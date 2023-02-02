class Solution {
    public String longestCommonPrefix(String[] strs) {
        String out = "";
        int minLength = 200;
        for(String word: strs){
            if(word.length() < minLength) 
                minLength = word.length();
        }
        if(minLength == 0)
            return "";
        
        char last;
        
        for(int i = 0; i < minLength; i++){
            last = strs[0].charAt(i);
            for(String word: strs){
                if(word.charAt(i) != last)
                    return out;
            }
            out += strs[0].charAt(i);
        }
        
        return out;
    }
}