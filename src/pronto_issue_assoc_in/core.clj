(ns pronto-issue-assoc-in.core
  (:gen-class)
  (:require
    [pronto.core :as pronto]
    [pronto.utils :as pronto-utils])
  (:import (person PersonOuterClass$Person)))

(pronto/defmapper
  my-mapper
  [PersonOuterClass$Person]
  :key-name-fn pronto-utils/->kebab-case
  :enum-value-fn pronto-utils/->kebab-case)

(defn -main
  "I don't do a whole lot ... yet."
  [& _]
  ; works
  (pronto/pcond-> (pronto/proto-map my-mapper
                                    PersonOuterClass$Person
                                    :name "Name")
                  (some? nil) (assoc-in [:address :city] "Tel-Aviv"))

  ; don't work
  (pronto/pcond-> (pronto/proto-map my-mapper
                                    PersonOuterClass$Person
                                    :name "Name")
                  (some? nil) (assoc-in [:b :city] "Tel-Aviv")))
