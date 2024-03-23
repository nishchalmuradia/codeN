package leetcodedaily.greedyAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item {
    int price;
    int weight;

    public Item(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }
}

class ItemComparator implements Comparator<Item> {
    // comparsion logic for sorting in p/w factor
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double) (a.price) / (double) (a.weight);
        double r2 = (double) (b.price) / (double) (b.weight);
        return Double.compare(r2, r1);
    }
}

public class FractionalKnapsackProblem {
    public static int fractionalKnapsack(int totalWeight, Item arr[], int n) {

        // adding items to the knapsackList
        List<Item> knapsackList = new ArrayList<>();
        for (Item i : arr) {
            knapsackList.add(i);
        }


        //sorting
        ItemComparator itemComparator = new ItemComparator();
        Collections.sort(knapsackList, itemComparator);
        int maxProfit = 0;

        //actual logic to empty the bag and add count profit
        for (int i = 0; i < knapsackList.size(); i++) {
            if (totalWeight == 0) {
                break;
            }
            if (knapsackList.get(i).weight <= totalWeight) {
                maxProfit += knapsackList.get(i).price;
            } else {
                maxProfit += (totalWeight * (knapsackList.get(i).price / knapsackList.get(i).weight));
            }
            totalWeight -= knapsackList.get(i).weight;
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        int n = 3, weight = 15;
        Item arr[] = {
                new Item(5, 1),
                new Item(10, 3),
                new Item(15, 5),
                new Item(7, 4),
                new Item(8, 1),
                new Item(9, 3),
                new Item(4, 2)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is " + ans);
    }

}
