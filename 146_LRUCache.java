class LRUCache {

    public int capacity;
    public Node head;
    public Node tail;
    public HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(0,0);
        tail = new Node(0,0);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key){
        if(map.containsKey(key)){
            Node temp = map.get(key);
            update(temp);
            return temp.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.value = value;
            update(temp);
        }
        else{
            Node temp = new Node(key, value);
            if(map.size() == capacity){
                //Remove least used from map
                map.remove(tail.prev.key);
                //Change pointers of nodes before and after the removed element in map
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
            }
            map.put(key, temp);
            update(temp);
        }
    }
    
    // head most recently used...........least used tail
    //update called when it was just used, so should move to head
    public void update(Node node){
        //remove node from list
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        //add node at head
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    class Node{
        public int key;
        public int value;
        public Node prev;
        public Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = new Node();
            this.next = new Node();
        }
        
        public Node(){
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */