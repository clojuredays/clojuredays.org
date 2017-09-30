(ns dcd-website.credits)

(def dcd-team
  [["Carlo Sciolla" "skuro"]
   ["Vijay Kiran" "vijaykiran"]
   ["Max Gonzih" "gonzih"]
   ["Joost Diepenmaat" "ZeekatSoftware"]])

(defn credits []
  [:span
   [:div
    (letfn [(organizer [[name handle]]
              ^{:key handle}
              [:span.org-info
               [:a {:href (str "https://twitter.com/" handle)
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
