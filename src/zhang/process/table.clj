(ns zhang.process.table
  (:require [potemkin :refer [import-vars]]
            [zhang.agent.process-table :as process-table])
  (:refer-clojure :exclude [count empty? remove]))

(import-vars
  [process-table

    count
    empty?
    get-all
    ps
    add
    lookup
    remove
    remove-all])
