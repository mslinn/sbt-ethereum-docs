# Tutorial

#### Overview

Learn how to interact with smart contracts deployed on the Ethereum blockchain in a few minutes.
We'll take you from no experience whatsoever to reading and updating contract state in no time at all.
The only prerequisite will be to have Java 8 VM installed. Plus, while reading contract state is free,
transactions that update the blockchain cost bank (well, a few cents usually). We'll walk you through
setting up an Ethereum account and wallet, but you'll have to get the account funded somehow.

#### Getting `eth-command-line`

`eth-command-line` is the simplest way to play with `sbt-ethereum`. It's just a sample project you
can clone, not usually for development purposes, but to interact with Ethereum's blockchain and tools.
If you have git installed, it's as simple as
```
$ git clone https://github.com/swaldman/eth-command-line.git
Cloning into 'eth-command-line'...
remote: Counting objects: 58, done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 58 (delta 0), reused 1 (delta 0), pack-reused 55
Unpacking objects: 100% (58/58), done.
Checking connectivity... done.
```
You now have a directory called `eth-command-line`, which also contains a script called `eth-command-line`.
So...
```
$ cd ./eth-command-line
$ ./eth-command-line
```
The first time you do this, you'll see a lot of crap, and it will take a while. The script will
automatically load Scala and its remarkable build tool, `sbt`. Then it will load `sbt-ethereum`
and all its dependencies. Finally, it will leave you with a prompt like this:
```
eth-command-line ~>
```
From now on, you can enter the `eth-command-line` directory and run the `eth-command-line` script
any time you'd like. Starting up `eth-command-line` may still spew some warnings, but it should all happen
much mor quickly.

#### Creating accounts and wallets

An Ethereum account can be represented as just a number made up of 40 hexadecimal characters. The account
is controlled by whomever has access to a *private key* associated with the account. In its purest form,
the private key is just a hexadecimal number made up of 64 digits, but you should rarely actually see
a private key. Storing a private key on a disk drive is dangerous. Anyone who manages to read a file with
the private key "owns" the account as surely as its creator does, and can steal any money associated with
it. Normally, we store the private key as a _wallet file_, which is nothing more than a representation of
the private key encrypted with a passphrase that you choose and memorize.

Let's create a wallet!

```
eth-command-line ~> ethKeystoreCreateWalletV3
[info] Generated keypair for address '0xd1a30c1e0cb4ccb679e3b3cb069d606c40e3fec5'
[info] Generating V3 wallet, alogorithm=scrypt, n=262144, r=8, p=1, dklen=32
Enter passphrase for new wallet: *******************
Please retype to confirm: *******************
[success] Total time: 17 s, completed Oct 27, 2017 6:53:43 AM
```
Note that we now have an Ethereum address, `0xd1a30c1e0cb4ccb679e3b3cb069d606c40e3fec5`. (The address is not
yet funded or worth anything, but if we mean to use it to manage value, it's a good idea to **back up your wallet
files**. _**TODO:** a link to a page about the sbt-ethereum repository and the location of wallet files._)

Once we have an address in `sbt-ethereum`'s keystore, we can work with it from any `sbt-ethereum` project.
`sbt-ethereum` retains a persistent repository of information about addresses and smart contracts that is always
available. Let's see our new account.
```
eth-command-line ~> ethKeystoreList
+--------------------------------------------+
| Keystore Addresses                         |
+--------------------------------------------+
| 0xd1a30c1e0cb4ccb679e3b3cb069d606c40e3fec5 |
+--------------------------------------------+
[success] Total time: 1 s, completed Oct 27, 2017 7:03:22 AM
```
##### A note about long, ugly command names

`sbt-ethereum` uses extremely verbose command names, whose meaning is hopefully reasonably clear, but that
no one should want to type. Don't type them! `sbt-ethereum` is designed to work by <tab> completetion. To
enter the command `ethKeystoreList`, type `ethK<tab>`, which will expand to `ethKeystore`. Then type `L<tab>`,
and it will expand to `ethKeystoreList`. To see a list of all keystore-related commands, type `ethKeystore<tab>`.

**In general, the <tab> key is your friend. Tabbing in commands will show you command completions, as in
the previous paragraph, but it will also suggest command-line arguments once the command is complete.
When interacting with smart contracts, tabbing will reveal the available smart-contract methods, and then
their names and types.**

#### Connecting to an Ethereum node

Suppose you wanted to check the balance of your new account. You could use the command `ethBalance`, followed by
the address whose balance you wish to check. But you may see an error, like this:
```
eth-command-line ~> ethBalance 0xd1a30c1e0cb4ccb679e3b3cb069d606c40e3fec5
[error] Failed to connect to JSON-RPC client at 'http://ethjsonrpc.mchange.com:8545': java.net.ConnectException: Connection refused
[trace] Stack trace suppressed: run last compile:ethBalance for the full output.
[error] (compile:ethBalance) java.net.ConnectException: Connection refused
[error] Total time: 1 s, completed Oct 27, 2017 7:09:53 AM
```
In order to check an account balance, `sbt-ethereum` has to leave its private space and go out into the world, onto the
network, to check the balance currently encoded in the blockchain. To do that, it needs a kind of server, called an
`Ethereum node`, to interact with. `sbt-ethereum` has a default node it tries to interact with if none has been specified,
but it is not, alas, very reliable.

