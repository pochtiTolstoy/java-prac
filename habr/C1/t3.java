//Дан массив целых чисел и ещё одно целое число. 
//Удалите все вхождения этого числа из массива (пропусков быть не должно).

import java.util.Arrays;

class t3 {
	public static void mod_arr(int[] arr) {
		arr[0] = 10; // will change outside array
		arr = new int[10]; // will act like local reference
		for (int i = 0; i < 10; ++i) {
			arr[i] = 10 + i;
		}
		print_arr(arr);
	}
	public static int[] remove_elems(int[] arr, int key) {
		int offset = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] == key) {
				++offset;
			} else {
				arr[i - offset] = arr[i];
			}
		}
		int[] temp = new int[arr.length - offset];
		for (int i = 0; i < arr.length - offset; ++i)
			temp[i] = arr[i];
		return temp;
		//return Arrays.copyOf(arr, arr.length - offset);
	}
	public static void print_arr(int[] arr) {
		for (int x: arr) System.out.print(x + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 3, 4, 5, 3, 6 };
		print_arr(arr);
		arr = remove_elems(arr, 3);
		print_arr(arr);
		//System.out.println(Arrays.toString(remove_elems(arr, 3)));
	}
}
