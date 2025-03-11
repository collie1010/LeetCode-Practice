package Shuffle;

public class FisherYatesShuffle {
    // 用於打亂整數陣列的方法
    public void shuffle(int[] arr) {
        // 取得陣列長度
        int n = arr.length;
        
        // 從最後一個元素開始遍歷到第一個元素
        for (int i = n - 1; i > 0; i--) {
            // 產生一個從0到i的隨機索引
            int j = (int) (Math.random() * (i + 1));
            
            // 交換目前位置(i)和隨機位置(j)的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    // 用於打亂泛型陣列的方法
    public <T> void shuffle(T[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            
            // 交換元素
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    // 主方法用於測試
    public static void main(String[] args) {
        // 測試整數陣列
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        FisherYatesShuffle shuffler = new FisherYatesShuffle();
        
        System.out.println("原始整數陣列：");
        printArray(numbers);
        
        shuffler.shuffle(numbers);
        
        System.out.println("打亂後的整數陣列：");
        printArray(numbers);
        
        // 測試字串陣列
        String[] fruits = {"蘋果", "香蕉", "橘子", "葡萄", "草莓"};
        
        System.out.println("\n原始字串陣列：");
        printArray(fruits);
        
        shuffler.shuffle(fruits);
        
        System.out.println("打亂後的字串陣列：");
        printArray(fruits);
    }
    
    // 用於印出整數陣列的輔助方法
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // 用於印出泛型陣列的輔助方法
    private static <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

