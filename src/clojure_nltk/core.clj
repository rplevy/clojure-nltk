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

;; note to self: it may make sense to set this up so that for each nltk module should have a corresponding clojure-nltk namespace.

(defmacro corpus-base [corpus-name method & params]
  `(clojure-python.core/pyobj-iterate
    (clojure-python.core/_> [~'corpus ~corpus-name ~method]
                            ~@params)))
(defmacro corpus-words [corpus-name & params]
  `(clojure-nltk.core/corpus-base ~corpus-name ~'words ~@params))
(defmacro corpus-categories [corpus-name & params]
  `(clojure-nltk.core/corpus-base ~corpus-name ~'categories ~@params))
(defmacro corpus-fileids [corpus-name & params]
  `(clojure-nltk.core/corpus-base ~corpus-name ~'fileids ~@params))
