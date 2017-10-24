# `sbt-ethereum` SBT Tasks
The following SBT tasks are provided by `sbt-ethereum`.
Some require configuration, others do not.

## `eth` Tasks

### `ethAbiForget`
Sample usage:
```scala
scala> 1 + 1
res0: Int = 2
```

### `ethAbiList`
Sample usage:
```scala
scala> 1 + 1
res1: Int = 2
```

### `ethAbiMemorize`
Sample usage:
```scala
scala> 1 + 1
res2: Int = 2
```

### `ethAliasDrop`
Sample usage:
```scala
scala> 1 + 1
res3: Int = 2
```

### `ethAliasList`
Sample usage:
```scala
scala> 1 + 1
res4: Int = 2
```

### `ethAliasSet`
Sample usage:
```scala
scala> 1 + 1
res5: Int = 2
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
```scala
scala> 1 + 1
res6: Int = 2
```

### `ethBlockchainId` 
Sample usage:
```scala
scala> 1 + 1
res7: Int = 2
```

### `ethCompilationsCull` 
Sample usage:
```scala
scala> 1 + 1
res8: Int = 2
```

### `ethCompilationsInspect`
Dump out everything known about a contract at a specific address.
This query costs a tiny bit of gas.

[etherscan.io](https://etherscan.io) can show the same information; the information provided in the following 
code example for the contract at address `0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941` is also available at
[https://etherscan.io/address/0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941b](https://etherscan.io/address/0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941b).

![](../images/etherScan.png)

```sbtshell
> ethCompilationsInspect 0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941b

-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                       CONTRACT INFO DUMP
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
------------------------------------------------------------------------
Contract Address (on blockchain 'mainnet'):

0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941b
------------------------------------------------------------------------
Deployer Address:

0x766f158c69cdb28e2f8815e16a82ecee48865d38
------------------------------------------------------------------------
Transaction Hash:

0x9b0e7303bcc17d567ab74abc6c187625bc8fbafd31eb05a7d54ab2e17e50f12b
------------------------------------------------------------------------
Deployment Timestamp:

Mon Oct 23 16:24:13 PDT 2017
------------------------------------------------------------------------
Code Hash:

0xebd2941e2f46d0daf2dc625e6eef82a9354ef42bab83170088582010c571215c
------------------------------------------------------------------------
Code:

0x60606040523415600b57fe5b5b60878061001a6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063c72852a714603a575bfe5b3415604157fe5b605560048080359060200190919050506057565b005b5b505600a165627a7a72305820eb4a6f473ca4af6929fcccdeb92a35bf08b24e9c204ee231ca94f5d2ae5cbf380029
------------------------------------------------------------------------
Contract Name:

SampleContract
------------------------------------------------------------------------
Contract Source:

/*
 * DO NOT EDIT! DO NOT EDIT! DO NOT EDIT!
 *
 * This is an automatically generated file. It will be overwritten.
 *
 * For the original source see
 *    '/mnt/_/work/experiments/ethereum/my-scala-solidity-project/src/main/solidity/SampleContract.sol'
 */

pragma solidity ^0.4.10;





contract SampleContract {
  function asdf (uint param) constant {}
}

------------------------------------------------------------------------
Contract Language:

Solidity
------------------------------------------------------------------------
Language Version:

0.4.10
------------------------------------------------------------------------
Compiler Version:

0.4.10+commit.f0d539ae
------------------------------------------------------------------------
Compiler Options:

{"compilationTarget":{"<stdin>":"SampleContract"},"libraries":{},"optimizer":{"enabled":false,"runs":200},"remappings":[]}
------------------------------------------------------------------------
ABI Definition:

[{"name":"asdf","inputs":[{"name":"param","type":"uint256"}],"outputs":[],"constant":true,"payable":false,"type":"function"}]
------------------------------------------------------------------------
Metadata:

{"compiler":{"version":"0.4.10+commit.f0d539ae"},"language":"Solidity","output":{"abi":[{"constant":true,"inputs":[{"name":"param","type":"uint256"}],"name":"asdf","outputs":[],"payable":false,"type":"function"}],"devdoc":{"methods":{}},"userdoc":{"methods":{}}},"settings":{"compilationTarget":{"<stdin>":"SampleContract"},"libraries":{},"optimizer":{"enabled":false,"runs":200},"remappings":[]},"sources":{"<stdin>":{"keccak256":"0x7c7952bfe078283b67b234e85015526fa747199a8f0f62d2de054040a7c22b1b","urls":["bzzr://41c7b78ea23f8ceb0193f5ae719719139e2b22c6dad0e7e0cdd7f61148e21566"]}},"version":1}
-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

