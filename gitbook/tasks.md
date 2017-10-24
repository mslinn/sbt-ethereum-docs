# `sbt-ethereum` SBT Tasks and Settings
The following SBT tasks and settings are provided by `sbt-ethereum`.
Some require configuration, others do not.

## `eth` Tasks and Settings

### `ethAbiForget`
This task removes an ABI definition that was added to the sbt-ethereum database via ethAbiMemorize.
Sample usage:
```scala
scala> 1 + 1
res0: Int = 2
```

### `ethAbiList`
This task lists the addresses for which ABI definitions have been memorized. (Does not include our own deployed compilations, see 'ethCompilationsList').
Sample usage:
```scala
scala> 1 + 1
res1: Int = 2
```

### `ethAbiMemorize`
This task prompts for an ABI definition for a contract and inserts it into the sbt-ethereum database.
Sample usage:
```scala
scala> 1 + 1
res2: Int = 2
```

### `ethAliasDrop`
This task drops an alias for an ethereum address from the sbt-ethereum repository database.
Sample usage:
```scala
scala> 1 + 1
res3: Int = 2
```

### `ethAliasList`
This task lists aliases for ethereum addresses that can be used in place of the hex address in many tasks.
Sample usage:
```scala
scala> 1 + 1
res4: Int = 2
```

### `ethAliasSet`
This task defines or redefines an alias for an ethereum address that can be used in place of the hex address in many tasks.
Sample usage:
```scala
scala> 1 + 1
res5: Int = 2
```

### `ethBalance`
This task computes the balance in ether of a given address, or of current sender if no address is supplied.
Sample usage, showing a balance of approximately $3 at the time of writing:
```sbtshell
> ethBalance
[info] 0.009556395 ether (as of the latest incorporated block, address 0x766f158c69cdb28e2f8815e16a82ecee48865d38)
[success] Total time: 0 s, completed Oct 23, 2017 4:26:26 PM
```

### `ethBalanceInWei`
This task computes the balance in wei of a given address, or of current sender if no address is supplied.
Sample usage:
```scala
scala> 1 + 1
res6: Int = 2
```

### `ethBlockchainId`
This setting defines the name for the network represented by `ethJsonRpcUrl` (e.g. `mainnet`, `morden`, `ropsten`).
Sample usage:
```scala
scala> 1 + 1
res7: Int = 2
```

### `ethCompilationsCull`
This task removes never-deployed compilations from the repository database.
Sample usage:
```scala
scala> 1 + 1
res8: Int = 2
```

### `ethCompilationsInspect`
This task dumps to the console full information about a compilation, based on either a code hash or contract address.
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
This task lists summary information about compilations known in the repository.
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
This task deploys contracts named in `ethDeployAutoContracts`.
Sample usage:
```scala
scala> 1 + 1
res9: Int = 2
```

### `ethDeployAutoContracts`
This setting defines names (and optional space-separated constructor args) of contracts compiled within this project that should be deployed automatically.
Sample usage:
```scala
scala> 1 + 1
res10: Int = 2
```

### `ethDeployOnly`
This task deploys the specified named contract.
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
This setting defines the source of randomness that will be used for key generation.
Sample usage:
```scala
scala> 1 + 1
res11: Int = 2
```

### `ethGasMarkup`
This setting defines the fraction by which automatically estimated gas limits will be marked up (if not overridden) in setting contract creation transaction gas limits.
Sample usage:
```scala
scala> 1 + 1
res12: Int = 2
```

### `ethGasPriceMarkup` 
This setting defines the fraction by which automatically estimated gas price will be marked up (if not overridden) in executing transactions.
Sample usage:
```scala
scala> 1 + 1
res13: Int = 2
```

### `ethIncludeLocations`
This setting defines the directories or URLs that should be searched to resolve import directives, besides the source directory itself.
Sample usage:
```scala
scala> 1 + 1
res14: Int = 2
```

