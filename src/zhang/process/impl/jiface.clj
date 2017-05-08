(ns zhang.process.impl.jiface
  "A jiface-based (JInterface wrapper) implementation of a Zhang process.")

(defrecord JifaceProcess [])

(def process-behaviour
  {:spawn (fn [])})

(defn create
  "Constructor for the Zhang jiface process."
  []
  (->JifaceProcess))
