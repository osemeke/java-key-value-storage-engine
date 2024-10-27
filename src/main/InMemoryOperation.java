package main;

import java.util.LinkedList;
import java.lang.instrument.Instrumentation;

public class InMemoryOperation {

	int nodes;
	LinkedList<Node> memtable = new LinkedList<Node>();
	
	FileOperation fo;

	public InMemoryOperation() {
		fo = new FileOperation();
		
	}
	
    public Node insert(Node root, long key, String value)
    {
        if (root == null) return new Node(key, value);

        if (root.key == key) 
        {
        	root.SetValue(value);
        	return root;
        }
        
        if (key < root.key)
            root.left = insert(root.left, key, value);
        else
            root.right = insert(root.right, key, value);

        return root;
    }
    
    public void inorder(Node root)
    {
        if (root != null) {
            inorder(root.left);
            nodes++;
        	memtable.add(root);
            System.out.print(nodes + ": " + root.key + " -> " + root.value + "\n");
            inorder(root.right);
        }
        
		fo = new FileOperation();
    	fo.writeCommitLog(memtable);

    }
    
	public int getNodeCount() {
		return nodes;
	}

	public void flush() {

		long size = fo.getFileSize(Config.COMMIT_LOG_FILE);

		System.out.print("\nMax: " + Config.MAXIMUM_RANDOM_ACCESS_MEMORY);
		System.out.print("\nSize: " + size);
		System.out.print("\nSize: " + memtable.size());

		if (exceedsMaximumAllowedMemory())	{
			// clear commit log file
	    	fo.writeCommitLog(new LinkedList<Node>());
	    	Compaction compaction = new Compaction();
			compaction.run(memtable);
			System.out.print("\nRUN COMPACTION!\n");
		}
	}

	private boolean exceedsMaximumAllowedMemory() {
		//long size = fo.getFileSize(Config.COMMIT_LOG_FILE);
		 long size = memtable.size();
		return size > Config.MAXIMUM_RANDOM_ACCESS_MEMORY ? true : false;
	}

}