class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int n = arrays.length;
        int shortestIndex = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> common = new ArrayList<Integer>();
        
        for(int i = 0; i < n; i++){
            if(arrays[i].length < min){
                min = arrays[i].length;
                shortestIndex = i;
            }
        }
        
        for(int i = 0; i < arrays[shortestIndex].length; i++){
            int num = arrays[shortestIndex][i];
            outer: for(int j = 0; j < n; j++){
                inner: for(int k = 0; k < arrays[j].length; k++){
                    if(num > arrays[j][arrays[j].length-1])
                        break outer;
                    if(arrays[j][k] == num)
                        break inner;
                    if(arrays[j][k] > num)
                        break outer;
                }
                if(j == n-1)
                    common.add(num);
            }
        }
        
        return common;
    }
}