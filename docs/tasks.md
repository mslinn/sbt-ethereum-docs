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
```tut
1 + 1
```

### `ethDeployAutoContracts` 
Sample usage:
```tut
1 + 1
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
FIXME what does this do?
Sample usage:
```sbtshell
> xethGasPriceOverrideSet 5 gwei
[info] Gas price override set to 5000000000.
[success] Total time: 0 s, completed Oct 23, 2017 4:22:20 PM
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
