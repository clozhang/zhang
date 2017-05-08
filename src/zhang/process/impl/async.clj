(ns zhang.process.impl.async
  "A core.async implementation of a Zhang process."
  (:require [clojure.core.async :as async]
            [zhang.agent.process-table :as process-table]
            [zhang.process.protocol :as process-api])
  (:import (java.net InetAddress)))

(defrecord AsyncProcess [id fun chan])

(defn snd
  [this msg]
  (async/put! (:chan this) msg))

(defn terminate
  [this]
  (process-table/remove-process (:id this))
  (dissoc this :id :fun :chan)
  nil)

(def process-behaviour
  {:id #(:id %)
   :! snd
   :receive identity
   :terminate terminate})

(defn create-process
  ""
  [fun chan]
  (->AsyncProcess
    (format "<%s:%s:%s>"
            (.getHostName (InetAddress/getLocalHost))
            (hash fun)
            (hash chan))
    fun
    chan))

(defrecord AsyncProcessFactory [])

(defn spawn
  [this fun]
  (let [chan (async/chan)]
    (async/go-loop [f fun]
      (recur (f (async/<! chan))))
    (process-table/add-process
      (create-process fun chan))))

(def process-factory-behaviour
  {:spawn spawn
   :spawn-linked identity
   :spawn-managed identity})

(extend AsyncProcessFactory
        process-api/ZhangProcessFactory
        process-factory-behaviour)
