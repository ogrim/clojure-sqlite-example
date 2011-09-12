(ns clojure-sqlite-example.core
  (:use [clojure.java.jdbc]))

(def testdata
  {:date "2011-9-12",
   :url "http://example.com",
   :title "SQLite Example",
   :body "Example using SQLite with Clojure"
   })

(def db
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     "db/database.db"
   })

(defn create-db []
  (try (with-connection db 
         (create-table :news
                       [:date :text]
                       [:url :text]
                       [:title :text]
                       [:body :text]))
       (catch Exception e (println e))))

(create-db)

(with-connection db
  (insert-records :news testdata))

(def output
  (with-connection db
    (with-query-results rs ["select * from news"] (doall rs))))

(keys (first output))

