(set-env!
 :source-paths    #{"sass" "src/cljs"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs          "1.7.228-2"        :scope "test"]
                 [adzerk/boot-cljs-repl     "0.3.3"            :scope "test"]
                 [adzerk/boot-reload        "0.5.0"            :scope "test"]
                 [pandeiro/boot-http        "0.7.6"            :scope "test"]
                 [com.cemerick/piggieback   "0.2.1"            :scope "test"]
                 [org.clojure/tools.nrepl   "0.2.12"           :scope "test"]
                 [weasel                    "0.7.0"            :scope "test"]
                 [crisptrutski/boot-cljs-test "0.3.0"          :scope "test"]
                 [deraen/boot-sass  "0.3.0"                    :scope "test"]
                 [org.slf4j/slf4j-nop  "1.7.22"                :scope "test"]
                 [org.clojure/clojurescript "1.7.228"]
                 [reagent "0.6.0"]
                 [com.eclipsesource.j2v8/j2v8_macosx_x86_64 "4.6.0"]
                 [boot-deps "0.1.6"]
                 [cljsjs/leaflet "0.7.7-6"]])

(require
 '[clojure.java.io             :as io]
 '[clojure.string              :as string]
 '[adzerk.boot-cljs            :refer [cljs]]
 '[adzerk.boot-cljs-repl       :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload          :refer [reload]]
 '[pandeiro.boot-http          :refer [serve]]
 '[crisptrutski.boot-cljs-test :refer [test-cljs]]
 '[deraen.boot-sass            :refer [sass]])

(import 'com.eclipsesource.v8.V8)

(deftask build []
  (comp (cljs)
        (sass)))

(deftask run []
  (comp (serve)
        (watch)
        (cljs-repl)
        (reload)
        (build)))

(deftask production []
  (task-options! cljs {:optimizations :advanced}
                 sass {:output-style :compressed})
  identity)

(deftask development []
  (task-options! cljs   {:optimizations :none :source-map true}
                 reload {:on-jsload 'dcd-website.carousel/init})
  identity)

(deftask dev
  "Simple alias to run application in development mode"
  []
  (comp (development)
        (run)))


(deftask testing []
  (set-env! :source-paths #(conj % "test/cljs"))
  identity)

;;; This prevents a name collision WARNING between the test task and
;;; clojure.core/test, a function that nobody really uses or cares
;;; about.
(ns-unmap 'boot.user 'test)

(deftask test []
  (comp (testing)
        (test-cljs :js-env :phantom
                   :exit?  true)))

(deftask auto-test []
  (comp (testing)
        (watch)
        (test-cljs :js-env :phantom)))

(def js-setup-code "var global = global || this;
        var self = self || this;
        var window = window || this;
        window.location = window.location || false;
        var document = document || this;
        var console = global.console || {};
        var History = History || {};
        var history = history || {};
        document.location = false;
        ['error', 'log', 'info', 'warn'].forEach(function (fn) {
          if (!(fn in console)) {
            console[fn] = function () {};
          }
        });")

(defn render-component [in-file]
  (println "Pre-rendering component")
  (let [code (slurp in-file)
        runtime (V8/createV8Runtime)
        combined-code (str js-setup-code "\n\n" code "\n\n" "dcd_website.app.render_to_string()")
        result (.executeStringScript runtime combined-code)]
    (.release runtime)
    result))

(deftask pre-render []
  (fn [next-handler]
    (fn [fileset]
      (let [inputs (input-files fileset)
            outputs (output-files fileset)
            fname "index.html"
            code-fname "js/app.js"
            code-file (tmp-file (first (by-path [code-fname] inputs)))
            in-file   (tmp-file (first (by-path [fname] inputs)))
            out-file  (tmp-file (first (by-path [fname] outputs)))
            content (slurp in-file)
            html (render-component code-file)
            new-content (string/replace content "<!--placeholder-->" html)]
        (spit out-file new-content)
        (-> fileset
            commit!
            next-handler)))))
