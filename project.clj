(defproject clojuredays.org "0.1.0-SNAPSHOT"
            :plugins [[yogthos/lein-sass "0.1.8"]]
            :sass {:source "sass/css" :target "public/css"}
            :dependencies [[org.clojure/clojure "1.10.1"]
                           [hiccup "1.0.5"]]
            :main dcd-website.core
            :source-paths ["src/clj" "src/cljc"])


