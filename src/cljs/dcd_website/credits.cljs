(ns dcd-website.credits)

(def dcd-team
  [["Carlo Sciolla" "https://twitter.com/skuro"]
   ["Vijay Kiran" "https://twitter.com/vijaykiran"]
   ["Eugene Lukyanchuk" "https://github.com/agnivalent"]
   ["Joost Diepenmaat" "https://twitter.com/ZeekatSoftware"]
   ["Max Gonzih" "https://github.com/Gonzih"]])

(defn credits []
  [:span
   [:div
    (letfn [(organizer [[name link]]
              ^{:key link}
              [:span.org-info
               [:a {:href link
                    :target :_blank}
                [:img.icon.twitter {:src "img/icons/twitter.svg"}]
                name]])]
      (map organizer dcd-team))]
   [:h3 "Design & Art"]
   [:span.org-info
    [:a {:href "https://twitter.com/moolver_sin"
         :target :_blank}
     [:img.icon.twitter {:src "img/icons/twitter.svg"}]
     "Lubov Soltan"]]])
