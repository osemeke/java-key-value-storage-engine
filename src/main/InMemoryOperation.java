package main;

import java.util.LinkedList;

public class InMemoryOperation {

	Node last;
	int nodes;
	LinkedList<Node> memtable = new LinkedList<Node>();
	
    public Node insert(Node root, long key, String value)
    {
        if (root == null)
            return new Node(key, value);

        if (root.key == key)
            return root;

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
            this.last = root; // ?
            inorder(root.right);
        }
        
		FileOperation fo = new FileOperation();
		fo.writeCommitLog(memtable);
    }
    
	public Node getRoot() {
		return this.last;
	}

	public int getSize() {
		return nodes;
	}

}