/***************************************************************************
 * Copyright (c) 2016 VMware, Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************/
package adt;

import java.util.Arrays;
import java.util.logging.Logger;


/**
 * Created by xiaoliangl on 5/3/16.
 */
public class SparseArray<T>{
   private final static Logger LOGGER = Logger.getLogger("SparseArray");

   private int[] keys;
   private Object[] values;
   private int valueCount = 0;

   public SparseArray(int initialCapacity) {
      if(initialCapacity < 0) {
         throw new IllegalArgumentException();
      }

      keys = new int[initialCapacity];
      Arrays.fill(keys, -1);
      values = new Object[initialCapacity];
      Arrays.fill(values, null);
   }

   public int getActualLength() {
      return keys.length;
   }

   public int getValueCount() {
      return valueCount;
   }

   public boolean isEmpty() {
      return getValueCount() > 0;
   }

   public boolean contains(T o) {
      return keyOf(o) != -1;
   }

   public T get(int key) {
      int index = search(keys, key);

      if(index != -1) {
         return (T) values[index];
      }
      return null;
   }

   public void set(int key, T element) {
      int index = search(keys, key);

      if(index != -1) {
         if (element == null) {
            keys[index] = -1;
            values[index] = null;
            valueCount--;

            shrinkIfNeeded();
         } else {
            values[index] = element;
         }
      } else {
         if(element != null) {
            enlargeIfNeeded();
            index = search(keys, -1);
            keys[index] = key;
            values[index] = element;
            valueCount++;
         }
      }
   }

   private void shrinkIfNeeded() {
      int ratio = (int) (valueCount * (1 + 0.2));
      if(ratio < values.length) {
         int[] newKeys = new int[ratio];

         Object[] newVals = new Object[ratio];

         int i = 0, j = 0;
         for(; i < keys.length; i ++) {
            if(keys[i] != -1) {
               newKeys[j] = keys[i];
               newVals[j] = values[i];
               j ++;
            }
         }

         for(; j < newKeys.length; j ++) {
            newKeys[j] = -1;
         }

         keys = newKeys;
         values = newVals;
      }
   }

   protected boolean enlargeIfNeeded() {
      if(values.length == valueCount) {
         int newLen = (int)(values.length * (1 + 0.2));
         int[] newKeys = new int[newLen];
         Arrays.fill(newKeys, -1);
         System.arraycopy(keys, 0, newKeys, 0, keys.length);
         keys = newKeys;
         Object[] newVals = new Object[newLen];
         System.arraycopy(values, 0, newVals, 0, values.length);
         values = newVals;

         return true;
      }

      return false;
   }


   public int keyOf(T o) {
      if(isEmpty()) {
         return -1;
      } else {
         for(int i = 0; i < keys.length; i ++) {
            int key = keys[i];
            if(key != -1) {
               T value = (T) values[i];
               if(o.equals(value)) {
                  return key;
               }
            }
         }

         return -1;
      }
   }


   public String toString() {
      StringBuilder sb = new StringBuilder();
      return sb.append(Arrays.toString(keys)).append('\n').append(Arrays.toString(values)).toString();
   }

   public void debug() {
      System.out.println(toString());
   }

   public static int search(int[] array, int value) {
      for(int i = 0; i < array.length; i ++) {
         if(array[i] == (value)) {
            return i;
         }
      }

      return -1;
   }

}
