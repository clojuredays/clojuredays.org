(ns dcd-website.dcd2018
  (:require [dcd-website.header :refer [header-component]]
            [dcd-website.footer :refer [footer-component]]
            [dcd-website.coc :refer [code-of-conduct-component]]
            [dcd-website.credits :refer [credits]]))

(defn header-component-2018
  []
  (header-component {:title "Dutch Clojure Days 2018"}))

(defn main-component []
  [:article.main
   [:div#about
    [:h2 "About DCD18"]
    [:p "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands!"]]
   [:div#cfp
    [:h2 "Call for papers"]
    [:p "The CFP is not open yet"]]
   [:div#date
    [:h2 "When?"]
    [:p "TBD"]]
   [:div#location
    [:h2 "Where?"]
    [:p "TBD"]]
   [:div#sponsors
    [:h2 "Sponsors"]
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
