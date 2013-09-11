(ns fourcloj.core)

;;=====================================
;; http://www.4clojure.com/problem/38
;;=====================================
(defn maxify [& args]
  (apply
   (fn mx
     ([x] x)
     ([x & more] 
        (if (> x (first more))
          (apply mx (cons x (rest more)))
          (apply mx more))
        ))
   args)
  )

;;=====================================
;; http://www.4clojure.com/problem/39
;;=====================================
(defn interleave-two-seqs [list1 list2]
  (apply
   (fn ntr ([a b] 
              (if (and (> (count a) 0) (> (count b) 0))
                (list* (first a) (first b) (ntr (rest a) (rest b)))
                [])
              ))
   [list1 list2])
)

;;=====================================
;; http://www.4clojure.com/problem/65
;;=====================================
(defn black-box [arg]
  :map
  (apply
   (fn bb ([aseq]
             (cond
              (= {} (empty aseq)) :map
              (= #{} (empty aseq)) :set
              (= '() (empty aseq))
                (if (= 99 (first (conj (conj aseq 98) 99)))
                  :list
                  :vector)
              )
             ))
   [arg])
)

;; hmm not getting this to work
;; - but sets always have the same order
(defn reverse-test [a] 
  ;; [a (reverse a)]
  (= (first a) (first (reverse a)))
)

;; flatten
;; - maps/sets: flatten to empty list ==> returns false
;; - lists/vector: flatten to self (if flat) ==> returns true

(defn flatten-test [aseq]
  (and (not= 0 (count aseq)) (not= 0 (count (flatten aseq)))))

;; tests whether the collection is a map
;; - works for non empty seqs
(defn map-test [aseq]
  (= 2 (count (first (set aseq))))
)

;; test for empty seqs
(defn test-empty-seq [aseq]
  (= 0 (count aseq))
)

;; only maps/sets will allow you to index them with no elements

;; contains?
;; - on vectors, contains works on index 
;;   (contains? [1 2 3] 3) => false
;;   (contains? [1 2 3] 0) => true
;; - on lists, contains is not supported
;; - on sets, contains tests values, as expected
;; - on maps, contains tests keys (contains? {:a 1 :b 2} :a) => true

;; keys - only map responds to keys

;; indexing 
;; (#{1 2 3} 0) ==> nil
;; (#{1 2 3} 1) ==> 1
;; ([1 2 3] 0) ==> 1

