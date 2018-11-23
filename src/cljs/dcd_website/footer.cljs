(ns dcd-website.footer)

(def dcd-team
  [["Carlo Sciolla" "https://twitter.com/skuro"]
   ["Vijay Kiran" "https://twitter.com/vijaykiran"]
   ["Eugene Lukyanchuk" "https://github.com/agnivalent"]
   ["Joost Diepenmaat" "https://twitter.com/ZeekatSoftware"]
   ["Max Gonzih" "https://github.com/Gonzih"]])

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
       "@clojuredays"]]]

    [:div.col
     [:h3 "DCD team"]
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
      [:a {:href "https://twitter.com/moolver_sin"
           :target :_blank}
       "Lubov Soltan"]]]]])
