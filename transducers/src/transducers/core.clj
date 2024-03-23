(ns transducers.core)

;; https://www.zhiqiangqiao.com/blog/transducers-in-clojure-explained
;; Learning about transducers.
;; Glenn shared this link with me.
(defn transducer-inc
  "First transducer
  rf is short for reducing function"
  [rf]
  (fn
    ([] (rf))
    ([result] (rf result))
    ;; Ignore above 'boilerplate' for other arities
    ([result input]
     (rf result (inc input)))))

;; Transduce is the variation of reduce, the first and second argument
;; are transducer and the reducer.
;; https://clojuredocs.org/clojure.core/transduce
;; [1 2] -> [2 3] -> 2 + 3 -> 5
(transduce transducer-inc + [1 2])
;; => 5

;; This statement is analogous to the previous one
;; And there's reason why I provide 0 as initial value here. I'll explain later.
(reduce (transducer-inc +) 0 [1 2])
;; => 5

;; [1 2] -> [2 3] -> 2 * 3 -> 6
(transduce transducer-inc * [1 2])
;; => 6

;; And the same transducer function can be obtained like this.
;; We'll explain that 1-arity map later. It's not a partial function
;; (partial map inc), even they function similarly.
(transduce (map inc) + [1 2])
;; => 5

(map inc [1 2])
;; => (2 3)

;; We could definitely achieve same result with collection pre-processing
(reduce + (map inc [1 2]))
;; => 5

;; What a transducer does, is pre-processing the individual items of
;; the collection lazily. When its work is done, it'll pass the
;; processed item to the reducing function, or not (like what filter
;; does).

;; Source code for `filter`
;; If called without a collection, returns a transducer.

;; (defn filter
;;   "Returns a lazy sequence of the items in coll for which
;;   (pred item) returns logical true. pred must be free of side-effects.
;;   Returns a transducer when no collection is provided."
;;   ([pred]
;;    (fn [rf]
;;      (fn
;;        ([] (rf))
;;        ([result] (rf result))
;;        ([result input]
;;         (if (pred input)
;;           (rf result input)
;;           result)))))
;;   ([pred coll]
;;    (lazy-seq
;;     (when-let [s (seq coll)]
;;       (if (chunked-seq? s)
;;         (let [c (chunk-first s)
;;               size (count c)
;;               b (chunk-buffer size)]
;;           (dotimes [i size]
;;             (let [v (.nth c i)]
;;               (when (pred v)
;;                 (chunk-append b v))))
;;           (chunk-cons (chunk b) (filter pred (chunk-rest s))))
;;         (let [f (first s) r (rest s)]
;;           (if (pred f)
;;             (cons f (filter pred r))
;;             (filter pred r))))))))

(def negative-quotient (comp - /))

(negative-quotient 8 3)
;; => -8/3

(transduce (comp transducer-inc transducer-inc) + [1 2])
;; => 7

(transduce (comp transducer-inc transducer-inc) * [1 2])
;; => 12

(def transducer-double (map #(* % 2)))

;; [1 2] -> [2 3] -> [4 6] -> 10
(transduce (comp transducer-inc transducer-double) + [1 2])
;; => 10

;; [1 2] -> [2 4] -> [3 5] -> 8
(transduce (comp transducer-double transducer-inc) + [1 2])
;; => 8


;; ********** Reducers

;; Should take two arguments, and return a value.
;; The reducing function should be able to accept its return value as
;; its first argument.

(+ 1 2) ;; => 3

(conj [1 2] 3) ;; => [1 2 3]

;; Both 0- and 2-argument arities are required.
(reduce + []) ;; => 0

(reduce + [2]) ;; => 2

(reduce + nil) ;; => 0

(reduce + 3 [2]) ;; => 5
(reduce + 3 [2 3 4]) ;; => 12

;; 1 item in collection? Reducing function is not called!
(reduce conj [1]) ;; => 1

(reduce nil [1]) ;; => 1

;; `transduce` ALWAYS calls the 0-arity transformed reducing function
;; to generate an initial value if it's not provided.

(transduce (map inc) + [1 2])
;; => 5

(transduce (map inc) +  0 [1 2])
;; => 5

(reduce ((map inc) +) [1 2])
;; => 4

(reduce ((map inc) +) 0 [1 2])
;; => 5


;; ***** Transducers are not just used with a reducing function.

(into [] (filter odd?) (range 10))
;; => [1 3 5 7 9]


;; In the examples below:
;; transducing function: (filter odd?)
;; reducing function: conj
;; Initial accumulator: (vec (range 20 30 3)) (or [], or missing)
;; collection: (range 10)

;; [] is the initial accumulator here.
(transduce (filter odd?) conj [] (range 10))
;; => [1 3 5 7 9]

;; Omit the initial accumulator.
(transduce (filter odd?) conj (range 10))
;; => [1 3 5 7 9]

;; Start with a vector of every 3rd number between 20 and 30.
;; Note, the transducing function is not applied to the initial
;; accumulator.
(transduce (filter odd?) conj (vec (range 20 30 3)) (range 10))
;; => [20 23 26 29 1 3 5 7 9]

(into #{} (filter odd?) (range 10))
;; => #{7 1 3 9 5}

(sequence (filter odd?) (range 10))
;; => (1 3 5 7 9)
(class (sequence (filter odd?) (range 10)))
;; => clojure.lang.LazySeq


;; More examples

(transduce (filter odd?) + (range 5))
;; => 4

(transduce identity conj [1])
;; => [1]

(transduce cat conj [[1] [2 5]])
;; => [1 2 5]

(transduce cat + [[1] [2 5]])
;; => 8

;; Apply left->right
;; Take first 5 elements of (repeat [1 2 3])
;; Apply `cat`
(sequence (comp (take 5) cat) (repeat [1 2 3]))
;; => (1 2 3 1 2 3 1 2 3 1 2 3 1 2 3)

;; Explanation
(take 5 (repeat [1 2 3]))
;; => ([1 2 3] [1 2 3] [1 2 3] [1 2 3] [1 2 3])

(sequence cat (take 5 (repeat [1 2 3])))
;; => (1 2 3 1 2 3 1 2 3 1 2 3 1 2 3)



;; Switch the order, do `cat` first

;; Apply left->right
;; Apply `cat` to (repeat [1 2 3])
;; Take the first 5 elements
(sequence (comp cat (take 5)) (repeat [1 2 3]))
;; => (1 2 3 1 2)

;; (sequence cat (repeat [1 2 3])) ;; Returns LazySeq
(class (sequence cat (repeat [1 2 3])))
;; => clojure.lang.LazySeq

(take 5 (sequence cat (repeat [1 2 3])))
;; => (1 2 3 1 2)
