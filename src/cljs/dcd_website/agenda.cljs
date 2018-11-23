(ns dcd-website.agenda)

(defn table-row [{:keys [title time author type]}]
  (let [[start end] time]
    ^{:key (str time author)}
    [:tr
     [:td.time
      (when start [:p.start start])
      (when end [:p.end end])]
     [:td {:col-span (if author 1 2)} [:a {:href (str "#" title)} title]]
     (when author
       [:td author])]))

(defn agenda-component [agenda-data]
  [:div.agenda
   [:table {:cell-spacing 0}
    [:tbody
     (doall (map table-row agenda-data))]]])

(defn speaker-component [{:keys [author description title type profile-pic bio twitter youtube-link]}]
  ^{:key author}
  [:div.speaker
   [:div.name
    [:img {:src (str "img/speakers/" profile-pic)}]
    (when twitter
      [:a.twitter-link {:href (str "https://twitter.com/" twitter) :target :_blank}
       [:span.twitter-handle (str "@" twitter)]])
    [:h3 author]]
   [:div.info
    [:h3.title {:id title}
     (when (= :lightning type)
       [:span.lightning "lightning talk"])
     title]
    [:div.description description]
    (when bio [:div.bio "About the speaker: " bio])
    (when youtube-link
      [:a.youtube-link {:href youtube-link
                        :target :_blank}
       "Watch on YouTube"])]])

(defn speakers-component [agenda-data]
  [:div.speakers
   (doall (->> agenda-data
               (filter #(and (:profile-pic %)
                             (#{:lightning :talk} (:type %))))
               (map speaker-component)))])
