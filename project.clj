(def proto-version "3.20.0")

(defproject pronto-issue-assoc-in "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :java-source-paths ["src/java" "src/java/generated"]
  :dependencies [[org.clojure/clojure "1.10.3"]

                 ; Protobuf
                 [com.google.protobuf/protobuf-java ~proto-version]
                 [com.appsflyer/pronto "2.1.0"]]
  :main ^:skip-aot pronto-issue-assoc-in.core
  :target-path "target/%s"
  :lein-protodeps {:output-path   "src/java/generated"
                   :proto-version ~proto-version
                   :compile-grpc? false
                   :repos         {:local-proto {:repo-type    :filesystem
                                                 :config       {:path ""}
                                                 :proto-paths  ["schemas"]
                                                 :dependencies [[""]]}}}
  :profiles {:uberjar {:aot      :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :dev     {:plugins [; Protobuf
                                 [com.appsflyer/lein-protodeps "1.0.3"]]}})
