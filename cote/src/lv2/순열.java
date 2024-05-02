package lv2;

import java.util.ArrayList;
import java.util.List;

public class 순열 {

    public static List<List<Integer>> generatePermutations(List<Integer> elements) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), elements);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, List<Integer> elements) {
        if (tempList.size() <= elements.size()) {
            result.add(new ArrayList<>(tempList));
        }
        for (int i = 0; i < elements.size(); i++) {
            if (tempList.contains(elements.get(i))) continue; // Skip already used elements
            tempList.add(elements.get(i));
            backtrack(result, tempList, elements);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> elements = List.of(1, 2, 3); // 예시로 1, 2, 3을 원소로 가정
        List<List<Integer>> permutations = generatePermutations(elements);
        
        System.out.println("All possible permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }	
}
