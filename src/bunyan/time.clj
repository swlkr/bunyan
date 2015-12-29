(ns bunyan.time)

(defn now []
  (new java.util.Date))

(defn diff [start end]
  (- (.getTime end) (.getTime start)))
