(defproject clojure-nltk "2.0.3-clj-0"
  :description "Python's NLTK for Clojure (interop / partial port)."
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [clojure-python "0.4.1"]]
  :profiles {:dev {:dependencies [[midje "1.4.0"]]}}
  :plugins [[lein-midje "2.0.0"]])
