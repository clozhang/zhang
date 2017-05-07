# Zhang Design

Host-level magagement:

* Handled by epmd
* Supporting functions
   * Use `clojang.epmd`
   * Add `erl`-like feature that starts `epmd` if it's not running

JVM-level management:

* Handled by Zhang JVM agent
* Initial development: blue sky, no Erlangisms
    * New architecture taking advantage of the JVM/Clojure
        * Envision and develop a system without Erlang idiosyncracies
        * Use same design goals
        * Use net(ty) and core.async
        * Take maximal advantage of core.async features/abilities
    * Implement whole system in pure-Clojure
        *
* Once
* Atomic hash-map used as store for data
    * process list
    * next available pid
* Message-passing to/from agent (via core.async)

* Spawned Functions
* Process List per JVM
* Node list per host
