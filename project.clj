(defproject clojure-sqlite-example "0.2.1"
  :description "A simple example of using SQLite with Clojure"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/java.jdbc "0.7.8"]
                 [org.xerial/sqlite-jdbc "3.23.1"]]
  :main ^:skip-aot clojure-sqlite-example.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
