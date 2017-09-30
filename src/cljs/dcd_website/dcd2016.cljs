(ns dcd-website.dcd2016
  (:require [dcd-website.header :as header]
            [dcd-website.footer :refer [footer-component]]))

(defn main-component []
  [:article.main
   [:div#dcd16
    [:h2 "DCD16"]
    [:p "Videos from the previous event are available here: "
     [:a {:href "https://www.youtube.com/playlist?list=PLjzcwcP9P2LeiVXofnnXcxAqvmVNn3fTD"
          :target :_blank}
      [:img.icon.youtube {:src "img/icons/youtube.svg"}]
      "DCD16 Playlist on Youtube"] "."]]])

(def dcd2016-website-structure
  {:header-component  header/header-component
   :main-component    main-component
   :footer-component  footer-component})
