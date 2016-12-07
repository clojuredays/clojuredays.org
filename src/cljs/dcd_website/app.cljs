(ns dcd-website.app
  (:require [reagent.core :as reagent :refer [atom]]))

(def dcd-team
  [["Carlo Sciolla" "skuro"]
   ["Vijay Kiran" "vijaykiran"]
   ["Max Gonzih" "gonzih"]
   ["Joost Diepenmaat" "ZeekatSoftware"]])

(defn header-component []
  [:header.header
   [:div.logo
    [:img {:src "img/logo.png"}]]
   [:div.title
    [:h1 "Dutch Clojure Days 2017"]]])

(defonce sidebar-expanded (atom false))

(defn collapse-sidebar [_]
  (reset! sidebar-expanded false)
  true)

(defn expand-sidebar [_]
  (reset! sidebar-expanded true)
  true)

(defn menu-entry-component [{:keys [link text]}]
  [:a.item {:href link :on-click collapse-sidebar :key (gensym)} text])

(defn sidebar-component []
  [:aside.sidebar
   {:class (when-not @sidebar-expanded "collapsed")}
   [:a.item.expand-icon
    {:href "#"
     :on-click (fn [e]
                 (.preventDefault e)
                 (swap! sidebar-expanded not))}
    "☰"]
   (map menu-entry-component [{:link "#about"    :text "About"}
                              {:link "#cfp"      :text "Call for papers"}
                              {:link "#date"     :text "When?"}
                              {:link "#location" :text "Where?"}
                              {:link "#sponsors" :text "Sponsors"}
                              {:link "#behave"   :text "Code of conduct"}
                              {:link "#org"      :text "Contacts"}
                              {:link "#dcd16"    :text "DCD16"}])])

(defn code-of-conduct-component []
  [:div
   [:p "All attendees, speakers, sponsors and volunteers at our conference are required to agree with the following code of conduct. Organisers will enforce this code throughout the event. We expect cooperation from all participants to help ensure a safe environment for everybody."]
   [:h3 "Need Help?"]
   [:p "You can always reach out to us at "
    [:a {:href "mailto:events@clojuredays.org"}
     [:img.icon {:src "img/icons/email.svg"}]
     "events@clojuredays.org"] " or on "
    [:a {:href "https://twitter.com/clojuredays"}
     [:img.icon {:src "img/icons/twitter.svg"}]
     "twitter"] "."]
   [:h3 "The Quick Version"]
   [:p "Our conference is dedicated to providing a harassment-free conference experience for everyone, regardless of gender, gender identity and expression, age, sexual orientation, disability, physical appearance, body size, race, ethnicity, religion (or lack thereof), or technology choices. We do not tolerate harassment of conference participants in any form. Sexual language and imagery is not appropriate for any conference venue, including talks, workshops, parties, Twitter and other online media. Conference participants violating these rules may be sanctioned or expelled from the conference  " [:strong "without a refund"] " at the discretion of the conference organisers."]
   [:h3 "The Less Quick Version"]
   [:p "Harassment includes offensive verbal comments related to gender, gender identity and expression, age, sexual orientation, disability, physical appearance, body size, race, ethnicity, religion, technology choices, sexual images in public spaces, deliberate intimidation, stalking, following, harassing photography or recording, sustained disruption of talks or other events, inappropriate physical contact, and unwelcome sexual attention."]
   [:p "Participants asked to stop any harassing behavior are expected to comply immediately."]
   [:p "Sponsors are also subject to the anti-harassment policy. In particular, sponsors should not use sexualised images, activities, or other material. Booth staff (including volunteers) should not use sexualised clothing/uniforms/costumes, or otherwise create a sexualised environment."]
   [:p "If a participant engages in harassing behavior, the conference organisers may take any action they deem appropriate, including warning the offender or expulsion from the conference with no refund."]
   [:p "If you are being harassed, notice that someone else is being harassed, or have any other concerns, please contact a member of conference staff immediately. Conference staff can be identified as they'll be wearing branded clothing and/or badges."]
   [:p "Conference staff will be happy to help participants contact hotel/venue security or local law enforcement, provide escorts, or otherwise assist those experiencing harassment to feel safe for the duration of the conference. We value your attendance."]
   [:p "We expect participants to follow these rules at conference and workshop venues and conference-related social events."]])

