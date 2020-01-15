(ns dcd-website.main
  (:require [dcd-website.sidebar :refer [sidebar-component]]
            [dcd-website.footer :refer [footer-component]]))

(defn content [header-component main-component]
  [:div.site
   [:div.wrapper-header header-component]
   [:div.wrapper (sidebar-component) main-component]
   (footer-component)])
