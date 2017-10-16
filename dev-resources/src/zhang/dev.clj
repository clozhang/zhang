(ns zhang.dev
  "A development namespace that imports other useful namespaces for easy
  prototyping, &c. The intended use is for this to be the initial namespace
  when running ``lein repl`` from the Clozhang project directory."
  (:require [clojure.pprint :refer [print-table]]
            [clojure.tools.namespace.repl :as repl]
            [taoensso.timbre :as log]
            [trifl.java :refer [show-methods]]
            [zhang.core :as zhang]))

(def reload #'repl/refresh)
