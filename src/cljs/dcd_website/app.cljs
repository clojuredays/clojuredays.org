(ns dcd-website.app
  (:require [reagent.core :as reagent :refer [atom]]))

(declare agenda-component speakers-component)

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
                              {:link "#agenda"   :text "Agenda"}
                              {:link "#speakers" :text "Speakers"}
                              {:link "#behave"   :text "Code of conduct"}
                              {:link "#org"      :text "Contacts"}
                              {:link "#dcd16"    :text "DCD16"}])])

(defn code-of-conduct-component []
  [:div
   [:p "All attendees, speakers, sponsors and volunteers at our conference are required to agree with the following code of conduct. Organisers will enforce this code throughout the event. We expect cooperation from all participants to help ensure a safe environment for everybody."]
   [:h3 "Need Help?"]
   [:p "You can always reach out to us at "
    [:a {:href "mailto:events@clojuredays.org"}
     [:img.icon.email {:src "img/icons/email.svg"}]
     "events@clojuredays.org"] " or on "
    [:a {:href "https://twitter.com/clojuredays"}
     [:img.icon.twitter {:src "img/icons/twitter.svg"}]
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
  [:div.sponsors
   [:p "DCD is a free event that is made possible thanks to our amazing sponsors and volunteers."]
   [:h2.platinum "Platinum sponsors"]
   [:a.sponsor {:href "http://www.adgoji.com/" :target :_blank}
    [:img {:src "img/sponsors/adgoji.svg"}]]
   [:a.sponsor {:href "http://www.vakantiediscounter.nl/" :target :_blank}
    [:img {:src "img/sponsors/elmar.svg"}]]
   [:h2.regular "Silver sponsors"]
   [:a.sponsor.juxt {:href "https://juxt.pro/" :target :_blank}
    [:img {:src "img/sponsors/juxt.svg"}]]
   [:a.sponsor.infi {:href "https://infi.nl/" :target :_blank}
    [:img {:src "img/sponsors/infi.svg"}]]
   [:p "If you are interested in sponsoring this event please contact us via "
    [:a {:href "mailto:events@clojuredays.org"}
     [:img.icon.email {:src "img/icons/email.svg"}]
     "email."]]])

(defn when-component []
  [:div
   [:p"Dutch Clojure Days will happen on "]
   [:a {:href "https://www.eventbrite.com/e/dutch-clojure-day-2017-tickets-30113550440" :target :_blank}
    [:img.icon {:src "img/icons/calendar.svg"}] "Saturday, March 25th 2017"] "."
   [:div.iframe-wrapper
    [:iframe {:src "//eventbrite.com/tickets-external?eid=30113550440&ref=etckt"
              :frame-border 0
              :height "100%"
              :width "100%"
              :margin-height 5
              :margin-width 5
              :scrolling "auto"}]]])

(def coords (clj->js [52.3666451 4.892396599999984]))

(defn add-marker! [mymap]
  (-> js/L
      (.marker coords)
      (.bindPopup "<a href='http://tq.co' target='_blank'>TQ - Singel 542</a>")
      (.addTo mymap)))

(defn init-tile-layer! [mymap]
  (-> js/L
      (.tileLayer "https://api.mapbox.com/styles/v1/gonzih/cixw9sqla002c2sn0a5uqu72s/tiles/256/{z}/{x}/{y}?access_token={accessToken}"
                  (clj->js {:attribution "&copy; <a href='http://openstreetmap.org' target='_blank'>OpenStreetMap</a>, <a href='http://creativecommons.org/licenses/by-sa/2.0/' target='_blank'>CC-BY-SA</a>, © <a href='http://mapbox.com' target='_blank'>Mapbox</a>"
                            :maxZoom 18
                            :accessToken "pk.eyJ1IjoiZ29uemloIiwiYSI6ImNpeHc1eDA0NjAwMmczMmw4MnR5b2p4eWsifQ.nrJj6lim59mVefvEwsiCgA"}))
      (.addTo mymap)))

(defn init-map! []
  (let [mymap (-> js/L
                  (.map "location-map")
                  (.setView coords 17))]
    (init-tile-layer! mymap)
    (add-marker! mymap)))

(def location-component
  (with-meta
    (fn []
      [:div.location
       [:p "Dutch Clojure Days 2017 will take place at "
        [:a {:href "http://tq.co" :target :_blank} "TQ"]
        " (Singel 542, 1017 AZ Amsterdam)."]
       [:div#location-map]])
    {:component-did-mount init-map!}))

(defn call-for-paper-component []
  [:div
   [:p "Call for papers ended on 31th of January, 2017."]])

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
    [when-component]]
   [:div#location
    [:h2 "Where?"]
    [location-component]]
   [:div#sponsors
    [:h2 "Sponsors"]
    [sponsors-component]]
   [:div#agenda
    [:h2 "Agenda"]
    [agenda-component]]
   [:div#speakers
    [:h2 "Speakers"]
    [speakers-component]]
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
    [:div
     (letfn [(organizer [[name handle]]
               ^{:key handle}
               [:span.org-info
                [:a {:href (str "https://twitter.com/" handle)
                     :target :_blank}
                 [:img.icon.twitter {:src "img/icons/twitter.svg"}]
                 name]])]
       (map organizer dcd-team))]
    [:h3 "Design & Art"]
    [:span.org-info
     [:a {:href "https://twitter.com/moolver_sin"
          :target :_blank}
      [:img.icon.twitter {:src "img/icons/twitter.svg"}]
      "Lubov Soltan"]]]
   [:div#dcd16
    [:h2 "DCD16"]
    [:p "Videos from the previous event are available here: "
     [:a {:href "https://www.youtube.com/playlist?list=PLjzcwcP9P2LeiVXofnnXcxAqvmVNn3fTD"
          :target :_blank}
      [:img.icon.youtube {:src "img/icons/youtube.svg"}]
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

(def agenda-data
  [
   {:time "8.30-9.30"
    :title "Reception/Welcome"
    :type :org}

   {:time "9.15-9.30"
    :title "Opening"
    :author "#DCD17 team"
    :type :org}

   {:time "9.30-10.15"
    :title "Keynote: Transparency through data"
    :author "James Reeves"
    :description "How do we make effective use of data when designing software in Clojure? This talk will provide a tour of the options that are available, and explain how liberal use of data structures can make a codebase simpler and more adaptive to change."
    :type :talk}

   {:time "10:25-11:10"
    :title "Generatively testing user interfaces"
    :author "Andreas Geffen Lundahl"
    :type :talk}

   {:time "11:20-12:05"
    :title "Building Hermetic Systems (without Docker)"
    :author "Will Farrell"
    :type :talk}

   {:time "12:05-13:20"
    :title "Lunch"
    :type :org}

   {:time "13:20-14:05"
    :title "Our Road Trip to Component"
    :author "Marketa Adamova"
    :type :talk}

   {:time "14:15-14:30"
    :title "Sequencing Dance Music with Clojure"
    :author "Piotr Jagielski"
    :type :lightning}

   {:time "14:30-14:45"
    :title "Shipping a Clojurescript App"
    :author "Riccardo Cambiassi"
    :type :lightning}

   {:time "14:45-15:00"
    :title "Mach"
    :author "Malcolm Sparks"
    :type :lightning}

   {:time "15:00-15:15"
    :title "CREPL: Write and run ClojureScript code together"
    :author "Gijs Stuurman"
    :type :lightning}

   {:time "15:15-15:45"
    :title "Coffee break"
    :type :org}

   {:time "15:45-16:30"
    :title "Using Onyx in anger"
    :author "Simon Belak"
    :type :talk}

   {:time "16:40-17:25"
    :title "Clojure Puzzlers"
    :author "Renzo Borgatti"
    :type :talk}

   {:time "17:35-18:20"
    :title "From 0 to prototype using ClojureScript, re-frame and friends."
    :author "Martin Clausen"
    :type :talk}

   {:time "18:20-18:30"
    :title "Closing"
    :author "#DCD17 team"
    :type :org}

   {:time "18:30-21:30"
    :title "Networking / drinks + defjoke - a macro for creating FP jokes by Ray McDermott"
    :type :org}])

(def colors
  {:org "#f1f1f1"
   :talk "#b1e8b1"
   :lightning "#cbebff"})

(defn table-row [{:keys [title time author type]}]
  ^{:key (str time author)}
  [:tr
   {:style {:background (colors type)}}
   [:td time]
   [:td {:col-span (if author 1 2)} title]
   (when author
     [:td author])])

(defn agenda-component []
  [:div.agenda
   [:table {:cell-spacing 0}
    [:tbody
     (doall (map table-row agenda-data))]]])

(defn speaker-component [{:keys [author description title type]}]
  ^{:key author}
  [:div author "-" title "-" description])

(defn speakers-component []
  [:div.speakers
   (doall (->> agenda-data
               (filter #(#{:lightning :talk} (:type %)))
               (map speaker-component)))])

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
