(ns dcd-website.dcd2018
  (:require [dcd-website.map :refer    [location-component]]
            [dcd-website.header :refer [header-component]]
            [dcd-website.style :refer   [colors]]
            [dcd-website.footer :refer [footer-component]]
            [dcd-website.agenda :refer  [speakers-component agenda-component]]
            [dcd-website.coc :refer [code-of-conduct-component]]
            [dcd-website.credits :refer [credits]]))

(defn header-component-2018
  []
  (header-component {:title "Dutch Clojure Days 2018"}))

(defn about-component []
  [:div#about
   [:h2 "About DCD18"]
   [:p "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands!"]] )

(defn cfp-component []
  [:div#cfp
   [:h2 "Call for proposals"]
   [:p "Our CFP is open! Submit your talk today using " [:a {:href "https://www.papercall.io/dcd18"} "this form"]]])

(defn sponsors-component []
  [:div.sponsors
   [:p "DCD is a free event that is made possible thanks to our amazing sponsors and volunteers."]
   [:h2.platinum "Platinum sponsors"]
   [:a.sponsor.platinum {:href "http://www.adgoji.com/" :target :_blank}
    [:img {:src "img/2018/sponsors/adgoji.svg"}]]
   [:a.sponsor.platinum {:href "http://www.metosin.fi/en" :target :_blank}
    [:img {:src "img/2018/sponsors/metosin.svg"}]]
   [:a.sponsor.platinum {:href "https://www.exoscale.ch/" :target :_blank}
    [:img {:src "img/2018/sponsors/exoscale.svg"}]]
   [:a.sponsor.platinum {:href "https://synple.eu/en/index" :target :_blank}
    [:img {:src "img/2018/sponsors/synple.png"}]]

   [:h2.regular "Regular Sponsors"]
   [:a.sponsor {:href "https://infi.nl/" :target :_blank}
    [:img {:src "img/2018/sponsors/infi.svg"}]]
   [:a.sponsor {:href "https://www.brightin.nl/" :target :_blank}
    [:img {:src "img/2018/sponsors/brightin.png"}]]
   [:a.sponsor {:href "https://www.alliander.com/en" :target :_blank}
    [:img {:src "img/2018/sponsors/alliander.png"}]]])

(defn tickets-component []
  [:div#date
   [:h2 "Reserve your Spot"]
   [:p "DCD 2018 will be in Amsterdam on "
    [:b "Saturday April 21st, 2018"] "! Get your ticket now!"]
   [:div
    [:a {:href "https://www.eventbrite.com/e/dutch-clojure-day-2018-tickets-41749338395?ref=ebtnebregn" :target "_blank"}
     [:img {:src "https://www.eventbrite.com/custombutton?eid=41749338395" :alt "Eventbrite - Dutch Clojure Day 2018"}]]]])

(def agenda-data
  [{:time ["8:30" "9:15"]
    :title "Reception"
    :type :org}

   {:time ["9:15" "9:30"]
    :title "Opening"
    :author "#DCD18 team"
    :type :org}

   {:time ["9:30" "10:15"]
    :title ""
    :author ""
    :profile-pic ""
    :description ""
    :bio ""
    :twitter ""
    :add-padding true
    :type :talk
    :youtube-link ""}

   {:time ["10:25" "11:10"]
    :title ""
    :profile-pic ""
    :author ""
    :description ""
    :bio ""
    :twitter ""
    :add-padding true
    :type :talk
    :youtube-link ""}

   {:time ["11:20" "12:05"]
    :title ""
    :profile-pic ""
    :author ""
    :description ""
    :bio ""
    :twitter ""
    :type :talk
    :youtube-link ""}

   {:time ["12:05" "13:20"]
    :title "Lunch"
    :type :org
    :force-timeline-visible? true}

   {:time ["13:20" "14:05"]
    :title ""
    :profile-pic ""
    :author ""
    :description ""
    :bio ""
    :twitter ""
    :add-padding true
    :type :talk
    :youtube-link ""}

   {:title "Lightning Talks"
    :force-timeline-hidden? true
    :type :lightning}

   {:time ["14:15" "14:30"]
    :title ""
    :profile-pic ""
    :description ""
    :author ""
    :bio ""
    :twitter ""
    :type :lightning
    :youtube-link ""}

   {:time ["14:30" "14:45"]
    :title ""
    :profile-pic ""
    :author ""
    :description ""
    :bio ""
    :twitter ""
    :type :lightning
    :youtube-link ""}

   {:time ["14:45" "15:00"]
    :title ""
    :profile-pic ""
    :author ""
    :description ""
    :bio ""
    :twitter ""
    :type :lightning
    :youtube-link ""}

   {:time ["15:00" "15:15"]
    :title ""
    :profile-pic ""
    :author ""
    :description ""
    :bio ""
    :twitter ""
    :type :lightning
    :youtube-link ""}

   {:time ["15:15" "15:45"]
    :title "Coffee break"
    :type :org
    :add-padding true
    :force-timeline-visible? true}

   {:time ["15:45" "16:30"]
    :title ""
    :profile-pic ""
    :author ""
    :description ""
    :bio ""
    :twitter ""
    :add-padding true
    :type :talk
    :youtube-link ""}

   {:time ["16:40" "17:25"]
    :title ""
    :profile-pic ""
    :author ""
    :description ""
    :bio ""
    :twitter ""
    :add-padding true
    :type :talk
    :youtube-link ""}

   {:time ["17:35" "18:20"]
    :title ""
    :profile-pic ""
    :author ""
    :description ""
    :bio ""
    :twitter ""
    :type :talk
    :youtube-link ""}

   {:time ["18:20" "18:30"]
    :title "Closing"
    :author "#DCD17 team"
    :type :org}

   {:time ["18:30" "21:30"]
    :title "Networking/Drinks"
    :type :org}])

(defn main-component []
  [:article.main
   [about-component]
   [cfp-component]
   [tickets-component]
   [:div#location
    [:h2 "Where?"]
    [location-component {:coords [52.3666451 4.892396599999984]}]]
   [:div#sponsors
    [:h2 "Sponsors"]
    [sponsors-component]]
   [:div#agenda
    [:h2 "Agenda"]
    [agenda-component agenda-data]]
   [:div#speakers
    [:h2 "Speakers"]
    [speakers-component agenda-data]]
   [:div#behave
    [:h2 "Code of Conduct"]
    [code-of-conduct-component]]
   [:div#org
    [:h2 "Contacts"]
    [:h3 "Official contacts"]
    [:span.email-info
     [:a {:href "mailto:events@clojuredays.org"}
      [:img.icon.email {:src "img/icons/email.svg"}]
      "events@clojuredays.org"]]
    [:span.org-info
     [:a {:href "https://twitter.com/clojuredays"}
      [:img.icon.twitter {:src "img/icons/twitter.svg"}]
      "@clojuredays"]]
    [:h3 "DCD team"]
    [credits]]])

(def dcd2018-website-structure
  {:main-component main-component
   :header-component header-component-2018
   :footer-component footer-component})