[success] Total time: 0 s, completed Oct 23, 2017 4:25:21 PM
```

### `ethCompilationsList` 
Sample usage:
```sbtshell
> ethCompilationsList
+------------+--------------------------------------------+----------------------+--------------------------------------------------------------------+------------------------------+
| Blockchain | Contract Address                           | Name                 | Code Hash                                                          | Deployment Timestamp         |
+------------+--------------------------------------------+----------------------+--------------------------------------------------------------------+------------------------------+
| mainnet    | 0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941b | SampleContract       | 0xebd2941e2f46d0daf2dc625e6eef82a9354ef42bab83170088582010c571215c | 2017-10-23T16:24:13.017-0700 |
+------------+--------------------------------------------+----------------------+--------------------------------------------------------------------+------------------------------+
[success] Total time: 0 s, completed Oct 23, 2017 4:24:39 PM
```

### `ethDeployAuto`
Sample usage:
```scala
scala> 1 + 1
res9: Int = 2
```

### `ethDeployAutoContracts` 
Sample usage:
```scala
scala> 1 + 1
res10: Int = 2
```

### `ethDeployOnly`
FIXME What does this do?
Sample usage:
```sbtshell
> ethDeployOnly SampleContract
[info] Unlocking address '0x766f158c69cdb28e2f8815e16a82ecee48865d38' (on blockchain 'mainnet', aliases 'defaultSender')
Enter passphrase or hex private key for address '0x766f158c69cdb28e2f8815e16a82ecee48865d38':
[info] V3 wallet found for '0x766f158c69cdb28e2f8815e16a82ecee48865d38' (aliases 'defaultSender')
[info] Contract 'SampleContract' deployed in transaction '0x9b0e7303bcc17d567ab74abc6c187625bc8fbafd31eb05a7d54ab2e17e50f12b'.
[info] Receipt for transaction '0x9b0e7303bcc17d567ab74abc6c187625bc8fbafd31eb05a7d54ab2e17e50f12b' not yet available, will try again in 15 seconds. Attempt 1/9.
[info] Receipt for transaction '0x9b0e7303bcc17d567ab74abc6c187625bc8fbafd31eb05a7d54ab2e17e50f12b' not yet available, will try again in 15 seconds. Attempt 2/9.
[info] Receipt for transaction '0x9b0e7303bcc17d567ab74abc6c187625bc8fbafd31eb05a7d54ab2e17e50f12b' not yet available, will try again in 15 seconds. Attempt 3/9.
[info] Receipt for transaction '0x9b0e7303bcc17d567ab74abc6c187625bc8fbafd31eb05a7d54ab2e17e50f12b' not yet available, will try again in 15 seconds. Attempt 4/9.
[info] Receipt for transaction '0x9b0e7303bcc17d567ab74abc6c187625bc8fbafd31eb05a7d54ab2e17e50f12b' not yet available, will try again in 15 seconds. Attempt 5/9.
[info] Receipt received for transaction '0x9b0e7303bcc17d567ab74abc6c187625bc8fbafd31eb05a7d54ab2e17e50f12b':
[info] Transaction Receipt:
[info]        Transaction Hash:    0x9b0e7303bcc17d567ab74abc6c187625bc8fbafd31eb05a7d54ab2e17e50f12b
[info]        Transaction Index:   23
[info]        Transaction Status:  SUCCEEDED
[info]        Block Hash:          0x05bab951924a1a7fadfd462da06bf2398c951e846a26fe228e6532b5b7857885
[info]        Block Number:        4417219
[info]        Cumulative Gas Used: 899747
[info]        Contract Address:    0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941b
[info]        Logs:                None
[info] Contract 'SampleContract' has been assigned address '0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941b'.
```

### `ethEntropySource`
Sample usage:
```scala
scala> 1 + 1
res11: Int = 2
```

### `ethGasMarkup`
Sample usage:
```scala
scala> 1 + 1
res12: Int = 2
```

### `ethGasPriceMarkup` 
Sample usage:
```scala
scala> 1 + 1
res13: Int = 2
```

### `ethIncludeLocations` 
Sample usage:
```scala
scala> 1 + 1
res14: Int = 2
```

### `ethInvokeConstant`
This SBT task invokes a method on a local copy of the blockchain.
It does not cost gas and runs more quikcly than running it via `ethInvokeTransaction`.
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
This SBT task invokes a method on the master (non-local) copy of the blockchain.
It costs gas and runs more slowly than running it via `ethInvokeConstant`.
Sample usage:
```sbtshell
> ethInvokeTransaction 0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941b asdf 1234
[info] Unlocking address '0x766f158c69cdb28e2f8815e16a82ecee48865d38' (on blockchain 'mainnet', aliases 'defaultSender')
Enter passphrase or hex private key for address '0x766f158c69cdb28e2f8815e16a82ecee48865d38':
[info] V3 wallet found for '0x766f158c69cdb28e2f8815e16a82ecee48865d38' (aliases 'defaultSender')
[info] Outputs of function are (  )
[info] Call data for function call: c72852a700000000000000000000000000000000000000000000000000000000000004d2
[info] Gas estimated for function call: 26006
[info] Gas price set to 5000000000 wei
[info] Estimated transaction cost 130030000000000 wei (0.00013003 ether).
[info] Called function 'asdf', with args '1234', sending 0 wei to address '0x019e39e4c8c46034b1c0da2d26f99cc6a1ae941b' in transaction '0x142b432babfd7d00dd97877e4f38e5743b849d71432d59abe658f88322979c5a'.
[info] Receipt for transaction '0x142b432babfd7d00dd97877e4f38e5743b849d71432d59abe658f88322979c5a' not yet available, will try again in 15 seconds. Attempt 1/9.
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
```scala
scala> 1 + 1
res15: Int = 2
```

