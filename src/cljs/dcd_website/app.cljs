(ns dcd-website.app
  (:require [reagent.core :as reagent :refer [atom]]))

(def dcd-team
  [["Carlo Sciolla" "skuro"]
   ["Vijay Kiran" "vijaykiran"]
   ["Max Gonzih" "gonzih"]
   ["Joost Diepenmaat" "ZeekatSoftware"]])

(def lorem-str "Well, the way they make shows is, they make one show. That show's called a pilot. Then they show that show to the people who make shows, and on the strength of that one show they decide if they're going to make more shows. Some pilots get picked and become television programs. Some don't, become nothing. She starred in one of the ones that became nothing.")

(defn lorem [n]
  (apply str (take n (repeat lorem-str))))

(defn header-component []
  [:header.header
   [:div.logo
    [:img {:src "/img/logo_big2.png"}]]
   [:div.title
    [:h1 "Dutch Clojure Days 2017"]]])

(defn sidebar-component []
  [:aside.sidebar
   [:a.item {:href "#about"} "About"]
   [:a.item {:href "#date"} "When?"]
   [:a.item {:href "#location"} "Where?"]
   [:a.item {:href "#cfp"} "Call for papers"]
   [:a.item {:href "#behave"} "Code of conduct"]
   [:a.item {:href "#org"} "Organizers"]])

(defn main-component []
  [:article.main
   [:div#about
    [:h2 "About DCD17"]
    [:p "The Annual Gathering of Clojure Enthusiasts and Practitioners in the Netherlands!"]
    [:p "Videos from the previous event are available here: "
     [:a {:href "https://www.youtube.com/playlist?list=PLjzcwcP9P2LeiVXofnnXcxAqvmVNn3fTD"
          :target :_blank}
      "DCD 2016"]]]
   [:div#date
    [:h2 "When?"]
    [:p (lorem 1)]]
   [:div#location
    [:h2 "Where?"]
    [:p (lorem 2)]]
   [:div#cfp
    [:h2 "Call for papers"]
    [:p (lorem 1)]]
   [:div#behave
    [:h2 "Code of conduct"]
    [:p (lorem 5)]]
   [:div#org
    [:h2 "Organizers"]
    [:h3 "DCD team"]
    [:div
     (letfn [(organizer [[name handle]]
               ^{:key handle}
               [:span.org-info
                [:a {:href (str "https://twitter.com/" handle)
                     :target :_blank}
                 [:img {:src "/img/icons/twitter.svg"}]
                 name]])]
       (map organizer dcd-team))]
    [:h3 "Design & Art"]
    [:span.org-info
     [:a {:href "https://twitter.com/moolver_sin"
          :target :_blank}
      [:img {:src "/img/icons/twitter.svg"}]
      "Lubov Soltan"]]]])

(defn footer-component []
  [:footer.footer
   [:a {:href "https://twitter.com/clojuredays"
        :target :_blank}
    [:img {:src "/img/icons/twitter.svg"}]]
   [:a {:href "https://www.youtube.com/channel/UCZ7rYtyjSgF1jMYHCkyjwMQ"
        :target :_blank}
    [:img {:src "/img/icons/youtube.svg"}]]
   [:a {:href "mailto:contact@clojuredays.org"}
    [:img {:src "/img/icons/email.svg"}]]])

(defn calling-component []
  [:div.site
   [:div.wrapper
    [header-component]
    [sidebar-component]
    [main-component]]
   [footer-component]])

(defn init []
  (reagent/render-component
   [calling-component]
   (.getElementById js/document "container")))
