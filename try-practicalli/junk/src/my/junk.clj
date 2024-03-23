;; ---------------------------------------------------------
;; my.junk
;;
;; TODO: Provide a meaningful description of the project
;; ---------------------------------------------------------

(ns my.junk
  (:gen-class)
  (:require
   [com.brunobonacci.mulog :as mulog]))

;; ---------------------------------------------------------
;; Application

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn greet
  "Greeting message via Clojure CLI clojure.exec"
  ([] (greet {:team-name "secret engineering"}))
  ([{:keys [team-name]}]
   #_(println team-name)
   (println
    (str "my junk service developed by the " team-name " team"))))


(defn -main
  "Entry point into the application via clojure.main -M"
  [& args]
  (let [team (first args)]
    (mulog/set-global-context!
     {:app-name "my junk" :version  "0.1.0-SNAPSHOT"})
    (mulog/log ::application-starup :arguments args)
    (println (if team
               (greet {:team-name team})
               (greet)))))

;; ---------------------------------------------------------


;; ---------------------------------------------------------
;; Rick Comment
#_{:clj-kondo/ignore [:redefined-var]}
(comment

  (-main)
  (-main {:team-name "Clojure Engineering"})

  #_()) ; End of rich comment block
;; ---------------------------------------------------------
