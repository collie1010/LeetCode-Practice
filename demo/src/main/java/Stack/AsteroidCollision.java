package Stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
	
	public int[] asteroidCollisionWithStack(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();

		for (int asteroid : asteroids) {
			// 處理碰撞
			boolean survived = true;

			while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
				// 比較當前小行星和堆疊頂部小行星的大小
				if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
					// 堆疊頂部的小行星爆炸
					stack.pop();
					continue;
				} else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
					// 兩個小行星都爆炸
					stack.pop();
					survived = false;
				} else {
					// 當前小行星爆炸
					survived = false;
				}
				break;
			}

			if (survived) {
				stack.push(asteroid);
			}
		}

		// 將堆疊轉換為數組
		int[] result = new int[stack.size()];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}

		return result;
	}

	public int[] asteroidCollision(int[] asteroids) {
		int top = -1; // 使用陣列模擬堆疊

		for (int asteroid : asteroids) {
			boolean survived = true;

			while (top >= 0 && asteroid < 0 && asteroids[top] > 0) {
				if (Math.abs(asteroids[top]) < Math.abs(asteroid)) {
					top--;
					continue;
				} else if (Math.abs(asteroids[top]) == Math.abs(asteroid)) {
					top--;
					survived = false;
				} else {
					survived = false;
				}
				break;
			}

			if (survived) {
				asteroids[++top] = asteroid;
			}
		}

		return Arrays.copyOf(asteroids, top + 1);
	}
}
