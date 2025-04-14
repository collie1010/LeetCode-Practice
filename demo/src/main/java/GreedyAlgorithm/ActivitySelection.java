package GreedyAlgorithm;

import java.util.Arrays;

public class ActivitySelection {
	
	static class Activity {
		int start;
		int end;
		
		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	
	 public static void selectActivities(Activity[] activities) {
	        // 依照結束時間排序
	        Arrays.sort(activities, (a1, a2) -> a1.end - a2.end);
	        
	        // 選擇第一個活動
	        int i = 0;
	        System.out.println("選擇的活動：");
	        System.out.println("活動 " + i + ": (" + activities[i].start + ", " + activities[i].end + ")");
	        
	        // 選擇其他活動
	        for (int j = 1; j < activities.length; j++) {
	            // 如果這個活動的開始時間大於等於前一個活動的結束時間，選擇這個活動
	            if (activities[j].start >= activities[i].end) {
	                System.out.println("活動 " + j + ": (" + activities[j].start + ", " + activities[j].end + ")");
	                i = j;
	            }
	        }
	    }
	 
	 
	 public static void main(String[] args) {
	        Activity[] activities = {
	            new Activity(1, 4),
	            new Activity(3, 5),
	            new Activity(0, 6),
	            new Activity(5, 7),
	            new Activity(3, 8),
	            new Activity(5, 9),
	            new Activity(6, 10),
	            new Activity(8, 11),
	            new Activity(8, 12),
	            new Activity(2, 13),
	            new Activity(12, 14)
	        };
	        
	        selectActivities(activities);
	    }
	
}
