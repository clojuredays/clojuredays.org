(ns dcd-website.app
  (:require [reagent.core :as reagent :refer [atom]]))

(declare agenda-component speakers-component)

(def dcd-team
  [["Carlo Sciolla" "skuro"]
   ["Vijay Kiran" "vijaykiran"]
   ["Max Gonzih" "gonzih"]
   ["Joost Diepenmaat" "ZeekatSoftware"]])

(defn header-component
  ([]
   (header-component {}))
  ([styles & children]
   [:header.header styles
    [:div.logo
     [:img {:src "img/logo.svg"}]]
    [:div.title
     [:h1 "Dutch Clojure Days 2017"]]
    children]))

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
   [:a.sponsor.lunatech {:href "http://lunatech.com/" :target :_blank}
    [:img {:src "img/sponsors/lunatech.svg"}]]
   [:p "If you are interested in sponsoring this event please contact us via "
    [:a {:href "mailto:events@clojuredays.org"}
     [:img.icon.email {:src "img/icons/email.svg"}]
     "email."]]])

(defn when-component []
  [:div
   [:p"Dutch Clojure Days did happen on "]
   [:a {:href "https://www.eventbrite.com/e/dutch-clojure-day-2017-tickets-30113550440" :target :_blank}
    [:img.icon {:src "img/icons/calendar.svg"}] "Saturday, March 25th 2017, 8:30 AM – 5:30 PM CET"] "."])

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
  [{:time ["8:30" "9:15"]
    :title "Reception"
    :type :org}

   {:time ["9:15" "9:30"]
    :title "Opening"
    :author "#DCD17 team"
    :type :org}

   {:time ["9:30" "10:15"]
    :title "Keynote: Transparency through data"
    :author "James Reeves"
    :profile-pic "james.jpg"
    :description "How do we make effective use of data when designing software in Clojure? This talk will provide a tour of the options that are available, and explain how liberal use of data structures can make a codebase simpler and more adaptive to change."
    :bio "James Reeves is the current lead developer of Ring, and is the author of a number of other Clojure web development libraries, including Compojure and Hiccup."
    :twitter "weavejester"
    :add-padding true
    :type :talk}

   {:time ["10:25" "11:10"]
    :title "Generatively testing user interfaces"
    :profile-pic "andreas.jpg"
    :author "Andreas Geffen Lundahl"
    :description "Brace yourself for a journey into the mysterious and magnificent world of generative testing. Andreas tells his story of how he has combined data generators with Selenium, to test the part of the application every programmer dreads the most: the user interface. By applying this chaotic testing technique to the user interface and the application as a whole, he has found bugs, gained new insight, and ultimately had a lot of fun."
    :bio "I'm an independent consultant, who fell in love with Clojure in 2011 and I've been a functional programming enthusiast ever since. When I don't work for clients, I try to spend as much time as possible on my own (crazy) projects."
    :twitter "aglundahl"
    :add-padding true
    :type :talk}

   {:time ["11:20" "12:05"]
    :title "Building Hermetic Systems (without Docker)"
    :profile-pic "will.jpg"
    :author "Will Farrell"
    :description
    [:div
     [:p "Besides being a fun word to say, what is \"hermeticity\"? Put simply, a hermetic system lacks external dependencies, which simplifies development, testing, and deployment. As a design principal, it mirrors the functional design so prevalent in Clojure. Learn how to use Clojure to build hermetic systems  (with or without Docker) and leverage the REPL to manage the lifecycle of your services."]
     [:p "Takeways: "]
     [:ul
      [:li "How the notion of hermeticity is an example of functional design thinking"]
      [:li "How to identify hermetic  (and not so hermetic) systems"]
      [:li "How to leverage Clojure  (and the REPL) to build and manage hermetic systems"]]]
    :bio "Will Farrell is the Lead Software Architect at MojoTech in Providence, RI, where he oversees software projects large and small. He’s been building software for about a decade and loves Clojure especially. In his free time, when not working on open source software, he’s likely practicing his vinyl DJing skills or cooking a fancy meal."
    :twitter "wkf"
    :type :talk}

   {:time ["12:05" "13:20"]
    :title "Lunch"
    :type :org
    :force-timeline-visible? true}

   {:time ["13:20" "14:05"]
    :title "Our Road Trip to Component"
    :profile-pic "marketa.jpg"
    :author "Marketa Adamova"
    :description "Few months ago our company NomNom decided to move all its backend services from Ruby to Clojure. And I think a road trip is best comparison for this migration. There was excitement at start, then panic a few hours down the road wondering what was left behind,  but now a constant joy of discovering new things. In this talk I’d like to share how we eventually arrived at Stuart Sierra’s Component. Let’s take a look at how components improved our quickly growing codebase and testing, as well as some of the trade-offs we had to make. Finally I’ll show how components can help with managing running code in production."
    :bio "Marketa currently works as a Clojure developer at NomNom and is a co-organizer of the Prague Lambda Meetup. She is actively involved in introducing Clojure to wider community and has an strong interest in teaching programming."
    :twitter "MarketaAdamova"
    :add-padding true
    :type :talk}

   {:title "Lightning Talks"
    :force-timeline-hidden? true
    :type :lightning}

   {:time ["14:15" "14:30"]
    :title "Sequencing Dance Music with Clojure"
    :profile-pic "piotr.jpg"
    :description "In this talk I'll give a short introduction to Overtone, Leipzig and my own Disclojure libraries. I'll focus on techniques of sequencing and looping sounds and samples which can be used in live on-stage dance music performances."
    :author "Piotr Jagielski"
    :bio "JVM/Java developer for 10 years, last 2 years exploring Clojure/Overtone."
    :twitter "pjagielski"
    :type :lightning}

   {:time ["14:30" "14:45"]
    :title "Shipping a Clojurescript App"
    :profile-pic "riccardo.jpg"
    :author "Riccardo Cambiassi"
    :description "We will explore a case study of the use of Clojurescript on top of Electron  (Atom Shell) for the development and distribution of a desktop application. Rather than going through an introductory proof of concept, we will focus on the characteristics that made this technology stack a good fit for building, distributing and supporting a desktop app. Along the way, we will pick a few extra tools and practical tricks that may be beneficial to a similar endeavour."
    :bio "I am a web developer with a long term itch for UX and product design.  The Ruby ecosystem has been for a long time my toolkit of choice, but more recently I fell for the charm of functional programming in general, and Lisps in particular. Currently I am running, with the help of a few friends 100Starlings, a remote-first software development collective."
    :twitter "bru"
    :type :lightning}

   {:time ["14:45" "15:00"]
    :title "Mach"
    :profile-pic "malcolm.jpg"
    :author "Malcolm Sparks"
    :description "JUXT's Mach is a remake of make, the venerable build system rebuilt in ClojureScript with some differences. There are hundreds of build tools, this talk will introduce Mach and explain why I felt the need to make one more, what you can do with it and why you might want to use it."
    :bio "Founder of JUXT, author of some Clojure libs including bidi and yada."
    :twitter "malcolmsparks"
    :type :lightning}

   {:time ["15:00" "15:15"]
    :title "CREPL: Write and run ClojureScript code together"
    :profile-pic "gijs.jpg"
    :author "Gijs Stuurman"
    :description "CREPL is an online collaborative ClojureScript editor and evaluator. It's like a Google docs for ClojureScript, with a self-hosted ClojureScript compiler. This talks shows how to use CREPL to work together on the same ClojureScript code, for instance in a teaching setting. This talk is also a demonstration of what is possible with Clojure and ClojureScript because CREPL is written with both."
    :bio "Clojure programmer in Amsterdam."
    :twitter "thegeez"
    :type :lightning}

   {:time ["15:15" "15:45"]
    :title "Coffee break"
    :type :org
    :add-padding true
    :force-timeline-visible? true}

   {:time ["15:45" "16:30"]
    :title "Using Onyx in anger"
    :profile-pic "simon.jpg"
    :author "Simon Belak"
    :description "Clojure has always been good at manipulating data. With the release of spec and Onyx (\"masterless, cloud scale, fault tolerant, high performance distributed computation system\") good became best. In this talk I will walk you through a data layer architecture build around Kafka an Onyx that is self-describing, declarative, scalable and convenient to work with for the end user. The focus will be on the power and elegance of describing data and computation with data; and the inferences and automations that can be built on top of that."
    :bio "Built my first computer out of Lego bricks and learned to program soon after. Emergence, networks, modes of thought, limits of language and expression are what makes me smile (and up at night). Currently working at GoOpti making the company data-driven; setting up our analytics infrastructure (end goal: provide any answer stemming from data in 2 min or less); and building our predictive-realtime-superduper pricing engine."
    :twitter "sbelak"
    :add-padding true
    :type :talk}

   {:time ["16:40" "17:25"]
    :title "From 0 to prototype using ClojureScript, re-frame and friends."
    :profile-pic "martin.jpg"
    :author "Martin Clausen"
    :description "The talk goes over how to translate a product idea and continuous real world  user feedback from rapid iterations into a working prototype. I will highlight the distinct advantages of ClojureScript itself and its sophisticated tooling for this purpose, but also show how the excellent re-frame library provides sane and scalable structure and other \"similar in spirit\" technologies like PouchDB and CouchDB serve as a solid foundation for the prototype."
    :bio "Former lawyer now legal tech consultant and entrepreneur build next generation contract management system using ClojureScript."
    :twitter "MartinClausen8"
    :add-padding true
    :type :talk}

   {:time ["17:35" "18:20"]
    :title "Clojure Puzzlers"
    :profile-pic "renzo.jpg"
    :author "Renzo Borgatti"
    :description "Are you learning Clojure and want to be prepared for some of the most common traps and pitfalls? Are you a seasoned Clojure veteran and you think you've seen them all? Then come join us to play the Clojure Puzzlers! 8 questions are presented to the audience and you'll have to pick one of the possible answers. Anyone with a working knowledge of the language will be able to understand the puzzles, but even the most senior Clojure master will be puzzled. The interactive talk format is entertaining while the puzzles teach you about the subtleties of Clojure and its standard library."
    :bio "I started programming professionally around 2000. I've done work/research for different industries, corporate and startups. I moved between languages and got interested in Clojure sometime in 2010. After some spare time with it I decided it had to be my profession! I'm author of \"Clojure Standard Library, an Annotated Reference\" by Manning. I currently work at uSwitch in London."
    :twitter "reborg"
    :type :talk}

   {:time ["18:20" "18:30"]
    :title "Closing"
    :author "#DCD17 team"
    :type :org}

   {:time ["18:30" "21:30"]
    :title "Networking/Drinks"
    :type :org}

   {:time ["19:00" "19:30"]
    :title "defjoke - a macro for creating FP jokes"
    :profile-pic "ray.jpg"
    :author "Ray McDermott"
    :description "Bringing pure fun to an impure world."
    :bio "Clojure enthusiast: software architect by day, co-orgniser Belgian Clojure User group and co-host of defn podcast by night (some nights anyway)."
    :twitter "raymcdermott"
    :type :lightning
    :force-timeline-hidden? true}])

