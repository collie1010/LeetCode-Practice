package GreedyAlgorithm;

import java.util.Arrays;

public class FractionalKnapsack {
	static class Item implements Comparable<Item> {
		int weight;
		int value;
		double ratio; // 價值重量比

		public Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
			this.ratio = (double) value / weight;
		}

		// 根據價值重量比降序排序
		@Override
		public int compareTo(Item other) {
			return Double.compare(other.ratio, this.ratio);
		}
	}

	public static double getMaxValue(int[] weights, int[] values, int capacity) {
		int n = weights.length;
		Item[] items = new Item[n];

		// 創建物品對象並計算價值重量比
		for (int i = 0; i < n; i++) {
			items[i] = new Item(weights[i], values[i]);
		}

		// 根據價值重量比排序
		Arrays.sort(items);

		double totalValue = 0;
		int currentWeight = 0;

		// 貪婪選擇，優先選擇價值重量比高的物品
		for (Item item : items) {
			if (currentWeight + item.weight <= capacity) {
				// 可以完整放入
				currentWeight += item.weight;
				totalValue += item.value;
				System.out.printf("選擇物品：重量 = %d, 價值 = %d, 使用比例 = 1.0%n", item.weight, item.value);
			} else {
				// 只能放入一部分
				int remainingCapacity = capacity - currentWeight;
				totalValue += item.ratio * remainingCapacity;
				System.out.printf("選擇物品：重量 = %d, 價值 = %d, 使用比例 = %.2f%n", item.weight, item.value,
						(double) remainingCapacity / item.weight);
				break;
			}
		}

		return totalValue;
	}

	public static void main(String[] args) {
		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };
		int capacity = 50;

		System.out.println("背包容量：" + capacity);
		System.out.println("可用物品：");
		for (int i = 0; i < weights.length; i++) {
			System.out.printf("物品 %d：重量 = %d, 價值 = %d, 單位價值 = %.2f%n", i + 1, weights[i], values[i],
					(double) values[i] / weights[i]);
		}

		System.out.println("\n解決方案：");
		double maxValue = getMaxValue(weights, values, capacity);
		System.out.printf("\n最大總價值：%.2f%n", maxValue);
	}
}
