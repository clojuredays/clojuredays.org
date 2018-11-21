(ns dcd-website.header)

(defn header-component
  [{:keys [styles title]} & children]
  [:header.header styles
   [:img.logo {:src "/img/2019/logo.svg"}]
   children])
