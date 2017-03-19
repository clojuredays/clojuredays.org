(ns dcd-website.carousel
  (:require [reagent.core :as reagent :refer [atom]]
            [clojure.string :as s]
            [dcd-website.app :as dcd]))

(def slot (atom {}))

(def minute-size 10)

(defn minutes-of-day [hh mm]
  (+ (* 60 hh) mm))

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

(defn current-slot [now]
  (let [hh (.getHours now)
        mm (.getMinutes now)
        current-time (minutes-of-day hh mm)
        slot-pairs (partition 2 1 dcd/agenda-data)]
    (first (first (filter (current? current-time) slot-pairs)))))

(defn render-time [start]
  [:h1 {:style {:position "absolute"
                :bottom 0
                :font-size "6em"}} start])

(defn org-slot->width
  [start end]
  (let [start-min (time-str->minutes start)
        end-min (time-str->minutes end)]
    (str (* minute-size (- end-min start-min)) "px")))

(defmulti render-slot :type)

(defmethod render-slot :org
  [{title :title [start end] :time}]
  (let [size (org-slot->width start end)]
    (.log js/console start "," end "==>" size)
    [:div.slot {:style {:min-height "100%"
                        :min-width size}}
     [:h1 title]
     [render-time start]]))

(defmethod render-slot :talk
  [{title :title [start end] :time pic :profile-pic author :author}]
  [:div.slot {:style {:min-width "550px"}}
   [:h1 title]
   [:h3 "By " author]
   [:img {:src (str "img/speakers/" pic)
          :style {:width "200px"
                  :height "200px"
                  :border-radius "200px"}}]
   [render-time start]])

(defmethod render-slot :default
  []
  [:h1 "Something went wrong!"])

(defn time-bar []
  [:div {:style {:position "fixed"
                 :background-color "red"
                 :min-width "10px"
                 :min-height "100%"
                 :left "250px"}}])

(defn render-all-slots
  [slots]
  [:div {:style {:overflow "hidden"
                 :display "flex"
                 :position "relative"
                 :min-height "100%"
                 :margin-left "50%"}}
   (map (fn [slot bg]
          [:span {:key (gensym)
                  :style {:display "block"
                          :position "relative"
                          :background-color bg
                          :float "left"
                          :min-height "100%"
                          :padding-right "50px"}}
           [render-slot slot]]) slots (cycle ["lightgray" "white"]))])

(defn update-slot [t]
  (reset! slot (current-slot t)))

(defn carousel-component
  []
  [:div.site {:style {:height "500px"
                      :padding "50px 0px"}}
   [render-all-slots dcd/agenda-data]
   [time-bar]
   [:div.wrapper {:style {}}
    [dcd/header-component {:style {:position "absolute"
                                   :bottom 0
                                   :width "100%"}}]]])

(defn init []
  (when js/document.location
    (reagent/render-component
     [carousel-component]
     (.getElementById js/document "container"))))
