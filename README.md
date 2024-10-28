# Java Key/Value Storage Engine
Implementation of a network-available persistent Key/Value system

## In progress

This work is not complete.

## Design plan

- Client - Server `socket` connection to create a sort of cli interface
- In-memory store `memtable` implementation with a `balance binary tree`
- A `commit log` to ensure durability for cases like server crashes
- In-memory `flush` to disk when `memtable` size exceeds that set in the configuration
- Compaction module to merge `SSTable` segments written in LSM level folders
- Implement the two `compaction` strategies - `leveling` (eager) and `tiering` (lazy)
- Implement read on the `SSTables` on disk
- Flag a key with `tombstone` synmbol to implement delete
- implement all command interfaces for the key value store

## Extra
- Bloomfilter for disk read optimization
- Sparse index for disk read optimization


