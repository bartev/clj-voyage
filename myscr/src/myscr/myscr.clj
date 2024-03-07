(ns myscr.myscr
  "FIXME: my new org.corfield.new/scratch project.")

(defn exec
  "Invoke me with clojure -X myscr.myscr/exec"
  [opts]
  (println "exec with" opts))

(defn -main
  "Invoke me with clojure -M -m myscr.myscr"
  [& args]
  (println "-main with" args))
