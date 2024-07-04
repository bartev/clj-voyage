(ns my.core
  (:import
   [javax.swing SwingUtilities JFrame JLabel SwingConstants]
   [java.awt BorderLayout Color]))


(def bar "bbar")
;; => #'my.core/bar

(. Math PI)
;; => 3.141592653589793

(keys (.. System getProperties))

(. System .getProperties .get "java.version")

(get "java.version" )

(get (.. System getProperties) "java.version")
;; => "21.0.2"

(.. System getProperties (get "java.version"))
;; => "21.0.2"

(. (. System getProperties) (get "java.version"))
;; => "21.0.2"

(->
 (.. System getProperties)
 (get "java.version"))
;; => "21.0.2"

(. System getProperties)
;; => {"java.specification.version" "21", "sun.jnu.encoding" "UTF-8", "java.class.path" "dev:test:src:resources:/Users/bartev/.m2/repository/cider/cider-nrepl/0.45.0/cider-nrepl-0.45.0.jar:/Users/bartev/.m2/repository/clj-commons/clj-yaml/1.0.27/clj-yaml-1.0.27.jar:/Users/bartev/.m2/repository/com/bhauman/rebel-readline/0.1.4/rebel-readline-0.1.4.jar:/Users/bartev/.m2/repository/com/brunobonacci/mulog/0.9.0/mulog-0.9.0.jar:/Users/bartev/.m2/repository/criterium/criterium/0.4.6/criterium-0.4.6.jar:/Users/bartev/.m2/repository/djblue/portal/0.51.1/portal-0.51.1.jar:/Users/bartev/.m2/repository/lambdaisland/kaocha/1.87.1366/kaocha-1.87.1366.jar:/Users/bartev/.m2/repository/nrepl/nrepl/1.1.0/nrepl-1.1.0.jar:/Users/bartev/.m2/repository/org/clojure/clojure/1.11.1/clojure-1.11.1.jar:/Users/bartev/.m2/repository/org/clojure/test.check/1.1.1/test.check-1.1.1.jar:/Users/bartev/.m2/repository/org/clojure/tools.namespace/1.4.5/tools.namespace-1.4.5.jar:/Users/bartev/.m2/repository/org/clojure/tools.trace/0.7.11/tools.trace-0.7.11.jar:/Users/bartev/.m2/repository/org/slf4j/slf4j-nop/2.0.12/slf4j-nop-2.0.12.jar:/Users/bartev/.m2/repository/ring/ring-mock/0.4.0/ring-mock-0.4.0.jar:/Users/bartev/.m2/repository/cider/orchard/0.22.0/orchard-0.22.0.jar:/Users/bartev/.m2/repository/mx/cider/logjam/0.2.0/logjam-0.2.0.jar:/Users/bartev/.m2/repository/org/flatland/ordered/1.15.11/ordered-1.15.11.jar:/Users/bartev/.m2/repository/org/yaml/snakeyaml/2.1/snakeyaml-2.1.jar:/Users/bartev/.m2/repository/cljfmt/cljfmt/0.5.7/cljfmt-0.5.7.jar:/Users/bartev/.m2/repository/compliment/compliment/0.3.6/compliment-0.3.6.jar:/Users/bartev/.m2/repository/org/jline/jline-reader/3.5.1/jline-reader-3.5.1.jar:/Users/bartev/.m2/repository/org/jline/jline-terminal/3.5.1/jline-terminal-3.5.1.jar:/Users/bartev/.m2/repository/org/jline/jline-terminal-jansi/3.5.1/jline-terminal-jansi-3.5.1.jar:/Users/bartev/.m2/repository/amalloy/ring-buffer/1.3.1/ring-buffer-1.3.1.jar:/Users/bartev/.m2/repository/com/cognitect/transit-clj/1.0.333/transit-clj-1.0.333.jar:/Users/bartev/.m2/repository/com/cognitect/transit-cljs/0.8.280/transit-cljs-0.8.280.jar:/Users/bartev/.m2/repository/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar:/Users/bartev/.m2/repository/http-kit/http-kit/2.7.0/http-kit-2.7.0.jar:/Users/bartev/.m2/repository/org/clojure/data.json/2.4.0/data.json-2.4.0.jar:/Users/bartev/.m2/repository/aero/aero/1.1.6/aero-1.1.6.jar:/Users/bartev/.m2/repository/com/nextjournal/beholder/1.0.2/beholder-1.0.2.jar:/Users/bartev/.m2/repository/expound/expound/0.9.0/expound-0.9.0.jar:/Users/bartev/.m2/repository/hawk/hawk/0.2.11/hawk-0.2.11.jar:/Users/bartev/.m2/repository/lambdaisland/deep-diff2/2.10.211/deep-diff2-2.10.211.jar:/Users/bartev/.m2/repository/lambdaisland/tools.namespace/0.3.256/tools.namespace-0.3.256.jar:/Users/bartev/.m2/repository/meta-merge/meta-merge/1.0.0/meta-merge-1.0.0.jar:/Users/bartev/.m2/repository/org/clojure/spec.alpha/0.3.218/spec.alpha-0.3.218.jar:/Users/bartev/.m2/repository/org/clojure/tools.cli/1.0.219/tools.cli-1.0.219.jar:/Users/bartev/.m2/repository/org/tcrawley/dynapath/1.1.0/dynapath-1.1.0.jar:/Users/bartev/.m2/repository/progrock/progrock/0.1.2/progrock-0.1.2.jar:/Users/bartev/.m2/repository/slingshot/slingshot/0.12.2/slingshot-0.12.2.jar:/Users/bartev/.m2/repository/org/clojure/core.specs.alpha/0.2.62/core.specs.alpha-0.2.62.jar:/Users/bartev/.m2/repository/org/clojure/java.classpath/1.0.0/java.classpath-1.0.0.jar:/Users/bartev/.m2/repository/org/clojure/tools.reader/1.3.6/tools.reader-1.3.6.jar:/Users/bartev/.m2/repository/org/slf4j/slf4j-api/2.0.12/slf4j-api-2.0.12.jar:/Users/bartev/.m2/repository/cheshire/cheshire/5.8.1/cheshire-5.8.1.jar:/Users/bartev/.m2/repository/ring/ring-codec/1.1.1/ring-codec-1.1.1.jar:/Users/bartev/.m2/repository/rewrite-clj/rewrite-clj/0.5.2/rewrite-clj-0.5.2.jar:/Users/bartev/.m2/repository/rewrite-cljs/rewrite-cljs/0.4.3/rewrite-cljs-0.4.3.jar:/Users/bartev/.m2/repository/org/fusesource/jansi/jansi/1.16/jansi-1.16.jar:/Users/bartev/.m2/repository/com/cognitect/transit-java/1.0.371/transit-java-1.0.371.jar:/Users/bartev/.m2/repository/com/cognitect/transit-js/0.8.874/transit-js-0.8.874.jar:/Users/bartev/.m2/repository/io/methvin/directory-watcher/0.17.3/directory-watcher-0.17.3.jar:/Users/bartev/.m2/repository/net/incongru/watchservice/barbary-watchservice/1.0/barbary-watchservice-1.0.jar:/Users/bartev/.m2/repository/fipp/fipp/0.6.26/fipp-0.6.26.jar:/Users/bartev/.m2/repository/lambdaisland/clj-diff/1.4.78/clj-diff-1.4.78.jar:/Users/bartev/.m2/repository/mvxcvi/arrangement/2.1.0/arrangement-2.1.0.jar:/Users/bartev/.m2/repository/org/clojure/core.rrb-vector/0.1.2/core.rrb-vector-0.1.2.jar:/Users/bartev/.m2/repository/com/fasterxml/jackson/dataformat/jackson-dataformat-cbor/2.9.6/jackson-dataformat-cbor-2.9.6.jar:/Users/bartev/.m2/repository/com/fasterxml/jackson/dataformat/jackson-dataformat-smile/2.9.6/jackson-dataformat-smile-2.9.6.jar:/Users/bartev/.m2/repository/tigris/tigris/0.1.1/tigris-0.1.1.jar:/Users/bartev/.m2/repository/commons-codec/commons-codec/1.11/commons-codec-1.11.jar:/Users/bartev/.m2/repository/org/clojure/clojurescript/1.7.228/clojurescript-1.7.228.jar:/Users/bartev/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.14.2/jackson-core-2.14.2.jar:/Users/bartev/.m2/repository/javax/xml/bind/jaxb-api/2.4.0-b180830.0359/jaxb-api-2.4.0-b180830.0359.jar:/Users/bartev/.m2/repository/org/msgpack/msgpack/0.6.12/msgpack-0.6.12.jar:/Users/bartev/.m2/repository/net/java/dev/jna/jna/5.12.1/jna-5.12.1.jar:/Users/bartev/.m2/repository/com/google/javascript/closure-compiler/v20151216/closure-compiler-v20151216.jar:/Users/bartev/.m2/repository/org/clojure/google-closure-library/0.0-20151016-61277aea/google-closure-library-0.0-20151016-61277aea.jar:/Users/bartev/.m2/repository/org/mozilla/rhino/1.7R5/rhino-1.7R5.jar:/Users/bartev/.m2/repository/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0.jar:/Users/bartev/.m2/repository/com/googlecode/json-simple/json-simple/1.1.1/json-simple-1.1.1.jar:/Users/bartev/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/Users/bartev/.m2/repository/org/clojure/google-closure-library-third-party/0.0-20151016-61277aea/google-closure-library-third-party-0.0-20151016-61277aea.jar", "java.vm.vendor" "Homebrew", "sun.arch.data.model" "64", "java.vendor.url" "https://github.com/Homebrew/homebrew-core/issues", "user.timezone" "America/Chicago", "clojure.basis" ".cpcache/2206398787.basis", "java.vm.specification.version" "21", "os.name" "Mac OS X", "sun.java.launcher" "SUN_STANDARD", "user.country" "US", "sun.boot.library.path" "/opt/homebrew/Cellar/openjdk/21.0.2/libexec/openjdk.jdk/Contents/Home/lib", "sun.java.command" "clojure.main --eval (apply require clojure.main/repl-requires) --main nrepl.cmdline --middleware [cider.nrepl/cider-middleware,portal.nrepl/wrap-portal] --interactive -f rebel-readline.main/-main", "http.nonProxyHosts" "local|*.local|169.254/16|*.169.254/16", "jdk.debug" "release", "sun.cpu.endian" "little", "user.home" "/Users/bartev", "user.language" "en", "java.specification.vendor" "Oracle Corporation", "java.version.date" "2024-01-16", "java.home" "/opt/homebrew/Cellar/openjdk/21.0.2/libexec/openjdk.jdk/Contents/Home", "file.separator" "/", "java.vm.compressedOopsMode" "Zero based", "line.separator" "\n", "java.vm.specification.vendor" "Oracle Corporation", "java.specification.name" "Java Platform API Specification", "apple.awt.application.name" "main", "sun.management.compiler" "HotSpot 64-Bit Tiered Compilers", "ftp.nonProxyHosts" "local|*.local|169.254/16|*.169.254/16", "java.runtime.version" "21.0.2", "user.name" "bartev", "stdout.encoding" "UTF-8", "path.separator" ":", "os.version" "14.5", "java.runtime.name" "OpenJDK Runtime Environment", "file.encoding" "UTF-8", "java.vm.name" "OpenJDK 64-Bit Server VM", "java.vendor.version" "Homebrew", "java.vendor.url.bug" "https://github.com/Homebrew/homebrew-core/issues", "java.io.tmpdir" "/var/folders/zc/tbdf79nj7m1_jkn65fr8tj3m0000gn/T/", "java.version" "21.0.2", "user.dir" "/Users/bartev/dev/github/clj-voyage/rhickey", "os.arch" "aarch64", "java.vm.specification.name" "Java Virtual Machine Specification", "native.encoding" "UTF-8", "java.library.path" "/Users/bartev/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.", "java.vm.info" "mixed mode, sharing", "stderr.encoding" "UTF-8", "java.vendor" "Homebrew", "java.vm.version" "21.0.2", "sun.io.unicode.encoding" "UnicodeBig", "apple.awt.UIElement" "true", "socksNonProxyHosts" "local|*.local|169.254/16|*.169.254/16", "java.class.version" "65.0"}