A service called [Infura](https://infura.io) offers very realiable free access to an Ethereum node. To use Infura with
`sbt-ethereum`, register with that service to get an access token. Then set an environment variable called `ETH_INFURA_TOKEN`
with that value. Restart `sbt-ethereum`, and it will notice the token and be ready to communicate with the Ethereum network.
(You don't need to use Infura. You can interact with any node you like. See **TODO** for the many ways you can configure
the Ethereum node you wish to communicate with.)

If you are in `eth-command-line` now, and using a `bash` shell, you can try
```
eth-command-line ~> exit
smiley@tickle2:~/eth-command-line$ emacs ~/.bashrc
```
Now add the line
```
export ETH_INFURA_TOKEN=<your-new-Infura-token>
```
to your `.bashrc` file.

Then
```
$ ./eth-command-line 
[info] Loading project definition from /home/smiley/eth-command-line/project
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/home/smiley/.ivy2/cache/ch.qos.logback/logback-classic/jars/logback-classic-1.1.7.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/home/smiley/.ivy2/cache/org.slf4j/slf4j-nop/jars/slf4j-nop-1.7.21.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [ch.qos.logback.classic.util.ContextSelectorStaticBinder]
07:27:05.197 [MLog-Init-Reporter] INFO  com.mchange.v2.log.MLog - MLog clients using slf4j logging.
[info] Set current project to eth-command-line (in build file:/home/smiley/eth-command-line/)
07:27:08.742 [pool-6-thread-1] INFO  org.eclipse.jetty.util.log - Logging initialized @11720ms to org.eclipse.jetty.util.log.Slf4jLog
[info] Updating available solidity compiler set.
eth-command-line ~> 
```
You should now be able to check your new account's balance! Be careful to use the account number you generated in place of the one shown below.
```
eth-command-line ~> ethBalance 0xd1a30c1e0cb4ccb679e3b3cb069d606c40e3fec5
[info] 0 ether (as of the latest incorporated block, address 0xd1a30c1e0cb4ccb679e3b3cb069d606c40e3fec5)
[success] Total time: 0 s, completed Oct 27, 2017 7:42:00 AM
```

### Defining a default sender

Whenever you interact with the Ethereum blockchain, there needs to be some Ethereum address in the role of a sender. You interact
with the blockchain by sending messages to it. The blockchain expects an address from which the message comes.

`sbt_ethereum` allows you to set up a sender in three different ways, by setting up an alias called `defaultSender`, by defining an
ordinary sbt setting called `ethSender`, or by using the task `ethSenderOverrideSet` to establish a short-lived, temporary sender.
It's most convenient to define the address you use most often as `defaultSender`, and then define temporary overrides as needed.
(You'll only want to define `ethSender` when you are working on a development project with its own well-defined owner.)
Let's go ahead and define our new address as `defaultSender`.
```
eth-command-line ~> ethAliasSet defaultSender 0xd1a30c1e0cb4ccb679e3b3cb069d606c40e3fec5
[info] Alias 'defaultSender' now points to address 'd1a30c1e0cb4ccb679e3b3cb069d606c40e3fec5' (for blockchain 'mainnet').
[info] Refreshing alias cache.
[success] Total time: 0 s, completed Oct 29, 2017 4:43:29 AM
```
You are now ready to work with the Ethereum blockchain!

### Reading blockchain state via a smart contract

It's clear that we have no money. But we can still interact with smart contracts, if we content ourselves with "constant", "pure", or "view"
functions that may read data but do not alter the state of the blockchain.

We will interact with the following smart contract, called [eth-fortune](https://github.com/swaldman/eth-fortune):
```
pragma solidity ^0.4.10;

contract Fortune {
  string[] private fortunes;

  function Fortune( string initialFortune ) {
    addFortune( initialFortune );
  }

  function addFortune( string fortune ) {
    fortunes.push( fortune );
  }

  function drawFortune() constant returns ( string fortune ) {
    fortune = fortunes[ shittyRandom() % fortunes.length ];
  }

  function shittyRandom() private constant returns ( uint number ) {
    number = uint( block.blockhash( block.number - 1 ) );  	   
  }
}
```
The basic idea of this contract is very simple. Users can add "fortunes" (think of the messages found in fortune cookies) using
the `addFortune` method. Once fortunes have been added, users can then draw a random fortune by calling `drawFortune`.

Contracts have Ethereum addresses, just like humans do (and contract addresses can hold money -- "Ether" -- which the contract manages).
This contract has been deployed already at the address `0xcf547d5909b3c39e98bb54107f3320f60df01609`.

#### Memorizing a contract ABI

To interact with most Ethereum smart contracts, you need a JSON descriptor of the contract called an ABI.

When you develop and deploy a smart contract yourself, `sbt_ethereum` will automatically remember and incorporate the ABI into the
its internal database. However, when you wish to interact with a smart contract deployed by someone else, you have to get hold of
the ABI somehow.

Soon, it may be possible to look up ABIs via the standard, decentralized [swarm protocol](http://swarm-guide.readthedocs.io/en/latest/introduction.html).
But for now, things are more ad-hoc. Often, you will find ABIs in the documentation of the contracts you wish to work with. Contracts intended to be
widely used may publish their ABI on websites like [Etherscan](https://etherscan.io). Our Fortune contract has published its ABI there. Put
its address in the seach field at Etherscan. Then look under the "Contract Source" tab to find the ABI.

To tell `sbt_ethereum` about an ABI you have discovered externally, use the `ethAbiMemorize` command. The command itself takes no arguments.
It will prompt you for the contract address and the ABI, both of which you should copy and paste into your console.
```
eth-command-line ~> ethAbiMemorize
Contract address in hex: 0xcf547d5909b3c39e98bb54107f3320f60df01609
Contract ABI: [{"constant":false,"inputs":[{"name":"fortune","type":"string"}],"name":"addFortune","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"drawFortune","outputs":[{"name":"fortune","type":"string"}],"payable":false,"type":"function"},{"inputs":[{"name":"initialFortune","type":"string"}],"payable":false,"type":"constructor"}]
[info] ABI is now known for the contract at address cf547d5909b3c39e98bb54107f3320f60df01609
[success] Total time: 43 s, completed Oct 29, 2017 3:34:51 AM
```
Once an ABI has been memorized, it is available forever. `sbt_ethereum` will always know how to interact with this contract (unless you explicitly
use `ethAbiForget` to forget it).

#### Invoking a read-only method

Ethereum smart-contracts can mark methods as read-only. (Historically, that was via the keyword `constant`, but more recent
versions of the language support `view` and `pure` modifiers.) In all cases, read-only methods promise not to change the
state of the blockchain, merely to read that state (or, in the case of `pure` functions, to compute something independent
of the state).

It doesn't cost anything to access a read-only method. Let's try calling the `drawFortune` method of our Fortune contract.
As usual, be sure to substitute the address you generated for the Ethereum address below. Note that tab completion can help
you typ 'drawFortune', because sbt-ethereum already knows the ABI associated with address `0xcf547d5909b3c39e98bb54107f3320f60df01609`.
```
eth-command-line ~> ethInvokeConstant 0xcf547d5909b3c39e98bb54107f3320f60df01609 drawFortune
[info] Call data for function call: 8e3d7ae7
[info] Outputs of function are ( Parameter(fortune,string) )
[info] Raw result of call to function 'drawFortune': 0x00000000000000000000000000000000000000000000000000000000000000200000000000000000000000000000000000000000000000000000000000000027416761696e737420616c6c2065766964656e63652c20616c6c2077696c6c2062652077656c6c2e00000000000000000000000000000000000000000000000000
[info] The function 'drawFortune' yields 1 result.
[info]  + Result 1 of type 'string', named 'fortune', is "Against all evidence, all will be well."
[success] Total time: 0 s, completed Oct 29, 2017 6:04:32 AM
```

#### Setting aliases for common addresses

We've seen this before, but it's annoying to have to refer to commonly used addresses as strings like
`0xcf547d5909b3c39e98bb54107f3320f60df01609`. Let's set an alias for this, so we can simply refer to it
as 'fortune':
```
eth-command-line ~> ethAliasSet fortune 0xcf547d5909b3c39e98bb54107f3320f60df01609 
[info] Alias 'fortune' now points to address 'cf547d5909b3c39e98bb54107f3320f60df01609' (for blockchain 'mainnet').
[info] Refreshing alias cache.
[success] Total time: 1 s, completed Oct 29, 2017 8:26:10 AM
eth-command-line ~> ethInvokeConstant fortune drawFortune
[info] Call data for function call: 8e3d7ae7
[info] Outputs of function are ( Parameter(fortune,string) )
[info] Raw result of call to function 'drawFortune': 0x0000000000000000000000000000000000000000000000000000000000000020000000000000000000000000000000000000000000000000000000000000002254686174277320676f696e6720746f20687572742061206c6974746c65206269742e000000000000000000000000000000000000000000000000000000000000
[info] The function 'drawFortune' yields 1 result.
[info]  + Result 1 of type 'string', named 'fortune', is "That\'s going to hurt a little bit."
[success] Total time: 0 s, completed Oct 29, 2017 8:26:29 AM

```

