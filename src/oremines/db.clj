(ns oremines.db
  (:require [clj-postgresql.core :as pg]
            [clojure.java.jdbc :as jdbc]))

(def db (pg/pool :host "localhost:5432"
                 :user "oremines"
                 :dbname "oremines"
                 :password "admin2017"))
