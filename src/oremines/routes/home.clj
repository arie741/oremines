(ns oremines.routes.home
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [oremines.db :as db]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/:asd" [asd]
  	(apply str (db/oredata)))
  (route/not-found "Not Found"))