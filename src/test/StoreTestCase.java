package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import main.Config;
import main.FileOperation;
import main.InMemoryOperation;
import main.Node;

class StoreTestCase {

	@Test
	final void test() throws IOException {
		InMemoryOperation o = new InMemoryOperation();

		Node root = null;

		root = o.insert(root, 50, "good");
		root = o.insert(root, 90, "to");
		root = o.insert(root, 30, "know");
		root = o.insert(root, 30, "this");
		root = o.insert(root, 20, "thing");
		root = o.insert(root, 40, "will");
		root = o.insert(root, 70, "work");
		root = o.insert(root, 60, "at");
		root = o.insert(root, 80, "the");
		root = o.insert(root, 10, "1000th");
		root = o.insert(root, 80, "trial");

		// Print inorder traversal of the BST
		o.inorder(root);

		var last = o.getRoot();
		System.out.print(last.key + " ----> " + last.value + "\n");
		System.out.print(o.getSize());

		System.out.print("CHECKING LOAD\n");

		FileOperation fo = new FileOperation();		
		var list = fo.loadCommitLog();
		for (Node n : list) {
			System.out.print(n.key + " ----> " + n.value + "\n");
		}
		// PrintWriter writer = new PrintWriter(p, "UTF-8");
		// fo.writeLog(root, writer);

		// byte data[] = ...
		// String data = "wertyuiok sdfghj";
		// byte[] b = data.getBytes(StandardCharsets.UTF_8); // Java 7+ only


		fail("Not yet implemented");
	}



}
