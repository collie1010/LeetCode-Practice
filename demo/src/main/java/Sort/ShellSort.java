package Sort;

public class ShellSort {
    public void shellSort(int[] array) {
        int n = array.length;
        
        // 開始時使用較大的間隔，然後逐漸減小至1
        for (int gap = n/2; gap > 0; gap /= 2) {
            // 對每個間隔進行插入排序
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                
                // 對間隔為gap的元素進行插入排序
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
    
    // 印出陣列的輔助方法
    public void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // 主程式測試
    public static void main(String[] args) {
        ShellSort sorter = new ShellSort();
        
        // 測試案例
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("原始陣列：");
        sorter.printArray(array);
        
        sorter.shellSort(array);
        
        System.out.println("排序後陣列：");
        sorter.printArray(array);
    }
}