### `ethKeystoreCreateWalletV3` 
Sample usage:
```scala
scala> 1 + 1
res16: Int = 2
```

### `ethKeystoreInspectWalletV3` 
Sample usage:
```scala
scala> 1 + 1
res17: Int = 2
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
```scala
scala> 1 + 1
res18: Int = 2
```

### `ethKeystoreMemorizeWalletV3` 
Sample usage:
```scala
scala> 1 + 1
res19: Int = 2
```

### `ethKeystoreRevealPrivateKey` 
Sample usage:
```scala
scala> 1 + 1
res20: Int = 2
```

### `ethKeystoreValidateWalletV3` 
Sample usage:
```scala
scala> 1 + 1
res21: Int = 2
```

### `ethNetcompileUrl`
Sample usage:
```scala
scala> 1 + 1
res22: Int = 2
```

### `ethPackageScalaStubs`
Sample usage:
```scala
scala> 1 + 1
res23: Int = 2
```

### `ethSelfPing`
Sample usage:
```scala
scala> 1 + 1
res24: Int = 2
```

### `ethSendEther`
Sample usage:
```scala
scala> 1 + 1
res25: Int = 2
```

### `ethSender`
Sample usage:
```scala
scala> 1 + 1
res26: Int = 2
```

### `ethSenderOverrideDrop` 
Sample usage:
```scala
scala> 1 + 1
res27: Int = 2
```

### `ethSenderOverrideSet`
Sample usage:
```scala
scala> 1 + 1
res28: Int = 2
```

### `ethSenderOverrideShow`
Sample usage:
```scala
scala> 1 + 1
res29: Int = 2
```

### `ethSolidityChooseCompiler` 
Sample usage:
```scala
scala> 1 + 1
res30: Int = 2
```

### `ethSolidityCompile`
Sample usage:
```scala
scala> 1 + 1
res31: Int = 2
```

### `ethSolidityDestination`
Sample usage:
```scala
scala> 1 + 1
res32: Int = 2
```

### `ethSolidityInstallCompiler` 
Sample usage:
```scala
scala> 1 + 1
res33: Int = 2
```

### `ethSolidityShowCompiler` 
Sample usage:
```scala
scala> 1 + 1
res34: Int = 2
```

### `ethSoliditySource`
Sample usage:
```scala
scala> 1 + 1
res35: Int = 2
```

### `ethTargetDir`
Sample usage:
```scala
scala> 1 + 1
res36: Int = 2
```

### `ethTestrpcLocalRestart` 
Sample usage:
```scala
scala> 1 + 1
res37: Int = 2
```

### `ethTestrpcLocalStart` 
Sample usage:
```scala
scala> 1 + 1
res38: Int = 2
```

### `ethTestrpcLocalStop`
Sample usage:
```scala
scala> 1 + 1
res39: Int = 2
```

## `xeth` SBT Tasks
There are "advanced" tasks:

### `xethDefaultGasPrice`
Sample usage:
```scala
scala> 1 + 1
res40: Int = 2
```

### `xethEphemeralBlockchains`
Sample usage:
```scala
scala> 1 + 1
res41: Int = 2
```

### `xethFindCacheAliasesIfAvailable`
Sample usage:
```scala
scala> 1 + 1
res42: Int = 2
```

### `xethFindCacheOmitDupsCurrentCompilations`
Sample usage:
```scala
scala> 1 + 1
res43: Int = 2
```

### `xethFindCacheSessionSolidityCompilerKeys`
Sample usage:
```scala
scala> 1 + 1
res44: Int = 2
```

### `xethFindCurrentSender`
Sample usage:
```scala
scala> 1 + 1
res45: Int = 2
```

### `xethFindCurrentSolidityCompiler`
Sample usage:
```scala
scala> 1 + 1
res46: Int = 2
```

### `xethGasOverrideDrop`
Sample usage:
```scala
scala> 1 + 1
res47: Int = 2
```

### `xethGasOverrideSet`
Sample usage:
```scala
scala> 1 + 1
res48: Int = 2
```

### `xethGasOverrideShow`
Sample usage:
```scala
scala> 1 + 1
res49: Int = 2
```

### `xethGasPrice`
Sample usage:
```scala
scala> 1 + 1
res50: Int = 2
```

### `xethGasPriceOverrideDrop`
Sample usage:
```scala
scala> 1 + 1
res51: Int = 2
```

### `xethGasPriceOverrideSet`
FIXME what does this do?
Sample usage:
```sbtshell
> xethGasPriceOverrideSet 5 gwei
[info] Gas price override set to 5000000000.
[success] Total time: 0 s, completed Oct 23, 2017 4:22:20 PM
```

### `xethGasPriceOverrideShow`
Sample usage:
```scala
scala> 1 + 1
res52: Int = 2
```

### `xethGenKeyPair`
Sample usage:
```scala
scala> 1 + 1
res53: Int = 2
```

### `xethGenScalaStubsAndTestingResources`
Sample usage:
```scala
scala> 1 + 1
res54: Int = 2
```

### `xethInvokeData`
Sample usage:
```scala
scala> 1 + 1
res55: Int = 2
```

### `xethKeystoreCreateWalletV3Pbkdf2`
Sample usage:
```scala
scala> 1 + 1
res56: Int = 2
```

### `xethKeystoreCreateWalletV3Scrypt`
Sample usage:
```scala
scala> 1 + 1
res57: Int = 2
```

### `xethLoadAbiFor`
Sample usage:
```scala
scala> 1 + 1
res58: Int = 2
```

### `xethLoadCompilationsKeepDups`
Sample usage:
```scala
scala> 1 + 1
res59: Int = 2
```

### `xethLoadCompilationsOmitDups`
Sample usage:
```scala
scala> 1 + 1
res60: Int = 2
```

### `xethLoadWalletV3`
Sample usage:
```scala
scala> 1 + 1
res61: Int = 2
```

### `xethLoadWalletV3For`
Sample usage:
```scala
scala> 1 + 1
res62: Int = 2
```

### `xethNamedAbiSource`
Sample usage:
```scala
scala> 1 + 1
res63: Int = 2
```

### `xethNamedAbis`
Sample usage:
```scala
scala> 1 + 1
res64: Int = 2
```

### `xethNextNonce`
Sample usage:
```scala
scala> 1 + 1
res65: Int = 2
```

### `xethQueryRepositoryDatabase`
Sample usage:
```scala
scala> 1 + 1
res66: Int = 2
```

### `xethTestingResourcesObjectName`
Sample usage:
```scala
scala> 1 + 1
res67: Int = 2
```

### `xethTriggerDirtyAliasCache`
Sample usage:
```scala
scala> 1 + 1
res68: Int = 2
```

### `xethTriggerDirtySolidityCompilerList`
Sample usage:
```scala
scala> 1 + 1
res69: Int = 2
```

### `xethUpdateContractDatabase`
Sample usage:
```scala
scala> 1 + 1
res70: Int = 2
```

### `xethUpdateRepositoryDatabase`
Sample usage:
```scala
scala> 1 + 1
res71: Int = 2
```

### `xethUpdateSessionSolidityCompilers`
Sample usage:
```scala
scala> 1 + 1
res72: Int = 2
```

### `xethWalletV3Pbkdf2C`
Sample usage:
```scala
scala> 1 + 1
res73: Int = 2
```

### `xethWalletV3Pbkdf2DkLen`
Sample usage:
```scala
scala> 1 + 1
res74: Int = 2
```

### `xethWalletV3ScryptDkLen`
Sample usage:
```scala
scala> 1 + 1
res75: Int = 2
```

### `xethWalletV3ScryptN`
Sample usage:
```scala
scala> 1 + 1
res76: Int = 2
```

### `xethWalletV3ScryptP`
Sample usage:
```scala
scala> 1 + 1
res77: Int = 2
```

### `xethWalletV3ScryptR`
Sample usage:
```scala
scala> 1 + 1
res78: Int = 2
```
