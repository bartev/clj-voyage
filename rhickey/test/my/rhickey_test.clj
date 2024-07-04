;; ---------------------------------------------------------
;; my.rhickey.-test
;;
;; Example unit tests for my.rhickey
;;
;; - `deftest` - test a specific function
;; - `testing` logically group assertions within a function test
;; - `is` assertion:  expected value then function call
;; ---------------------------------------------------------


(ns my.rhickey-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [my.rhickey :as rhickey]))


(deftest application-test
  (testing "TODO: Start with a failing test, make it pass, then refactor"

    ;; TODO: fix greet function to pass test
    (is (= "my application developed by the secret engineering team"
           (rhickey/greet)))

    ;; TODO: fix test by calling greet with {:team-name "Practicalli Engineering"}
    (is (= (rhickey/greet "Practicalli Engineering")
           "my service developed by the Practicalli Engineering team"))))