(defn sponsors-component []
  [:p "DCD is a free event that is made possible thanks to our amazing sponsors and volunteers.
       Currently we are looking for sponsors for DCD17.
       If you are interested in sponsoring this event please contact us via "
   [:a {:href "mailto:events@clojuredays.org"}
    [:img.icon {:src "img/icons/email.svg"}]
    "email."]])

(defn when-component []
  [:p "Dutch Clojure Days will happen on "
   [:a {:href "dcd.ics"}
    [:img.icon {:src "img/icons/calendar.svg"}] "Saturday, March 25th 2017"] "."])

(defn location-component []
  [:p "Amsterdam. Probably. Exact location is yet to be announced. If you have any ideas or suggestions feel free to "
   [:a {:href "mailto:events@clojuredays.org"}
    [:img.icon {:src "img/icons/email.svg"}]
    "contact us"] "."])

(defn call-for-paper-component []
  [:p
   "Call for papers ends on 31th of January, 2017. To submit your talk proposal please use "
   [:a {:href "https://goo.gl/forms/yvTZUAZ2YyCtfEM02"
        :target :_blank}
    [:span.form-button "This form"]]])

(defn main-component []
  [:article.main
   [:div#about
    [:h2 "About DCD17"]
    [:p "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands!"]]
   [:div#cfp
    [:h2 "Call for papers"]
    [call-for-paper-component]]
   [:div#date
    [:h2 "When?"]
    [:p [when-component]]]
   [:div#location
    [:h2 "Where?"]
    [:p [location-component]]]
   [:div#sponsors
    [:h2 "Sponsors"]
    [sponsors-component]]
   [:div#behave
    [:h2 "Code of Conduct"]
    [code-of-conduct-component]]
   [:div#org
    [:h2 "Contacts"]
    [:h3 "Official contacts"]
    [:span.email-info
     [:a {:href "mailto:events@clojuredays.org"}
      [:img {:src "img/icons/email.svg"}]
      "events@clojuredays.org"]]
    [:span.org-info
     [:a {:href "https://twitter.com/clojuredays"}
      [:img {:src "img/icons/twitter.svg"}]
      "@clojuredays"]]
    [:h3 "DCD team"]
    [:div
     (letfn [(organizer [[name handle]]
               ^{:key handle}
               [:span.org-info
                [:a {:href (str "https://twitter.com/" handle)
                     :target :_blank}
                 [:img {:src "img/icons/twitter.svg"}]
                 name]])]
       (map organizer dcd-team))]
    [:h3 "Design & Art"]
    [:span.org-info
     [:a {:href "https://twitter.com/moolver_sin"
          :target :_blank}
      [:img {:src "img/icons/twitter.svg"}]
      "Lubov Soltan"]]]
   [:div#dcd16
    [:h2 "DCD16"]
    [:p "Videos from the previous event are available here: "
     [:a {:href "https://www.youtube.com/playlist?list=PLjzcwcP9P2LeiVXofnnXcxAqvmVNn3fTD"
          :target :_blank}
      [:img.icon {:src "img/icons/youtube.svg"}]
      "DCD16 Playlist on Youtube"] "."]]])

(defn footer-component []
  [:footer.footer
   [:a {:href "https://twitter.com/clojuredays"
        :target :_blank}
    [:img {:src "img/icons/twitter.svg"}]]
   [:a {:href "https://www.youtube.com/channel/UCZ7rYtyjSgF1jMYHCkyjwMQ"
        :target :_blank}
    [:img {:src "img/icons/youtube.svg"}]]
   [:a {:href "mailto:events@clojuredays.org"}
    [:img {:src "img/icons/email.svg"}]]])

(defn website-component []
  [:div.site
   [:div.wrapper
    [header-component]
    [sidebar-component]
    [main-component]]
   [footer-component]])

(defn init []
  (when js/document.location
    (reagent/render-component
     [website-component]
     (.getElementById js/document "container"))))

(defn ^:export render-to-string []
  (reagent/render-to-string [website-component]))
