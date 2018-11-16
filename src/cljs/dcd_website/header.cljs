(ns dcd-website.header)

(defn header-component
  [{:keys [styles title]} & children]
  [:header.header styles
   [:div.logo
    [:img {:src "img/2019/dcd19-logo.png"}]]
   [:h1 [:div.title title]]
   children])
