(ns dcd-website.header)

(defn header-component
  [{:keys [styles title]} & children]
  [:header.header styles
   [:div.logo [:img {:src "/img/2019/logo.svg"}]]
   [:span.title "DUTCH CLOJURE DAYS 2020"]
   children])
