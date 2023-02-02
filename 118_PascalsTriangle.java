class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        List<Integer> prevRow = new ArrayList<Integer>();
        List<Integer> row = new ArrayList<Integer>();
        //element is sum of index-1 + index of row before
        row.add(1);
        out.add(row);
        int a;
        for(int i = 1; i < numRows; i++){
            a = i+1; //number of elements in the row
            row = new ArrayList<Integer>();
            row.add(out.get(i-1).get(0));
            for(int j = 1; j < a-1; j++){
                row.add(out.get(i-1).get(j-1) + out.get(i-1).get(j));
            }
            row.add(out.get(i-1).get(a-2));
            out.add(row);
        }
        return out;
    }
}