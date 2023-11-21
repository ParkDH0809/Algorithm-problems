import java.util.*;

class Solution {
    Set<Integer> set;
    int[] arr;
    public int solution(int[] elements) {
        arr = new int[elements.length * 2];
        set = new HashSet<>();
        
        System.arraycopy(elements, 0, arr, 0, elements.length);
        System.arraycopy(elements, 0, arr, elements.length, elements.length);
        
        for(int i = 1; i <= elements.length; i++) {
            method(i);
        }
        return set.size();
    }
    
    public void method(int n) {
        for(int i = 0; i < arr.length / 2; i++) {
            int sum = 0;
            for(int j = i; j < n + i; j++) {
                sum += arr[j];
            }
            set.add(sum);
        }
    }
}