(defproject zhang "0.1.0-dev"
  :description "An implementation of the Erlang process model in Clojure
                core.async"
  :url "https://github.com/oubiwann/zhang"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
                 [org.clojure/core.match "0.3.0-alpha4"]
                 [dire "0.5.4"]
                 [twig "0.1.2"]]
  :plugins [[lein-codox "0.9.4"]
            [lein-simpleton "1.3.0"]]
  :repl-options {:init-ns zhang.dev}
  :test-selectors {:default :unit
                   :unit :unit
                   :system :system
                   :integration :integration}
  :codox {:output-path "docs/master/current"
          :doc-paths ["docs/source"]
          :namespaces [#"^zhang\.(?!test)"]
          :metadata {:doc/format :markdown}})
