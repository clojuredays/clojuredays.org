(ns dcd-website.dcd2016
  (:require [dcd-website.footer :refer [footer-component]]))

(defn main-component []
      [:article.main
       [:div#dcd16
        [:h2 "DCD16"]
        [:p "Videos from the previous event are available here: "
         [:a {:href   "https://www.youtube.com/playlist?list=PLjzcwcP9P2LeiVXofnnXcxAqvmVNn3fTD"
              :target :_blank}
          "DCD16 Playlist on Youtube"] "."]]])

(def dcd2016-website-structure
  {:title "Dutch Clojure Days 2016"
   :main-component   (main-component)})
