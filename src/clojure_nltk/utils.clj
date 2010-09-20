(ns clojure-nltk.utils
  (:use clojure.contrib.str-utils))

(defn get-classpath []
  (seq (.getURLs (java.lang.ClassLoader/getSystemClassLoader))))

(defn get-project-path []
  (let [classpath (get-classpath)
        path (first
              (drop-while
               #(not (re-find #"clojure-nltk/src/" (str %)))
               classpath))
        jarpath (and (nil? path)
                     (first
                      (drop-while
                       #(not (re-find #"clojure-nltk-[0-9\.]+\.jar" (str %)))
                       classpath)))]
    (re-sub
     #"^file:" ""
     (if jarpath
       (str jarpath "/")
       (str path)))))
      

(defn get-nltk-path []
  (str
   (get-project-path)
   "clojure_nltk/python-nltk-src/nltk-2.0b7/"))
