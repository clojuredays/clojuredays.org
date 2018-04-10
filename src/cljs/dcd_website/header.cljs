(ns dcd-website.header)

(defn header-component
  [{:keys [styles title]} & children]
  [:header.header styles
   [:div.logo
    [:img {:src "img/2018/logo.png"}]]
   children])
