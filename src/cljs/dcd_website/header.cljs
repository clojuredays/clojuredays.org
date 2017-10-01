(ns dcd-website.header)

(defn header-component
  [{:keys [styles title]} & children]
  [:header.header styles
   [:div.logo
    [:img {:src "img/logo.svg"}]]
   [:div.title
    [:h1 title]]
   children])
