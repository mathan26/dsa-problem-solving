package com.mathan.neetcode.stack.day09;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        //create array of of pairs [position, speed]
        double[][] cars = new double[n][2];

        for (int i = 0; i< n;i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // sort the cars based on position
        Arrays.sort(cars,(a, b)->Double.compare(a[0],b[0]));

        // stack to store arrival times of car fleets
        Stack<Double> stack = new Stack<>();

        for(int i=n-1; i>=0;i--) {
            double time = (target - cars[i][0])/cars[i][1]; // time to reach target

            //if current car takes more time than the car in front. it forms fleet
            if(stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // Else: it will catch up to a slower fleet and merge
        }
        return stack.size();

    }
}
