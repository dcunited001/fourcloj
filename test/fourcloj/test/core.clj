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

(deftest black-box-test
  (is (= :map (black-box {:a 1, :b 2})))
  (is (= :list (black-box (range (rand-int 20)))))
  (is (= :vector (black-box [1 2 3 4 5 6])))
  (is (= :set (black-box #{10 (rand-int 5)})))
  (is (= [:map :set :vector :list] (map black-box [{} #{} [] ()]))))

(deftest anilkey-test
  (is (true? (anilkey :a {:a nil :b 2})))
  (is (false? (anilkey :b {:a nil :b 2})))
  (is (false? (anilkey :c {:a nil :b 2}))))

(deftest map-defaults-test
  (is (= (map-defaults 0 [:a :b :c]) {:a 0 :b 0 :c 0}))
  (is (= (map-defaults "x" [1 2 3]) {1 "x" 2 "x" 3 "x"}))
  (is (= (map-defaults [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})))

(deftest reduce-odd-test
  (is (= (reduce-odd #{1 2 3 4 5}) '(1 3 5)))
  (is (= (reduce-odd [4 2 1 6]) '(1)))
  (is (= (reduce-odd [2 2 4 6]) '()))
  (is (= (reduce-odd [1 1 1 3]) '(1 1 1 3)))
)

