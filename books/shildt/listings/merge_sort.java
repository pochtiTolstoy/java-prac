class merge_sort {
	public static void main(String[] args) {
		int arr[] = { -10, 1, 0, 2, 10, 100, -1, 90, 20, 30, 70, 60 };
		print_arr(arr, arr.length);	
		sort(arr, 0, arr.length - 1);
		print_arr(arr, arr.length);	
	}
	public static void sort(int arr[], int l, int r) {
		if  (l < r) {
			int m = l + (r - l) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
	public static void merge(int arr[], int l, int m, int r) {
		int i = l;
		int j = m + 1;
		int k = 0;
		int size = r - l + 1;
		int temp[] = new int[size];
		while (i <= m && j <= r) 
			temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
		while (i <= m) temp[k++] = arr[i++];
		while (j <= r) temp[k++] = arr[j++];
		for (int ii = 0; ii < size; ++ii)
			arr[l + ii] = temp[ii];
	}
	public static void print_arr(int arr[], int size) {
		for (int i = 0; i < size; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
