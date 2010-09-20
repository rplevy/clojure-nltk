(ns clojure-nltk.core
  (:use clojure-nltk.utils)
  (:require clojure-python.core))

(defn init
  "load nltk"
  []
  (clojure-python.core/init (get-nltk-path))
  (clojure-python.core/py-import nltk))


;; TODO: add public API to interact with NLTK functions