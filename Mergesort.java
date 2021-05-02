import java.util.*;
import java.io.*;

public class Mergesort
{
	// Wrapper function for mergesort.
	public static void merge(int [] array)
	{
		sort(0, array.length - 1, array);
	}

	public static void sort(int low, int hi, int [] array)
	{
		if (low >= hi)
		{
			return;
		}

		// Prevents integer overflow when dealing with large arrays.
		int mid = low + (hi - low) / 2;

		sort(low, mid, array);
		sort(mid + 1, hi, array);

		// Merging arrays together.
		int [] temp = new int [hi - low + 1];

		int i = low, j = mid + 1, k = 0;

		while (i <= mid || j <= hi)
		{
			if (j > hi)
			{
				temp[k] = array[i];
				k++;
				i++;
			}
			else if (i > mid)
			{
				temp[k] = array[j];
				k++;
				j++;
			}
			else if (array[i] < array[j])
			{
				temp[k] = array[i];
				k++;
				i++;
			}
			else
			{
				temp[k] = array[j];
				k++;
				j++;
			}
		}

		// Copying over result from temp to original array.
		for (i = low; i <= hi; i++)
		{
			array[i] = temp[i - low];
		}
	}

	public static void printArray(int [] array, int n)
	{
		for (int i = 0; i < n; i++)
		{
			System.out.print("[" + array[i] + "]");
			System.out.print((i == n - 1) ? "\n" : " ");
		}
	}

	public static void main(String [] args) throws IOException
	{
		Scanner in = new Scanner(new File("unsorted1.txt"));

		// Getting the number of elements in the array from text file.
		int n = in.nextInt();

		int [] array = new int[n];

		for (int i = 0; i < n; i++)
		{
			array[i] = in.nextInt();
		}

		System.out.println("Unsorted Array: ");

		printArray(array, n);

		merge(array);

		System.out.println("After Mergesort: ");

		printArray(array, n);
	}
}