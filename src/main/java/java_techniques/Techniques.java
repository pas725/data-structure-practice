package java_techniques;

import java.util.*;
import java.util.stream.Collectors;

public class Techniques {
    public static void main(String[] args) {

        // 1D array, Initialize
        int arr_1d[] = {1,2,3};
        Arrays.fill(arr_1d, -1);    // Fill array


        // 2D array, Initialize with default value
        int dp[][] = new int[3][3];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        Arrays.stream(arr_1d).boxed().collect(Collectors.toList());

        // Heap
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();    // Min Heap
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());    // Max Heap

        // Heap with custom comparator
        PriorityQueue<Pair> min_comp_heap = new PriorityQueue<>(Comparator.comparingInt(Pair::getFreq));
        PriorityQueue<Pair> min_comp_heap1 = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        PriorityQueue<Pair> max_comp_heap = new PriorityQueue<>(Comparator.comparingInt(Pair::getFreq).reversed());

        // Map
        Map<Integer, String> map = new HashMap<>();
        map.forEach((k, v) -> System.out.println("Key=" + k + ", Value=" + v));


        TreeMap<Integer, Integer> treeMap = new TreeMap<>();


        // Sorted Set
        TreeSet<Integer> tm = new TreeSet<>();
        tm.add(3);
        tm.pollFirst(); // Remove first
        tm.pollLast();  // Remove last
        tm.lower(5);
        tm.higher(6);
        tm.stream().forEach(System.out::println);   // Iterate

        // Stack
        Stack<Integer> stack = new Stack<>();

        // Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.poll();   // Remove first
        queue.offer(3);   // Add to last

        // List of list
        List<List<Integer>> list = new ArrayList<>();
        List<int[]> lista = new ArrayList<>();
        list.forEach(System.out::println);


        Map<Character, Integer> map1 = new HashMap<>(); map1.put('c', 10); map1.put('a', 3);
        Map<Character, Integer> map2 = new HashMap<>(); map2.put('a', 3); map2.put('c', 10); map2.put('d', 7);


        LinkedList a = new LinkedList();
        a.add(2);
        a.remove(6);

        // Collections.sort(, );
    }
}

class Pair {
    int num;
    int freq;

    public Pair(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    public int getNum() {
        return num;
    }

    public int getFreq() {
        return freq;
    }
}
