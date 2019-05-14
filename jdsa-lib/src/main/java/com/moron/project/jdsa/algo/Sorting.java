package com.moron.project.jdsa.algo;

public class Sorting
{
    public static <T> void swap(T data[], int x, int y)
    {
	T tmp = data[x];
	data[x] = data[y];
	data[y] = tmp;
    }

    public static class Basic
    {
	/**
	 * <p>
	 * The idea is to insert an element into a sorted array, doing so creates a new
	 * sorted array for the same operation to be repeated on.
	 * 
	 * @param data the target array that will sort
	 */
	public static <T extends Comparable<T>> void insertionSort(T data[])
	{
	    for (int i = 1; i < data.length; i++)
	    {
		T tmp = data[i];
		int j;

		for (j = i; j > 0 && (tmp.compareTo(data[j - 1]) < 0); j--)
		{
		    data[j] = data[j - 1];
		}

		data[j] = tmp;
	    }
	}

	/**
	 * <p>
	 * The idea is to find the smallest element and put it at the top of the array.
	 * The same operation is applied to the second, third,... smallest elements.
	 * 
	 * @param data
	 */
	public static <T extends Comparable<T>> void selectionSort(T data[])
	{
	    for (int i = 0; i < data.length - 1; i++)
	    {
		int ind_min = i;

		for (int j = i + 1; j < data.length; j++)
		{
		    if (data[j].compareTo(data[ind_min]) < 0)
		    {
			ind_min = j;
		    }
		}

		if (ind_min != i)
		{
		    swap(data, i, ind_min);
		}
	    }
	}

	/**
	 * <p>
	 * Starting from the bottom, compare 2 adjacent element and swap them if the
	 * under is smaller, continue with the next pare until the smallest element
	 * bubbles to the top. Repeats the operation on the second, third,.. smallest
	 * elements.
	 * 
	 * @param data
	 */
	public static <T extends Comparable<T>> void bubbleSort(T data[])
	{
	    for (int i = 0; i < data.length - 1; i++)
	    {
		for (int j = data.length - 1; j > i; j--)
		{
		    if (data[j].compareTo(data[j - 1]) < 0)
		    {
			swap(data, j, j - 1);
		    }
		}
	    }
	}
    }

    public static class Advance
    {
	/**
	 * This function will call the actual operation function of quicksort.
	 * 
	 * @param data
	 */
	public static <T extends Comparable<T>> void quickSort(T data[])
	{
	    quickSort(data, 0, data.length - 1);
	}

	/**
	 * <p>
	 * Choose the pivot value (the middle element in this case), split the array
	 * into 2 part, the left contains elements with value < pivot, the right contain
	 * > pivot.
	 * 
	 * <p>
	 * The condition (i <= j), the equal check is for dealing with array of 2
	 * element, prevent infinite loop.
	 * 
	 * @param data
	 * @param left
	 * @param right
	 */
	private static <T extends Comparable<T>> void quickSort(T data[], int left, int right)
	{
	    int i = left;
	    int j = right;
	    T pivot = data[(left + right) / 2];

	    while (i < j)
	    {
		while (pivot.compareTo(data[i]) > 0)
		{
		    i++;
		}

		while (pivot.compareTo(data[j]) < 0)
		{
		    j--;
		}

		if (i <= j)
		{
		    swap(data, i, j);
		    i++;
		    j--;
		}
	    }

	    if (left < j)
	    {
		quickSort(data, left, i);
	    }
	    if (i < right)
	    {
		quickSort(data, i, right);
	    }
	}
    }
}
