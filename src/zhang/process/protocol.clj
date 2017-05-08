(ns zhang.process.protocol)

(defprotocol ZhangProcessFactory
  "Zhang supports creating its processes in the following ways."
  (spawn
    [this fun]
    [this node fun]
    [this ns fun args]
    [this node ns fun args]
    "Runs a function in a light-weight, non-OS/non-JVM thread (the exact
    mechanism used is up to the implementation). Returns a ZhangProcess.")
  (spawn-linked
    [this]
    "")
  (spawn-managed
    [this]
    ""))

(defprotocol ZhangProcess
  "Zhang processes support the following "
  (id
    [this]
    "Returns the implementation-specific id, the means by which one process is
    distinguised from another, or the means by which a process may be
    communicated.")
  (!
    [this msg]
    "")
  (receive
    [this]
    "")
  (terminate
    [this]
    ""))
