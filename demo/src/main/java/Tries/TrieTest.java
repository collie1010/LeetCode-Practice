package Tries;

import java.util.List;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        
        // 測試插入
        System.out.println("===測試插入===");
        trie.insert("hello");
        trie.insert("world");
        trie.insert("hi");
        trie.insert("hey");
        
        // 測試搜尋
        System.out.println("搜尋 'hello': " + trie.search("hello"));  // true
        System.out.println("搜尋 'world': " + trie.search("world"));  // true
        System.out.println("搜尋 'hi': " + trie.search("hi"));        // true
        System.out.println("搜尋 'hey': " + trie.search("hey"));      // true
        System.out.println("搜尋 'hell': " + trie.search("hell"));    // false
        
        // 測試前綴搜尋
        System.out.println("\n===測試前綴搜尋===");
        System.out.println("前綴 'he': " + trie.startsWith("he"));    // true
        System.out.println("前綴 'wo': " + trie.startsWith("wo"));    // true
        System.out.println("前綴 'ha': " + trie.startsWith("ha"));    // false
        
        // 顯示所有單字
        System.out.println("\n===所有儲存的單字===");
        List<String> allWords = trie.getAllWords();
        System.out.println(allWords);
        
        // 計算單字數
        System.out.println("\n===單字總數===");
        System.out.println("總單字數: " + trie.countWords());
        
        // 測試刪除
        System.out.println("\n===測試刪除===");
        trie.delete("hello");
        System.out.println("刪除 'hello' 後搜尋: " + trie.search("hello"));  // false
        System.out.println("搜尋 'hey': " + trie.search("hey"));             // true
        
        // 再次顯示所有單字
        System.out.println("\n===刪除後的所有單字===");
        allWords = trie.getAllWords();
        System.out.println(allWords);
    }
}

