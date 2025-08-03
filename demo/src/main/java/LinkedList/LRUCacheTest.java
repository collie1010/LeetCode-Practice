package LinkedList;

public class LRUCacheTest {
    public static void main(String[] args) {
        System.out.println("=== LRU Cache 測試程式 ===\n");
        
        // 測試案例 1: 基本功能測試
        testBasicOperations();
        
        // 測試案例 2: 容量限制測試
        testCapacityLimit();
        
        // 測試案例 3: 更新現有鍵值測試
        testUpdateExistingKey();
        
        // 測試案例 4: LRU 淘汰機制測試
        testLRUEviction();
        
        // 測試案例 5: 邊界條件測試
        testEdgeCases();
        
        System.out.println("=== 所有測試完成 ===");
    }
    
    // 測試基本的 get 和 put 操作
    private static void testBasicOperations() {
        System.out.println("測試 1: 基本功能測試");
        LRUCache cache = new LRUCache(2);
        
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("插入 (1,1) 和 (2,2)");
        
        System.out.println("get(1) = " + cache.get(1)); // 應該返回 1
        System.out.println("get(2) = " + cache.get(2)); // 應該返回 2
        System.out.println("get(3) = " + cache.get(3)); // 應該返回 -1 (不存在)
        System.out.println();
    }
    
    // 測試容量限制
    private static void testCapacityLimit() {
        System.out.println("測試 2: 容量限制測試");
        LRUCache cache = new LRUCache(2);
        
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("插入 (1,1) 和 (2,2) - 快取已滿");
        
        cache.put(3, 3); // 這應該會淘汰 key=1
        System.out.println("插入 (3,3) - 應該淘汰最久未使用的項目");
        
        System.out.println("get(1) = " + cache.get(1)); // 應該返回 -1 (已被淘汰)
        System.out.println("get(2) = " + cache.get(2)); // 應該返回 2
        System.out.println("get(3) = " + cache.get(3)); // 應該返回 3
        System.out.println();
    }
    
    // 測試更新現有鍵值
    private static void testUpdateExistingKey() {
        System.out.println("測試 3: 更新現有鍵值測試");
        LRUCache cache = new LRUCache(2);
        
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("插入 (1,1) 和 (2,2)");
        
        cache.put(1, 10); // 更新 key=1 的值
        System.out.println("更新 key=1 的值為 10");
        
        System.out.println("get(1) = " + cache.get(1)); // 應該返回 10
        System.out.println("get(2) = " + cache.get(2)); // 應該返回 2
        System.out.println();
    }
    
    // 測試 LRU 淘汰機制
    private static void testLRUEviction() {
        System.out.println("測試 4: LRU 淘汰機制測試");
        LRUCache cache = new LRUCache(3);
        
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println("插入 (1,1), (2,2), (3,3) - 快取已滿");
        
        System.out.println("存取 key=1，使其變為最近使用");
        cache.get(1); // 使 key=1 變為最近使用的
        
        cache.put(4, 4); // 這應該會淘汰 key=2 (最久未使用)
        System.out.println("插入 (4,4) - 應該淘汰 key=2");
        
        System.out.println("get(1) = " + cache.get(1)); // 應該返回 1
        System.out.println("get(2) = " + cache.get(2)); // 應該返回 -1 (已被淘汰)
        System.out.println("get(3) = " + cache.get(3)); // 應該返回 3
        System.out.println("get(4) = " + cache.get(4)); // 應該返回 4
        System.out.println();
    }
    
    // 測試邊界條件
    private static void testEdgeCases() {
        System.out.println("測試 5: 邊界條件測試");
        
        // 測試容量為 1 的快取
        System.out.println("容量為 1 的快取:");
        LRUCache cache1 = new LRUCache(1);
        cache1.put(1, 1);
        System.out.println("插入 (1,1)");
        System.out.println("get(1) = " + cache1.get(1)); // 應該返回 1
        
        cache1.put(2, 2);
        System.out.println("插入 (2,2) - 應該淘汰 (1,1)");
        System.out.println("get(1) = " + cache1.get(1)); // 應該返回 -1
        System.out.println("get(2) = " + cache1.get(2)); // 應該返回 2
        System.out.println();
        
        // 測試連續相同操作
        System.out.println("連續相同操作測試:");
        LRUCache cache2 = new LRUCache(2);
        cache2.put(1, 1);
        cache2.put(1, 10); // 更新同一個 key
        cache2.put(1, 100); // 再次更新同一個 key
        System.out.println("多次更新同一個 key");
        System.out.println("get(1) = " + cache2.get(1)); // 應該返回 100
        System.out.println();
    }
}

