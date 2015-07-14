/**
 *Question
 *Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *push(x) -- Push element x onto stack.
 *pop() -- Removes the element on top of the stack.
 *top() -- Get the top element.
 *getMin() -- Retrieve the minimum element in the stack.
**/

//Solution
class MinStack {
    
  private static final int INIT_CAPACITY = 100;
  private static final float FACTOR = 0.75f;
  
  private int[] elementStack = null;
  private int[] minStack = null;
  private int index = 0;
  private int min = Integer.MAX_VALUE;
  public MinStack() {
    elementStack = new int[INIT_CAPACITY];
    minStack = new int[INIT_CAPACITY];
  }
  
  public MinStack(int capacity) {
    if(capacity < 1 || capacity > (Integer.MAX_VALUE - 8)) {
      throw new IllegalArgumentException("illegal capacity value: " + capacity);
    }
    elementStack = new int[capacity];
    minStack = new int[capacity];
  }
  
  public void push(int x) {
    if(index > (Integer.MAX_VALUE - 8)) {
      throw new RuntimeException("no more space to store value");
    }
    if(index > 0 && (index + 1) >= elementStack.length) {
      int newSize = (int)(index + index*FACTOR);
      if(newSize > (Integer.MAX_VALUE - 8)) {
        throw new RuntimeException("no more space to store value");
      }
      int[] eleTemp = new int[newSize];
      int[] minTemp = new int[newSize];
      for(int i = 0; i < index; i++) {
        eleTemp[i] = elementStack[i];
        minTemp[i] = minStack[i];
      }
      elementStack = eleTemp;
      minStack = minTemp;
    }
    if(x < min) {
      min = x;
    }
        elementStack[index] = x;
        minStack[index] = min;
        index++;
    }

    public void pop() {
    	if(index > 0) {
    		index--;
    		if(index > 0)
    			min = minStack[index-1];
    	}
    	if(index == 0)
    		min = Integer.MAX_VALUE;
    }

    public int top() {
    	if(index > 0)
    		return elementStack[index-1];
    	return 0;
    }

    public int getMin() {
    	if(index > 0)
    		return min;
    	return 0;
    }
}
