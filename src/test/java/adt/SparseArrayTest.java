package adt;

import org.junit.Test;

/**
 * Created by xiaoliangl on 5/3/16.
 */
public class SparseArrayTest {
   @Test
   public void test() {
      SparseArray<String> array = new SparseArray<>(10);

      for(int i = 0; i < 100; i ++) {
         array.set(i, "s" + i);
         array.debug();
      }

      for(int i = 0; i < 100; i ++) {
         array.set(i, null);
         array.debug();
      }
   }
}
