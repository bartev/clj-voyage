# README #

## Set up new repo using `neil` ##

Use `neil` to setup a new repo and `deps.edu`.

```
brew install babashka/brew/neil
neil new --name myneil
cd myneil

neil dep add :lib babashka/fs :version 0.5.20
neil dep upgrade

neil add test
neil add kaocha
neil add nrepl

```

## Run with clojure cli ##

```
clj -X:test :nses '[myneil.myneil-test]'

clojure -X:watch-test
```

## Run with `bb.edn` ##

```
```

## Setting the version and tagging ##
```
neil version --help
neil version
neil version set 0.1.0
neil version patch
neil version minor
neil version major

neil version tag
```

## Other ##

```
bb test --print-config
```

## REPL ##

```
b clojure -M:nrepl
rlwrap bb clojure -M:nrepl
```

## bb.edn setup ##

```
{:tasks
 {:requires ([babashka.fs :as fs])

  test {:doc "Run tests"
        :task (apply clojure "-M:test" *command-line-args*)}

  ;; kaocha {:doc "Run tests with kaocha"
  ;;         ;; :task (apply clojure "-M:kaocha" *command-line-args*)
  ;;         :task (clojure "-M:test" *command-line-args*)}

  ;; k-watch {:doc "Run tests with kaocha watch"
  ;;          :task (apply clojure "-M:kaocha " *command-line-args*)
  ;;          }

  watch {:doc "Run tests, watching for changes"
         :task (apply clojure "-X:watch-test" *command-line-args*)}
  nrepl {:doc "Start REPL"
         :task (shell "rlwrap bb clojure -M:nrepl")}}}
```

## deps.edn setup ##

```
{:paths ["src"]
 :deps  {babashka/fs {:mvn/version "0.5.20"}}
 :aliases
 {:neil {:project {:name myneil/myneil}}

  ;; :test ;; added by neil
  ;; {:extra-paths ["test"]
  ;;  :extra-deps {io.github.cognitect-labs/test-runner
  ;;               {:git/tag "v0.5.0" :git/sha "b3fd0d2"}}
  ;;  :main-opts ["-m" "cognitect.test-runner"]
  ;;  :exec-fn cognitect.test-runner.api/test}

  ;; :kaocha ;; added by neil
  ;; {:extra-deps {lambdaisland/kaocha {:mvn/version "1.87.1366"}}
  ;;  :main-opts ["-m" "kaocha.runner"]}

  :test {:main-opts ["-m" "kaocha.runner"]
         :extra-deps {lambdaisland/kaocha {:mvn/version "1.87.1366"}}}


  :watch-test {:main-opts ["-m" "kaocha.runner"]
               :extra-deps {lambdaisland/kaocha {:mvn/version "1.87.1366"}}
               :exec-fn kaocha.runner/exec-fn
               :exec-args {:watch? true
                           :skip-meta :slow}}

  :nrepl ;; added by neil
  {:extra-deps {nrepl/nrepl {:mvn/version "1.1.1"}}
   :main-opts ["-m" "nrepl.cmdline" "--interactive" "--color"]}}}
```

## tests.edn setup ##

Include args for `kaocha` here.

Not sure about this.
```
#kaocha/v1 {:fail-fast? false}
```
