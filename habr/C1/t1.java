//1.1. Реализуйте алгоритм сортировки пузырьком для сортировки массива


class t1 {
	static int get_int(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}
	static int[] init_arr() {
		final int MIN_SIZE = 1;
		final int MAX_SIZE = 20;
		final int MIN_ELEM = -50;
		final int MAX_ELEM = 50;
		int size = get_int(MIN_SIZE, MAX_SIZE);
		int[] arr = new int[size];
		for (int i = 0; i < arr.length; ++i)
			arr[i] = get_int(MIN_ELEM, MAX_ELEM);
		return arr;
	}
	static void print_arr(int[] arr) {
		for (int x: arr) System.out.print(x + " ");
		System.out.println();
	}
	static int swap(int a, int b) {
		return a;
	}
	static void bubble_sort(int[] arr) {
		boolean flag;
		for (int j = 1; j < arr.length; ++j) {
			flag = false;
			for (int i = 0; i < arr.length - j; ++i) {
				if (arr[i] > arr[i + 1]) {
					arr[i + 1] = swap(arr[i], arr[i] = arr[i + 1]);
					flag = true;
				}
			}
			if (!flag) break;
		}
	}

	public static void main(String[] args) {
		int[] arr = init_arr();
		print_arr(arr);
		bubble_sort(arr);
		print_arr(arr);
		int[] a = { 1, 2, 3, 4, 5 };
		print_arr(a);
		bubble_sort(a);
		print_arr(a);
	}
}
