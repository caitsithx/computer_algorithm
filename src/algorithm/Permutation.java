package algorithm;

/**
 * @author <a href="mailto:caitsithx@gmail.com">豆SHA冰棒 </a>
 * 
 * 
 * @since RM 3.0.0
 */
public class Permutation {
   public static void main(String[] args) {
	String[] arr02 = { "a", "b", "c", "d" };
	permutation(arr02, 0, arr02.length);
   }

   public static void permutation(Object[] arr, int start, int end) {
	if (start < end + 1) {
	   permutation(arr, start + 1, end);

	   for (int i = start + 1; i < end; i++) {
		Object temp;

		temp = arr[start];
		arr[start] = arr[i];
		arr[i] = temp;

		permutation(arr, start + 1, end);

		temp = arr[i];
		arr[i] = arr[start];
		arr[start] = temp;
	   }
	} else {
	   for (int i = 0; i < end; i++) {
		System.out.print(arr[i]);
	   }
	   System.out.print("\n");
	}
   }
}
