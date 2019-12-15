(ns dcd-website.location)

(defn location-component []
      [:div.location
       [:p "Dutch Clojure Days will take place at the "
        [:a {:href "http://tq.co" :target :_blank} "TQ"]
        " (Singel 542, 1017 AZ Amsterdam)."]
       [:div#location-map]])
