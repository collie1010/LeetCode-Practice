package BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // 將基因庫轉換為 Set，便於快速查找
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        // 如果目標基因不在基因庫中，無法到達
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        
        // BFS 設定
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        char[] genes = {'A', 'C', 'G', 'T'};
        
        queue.offer(startGene);
        visited.add(startGene);
        int mutations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // 處理當前層的所有基因
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                
                // 如果找到目標基因，返回突變次數
                if (currentGene.equals(endGene))  return mutations;

                // 嘗試改變基因的每一個位置
                for (int j = 0; j < 8; j++) {
                    char originalChar = currentGene.charAt(j);
                    
                    // 嘗試所有可能的基因字符
                    for (char gene : genes) {
                        if (gene == originalChar) continue; // 跳過相同字符
                        
                        // 創建新的基因字串
                        StringBuilder sb = new StringBuilder(currentGene);
                        sb.setCharAt(j, gene);
                        String newGene = sb.toString();
                        
                        // 如果新基因在基因庫中且未被訪問過
                        if (bankSet.contains(newGene) && !visited.contains(newGene)) {
                            queue.offer(newGene);
                            visited.add(newGene);
                        }
                    }
                }
            }
            mutations++;
        }
        
        return -1; // 無法到達目標基因
    }

    public static void main(String[] args) {
        MinimumGeneticMutation solution = new MinimumGeneticMutation();
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        int result = solution.minMutation(start, end, bank);
        System.out.println("Minimum mutations needed: " + result);
    }
}
