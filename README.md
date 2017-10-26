# sbt-ethereum Documentation

[This Gitbook](https://mslinn.gitbooks.io/sbt-ethereum/content/) is the documentation for the family of projects based on 
[sbt-ethereum](https://github.com/swaldman/sbt-ethereum).

## Related Projects
  * [sbt-ethereum](https://github.com/swaldman/sbt-ethereum) SBT Plugin
  * [sbt-ethereum-docs](https://github.com/mslinn/sbt-ethereum-docs) The documentation you are reading is produced from this project
  * [eth-command-line](https://github.com/swaldman/eth-command-line) Ethereum command line client built from `sbt-ethereum`
  * [sbt-ethereum-seed](https://github.com/mslinn/sbt-ethereum-seed) Template for projects based on sbt-ethereum
  * [consuela](https://github.com/swaldman/sbt-ethereum) Scala library of ethereum and crypto-ish tools upon which `sbt-ethereum` is built
  * [eth-fortune](https://github.com/swaldman/eth-fortune) Sample Solidity app that uses `sbt-ethereum`

## Documentation Authors
This project has a custom SBT task for publishing called `commitAndPublishGitbook`.
You can invoke it from a bash shell like this:

    $ git add -A && git commit -m "Your comment here" && sbt commitAndPublishGitbook

If you are lazy or do not feel there is a need for a helpful commit comment, 
just run the SBT task and it will commit with a single dash in place of a comment:

    $ sbt commitAndPublishGitbook
