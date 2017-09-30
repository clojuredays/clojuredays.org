(ns dcd-website.header)

(defn header-component
  ([]
   (header-component {}))
  ([styles & children]
   [:header.header styles
    [:div.logo
     [:img {:src "img/logo.svg"}]]
    [:div.title
     [:h1 "Dutch Clojure Days 2018"]]
    children]))
