(ns dcd-website.dcd2016
  (:require [dcd-website.header :as header]
            [dcd-website.footer :refer [footer-component]]))

(defn header-component-2016
  []
  (header/header-component {:title "Dutch Clojure Days 2016"}))

(defn main-component []
  [:article.main
   [:div#dcd16
    [:h2 "DCD16"]
    [:p "Videos from the previous event are available here: "
     [:a {:href "https://www.youtube.com/playlist?list=PLjzcwcP9P2LeiVXofnnXcxAqvmVNn3fTD"
          :target :_blank}
      "DCD16 Playlist on Youtube"] "."]]])

(def dcd2016-website-structure
  {:header-component  header-component-2016
   :main-component    main-component
   :footer-component  footer-component})
