package com.tis.emo;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.logging.Logger;
 
public class LRUCache < K, V > extends LinkedHashMap < K, V > {
 
    private int capacity; // Maximum number of items in the cache.
   private static Logger _logger = Logger.getLogger(LRUCache.class.getName());
     
    public LRUCache(int capacity) { 
        super(capacity+1, 1.0f, true); // Pass 'true' for accessOrder.
        this.capacity = capacity;
    }
     
    protected boolean removeEldestEntry(Entry entry) {
        return (size() > this.capacity);
    } 
    
    
	public static void main(String[] args) {
    	_logger.info("setting value for gache ");
    	LRUCache cache = new LRUCache<>(5);
    	cache.put(1, "sample1");
    	_logger.info("setting value for gache cache.put(1, \"sample1\");");
    	cache.put(2, "sample1");
    	_logger.info("setting value for gache cache.put(2, \"sample2\");");
    	cache.put(3, "sample1");
    	_logger.info("setting value for gache cache.put(3, \"sample3\");");
    	cache.put(4, "sample1");
    	_logger.info("setting value for gache cache.put(4, \"sample4\");");
    	cache.put(5, "sample1");
    	_logger.info("setting value for gache cache.put(5, \"sample5\");");
    	
    	_logger.info(cache+ "--->  This is the value of the cache");
    	
    	_logger.info(cache+ "--->  This is the value of the cache");
    	cache.put(6, "sample6");
    	_logger.info("setting value for gache cache.put(6, \"sample6\");");
    	
         cache.put(7, "sample7");
    	_logger.info("setting value for gache cache.put(6, \"sample6\");");
    	
    	
    	_logger.info(cache+ "---> "
    			+ "------> This is the value of the cache"
    			+ "------>"
    			+ "------>"
    			+ "------>"
    			+ "------>"
    			+ "------>"
    			+ "------>"
    			);
    	
    	_logger.info(cache.get(1)+"   thisis getting 1 Key ");
    	
  
    }
}
