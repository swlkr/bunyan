(ns bunyan.ansi)

(def ansi-codes {:red    "[31m"
                 :green  "[32m"
                 :yellow "[33m"
                 :bold   "[1m"
                 :reset  "[0m"})

(defn style [text key]
  (let [code (get ansi-codes key)
        reset (:reset ansi-codes)]
    (str "\033" code text "\033" reset)))

(defn define-color-function [key]
  (intern *ns* (symbol (name key))
    (fn [text]
      (style text key))))

; Create a function in the current namespace
; for every key in the ansi-codes map
(doseq [k (keys ansi-codes)]
  (define-color-function k))
