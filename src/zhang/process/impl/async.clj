(ns zhang.process.impl.async
  "A core.async implementation of a Zhang process."
  (:require [clojure.core.async :as async]))

(defrecord AsyncProcess [fun chan])

(defn get-id
  [this]
  (:chan this))

(defn send
  [this msg]
  (async/put! (:chan this) msg))

(def process-behaviour
  {:id get-id
   :! send})

(defrecord AsyncProcessFactory [])

(defn spawn
  [this fun]
  (let [chan (async/chan)]
    (async/go-loop [f fun]
      (recur (f (async/<! chan))))
    (->AsyncProcess fun chan)))

(defn spawn!
  [this fn]
  )

(def process-factory-behaviour
  {:spawn spawn
   :spawn! spawn!})
