(ns dcd-website.carousel
  (:require [reagent.core :as reagent :refer [atom]]))

(defn carousel-component
  []
  [:h1 "hello world"])

(defn init []
  (when js/document.location
    (reagent/render-component
     [carousel-component]
     (.getElementById js/document "container"))))
