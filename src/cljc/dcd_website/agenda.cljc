(ns dcd-website.agenda
  (:require [clojure.string :as string]))

(defn table-row [{:keys [title time author co-speaker _type]}]
  (let [[start end] time]
    ^{:key (str time author)}
    [:tr
     [:td.time
      (when start [:p.start start])
      (when end [:p.end end])]
     [:td {:col-span (if author 1 2)} [:a {:href (str "#" title)} title]]
     (when author
       [:td author
        (when-let [co-author (:author co-speaker)]
          [:span.co-author
           [:br]
           co-author])])]))

(defn agenda-component [agenda-data]
  [:div.agenda
   [:table {:cell-spacing 0}
    [:tbody
     (doall (map table-row agenda-data))]]])

(defn- strip-protocol [url]
  (string/replace url #"https?://" ""))

;; courtesy of clj-commons/humanize
(defn- max-20-chars [the-string]
  (let [suffix "…"
        suffix-len (count suffix)
        max-length 20
        string-len (count the-string)]
    (if (<= string-len max-length)
      the-string
      (str (subs the-string 0 (- max-length suffix-len)) suffix))))

(defn speaker-component [{:keys [author description title type profile-pic bio twitter youtube-link blog co-speaker]}]
  ^{:key author}
  [:div.speaker
   [:div.name
    [:img {:src (str "img/speakers/" profile-pic)}]
    (when-not (= :placeholder type)
      [:h3 author])
    (when twitter
      [:a.twitter-link {:href (str "https://x.com/" twitter) :target :_blank}
       [:span.twitter-handle [:img {:class "icon" :src "img/icons/x.svg"}] (str "@" twitter)]])
    (when blog
      (let [link-url blog
            link-text (-> blog
                          strip-protocol
                          max-20-chars)]
        [:a.twitter-link {:href link-url}
         [:span.twitter-handle [:img {:class "icon" :src "img/icons/external-link.png"}] link-text]]))
    (when co-speaker
      (let [{:keys [author description title type profile-pic bio twitter youtube-link blog co-speaker]} co-speaker]
        [:span
         [:img.co-speaker {:src (str "img/speakers/" profile-pic)}]
         (when-not (= :placeholder type)
           [:h3 author])
         (when twitter
           [:a.twitter-link {:href (str "https://x.com/" twitter) :target :_blank}
            [:span.twitter-handle [:img {:class "icon" :src "img/icons/x.svg"}] (str "@" twitter)]])
         (when blog
           (let [link-url blog
                 link-text (-> blog
                               strip-protocol
                               max-20-chars)]
             [:a.twitter-link {:href link-url}
              [:span.twitter-handle [:img {:class "icon" :src "img/icons/external-link.png"}] link-text]]))]))]
   [:div.info
    [:h3.title {:id title}
     (when (= :lightning type)
       [:span.lightning "lightning talk"])
     title]
    [:div.description description]
    (when bio
      (let [speaker-title (if co-speaker
                            "speakers"
                            "speaker")]
        [:div.bio "About the " speaker-title ": "
         (if co-speaker
           [:span
            [:p bio]
            [:p (:bio co-speaker)]]
           bio)]))
    (when youtube-link
      [:a.youtube-link {:href youtube-link
                        :target :_blank}
       "Watch on YouTube"])]])

(defn speakers-component [agenda-data]
  [:div.speakers
   (doall (->> agenda-data
               (filter #(and (:profile-pic %)
                             (#{:lightning :talk :placeholder} (:type %))))
               (map speaker-component)))])
