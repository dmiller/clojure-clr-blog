(import 'System.Linq.Enumerable)
(def r1 (Enumerable/Where [1 2 3 4 5] even?))
(seq r1)                             ; => (2 4)

(defn f 
 ([x] x)
 ([x y] [x y]))


(Enumerable/Where [1 2 3 4 5] f)    ;=> FAIL!

(Enumerable/Where [1 2 3 4 5] #(f %1))

(Enumerable/Where [1 2 3 4 5] (sys-func [Object Boolean] [x] (f x)))


(def r2 (Enumerable/Range 1 10))
(seq r2)                             ;=> (1 2 3 4 5 6 7 8 9 10)
(seq (Enumerable/Where r2 even?))          ;=> (2 4 6 8 10)


(Enumerable/Where r2 (sys-func [Int32 Boolean] [x] (even? x)))
(Enumerable/Where r2 (sys-func [Object Boolean] [x] (even? x)))
(Enumerable/Where (seq r2) even?)


(def r3 (Enumerable/Repeat 2 5))   ;=> FAILS

(def r3 (Enumerable/Repeat (type-args Int32) 2 5))
                ; use type-args to supply the type parameters to the generic method
(seq r3)        ;=> (2 2 2 2 2)

(seq (-> (Enumerable/Range 1 10) 
		 (Enumerable/Where even?) 
		 (Enumerable/Select #(* %1 %1))))  ;=> (4 16 36 64 100)