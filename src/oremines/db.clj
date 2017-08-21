(ns oremines.db
  (:require [clj-postgresql.core :as pg]
            [clojure.java.jdbc :as jdbc]
            [csv-map.core :as csv]
            [dk.ative.docjure.spreadsheet :as sps]))

(def db (pg/pool :host "localhost:5432"
                 :user "oremines"
                 :dbname "oremines"
                 :password "admin2017"))

(defn oredata [dat dsheet] 
	(->> 
		(sps/load-workbook dat)
     	(sps/select-sheet dsheet)
     	(sps/select-columns {
;                           :A :no
     						:B :nama, 
     						:C :usia, 
     						:D :sex, 
     						:E :sekolah, 
     						:F :jurusan, 
     						:G :email, 
     						:H :phone, 
     						:I :kode, 
     						:J :keterangan, 
     						:K :R, 
     						:L :I, 
     						:M :A, 
     						:N :S, 
     						:O :E, 
     						:P :C})))

(defn ores [dat dsheet]
    (filterv :nama (drop 3
        (apply vector (oredata dat dsheet)))))

(defn insertm [dat]
    (jdbc/insert-multi!  db :ore
        dat))

;ex data [{:nama "as3d" :usia "4" :sex "F" :sekolah "asdasda" :jurusan "asdsada" :email "asddda" :phone "12321321" :kode "2312" :keterangan "adadadsa" :r "2" :i "2" :a "4" :s "6" :e "8" :c "1"}
;        {:nama "asd" :usia "4" :sex "F" :sekolah "asdasda" :jurusan "asdsada" :email "asddda" :phone "12321321" :kode "2312" :keterangan "adadadsa" :r "2" :i "2" :a "4" :s "6" :e "8" :c "1"}]