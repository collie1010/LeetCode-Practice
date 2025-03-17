package Tries;

import java.util.ArrayList;
import java.util.List;

public class Trie {
private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    // 插入單字
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        
        TrieNode current = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            int index = ch - 'a';
            if (current.getChildren()[index] == null) {
                current.getChildren()[index] = new TrieNode();
            }
            current = current.getChildren()[index];
        }
        current.setEndOfWord(true);
    }
    
    // 搜尋單字
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        
        TrieNode node = searchNode(word.toLowerCase());
        return node != null && node.isEndOfWord();
    }
    
    // 檢查是否有指定前綴的單字
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        return searchNode(prefix.toLowerCase()) != null;
    }
    
    // 輔助方法：搜尋節點
    private TrieNode searchNode(String str) {
        TrieNode current = root;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (current.getChildren()[index] == null) {
                return null;
            }
            current = current.getChildren()[index];
        }
        return current;
    }
    
    // 刪除單字
    public void delete(String word) {
        delete(root, word.toLowerCase(), 0);
    }
    
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return isEmpty(current);
        }
        
        int charIndex = word.charAt(index) - 'a';
        TrieNode node = current.getChildren()[charIndex];
        if (node == null) {
            return false;
        }
        
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);
        
        if (shouldDeleteCurrentNode) {
            current.getChildren()[charIndex] = null;
            return isEmpty(current);
        }
        return false;
    }
    
    // 檢查節點是否為空
    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.getChildren()) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }
    
    // 取得所有儲存的單字
    public List<String> getAllWords() {
        List<String> words = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        getAllWordsHelper(root, current, words);
        return words;
    }
    
    private void getAllWordsHelper(TrieNode node, StringBuilder current, List<String> words) {
        if (node.isEndOfWord()) {
            words.add(current.toString());
        }
        
        for (int i = 0; i < node.getChildren().length; i++) {
            if (node.getChildren()[i] != null) {
                current.append((char)('a' + i));
                getAllWordsHelper(node.getChildren()[i], current, words);
                current.setLength(current.length() - 1);
            }
        }
    }
    
    // 計算總單字數
    public int countWords() {
        return countWordsHelper(root);
    }
    
    private int countWordsHelper(TrieNode node) {
        int count = 0;
        if (node.isEndOfWord()) {
            count++;
        }
        
        for (TrieNode child : node.getChildren()) {
            if (child != null) {
                count += countWordsHelper(child);
            }
        }
        return count;
    }
}
