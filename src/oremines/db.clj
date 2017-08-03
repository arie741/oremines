(ns oremines.db
  (:require [clj-postgresql.core :as pg]
            [clojure.java.jdbc :as jdbc]
            [csv-map.core :as csv]))

(def db (pg/pool :host "localhost:5432"
                 :user "oremines"
                 :dbname "oremines"
                 :password "admin2017"))

(defn oredata [] (csv/parse-csv (slurp "C:/Users/medy/Downloads/Rekap Disnaker 1.csv")))