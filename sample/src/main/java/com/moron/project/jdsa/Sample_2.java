package com.moron.project.jdsa;

import com.moron.project.jdsa.algo.Sorting;

public class Sample_2 {

	private static <T> void printArr(T data[]) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < data.length; i++) {
			sb.append(data[i] + " ");
		}

		System.out.println(sb);
	}

	public static void main(String[] args) {
		Integer data[] = { 5, 1, 7, 3, 9, 3 };

		printArr(data);
//	Sorting.Basic.insertionSort(data);
//	Sorting.Basic.selectionSort(data);
		Sorting.Basic.bubbleSort(data);
		printArr(data);
	}
}
