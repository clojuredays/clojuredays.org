(ns dcd-website.dcd2019
  (:require [dcd-website.location :refer    [tq-location-component]]
            [dcd-website.header :refer [header-component]]
            [dcd-website.agenda :refer [speakers-component agenda-component]]
            [dcd-website.coc :refer [code-of-conduct-component]]))

(defn about-component []
  [:div#about
   [:h2 "About DCD '19"]
   [:p "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands!"]
   [:p "We welcome you to the 4th edition of our  " [:b "free "] " and non-profit Clojure conference organised by the community, for the community with a full day of amazing talks in a friendly welcoming atmosphere. Reserve your free spot today!"]
   (comment  [:h2 "Sponsorship Packages"]
             [:p "If you want to support us and Clojure community, consider sponsoring us. Please get in touch via email events@clojuredays.org. We offer two affordable sponsorship packages, check them out: "]
             [:img {:src "img/2019/sponsor.png" :width "600px"}]
             [:img {:src "img/2019/partner.png" :width "600px"}])])

(defn cfp-component []
  [:div#cfp
   [:h2 "Call for Proposals"]
   [:p "Our CFP is now closed."]])

(defn sponsors-component []
  [:div.sponsors
   [:p "DCD is a free event that is made possible thanks to our amazing sponsors and volunteers."]
   [:a.sponsor.platinum {:href "https://flexiana.com/" :target :_blank}
    [:img {:src "img/2019/sponsors/flexiana.jpg" :alt "Flexiana"}]]
   [:a.sponsor.regular {:href "http://www.adgoji.com/" :target :_blank}
    [:img {:src "img/2019/sponsors/adgoji.svg" :alt "adgoji"}]]
   [:a.sponsor.regular {:href "http://www.metosin.fi/en" :target :_blank}
    [:img {:src "img/2019/sponsors/metosin.svg" :alt "Metosin"}]]
   [:a.sponsor.regular {:href "https://www.exoscale.ch/" :target :_blank}
    [:img {:src "img/2019/sponsors/exoscale.svg" :alt "Exoscale"}]]
   [:a.sponsor.regular {:href "https://vakantiediscounter.nl" :target :_blank}
    [:img {:src "img/2019/sponsors/devakantiediscounter.svg" :alt "VakantieDiscounter"}]]
   [:a.sponsor.regular {:href "https://infi.nl/" :target :_blank}
    [:img {:src "img/2019/sponsors/infi.svg" :alt "Infi"}]]
   [:a.sponsor.regular {:href "https://lunatech.com/" :target :_blank}
    [:img {:src "img/2019/sponsors/lunatech.svg" :alt "Lunatech"}]]
   [:a.sponsor.regular {:href "https://nedap.com" :target :_blank}
    [:img {:src "img/2019/sponsors/nedap.png" :alt "Nedap"}]]
   [:a.sponsor.regular {:href "https://data42.de" :target :_blank}
    [:img {:src "img/2019/sponsors/data42.svg" :alt "data42"}]]
   [:a.sponsor.regular {:href "https://cognitect.com" :target :_blank}
    [:img {:src "img/2019/sponsors/cognitect.svg" :alt "Cognitect"}]]])

(defn tickets-component []
  [:div#date
   [:h2 "Reserve your Spot"]
   [:p "DCD 2019 will be in Amsterdam on "
    [:b "Saturday on April 6th, 2019"] "! We are sold out - sorry!"]])

