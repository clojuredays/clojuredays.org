(ns dcd-website.sidebar
  (:require [dcd-website.dcd2016 :as dcd2016]
            [dcd-website.dcd2017 :as dcd2017]
            [dcd-website.dcd2018 :as dcd2018]
            [dcd-website.state :as state]
            [reagent.core :as reagent]))

(defonce sidebar-expanded (reagent/atom false))

(defn collapse-sidebar []
  (reset! sidebar-expanded false)
  true)

(defn expand-sidebar []
  (reset! sidebar-expanded true)
  true)

(defn swap-website-structure [new-structure]
  (reset! state/website-structure new-structure))

(defn follow-menu-link [webcontent]
  (fn [_]
    (collapse-sidebar)
    (swap-website-structure webcontent)))

(defn menu-entry-component [{:keys [link text]}]
  [:a.item {:href link :on-click (follow-menu-link dcd2018/dcd2018-website-structure) :key (gensym)} text])

(defn archive []
  [:span.menu-title "Previous editions:"])

(defn archive-entry-component [{:keys [link text website-structure]}]
  [:a.item {:href link :on-click #(do (collapse-sidebar)
                                      (swap-website-structure website-structure)) :key (gensym)} text])

(defn sidebar-component []
  [:aside.sidebar
   {:class (when-not @sidebar-expanded "collapsed")}
   [:a.item.expand-icon
    {:on-click #(swap! sidebar-expanded not)}
    "☰"]
   (map menu-entry-component [#_{:link "#about"    :text "About"}
                              #_{:link "#cfp"      :text "Call for papers"}
                              {:link "#date"     :text "When?"}
                              {:link "#agenda"   :text "Agenda"}
                              {:link "#sponsors" :text "Sponsors"}
                              {:link "#speakers" :text "Speakers"}
                              {:link "#behave"   :text "Code of conduct"}
                              {:link "#org"      :text "Contacts"}
                              {:link "#location" :text "Where?"}])
   [archive]
   (map archive-entry-component [{:link "#dcd2017"
                                  :text "DCD2017"
                                  :website-structure dcd2017/dcd2017-website-structure}
                                 {:link "#dcd2016"
                                  :text "DCD2016"
                                  :website-structure dcd2016/dcd2016-website-structure}])])
