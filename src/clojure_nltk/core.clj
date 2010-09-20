(ns clojure-nltk.core
  (:require [clojure-python.core]))

(defn init
  "load nltk"
  []
  (clojure-python.core/init "python-nltk-src/nltk-2.0b7")
  (py-import nltk))

