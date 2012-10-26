(ns clojure-nltk.core-test
  (:require [clojure-nltk.core :as base]
            [midje.sweet :refer :all]))

(fact (base/nltk-init) => anything)
