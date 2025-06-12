package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
	public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') radiant.offer(i);
            else dire.offer(i);
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if (rIndex < dIndex) radiant.offer(rIndex + n);
            else dire.offer(dIndex + n);

        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
	
	 public static void main(String[] args) {
		 	Dota2Senate solution = new Dota2Senate();
	        
	        // 測試案例1
	        String senate1 = "RD";
	        System.out.println("Test Case 1:");
	        System.out.println("Input: " + senate1);
	        System.out.println("Output: " + solution.predictPartyVictory(senate1));
	        System.out.println();
	        
	        // 測試案例2
	        String senate2 = "RDD";
	        System.out.println("Test Case 2:");
	        System.out.println("Input: " + senate2);
	        System.out.println("Output: " + solution.predictPartyVictory(senate2));
	        System.out.println();
	        
	        // 測試案例3 - 較長的字符串
	        String senate3 = "RDRDRD";
	        System.out.println("Test Case 3:");
	        System.out.println("Input: " + senate3);
	        System.out.println("Output: " + solution.predictPartyVictory(senate3));
	        System.out.println();
	        
	        // 測試案例4 - 全是同一陣營
	        String senate4 = "RRR";
	        System.out.println("Test Case 4:");
	        System.out.println("Input: " + senate4);
	        System.out.println("Output: " + solution.predictPartyVictory(senate4));
	        System.out.println();
	        
	        // 測試案例5 - 交替出現
	        String senate5 = "DRRD";
	        System.out.println("Test Case 5:");
	        System.out.println("Input: " + senate5);
	        System.out.println("Output: " + solution.predictPartyVictory(senate5));
	        System.out.println();

	        // 測試案例6 - 單一字符
	        String senate6 = "R";
	        System.out.println("Test Case 6:");
	        System.out.println("Input: " + senate6);
	        System.out.println("Output: " + solution.predictPartyVictory(senate6));
	        System.out.println();
	    }
}
