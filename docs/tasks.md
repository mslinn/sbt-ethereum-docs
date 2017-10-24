# `sbt-ethereum` SBT Tasks
The following SBT tasks are provided by `sbt-ethereum`.
Some require configuration, others do not.

## `eth` Tasks

### `ethAbiForget`
Sample usage:
```tut
1 + 1
```

### `ethAbiList`
Sample usage:
```tut
1 + 1
```

### `ethAbiMemorize`
Sample usage:
```tut
1 + 1
```

### `ethAliasDrop`
Sample usage:
```tut
1 + 1
```

### `ethAliasList`
Sample usage:
```tut
1 + 1
```

### `ethAliasSet`
Sample usage:
```tut
1 + 1
```

### `ethBalance`
Sample usage, showing a balance of approximately $3 at the time of writing:
```sbtshell
> ethBalance
[info] 0.009556395 ether (as of the latest incorporated block, address 0x766f158c69cdb28e2f8815e16a82ecee48865d38)
[success] Total time: 0 s, completed Oct 23, 2017 4:26:26 PM
```

### `ethBalanceInWei` 
Sample usage:
```tut
1 + 1
```

### `ethBlockchainId` 
Sample usage:
```tut
1 + 1
```

### `ethCompilationsCull` 
Sample usage:
```tut
1 + 1
```

### `ethCompilationsInspect` 
Sample usage:
```tut
1 + 1
```

### `ethCompilationsList` 
Sample usage:
```tut
1 + 1
```

### `ethDeployAuto`
Sample usage:
```tut
1 + 1
```

### `ethDeployAutoContracts` 
Sample usage:
```tut
1 + 1
```

### `ethDeployOnly`
Sample usage:
```tut
1 + 1
```

### `ethEntropySource`
Sample usage:
```tut
1 + 1
```

### `ethGasMarkup`
Sample usage:
```tut
1 + 1
```

### `ethGasPriceMarkup` 
Sample usage:
```tut
1 + 1
```

### `ethIncludeLocations` 
Sample usage:
```tut
1 + 1
```

### `ethInvokeConstant`
This SBT task Invoke a method on a local copy of the blockchain.
Sample usage:
```sbtshell
> ethInvokeConstant 0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941b asdf 1234
[info] Call data for function call: c72852a700000000000000000000000000000000000000000000000000000000000004d2
[info] Outputs of function are (  )
[info] Raw result of call to function 'asdf': 0x
[info] The function asdf yields no result.
[success] Total time: 0 s, completed Oct 23, 2017 4:29:14 PM

```

### `ethInvokeTransaction` 
Sample usage:
```tut
1 + 1
```

