(set-env!
 :source-paths    #{"sass" "src/cljs"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs          "1.7.228-1"  :scope "test"]
                 [adzerk/boot-cljs-repl     "0.3.0"      :scope "test"]
                 [adzerk/boot-reload        "0.4.8"      :scope "test"]
                 [pandeiro/boot-http        "0.7.2"      :scope "test"]
                 [com.cemerick/piggieback   "0.2.1"      :scope "test"]
                 [org.clojure/tools.nrepl   "0.2.12"     :scope "test"]
                 [weasel                    "0.7.0"      :scope "test"]
                 [org.clojure/clojurescript "1.7.228"]
                 [crisptrutski/boot-cljs-test "0.2.0-SNAPSHOT" :scope "test"]
                 [reagent "0.5.0"]
                 [deraen/boot-sass  "0.2.1" :scope "test"]
                 [org.slf4j/slf4j-nop  "1.7.13" :scope "test"]
                 [com.eclipsesource.j2v8/j2v8_linux_x86_64 "4.6.0"]])

(require
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
                 reload {:on-jsload 'dcd-website.app/init})
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

(defn render-component []
  (println "Pre rendering component")
  (let [path "target/js/app.js"
        code (slurp path)
        runtime (V8/createV8Runtime)
        _ (.executeVoidScript runtime js-setup-code)
        _ (.executeVoidScript runtime code)
        result (.executeStringScript runtime "dcd_website.app.render_to_string()")]
    (.release runtime)
    result))

(deftask pre-render []
  (with-pre-wrap fileset
    (let [path "target/index.html"
          content (slurp path)
          html (render-component)
          new-content (string/replace content "<!--placeholder-->" html)]
      (spit path new-content))
    fileset))
