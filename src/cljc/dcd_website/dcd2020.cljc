(ns dcd-website.dcd2020
  (:require [dcd-website.location :refer [tq-location-component]]
            [dcd-website.agenda :refer [speakers-component agenda-component]]
            [dcd-website.coc :refer [code-of-conduct-component]]))

(defn cancelled-component []
  [:div#about
   [:h2 "ClojureDays 2020 has been cancelled"]
   [:p "Thank your for your enthousiastic reaction to this year's edition of
Dutch Clojure Days. We receieved a fantastic response in both our CFP
and ticket sale and would have loved to organize yet another great
programme."]
   [:p "Unfortunately the Corona crisis makes it impossible this year to
organise the planned event safely. That's why we've decided to cancel
this year's ClojureDays conference."]
   [:p "We are considering options for organising another kind of event at a
later time. Stay tuned for news and make sure to follow us on twitter."]
   [:p "On behalf of the Dutch Clojure Days team" [:br] "Carlo Sciolla"]])

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
   [:p "In the meanwhile you can always"
    [:a {:href "https://www.eventbrite.com/e/dutch-clojure-day-2020-tickets-85069363757"} " join the waiting list"] " so you can get in as soon as a spot frees up."]
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
   (tq-location-component)])

(defn sponsors-component []
  [:div#sponsors
   [:h2 "Sponsors"]
   [:div.sponsors
    [:p "DCD is a free event that is made possible thanks to our amazing sponsors and volunteers."]
    [:h3.package "Partner"]
    [:a.sponsor.platinum {:href "https://www.greenhousegroup.com/" :target :_blank}
     [:img {:src "img/2020/sponsors/ghg.png" :alt "Greenhouse Group"}]]
    [:h3.package "Sponsor"]
    [:a.sponsor.regular {:href "http://www.adgoji.com/" :target :_blank}
     [:img {:src "img/2019/sponsors/adgoji.svg" :alt "adgoji"}]]
    [:a.sponsor.regular {:href "https://cognitect.com" :target :_blank}
     [:img {:src "img/2019/sponsors/cognitect.svg" :alt "Cognitect"}]]
    [:a.sponsor.regular {:href "https://www.magnet.coop/" :target :_blank}
     [:img {:src "img/2020/sponsors/magnet.svg" :alt "Magnet"}]]
    [:a.sponsor.regular {:href "https://twitter.com/iarenaza" :target :_blank}
     [:img {:src "img/2020/sponsors/ian.svg" :alt "Iñaki Arenaza"}]]
    [:a.sponsor.regular {:href "https://www.brightin.nl/" :target :_blank}
     [:img {:src "img/2018/sponsors/brightin.png" :alt "Brightin"}]]
    [:a.sponsor.regular {:href "https://vakantiediscounter.nl" :target :_blank}
     [:img {:src "img/2019/sponsors/devakantiediscounter.svg" :alt "VakantieDiscounter"}]]
    [:a.sponsor.regular {:href "https://flexiana.com/" :target :_blank}
     [:img {:src "img/2019/sponsors/flexiana.jpg" :alt "Flexiana"}]]
    [:a.sponsor.regular {:href "https://infi.nl/" :target :_blank}
     [:img {:src "img/2019/sponsors/infi.svg" :alt "Infi"}]]
    [:a.sponsor.regular {:href "https://lunatech.com/" :target :_blank}
     [:img {:src "img/2019/sponsors/lunatech.svg" :alt "Lunatech"}]]]])

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

(defn cancelled []
  [:article.main
   (cancelled-component)])

(def dcd2020-website-structure
  {:title          "Dutch Clojure Days 2020"
   :main-component (cancelled)})
