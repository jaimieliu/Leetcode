class Solution {
    public String convert(String s, int numRows) {
        List<Character[]> map = new ArrayList<Character[]>();
        int index = 0;
        int row = 0;
        if(numRows == 1){
            return s;
        }

        while(index < s.length()){
            Character[] arr = new Character[numRows];

            if(row == 0){
                for(int r = 0; r < numRows; r++){
                    if(index < s.length()){
                        arr[r] = s.charAt(index);
                        index++;
                    }
                }
                row = numRows-2;
            }
            else{
                arr[row] = s.charAt(index);
                index++;
                row--;
            }
            map.add(arr);
        }

        String output = "";
        for(int r = 0; r < numRows; r++){
            for(Character[] arr: map){
                if(arr[r] != null)
                    output += arr[r];
            }
        }

        return output;
    }
}