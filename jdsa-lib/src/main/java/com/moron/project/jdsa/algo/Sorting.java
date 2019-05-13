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
	 * <p>The idea is to insert an element into a sorted array,
	 * doing so creates a new sorted array for the same operation 
	 * to be repeated on.
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
	 * <p>The idea is to find the smallest element and put it 
	 * at the top of the array. The same operation is applied to 
	 * the second, third,... smallest elements.
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
	 * Starting from the bottom, compare 2 adjacent element and 
	 * swap them if the under is smaller, continue with the next pare 
	 * until the smallest element bubbles to the top. Repeats the operation 
	 * on the second, third,.. smallest elements.
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
}
