(ns dcd-website.dcd2022
  (:require [dcd-website.location :refer [cloud-pirates-location-component]]
            [dcd-website.agenda :refer [speakers-component agenda-component]]
            [dcd-website.coc :refer [code-of-conduct-component]]))

(defn about-component []
  [:div#about
   [:h2 "About DCD 2022"]
   [:p "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands! We welcome you to the 6th edition of our " [:b "free "] " and non-profit Clojure conference organised by the community, for the community with a full day of amazing talks in a friendly welcoming atmosphere."]])

(defn cfp-component []
  [:div#cfp
   [:h2 "Call for Proposals"]
   [:p "Our CFP is open until August 15th, 2022."]
   [:p "You can submit your proposal at " [:a {:href "https://sessionize.com/dutch-clojure-days-2022/"} "Sessionize"] "."]
   [:p "We look forward to receive your groudbreaking, breathtaking, parenssurfing proposals on topics such as (but not limited to) real-world experiences and lessons learned from putting your clojure(script) applications to production, fancy new library tool that just landed on the clojure planet, etc. Be creative!"]])

(defn tickets-component []
  [:div#tickets
   [:h2 "Tickets"]
   [:p "The conference is currently sold out, but fear not! As a free event, it often happens that tickets become available later during to cancellations. "
    [:a {:href "https://twitter.com/clojuredays"}
     "Stay tuned"] " for updates!"]
   [:p "In the meanwhile you can always join the waitlist"
    #_[:a {:href "https://www.eventbrite.com/e/dutch-clojure-day-2022-tickets-380638669507"} " join the waiting list"] " so you can get in as soon as a spot frees up."]
   #_[:p "Tickets for the conference are free of charge. You can reserve your spot on Eventbrite:"]
   [:div#eventbrite-widget-container-380638669507]
   [:button#eventbrite-widget-modal-trigger-380638669507 {:type "button"} "Reserve your spot"]])

(defn sponsor-packages-component []
  [:div#packages
   [:h2 "Sponsorship Packages"]
   [:p "If you want to support us and Clojure community, consider sponsoring us. We offer two affordable sponsorship packages, check them out:"]
   [:a {:href "img/2022/partner.png" :target "none"}
    [:img {:src "img/2022/partner.png" :style "width: 100%; height: auto; max-width: 600px"}]]
   [:br]
   [:a {:href "img/2022/sponsor.png" :target "none"}
    [:img {:src "img/2022/sponsor.png" :style "width: 100%; height: auto; max-width: 600px"}]]
   [:p "If you want to support and engage with the Dutch Clojure Days community, please get in touch via email at " [:a {:href "mailto:events@clojuredays.org"} "events@clojuredays.org"] "."]])

(defn when-component []
  [:div#date
   [:h2 "When?"]
   [:p "Dutch Clojure Days will happen on "
    [:b " Saturday, October 29th, 2022"] "."]])

(defn where-component []
  [:div#location
   [:h2 "Where?"]
   (cloud-pirates-location-component)])

(defn sponsors-component []
  [:div#sponsors
   [:h2 "Sponsors"]
   [:div.sponsors
    [:p "DCD is a free event that is made possible thanks to our amazing sponsors and volunteers."]
    [:h3.package "Partner"]
    [:a.sponsor.platinum {:href "https://www.brightmotive.com/company/careers/" :target :_blank}
     [:img {:src "img/2022/sponsors/brightmotive.svg" :alt "Brightmotive"}]]
    [:a.sponsor.platinum {:href "https://juxt.pro" :target :_blank}
     [:img {:src "img/2022/sponsors/juxt.svg" :alt "JUXT"}]]
    [:a.sponsor.platinum {:href "https://flexiana.com/" :target :_blank}
     [:img {:src "img/2022/sponsors/flexiana.png" :alt "Flexiana"}]]
    [:a.sponsor.platinum {:href "https://freshcodeit.com/services/clojure-development-company" :target :_blank}
     [:img {:src "img/2022/sponsors/freshcode.svg" :alt "Freshcode"}]]
    [:h3.package "Sponsor"]
    [:a.sponsor.regular {:href "https://www.eerlijkewoz.nl/" :target :_blank}
     [:img {:src "img/2022/sponsors/eerlijkewoz.svg" :alt "Eerlijke WOZ"}]]
    [:a.sponsor.regular {:href "https://adgoji.bamboohr.com/jobs/" :target :_blank}
     [:img {:src "img/2022/sponsors/adgoji.png" :alt "adgoji"}]]
    [:a.sponsor.regular {:href "https://www.metosin.fi/en/" :target :_blank}
     [:img {:src "img/2022/sponsors/metosin.svg" :alt "Metosin"}]]
    [:h3.package "Friends and family"]
    [:a.sponsor.regular {:href "https://www.cloudpirates.nl/" :target :_blank}
     [:img {:src "img/2022/sponsors/cloudpirates.png" :alt "Cloud Pirates"}]]]])

(def agenda-data
  [{:time ["8:30" "9:15"]
    :title "Reception"
    :type :org}

   {:time ["9:15" "9:30"]
    :title "Opening"
    :author "#DCD22 team"
    :type :org}

   {:time ["9:30" "10:15"]
    :author "Nikita Prokopov"
    :title "Clojure + UI = ❤️"
    :profile-pic "tonsky.jpg"
    :description "The web became a de-facto way of building UIs these days. But is it good? Or fast?
<br />
I argue that the web has its unique features, but it also brings a lot of unnecessary complexity to desktop apps, both in performance, resource use, compatibility, and stability.
<br />
Another point is that REPL-driven development is a perfect environment for building UIs, which ClojureScript + Figwheel has proven. Zero time feedback loop + persistent state + no reloads == a blessing for any visual project, yet many modern tools get there.
<br />
Finally, in the true spirit of Clojure and JVM, write once, run anywhere means desktop apps should run the same on all platforms, respecting platforms but also giving a lot of common ground to share development efforts, just like Electron apps do.
<br />
I feel Clojure has a unique opportunity to lead a new era in GUI app development — cross-platform Clojure desktop apps.
<br />
In this talk, we’ll present Humble UI, a brand-new way of building desktop apps in Clojure that doesn’t rely on the web ecosystem or any of the existing cross-platform UI frameworks. Instead, it’s custom-tailored from the ground up for the interactivity and portability of Clojure.
<br />
We’ll talk about graphical stack, OS integration, layout, components and reuse, state management, and also some unique twists you probably always wanted in the UI framework but didn’t know to ask for."
    :bio "<b>Clojure enthusiast, author of DataScript, Rum, Fira Code</b>
<br />
Nikita has been programming in Clojure, Java, Python, Erlang for 17 years, been interested in UI/UX design for about the same amount of time, and created a few notable projects, including DataScript, Rum and Fira Code."
    :twitter "nikitonsky"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["10:25" "11:10"]
    :author "Paula Gearon"
    :title "A Library Reckoning"
    :profile-pic "gearon.jpg"
    :description "Clojure was about to release a namespace for doing math, but only on the JVM. Why not ClojureScript as well? When I asked, the answer was that Java offered certain mathematical guarantees. Could ClojureScript offer the same?
The answer turned out to be a lesson in IEEE 754 floating-point numbers; a question of portability between JavaScript and Java; a framework for cross platform testing; discovery of bugs in Clojure; optimizing ClojureScript for the compiler; the ClojureScript contribution process; and finally, renaming the clojure.java.math namespace, along with the creation of a new namespace for ClojureScript.
<br />
This talk will be an introduction to these topics for people who haven't seen them before, and possibly have some interesting things for more advanced developers as well."
    :bio "<b>Ontology Architect at IMO, and Graph database enthusiast, and Clojurista</b>
<br />
An avid Clojure developer, Paula likes to work in the most technical parts of a system building the infrastructure that lets other developers do their jobs. She has been the technical lead on several commercial and open source projects, with a focus on data storage and processing, and was a lead editor for the SPARQL standard for accessing RDF databases. When not coding, she does triathlons, cooks, helps her children with homework, and mentors and supports young members of Women Who Code. Originally from Australia, she currently lives with her family in Virginia, in the USA."
    :twitter "quoll"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["12:05" "14:15"]
    :title "Lunch"
    :type :org
    :force-timeline-visible? true}

   {:title "Lightning Talks"
    :force-timeline-hidden? true
    :type :lightning}

   {:time ["14:15" "14:30"]
    :author "Daniel Janus"
    :title "Golfing Clojure: Check Checker under 280 characters of Clojure"
    :profile-pic "djanus.jpg"
    :description "I spent one hot July weekend solving a CodeWars challenge: write a program to find out whether the king is in check on a given chessboard. The trick? Squeeze it in fewer than 280 characters of Clojure code.
<br />
It was a lot of fun! In this talk, I’d like to share some of that fun with the audience. We’ll see some _very_ dirty tricks and experience some ‘aha!’ moments along the way to squeeze out just another handful of bytes. And again, and again, until we make it."
    :bio "<b>Code cruncher at Fy!</b>
<br />
Daniel has been in love with functional programming ever since his uni days, and in Clojure since before Leiningen was a thing. That is to say, pretty much forever.
<br />
He enjoys cycling, reading, playing Scrabble and spending time with cats (though not necessarily the other way round)."
    :twitter "nathell"
    :type :lightning
    :youtube-link nil}

   {:time ["14:30" "14:45"]
    :title "Sorry For The Convenience: The Importance of Progressive Enhancement"
    :profile-pic "bwalsh.png"
    :author "Brendon Walsh"
    :description "A summary of progressive enhancement techniques and how breaking GUI changes can be just as harmful to users as breaking API changes are to developers."
    :bio "<b>Software Developer</b>
<br />
Software Developer for 15 years (Clojure for 9). Accessibility extremist and web archival enthusiast."
    #_#_:twitter "clojuredays"
    :type :lightning
    :youtube-link nil}

   {:time ["14:45" "15:00"]
    :title "tagfl, task analysis generated from lisp"
    :profile-pic "asiegfried.jpg"
    :author "Adrien Siegfried"
    :description "Task analysis is an effective tool to capture the why and how's of a business requirement. Although some efforts are made to make this analysis more readable and capable of representing objects in use - such as the HAMSTERS notation, building such graphs are yet a challenge. A new approach is to consider the automatic generation of such graphs by using a graph visualization tool such as graphviz.
<br />
Tagfl is a lisp interpreter that aggregates multiple s-expressions describing tasks and automatically generates the corresponding graph. This approach helps designers create well-formatted, versionable and extendable task analyses.
It opens the possibility to generate documentation automatically while taking minutes from an interview.
<br />
This talk will go through what and how to use task analysis, followed by a live demo of a task analysis being generated with tagfl."
    :bio "<b>Founder of UXlambda</b>
<br/>
From UX designer to Clojure developer, I have been helping companies build user-centred web applications for 6 years as an independent consultant.
<br />
One of my key contributions is with the Starling web portal, an Airbus and Earthworm collaboration to help companies fight deforestation with satellite imagery and supply-chain knowledge: a contribution highlighted at the SIG 2019 conference where I have talked about how to include design principles into gis application.
<br />
Currently, I am building Daisy, a tool that transforms Figma design into a React library; my take on the gap between design and development."
    #_#_:twitter "clojuredays"
    :type :lightning
    :youtube-link nil}

   {:time ["15:00" "15:15"]
    :title "Clojupedia, linking the Clojure ecosystem"
    :profile-pic "ahelins.png"
    :author "Adam Helins"
    :description "A new initiative funded by Clojurists Together, Clojupedia aims to bridge our rich ecosystem by using personal knowledge management software in a non-personal fashion. We shall have a quick look at how we can centralize our libraries and tools to make them easily searchable. More importantly, link all those pieces together to make them discoverable."
    :bio "<b>Founder of Protosens SRL</b>
<br/>
After navigating through the Clojure ecosystem for many years, Adam Helins founded Protosens, a consulting company notably specialized in this wonderful language. He is also actively working on Convex.world, a super fast blockchain heavily inspired by Clojure constructs."
    :twitter "adamhelins"
    :type :lightning
    :youtube-link nil}

   {:time ["15:15" "15:45"]
    :title "Coffee break"
    :type :org
    :add-padding true
    :force-timeline-visible? true}

   {:time ["15:45" "16:30"]
    :title "Automated Correctness Analysis for core.async"
    :profile-pic "../fav.png"
    :author "Sung-Shik Jongmans"
    :description "It's been over nine years ago since Rich Hickey wrote the first blog post on the core.async library. At the time, Rich already hinted at the potential for \"automated correctness analyses\" but also stated that \"no work has been done on that front for core.async as yet\". To celebrate almost a decade of channels in Clojure, let's take another swing at this!
<br />
In this talk, I'll present the Discourje project. In a nutshell, the project allows Clojure programmers to specify communication patterns for core.async usage (as a kind of textual sequence diagrams), after which a run-time monitor can automatically verify channel traffic for compliance. The main correctness guarantee is safety: puts/takes that are forbidden by the spec never take effect (an exception is thrown instead). The project has mathematical foundations and originates from research on type systems in Computer Science, but that's all outside the scope of this talk."
    :bio "<b>Assistant professor at Open University of the Netherlands</b>
<br/>
Sung-Shik Jongmans is assistant professor at Open University of the Netherlands and researcher at the Dutch National Research Institute for Mathematics and Computer Science (CWI, Amsterdam). His interests include programming languages, concurrency theory, and software engineering. Since he met Clojure a few years back, he's been excited to use the language to explore new research ideas. His long term aim: to make concurrent programming easier."
    #_#_:twitter "clojuredays"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["16:40" "17:25"]
    :title "Got a Guru?"
    :profile-pic "jmiller.jpg"
    :author "Jordan Miller"
    :description "Do you have a mentor? You definitely should. Guidance and mentorship is essential to growth and is relevant during all stages of an engineer’s career. Intentionally forming and maintaining these types of positive relationships ensures your professional progression and inspires a sense of well-being. Giving and receiving knowledge has a trickle down effect that touches and changes lives. Engaging in this practice can be one of the most impactful things that you do.
<br />
For some folks, establishing this type of interpersonal connection comes less naturally, especially as we advance in our careers. Going beyond *why* seeking and offering guidance is vital, we’ll explore *how* to form this type of alliance from an architect's perspective. Visualizing how to build, integrate and sustain these processes so that kinship based on meaningful knowledge sharing becomes second nature. Illustrating practices that work on an individual level and that have the propensity to scale to create a culture of mentorship within any group, community or company.
<br />
At Vouch.io we've carefully cultivated this kind of culture organically and would love to share our secrets with the larger clj(s) community!"
    :bio "<b>Software Engineer at Vouch.io</b>
<br />
Jordan Miller is an autodidact, a she/her, a modern dev, a dev for the millennium. She enjoys cats, clojure(script) and community building. Sometimes known by her online pseudonym \"Lambduhh\" she is a Cognitect sponsored content creator, podcast host, conference speaker and organizer (and soon to be author!) She resides in sunny Sarasota, FL where you may catch her spinning fire hoop, doing aerial dance, practicing circus arts or inspiring others by producing instructional technical content on multiple platforms. Here are some places to find her content https://linktr.ee/lambduhhh"
    :twitter "lambduhh"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["17:35" "18:20"]
    :title "ClojureScript reimagined"
    :profile-pic "borkdude.jpg"
    :author "Michiel Borkent"
    :description "For the last three years I've occupied myself mostly with building new Clojure tooling and libraries: clj-kondo, babashka, nbb, etc. These tools opened up use cases for Clojure(Script) that were previously less feasible and also attracted new audiences to Clojure. With babashka it is very easy to sneak in a small script at your non-Clojure job. Similar for nbb: writing a Node script for your colleagues who just use NPM became easy.
<br />
What if we could pull off the same trick with ClojureScript in the browser?
<br />
What if sneaking in a little bit of ClojureScript into a JavaScript project was as easy as installing one extra library in your package.json? What if interop between JavaScript and .cljs files was seamless? What if JS devs could still use Node for all your tooling and didn't have to pull in a JVM? What if you could publish libraries with compiled CLJS to NPM that all share the same CLJS core functions?
<br />
Would this increase the adoption of ClojureScript in the mainstream? Would this approach be helpful to existing ClojureScript users for a new category of projects? In this talk we're getting a glimpse of what that may look like."
    :bio "<b>Clojure OSS developer</b>
<br/>
Michiel Borkent, also known as @borkdude on the web, is an open source software developer who loves Clojure. He is the author of clj-kondo, babashka, SCI, nbb and other tools that you might have heard of. When he is not coding, he likes to go for a walk outdoors or eat vegetables!"
    :twitter "borkdude"
    :type :talk
    :youtube-link nil}

   {:time ["18:20" "18:30"]
    :title "Closing"
    :author "#DCD22 team"
    :type :org}

   {:time ["18:30" "21:30"]
    :title "Networking/Drinks"
    :type :org}])

(defn main-component []
  [:article.main
   (about-component)
   (when-component)
   (where-component)
   (tickets-component)
   (cfp-component)
   (sponsors-component)
   #_(sponsor-packages-component)
   [:div#agenda
    [:h2 "Agenda"]
    #_[:p "The agenda below is just an indication as " [:a {:href "https://sessionize.com/dutch-clojure-days-2022/"} "our CfP is still ongoing!"]]
    (agenda-component agenda-data)]
   [:div#speakers
    [:h2 "Speakers"]
    (speakers-component agenda-data)]
   [:div#behave
    [:h2 "Code of Conduct"]
    (code-of-conduct-component)]])

(def dcd2022-website-structure
  {:title          "Dutch Clojure Days 2022"
   :main-component (main-component)})
