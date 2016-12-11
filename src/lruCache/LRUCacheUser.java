package lruCache;

import java.util.*;
import java.io.*;

public class LRUCacheUser {
	// TODO: fix this broken LRU cache -- although it kinda works now as-is, but not quite
	public static void main(String[] args) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("lruCacheInput"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		LRUCache<Character> cache;
		int cacheSize; String str;
		while (scan.hasNext()) {
			cacheSize = scan.nextInt();
			str = scan.next();
			
			cache = new LRUCache<Character>(cacheSize);
			for (char c : str.toCharArray()) {
				if (c != '!') {
					cache.reference(c);
				} else {
					cache.printOutput();
				}
			}
		}
	}
}
