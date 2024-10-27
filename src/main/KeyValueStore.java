package main;


public class KeyValueStore implements Store {
	
	InMemoryOperation memory;
	FileOperation fo;		

	public KeyValueStore() {
		memory = new InMemoryOperation();
		fo = new FileOperation();
	}

	@Override
	public void put(long key, String value) {
		var memtable = fo.loadCommitLog();
		Node root = null;
		if (memtable.size() > 0) root = memtable.getFirst();		
		var nr = memory.insert(root, key, value);
		System.out.println("new insertion!");
		memory.inorder(nr);
		memory.flush();
	}

	@Override
	public void read(long key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readKeyRange(long startKey, long endKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchPut(long[] keys, String[] values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long key) {
		// TODO Auto-generated method stub
		
	}

}
