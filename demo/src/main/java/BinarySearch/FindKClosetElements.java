package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosetElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        int left = 0;
		int right = arr.length - 1;
		while (right - left >= k) {
			if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
				left++;
			} else {
				right--;
			}
		}

        for (int i = left; i <= right; i++) {
			result.add(arr[i]);
		}
		return result;
    }
}
