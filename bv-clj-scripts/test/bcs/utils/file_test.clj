(ns bcs.utils.file-test
  (:require [bcs.utils.file :as sut]
            [clojure.test :refer :all]))

(deftest read-file-test
  (is (= "README\n\nHow do I use this stuff?"
         (sut/read-file "sample-readme.md")))
  (is (= 1 1)))

(deftest read-lines-test
  (is (= ["README" "" "How do I use this stuff?"]
         (sut/read-lines "sample-readme.md"))))
