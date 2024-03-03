(ns yaml-utils
  (:require [clj-yaml.core :as yaml]
            [clojure.java.io :as io]))

(yaml/generate-string
 [{:name "John Smith"
   :age 33}
  {:name "Mary Smith"
   :age 32}]
 :dumper-options {:flow-style :block})


(def my-map {"name" "John Doe"
             "age" 30
             "city" "New York"})

(def multiples {:john my-map
                :doe my-map})


(def samp-dict {:todo {:name "Fix issue"
                       :responsible {:names ["Rita" "Bob" "Frank"]}
                       :ages [20.5 3.423e1 40]
                       :age-str "25"}})

(def mult-samp-dict {:todos {:one samp-dict
                             :two samp-dict
                             :three samp-dict}})

(defn print-yaml
  "Print a dict as yaml."
  [data]
  (println
   (yaml/generate-string
    data
    :dumper-options {:flow-style :block})))

(print-yaml multiples)
(print-yaml samp-dict)

(defn write-yaml
  "Write data to fname as yaml file."
  [data fname]
  (spit fname
        (yaml/generate-string
         data
         :dumper-options {:flow-style :block})
        :append false))

(write-yaml samp-dict "data-out-samp-dict.yaml")
(write-yaml mult-samp-dict "data-out-mult-samp-dict.yaml")
