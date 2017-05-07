#  • JInterface Conceptual Components

#### Contents
* [The Purpose of JInterface](#purpose)
* [How It Works](#how-it-works)
* [Components](#components)
* [The Benefits of JInterface](#benefits)
* [JInterface Downsides](#downsides)
* [What the JVM Ecosystem Does Better](#jvm-pros)
* [What Zhang Needs](#needed)

<a name="purpose">

## The Purpose of JInterface

From the Erlang [JInterface User's Guide](http://erlang.org/doc/apps/jinterface/jinterface_users_guide.html):

<blockquote>
  The JInterface package provides a set of tools for communication with Erlang
  processes. It can also be used for communication with other Java processes
  using the same package, as well as C processes using the Erl_Interface
  library.
</blockquote>

<a name="how-it-works">

## How it Works

Since the JInterface package provides a mechanism for communicating with
Erlang, message recipients can be Erlang processes or instances of analogous
Java objects (namely, `com.ericsson.otp.erlang.OtpMbox`). In either case,
these are identified with process ids (pids) and possibly registered names.

JInterface makes possible JVM-Erlang communication using the native Erlang
communication protocol. It does this via JInterface Java classes which support
the following:

 * manipulation of data represented as Erlang data types
 * conversion of data between Java and Erlang formats
 * encoding and decoding of Erlang data types for transmission or storage
 * communication between Java nodes and Erlang processes

See the [JInterface User's Guide](http://erlang.org/doc/apps/jinterface/jinterface_users_guide.html)
for more information on JInterface. (Note that versions of that document have
been provided for both
[jiface](http://clojang.github.io/jiface/current/10-low-level-api.html)
and
[clojang](http://clojang.github.io/clojang/current/20-mid-level-api.html)
with example code provided using the respective library for the document.)

From the documentation on the
[Distribution Protocol](http://erlang.org/doc/apps/erts/erl_dist_protocol.html)
in the Erlang Run-Time System Application User's Guide:

The distribution protocol can be divided into four parts:

1. Low-level socket connection
1. Handshake, interchange node name
1. Challenge/Response
1. Full connection to remote node

A typical flow through JInterface might go like the following:

[More details forthcoming ...]

[Add a visual representation of this ...]

<a name="components">

## The Components

We may loosely group the JInterface components into the following categories:

* Types
* Streams
* Sockets
* Connections
* Nodes
* OTP Links

The first two will likely remain as-is, with Zhang using them via their
`jiface` or `clojang` library wrappers, while the remaining four will be
reimplemented in Zhang.

In the next section, we break this down by source file.

### Source Files

Here is the complete listing of the Java source files found in
`erlang/19.3/lib/jinterface-1.7.1/java_src/com/ericsson/otp/erlang`:

 * `AbstractConnection.java`
 * `AbstractNode.java`
 * `GenericQueue.java`
 * `Link.java`
 * `Links.java`
 * `OtpAuthException.java`
 * `OtpConnection.java`
 * `OtpCookedConnection.java`
 * `OtpEpmd.java`
 * `OtpErlangAtom.java`
 * `OtpErlangBinary.java`
 * `OtpErlangBitstr.java`
 * `OtpErlangBoolean.java`
 * `OtpErlangByte.java`
 * `OtpErlangChar.java`
 * `OtpErlangDecodeException.java`
 * `OtpErlangDouble.java`
 * `OtpErlangException.java`
 * `OtpErlangExit.java`
 * `OtpErlangExternalFun.java`
 * `OtpErlangFloat.java`
 * `OtpErlangFun.java`
 * `OtpErlangInt.java`
 * `OtpErlangList.java`
 * `OtpErlangLong.java`
 * `OtpErlangMap.java`
 * `OtpErlangObject.java`
 * `OtpErlangPid.java`
 * `OtpErlangPort.java`
 * `OtpErlangRangeException.java`
 * `OtpErlangRef.java`
 * `OtpErlangShort.java`
 * `OtpErlangString.java`
 * `OtpErlangTuple.java`
 * `OtpErlangUInt.java`
 * `OtpErlangUShort.java`
 * `OtpException.java`
 * `OtpExternal.java`
 * `OtpInputStream.java`
 * `OtpLocalNode.java`
 * `OtpMbox.java`
 * `OtpMD5.java`
 * `OtpMsg.java`
 * `OtpNode.java`
 * `OtpNodeStatus.java`
 * `OtpOutputStream.java`
 * `OtpPeer.java`
 * `OtpSelf.java`
 * `OtpServer.java`
 * `OtpServerSocketTransport.java`
 * `OtpServerTransport.java`
 * `OtpSocketTransportFactory.java`
 * `OtpSocketTransport.java`
 * `OtpSystem.java`
 * `OtpTransportFactory.java`
 * `OtpTransport.java`

Some of these will remain, others will be removed. Most significantly, the meat
of the networking code will be completely replaced with something much more
performant:

 * *No Change*
     * Erlang Data Types
     * Reading/Writing Encoded Streams
     * Exception Classes
     * Constants
 * *Will Be Replaced*
     * Sockets
     * EPMD & Connections
     * Nodes
     * Linking
 * *Will Be Removed*
     * Interfaces
     * Utilities
     * Deprecated

Source files are grouped into these below, with more information provided.

#### Erlang Data Types

 * `OtpErlangAtom.java`
 * `OtpErlangBinary.java`
 * `OtpErlangBitstr.java`
 * `OtpErlangBoolean.java`
 * `OtpErlangByte.java`
 * `OtpErlangChar.java`
 * `OtpErlangDouble.java`
 * `OtpErlangExit.java`
 * `OtpErlangExternalFun.java`
 * `OtpErlangFloat.java`
 * `OtpErlangFun.java`
 * `OtpErlangInt.java`
 * `OtpErlangList.java`
 * `OtpErlangLong.java`
 * `OtpErlangMap.java`
 * `OtpErlangObject.java`
 * `OtpErlangPid.java`
 * `OtpErlangPort.java`
 * `OtpErlangRef.java`
 * `OtpErlangShort.java`
 * `OtpErlangString.java`
 * `OtpErlangTuple.java`
 * `OtpErlangUInt.java`
 * `OtpErlangUShort.java`

For the most part we will be ignoring those; Zhang does not discard them or
try to improve upon them. Rather, it makes use of them via the `jiface` and
`clojang` libraries.

#### Reading/Writing Encoded Streams

 * `OtpInputStream.java`
 * `OtpOutputStream.java`
 * `OtpMsg.java`

It is not a current high priority for Zhang development to convert these to
Clojure, so like with the types, Zhang makes use of them via the `jiface` and
`clojang` libraries.

#### Exception Classes

These are used by the types, stream classes, and the `OtpMsg` class; as such,
they will remain:

 * `OtpAuthException.java`
 * `OtpErlangException.java`
 * `OtpErlangRangeException.java`
 * `OtpErlangDecodeException.java`
 * `OtpException.java`

#### Constants

This will likely be used in its current form:

 * `OtpExternal.java`

#### Sockets

The following will be replaced using a networking framework from the JVM
ecosystem:

 * `OtpServerSocketTransport.java`
 * `OtpSocketTransportFactory.java`
 * `OtpSocketTransport.java`

#### Interfaces

These will go away when their implementations are replaced:

 * `OtpServerTransport.java`
 * `OtpTransport.java`
 * `OtpTransportFactory.java`

#### EPMD & Connections

 * `OtpEpmd.java`
 * `AbstractConnection.java`
 * `OtpConnection.java`
 * `OtpCookedConnection.java`
 * `GenericQueue.java`
 * `OtpMbox.java`

`OtpEpmd` will need to be replaced when the current transport/socket code goes
away. Likewise for the connection classes, which will also need to be rewritten
when the `OtpPeer`, `OtpEpmd`, and OTP stream classes are replaced. The same
goes for `OtpMbox`. When the connection classes are replaced, `GenericQueue`
will need to go too.

#### Nodes

 * `AbstractNode.java`
 * `OtpLocalNode.java`
 * `OtpNode.java`
 * `OtpPeer.java`
 * `OtpSelf.java`

`AbstractNode` is actually an implementation of the `OtpTransportFactory`
interface. When the transport code changes, this will likely have to as well.
The rest of the classes in this list either directly or indirectly extend
`AbstractNode`, so the same applies to them.

#### Logical Linking

*(between Erlang processes/JIface process objects)*

It is with these objects that one is may build up supervision trees in the JVM
(or, at the very least, react to broken connections).

 * `Link.java`
 * `Links.java`
 * `OtpNodeStatus.java`

#### Utilities

 * `OtpMD5.java`
 * `OtpSystem.java`

The first will be replaced (or augmented) by ecosystem libs and the latter
isn't used anywhere (so will go away).

#### Deprecated

This will go away:

 * `OtpServer.java`

<a name="benefits">

## The Benefits of JInterface

The primary benefit of JInterface is that it exists: an Erlang developer has
taken the time to create the Java necessary to communicate with OPT nodes
(both those written in Erlang and Java). Beyond mere existence, JInterface
provides proven Erlang types in Java as well as the ability to write these to
and read them from buffers.

JInterface also provides a bit of convenience for developers who don't live
in the JVM ecosystem and just need to create a one-off application that
communicates with Erlang: no dependencies. The library is self-contained.

<a name="downsides">

## JInterface Downsides

There are several downsides to JInterface perceived by the author of Zhang.
The simplicity of its lack of dependencies means that best-of-breed libraries
are not being used for such things as managing queues and efficient TCP/IP
communications.

<a name="jvm-pros">

## What the JVM Ecosystem Does Better

* Sockets
* Async IO
* Utility libraries

<a name="needed">

## What Zhang Needs

The ability to safely create and manage many OTP nodes with low-overhead,
utilizing the best of what Clojure's `core.async` can provide as well as
various support libraries from the JVM ecosystem.
