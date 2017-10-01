(ns dcd-website.app
  (:require [reagent.core :as reagent :refer [atom]]
            [dcd-website.dcd2018 :as dcd2018]
            [dcd-website.sidebar :refer [sidebar-component]]
            [dcd-website.map :refer [add-marker! init-tile-layer! init-map!]]
            [dcd-website.style :refer [colors]]
            [dcd-website.state :refer [website-structure]]))

(declare agenda-component speakers-component)

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

(defn website-component []
  (let [{:keys [header-component
                main-component
                footer-component]} @website-structure]
    [:div.site
     [:div.wrapper
      [header-component]
      [sidebar-component]
      [main-component]]
     [footer-component]]))

(defn init []
  (when js/document.location
    (reset! website-structure dcd2018/dcd2018-website-structure)
    (let [root (.getElementById js/document "container")]
      (when root
        (reagent/render-component [website-component] root)))))

(defn ^:export render-to-string []
  (reagent/render-to-string [website-component]))
