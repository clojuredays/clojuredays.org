(ns dcd-website.dcd2018
  (:require [dcd-website.map :refer    [location-component]]
            [dcd-website.header :refer [header-component]]
            [dcd-website.style :refer   [colors]]
            [dcd-website.footer :refer [footer-component]]
            [dcd-website.agenda :refer  [speakers-component agenda-component]]
            [dcd-website.coc :refer [code-of-conduct-component]]
            [dcd-website.credits :refer [credits]]))

(defn header-component-2018
  []
  (header-component {:title "Dutch Clojure Days 2018"}))

(defn about-component []
  [:div#about
   [:h2 "About DCD18"]
   [:p "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands!"]] )

(defn cfp-component []
  [:div#cfp
   [:h2 "Call for papers"]
   [:p "Our CFP is now officially closed."]])

(defn sponsors-component []
  [:div.sponsors
   [:p "DCD is a free event that is made possible thanks to our amazing sponsors and volunteers."]
   [:h2.platinum "Platinum sponsors"]
   [:a.sponsor.platinum {:href "http://www.adgoji.com/" :target :_blank}
    [:img {:src "img/2018/sponsors/adgoji.svg"}]]
   [:a.sponsor.platinum {:href "http://www.metosin.fi/en" :target :_blank}
    [:img {:src "img/2018/sponsors/metosin.svg"}]]
   [:a.sponsor.platinum {:href "https://www.exoscale.ch/" :target :_blank}
    [:img {:src "img/2018/sponsors/exoscale.svg"}]]
   [:a.sponsor.platinum {:href "https://synple.eu/en/index" :target :_blank}
    [:img {:src "img/2018/sponsors/synple.png"}]]

   [:h2.regular "Regular Sponsors"]
   [:a.sponsor.regular.infi {:href "https://infi.nl/" :target :_blank}
    [:img {:src "img/2018/sponsors/infi.svg"}]]
   [:a.sponsor.regular {:href "https://www.brightin.nl/" :target :_blank}
    [:img {:src "img/2018/sponsors/brightin.png"}]]
   [:a.sponsor.regular.alliander {:href "https://www.alliander.com/en" :target :_blank}
    [:img {:src "img/2018/sponsors/alliander.png"}]]])

(defn tickets-component []
  [:div#date
   [:h2 "Reserve your Spot"]
   [:p "DCD 2018 will be in Amsterdam on "
    [:b "Saturday April 21st, 2018"] "! Get your ticket now!"]
   [:div
    [:a {:href "https://www.eventbrite.com/e/dutch-clojure-day-2018-tickets-41749338395?ref=ebtnebregn" :target "_blank"}
     [:img {:src "https://www.eventbrite.com/custombutton?eid=41749338395" :alt "Eventbrite - Dutch Clojure Day 2018"}]]]])

