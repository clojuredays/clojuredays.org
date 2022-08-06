(ns dcd-website.core
  (:require [dcd-website.html :as html]
            [dcd-website.dcd2016 :refer [dcd2016-website-structure]]
            [dcd-website.dcd2017 :refer [dcd2017-website-structure]]
            [dcd-website.dcd2018 :refer [dcd2018-website-structure]]
            [dcd-website.dcd2019 :refer [dcd2019-website-structure]]
            [dcd-website.dcd2020 :refer [dcd2020-website-structure]]
            [dcd-website.dcd2022 :refer [dcd2022-website-structure]])
  (:gen-class))

(defn pages
  "returns all the pages that need to be generated"
  []
  [(assoc dcd2016-website-structure :file-name "dcd2016")
   (assoc dcd2017-website-structure :file-name "dcd2017")
   (assoc dcd2018-website-structure :file-name "dcd2018")
   (assoc dcd2019-website-structure :file-name "dcd2019")
   (assoc dcd2020-website-structure :file-name "dcd2020")
   (assoc dcd2022-website-structure :file-name "index")])

(defn -main [& _args]
  (doseq [page (pages)] (html/to-html page)))

(comment
  (-main))
