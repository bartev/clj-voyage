(ns bcs.utils.file
  (:require
   [babashka.fs :as fs]
   [clojure.pprint :refer [pprint]]
   [clojure.java.io :as io]
   [clojure.string :as str]))

(defn read-file
  "Return full file contents from `path`.
  Will find file that are in the current path. (e.g. in `resources`)"
  [path]
  (->
   "resources/README.md"
   fs/absolutize
   fs/file
   slurp
   str/trim-newline))

(defn read-lines
  "Return file contents as collection of rows."
  [path]
  (-> path read-file str/split-lines))

#_(read-file "README.md")
;; => "README\n\nHow do I use this stuff?"

#_(read-lines "README.md")
;; => ["README" "" "How do I use this stuff?"]
