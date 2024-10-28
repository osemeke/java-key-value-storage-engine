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
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import common.Config;
import main.FileOperation;
import main.InMemoryOperation;
import main.KeyValueStore;
import main.Node;

class StoreTestCase {

	@ParameterizedTest
	@MethodSource("KeyValueStorePutTest")
	final void key_value_store_put_test(long key, String value, int expected) {
		KeyValueStore store = new KeyValueStore();		
		store.put(key, value);
		
		FileOperation fo = new FileOperation();		
		var memtable = fo.loadCommitLog();
		
		InMemoryOperation o = new InMemoryOperation();

		int count = memtable.size();
		System.out.println(count);
	    assertEquals(expected, count);
	}
	
	static Stream<Arguments> KeyValueStorePutTest() {
		int expect = 5;
		return Stream.of(
				Arguments.of(10, "Ossy", expect),
				Arguments.of(30, "Onyi", expect),
				Arguments.of(80, "John", expect),
				Arguments.of(31, "Messi", expect),
				Arguments.of(30, "Mary", expect),
				Arguments.of(20, "Edirin", expect)
		);
	}


}
