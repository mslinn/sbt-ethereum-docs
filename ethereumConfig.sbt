libraryDependencies += "com.mchange" %% "consuela" % "0.0.3-SNAPSHOT"

ethJsonRpcUrl := Option(System.getenv("ETH_INFURA_TOKEN"))
  .map { token =>
    // If you do not want to set up your own Ethereum node, and you do not want to use our Ethereum node, you can use an Infura Ethereum node.
    // To do this:
    // 1) Get an Infura token: https://infura.io/#how-to
    // 2) Define an environment variable called ETH_INFURA_TOKEN to hold the token
    //    You might want to set the environment variable in `~/.bashrc`, `~/.profile` or `~/.bash_profile`, like this:
    //    export ETH_INFURA_TOKEN="blahblahblah"
    // The next time you run this project from SBT the token will be used to connect with an Infura Ethereum node.

    // The eth-command-line client uses the token to access an Infura Ethereum node by the following incantation:
    s"http://mainnet.infura.io/$token"
  }.getOrElse {
    Option(System.getenv("ETH_DEFAULT_NODE")) // Define this environment variable with the entire URL for the Ethereum node you wish to use
      .getOrElse { // If neither environment variables are defined, use this value
        //"http://192.168.10.49:8545"
        "http://ethjsonrpc.mchange.com:8545/"
      }
  }

ethPackageScalaStubs := "eth.anyone.contract"
