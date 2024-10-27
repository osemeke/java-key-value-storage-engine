package main;

import java.io.Serializable;

public class Node implements Serializable {
    public long key;
    public String value;
    public Node left, right;

    public Node(long k, String v)
    {
        key = k;
        value = v;
        left = right = null;
    }

	public Node() {
		// TODO Auto-generated constructor stub
	}
}