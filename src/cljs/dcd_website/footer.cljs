(ns dcd-website.footer)

(defn footer-component []
  [:footer.footer
   [:a {:href "https://twitter.com/clojuredays"
        :target :_blank}
    [:img {:src "img/icons/twitter.svg"}]]
   [:a {:href "https://www.youtube.com/channel/UCZ7rYtyjSgF1jMYHCkyjwMQ"
        :target :_blank}
    [:img {:src "img/icons/youtube.svg"}]]
   [:a {:href "mailto:events@clojuredays.org"}
    [:img {:src "img/icons/email.svg"}]]])
