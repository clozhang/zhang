(defproject zhang "0.1.0-SNAPSHOT"
  :description "An implementation of π-Calculus in Clojure"
  :url "https://github.com/clozhang/zhang"
  :license {
    :name "Apache License, Version 2.0"
    :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :exclusions [org.clojure/clojure]
  :dependencies [
    [clojusc/trifl "0.2.0"]
    [clojusc/twig "0.3.2"]
    [org.clojure/clojure "1.8.0"]]
  :plugins [[lein-simpleton "1.3.0"]]
  :profiles {
    :dev {
      :dependencies [
        [org.clojure/tools.namespace "0.2.11"]]
      :source-paths ["dev-resources/src"]
      :repl-options {:init-ns zhang.dev}}
    :test {
      :test-selectors {
        :default :unit
        :unit :unit
        :system :system
        :integration :integration}
      :plugins [
        [lein-ancient "0.6.12"]
        [jonase/eastwood "0.2.5"]
        [lein-bikeshed "0.5.0"]
        [lein-kibit "0.1.5"]
        [venantius/yagni "0.1.4"]]}
    :ubercompile {:aot :all}
    :docs {
      :dependencies [
        [clozhang/codox-theme "0.1.0-SNAPSHOT"]]
      :plugins [
        [lein-codox "0.10.3"]
        [lein-simpleton "1.3.0"]]
      :codox {
        :output-path "docs/current"
        :doc-paths ["resources/docs"]
        :project {:name "zhang"}
        :themes [:clozhang]
        :namespaces [#"^zhang\.(?!test)"]
          :metadata {:doc/format :markdown}}}}
  :aliases {
    "check-deps"
      ["with-profile" "+test" "ancient" "check" ":all"]
    "ubercompile"
      ["with-profile" "+ubercompile" "compile"]
    "docs"
      ["with-profile" "+docs" "codox"]
    "build"
      ["do" ["check"]
            ["check-deps"]
            ["docs"]
            ["ubercompile"]
            ["clean"]
            ["test"]
            ["uberjar"]]})
