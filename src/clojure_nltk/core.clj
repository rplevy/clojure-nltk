(ns clojure-nltk.core
  (:require [clojure-python.core :as py]
            [clojure.java.io :as io]))

(defmacro nltk-init
  "set up ntlk. currently supported usages:
  (nltk-init (:import foo bar baz))"
  [& clauses]
  (let [import-clauses (set (apply concat
                                   (map #(if (= :import (first %))
                                           (rest %)) clauses)))]
    `(do
       (py/init (io/resource "nltk/"))
       (py/py-import-lib ~'nltk)
       ~@(map (fn [module]
                `(py/py-import-lib
                  ~'nltk
                  ~module))
              import-clauses))))

(defmacro corpus-base [corpus-name method & params]
  `(py/pyobj-iterate
    (py/_> [~'corpus ~corpus-name ~method]
                            ~@params)))
(defmacro corpus-words [corpus-name & params]
  `(py/corpus-base ~corpus-name ~'words ~@params))
(defmacro corpus-categories [corpus-name & params]
  `(py/corpus-base ~corpus-name ~'categories ~@params))
(defmacro corpus-fileids [corpus-name & params]
  `(py/corpus-base ~corpus-name ~'fileids ~@params))
