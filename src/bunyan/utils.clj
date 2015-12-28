(ns bunyan.utils
  (:require [clojure.string :refer [join]]))

(defn safe-println [& more]
  (.write *out* (str (join " " more) "\n")))

(defn now []
  (new java.util.Date))

(defn diff [start end]
  (- (.getTime end) (.getTime start)))
