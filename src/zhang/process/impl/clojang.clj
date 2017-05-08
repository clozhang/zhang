(ns zhang.process.impl.clojang
  "A clojang-based (jiface wrapper) implementation of a Zhang process.")

(defrecord ClojangProcess [])

(def process-behaviour
  {:spawn identity})

(defn create
  "Constructor for the Zhang clojang process."
  []
  (->ClojangProcess))
