(ns dcd-website.sidebar
  (:require [dcd-website.dcd2016 :as dcd2016]
            [dcd-website.dcd2017 :as dcd2017]
            [dcd-website.dcd2018 :as dcd2018]
            [dcd-website.dcd2019 :as dcd2019]
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

(defn archive []
  [:span.menu-title "Previous editions:"])

(defn menu-entry-component [{:keys [link text website-structure]
                             :or   {website-structure dcd2019/dcd2019-website-structure}}]
  [:a.item {:href                                                                 link :on-click #(do (collapse-sidebar)
                                                                                                      (swap-website-structure website-structure)) :key (gensym)} text])

(defn sidebar-component []
  [:aside.sidebar
   {:class (when-not @sidebar-expanded "collapsed")}
   [:a.item.expand-icon
    {:on-click #(swap! sidebar-expanded not)}
    "☰"]
   (map menu-entry-component [{:link "#about" :text "About"}
                              {:link "#cfp" :text "Call for papers"}
                              {:link "#date" :text "When?"}
                              {:link "#agenda" :text "Agenda"}
                              {:link "#sponsors" :text "Sponsors"}
                              {:link "#speakers" :text "Speakers"}
                              {:link "#behave" :text "Code of conduct"}
                              {:link "#location" :text "Where?"}
                              {:link              "#dcd2018"
                               :text              "Archive: DCD2018"
                               :website-structure dcd2018/dcd2018-website-structure}
                              {:link              "#dcd2017"
                               :text              "Archive: DCD2017"
                               :website-structure dcd2017/dcd2017-website-structure}
                              {:link              "#dcd2016"
                               :text              "Archive: DCD2016"
                               :website-structure dcd2016/dcd2016-website-structure}
                              ])])
