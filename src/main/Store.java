package main;

public interface Store {
	public void put(long key, String value);
	public void read(long key);
	public void readKeyRange(long startKey, long endKey);
	public void batchPut(long[] keys, String[] values);
	public void delete(long key);
}