(def agenda-data
  [{:time ["8:30" "9:15"]
    :title "Reception"
    :type :org}

   {:time ["9:15" "9:30"]
    :title "Opening"
    :author "#DCD18 team"
    :type :org}

   {:time ["9:30" "10:15"]
    :title "Embrace the JVM"
    :author "Alexander Yakushev"
    :profile-pic "alexander.jpg"
    :description "JVM is the native platform for Clojure, yet a lot of its tools and tricks are unfamiliar to Clojure programmers. This talk will bring them to light and show you how the JVM facilities can make your Clojure work even more productive."
    :bio "Alexander is a software engineer at Grammarly where he blurs the line between programming and natural languages. After being bitten by a radioactive spider with a lambda on its back, Alexander promised to use the obtained Lisp superpowers for good only. In his free time, he contributes to Clojure tooling like CIDER, studies distributed systems, and fills his half-full stack."
    :twitter "unlog1c"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["10:25" "11:10"]
    :title "Online statistical analysis using transducers and sketch algorithms"
    :profile-pic "simon.jpg"
    :author "Simon Belak"
    :description "Online statistical analysis using transducers and sketch algorithms. Don’t know what either is? You are going to learn something very cool (and perspective-changing) then. Know them, but want an experience report? Got you covered, fam."
    :bio "Built my first computer out of Lego bricks and learned to program soon after. Emergence, networks, modes of thought, limits of language and expression are what makes me smile (and stay up at night). The combination of lisp and machine learning put me on the path of always striving to make myself redundant if not outright obsolete. Currently working hard to become obsolete at Metabase where I am trying to build an artificial data scientist and imbue visualisations with understanding and context."
    :twitter "sbelak"
    :add-padding true
    :type :talk
    :youtube-link nil}

   #_{:time ["11:20" "12:05"]
    :title ""
    :profile-pic ""
    :author ""
    :description ""
    :bio ""
    :twitter ""
    :type :talk
    :youtube-link nil}

   {:time ["12:05" "13:20"]
    :title "Lunch"
    :type :org
    :force-timeline-visible? true}

   {:time ["13:20" "14:05"]
    :title "Implementing Graph API's with Clojure"
    :profile-pic "wilker.jpg"
    :author "Wilker Lúcio"
    :description "REST is taking a rest. Over the past years we are seeing a huge growth of graph API’s with GraphQL leading the way. In this talk I will describe what graph APIs can look like on the Clojure side, and even show you how to achieve the best of both worlds by integrating GraphQL with Clojure graphs!"
    :bio "I’m a passionate developer working and learning programming skills since 12 years old, love the way of web development and always researching new technologies. I started real web programming with PHP, but ever trying to learn more and more (passing through Java, Python, C#, ActionScript, Javascript…), currently passionate about Clojure and it’s ecosystem. In recent years I’ve been engaged in the Clojure community, collaborating in projects like Om.next/Fulcro, Devcards, and writing libraries like Pathom. If you’d like to learn more about my work, please check my Github profile at https://github.com/wilkerlucio."
    :twitter "wilkerlucio"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:title "Lightning Talks"
    :force-timeline-hidden? true
    :type :lightning}

   {:time ["14:15" "14:30"]
    :title "Easier REPL-based debugging with scope-capture"
    :profile-pic "val.jpg"
    :description "Tired of manually re-creating Ring requests, app states and database connections simply to evaluate this tiny expression at the REPL? Scope-capture to the rescue, a new Clojure(Script) library that lets you instantly save and restore local bindings at the REPL."
    :author "Valentin Waeselynck"
    :bio "Valentin Waeselynck is the CTO of BandSquare, a platform providing web and CRM tools for managing audiences, built on top of Clojure and Datomic. He authored a few open-source libraries for Clojure and Datomic, including Datomock, scope-capture and Datofu. On the side, he enjoys doing maths and climbing mountains."
    :twitter "val_waeselynck"
    :type :lightning
    :youtube-link nil}

   {:time ["14:30" "14:45"]
    :title "REPtiLe - exercise your lizard brain and share REPLs in a cold-blooded browser"
    :profile-pic "ray.jpg"
    :author "Ray McDermott"
    :description "Use REPtiLe to have your own REPL on the web and also see what your team are doing in their REPLs.

REPtiLe is ideal for a small number of developers to work together in real-time."
    :bio "Clojure developer / architect. co-host defn podcast and the apropos youtube channel"
    :twitter "raymcdermott"
    :type :lightning
    :youtube-link nil}

   #_{:time ["14:45" "15:00"]
    :title "Surprise! A collection of unexpected behavior in Clojure"
    :profile-pic "jens.jpg"
    :author "Jens Bendisposto"
    :description [:span "Do you know that " [:pre {:style {:display "inline"}} "(sorted? [1 2 3])"] " evaluates to " [:pre {:style {:display "inline"}} " false"] "? In my talk I will show some funny quirks and little inconsistencies in Clojure that may take you by surprise."]
    :bio "Jens is in a relationship with Clojure for more than 7 years and he is still in love despite the little quirks he discovered. Jens teaches a yearly course on functional programming with Clojure at the University of Düsseldorf since 2013 and he is one of the organizers of the Düsseldorf Clojure User Group, the Java User Group and the Lambda Düsseldorf Meetup."
    :twitter "jbendisposto"
    :type :lightning
    :youtube-link nil}

   #_{:time ["15:00" "15:15"]
    :title "Stay agile with clojure.spec"
    :profile-pic "unknown.png"
    :author "Dr Roland Kay"
    :description "You love the sense of liberation and control that Clojurescript gives you and you want the same for your data. A schema for your in-memory data will enable you to change it quickly with confidence. So, the next time that your product manager drops a last minute change request, it will be no stress."
    :bio "Dr Kay has over ten years experience working in investment banking in London developing financial models and delivering tools which depend on them to trading desks. He came of age with asm, C and C++ and has been using dynamically typed languages to put the power of the core analytics written in C++ in the hands of practitioners who lack extensive software development experience.

