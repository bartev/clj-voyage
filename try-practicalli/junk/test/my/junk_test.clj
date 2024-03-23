;; ---------------------------------------------------------
;; my.junk.-test
;;
;; Example unit tests for my.junk
;;
;; - `deftest` - test a specific function
;; - `testing` logically group assertions within a function test
;; - `is` assertion:  expected value then function call
;; ---------------------------------------------------------


(ns my.junk-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [my.junk :as junk]))


(deftest application-test
  (testing "TODO: Start with a failing test, make it pass, then refactor"

    ;; TODO: fix greet function to pass test
    (is (= "my application developed by the secret engineering team"
           (junk/greet)))

    ;; TODO: fix test by calling greet with {:team-name "Practicalli Engineering"}
    (is (= (junk/greet "Practicalli Engineering")
           "my service developed by the Practicalli Engineering team"))))
