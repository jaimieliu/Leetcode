class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        char[] temp = new char[strs[0].length()];
        String orig = "";
        for(int i = 0; i < strs.length; i++){
            orig = strs[i];
            temp = strs[i].toCharArray();
            Arrays.sort(temp);
            strs[i] = String.valueOf(temp);
            if(!map.containsKey(strs[i])){
                List<String> tempList = new ArrayList<String>();
                tempList.add(orig);
                map.put(strs[i], tempList);
            }
            else{
                List<String> tempList = new ArrayList<String>(map.get(strs[i]));
                tempList.add(orig);
                map.put(strs[i], tempList);
            }
            
        }
        for(String key: map.keySet()){
            list.add(map.get(key));
        }
        
        return list;
    }
}