#  • Process Calculi

From [Wikipedia](https://en.wikipedia.org/wiki/Process_calculus):

In computer science, the process calculi (or process algebras) are a diverse family of related approaches for formally modelling concurrent systems. Process calculi provide a tool for the high-level description of interactions, communications, and synchronizations between a collection of independent agents or processes. They also provide algebraic laws that allow process descriptions to be manipulated and analyzed, and permit formal reasoning about equivalences between processes.

## Precursors

* [Lambda Calculus](https://en.wikipedia.org/wiki/Lambda_calculus) (1936)
* [Petri nets](https://en.wikipedia.org/wiki/Petri_net) (1962)
* [Actor model](https://en.wikipedia.org/wiki/Actor_model) (1973)

## Examples of Process Calculi

Leading examples of process calculi include the following:

* [CSP](https://en.wikipedia.org/wiki/Communicating_Sequential_Processes) (1977; influenced occam, Go, Clojure core.async)
* [CCS](https://en.wikipedia.org/wiki/Calculus_of_communicating_systems) (1980)
* [ACP](https://en.wikipedia.org/wiki/Algebra_of_Communicating_Processes) (1982)
* [LOTOS](https://en.wikipedia.org/wiki/Language_Of_Temporal_Ordering_Specification) (1988)
* [the π-calculus](https://en.wikipedia.org/wiki/%CE%A0-calculus) (1992)
* [the join-calculus](https://en.wikipedia.org/wiki/Join-calculus) (1995)
* [PEPA](https://en.wikipedia.org/wiki/PEPA) (1996)
* [the ambient calculus](https://en.wikipedia.org/wiki/Ambient_calculus) (1998)

## Essential Features

While the variety of existing process calculi is very large (including variants that incorporate stochastic behaviour, timing information, and specializations for studying molecular interactions), there are several features that all process calculi have in common:

* Representing interactions between independent processes as communication (
  message-passing), rather than as modification of shared variables.
* Describing processes and systems using a small collection of primitives, and
  operators for combining those primitives.
* Defining algebraic laws for the process operators, which allow process
  expressions to be manipulated using equational reasoning.

Key operations that processes need to support:

* Parallel composition of processes
* Specification of which channels to use for sending and receiving data
* Sequentialization of interactions
* Hiding of interaction points
* Recursion or process replication
