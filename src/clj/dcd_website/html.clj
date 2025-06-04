(ns dcd-website.html
  (:require [hiccup.page :refer [html5]]
            [dcd-website.header :refer [header-component]]
            [dcd-website.main :refer [content]]))

(defn page
  "Will create a full page from the content"
  [title content]
  (html5 {:lang "en"}
         [:meta {:charset "utf-8"}]
         [:meta {:content "width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no", :name "viewport"}]
         [:meta {:content "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands!", :name "description"}]
         [:title title]
         [:meta {:property "og:title" :content title}]
         [:meta {:property "og:image" :content "img/2019/logo.png"}]
         [:meta {:property "og:site_name", :content "clojuredays.org"}]
         [:meta {:name "og:description", :content "The Annual International Gathering of Clojure Enthusiasts and Practitioners in the Netherlands!"}]
         [:link {:type "text/css" :href "https://fontlibrary.org/face/Quicksand:200,300,400,500,700" :media "screen" :rel "stylesheet"}]
         [:link {:media "screen", :type "text/css", :rel "stylesheet", :href "css/main.css"}]
         [:link {:sizes "32x32" :href "img/fav.png" :rel "icon"}]
         [:link {:sizes "192x192" :href "img/fav.png" :rel "icon"}]
         [:link {:href "img/fav.png" :rel "apple-touch-icon-precomposed"}]
         [:link {:href "css/leaflet.css" :rel "stylesheet"}]
         [:link {:type "text/css" :href "css/cookieconsent.css" :rel "stylesheet"}]
         [:link {:type "text/css" :href "css/cookieconsent.override.css" :rel "stylesheet"}]
         content
         [:script {:src "js/leaflet.js" :type "text/javascript"}]
         [:script {:src "js/main.js" :type "text/javascript"}]
         (comment
           [:script {:src "js/eb_widgets.js" :type "text/javascript"}]
           [:script {:src "js/eventbright.js" :type "text/javascript"}]
           [:script {:src "js/cookieconsent.config.js" :type "module"}])))

(defn to-html
  "Will take a map with things like content and output a html file in the public folder."
  [{:keys [file-name title main-component]}]
  (spit (str "public/" file-name ".html")
        (page title (content (header-component title) main-component))))