He has recently discovered the power of functional programming to tame the complexity of front-end development. He is impressed by the ability of clojure.spec to exceed the level of confidence in code integrity that comes with statically-typed languages while retaining the flexibility and fast-prototyping offered by dynamic languages."
    :twitter nil
    :type :lightning
    :youtube-link nil}

   {:time ["15:15" "15:45"]
    :title "Coffee break"
    :type :org
    :add-padding true
    :force-timeline-visible? true}

   {:time ["15:45" "16:30"]
    :title "No EC2 instances were harmed during this deployment"
    :profile-pic "josh.jpg"
    :author "Josh Glover"
    :description "Serverless systems promise a bright future of increased battery life for on-call developers’ phones, but do they deliver? This is a story of how we built a backend with Clojure, API Gateway, Lambda, and DynamoDB. Takeaway: when, where, or if this approach fits your problems."
    :bio "Josh Glover has come a long way since declaring Lisp a completely pointless language in university. 15 years and three countries later, he shudders at the very thought of using a language other than Clojure. He is really interested in teaching programming and increasing diversity in the industry. He currently lives in Stockholm and works for Klarna Bank AB, the leading payments company in the Nordics."
    :twitter "jmglov"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["16:40" "17:25"]
    :title "How we test at Nubank"
    :profile-pic "phillip.jpg"
    :author "Phillip Mates"
    :description "Nubank has been shipping business-critical Clojure services for 5+ years. To do so reliably we’ve adopted various approaches to testing, combining unit, integration, & end-to-end tests. This talk will explore our experiences: what’s worked, what hasn’t, and where we are going next with testing"
    :bio "Coming from a background in theoretical programming language research I’ve been coding Clojure at Nubank for over a year. In this time I’ve become the maintainer of Midje, co-authored a library for validating nested data-structures that produces readable diffs (matcher-combinators), and participated in projects to scale Nubank’s testing infrastructure past 100 microservices. Last Fall I moved to Berlin to help Nubank open its first office outside of Brazil. In Berlin, my colleagues and I are focused on building data infrastructure for São Paulo-based analysts and engineers to use."
    :twitter "pmatey"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["17:35" "18:20"]
    :title "5 years of Clojure: building better infrastructure with parentheses"
    :profile-pic "pierre.jpg"
    :author "Pierre-Yves Ritschard"
    :description "This talk gives an overview of the initial architectural decisions at Exoscale, an Infrastructure as a Service company where Clojure is in heavy use."
    :bio "Pierre-Yves is CTO at exoscale where he is responsible for architecture and strategic technology choices, relying on experience in the architecture of very large corporate systems as well as technical product design in several startups.

Pierre-Yves is an active member of the open-source community as author of pithos and cyanite as well as key contributions to OpenBSD, collectd and riemann amongst others."
    :twitter "pyr"
    :type :talk
    :youtube-link nil}

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

(defn main-component []
  [:article.main
   [about-component]
   [cfp-component]
   [tickets-component]
   [:div#location
    [:h2 "Where?"]
    [location-component {:coords [52.3666451 4.892396599999984]}]]
   [:div#sponsors
    [:h2 "Sponsors"]
    [sponsors-component]]
   [:div#agenda
    [:h2 "Agenda"]
    [:p "TBD"]
    #_[agenda-component agenda-data]]
   [:div#speakers
    [:h2 "Speakers"]
    [speakers-component agenda-data]]
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
