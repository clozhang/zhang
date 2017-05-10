(defproject clojang/zhang "0.1.0-SNAPSHOT"
  :description "An implementation of the Erlang process model in Clojure
                core.async"
  :url "https://github.com/clojang/zhang"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [
    [clojang "0.4.0-SNAPSHOT"]
    [clojang/zhang-agent "0.3.0-SNAPSHOT"]
    [clojusc/trifl "0.1.0-SNAPSHOT"]
    [clojusc/twig "0.3.1"]
    [dire "0.5.4"]
    ;[org.clojure/clojure "1.8.0"]
    [org.clojure/clojure "1.9.0-alpha16"]
    [org.clojure/core.async "0.3.442"]
    [org.clojure/core.match "0.3.0-alpha4"]
    [potemkin "0.4.3"]
    [spootnik/net "0.3.3-beta12"]
    ]
  :plugins [[lein-simpleton "1.3.0"]]
  :test-selectors {:default :unit
                   :unit :unit
                   :system :system
                   :integration :integration}
  :codox {:output-path "docs/current"
          :doc-paths ["resources/docs"]
          :project {:name "zhang"}
          :themes [:clojang]
          :namespaces [#"^zhang\.(?!test)"]
          :metadata {:doc/format :markdown}}
  :profiles {
    :uberjar {
      :aot :all}
    :docs {
      :aot :all
      :dependencies [[clojang/codox-theme "0.2.0-SNAPSHOT"]]
      :plugins [
        [lein-codox "0.10.3"]
        [lein-simpleton "1.3.0"]]}
    :testing {
      :aot :all
      :dependencies [
        [clojusc/trifl "0.1.0-SNAPSHOT"]]
      :plugins [
        [lein-ancient "0.6.10"]
        [jonase/eastwood "0.2.3" :exclusions [org.clojure/clojure]]
        [lein-bikeshed "0.4.1"]
        [lein-kibit "0.1.4" :exclusions [org.clojure/clojure]]
        [venantius/yagni "0.1.4"]]
      :source-paths ["test"]
      :test-selectors {
        :default :unit
        :unit :unit
        :system :system
        :integration :integration}}
    :dev {
      :dependencies [
        [org.clojure/tools.namespace "0.2.11"]]
      :source-paths ["dev-resources/src"]
      :jvm-opts [
        ;"-verbose:class"
        ;"-Dheadless"
        "-splash:resources/images/logo-5-250x.png"
        "-Dnode.sname=zhang"]
      :java-agents [[clojang/zhang-agent "0.3.0-SNAPSHOT"]]
      :repl-options {:init-ns zhang.dev}}})
