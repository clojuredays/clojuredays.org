(ns dcd-website.dcd2018
  (:require [dcd-website.map :refer    [location-component]]
            [dcd-website.header :refer [header-component]]
            [dcd-website.footer :refer [footer-component]]
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
   [:a.sponsor {:href "http://www.adgoji.com/" :target :_blank}
    [:img {:src "img/2018/sponsors/adgoji.svg"}]]
   [:a.sponsor {:href "http://www.metosin.fi/en" :target :_blank}
    [:img {:src "img/2018/sponsors/metosin.svg"}]]
   [:a.sponsor {:href "https://synple.eu/en/index" :target :_blank}
    [:img {:src "img/2018/sponsors/synple.svg"}]]
   [:h2.regular "Regular Sponsors"]
   [:a.sponsor.infi {:href "https://infi.nl/" :target :_blank}
    [:img {:src "img/2018/sponsors/infi.svg"}]]
   ])

(defn tickets-component []
  [:div#date
   [:h2 "Reserve your Spot"]
   [:p "DCD 2018 will be in Amsterdam on"
    [:b "Saturday April 21st, 2018"] "! Get your ticket now!"]
   [:div
    [:a {:href "https://www.eventbrite.com/e/dutch-clojure-day-2018-tickets-41749338395?ref=ebtnebregn" :target "_blank"}
     [:img {:src "https://www.eventbrite.com/custombutton?eid=41749338395" :alt "Eventbrite - Dutch Clojure Day 2018"}]]]])

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
    [sponsors-component]
    [:p "Dutch Clojure Day is a free event organised by community. And we can never make it happen without our sponsors. This year we have two sponsorship packages available for DCD 18. Check them out."]
    [:img {:src "img/2018/sponsor-packages.jpg"}]
    [:p "If you are interested in sponsoring this event please contact us via "
     [:a {:href "mailto:events@clojuredays.org"}
      [:img.icon.email {:src "img/icons/email.svg"}]
      "email."]]]
   [:div#agenda
    [:h2 "Agenda"]
    [:p "TBD"]]
   [:div#speakers
    [:h2 "Speakers"]
    [:p "TBD"]]
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
