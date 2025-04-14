package GreedyAlgorithm;

import java.util.Arrays;

public class AssignCookies {

	public int findContentChildren(int[] g, int[] s) {
		// 先將兩個陣列排序
		Arrays.sort(g); // 孩子的需求因子排序
		Arrays.sort(s); // 餅乾尺寸排序

		int contentChildren = 0; // 滿足的孩子數量
		int cookieIndex = 0; // 餅乾索引
		int childIndex = 0; // 孩子索引

		// 當還有餅乾和還有孩子時，繼續嘗試分配
		while (cookieIndex < s.length && childIndex < g.length) {
			// 如果當前餅乾能滿足當前孩子
			if (s[cookieIndex] >= g[childIndex]) {
				contentChildren++; // 滿足的孩子數量加1
				childIndex++; // 移到下一個孩子
			}
			cookieIndex++; // 無論是否滿足，都嘗試下一塊餅乾
		}

		return contentChildren;
	}

	public static void main(String[] args) {
		AssignCookies solution = new AssignCookies();

		// 測試範例
		int[] g = { 1, 2, 3 };
		int[] s = { 1, 1 };

		int result = solution.findContentChildren(g, s);
		System.out.println("能夠滿足的孩子數量: " + result);

		// 詳細過程演示
		System.out.println("\n分配過程:");
		System.out.println("孩子的需求: " + Arrays.toString(g));
		System.out.println("餅乾的尺寸: " + Arrays.toString(s));
	}
}
