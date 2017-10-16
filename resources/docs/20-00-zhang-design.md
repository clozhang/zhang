# Zhang Design

## Development Plan

During the initial stage of development, focus will be on best idiomatic use
of Clojure and `core.async` programming to provide the desired features,
without considering the implementation details of the Erlang distribution
model.

* Create a partial system using only `core.async`
   * System will entail a single JVM
   * Will support numerous in-JVM nodes
* Add support for multi-JVM instances
   * IPC/UNIX domain sockets?
* Add support for multi-host JVM instances
   * What protocol?

With a solid Clojure foundation in place, support will be added for the Erlang
process and distribution model.

* Integrate with `epmd`
* Add support for the Erlang distribution protocol (wire-level)
* Add support for OTP nodes
* Add support for OTP message boxes

## Clojure Implementation Tiers

### Host-level Coordination

* Is there sometihng comparable to `epmd` in the JVM ecosystem?

### A Single JVM

* Create Zhang JVM agent
* Initial development: blue sky, no Erlangisms
    * New architecture taking advantage of the JVM/Clojure
        * Envision and develop a system without Erlang idiosyncracies
        * Reference original design goals of Erlang
        * Use net(ty) and core.async
        * Take maximal advantage of core.async features/abilities
    * Implement whole system in pure-Clojure
        * Process table

* Atomic hash-map used as store for data
    * process list
    * next available pid
* Message-passing to/from agent (via core.async)

* Spawned Functions
* Process List per JVM
* Node list per host

### Inter-JVMs, Same Host

* IPC?
* ???

### Inter-host JVM

* `net`/`netty`
* ???

## Erlang Implementation Tiers

### `empd` Integration

* Much of this already exists
* Supporting functions
   * Use `clozhang.epmd`
   * Add `erl`-like feature that starts `epmd` if it's not running


### Distribution Protocol

* Write a `net`/`netty` pipeline
   * Implement `net` encoder & decoder
   * ???
* ???

### OTP Nodes

TBD

### OTP Message Boxes

TBD
