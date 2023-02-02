class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1)
            return 1;
        char c;
        String out = "";
        int count = 1;
        for(int i = 0; i < chars.length; i++){
            c = chars[i];
            count = 1;
            inner: for(int j = i+1; j < chars.length; j++){
                if(chars[j] == c){
                    count++;
                }
                else
                    break inner;
            }
            if(count == 1)
                out = out + c;
            else
                out = out + c + String.valueOf(count);
            
            i += count - 1;
        }
        char[] outArr = out.toCharArray();
        for(int i = 0; i < outArr.length; i++)
            chars[i] = outArr[i];
        
        return outArr.length;
    }
}