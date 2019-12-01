(ns dcd-website.dcd2020
  (:require [dcd-website.map :refer    [location-component]]
            [dcd-website.header :refer [header-component]]
            [dcd-website.footer :refer [footer-component]]
            [dcd-website.agenda :refer [speakers-component agenda-component]]
            [dcd-website.coc :refer [code-of-conduct-component]]))

(defn header-component-2020
  []
  (header-component {:title "Dutch Clojure Days"}))

(defn about-component []
  [:div#about
   [:h2 "About DCD 2020"]
   [:p "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands! We welcome you to the 5th edition of our " [:b "free "] " and non-profit Clojure conference organised by the community, for the community with a full day of amazing talks in a friendly welcoming atmosphere."]
   [:h2 "Sponsorship Packages"]
   [:p "If you want to support us and Clojure community, consider sponsoring us. Please get in touch via email at " [:a {:href "mailto:events@clojuredays.org"} "events@clojuredays.org"] "."]
   ;;  We offer two affordable sponsorship packages, check them out:
   (comment [:img {:src "/img/2020/sponsor.png" :width "600px"}]
            [:img {:src "/img/2020/partner.png" :width "600px"}])])

(defn cfp-component []
  [:div#cfp
   [:h2 "Call for Proposals"]
   [:p "Our CFP is open! You can submit your proposal at " [:a {:href "https://www.papercall.io/dcd20"} "Papercall"] ". We look forward to receive your groudbreaking, breathtaking, parenssurfing proposals on real-world experiences and lessons learned frm putting your clojure(script) applications to production, fancy new library tool that just landed on the clojure planet, etc."]])

(defn tickets-component []
  [:div#date
   [:h2 "Reserve your Spot"]
   [:p "DCD 2020 will be in Amsterdam on "
    [:b "Saturday, May 16th, 2020"] ". We'll soon open our registrations, make sure to follow us on "
    [:a {:href "https://twitter.com/clojuredays"} "@clojuredays"] " and be the first to reserve your spot!"]])

(defn when-component []
  [:div
   [:p"Dutch Clojure Days will happen on "
    [:b " Saturday, May 16th, 2020"] "."]])

(defn main-component []
  [:article.main
   [:div#about
    [about-component]]
   [:div#date
    [:h2 "When?"]
    [when-component]]
   [:div#cfp
    [cfp-component]]
   #_[:div#sponsors
      [:h2 "Sponsors"]
      [sponsors-component]]
   #_[:div#agenda
      [:h2 "Agenda"]
      [agenda-component agenda-data]]
   #_[:div#speakers
      [:h2 "Speakers"]
      [speakers-component agenda-data]]
   [:div#location
    [:h2 "Where?"]
    [location-component {:coords [52.3666451 4.892396599999984]}]]
   [:div
    [tickets-component]]
   [:div#behave
    [:h2 "Code of Conduct"]
    [code-of-conduct-component]]])

(def dcd2020-website-structure
  {:main-component main-component
   :header-component header-component-2020
   :footer-component footer-component})
