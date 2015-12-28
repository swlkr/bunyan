(ns bunyan.core-test
  (:require [clojure.test :refer :all]
            [bunyan.core :refer :all]
            [bunyan.utils :refer [now]]))

(deftest log-string-should-return-a-formatted-string
  (testing "log"
    (is (= (log-string {:uri "/" :request-method "get"} {:status 200} (now)) "\033[1mGET\033[0m / \033[32m200\033[0m 0ms"))))
