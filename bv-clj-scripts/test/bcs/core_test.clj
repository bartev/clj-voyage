(ns bcs.core-test
  (:require [bcs.core :as sut]
            [clojure.test :refer :all]))

(deftest fail-1
  (is (= 1 2)))

(deftest fail-a
  (is (= :a :b)))
