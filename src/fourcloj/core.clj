(ns fourcloj.core)

;; http://www.4clojure.com/problem/38
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


;; http://www.4clojure.com/problem/39
(defn interleave-two-seqs [list1 list2]
  (apply
   (fn ntr ([a b] 
              (if (and (> (count a) 0) (> (count b) 0))
                (list* (first a) (first b) (ntr (rest a) (rest b)))
                [])
              ))
   [list1 list2])
)
