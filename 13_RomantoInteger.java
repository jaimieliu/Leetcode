class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char last = 'M';
        for(int i = 0; i < s.length(); i++){
            if(map.get(last) >= map.get(s.charAt(i)))
                sum += map.get(s.charAt(i));
            else
                sum += map.get(s.charAt(i)) - (2 * map.get(last));
            last = s.charAt(i);
        }
        
        return sum;
    }
}