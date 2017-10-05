(ns dcd-website.carousel
  (:require [reagent.core :as reagent :refer [atom]]
            [clojure.string :as s]
            [dcd-website.app :as dcd]
            [dcd-website.header :as header]
            [dcd-website.dcd2017 :as dcd2017]))

(def minute-size 15)

;; (enable-console-print!)

(def clean-agenda
  (as-> dcd2017/agenda-data $
    (filter (fn [{:keys [type force-timeline-visible? force-timeline-hidden?]}]
              (and (or force-timeline-visible? (#{:lightning :talk} type))
                   (not force-timeline-hidden?)))
            $)
    (concat [{:time ["8:30" "9:30"]
              :type :org
              :title "Reception/Opening"}]
            $
            [{:time ["18:20" "20:00"]
              :type :org
              :timeline-description
              [:div.timeline-description
               [:h2 "Thank you!"]
               [:h3 "See you next year for #DCD18!"]]
              :title "Closing/Networking/Drinks"}])))

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
  (max 0
       (- (date->minutes date) agenda-start)))

(defn time-str->minutes [s]
  (let [[hh mm] (mapv int (s/split s #":"))]
    (minutes-of-day hh mm)))

(defn current-progress [now]
  {:progress (agenda-progress now)})

(defonce progress (atom (current-progress (js/Date.))))

(def light-blue "rgba(160,200,220,.8)")

(def lightning-starts?
  (set (map (comp first :time) (filter (comp #{:lightning} :type) clean-agenda))))

(defn render-time [start fg]
  [:h1.time
   {:style {:color fg}}
   start])

(defn org-slot->width
  [start end add-padding]
  (let [start-min (time-str->minutes start)
        end-min (time-str->minutes end)
        padding (if add-padding (* 10 minute-size) 0)]
    (str (+ padding (* minute-size (- end-min start-min))) "px")))

(defn talk-slot->width
  ([start end add-padding]
   (let [start-min (time-str->minutes start)
         end-min (time-str->minutes end)
         padding (if add-padding (* 10 minute-size) 0)]
     (str (+ padding (* minute-size (- end-min start-min))) "px"))))

(defmulti render-slot (fn [{:keys [type]} _ _] type))

(defmethod render-slot :org
  [{title :title [start end] :time author :author description :timeline-description add-padding :add-paggind :as slot} bg fg]
  (let [size (org-slot->width start end add-padding)]
    [:div.slot {:style {:min-height "100%"
                        :min-width size
                        :background-color bg}}
     [:h1.title title]
     (when description description)
     [render-time start fg]]))

(defn render-talk-slot
  [{title :title [start end] :time pic :profile-pic author :author add-padding :add-padding :as slot} bg fg]
  [:div.slot {:style {:min-width (talk-slot->width start end add-padding)
                      :background-color bg}}
   [:h1.title title]
   [:div.author
    [:img.speaker {:src (str "img/speakers/" pic) }]
    [:h3.name "By " author]]
   [render-time start fg]])

(defmethod render-slot :talk
  [slot bg fg]
  (render-talk-slot slot bg fg))

(defmethod render-slot :lightning
  [slot bg fg]
  (render-talk-slot slot bg fg))

(defmethod render-slot :default [_ _ _]
  [:h1 "Something went wrong!"])

(defn time-bar []
  [:div {:style {:position "fixed"
                 :background-color "rgba(255, 0, 0, .5)"
                 :min-width "10px"
                 :min-height "100%"
                 :left "650px"
                 :top "-100px"}}])

(defn progress->margin []
  (if (> 0 (:progress @progress))
    "650px"
    (str (- 650 (* minute-size (:progress @progress)))
         "px")))

(defn render-all-slots [slots]
  (let [colors (cycle [light-blue "white"])]
    [:div {:style {:overflow "hidden"
                   :display "flex"
                   :position "relative"
                   :min-height "100%"
                   :transition "margin-left 200ms ease-in-out"
                   :margin-left (progress->margin)}}
     (doall (map
             (fn [slot bg fg]
               ^{:key slot} [render-slot slot bg fg])
             slots
             colors
             (drop 1 colors)))]))

(defn carousel-component []
  [:div.site {:style {:height "71vh"}}
   [render-all-slots clean-agenda]
   [time-bar]
   [:div.wrapper
    [header/header-component {:style {:position "absolute"
                                   :bottom 0
                                   :height "350px"
                                   :width "100%"}}]
    [:img.all-sponsors {:src "img/all-sponsors.svg"}]]])

(def test-progress (atom 8))

(defn update-progress-test! []
  (reset! progress (current-progress (doto (js/Date.)
                                       (.setHours @test-progress)
                                       (.setMinutes 20))))
  (swap! test-progress inc)
  true)

(defn update-progress! []
  (let [d (js/Date.)]
    (if (< (.getHours d) 19)
      (do
        (reset! progress (current-progress d))
        true)
      (do
        (reset! progress (current-progress (doto d
                                             (.setHours 19)
                                             (.setMinutes 20))))
        false))))

(defn set-time-test [hh mm]
  (reset! progress (current-progress (doto (js/Date.)
                                       (.setHours hh)
                                       (.setMinutes mm)))))

(defn schedule [f t]
  (.setTimeout js/window
               (fn [] (when (f) (schedule f t)))
               t))

(defn init []
  (dcd/init)
  (when js/document.location
    (let [root (.getElementById js/document "carousel-container")]
      (when root
        (reagent/render-component [carousel-component] root)
        (schedule update-progress! 1000)
                                        ; (schedule update-progress-test! 1000)
                                        ; (enable-print!)
                                        ; (dotimes [_ 11] (update-progress-test!))
                                        ; (prn @progress)
                                        ; (prn (map :time clean-agenda))
        ))))
