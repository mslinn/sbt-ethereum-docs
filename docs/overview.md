# Overview

There are three types of activities you can perform with the the family of projects powered by `sbt-ethereum`:

  1. Use `eth-command-line` to interact with the ethereum blockchain, and to create and manage ethereum wallets and keys.
     `eth-command-line` is just a basic `sbt-ethereum` project, predefined for your convenience.
  2. Define custom `sbt-ethereum` projects to develop and deploy smart contracts in solidity, using sbt as a build
     tool. Within these projects, you will continue to have access to all of the functionality of `eth-command-line`.
  3. Define custom `sbt-ethereum` projects to build and run Scala applications that interact with ethereum smart contracts, 
     which may be preexisting and already deployed on the blockchain, or which you may develop yourself in solidty within
     the same project. This is particularly useful when integrating ethereum applications into existing infrastructure.

All projects based on `sbt-ethereum`, including `eth-command-line`, share a common database on the local machine,
so they all have equal access to the Ethereum wallets you create and the contract ABIs you define or import.
When you deploy your smart contracts using `sbt-ethereum`, their ABIs and other meta-information will be added to the local machine's database, 
and a permanent local record will exist of all the contracts you work.

## Prerequisites
  1. A Java 8 runtime environment (we have not tested Java 9 yet).
    If your machine does not already have one installed, you can download a 
    [Java Runtime Environment](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
    or a full [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
  2. Optional: [git](https://git-scm.com/) client.
     This documentation assumes the standard `git` command-line client, but you can use a gui-based `git` client if you prefer.

## Quick Start
  1. You can use `git` or download a zip file to obtain `eth-command-line`.
 
      a. To use the `git` command line, type:
      
         $ git clone git@github.com:swaldman/eth-command-line.git
      
      b. If you [download](https://github.com/swaldman/eth-command-line/archive/master.zip) the zip file 
        containing the `eth-command-line` project, extract it and rename it to `eth-command-line` :
         
         $ wget -O eth-command-line.zip https://github.com/swaldman/eth-command-line/archive/master.zip
         $ unzip eth-command-line
         $ mv eth-command-line-master eth-command-line
         
  2. Move to the `eth-command-line` directory that was just created.
     ```
     $ cd eth-command-line
     ```
  3. Execute `./eth-command-line`. 
     The first time you do this, many dependencies be downloaded.
     At a minimum you will see something like the following output.
     Don't be concerned if you see lots of other warnings. `sbt-ethereum` is based on [sbt](http://www.scala-sbt.org/download.html),
     which complains a lot. Maybe it should to go to digital boot camp in order to improve its attitude.
     ```
     $ ./eth-command-line 
     [info] Loading global plugins from /home/smiley/.sbt/0.13/plugins
     [info] Loading project definition from /home/smiley/eth-command-line/project
     23:28:14.283 [MLog-Init-Reporter] INFO  com.mchange.v2.log.MLog - MLog clients using slf4j logging.
     [info] Set current project to eth-command-line (in build file:/home/smiley/eth-command-line/)
     23:28:16.775 [pool-8-thread-1] INFO  org.eclipse.jetty.util.log - Logging initialized @6904ms to org.eclipse.jetty.util.log.Slf4jLog
     [info] Updating available solidity compiler set.
     eth-command-line ~> 
     ```
     If you already have [sbt](http://www.scala-sbt.org/download.html) installed in your machine, you can run SBT. For most users, simply type `sbt`.
     from within the `eth-command-line` directory instead of `./eth-command-line`. (The `eth-command-line` script is just
     an `sbt` launcher.)
  4. When you see the `eth-command-line` prompt (`eth-command-line ~> `) you can begin typing `sbt-ethereum` commands. 
     (These are actually as sbt *tasks*.)
     To see a list of all `eth-command-line`'s tasks and settings, type `eth<tab>` and `xeth<tab>`.
  5. Before you can run tasks that require the payment of Ether, such as sending Ether 
     ([ethSendEther](https://mslinn.gitbooks.io/sbt-ethereum/content/gitbook/tasks.html#ethsendether)) or
     invoking state-changing smart-contract functions 
     ([ethInvokeTransaction](https://mslinn.gitbooks.io/sbt-ethereum/content/gitbook/tasks.html#ethinvoketransaction)), 
     you will need to first define the ethereum address from which the operation will originate. 
     You can create a new address using the
     [ethKeystoreCreateWalletV3](https://mslinn.gitbooks.io/sbt-ethereum/content/gitbook/tasks.html#ethkeystorecreatewalletv3) 
     task.
     ```
     eth on master in eth-command-line> ethKeystoreCreateWalletV3
     [info] Generated keypair for address '0xc33071ead8753b04e0ee108cc168f2b22f93525d'
     [info] Generating V3 wallet, alogorithm=scrypt, n=262144, r=8, p=1, dklen=32
     Enter passphrase for new wallet: *******************
     Please retype to confirm: *******************
     [success] Total time: 31 s, completed Dec 30, 2016 7:53:11 AM
     ```
     `ethKeystoreCreateWalletV3` is an annoyingly long command to type. Don't type it. Type `ethK<tab>`, which will
     expand to `ethKeystore` then `C<tab>`, which will expans to `ethKeystoreCreateWalletV3`.

     You can also import any existing `geth` wallets into the `sbt-ethereum` repository directory.
     Just copy the wallet files for the accounts you wish to import from the `geth` keystore into the 
     sbt-ethereum keystore directory. The `geth` keystore directory is `~/.ethereum/keystore` on Linux/UNIX,
     `~/Library/Ethereum/keystore` on Mac, `$APPDATA\ethereum` on Windows. The `sbt-ethereum` keystore directory 
     is `~/.sbt-ethereum/keystore` on Linux/UNIX, `~/Library/sbt-ethereum/keystore` on Mac, `$APPDATA\sbt-ethereum` 
     on Windows.
  
     *Be sure to back up your `sbt-ethereum` keystore directory to avoid losing your wallets
     and accounts!*
  6. Once you have a generated or imported a wallet and transferred some Ether to it,
     you can make it the default sender for your interactions with the blockchain by setting a special alias, `defaultSender`:
     ```
     eth-command-line ~> ethAliasSet defaultSender 0xe92db74ce7c392634a1d9af344aeeb4a5f1e0a78
     [info] Alias 'defaultSender' now points to address 'e92db74ce7c392634a1d9af344aeeb4a5f1e0a78' (for blockchain 'mainnet').
     [info] Refreshing alias cache.
     [success] Total time: 0 s, completed Oct 25, 2017 11:41:40 PM
     ```
     Remember to replace the hex string above with your own Ethereum address!
   
## Choosing an Ethereum Node
`sbt-ethereum` is preconfigured to check to see if two environment variables are defined.
If they have values, those values are used to specify the Ethereum node that `sbt-ethereum` connects to.
Otherwise, our public Ethereum node is used as a default.

### Using One of Infuria's Ethereum Nodes
To configure `eth-command-line` / `sbt-ethereum` to work with Infura's Ethereum nodes,
obtain a token from [infura.io](https://infura.io) and store it in an environment variable called `ETH_INFURA_TOKEN`.
You might want to set the environment variable in `~/.bashrc`, `~/.profile` or `~/.bash_profile`.
```
export ETH_INFURA_TOKEN="blahblahblah"
```
The next time you start `eth-command-line`, or any program that shares a similar SBT build configuration, 
they will notice the token and automatically use it to connect with an Infura Ethereum node.

### Using Any Arbitrary Ethereum Node
`sbt-ethereum` can work with any Ethereum node.
If no environment variable called `ETH_INFURA_TOKEN` is defined, the `eth-command-line` build configuration checks for an environment variable called `ETH_DEFAULT_NODE`.
If it is defined, its value is used verbatim to define the Ethereum node to connect to.
When you are ready to run your own node and sync it to the blockchain, 
you should store your node's URL in `ETH_DEFAULT_NODE`, like this:
```
export ETH_DEFAULT_NODE="http://mynode.domain.com:8545/"
```
If you have defined your own custom sbt-ethereum project, you can also define the setting `ethJsonRpcUrl` in your `build.sbt` file.
```
ethJsonRpcUrl := "http://mynode.domain.com:8545/"
```

### Using the Default Ethereum Node
If neither the environment variable called `ETH_INFURA_TOKEN` nor the environment variable called `ETH_DEFAULT_NODE` are defined, 
the default Ethereum node is used, `http://ethjsonrpc.mchange.com:8545/`.
    
## Custom Projects

Before you begin a custom project, you will need to define a project directory with a `build.sbt` file
and a special directory structure. If you already have `sbt` downloaded and installed, you can type
```
$ sbt new swaldman/solidity-seed.g8
```
and then follow the prompts. Just hit return to use the default value.
```
A minimal solidity project for sbt-ethereum 

name [my-solidity-project]: hyperdemocracy
version [0.0.1-SNAPSHOT]: 
sbt_ethereum_version [0.0.2-SNAPSHOT]: 
sbt_version [0.13.16]: 

Template applied in ./hyperdemocracy
```
Inside the newly created `hyperdemocracy` directory you will find a `build.sbt` file, and a directory
called `src/maim/solidity`. The smart contracts you will wish to compile and deploy should be saved in
this directory.

If you wish to integrate new or already-deployed smart contracts with Scala applications, use
```
$ sbt new swaldman/solidity-scala-seed.g8
[info] Loading global plugins from /home/smiley/.sbt/0.13/plugins
[info] Loading project definition from /home/smiley/tmp/project
[info] Set current project to tmp (in build file:/home/smiley/tmp/)

A mixed solidity / scala project for sbt-ethereum 

name [my-scala-solidity-project]: hyperdemocracy
organization [eth.anyone]: org.hyperdemocracy           
package [org.hyperdemocracy]: org.hyperdemocracy.voting
scala_stubs_package [org.hyperdemocracy.voting.contract]: 
scala_version [2.11.11]: 
version [0.0.1-SNAPSHOT]: 
sbt_ethereum_version [0.0.2-SNAPSHOT]: 
consuela_version [0.0.3-SNAPSHOT]: 
sbt_version [0.13.15]: 

Template applied in ./hyperdemocracy
```
You'll find a `src/main/scala` directory defined, containing an `org/hyperdemocracy/voting` subdirectory
for your scala application, in addition to `src/main/solidity`.

You will also find a `src/test/scala` directory defined with a parallel package directory hierarchy.

Finally, you will find a `src/ethabi` directory, where you can put files conatining Ethereum JSON ABI of
smart contracts for which you would like Scala stubs to be generated. Your Scala application can use these
stubs to interact with existing smart contracts.
  
## Introduction to Tasks and Settings
From the top-level directory of any SBT project based on `sbt-ethereum`, start SBT:
```
$ sbt
[info] Loading global plugins from /home/mslinn/.sbt/0.13/plugins
[info] Loading project definition from /mnt/_/work/eth-command-line/project
12:10:24.290 [MLog-Init-Reporter] INFO  com.mchange.v2.log.MLog - MLog clients using slf4j logging.
[info] Set current project to sbt-ethereum-template (in build file:/mnt/_/work/eth-command-line/)
2017-10-24 12:10:25.833:INFO::pool-8-thread-1: Logging initialized @5415ms to org.eclipse.jetty.util.log.StdErrLog
[info] Updating available solidity compiler set.
> 
```

All of the `sbt-ethereum` SBT tasks and settings are prefaced with `eth` or `xeth`.
Tab completion is supported.
Try typing `eth<tab>`, and you will see all the SBT tasks and settings that `sbt-ethereum` defines with that prefix:

```
> eth
ethAbiForget                   ethAbiList                     ethAbiMemorize                 ethAliasDrop                   ethAliasList                   ethAliasSet                    ethBalance                     ethBalanceInWei                
ethBlockchainId                ethCompilationsCull            ethCompilationsInspect         ethCompilationsList            ethDeployAuto                  ethDeployAutoContracts         ethDeployOnly                  ethEntropySource               
ethGasMarkup                   ethGasPriceMarkup              ethIncludeLocations            ethInvokeConstant              ethInvokeTransaction           ethJsonRpcUrl                  ethKeystoreAutoRelockSeconds   ethKeystoreCreateWalletV3      
ethKeystoreInspectWalletV3     ethKeystoreList                ethKeystoreLocationsV3         ethKeystoreMemorizeWalletV3    ethKeystoreRevealPrivateKey    ethKeystoreValidateWalletV3    ethNetcompileUrl               ethPackageScalaStubs           
ethSelfPing                    ethSendEther                   ethSender                      ethSenderOverrideDrop          ethSenderOverrideSet           ethSenderOverrideShow          ethSolidityChooseCompiler      ethSolidityCompile             
ethSolidityDestination         ethSolidityInstallCompiler     ethSolidityShowCompiler        ethSoliditySource              ethTargetDir                   ethTestrpcLocalRestart         ethTestrpcLocalStart           ethTestrpcLocalStop            
> eth
```

Similarly, typing `xeth<tab>` shows all the SBT tasks and settings that `sbt-ethereum` defines with that prefix:
```
> xeth
xethDefaultGasPrice                        xethEphemeralBlockchains                   xethFindCacheAliasesIfAvailable            xethFindCacheOmitDupsCurrentCompilations   xethFindCacheSessionSolidityCompilerKeys   
xethFindCurrentSender                      xethFindCurrentSolidityCompiler            xethGasOverrideDrop                        xethGasOverrideSet                         xethGasOverrideShow                        
xethGasPrice                               xethGasPriceOverrideDrop                   xethGasPriceOverrideSet                    xethGasPriceOverrideShow                   xethGenKeyPair                             
xethGenScalaStubsAndTestingResources       xethInvokeData                             xethKeystoreCreateWalletV3Pbkdf2           xethKeystoreCreateWalletV3Scrypt           xethLoadAbiFor                             
xethLoadCompilationsKeepDups               xethLoadCompilationsOmitDups               xethLoadWalletV3                           xethLoadWalletV3For                        xethNamedAbiSource                         
xethNamedAbis                              xethNextNonce                              xethQueryRepositoryDatabase                xethTestingResourcesObjectName             xethTriggerDirtyAliasCache                 
xethTriggerDirtySolidityCompilerList       xethUpdateContractDatabase                 xethUpdateRepositoryDatabase               xethUpdateSessionSolidityCompilers         xethWalletV3Pbkdf2C                        
xethWalletV3Pbkdf2DkLen                    xethWalletV3ScryptDkLen                    xethWalletV3ScryptN                        xethWalletV3ScryptP                        xethWalletV3ScryptR                        
> xeth
```

All of the SBT tasks are [described individually](tasks.md#sbt-ethereum-sbt-tasks-and-settings).
