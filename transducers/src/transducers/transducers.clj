(ns transducers.transducers
  "FIXME: my new org.corfield.new/scratch project.")

(defn exec
  "Invoke me with clojure -X transducers.transducers/exec"
  [opts]
  (println "exec with" opts))

(defn -main
  "Invoke me with clojure -M -m transducers.transducers"
  [& args]
  (println "-main with" args))
