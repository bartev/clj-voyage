(ns tasks
  (:require
   [clojure.edn :as edn]
   [clojure.java.io :as io]
   [babashka.fs :as fs]))

(def now (java.time.LocalDate/now (java.time.ZoneId/of "US/Eastern")))

(defn read-project-clj
  "Read the project.clj into a clojure dict."
  [fname]
  (with-open [reader (io/reader fname)]
    (edn/read reader)))

(read-project-clj "resources/project-emptyclj.clj")
;; cat project.clj | sed -e 's/#=//g' -e 's/~@//jg' -e 's/~//g' | bb '(let [{:keys [dependencies source-paths resource-paths]} (apply hash-map (drop 3 *in*))] {:paths (into source-paths resource-paths) :deps (into {} (for [[d v] dependencies] [d {:mvn/version v}]))} ) ' | jet --pretty > deps.edn


(->> (slurp "resources/project-emptyclj.clj")
     edn/read-string
     (drop 3)
     type
     )
