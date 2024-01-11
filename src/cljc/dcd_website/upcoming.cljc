(ns dcd-website.upcoming)

(defn about-component []
  [:div#about
   [:h2 "About Dutch Clojure Days"]
   [:p "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands! We are the #1 " [:b "free "] " and non-profit Clojure conference in the world, organised by the community, for the community with a full day of amazing talks in a friendly, welcoming atmosphere."]
   [:p "We don't have a conference planned yet, "
    [:a {:href "https://twitter.com/clojuredays"}
     "stay tuned"] " for updates!"]])

(defn main-component []
[:article.main
 (about-component)])

(def upcoming-website-structure
{:title          "Dutch Clojure Days"
 :main-component (main-component)})
