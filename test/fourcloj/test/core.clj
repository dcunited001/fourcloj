(ns fourcloj.test.core
  (:require [clojure.test :refer :all]
            [fourcloj.core :refer :all]))

(deftest maxify-test 
  (is (= (maxify 1 8 3 4) 8))
  (is (= (maxify 30 20) 30))
  (is (= (maxify 45 67 11) 67)))

(deftest interleave-two-seqs-test
  (is (= (interleave-two-seqs [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
  (is (= (interleave-two-seqs [1 2] [3 4 5 6]) '(1 3 2 4)))
  (is (= (interleave-two-seqs [1 2 3 4] [5]) [1 5]))
  (is (= (interleave-two-seqs [30 20] [25 15]) [30 25 20 15])))

