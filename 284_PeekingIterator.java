// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer next;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        this.next = null;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(next == null)
            next = iterator.next();
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(next != null){
            int val = next;
            next = null;
            return val;
        }
        return iterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    if(next != null || iterator.hasNext())
            return true;
        return false;
	}
}