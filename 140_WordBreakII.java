class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> out = new ArrayList<String>();
        findStrings(s, wordDict, out, "");
        return out;
    }
    
    public void findStrings(String s, List<String> wordDict, List<String> out, String sentence){
        if(s == ""){
            out.add(sentence.substring(0, sentence.length()-1));
        }
        for(int i = 1; i <= s.length(); i++){
            if(wordDict.contains(s.substring(0,i))){
                sentence += s.substring(0,i) + " ";
                findStrings(s.substring(i), wordDict, out, sentence);
                sentence = sentence.substring(0, sentence.length()-i-1);
            }
        }
    }
}