/*
1.0. Максимальное, минимальное и среднее значение

Задача:

Заполните массив случайным числами и выведите максимальное, минимальное и среднее значение.

Для генерации случайного числа используйте метод Math.random(), который возвращает значение в промежутке [0, 1].
*/

import java.util.Scanner;

class t0 {
	static double[] read_arr() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int size = in.nextInt();
		return new double[size];
	}
	static void init_arr(double[] arr) {
		for (int i = 0; i < arr.length; ++i)
			arr[i] = Math.random();
	}
	static void print_arr(double[] arr) {
		for (double x: arr) System.out.printf("%.6f\n", x);
		System.out.println();
	}
	static double find_min(double[] arr) {
		double min = arr[0];
		for (double x: arr) min = (x < min) ? x : min;
		return min;
	}
	static double find_max(double[] arr) {
		double max = arr[0];
		for (double x: arr) max = (x > max) ? x : max;
		return max;
	}
	static double find_avg(double[] arr) {
		double avg = 0;
		for (double x: arr) avg += x;
		return avg / arr.length;
	}

	static void print_statistics(double[] arr) {
		System.out.printf("Minimum: %.6f\n", find_min(arr));
		System.out.printf("Maximum: %.6f\n", find_max(arr));
		System.out.printf("Average: %.6f\n", find_avg(arr));
	}

	public static void main(String[] args) {
		double[] arr = read_arr();	
		init_arr(arr);
		System.out.println("Generated array:");
		print_arr(arr);
		print_statistics(arr);
	}
}
