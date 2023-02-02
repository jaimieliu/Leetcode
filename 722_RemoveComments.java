class Solution {
    public List<String> removeComments(String[] source) {
        String sum = "";
        for(String str: source){
            sum += str + "\n";
        }

        int line, block;
        int index = 0;
        loop: while(index < sum.length()){
            line = sum.indexOf("//", index);
            block = sum.indexOf("/*", index);
            
            if(line == -1 && block == -1){
                break loop;
            }
            else if((line < block && line != -1) || block == -1){
                index = sum.indexOf("\n", line);
                sum = sum.substring(0, line) + sum.substring(index);
                index = line;   //since you deleted everyhting from line to index, now the char at index that you want to start looking at is at the line position
            }
            else if((block < line && block != -1) || line == -1){
                index = sum.indexOf("*/", block+2) + 2;
                if(index < sum.length())
                    sum = sum.substring(0, block) + sum.substring(index);
                else
                    sum = sum.substring(0, block);
                index = block;
            }
        }
        String[] outArr = sum.split("\n");
        List<String> out = new ArrayList<String>();
        for(String str: outArr){
            if(str != "")
                out.add(str);
        }
        return out;
    }
}