(ns myneil.myneil
  "FIXME: my new org.corfield.new/scratch project."
  (:gen-class))

(defn exec
  "Invoke me with clojure -X myneil.myneil/exec"
  [opts]
  (println "exec with" opts))

(defn -main
  "Invoke me with clojure -M -m myneil.myneil"
  [& args]
  (println "-main with" args))
