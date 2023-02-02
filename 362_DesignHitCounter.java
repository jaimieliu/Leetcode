class HitCounter {

    public ArrayList<Integer> list;
    
    public HitCounter() {
        list = new ArrayList<Integer>();
    }
    
    public void hit(int timestamp) {
        list.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        int count = 0;
        int min = timestamp - 300;
        for(int num: list){
            if(num > min && num <= timestamp)
                count++;
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */