(ns oremines.routes.home
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [oremines.db :as db]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/ores" []
  	(str (count (db/ores "C:/Users/medy/Downloads/Rekap Disnaker 2.xlsx" "SMK PGRI109"))))
  (GET "/in" []
    (db/insertm (db/ores "C:/Users/medy/Downloads/Rekap Disnaker 2.xlsx" "SMK PGRI109")))
  (route/not-found "Not Found"))