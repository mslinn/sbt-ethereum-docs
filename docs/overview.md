# sbt-ethereum Overview

There are three types of activities you can perform with `sbt-ethereum`:

  1. Running ad-hoc, interactive commands, performed in the SBT REPL.
     These commands are provided by `sbt-ethereum`.
  2. Defining and running SBT tasks that wrap the above `sbt-ethereum` SBT commands into custom commands for your needs.
  3. Running a program that executes Solidity commands.

## Getting Started
  1. Obtain a token from [infura.io](https://infura.io) and store it in an environment variable called `INFURA_TOKEN`.
     This token is referenced in `build.sbt`.
     ```
     export INFURA_TOKEN="blahblahblah"
     ```
  2. Clone [sbt-ethereum-seed](https://github.com/mslinn/sbt-ethereum-seed)
  3. Move to the top-level directory of your copy of `sbt-ethereum-seed`:
     ```
     $ cd sbt-ethereum-seed
     ```

## Running Ad-Hoc Ethereum Commands
From the `sbt-ethereum-seed` directory, start SBT:
```
$ sbt
[info] Loading global plugins from /home/mslinn/.sbt/0.13/plugins
[info] Loading project definition from /mnt/_/work/experiments/ethereum/my-scala-solidity-project/project
12:10:24.290 [MLog-Init-Reporter] INFO  com.mchange.v2.log.MLog - MLog clients using slf4j logging.
[info] Set current project to sbt-ethereum-template (in build file:/mnt/_/work/experiments/ethereum/my-scala-solidity-project/)
2017-10-24 12:10:25.833:INFO::pool-8-thread-1: Logging initialized @5415ms to org.eclipse.jetty.util.log.StdErrLog
[info] Updating available solidity compiler set.
> 
```

All of the `sbt-ethereum` commands are prefaced with `eth` or `xeth`.
Tab completion is supported.
Try typing `eth<tab>`, and you will see all the SBT commands that `sbt-ethereum` defines with that prefix:

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
