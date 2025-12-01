(ns dcd-website.footer)

(def dcd-team
  [["Carlo Sciolla"      "https://codehopper.nl"]
   ["Joost Diepenmaat"   "https://jomco.nl/"]
   ["Remco van 't Veer" "https://jomco.nl/"]])

(defn footer-component []
  [:footer.footer

   [:aside.sidebar]

   [:article.main
    [:div.col
     [:h3 "Official contacts"]
     [:span.email-info
      [:a {:href "mailto:events@clojuredays.org"}
       "events@clojuredays.org"]]
     [:span.org-info
      [:a {:href "https://twitter.com/clojuredays"}
       "@clojuredays"]]
     [:span.org-info
      [:a {:rel "me"
           :href "https://functional.cafe/@clojuredays"}
       "@clojuredays@functional.cafe"]]]

    [:div.col
     [:h3 "ClojureDays foundation"]
     [:span
      [:div
       (letfn [(organizer [[name link]]
                 ^{:key link}
                 [:span.org-info
                  [:a {:href link
                       :target :_blank}
                   name]])]
         (map organizer dcd-team))]]]

    [:div.col
     [:h3 "Design & Art"]
     [:span
      [:a {:href "https://artistlubov.cohart.com/"
           :target :_blank}
       "Lubov Soltan"]]]]])
