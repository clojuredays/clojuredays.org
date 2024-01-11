(ns dcd-website.location)

(defn tq-location-component []
  [:div.location
   [:p "Dutch Clojure Days took place at the wonderful "
    [:a {:href "http://tq.co" :target :_blank} "TQ"]
    ", in the heart of Amsterdam "
    [:a {:href "https://goo.gl/maps/R8bcfmyeWM1v4v2G9"}
     "(Singel 542, 1017 AZ Amsterdam)"] "."]
   [:div#location-map {:location "tq"}]])

(defn cloud-pirates-location-component []
  [:div.location
   [:p "Dutch Clojure Days was hosted by the wonderful people at "
    [:a {:href "https://www.cloudpirates.nl/" :target :_blank} "Cloud Pirates"]
    ", in the heart of Amsterdam "
    [:a {:href "https://goo.gl/maps/zdcrQVyNjAQuuBXeA"}
     "(Piet Heinkade 217, 1019 HM Amsterdam)"] "."]
   [:div#location-map {:location "cloudpirates"}]])
