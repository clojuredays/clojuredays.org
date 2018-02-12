(ns dcd-website.header)

(defn header-component
  [{:keys [styles title]} & children]
  [:header.header styles
   [:div.title
    [:h1 title]]
   [:div.logo
    [:img {:src "img/2018/logo.svg"}]]
   children])