(new java.util.Date)
;; => #inst "2024-07-04T16:36:47.851-00:00"
;; => #inst "2024-07-04T16:34:03.617-00:00"

(doto (JFrame.)
  (add (JLabel. "Hello World")) pack show)

(def f
  (doto (JFrame.) (add (JLabel. "hello world")) pack show))


(defn myfun [x] x)
;; => #'my.core/myfun

(meta myfun)
;; => nil
;; => nil

(-> #'myfun meta :name)
;; => myfun
;; => map

(def functions [myfun])
;; => #'My.Core/Functions

(map meta functions)

(clojure.repl/demunge (str myfun))
;; => "my.core/myfun@17229b2f"
;; => "clojure.core/map?--5477@400bc148"

(defn- pretty-demunge
  "Return the demunged function name as a string.
  The name includes the namespace.
  https://stackoverflow.com/questions/22116257/how-to-get-functions-name-as-string-in-clojure"
  [fn-object]
  (let [dem-fn (clojure.main/demunge (str fn-object))
        pretty (second (re-find #"(.*?\/.*?)[\-\-|@].*" dem-fn))]
    (if pretty pretty dem-fn)))

(pretty-demunge map?)
;; => "clojure.core/map?"

(pretty-demunge myfun)
;; => "my.core/myfun"

(-> myfun
    str
    clojure.main/demunge)
;; => "my.core/myfun@17229b2f"

(map pretty-demunge functions)
;; => ("my.core/myfun")

(defmacro fn-name
  "Get the function name as a string
  https://stackoverflow.com/questions/22116257/how-to-get-functions-name-as-string-in-clojure"
  [f]
  `(-> ~f
       var
       meta        :name
       str))
(fn-name myfun)

(defmacro fn-ns-name
  "Get the function name as a string"
  [f]
  `(-> ~f
       var
       meta
       :ns
       str))

(fn-ns-name myfun)

;; => {:arglists ([x]),
;;     :line 40,
;;     :column 1,
;;     :file "/Users/bartev/dev/github/clj-voyage/rhickey/src/my/core.clj",
;;     :name myfun,
;;     :ns #namespace[my.core]}
