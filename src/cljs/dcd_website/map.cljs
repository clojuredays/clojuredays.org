(ns dcd-website.map
  (:require [reagent.core :as reagent]))

(defn add-marker! [mymap coords]
  (-> js/L
      (.marker coords)
      (.bindPopup "<a href='http://tq.co' target='_blank'>TQ - Singel 542</a>")
      (.addTo mymap)))

(defn init-tile-layer! [mymap]
  (-> js/L
      (.tileLayer "https://api.mapbox.com/styles/v1/gonzih/cixw9sqla002c2sn0a5uqu72s/tiles/256/{z}/{x}/{y}?access_token={accessToken}"
                  (clj->js {:attribution "&copy; <a href='http://openstreetmap.org' target='_blank'>OpenStreetMap</a>, <a href='http://creativecommons.org/licenses/by-sa/2.0/' target='_blank'>CC-BY-SA</a>, © <a href='http://mapbox.com' target='_blank'>Mapbox</a>"
                            :maxZoom 18
                            :accessToken "pk.eyJ1IjoiZ29uemloIiwiYSI6ImNpeHc1eDA0NjAwMmczMmw4MnR5b2p4eWsifQ.nrJj6lim59mVefvEwsiCgA"}))
      (.addTo mymap)))

(defn init-map! [coords]
  (let [mymap (-> js/L
                  (.map "location-map" (clj->js {::scrollWheelZoom false}))
                  (.setView coords 17))]
    (init-tile-layer! mymap)
    (add-marker! mymap coords)))

(defn location-component [{:keys [coords]}]
  (reagent/create-class {:reagent-render (fn []
                                           [:div.location
                                            [:p "Dutch Clojure Days 2017 will take place at "
                                             [:a {:href "http://tq.co" :target :_blank} "TQ"]
                                             " (Singel 542, 1017 AZ Amsterdam)."]
                                            [:div#location-map]])
                         :component-did-mount #(init-map! (clj->js coords))}))