### `ethJsonRpcUrl`
The following sample usage assumes your [Infura](https://infura.io) token is `xxxx`:
```sbtshell
> show ethJsonRpcUrl
show ethJsonRpcUrl
[info] https://mainnet.infura.io/xxxx
```

### `ethKeystoreAutoRelockSeconds` 
Sample usage:
```tut
1 + 1
```

### `ethKeystoreCreateWalletV3` 
Sample usage:
```tut
1 + 1
```

### `ethKeystoreInspectWalletV3` 
Sample usage:
```tut
1 + 1
```

### `ethKeystoreList` 
The following sample usage shows a keystore has already been set up with the public address `0x766f158c69cdb28e2f8815e16a82ecee48865d38`:
```sbtshell
> ethKeystoreList
ethKeystoreList
+--------------------------------------------+
| Keystore Addresses                         |
+--------------------------------------------+
| 0x766f158c69cdb28e2f8815e16a82ecee48865d38 |
+--------------------------------------------+
[success] Total time: 0 s, completed Oct 23, 2017 3:55:28 PM
```

### `ethKeystoreLocationsV3` 
Sample usage:
```tut
1 + 1
```

### `ethKeystoreMemorizeWalletV3` 
Sample usage:
```tut
1 + 1
```

### `ethKeystoreRevealPrivateKey` 
Sample usage:
```tut
1 + 1
```

### `ethKeystoreValidateWalletV3` 
Sample usage:
```tut
1 + 1
```

### `ethNetcompileUrl`
Sample usage:
```tut
1 + 1
```

### `ethPackageScalaStubs`
Sample usage:
```tut
1 + 1
```

### `ethSelfPing`
Sample usage:
```tut
1 + 1
```

### `ethSendEther`
Sample usage:
```tut
1 + 1
```

### `ethSender`
Sample usage:
```tut
1 + 1
```

### `ethSenderOverrideDrop` 
Sample usage:
```tut
1 + 1
```

### `ethSenderOverrideSet`
Sample usage:
```tut
1 + 1
```

### `ethSenderOverrideShow`
Sample usage:
```tut
1 + 1
```

### `ethSolidityChooseCompiler` 
Sample usage:
```tut
1 + 1
```

### `ethSolidityCompile`
Sample usage:
```tut
1 + 1
```

### `ethSolidityDestination`
Sample usage:
```tut
1 + 1
```

### `ethSolidityInstallCompiler` 
Sample usage:
```tut
1 + 1
```

### `ethSolidityShowCompiler` 
Sample usage:
```tut
1 + 1
```

### `ethSoliditySource`
Sample usage:
```tut
1 + 1
```

### `ethTargetDir`
Sample usage:
```tut
1 + 1
```

### `ethTestrpcLocalRestart` 
Sample usage:
```tut
1 + 1
```

### `ethTestrpcLocalStart` 
Sample usage:
```tut
1 + 1
```

### `ethTestrpcLocalStop`
Sample usage:
```tut
1 + 1
```

## `xeth` SBT Tasks
There are "advanced" tasks:

### `xethDefaultGasPrice`
Sample usage:
```tut
1 + 1
```

### `xethEphemeralBlockchains`
Sample usage:
```tut
1 + 1
```

### `xethFindCacheAliasesIfAvailable`
Sample usage:
```tut
1 + 1
```

### `xethFindCacheOmitDupsCurrentCompilations`
Sample usage:
```tut
1 + 1
```

### `xethFindCacheSessionSolidityCompilerKeys`
Sample usage:
```tut
1 + 1
```

### `xethFindCurrentSender`
Sample usage:
```tut
1 + 1
```

### `xethFindCurrentSolidityCompiler`
Sample usage:
```tut
1 + 1
```

### `xethGasOverrideDrop`
Sample usage:
```tut
1 + 1
```

### `xethGasOverrideSet`
Sample usage:
```tut
1 + 1
```

### `xethGasOverrideShow`
Sample usage:
```tut
1 + 1
```

### `xethGasPrice`
Sample usage:
```tut
1 + 1
```

### `xethGasPriceOverrideDrop`
Sample usage:
```tut
1 + 1
```

### `xethGasPriceOverrideSet`
Sample usage:
```tut
1 + 1
```

### `xethGasPriceOverrideShow`
Sample usage:
```tut
1 + 1
```

### `xethGenKeyPair`
Sample usage:
```tut
1 + 1
```

### `xethGenScalaStubsAndTestingResources`
Sample usage:
```tut
1 + 1
```

### `xethInvokeData`
Sample usage:
```tut
1 + 1
```

### `xethKeystoreCreateWalletV3Pbkdf2`
Sample usage:
```tut
1 + 1
```

### `xethKeystoreCreateWalletV3Scrypt`
Sample usage:
```tut
1 + 1
```

### `xethLoadAbiFor`
Sample usage:
```tut
1 + 1
```

### `xethLoadCompilationsKeepDups`
Sample usage:
```tut
1 + 1
```

### `xethLoadCompilationsOmitDups`
Sample usage:
```tut
1 + 1
```

### `xethLoadWalletV3`
Sample usage:
```tut
1 + 1
```

### `xethLoadWalletV3For`
Sample usage:
```tut
1 + 1
```

### `xethNamedAbiSource`
Sample usage:
```tut
1 + 1
```

### `xethNamedAbis`
Sample usage:
```tut
1 + 1
```

### `xethNextNonce`
Sample usage:
```tut
1 + 1
```

### `xethQueryRepositoryDatabase`
Sample usage:
```tut
1 + 1
```

### `xethTestingResourcesObjectName`
Sample usage:
```tut
1 + 1
```

### `xethTriggerDirtyAliasCache`
Sample usage:
```tut
1 + 1
```

### `xethTriggerDirtySolidityCompilerList`
Sample usage:
```tut
1 + 1
```

### `xethUpdateContractDatabase`
Sample usage:
```tut
1 + 1
```

### `xethUpdateRepositoryDatabase`
Sample usage:
```tut
1 + 1
```

### `xethUpdateSessionSolidityCompilers`
Sample usage:
```tut
1 + 1
```

### `xethWalletV3Pbkdf2C`
Sample usage:
```tut
1 + 1
```

### `xethWalletV3Pbkdf2DkLen`
Sample usage:
```tut
1 + 1
```

### `xethWalletV3ScryptDkLen`
Sample usage:
```tut
1 + 1
```

### `xethWalletV3ScryptN`
Sample usage:
```tut
1 + 1
```

### `xethWalletV3ScryptP`
Sample usage:
```tut
1 + 1
```

### `xethWalletV3ScryptR`
Sample usage:
```tut
1 + 1
```
