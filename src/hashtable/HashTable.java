package hashtable;

import java.util.TreeMap;

public class HashTable<K, V> {
    // 哈希表適用質數列表
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private int capacityIndex = 7;
    // 鏈地址法，separate Chaining
    // 每個地址存一個查找表，查找表可以是鏈接串列，也可以是平衡樹
    private TreeMap<K, V>[] hashTable;
    private int size;
    private int M; // 地址空間
    public HashTable() {
        this.M = capacity[capacityIndex];
        hashTable = new TreeMap[M];
        for(int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; // hash函數求得索引值，& 0x7fffffff就是取絕對值
    }
    public int getSize() {
        return size;
    }
    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if(map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if(size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }
    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for(int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = M;
        this.M = newM;
        for(int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            for(K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key)); // 從舊hashTable每個索引地址中取出每個平衡樹中的元素
            }
        }
        this.hashTable = newHashTable;
    }
    public V remove(K key) {
        V ret = null;
        TreeMap<K, V> map = hashTable[hash(key)];
        if(map.containsKey(key)) {
            ret = map.get(key);
            size--;
            if(size < lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }
    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if(!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist.");
        }
        map.put(key, value);
    }
    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }
    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }
}
