(ns clojure-nltk.utils
  (:use clojure.contrib.str-utils))

(defn get-classpath []
  (seq (.getURLs (java.lang.ClassLoader/getSystemClassLoader))))

(defn get-project-path []
  (re-sub
   #"^file:" ""
   (str
    (first
     (drop-while
      #(not (re-find #"clojure-nltk/src/" (str %)))
      (get-classpath))))))

(defn get-nltk-path []
  (str
   (get-project-path)
   "clojure_nltk/python-nltk-src/nltk-2.0b7/"))
