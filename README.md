# 張 zhang

[![Build Status][travis-badge]][travis]
[![Dependencies Status][deps-badge]][deps]
[![Clojars Project][clojars-badge]][clojars]

*An implementation of the Erlang process model in Clojure core.async*

[![][logo]][logo-large]


#### Table of Contents

* [Introduction](#introduction-)
* [Documentation](#documentation-)
* [Usage](#usage-)
* [Background](#background-)
  * [Origins](#origins-)
  * [Erlang, JInterface, & Clojang](#erlang-jinterface--clojang-)
  * [Akka/Okku & Quasar/Pulsar](#akkaokku--quasarpulsar-)
  * [A Note on the Name](#a-note-on-the-name-)
* [License](#license-)


## Introduction [&#x219F;](#table-of-contents)

The zhang project aims to create a very minimal library in Clojure, built on
core.async, that, as closely as possible, implements the Erlang process model.
It *does not* aim to provide any opionions about (and thus even less, any
implementations for) either message structure or infrastructure necessary for
supporting remote processes.

As such, zhang should be a general-purpose, low-level library for the JVM
ideally suited for anyone who is interested in building systems with functions
that offer capabilities of communication.

Desired features include:

* quickly creating and destroying processes
* safe "crashing" of a process
* quickly sending messages between processes
* support large numbers of processes
* shared nothing
* message passing
* function mailboxes
* ordered save queues
* timeouts
* pattern matching (core.match) and selective receive
* process registration hooks (in order to support arbitrary publishing mechanisms)

How processes register with a publication mechanism and how they communicate
with each other (either locally or remotely) is beyond the scope of the zhang
library. As an example, the Clojang library (which intends to use zhang) will
provide implementation details for these -- it just needs an underlying
process model amenable to its implementation goals.


## Documentation [&#x219F;](#table-of-contents)

Documentation for zhang is regularly generated and made available here:

* http://clojang.github.io/zhang/current

Related documentation:

* http://clojang.github.io/jiface/current
* http://clojang.github.io/clojang/current


## Usage [&#x219F;](#table-of-contents)

TBD


## Background [&#x219F;](#table-of-contents)

TBD


### Origins [&#x219F;](#table-of-contents)

The zhang project came about, like so many software projects, through the
time-honored process of yak-shaving. The particular yak that spawned zhang was
associated with the [Clojang](https://github.com/clojang/clojang) project,
which in turn was a yak-shaving response to Erlang's [JInterface](http://erlan
g.org/doc/apps/jinterface/jinterface_users_guide.html) (in particular the
desire to have a low-level Clojure-idiomatic wrapper for JInterface).

One of the issues that arose when working on Clojang was the number of threads
created when connecting nodes and the lack of light-weight (non-OS) processes
for creating Clojure servers that communicate with Erlang processes. This
limits the number of nodes that can be created and doesn't really allow
programmers to fully explore the power of Erlang's processing model on the
JVM. (In all fairness, this was never the intent of JInterface; instead, it is
a Java translation of
[Erlang Ports](http://erlang.org/doc/reference_manual/ports.html),
allowing basic interoperability between Java and Erlang programs.)

To work around this, we wanted to create servers in Clojure using the
core.async library, which brings light-weight, non-OS processes to Clojure
programmers. The core.async library was inspired by Tony Hoare's work on
communicating sequential processes (CSP) originally described in a 1978 paper.
That paper (and significant subsequent work) influenced the design of
concurrency in the C# language as well as the concurrency model used in the Go
programming language. Both of these heavily influenced the design and
implementation of core.async in Clojure.

And this is the purpose of zhang: to build a close approximation of the Erlang
process model using the channels, messages, ``go`` blocks, etc., of Clojure's
core.async library -- thus allowing us to create highly scalable, concurrent
applications in Clojure.


### Erlang, JInterface, & Clojang [&#x219F;](#table-of-contents)

TBD


### Akka/Okku & Quasar/Pulsar [&#x219F;](#table-of-contents)

TBD


### A Note on the Name [&#x219F;](#table-of-contents)

The zhang project takes it's name from
[Zhang Heng](https://en.wikipedia.org/wiki/Zhang_Heng),
who approximated π early in the first millennium (Han Dynasty). This is an
obscure pun, since the Erlang process model could be, in some ways,
interpreted as an approximation of the
[π-calculus](https://en.wikipedia.org/wiki/%CE%A0-calculus). In addition to
being a mathematician, Zhang Heng was also a poet, astronomer, and engineer --
a wonderful patron for a software project!


## License

Copyright © 2016-2017 Duncan McGreggor

Distributed under the Apache License, Version 2.0.


<!-- Named page links below: /-->

[travis]: https://travis-ci.org/clojang/zhang
[travis-badge]: https://travis-ci.org/clojang/zhang.png?branch=master
[deps]: http://jarkeeper.com/clojang/zhang
[deps-badge]: http://jarkeeper.com/clojang/zhang/status.svg
[clojars]: https://clojars.org/zhang
[clojars-badge]: https://img.shields.io/clojars/v/zhang.svg
[logo]: resources/images/Zhang_Heng-2-250x.png
[logo-large]: resources/images/Zhang_Heng-2-600x.png
