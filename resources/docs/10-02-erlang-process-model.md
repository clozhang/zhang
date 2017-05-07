#  • The Erlang Process Model

The Erlang "process" model is a bit of a misnomer: this is a concept that
includes elements "below" the process level (functions), at the process level
(processes, message-passing), and "above" the process level (nodes, `epmd`).
It is this broad spectrum that Zhang aims to implmenent in the Clojure
ecosystem, using appropriate JVM and Clojure libraries for the best possible
performance, developer experience, and deplyment capabilities.

## References

* Getting Started with Erlang: [Concurrent Programming](http://erlang.org/doc/getting_started/conc_prog.html)
* Erlang Reference Manual:  [Processes](http://erlang.org/doc/reference_manual/processes.html)
