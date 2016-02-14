(ns ^{:doc
  "Aliases from ``core.async`` for the dyslexic/syntactically challenged.

  Mostly this involves replacing:

  * ``<!`` variants with ``take*``
  * ``>!`` with ``put*``
  * ``alt*`` with ``select*``, and
  * ``go*`` with ``spawn*``.

  No deprecated functions from ``core.async`` are aliased."}
  zhang.async
  (:require [clojure.core.async :as a]
            [potemkin :refer [import-vars]])
  (:refer-clojure :exclude [into map merge reduce select take]))

(def take
  "
  Alias for ``core.async/<!`` - takes a val from port.

  ```
  (take port)
  ```

  Must be called inside a ``(spawn ...)`` block. Will return ``nil`` if closed.
  Will park if nothing is available."
  #'a/<!)

(def take-blocking
  "Alias for ``core.async/<!!`` - takes a val from port.

  ```
  (take-blocking port)
  ```

  Will return ``nil`` if closed. Will block if nothing is available."
  #'a/<!!)

(def put
  "Alias for ``core.async/>!`` - puts a val into port.

  ```
  (put val port)
  ```

  ``nil`` values are not allowed. Must be called inside a ``(spawn ...)``
  block. Will park if no buffer space is available. Returns ``true``
  unless port is already closed."
  #'a/>!)

(def put-blocking
  "Alias for ``core.async/>!!`` - puts a val into port.

  ```
  (put-blocking val port)
  ```

  ``nil`` values are not allowed. Will block if no buffer space is available.
  Returns ``true`` unless port is already closed."
  #'a/>!!)

(def select
  "Alias for ``core.async/alts!`` - completes at most one of several channel
  operations.

  ```
  (select ports & {:as opts})
  ```

  Must be called inside a ``(spawn ...)`` block. ports is a vector of
  channel endpoints, which can be either a channel to take from or a
  vector of ``[channel-to-put-to val-to-put]``, in any combination.
  Takes will be made as if by ``(take ...)``, and puts will be made as
  if by ``(put ...)``."
  #'a/alts!)

(def select-blocking
  "Alias for ``core.async/alts!!``.

  ```
  (select-blocking ports & {:as opts})
  ```

  Like ``select``, except takes will be made
  as if by ``(take-blocking ...)``, and puts will be made as if by
  ``(put-blocking ...)``. A call will block until completed; not intended
  for use in ``(spawn ...)`` blocks."
  #'a/alts!!)

(def cond-select
  "Alias for ``core.async/alt!`` (macro).

  ```
  (cond-select & clauses)
  ```

  Makes a single choice between one of
  several channel operations, as if by ``(select ...)``, returning the value
  of the result expr corresponding to the operation completed. Must be
  called inside a ``(spawn ...)`` block."
  #'a/alt!)

(def cond-select-blocking
  "Alias for ``core.async/alt!!`` (macro).

  ```
  (cond-select-blocking & clauses)
  ```

  Like ``(cond-select ...)``, except as
  if by ``(select-blocking ...)``. A call will block until completed; not
  intended for use in ``(spawn ...)`` blocks."
  #'a/alt!!)

(def do-select
  "Alias for ``core.async/do-alts``.

  ```
  (do-select fret ports opts)
  ```

  Returns derefable ``[val port]`` if
  immediate, ``nil`` if enqueued."
  #'a/do-alts)

(def spawn
  "Alias for ``core.async/go`` (macro) - asynchronously executes the body,
  returning immediately to the calling thread.

  ```
  (spawn & body)
  ```

  Additionally, any visible calls to
  ``put``, ``take``, and ``select*`` channel operations within the body will
  block (if necessary) by 'parking' the calling thread rather than tying up an
  OS thread. Upon completion of the operation, the body will be resumed."
  #'a/go)

(def spawn-loop
  "Alias for ``core.async/go-loop`` (macro).

  ```
  (spawn-loop bindings & body)
  ```

  Like ``(spawn (loop ...))``"
  #'a/go-loop)

(def take-n
  "Alias for ``core.async/take``.

  ```
  (take-n n ch)
  (take-n n ch buf-or-n)
  ```

  Returns a channel that will return, at most,
  ``n`` items from ``ch``. After ``n`` items have been returned, or ``ch`` has
  been closed, the return channel will close."
  #'a/take)

(import-vars
  [a

   ;; <!
   ;; <!!
   ;; >!
   ;; >!!
   ;; alt!
   ;; alt!!
   ;; alts!
   ;; alts!!
   admix
   buffer
   chan
   close!
   ;; do-alts
   dropping-buffer
   into
   map
   merge
   mix
   mult
   offer!
   onto-chan
   pipe
   pipeline
   pipeline-async
   pipeline-blocking
   poll!
   promise-chan
   pub
   put!
   reduce
   sliding-buffer
   solo-mode
   split
   sub
   ;; take
   take!
   tap
   thread
   thread-call
   timeout
   to-chan
   toggle
   unblocking-buffer?
   unique
   unmix
   unmix-all
   unsub
   unsub-all
   untap
   untap-all])
