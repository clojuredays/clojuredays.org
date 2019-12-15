(ns dcd-website.header)

(defn header-component
  [title]
  [:header.header
   [:div.logo [:img {:src "img/2019/logo.svg"}]]
   [:span.title title]])
