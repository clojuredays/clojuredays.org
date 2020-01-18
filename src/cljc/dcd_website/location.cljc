(ns dcd-website.location)

(defn location-component []
  [:div.location
   [:p "Dutch Clojure Days will take place at the wonderful "
    [:a {:href "http://tq.co" :target :_blank} "TQ"]
    ", in the heart of Amsterdam "
    [:a {:href "https://goo.gl/maps/R8bcfmyeWM1v4v2G9"}
     "(Singel 542, 1017 AZ Amsterdam)"] "."]
   [:div#location-map]])
