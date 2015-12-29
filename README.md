bunyan
======================

Ring middleware to log the http method, url, status code and duration of each request to stdout.

Pull requests are welcome!

Usage
-----

In your `project.clj`, add the following dependency:

```clojure
[bunyan "0.1.1"]
```

Then, add the middleware to your stack.

```clojure
(ns foo
  (:require [...]
            [org.httpkit.server :refer [run-server]]
            [bunyan.core :as bunyan]))

...

(def app
  (-> (handler/api app-routes)
      (bunyan/wrap-with-logger)))

(defn -main [& args]
  (run-server app {:port config/port}))
  (println (str "Server running on port " config/port))
```

Example Logs
-----------

```bash
GET / 200 7ms # 200s are green
GET /redirect 300 7ms # 300s are yellow
POST / 404 0ms # 400s are yellow too
GET /posts 500 1ms # 500s are red
````
