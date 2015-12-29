(ns bunyan.core
  (:require [clojure.string :refer [upper-case]]
            [bunyan.ansi :refer :all]
            [bunyan.time :refer :all]))

(defn color-status [status]
  (cond
    (< status 300) (green status)
    (< status 500) (yellow status)
    (< status 600) (red status)
    :else status))

(defn log-string [request response start-time]
  (let [ms (diff start-time (now))
        {:keys [request-method uri]} request]
    (str
      (-> request-method name upper-case bold) " "
      uri " "
      (-> response :status color-status) " "
      ms "ms")))

(defn log [request response start-time]
  (println (log-string request response start-time)))

(defn wrap-with-logger [handler]
  (fn [request]
    (let [start-time (now)
          {:keys [uri request-method]} request
          response (handler request)]
      (log request response start-time)
      response)))
