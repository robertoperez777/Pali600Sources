package Threads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
		map.putIfAbsent("1", "1");
		map.putIfAbsent("2", "2");
		map.putIfAbsent("3", "3");
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> entry = entrySet.iterator();
		while(entry.hasNext()){
			map.putIfAbsent("5", "5");
			System.out.println("Concurrent" + entry.next());
		}
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("1", "1");
		hashMap.put("2", "2");
		hashMap.put("3", "3");
		Set<Entry<String, String>> hashMapSet = hashMap.entrySet();
		Iterator<Entry<String, String>> entr = hashMapSet.iterator();
		while(entr.hasNext()){
			hashMap.put("5", "5");
			System.out.println("Map"+entr.next());
		}

	}

}
