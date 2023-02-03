class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int left = i, right = i;

            while(left >= 0 && s.charAt(left) == c){
                left--;
            }
            while(right <= s.length()-1 && s.charAt(right) == c){
                right++;
            }

            while(left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            if(right-left-1 > longest.length()){
                longest = s.substring(left+1, right);
            }
        }

        return longest;
    }
}