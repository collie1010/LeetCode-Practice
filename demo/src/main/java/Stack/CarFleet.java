package Stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        Stack<Double> stack = new Stack<>();
        for(int[] car : cars){
            stack.push((double)(target - car[0]) / car[1]);
            while(stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        CarFleet carFleet = new CarFleet();
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet.carFleet(target, position, speed));
    }
}
