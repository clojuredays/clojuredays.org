(ns dcd-website.dcd2026
  (:require [dcd-website.location :refer [wesopa-location-component]]
            [dcd-website.agenda :refer [speakers-component agenda-component]]
            [dcd-website.coc :refer [code-of-conduct-component]]))

(defn about-component []
  [:div#about
   [:h2 "About DCD 2026"]
   [:p "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands! We welcome you to the 6th edition of our " [:b "free "] " and non-profit Clojure conference organised by the community, for the community with a full day of amazing talks in a friendly welcoming atmosphere."]])

(defn cfp-component []
  [:div#cfp
   [:h2 "Call for Proposals"]
   [:p "Our CFP will be open from "
    [:b "November 1st, 2025 "]
    [:span "until "]
    [:b "January 15th, 2026."]]
   [:p "Are you involved in in the Clojure ecosystem? Are you proud of a
project you're working on?"]
   [:p "Come and present at the Dutch Clojure Days 2026 Conference! Your
solution can be absurd, incredibly practical or make the world a
better place. Show your warm Clojure-knitted sweaters, exciting live
music setup, break-through open source tools, community work or
perfectly executed business solution. If you're passionate about it,
we want to hear about it!"]
   [:p "Your presentation can be a short, 7 minute lightning talk, or a full 35 minute presentation."]
   [:p "From November 1rst, 2025 you can submit your proposal at " [:a {:href "https://sessionize.com/dutch-clojure-days-2026"} "Sessionize"] "."]])

(defn tickets-component []
  [:div#tickets
   [:h2 "Tickets"]
   [:p "Registrations are open and free of charge. Go ahead and "
    [:a {:href "https://www.eventbrite.com/e/tickets-dutch-clojure-days-2026-1396444435899"} " get your ticket now!"]]
   [:div#eventbrite-widget-container-eventbrite-widget-container-1396444435899]])

(defn sponsor-packages-component []
  [:div#packages
   [:h2 "Sponsorship Packages"]
   [:p "Want to join us in spreading the Clojure love? We'd be thrilled to have you as a sponsor! We've got three awesome sponsorship packages designed to fit every budget:"]
   [:a {:href "img/2026/partner.svg" :target "none"}
    [:img {:src "img/2026/partner.svg" :style "width: 100%; height: auto; max-width: 600px"}]]
   [:br]
   [:a {:href "img/2026/sponsor.svg" :target "none"}
    [:img {:src "img/2026/sponsor.svg" :style "width: 100%; height: auto; max-width: 600px"}]]
   [:br]
   [:a {:href "img/2026/supporter.svg" :target "none"}
    [:img {:src "img/2026/supporter.svg" :style "width: 100%; height: auto; max-width: 600px"}]]
   [:p "If you want to support and engage with the Dutch Clojure Days community, please get in touch via email at " [:a {:href "mailto:events@clojuredays.org"} "events@clojuredays.org"] "."]])

(defn when-component []
  [:div#date
   [:h2 "When?"]
   [:p "Dutch Clojure Days is scheduled to happen on "
    [:b " Saturday, May 9th, 2026"] "."]])

(defn where-component []
  [:div#location
   [:h2 "Where?"]
   (wesopa-location-component)])

(defn sponsors-component []
  [:div#sponsors
   [:h2 "Sponsors"]
   [:div.sponsors
    [:p "DCD is a free event that is made possible thanks to our amazing sponsors and volunteers."]
    [:h3.package "Partner"]
    [:a.sponsor.platinum {:href "https://exoscale.com/" :target :_blank}
     [:img {:src "img/2026/sponsors/exoscale.svg" :alt "Exoscale"}]]
    [:h3.package "Supporter"]
    [:a.sponsor.supporter {:href "https://nextjournal.com/" :target :_blank}
     [:img {:src "img/2026/sponsors/nextjournal.svg" :alt "Nextjournal"}]]]])

(def agenda-data
  [{:time ["8:30" "9:15"]
    :title "Reception"
    :type :org}

   {:time ["9:15" "9:30"]
    :title "Opening"
    :author "#DCD26 team"
    :type :org}

   {:time ["9:30" "10:15"]
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["10:25" "11:10"]
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["11:20" "12:00"]
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["12:00" "14:00"]
    :title "Lunch"
    :type :org
    :force-timeline-visible? true}

   {:title "Lightning Talks"
    :force-timeline-hidden? true
    :type :lightning}

   {:time ["14:00" "14:10"]
    :type :lightning
    :youtube-link nil}

   {:time ["14:10" "14:20"]
    :type :lightning
    :youtube-link nil}

   {:time ["14:20" "14:30"]
    :type :lightning
    :youtube-link nil}

   {:time ["14:40" "15:00"]
    :title "Coffee break"
    :type :org
    :add-padding true
    :force-timeline-visible? true}

   {:time ["15:00" "15:45"]
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["15:45" "16:30"]
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["16:30" "16:40"]
    :title "Closing"
    :author "#DCD26 team"
    :type :org}

   {:time ["17:00" "🥳"]
    :title "Networking/Drinks"
    :type :org}])

(defn main-component []
  [:article.main
   (about-component)
   (when-component)
   (where-component)
   (tickets-component)
   (cfp-component)
   (sponsors-component)
   (sponsor-packages-component)
   [:div#agenda
    [:h2 "Agenda"]
    [:p "The agenda below is just an indication as " [:a {:href "https://sessionize.com/dutch-clojure-days-2026/"} "our CfP is still ongoing!"]]
    (agenda-component agenda-data)]
   #_[:div#speakers
      [:h2 "Speakers"]
      (speakers-component agenda-data)]
   [:div#behave
    [:h2 "Code of Conduct"]
    (code-of-conduct-component)]])

(def dcd2026-website-structure
  {:title          "Dutch Clojure Days 2026"
   :main-component (main-component)})
