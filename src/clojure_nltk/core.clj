(ns clojure-nltk.core
  (:use clojure-nltk.utils)
  (:require clojure-python.core))

(defmacro nltk-init
  "set up ntlk. currently supported usages:
  (nltk-init (:import foo bar baz))"
  [& clauses]
  (let [import-clauses (set (apply concat (map #(if (= :import (first %)) (rest %)) clauses)))
        ;; possibly define other types of clauses here
        ]
    `(do
       (clojure-python.core/init
        (clojure-nltk.utils/get-nltk-path))
       (clojure-python.core/py-import ~'nltk)
       ~@(map (fn [module]
                `(clojure-python.core/py-import
                  ~'nltk
                  ~module))
              import-clauses))))

(defn lazy-corpus [pyobj]
  (clojure-python.core/pyobj-iterate pyobj))

;; TODO: add to this public API into NLTK functions