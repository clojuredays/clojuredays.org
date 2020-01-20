(ns dcd-website.dcd2020
  (:require [dcd-website.location :refer [location-component]]
            [dcd-website.agenda :refer [speakers-component agenda-component]]
            [dcd-website.coc :refer [code-of-conduct-component]]))

(defn about-component []
  [:div#about
   [:h2 "About DCD 2020"]
   [:p "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands! We welcome you to the 5th edition of our " [:b "free "] " and non-profit Clojure conference organised by the community, for the community with a full day of amazing talks in a friendly welcoming atmosphere."]])

(defn cfp-component []
  [:div#cfp
   [:h2 "Call for Proposals"]
   [:p "Our CFP is open until March 15, 2020."]
   [:p "You can submit your proposal at " [:a {:href "https://www.papercall.io/dcd20"} "Papercall"] "."]
   [:p "We look forward to receive your groudbreaking, breathtaking, parenssurfing proposals on topics such as (but not limited to) real-world experiences and lessons learned from putting your clojure(script) applications to production, fancy new library tool that just landed on the clojure planet, etc. Be creative!"]])

(defn tickets-component []
  [:div#tickets
   [:h2 "Tickets"]
   [:p "The conference is currently sold out, but fear not! As a free event, it often happens that tickets become available later during to cancellations. "
    [:a {:href "https://twitter.com/clojuredays"}
     "Stay tuned"] " for updates!"]
   #_[:p "Dutch Clojure Days are always free conferences but you still need to register to be able to attend. Make sure to"
      [:a {:href "https://www.eventbrite.com/e/dutch-clojure-day-2020-tickets-85069363757"} " reserve your spot "] "today!"]
   #_[:div#eventbrite-widget-container-85069363757]])
;; [:button#eventbrite-widget-modal-trigger-85069363757 {:type "button"} "Reserve your spot"]


(defn sponsor-packages-component []
  [:div#packages
   [:h2 "Sponsorship Packages"]
   [:p "If you want to support us and Clojure community, consider sponsoring us. We offer two affordable sponsorship packages, check them out:"]
   [:a {:href "img/2020/partner.png" :target "none"}
    [:img {:src "img/2020/partner.png" :style "width: 100%; height: auto; max-width: 600px"}]]
   [:br]
   [:a {:href "img/2020/sponsor.png" :target "none"}
    [:img {:src "img/2020/sponsor.png" :style "width: 100%; height: auto; max-width: 600px"}]]
   [:p "If you want to support and engage with the Dutch Clojure Days community, please get in touch via email at " [:a {:href "mailto:events@clojuredays.org"} "events@clojuredays.org"] "."]])

(defn when-component []
  [:div#date
   [:h2 "When?"]
   [:p "Dutch Clojure Days will happen on "
    [:b " Saturday, May 16th, 2020"] "."]])

(defn where-component []
  [:div#location
   [:h2 "Where?"]
   (location-component)])

(defn sponsors-component []
  [:div#sponsors
   [:h2 "Sponsors"]
   [:div.sponsors
    [:p "DCD is a free event that is made possible thanks to our amazing sponsors and volunteers."]
    [:h3.package "Partner"]
    [:a.sponsor.platinum {:href "https://www.greenhousegroup.com/" :target :_blank}
     [:img {:src "img/2020/sponsors/ghg.png"}]]
    [:h3.package "Sponsor"]
    [:a.sponsor.regular {:href "http://www.adgoji.com/" :target :_blank}
     [:img {:src "img/2019/sponsors/adgoji.svg"}]]
    [:a.sponsor.regular {:href "https://cognitect.com" :target :_blank}
     [:img {:src "img/2019/sponsors/cognitect.svg"}]]
    [:a.sponsor.regular {:href "https://www.magnet.coop/" :target :_blank}
     [:img {:src "img/2020/sponsors/magnet.svg"}]]
    [:a.sponsor.regular {:href "https://twitter.com/iarenaza" :target :_blank}
     [:img {:src "img/2020/sponsors/ian2.svg"}]]]])

(defn main-component []
  [:article.main
   (about-component)
   (when-component)
   (where-component)
   (tickets-component)
   (cfp-component)
   (sponsors-component)
   (sponsor-packages-component)
   #_[:div#agenda
      [:h2 "Agenda"]
      [agenda-component agenda-data]]
   #_[:div#speakers
      [:h2 "Speakers"]
      [speakers-component agenda-data]]
   [:div#behave
    [:h2 "Code of Conduct"]
    (code-of-conduct-component)]])

(def dcd2020-website-structure
  {:title          "Dutch Clojure Days 2020"
   :main-component (main-component)})
