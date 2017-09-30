(ns dcd-website.agenda
  (:require [dcd-website.style :refer [colors]]))

(defn table-row [{:keys [title time author type]}]
  (let [[start end] time]
    ^{:key (str time author)}
    [:tr
     {:style {:background (colors type)}}
     [:td.time
      (when start [:p.start start])
      (when end [:p.end end])]
     [:td {:col-span (if author 1 2)} title]
     (when author
       [:td author])]))

(defn agenda-component [{:keys [agenda-data]}]
  [:div.agenda
   [:table {:cell-spacing 0}
    [:tbody
     (doall (map table-row agenda-data))]]])

(defn speaker-component [{:keys [author description title type profile-pic bio twitter youtube-link]}]
  ^{:key author}
  [:div.speaker
   [:div.name
    [:img {:src (str "img/speakers/" profile-pic)}]
    [:a.twitter-link {:href (str "https://twitter.com/" twitter) :target :_blank}
     [:img.icon.twitter {:src "img/icons/twitter.svg"}]
     [:span.twitter-handle (str "@" twitter)]]
    [:h3 author]]
   [:div.info
    [:h3.title title]
    [:div.description description]
    (when bio [:div.bio "About the speaker: " bio])
    (when youtube-link
      [:a.youtube-link {:href youtube-link
                        :target :_blank}
       [:img.icon.youtube {:src "img/icons/youtube.svg"}]
       "Watch on YouTube"])]])

(defn speakers-component [{:keys [agenda-data]}]
  [:div.speakers
   (doall (->> agenda-data
               (filter #(and (:profile-pic %)
                             (#{:lightning :talk} (:type %))))
               (map speaker-component)))])
