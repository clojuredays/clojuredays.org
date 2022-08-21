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
     [:img {:src "img/2022/sponsors/brightmotive.svg"}]]
    [:h3.package "Sponsor"]
    [:a.sponsor.regular {:href "https://www.eerlijkewoz.nl/" :target :_blank}
     [:img {:src "img/2022/sponsors/eerlijkewoz.svg"}]]
    [:a.sponsor.regular {:href "https://adgoji.bamboohr.com/jobs/" :target :_blank}
     [:img {:src "img/sponsors/adgoji.svg"}]]
    [:a.sponsor.regular {:href "https://www.metosin.fi/en/" :target :_blank}
     [:img {:src "img/2022/sponsors/metosin.svg"}]]
    [:h3.package "Friends and family"]
    [:a.sponsor.regular {:href "https://www.cloudpirates.nl/" :target :_blank}
     [:img {:src "img/2022/sponsors/cloudpirates.png"}]]]])

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
    :title "Cljoure + UI = ❤️"
    :profile-pic "tonsky.jpg"
    :description "The web became a de-facto way of building UIs these days. But is it good? Or fast?

I argue that the web has its unique features, but it also brings a lot of unnecessary complexity to desktop apps, both in performance, resource use, compatibility, and stability.

Another point is that REPL-driven development is a perfect environment for building UIs, which ClojureScript + Figwheel has proven. Zero time feedback loop + persistent state + no reloads == a blessing for any visual project, yet many modern tools get there.

Finally, in the true spirit of Clojure and JVM, write once, run anywhere means desktop apps should run the same on all platforms, respecting platforms but also giving a lot of common ground to share development efforts, just like Electron apps do.

I feel Clojure has a unique opportunity to lead a new era in GUI app development — cross-platform Clojure desktop apps.

In this talk, we’ll present Humble UI, a brand-new way of building desktop apps in Clojure that doesn’t rely on the web ecosystem or any of the existing cross-platform UI frameworks. Instead, it’s custom-tailored from the ground up for the interactivity and portability of Clojure.

We’ll talk about graphical stack, OS integration, layout, components and reuse, state management, and also some unique twists you probably always wanted in the UI framework but didn’t know to ask for."
    :bio "Clojure enthusiast, author of DataScript, Rum, Fira Code

Nikita has been programming in Clojure, Java, Python, Erlang for 17 years, been interested in UI/UX design for about the same amount of time, and created a few notable projects, including DataScript, Rum and Fira Code."
    :twitter "nikitonsky"
    :add-padding true
    :type :talk
    :youtube-link nil}

   {:time ["10:25" "11:10"]
    :author "TBD"
    :title "TBD"
    :profile-pic "../fav.png"
    :description [:a {:href "https://sessionize.com/dutch-clojure-days-2022/"} "Our CfP is open, submit your talk!"]
    #_#_:bio "N/A"
    :twitter "clojuredays"
    :add-padding true
    :type :placeholder
    :youtube-link nil}

   {:time ["11:20" "12:05"]
    :author "TBD"
    :title "TBD"
    :profile-pic "../fav.png"
    :description ""
    :bio ""
    :twitter "clojuredays"
    :type :skip
    :youtube-link nil}

   {:time ["12:05" "13:20"]
    :title "Lunch"
    :type :org
    :force-timeline-visible? true}

   {:title "Lightning Talks"
    :force-timeline-hidden? true
    :type :lightning}

   {:time ["14:15" "14:30"]
    :author "TBD"
    :title "TBD"
    :profile-pic "../fav.png"
    :description ""
    :bio ""
    :twitter "clojuredays"
    :type :skip
    :youtube-link nil}

   {:time ["14:30" "14:45"]
    :title "TBD"
    :profile-pic "../fav.png"
    :author "TBD"
    :description ""
    :bio ""
    :twitter "clojuredays"
    :type :skip
    :youtube-link nil}

   {:time ["14:45" "15:00"]
    :title "TBD"
    :profile-pic "../fav.png"
    :author "TBD"
    :description ""
    :bio ""
    :twitter "clojuredays"
    :type :skip
    :youtube-link nil}

   {:time ["15:00" "15:15"]
    :title "TBD"
    :profile-pic "../fav.png"
    :author "TBD"
    :description ""
    :bio ""
    :twitter "clojuredays"
    :type :skip
    :youtube-link nil}

   {:time ["15:15" "15:45"]
    :title "Coffee break"
    :type :org
    :add-padding true
    :force-timeline-visible? true}

   {:time ["15:45" "16:30"]
    :title "TBD"
    :profile-pic "../fav.png"
    :author "TBD"
    :description ""
    :bio ""
    :twitter "clojuredays"
    :add-padding true
    :type :skip
    :youtube-link nil}

   {:time ["16:40" "17:25"]
    :title "TBD"
    :profile-pic "../fav.png"
    :author "TBD"
    :description ""
    :bio ""
    :twitter "clojuredays"
    :add-padding true
    :type :skip
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
    :bio "Michiel Borkent, also known as @borkdude on the web, is an open source software developer who loves Clojure. He is the author of clj-kondo, babashka, SCI, nbb and other tools that you might have heard of. When he is not coding, he likes to go for a walk outdoors or eat vegetables!"
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
    [:p "The agenda below is just an indication as " [:a {:href "https://sessionize.com/dutch-clojure-days-2022/"} "our CfP is still ongoing!"]]
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
