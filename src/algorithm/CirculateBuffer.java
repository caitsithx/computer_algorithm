package algorithm;

import java.util.Arrays;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 *
 * 
 * @since RM 3.0.0
 */
public class CirculateBuffer {
   private int[] inner = null;
   private int dataStart = 0;
   private int count = 0;
   private int dataEnd = 0;

   public CirculateBuffer(int size) {
	inner = new int[size];
	Arrays.fill(inner, -1);
   }
   
   public final boolean isFull(){
	return count == inner.length;
   }
   
   public final boolean isEmpty(){
	return count == 0;
   }
   
   public final boolean enqueue(int item) {
	if(isFull()) {
	   return false;
	}
	
	inner[dataEnd] = item;
	count ++;
	dataEnd ++;
	
	if(dataEnd == inner.length) {
	   dataEnd = 0;
	}
	
	return true;
   }
   
   public final int dequeue() throws Exception {
	int item = -1;
	if(isEmpty()) {
	   throw new Exception();
	}
	
	item = inner[dataStart];
	inner[dataStart] = -1;
	dataStart ++;
	count --;
	
	if(dataStart == inner.length) {
	   dataStart = 0;
	}
	
	
	return item;
   }
   
   public String toString() {
	if(inner == null) {
	   return "";
	}
	
	return Arrays.toString(inner);
   }
   
   @SuppressWarnings("javadoc")
   public final static void main(String[] args) throws Exception {
	CirculateBuffer cb = new CirculateBuffer(4);
	
	int i=0;
	for(; i < 5; i ++) {
	   cb.enqueue(i);
	   System.err.println(cb);
	}
	
	System.err.println();
	
	for(; i > 2; i --) {
	   cb.dequeue();
	   System.err.println(cb);
	}
	
	System.err.println();
	
	int j=0;
	for(; j < 5; j ++) {
	   cb.enqueue(j);
	   System.err.println(cb);
	}
	
	System.err.println();
	
	for(; i > 0; i --) {
	   cb.dequeue();
	   System.err.println(cb);
	}
	
   }
}
