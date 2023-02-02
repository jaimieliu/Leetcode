public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String input = Integer.toBinaryString(n);
        int count = 0;

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '1'){
                count++;
            }
        }

        return count;
    }
}