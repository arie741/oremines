(ns oremines.routes.home
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/:asd" [asd]
  	(str asd))
  (route/not-found "Not Found"))