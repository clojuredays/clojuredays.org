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
    [:time {:date-time "2026-05-09"}
     [:b " Saturday, May 9th, 2026"]] "."]])

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
    [:a.sponsor.platinum {:href "https://freshcodeit.com/" :target :_blank}
     [:img {:src "img/2026/sponsors/freshcode.svg" :alt "FreshCode"}]]
    [:h3.package "Supporter"]
    [:a.sponsor.supporter {:href "https://nextjournal.com/" :target :_blank}
     [:img {:src "img/2026/sponsors/nextjournal.svg" :alt "Nextjournal"}]]]])

(def agenda-data
  [{:time ["8:30" "9:00"]
    :title "Reception"
    :type :org}

   {:time ["9:00" "9:15"]
    :title "Opening"
    :author "#DCD26 team"
    :type :org}

   {:time ["9:15" "10:00"]
    :title "Shapes of Together"
    :author "Daniel Slutsky"
    :add-padding true
    :type :talk
    :profile-pic "dslutsky.jpg"
    :description "In this talk, we discuss how spaces for collaboration form and grow, drawing on experiences from local activist groups, from building Scicloj, and from watching newer spaces like Clojure Civitas. Using Clojure's tools for visual storytelling, we'll dive into the stories of these communities and others: their conversations, their activity over time, and how they've changed.
<br />
Community building raises questions. How do we create spaces where diverse voices are genuinely heard, yet still find common direction and reach decisions when needed? How do we support people of different backgrounds? How do we maintain continuity when individuals come and go, and what structures serve a group that keeps changing? How do we nurture ideas that challenge mainstream thought, yet remain welcoming to those encountering these ideas for the first time?
<br />
In times of uncertainty, we don't have to be alone. With care, building together becomes possible. We'll consider what that care may look like, and ask: what do we still need to build for each other?"
    :bio "Daniel Slutsky is a Clojurian and a mathematician. Since 2019, he has been involved in building Scicloj, an open-source community focused on helping Clojure grow. He co-maintains a few tools and libraries, including Noj, Clay, Tableplot, and ClojisR."
    :blog "https://clojurecivitas.github.io/Daniel_Slutsky"
    :youtube-link nil}

   {:time ["10:00" "10:45"]
    :title "Unconfirmed"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["10:45" "11:15"]
    :title "Coffee break"
    :type :org}

   {:title "Lightning Talks"
    :force-timeline-hidden? true
    :type :lightning}

   {:time ["11:15" "11:25"]
    :type :lightning
    :title "clj-simple-stats: statistics that is actually easy to setup and use"
    :author "Nikita Prokopov"
    :profile-pic "nprokopov.jpg"
    :bio "Nikita has been programming in Clojure, Java, Python, Erlang for 19 years, been interested in UI/UX design for about the same amount of time, and created a few notable projects, including DataScript, Rum, Clojure Sublimed, Tongue, Clj-reload, Uberjars, Clj-simple-router, Humble UI and Fira Code."
    :description "Brief overview of clj-simple-stats: a website statistics middleware for Ring servers that requires no configuration, can be plugged in with 1 line of code and Just Works™"
    :twitter "nikitonsky"
    :blog "https://tonsky.me"
    :youtube-link nil}

   {:time ["11:25" "11:35"]
    :type :lightning
    :title "MilaDB: 0-deps embeddable time-traveling database"
    :author "Benny Andresen"
    :bio "Benny is a Clojure developer in Northern Germany. Not the best place to spend lots of time in the hammock, but he makes it work."
    :profile-pic "bandresen.jpg"
    :description "A Database heavily inspired by Datomic and its descendants like Datascript, Datahike, Datalevin and most recently dbval.
<br />
The value proposition is: db-as-a-value, running in process, zero dependencies, backed by bbolt's simplified-from LMDB database design.
<br />
Wherever you would use SQLite and you're into Datomic-flavored Datalog, MilaDB could be an option."
    :youtube-link nil}

   {:time ["11:35" "11:45"]
    :type :lightning
    :title "Unlocking the power of SQLite with coffi (JDK 22 FFI)"
    :author "Anders Murphy"
    :bio "👋 Hi! I'm Anders. A Fullstack Developer, Product Engineer and Startup Founder from Edinburgh (UK). I've spent most of my career building consumer facing apps.
<br />
I do consulting work on: Clojure, JVM, SQLite, product design, rapid prototyping and performance tuning (with a focus on vertical scaling).
<br />
Currently I'm working for Lightweight Labs."
    :profile-pic "amurphy.jpg"
    :description [:span "In this session I'll cover how the " [:a {:href "https://github.com/IGJoshua/coffi"} "coffi library"] " lets you use JDK 22 FFI to make C bindings. This unlocks bindings in C libraries that are often not implemented in high level wrappers. In the case of SQLite there's a whole suit of powerful features that are hard to access from more generic database wrappers like JDBC.
<br />
Coffi's macros and memory arenas make programming C from Clojure fun."]
    :twitter "anders_murphy"
    :blog "https://andersmurphy.com"
    :youtube-link nil}

   {:time ["11:45" "12:30"]
    :title "Unconfirmed"
    :type :talk
    :force-timeline-visible? true}

   {:time ["12:30" "14:00"]
    :title "Lunch break"
    :type :org}

   {:time ["14:00" "14:45"]
    :title "Sound theory, music theory and analogue synthesis, with Overtone"
    :author "Arne Brasseur"
    :bio [:span "Arne is the CEO and founder of " [:a {:href "https://gaiwan.co"} "Gaiwan"] ", the company behind " [:a {:href "https://lambdaisland.com"} "Lambda Island"] " and Heart of Clojure. He teaches and consults about all things Clojure and ClojureScript, as well working tirelessly to improve the Clojure ecosystem through open source software like Kaocha, and community initiatives like ClojureVerse."]
    :profile-pic "abrasseur.jpg"
    :description "With Overtone Clojure has one of the coolest live music coding environments in
existence, but the learning curve is steep. Overtone has fewer built-in
instruments than for instance Sonic-Pi, assuming that people will be more
interested in building their own synths and instruments instead. As a result the
biggest barrier to entry often isn't really about Clojure or Overtone, but about
sound, music, and the principles of analogue synthesisers.
<br />
In this very hands-on talk I want to present some basic sound and music theory,
and then go over the most common synthesis techniques, like additive synthesis,
subtractive synthesis, frequency modulation, etc. Showing through live examples
in Overtone how much fun can be had, and encouraging people to start exploring
this wonderful world themselves."
    :type :talk
    :blog "https://lambdaisland.com/blog"
    :youtube-link nil}

   {:time ["14:45" "15:30"]
    :title "Unconfirmed"
    :type :talk
    :youtube-link nil}

   {:title "Lightning Talks"
    :force-timeline-hidden? true
    :type :lightning}

   {:time ["15:30" "15:40"]
    :type :lightning
    :title "Fun with JVM flags"
    :author "Ray McDermott"
    :profile-pic "rmcdermott.jpg"
    :bio "Clojure enthusiast, podcast host. Seasoned, veteran, perhaps even a classic, old fart or haha a senior developer"
    :description "A small comic interlude on how the JVM flags can be reinterpreted for fun and no profit"
    :youtube-link nil}

   {:time ["15:40" "15:50"]
    :type :lightning
    :title "Bringing async/await from Squint to ClojureScript"
    :author "Michiel Borkent"
    :profile-pic "borkdude.jpg"
    :bio "Michiel Borkent, known online as @borkdude, is a passionate open source Clojure developer. He’s helping developers to write cleaner, faster, and more enjoyable code with popular tools like clj-kondo, babashka, SCI, nbb, and squint. When he’s not deep in parentheses, you’ll find him at the piano or enjoying a walk outdoors."
    :description "In this talk you will learn how I ported Squint’s implementation of async/await to ClojureScript and how you can use it to simplify asynchronous code.
<br />
Three years ago I presented Squint at Dutch Clojure Days: a dialect of ClojureScript that supports modern JavaScript (ES6) features such as async/await. Async/await allows asynchronous code to be written in a sequential style. The `await` keyword marks a point where execution pauses until a result is available, without blocking the runtime. When the result arrives, execution continues where it left off.
<br />
Since then, porting it to ClojureScript itself has been on the back of my mind. The main obstacle was that ClojureScript historically targeted older versions of JavaScript and was deliberately conservative about adopting newer language features.
Now, a decade after ES6 was introduced, ClojureScript targets ES6 as its baseline. This shift has renewed interest in integrating features such as async/await directly into ClojureScript.
<br />
The talk covers the design constraints, compiler changes, and trade-offs involved in bringing async/await semantics to ClojureScript."
    :twitter "borkdude"
    :blog "https://blog.michielborkent.nl"
    :youtube-link nil}

   {:time ["15:50" "16:00"]
    :type :lightning
    :title "On growing a community"
    :author "Erik Assum"
    :profile-pic "eassum.jpg"
    :bio "Erik is a wearer of many hats at Ardoq, a Norwegian scale up in the enterprise architecture space . He’s a mainly a backend programmer, but tends to work wherever the code is bad enough. Given time he’ll eventually drift into some sort of devops role while trying to figure out how to run the current project even better.
<br />
Lately, he's been lurking around open-source Clojure projects looking for easy bugs to fix. This is his way of paying back to the community."
    :description "The Clojure community is a small one. Perhaps you live in a place where the scene is not yet vibrant and thriving. In this lightning talk, I'll give a couple of tips on how to get your local community going with very low effort"
    :twitter "slipset"
    :blog "https://slipset.github.io"
    :youtube-link nil}

   {:time ["16:00" "16:10"]
    :title "Closing"
    :author "#DCD26 team"
    :type :org}])

(defn main-component []
  [:article.main
   (about-component)
   (when-component)
   (where-component)
   (tickets-component)
   #_(cfp-component)
   (sponsors-component)
   (sponsor-packages-component)
   [:div#agenda
    [:h2 "Agenda"]
    [:p "The agenda below is just an indication as " [:a {:href "https://sessionize.com/dutch-clojure-days-2026/"} "our CfP is still ongoing!"]]
    (agenda-component agenda-data)]
   [:div#speakers
    [:h2 "Speakers"]
    (speakers-component agenda-data)]
   [:div#behave
    [:h2 "Code of Conduct"]
    (code-of-conduct-component)]])

(def dcd2026-website-structure
  {:title          "Dutch Clojure Days 2026"
   :main-component (main-component)})