### `ethInvokeConstant`
This task makes a call to a constant function, consulting only the local copy of the blockchain. 
It burns no Ether and returns the latest available result.
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
This SBT task calls a function on a deployed smart contract.
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
This setting defines the URL that the Ethereum JSON-RPC service build should work with.
The following sample usage assumes your [Infura](https://infura.io) token is `xxxx`:
```sbtshell
> show ethJsonRpcUrl
show ethJsonRpcUrl
[info] https://mainnet.infura.io/xxxx
```

### `ethKeystoreAutoRelockSeconds` 
This setting defines the number of seconds after which an unlocked private key should automatically relock.
Sample usage:
```scala
scala> 1 + 1
res15: Int = 2
```

### `ethKeystoreCreateWalletV3`
This task generates a new V3 wallet, using `ethEntropySource` as a source of randomness.
Sample usage:
```scala
scala> 1 + 1
res16: Int = 2
```

### `ethKeystoreInspectWalletV3`
This task prints V3 wallet as JSON to the console.
Sample usage:
```scala
scala> 1 + 1
res17: Int = 2
```

### `ethKeystoreList`
This task lists all addresses in known and available keystores, with any aliases that may have been defined.
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
This setting defines the directories from which V3 wallets can be loaded.
Sample usage:
```scala
scala> 1 + 1
res18: Int = 2
```

### `ethKeystoreMemorizeWalletV3`
This task prompts for the JSON of a V3 wallet and inserts it into the sbt-ethereum keystore.
Sample usage:
```scala
scala> 1 + 1
res19: Int = 2
```

### `ethKeystoreRevealPrivateKey`
Danger! Warning! This task unlocks a wallet with a passphrase and prints the plaintext private key directly to the console (standard out).
Sample usage:
```scala
scala> 1 + 1
res20: Int = 2
```

### `ethKeystoreValidateWalletV3`
This task verifies that a V3 wallet can be decoded for an address, and decodes to the expected address.
Sample usage:
```scala
scala> 1 + 1
res21: Int = 2
```

### `ethNetcompileUrl`
This optional setting defines the URL of an eth-netcompile service, for more reliable network-based compilation than that available over json-rpc.
Sample usage:
```scala
scala> 1 + 1
res22: Int = 2
```

### `ethPackageScalaStubs`
This setting defines the package into which Scala stubs of Solidity compilations should be generated.
Sample usage:
```scala
scala> 1 + 1
res23: Int = 2
```

### `ethSelfPing`
This task sends 0 ether from current sender to itself.
Sample usage:
```scala
scala> 1 + 1
res24: Int = 2
```

### `ethSendEther`
This task sends ether from the current sender to a specified account in the format `ethSendEther <to-address-as-hex> <amount> <wei|szabo|finney|ether>`.
Sample usage:
```scala
scala> 1 + 1
res25: Int = 2
```

### `ethSender`
This setting defines the address from which transactions will be sent.
Sample usage:
```scala
scala> 1 + 1
res26: Int = 2
```

### `ethSenderOverrideDrop`
This task removes any sender override, reverting to any `ethSender` or `defaultSender` that may be set.
Sample usage:
```scala
scala> 1 + 1
res27: Int = 2
```

### `ethSenderOverrideSet`
This task sets an ethereum address to be used as sender in prefernce to any 'ethSender' or defaultSender that may be set.
Sample usage:
```scala
scala> 1 + 1
res28: Int = 2
```

### `ethSenderOverrideShow`
This task displays any sender override, if set.
Sample usage:
```scala
scala> 1 + 1
res29: Int = 2
```

### `ethSolidityChooseCompiler`
This task manually selects among solidity compilers available to this project.
Sample usage:
```scala
scala> 1 + 1
res30: Int = 2
```

### `ethSolidityCompile`
This task compiles solidity files.
Sample usage:
```scala
scala> 1 + 1
res31: Int = 2
```

### `ethSolidityDestination`
This setting defines the location for compiled solidity code and metadata.
Sample usage:
```scala
scala> 1 + 1
res32: Int = 2
```

### `ethSolidityInstallCompiler`
This task installs a best-attempt platform-specific solidity compiler into the `sbt-ethereum` repository (or choose a supported version).
Sample usage:
```scala
scala> 1 + 1
res33: Int = 2
```

### `ethSolidityShowCompiler`
This task displays the currently active Solidity compiler.
Sample usage:
```scala
scala> 1 + 1
res34: Int = 2
```

### `ethSoliditySource`
This setting defines the solidity source code directory.
Sample usage:
```scala
scala> 1 + 1
res35: Int = 2
```

### `ethTargetDir`
This setting defines the location in the target directory where ethereum artifacts will be placed.
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
This task starts a local `testrpc` environment (if the command `testrpc` is in your `PATH`).
Sample usage:
```scala
scala> 1 + 1
res38: Int = 2
```

### `ethTestrpcLocalStop`
This task stops any local `testrpc` environment that may have been started previously.
Sample usage:
```scala
scala> 1 + 1
res39: Int = 2
```

## `xeth` SBT Tasks
There are "advanced" tasks:

### `xethDefaultGasPrice`
This task finds the current default gas price.
Sample usage:
```scala
scala> 1 + 1
res40: Int = 2
```

### `xethEphemeralBlockchains`
This setting defines the IDs of blockchains that should be considered ephemeral (so their deployments should not be retained).
Sample usage:
```scala
scala> 1 + 1
res41: Int = 2
```

### `xethFindCacheAliasesIfAvailable`
This task finds and caches aliases for use by address parsers.
Sample usage:
```scala
scala> 1 + 1
res42: Int = 2
```

### `xethFindCacheOmitDupsCurrentCompilations`
This task finds and caches compiled, deployable contract names, omitting ambiguous duplicates. Triggered by `ethSolidityCompile`.
Sample usage:
```scala
scala> 1 + 1
res43: Int = 2
```

### `xethFindCacheSessionSolidityCompilerKeys`
This task finds and caches keys for available compilers for use parser for `ethSolidityCompilerSet`.
Sample usage:
```scala
scala> 1 + 1
res44: Int = 2
```

### `xethFindCurrentSender`
This task finds the address that should be used to send ether or messages.
Sample usage:
```scala
scala> 1 + 1
res45: Int = 2
```

### `xethFindCurrentSolidityCompiler`
This task finds and caches keys for the available compilers for use parser for `ethSolidityCompilerSet`.
Sample usage:
```scala
scala> 1 + 1
res46: Int = 2
```

### `xethGasOverrideDrop`
This task removes any previously set gas override, reverting to the usual automatic marked-up estimation of gas required for a transaction.
Sample usage:
```scala
scala> 1 + 1
res47: Int = 2
```

### `xethGasOverrideSet`
This task defines a value which overrides the usual automatic marked-up estimation of gas required for a transaction.
Sample usage:
```scala
scala> 1 + 1
res48: Int = 2
```

### `xethGasOverrideShow`
This task displays the current gas override, if set.
Sample usage:
```scala
scala> 1 + 1
res49: Int = 2
```

### `xethGasPrice`
This task finds the current gas price, including any overrides or gas price markups.
Sample usage:
```scala
scala> 1 + 1
res50: Int = 2
```

### `xethGasPriceOverrideDrop`
This task removes any previously set gas price override, reverting to the usual automatic marked-up default.
Sample usage:
```scala
scala> 1 + 1
res51: Int = 2
```

### `xethGasPriceOverrideSet`
This task defines a value which overrides the usual automatic marked-up default gas price that will be paid for a transaction.
Sample usage:
```sbtshell
> xethGasPriceOverrideSet 5 gwei
[info] Gas price override set to 5000000000.
[success] Total time: 0 s, completed Oct 23, 2017 4:22:20 PM
```

### `xethGasPriceOverrideShow`
This task displays the current gas price override, if set.
Sample usage:
```scala
scala> 1 + 1
res52: Int = 2
```

### `xethGenKeyPair`
This task generates a new key pair, using ethEntropySource as a source of randomness.
Sample usage:
```scala
scala> 1 + 1
res53: Int = 2
```

### `xethGenScalaStubsAndTestingResources`
This task generates stubs for compiled Solidity contracts, and resources helpful in testing them.
Sample usage:
```scala
scala> 1 + 1
res54: Int = 2
```

### `xethInvokeData`
This task reveals the data portion that would be sent in a message invoking a function and its arguments on a deployed smart contract.
Sample usage:
```scala
scala> 1 + 1
res55: Int = 2
```

### `xethKeystoreCreateWalletV3Pbkdf2`
This task generates a new `pbkdf2` V3 wallet, using `ethEntropySource` as a source of randomness.
Sample usage:
```scala
scala> 1 + 1
res56: Int = 2
```

### `xethKeystoreCreateWalletV3Scrypt`
This task generates a new `scrypt` V3 wallet, using `ethEntropySource` as a source of randomness.
Sample usage:
```scala
scala> 1 + 1
res57: Int = 2
```

### `xethLoadAbiFor`
This task finds the ABI for a contract address, if known.
Sample usage:
```scala
scala> 1 + 1
res58: Int = 2
```

### `xethLoadCompilationsKeepDups`
This task loads compiled solidity contracts, permitting multiple nonidentical contracts of the same name.
Sample usage:
```scala
scala> 1 + 1
res59: Int = 2
```

### `xethLoadCompilationsOmitDups`
This task loads compiled solidity contracts, omitting contracts with multiple nonidentical contracts of the same name.
Sample usage:
```scala
scala> 1 + 1
res60: Int = 2
```

### `xethLoadWalletV3`
This task loads a V3 wallet from ethWalletsV3 for current sender.
Sample usage:
```scala
scala> 1 + 1
res61: Int = 2
```

### `xethLoadWalletV3For`
This task loads a V3 wallet from ethWalletsV3.
Sample usage:
```scala
scala> 1 + 1
res62: Int = 2
```

### `xethNamedAbiSource`
This setting defines the location where files containing json files containing ABIs for which stubs should be generated. Each as '<stubname>.json'.
Sample usage:
```scala
scala> 1 + 1
res63: Int = 2
```

### `xethNamedAbis`
This task loads any named ABIs from the `xethNamedAbiSource` directory.
Sample usage:
```scala
scala> 1 + 1
res64: Int = 2
```

### `xethNextNonce`
This task finds the next nonce for the current sender.
Sample usage:
```scala
scala> 1 + 1
res65: Int = 2
```

### `xethQueryRepositoryDatabase`
This task is primarily for debugging. It queries the internal repository database.
Sample usage:
```scala
scala> 1 + 1
res66: Int = 2
```

### `xethTestingResourcesObjectName`
This setting defines the name of the Scala object that will be automatically generated with resources for tests.
Sample usage:
```scala
scala> 1 + 1
res67: Int = 2
```

### `xethTriggerDirtyAliasCache`
This task updates of the cache of aliases used for tab completions.
Sample usage:
```scala
scala> 1 + 1
res68: Int = 2
```

### `xethTriggerDirtySolidityCompilerList`
This task updates the cache of available solidity compilers used for tab completions.
Sample usage:
```scala
scala> 1 + 1
res69: Int = 2
```

### `xethUpdateContractDatabase`
This task integrates newly compiled contracts into the contract database. Returns true if changes were made.
Sample usage:
```scala
scala> 1 + 1
res70: Int = 2
```

### `xethUpdateRepositoryDatabase`
This task is primarily for development and debugging. It updates the internal repository database with arbitrary SQL.
Sample usage:
```scala
scala> 1 + 1
res71: Int = 2
```

### `xethUpdateSessionSolidityCompilers`
This task finds and tests potential Solidity compilers to see which is available.
Sample usage:
```scala
scala> 1 + 1
res72: Int = 2
```

### `xethWalletV3Pbkdf2C`
This setting defines the value to use for parameter C when generating pbkdf2 V3 wallets.
Sample usage:
```scala
scala> 1 + 1
res73: Int = 2
```

### `xethWalletV3Pbkdf2DkLen`
This setting defines the derived key length parameter used when generating pbkdf2 V3 wallets.
Sample usage:
```scala
scala> 1 + 1
res74: Int = 2
```

### `xethWalletV3ScryptDkLen`
This setting defines the derived key length parameter used when generating Scrypt V3 wallets.
Sample usage:
```scala
scala> 1 + 1
res75: Int = 2
```

### `xethWalletV3ScryptN`
This setting defines the value to use for parameter `N` when generating Scrypt V3 wallets.
Sample usage:
```scala
scala> 1 + 1
res76: Int = 2
```

### `xethWalletV3ScryptP`
This setting defines the value to use for parameter `P` when generating Scrypt V3 wallets.
Sample usage:
```scala
scala> 1 + 1
res77: Int = 2
```

### `xethWalletV3ScryptR`
This setting defines the value to use for parameter `R` when generating Scrypt V3 wallets.
Sample usage:
```scala
scala> 1 + 1
res78: Int = 2
```
