/*
Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.
*/
class t2 {
	static void sieve_arr(int[] arr, int num) {
		for (int i = num * 2; i < arr.length; i += num)
			arr[i] = -1;
	}

	public static void main(String[] args) {
		int size = 100;
		int[] arr = new int[size + 1];
		arr[0] = arr[1] = -1;
		for (int i = 2; i < arr.length; ++i) {
			if (arr[i] == 0) {
				System.out.printf("Prime: %d\n", i);
				sieve_arr(arr, i);
			}
		}
	}
}
