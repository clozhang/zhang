(ns zhang.process
  (:require [potemkin :refer [import-vars]]
            [zhang.process.impl.async :as async-process]
            [zhang.process.impl.clojang :as clojang-process]
            [zhang.process.impl.jiface :as jiface-process]
            [zhang.process.impl.jinterface :as jinterface-process]
            [zhang.process.protocol :as process-api])
  (:import [clojure.lang Keyword]
           [zhang.process.impl.async AsyncProcess]
           ; [zhang.process.impl.clojang ClojangProcess]
           ; [zhang.process.impl.jiface JifaceProcess]
           ; [zhang.process.impl.jinterface JinterfaceProcess]
           ))

(import-vars
  [process-api

    id
    !
    receive
    terminate])

(extend AsyncProcess
        process-api/ZhangProcess
        async-process/process-behaviour)

; (extend ClojangProcess
;         process-api/ZhangProcess
;         clojang-process/process-behaviour)

; (extend JifaceProcess
;         process-api/ZhangProcess
;         jiface-process/process-behaviour)

; (extend JinterfaceProcess
;         process-api/ZhangProcess
;         jinterface-process/process-behaviour)

(defn spawn
  ([fun]
    (spawn :async fun))
  ([^Keyword process-type fun]
   (case process-type
     :async (-> (async-process/->AsyncProcessFactory)
                (async-process/spawn fun))
     ; :clojang (clojang-process/spawn)
     ; :jiface (jiface-process/spawn)
     ; :jinterface (jinterface-process/spawn)
     )))
