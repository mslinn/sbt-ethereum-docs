# sbt-ethereum Documentation

[This Gitbook](https://mslinn.gitbooks.io/sbt-ethereum/content/) is the documentation for the family of projects based on 
[sbt-ethereum](https://github.com/swaldman/sbt-ethereum).

## Related Projects
  * [eth-command-line](https://github.com/swaldman/eth-command-line) Ethereum command line client built from `sbt-ethereum`
  * [eth-fortune](https://github.com/swaldman/eth-fortune) Sample Solidity app that uses `sbt-ethereum`
  * [fatfinger](https://github.com/swaldman/fatfinger) TODO Is this relevant? If not, delete this line, otherwise, make this into a real comment
  * [jsonrpc-client](https://github.com/swaldman/jsonrpc-client) TODO Is this relevant? If not, delete this line, otherwise, make this into a real comment
  * [sbt-ethereum](https://github.com/swaldman/sbt-ethereum) SBT Plugin
  * [sbt-ethereum-seed](https://github.com/mslinn/sbt-ethereum-seed) Template for projects based on sbt-ethereum

## Documentation Authors
This project has a custom SBT task for publishing called `commitAndPublishGitbook`.
You can invoke it from a bash shell like this:

    $ git add -A && git commit -m "Your comment here" && sbt commitAndPublishGitbook

If you are lazy, and/or do not feel there is a need for a helpful commit comment, 
just run the SBT task and it will commit with a single dash in place of a comment:

    $ sbt commitAndPublishGitbook
