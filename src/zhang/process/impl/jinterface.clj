(ns zhang.process.impl.jinterface
  "An Erlang JInterface-based implementation of a Zhang process.")

(defrecord JinterfaceProcess [])

(def process-behaviour
  {:spawn (fn [])
   :spawn! (fn [])})

(defn create
  "Constructor for the Zhang JInterafce process."
  []
  (->JinterfaceProcess))
