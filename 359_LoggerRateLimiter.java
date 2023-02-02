class Logger {
    public HashMap<String, Integer> stringTime;
    
    public Logger() {
        stringTime = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(stringTime.containsKey(message)){
            if(stringTime.get(message) + 10 <= timestamp){
                stringTime.put(message, timestamp);
                return true;
            }
            return false;
        }
        else{
            stringTime.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */