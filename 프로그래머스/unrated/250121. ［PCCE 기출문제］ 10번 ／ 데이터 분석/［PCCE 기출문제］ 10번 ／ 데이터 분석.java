import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        //1. 데이터 뽑기
        int ext_num = getNumber(ext);
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < data.length; i++)
            if(data[i][ext_num] < val_ext)
                list.add(data[i]);
        
        //2. 데이터 정렬하기
        int sort_num = getNumber(sort_by);
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sort_num] - o2[sort_num];
            }
        });
        
        //3. int[][]형으로 변환해 반환하기
        return getAnswer(list);
    }
    
    int getNumber(String s) {
        switch(s) {
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            default:
                return 3;
        }
    }
    
    int[][] getAnswer(ArrayList<int[]> list) {
        int[][] answer = new int[list.size()][];
        for(int i = 0; i < answer.length; i++) 
            answer[i] = list.get(i);
        return answer;
    }
}