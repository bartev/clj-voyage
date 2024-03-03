(ns bv.calculator-test
  (:require
   [bv.calculator :as sut]
   [clojure.test :refer :all]))

(deftest adding-numbers
  (is (= 4 (sut/plus 3 1))))
;; => #'bv.calculator-test/adding-numbers

(deftest dividing-numbers
  (is (= 2 (sut/divide 6 3))))
;; => #'bv.calculator-test/dividing-numbers

(deftest dividing-by-zero
  (is (thrown? ArithmeticException (sut/divide 1 0))))
