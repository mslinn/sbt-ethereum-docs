# Overview

There are three types of activities you can perform with the the family of projects powered by `sbt-ethereum`:

  1. Use `eth-command-line` to interactively run ad-hoc commands.
     These commands are actually SBT tasks and settings defined by `sbt-ethereum`, which you type into the SBT REPL.
     You do not need to know SBT, or Scala, or even be a programmer, in order to use `eth-command-line` effectively.
     However, Scala programmers who understand SBT will be able to do more than those who do not.
  2. Define and run SBT tasks that wrap the `sbt-ethereum` SBT tasks into custom SBT tasks for your needs.
     The easiest way to do this is to customize the `eth-command-line` project.
  3. Compile and run Scala programs that execute Solidity programs using functionality provided by `sbt-ethereum`.
     This is particularly useful when integrating Solidity into existing infrastructure.
     Again, the easiest way to do this is to customize the `eth-command-line` project.

All projects based on `sbt-ethereum`, including `eth-command-line`, share a common database on the local machine,
so they all have equal access to Ethereum wallets and imported contract ABIs.
When you deploy your smart contracts using `sbt-ethereum`, their ABIs and other meta-information will be added to the local machine's database, 
and a permanent local record will exist of all the contracts you work.

## Prerequisites
  1. A Java 8 runtime environment (we have not tested Java 9 yet).
    If your machine does not already have one installed, you can download a 
    [Java Runtime Environment](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
    or a full [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
  2. [SBT](http://www.scala-sbt.org/download.html)
  3. Optional: [git](https://git-scm.com/) client.
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
  3. Execute `sbt`. 
     The first time you do this, many dependencies be downloaded.
     At a minimum you will see the following output.
     Don't be concerned if you see lots of warnings and errors.
     SBT complains a lot; maybe should to go to digital boot camp in order to improve its attitude.
     ```
     $ sbt
     [info] Loading global plugins from /home/mslinn/.sbt/0.13/plugins
     [info] Loading project definition from /mnt/_/work/eth-command-line/project
     13:06:15.449 [MLog-Init-Reporter] INFO  com.mchange.v2.log.MLog - MLog clients using slf4j logging.
     [info] Set current project to eth-command-line (in build file:/mnt/_/work/eth-command-line/)
     13:06:17.553 [pool-8-thread-1] INFO  org.eclipse.jetty.util.log - Logging initialized @7610ms to org.eclipse.jetty.util.log.Slf4jLog
     [info] Updating available solidity compiler set.
     eth on master in eth-command-line> 
     ```
  4. When you see the `eth-command-line` prompt (`eth on master in eth-command-line> `) you can begin typing `eth-command-line`'s Ethereum-related commands 
     (these are actually known as SBT *tasks* and *settings*).
     To see a list of all `eth-command-line`'s tasks and settings, type `eth<tab>` and `xeth<tab>`.
  5. Before you can run tasks that require the payment of Ether, such as sending Ether 
     ([ethSendEther](https://mslinn.gitbooks.io/sbt-ethereum/content/gitbook/tasks.html#ethsendether)) or
     invoking state-changing smart-contract tasks 
     ([ethInvoke](https://mslinn.gitbooks.io/sbt-ethereum/content/gitbook/tasks.html#ethinvoke)), 
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
     You can also import any existing `geth` wallets into the `sbt-ethereum` repository directory.
     (TODO HOW?)
  
     *Be sure to back up your `sbt-ethereum` repository directory to avoid losing your wallets
     and accounts!* (TODO HOW?)
  6. Once you have a generated or imported a wallet and transferred some Ether to it,
     set `ethAddress` to `eth-command-line` to use that account for fund transfers or method invocations as shown in this example:
     ```
     eth on master in eth-command-line> set ethAddress := "0xc33071ead8753b04e0ee108cc168f2b22f93525d"
  
     ```
     Remember to replace the hex string above with your own Ethereum address!
   
## Choosing an Ethereum Node
`eth-command-line` / `sbt-ethereum` is preconfigured to check to see if two environment variables are defined.
If they have values, those values are used to specify the Ethereum node that `eth-command-line` / `sbt-ethereum` connects to.
Otherwise, our public Ethereum node is used as a default.

### Using One of Infuria's Ethereum Nodes
To configure `eth-command-line` / `sbt-ethereum` to work with Infura's Ethereum nodes,
obtain a token from [infura.io](https://infura.io) and store it in an environment variable called `ETH_INFURA_TOKEN`.
This token is referenced in `build.sbt`.
You might want to set the environment variable in `~/.bashrc`, `~/.profile` or `~/.bash_profile`.
```
export ETH_INFURA_TOKEN="blahblahblah"
```
The next time you start `eth-command-line`, or any program that shares a similar SBT build configuration, 
they will notice the token and automatically use it to connect with an Infura Ethereum node.

### Using Any Arbitrary Ethereum Node
`eth-command-line` / `sbt-ethereum` can work with any Ethereum node.
If no environment variable called `ETH_INFURA_TOKEN` is defined, the `eth-command-line` build configuration checks for an environment variable called `ETH_DEFAULT_NODE`.
If it is defined, its value is used verbatim to define the Ethereum node to connect to.
When you are ready to run your own node and sync it to the blockchain, 
you should store your node's URL in `ETH_DEFAULT_NODE`, like this:

    export ETH_DEFAULT_NODE="http://mynode.domain.com:8545/"

### Using the Default Ethereum Node
If neither the environment variable called `ETH_INFURA_TOKEN` nor the environment variable called `ETH_DEFAULT_NODE` are defined, 
the default Ethereum node is used, `http://ethjsonrpc.mchange.com:8545/`.
    
## Custom Projects
The `sbt-ethereum-seed` project is a handy starting point for custom projects based on `sbt-ethereum`, 
and it also supports all of the functionality of `eth-command-line`.
To create a custom project:

  1. Clone [sbt-ethereum-seed](https://github.com/mslinn/sbt-ethereum-seed):
     ```
     git clone git@github.com:swaldman/eth-command-line.git
     ```
  2. Move to the top-level directory of your copy of `eth-command-line`:
     ```
     $ cd eth-command-line
     ```
  3. Configure the Ethereum node by editing `build.sbt` as described in the preceding two sections.
  
## Introduction to Tasks and Settings
From the top-level directory of any SBT project based on `sbt-ethereum`, start SBT:
```
$ sbt
[info] Loading global plugins from /home/mslinn/.sbt/0.13/plugins
[info] Loading project definition from /mnt/_/work/sbt-ethereum-seed/project
12:10:24.290 [MLog-Init-Reporter] INFO  com.mchange.v2.log.MLog - MLog clients using slf4j logging.
[info] Set current project to sbt-ethereum-template (in build file:/mnt/_/work/sbt-ethereum-seed/)
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
