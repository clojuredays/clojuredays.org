(ns dcd-website.app
  (:require [reagent.core :as reagent]
            [dcd-website.dcd2020 :as dcd2020]
            [dcd-website.sidebar :refer [sidebar-component]]
            [dcd-website.map :refer [add-marker! init-tile-layer! init-map!]]
            [dcd-website.state :refer [website-structure]]))

(reset! website-structure dcd2020/dcd2020-website-structure)

(defn website-component []
  (let [{:keys [header-component
                main-component
                footer-component]} @website-structure]
    [:div.site
     [:div.wrapper-header
      [header-component]]
     [:div.wrapper
      [sidebar-component]
      [main-component]]
     [footer-component]]))

(defn init []
  (when js/document.location
    (let [root (.getElementById js/document "container")]
      (when root
        (reagent/render-component [website-component] root)))))

(defn ^:export render-to-string []
  (reagent/render-to-string [website-component]))
