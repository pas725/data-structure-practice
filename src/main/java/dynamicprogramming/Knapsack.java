package dynamicprogramming;

/*
 * Created by piyush_sagar on 1/18/19.
 * https://www.hackerearth.com/practice/notes/the-knapsack-problem/
 */
public class Knapsack {

    public static void main(String[] args) {
        int profit[] = {10, 40, 30, 50};
        int itemWeight[] = {5, 4, 6, 3};
        int capacity = 12;

        int result = knapsack(profit, itemWeight, capacity);

        System.out.println("Knapsack is filled with weight : " + result);
    }

    private static int knapsack(int[] profit, int[] item, int capacity) {
        int items = item.length;
        int memo[][] = new int[items+1][capacity+1];

        for (int row=1; row<= items; row++) {
            for (int weight = 1; weight <= capacity; weight++) {
                if (item[row-1] <= weight) {
                    memo[row][weight] = Math.max(
                            memo[row-1][weight],
                            profit[row-1] + memo[row-1][weight-item[row-1]]
                    );
                } else {
                    memo[row][weight] = memo[row-1][weight];
                }
            }
        }

        return memo[items][capacity];
    }
}