(def agenda-data
  [{:time ["8:30" "9:15"]
    :title "Reception"
    :type :org}

   {:time ["9:15" "9:30"]
    :title "Opening"
    :author "#DCD19 team"
    :type :org}

   {:time ["9:30" "10:15"]
    :author "Bozhidar Batsov"
    :title "nREPL Redux"
    :profile-pic "bbatsov.jpg"
    :description "After years of stagnation nREPL left Clojure Contrib and its development has resumed! It wasn’t easy, it took a lot of work, I learned many valuable lessons along the way, and I want to share all of this with you! This talk is going to examine the efforts that lead to restarting the active nREPL development in 2018, the current state of the project and the ambitious plans for its future. As almost all Clojure developers rely on nREPL in one way or another (e.g. cider-jack-in or lein repl), I believe that many of you might find this talk both interesting and informative! A maybe even fun! ;-)"
    :bio "Bozhidar is the maintainer of CIDER, nREPL and many Clojure libraries related to Clojure tooling. He’s also the editor of the community Clojure style guide. Most people would probably describe him as an Emacs zealot (and they would be right). He’s also quite fond of the Lisp family of languages, functional programming in general and Clojure in particular.
Believe it or not, Bozhidar has hobbies and interests outside the realm of computers, but we won’t bore with those here."
    :twitter "bbatsov"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["10:25" "11:10"]
    :author "Bahadir Cambel"
    :title "Building BNR Smart Radio & FD.nl Recommender system using Clojure & Serverless Architecture"
    :profile-pic "bcambel.jpg"
    :description "Managing servers and infrastructure is a costly, time consuming huge pain. This talk is going to demonstrate how Clojure is a perfect match for Serverless Architecture and how to max AWS capabilities to build your ultra-scale system without any frameworks."
    :bio "Software Architect & Lead Data Engineer @fd_nieuws #Clojure #Python distributed computing. Runner. Almost ultra-marathoner Freelancing for FD & Schiphol Runs more than he should."
    :twitter "bahadircambel"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["11:20" "12:05"]
    :author "Rakhim Davletkaliyev"
    :title "Decentralized evolutionary computation with Clojure and ClojureScript"
    :profile-pic "rdavletkaliyev.jpg"
    :description "Let’s get inspired by biological evolution and write a decentralized genetic algorithms framework entirely in Clojure and Cljs. Then let’s use it to casually tackle some NP-complete problems by combining the computing power of all devices of Clojure Day 2019 participants!"
    :bio "Software developer since 2010. Co-founder of Hexlet, an educational startup from Finland which is the home of 200k students who learn computer programming and software development, get hired and build cool stuff. In November 2019 resigned as CEO and about to launch something new. I organize free workshops and open lectures on programming and computing in Helsinki. Blog at rakhim.org."
    :twitter "freetonik"
    :type :talk
    :youtube-link nil}

   {:time ["12:05" "13:20"]
    :title "Lunch"
    :type :org
    :force-timeline-visible? true}

   {:time ["13:20" "14:05"]
    :author "Alex King"
    :title "How we migrated a complex JavaScript application to ClojureScript step-by-step"
    :profile-pic "aking.jpg"
    :description "As software evolves along with the languages and frameworks it is built upon, it’s easy to create a monster. This is the tale of tackling complexity at the heart of Exoscale, and how a data-driven approach with ClojureScript enabled us to seamlessly replace a JavaScript app without user outage."
    :bio "Alex King is a software engineer from the UK, currently based in Switzerland with Exoscale. He is passionate about delivering clean, well tested code, that is easy for others to understand. He is well experienced with over 15 years of software development, and adept at bridging the gap between the front-end and back-end teams. He was responsible for large rewrites of core architecture behind the BBC Sport and BBC News platforms, and worked as a consultant for JUXT, where he helped to develop a large Clojure(script) application used by traders at Credit Suisse, along with many years of Scala development before finding a home with Clojure. Away from the day job he can be found enjoying hammock time up in the mountains, or on stage in a dive bar with a guitar in hand."
    :twitter "superaking"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:title "Lightning Talks"
    :force-timeline-hidden? true
    :type :lightning}

   {:time ["14:15" "14:30"]
    :author "Heimo Laukkanen"
    :title "Clojure powered services at Finnish Broadcasting Company"
    :profile-pic "hlaukkanen.jpg"
    :description "Finnish Broadcasting Company runs the most loved streaming service in Finland. One enabler is the use of Clojure, which empowers teams to build and operate robust micro-services. This talk shares our experiences and learnings on how we have enabled developer success in our ecosystem since 2015."
    :bio "."
    :twitter "huima"
    :type :lightning
    :youtube-link nil}

   {:time ["14:30" "14:45"]
    :title "Discourje: Automatically validated message exchange patterns in Clojure."
    :profile-pic "rhamers.jpg"
    :author "Ruben Hamers"
    :description "The core.async library provides many high-level features for async programming, but does not protect against classical concurrency problems. Discourje extends core.async and offers high-level abstractions to define message exchange patterns that are run-time validated and enforced between threads."
    :bio "I got in touch with Clojure while reading about Java concurrency and was instantly fascinated by the elegance of Clojure’s syntax and macros. Inspired and enthused by previous research on high-level abstractions for MEPs (e.g., in Java, JavaScript, Rust, and Go), I initiated the Discourje project to bring such abstractions for the first time to Clojure. As a part-time master student at Open Universiteit, I am currently finishing my MSc thesis on Discourje (and its underlying formal theory!). In my full-time day-to-day job, I work as a software engineer at BlueTea (www.bluetea.nl) where we build virtual simulations and serious games."
    :twitter nil
    :type :lightning
    :youtube-link nil}

   {:time ["14:45" "15:00"]
    :title "Re-find: discover functions with spec"
    :profile-pic "borkdude.jpg"
    :author "Michiel Borkent"
    :description "Re-find is an app and a library that lets you interactively discover Clojure functions based on example in- and output values or predicates. In this talk we will see how it works and how it is implemented, using clojure.spec as the driving force."
    :bio "Michiel Borkent is a software developer and Clojurian. He can be found as @borkdude in various places on the web."
    :twitter "borkdude"
    :type :lightning
    :youtube-link nil}

   {:time ["15:00" "15:15"]
    :title "Future boot"
    :profile-pic "mratzke.jpg"
    :author "Matthew Ratzke"
    :description "Boot-clj is a powerful tool for any Clojure developer, find out about the new maintainers, and what we have planned for the future of boot. Here’s a hint: native images."
    :bio "Matt is a self-proclaimed Clojure Entrepreneur. Using Clojure as a foundation for his startups, matt is currently working on solutions for the Canadian cannabis industry. He is also the lead maintainer of boot-clj and contributes heavily to Hoplon and the boot-clj ecosystem."
    :twitter "degree9io"
    :type :lightning
    :youtube-link nil}
   #_{:time ["15:00" "15:15"]
      :title "TBD"
      :profile-pic "unknown.png"
      :author "TBD"
      :description "TBD"
      :bio "TBD"
      :twitter ""
      :type :talk
      :youtube-link nil}

   {:time ["15:15" "15:45"]
    :title "Coffee break"
    :type :org
    :add-padding true
    :force-timeline-visible? true}

   {:time ["15:45" "16:30"]
    :title "How I Supercharged Learning Clojure through Gamification"
    :profile-pic "mbeisaron.jpg"
    :author "Mey Beisaron"
    :description "Gamification can be an excellent way to reduce the barrier of entry & quickly learn new programming languages. This talk will dive into how through a simple game you can master new syntaxes by applying concepts from languages you know & leveraging shared libraries to ramp up your coding skills."
    :bio "Mey Beisaron is a public speaker, a Clojure, Java, and Node.js developer and a software engineering graduate. When she is not spending her weekends at hackathons, she experiments with algorithms or learns languages such as russian, french and italian. Mey is also a sworn star wars fan. May the force be with you."
    :twitter "ladymeyy"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["16:40" "17:25"]
    :title "The rise and fall of e2e testing at scale"
    :profile-pic "phillip.jpg"
    :author "Phillip Mates"
    :description "Last year I presented on single-service testing. This year I’d like to focus on how Nubank has evolved multi-service testing: our adoption & eventual abandonment of end-to-end tests; the rise of light-weight cross-service generative-based schema validation tests"
    :bio "Coming from a background in theoretical programming language research I’ve been coding Clojure at Nubank for the last 2 years. In this time I’ve become the maintainer of Midje, co-authored a library for validating nested data-structures that produces readable diffs (matcher-combinators), and participated in projects to scale Nubank’s testing infrastructure past 100 microservices. I’m currently focused on building data infrastructure out of Nubank’s small Berlin office."
    :twitter "philomates"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["17:35" "18:20"]
    :title "Growing a biomedical search engine in Clojure"
    :profile-pic "jkuipers.png"
    :author "Joël Kuiper"
    :description "Starting a new project is always hard. The blank pages stare at you. Sometimes you know what needs to be done, but sometimes the requirements are totally unknown. Three years ago Doctor Evidence decided to build a biomedical search engine, and this talk will be about our journey into the unknown."
    :bio "I once set out on doing academic research for a living, but then thought better of it. Received a Bachelor of Science degree in Artificial Intelligence from the University of Groningen, the Netherlands. I’m passionate about software development, user experience, and machine learning. Hobby astronomer by night."
    :twitter ""
    :type :talk
    :youtube-link nil}

   {:time ["18:20" "18:30"]
    :title "Closing"
    :author "#DCD19 team"
    :type :org}

   {:time ["18:30" "21:30"]
    :title "Networking/Drinks"
    :type :org}

   #_{:time ["19:00" "19:30"]
      :title "extemporay - REPL driven comedy"
      :profile-pic "ray.jpg"
      :author "Ray McDermott"
      :description "Learn how to compose a library of simple functions and data to deliver the most elegant forms of comedy on the Clojuresphere.
You will see how you can get feedback from something better than actual humans: the REPL"
      :bio "Clojure enthusiast: software architect by day, co-orgniser Belgian Clojure User group and co-host of defn podcast by night (some nights anyway)."
      :twitter "raymcdermott"
      :type :lightning
      :force-timeline-hidden? true}])

(defn when-component []
  [:div
   [:p"Dutch Clojure Days will happen on "
    [:b " Saturday April 6th, 2019"] "."]])

(defn main-component []
  [:article.main
   [:div#about
    (about-component)]
   [:div#date
    [:h2 "When?"]
    (when-component)]
   [:div#sponsors
    [:h2 "Sponsors"]
    (sponsors-component)]
   [:div#agenda
    [:h2 "Agenda"]
    (agenda-component agenda-data)]
   [:div#speakers
    [:h2 "Speakers"]
    (speakers-component agenda-data)]
   [:div#location
    [:h2 "Where?"]
    (tq-location-component)]
   [:div
    (tickets-component)]
   [:div#cfp
    (cfp-component)]
   [:div#behave
    [:h2 "Code of Conduct"]
    (code-of-conduct-component)]])

(def dcd2019-website-structure
  {:title "Dutch Clojure Days 2019"
   :main-component (main-component)})
