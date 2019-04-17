package com.datastructures.hashtable;

@SuppressWarnings("unchecked")
public class HashTable<Key, Value> {

	private static final int defaultCapacity = 11;
	private Key[] keys;
	private Value[] values;
	private int numberOfItems;
	private int capacity;

	public HashTable() {
		this.keys = (Key[]) new Object[defaultCapacity];
		this.values = (Value[]) new Object[defaultCapacity];
		this.numberOfItems = 0;
		this.capacity = defaultCapacity;
	}

	public HashTable(int newCapacity) {
		this.keys = (Key[]) new Object[newCapacity];
		this.values = (Value[]) new Object[newCapacity];
		this.numberOfItems = 0;
		this.capacity = newCapacity;
	}

	public Key[] getKeys() {
		return keys;
	}

	public Value[] getValues() {
		return values;
	}

	public int getCapacity() {
		return capacity;
	}

	public int size() {
		return this.numberOfItems;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	private int hash(Key key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public void put(Key key, Value value) {
		if (key == null && value == null)
			return;
		if (numberOfItems >= capacity * 0.75)
			resize(2 * capacity);
		int index = hash(key);
		while (keys[index] != null) {
			if (keys[index].equals(key)) {
				values[index] = value;
				return;
			}
			index = (index + 1) % capacity;
		}
		keys[index] = key;
		values[index] = value;
		numberOfItems++;
	}

	public Value get(Key key) {
		if (key == null)
			return null;
		int index = hash(key);
		while (keys[index] != null) {
			if (keys[index].equals(key))
				return values[index];
			index = (index + 1) % capacity;
		}
		return null;
	}

	public void remove(Key key) {
		if (key == null)
			return;
		int index = hash(key);
		while (!keys[index].equals(key)) {
			index = (index + 1) % capacity;
		}
		keys[index] = null;
		values[index] = null;
		index = (index + 1) % capacity;
		while (keys[index] != null) {
			Key tempKey = keys[index];
			Value tempValue = values[index];
			keys[index] = null;
			values[index] = null;
			numberOfItems--;
			put(tempKey, tempValue);
			index = (index + 1) % capacity;
		}
		numberOfItems--;
		if (numberOfItems <= capacity / 3)
			resize(capacity / 3);
	}

	private void resize(int newCapacity) {
		System.out.println("Resize table with new capacity: " + newCapacity);
		HashTable<Key, Value> newTable = new HashTable<>(newCapacity);
		for (int i = 0; i < capacity; ++i) {
			if (keys[i] != null)
				newTable.put(keys[i], values[i]);
		}
		this.keys = newTable.getKeys();
		this.values = newTable.getValues();
		this.capacity = newTable.getCapacity();
	}

	public static void main(String args[]) {
		HashTable<String, Integer> hashTable = new HashTable<>();

		hashTable.put("a", 1);
		System.out.println(hashTable.size());
		hashTable.put("b", 2);
		System.out.println(hashTable.size());
		hashTable.put("c", 3);
		System.out.println(hashTable.size());
		hashTable.put("d", 4);
		System.out.println(hashTable.size());
		hashTable.put("e", 5);
		System.out.println(hashTable.size());
		hashTable.put("f", 6);
		System.out.println(hashTable.size());
		hashTable.put("g", 7);
		System.out.println(hashTable.size());
		hashTable.put("h", 8);
		System.out.println(hashTable.size());
		hashTable.put("j", 9);
		System.out.println(hashTable.size());
		hashTable.put("k", 10);
		System.out.println(hashTable.size());
		hashTable.put("l", 11);
		System.out.println(hashTable.size());
		hashTable.put("m", 12);
		System.out.println(hashTable.size());
		hashTable.put("n", 13);
		System.out.println(hashTable.size());
		hashTable.put("bb", 14);
		System.out.println(hashTable.size());
		hashTable.put("v", 15);
		System.out.println(hashTable.size());
		hashTable.put("bbc", 16);
		System.out.println(hashTable.size());
		hashTable.put("x", 17);
		System.out.println(hashTable.size());
		hashTable.put("y", 18);
		System.out.println(hashTable.size());

		hashTable.remove("c");
		System.out.println(hashTable.size());

		hashTable.remove("h");
		System.out.println(hashTable.size());
		hashTable.remove("j");
		System.out.println(hashTable.size());
		hashTable.remove("k");
		System.out.println(hashTable.size());
		hashTable.remove("l");
		System.out.println(hashTable.size());
		hashTable.remove("m");
		System.out.println(hashTable.size());
		hashTable.remove("n");
		System.out.println(hashTable.size());
		hashTable.remove("bb");
		System.out.println(hashTable.size());
		hashTable.remove("v");
		System.out.println(hashTable.size());
		hashTable.remove("bbc");
		System.out.println(hashTable.size());
		hashTable.remove("x");
		System.out.println(hashTable.size());
		hashTable.remove("a");
		System.out.println(hashTable.size());
		hashTable.remove("b");
		System.out.println(hashTable.size());
		hashTable.remove("d");
		System.out.println(hashTable.size());
		hashTable.remove("e");
		System.out.println(hashTable.size());
		hashTable.remove("f");
		System.out.println(hashTable.size());
	}
}
