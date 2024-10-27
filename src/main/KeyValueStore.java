package main;


public class KeyValueStore implements Store {
	
	InMemoryOperation o;
	
	public KeyValueStore() {
		o = new InMemoryOperation();
	}

	@Override
	public void put(long key, String value) {
        Node root = o.getRoot();
		o.insert(root, key, value);
		System.out.println("new insertion!");
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