(def colors
  {:org "#f1f1f1"
   :talk "#b1e8b1"
   :lightning "#cbebff"})

(defn table-row [{:keys [title time author type]}]
  (let [[start end] time]
    ^{:key (str time author)}
    [:tr
     {:style {:background (colors type)}}
     [:td.time
      (when start [:p.start start])
      (when end [:p.end end])]
     [:td {:col-span (if author 1 2)} title]
     (when author
       [:td author])]))

(defn agenda-component []
  [:div.agenda
   [:table {:cell-spacing 0}
    [:tbody
     (doall (map table-row agenda-data))]]])

(defn speaker-component [{:keys [author description title type profile-pic bio twitter]}]
  ^{:key author}
  [:div.speaker
   [:div.name
    [:img {:src (str "img/speakers/" profile-pic)}]
    [:a.twitter-link {:href (str "https://twitter.com/" twitter) :target :_blank}
     [:img.icon.twitter {:src "img/icons/twitter.svg"}]
     [:span.twitter-handle (str "@" twitter)]]
    [:h3 author]]
   [:div.info
    [:h3.title title]
    [:div.description description]
    (when bio [:div.bio "About the speaker: " bio])]])

(defn speakers-component []
  [:div.speakers
   (doall (->> agenda-data
               (filter #(and (:profile-pic %)
                             (#{:lightning :talk} (:type %))))
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
    (let [root (.getElementById js/document "container")]
      (when root
        (reagent/render-component [website-component] root)))))

(defn ^:export render-to-string []
  (reagent/render-to-string [website-component]))
