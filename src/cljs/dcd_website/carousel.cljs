(ns dcd-website.carousel
  (:require [reagent.core :as reagent :refer [atom]]
            [clojure.string :as s]
            [dcd-website.app :as dcd]))

(def minute-size 10)

(def clean-agenda
  (let [rm-pos (fn [v pos] (vec (concat (subvec v 0 pos) (subvec v (inc pos)))))
        bogus-slots [7 17]]
    (reduce rm-pos dcd/agenda-data bogus-slots)))

(defn minutes-of-day [hh mm]
  (+ (* 60 hh) mm))

(defn date->minutes [d]
  (minutes-of-day (.getHours d) (.getMinutes d)))

(def agenda-start
  (let [start (doto (js/Date.)
                (.setHours 8)
                (.setMinutes 30))]
    (date->minutes start)))

(defn agenda-progress
  "Calculates the number of minutes since 8:30"
  [date]
  (- (date->minutes date) agenda-start))

(defn time-str->minutes [s]
  (let [[hh mm] (mapv int (s/split s #":"))]
    (minutes-of-day hh mm)))

(defn between? [time start end]
  (and (>= time start)
       (< time end)))

(defn time-slot [{[start end] :time}]
  (mapv time-str->minutes [start end]))

(defn current? [t]
  (fn [[first second]]
    (let [[second-start second-end] (time-slot second)]
      (< t second-start))))

(defn slot-index [slot]
  (.indexOf (to-array clean-agenda) slot))

(defn current-slot [now]
  (let [hh (.getHours now)
        mm (.getMinutes now)
        current-time (minutes-of-day hh mm)
        slot-pairs (partition 2 1 clean-agenda)]
    (first (first (filter (current? current-time) slot-pairs)))))

(defn next-slot [slot]
  (get clean-agenda (inc (slot-index slot))))

(defn before-org? [slot]
  (= :org (:type (next-slot slot))))

(defn current-progress [now]
  {:progress (agenda-progress now)
   :current  (current-slot now)
   :slot     (slot-index (current-slot now))})

(def progress (atom (current-progress (js/Date.))))

(def light-blue "rgba(160,200,220,.8)")

(def lightning-starts?
  (set (map (comp first :time) (filter (comp #{:lightning} :type) clean-agenda))))

(defn render-time [start idx]
  [:h1 {:style {:position "absolute"
                :bottom -30
                :color (if (even? idx) "white" light-blue)
                :font-size "4em"}} start])

(defn org-slot->width
  [start end]
  (let [start-min (time-str->minutes start)
        end-min (time-str->minutes end)]
    (str (* minute-size (- end-min start-min)) "px")))

(defn talk-slot->width
  ([start end correction?]
   (let [start-min (time-str->minutes start)
         end-min (time-str->minutes end)
         correction (if correction? 10 0)]
     (str (* minute-size (+ correction (- end-min start-min))) "px")))
  ([start end]
   (talk-slot->width start end true)))

(defmulti render-slot :type)

(defmethod render-slot :org
  [{title :title [start end] :time :as slot}]
  (let [size (org-slot->width start end)]
    [:div.slot {:style {:min-height "100%"
                        :min-width size}}
     [:h1 title]
     [:div {:style {:text-align "center"}}
      [:img {:src "img/logo.svg"
             :style {:width "200px"}}]]
     [render-time start (slot-index slot)]]))

(defmethod render-slot :talk
  [{title :title [start end] :time pic :profile-pic author :author :as slot}]
  [:div.slot {:style {:min-width (if (before-org? slot)
                                   (talk-slot->width start end false)
                                   (talk-slot->width start end))}}
   [:h1 {:style {:line-height "1.5em"}} title]
   [:div {:style {:text-align "center"}}
    [:img {:src (str "img/speakers/" pic)
           :style {:width "200px"
                   :height "200px"
                   :border (str "2px solid " light-blue)
                   :border-radius "200px"}}]
    [:h3 "By " author]]
   [render-time start (slot-index slot)]])

(defmethod render-slot :lightning
  [{title :title [start end] :time pic :profile-pic author :author :as slot}]
  [:div.slot {:style {:min-width (talk-slot->width start end false)}}
   [:div {:style {:text-align "center"
                  :margin-right "-50px"}}
    [:h2 {:style {:line-height "1.5em"}} title]
    [:h3 "By " author]
    [:img {:src (str "img/speakers/" pic)
           :style {:width "200px"
                   :height "200px"
                   :border-radius "200px"}}]]
   [render-time start (slot-index slot)]])

(defmethod render-slot :default
  []
  [:h1 "Something went wrong!"])

(defn time-bar []
  [:div {:style {:position "fixed"
                 :background-color "rgba(255, 0, 0, .5)"
                 :min-width "10px"
                 :min-height "100%"
                 :left "650px"
                 :top "-100px"}}])

(defn adjust-progress-for-margin
  "Every slot has a 50px margin, need to adjust the time scale accordingly"
  [{progress :progress {[slot-start slot-end] :time} :current slot :slot}]
  (let [slot-start (time-str->minutes slot-start)
        slot-end   (time-str->minutes slot-end)
        length (- slot-end slot-start)
        slot-progress (- (+ agenda-start progress) slot-start)]
    (+ (* 50 slot)
       (/ (* 50 slot-progress) length))))

(defn progress->margin []
  (if (> 0 (:progress @progress))
    "650px"
    (let [correction (adjust-progress-for-margin @progress)]
      (str (max (- (- 650 (* minute-size (:progress @progress))) correction)
                (- (- 650 (* minute-size 780)) correction)) "px"))))

(defn render-all-slots
  [slots]
  [:div {:style {:overflow "hidden"
                 :display "flex"
                 :position "relative"
                 :min-height "100%"
                 :margin-left (progress->margin)}}
   (map (fn [slot bg]
          [:span {:key (gensym)
                  :style {:display "block"
                          :position "relative"
                          :background-color bg
                          :float "left"
                          :min-height "100%"
                          :padding-right "50px"}}
           [render-slot slot]]) slots (cycle [light-blue "white"]))])

(defn carousel-component
  []
  [:div.site {:style {:height "70vh"}}
   [render-all-slots clean-agenda]
   [time-bar]
   [:div.wrapper {:style {}}
    [dcd/header-component {:style {:position "absolute"
                                   :bottom 0
                                   :height "30vh"
                                   :width "100%"}}]]])

(defn update-progress []
  (let [time (js/Date.)]
    (reset! progress (current-progress time))))

(defn init []
  (when js/document.location
    (reagent/render-component
     [carousel-component]
     (.getElementById js/document "container"))
    #_(.setInterval js/window update-progress 1000)))
