class Solution {
    public int strStr(String haystack, String needle) {
        //Short Way
        //return haystack.indexOf(needle);

        //Longer Way
        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            if(haystack.substring(i, i + needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}