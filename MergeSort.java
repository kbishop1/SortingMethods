package luke;


public class MergeSort {
	public static void mergeSort(int[] list) {
		if (list.length > 1) {
			//sort the first half
			int[] halfOne = new int[list.length / 2];
			System.arraycopy(list, 0, halfOne, 0, list.length / 2);
			mergeSort(halfOne);//recursive call

			// Sort the second half
			int secondHalfLength = list.length - list.length / 2;
			int[] halfTwo = new int[secondHalfLength];
			System.arraycopy(list, list.length / 2,
					halfTwo, 0, secondHalfLength);
			mergeSort(halfTwo);//recursive call

			// call merge method to sort the two into list
			merge(halfOne, halfTwo, list);
		}
	}

	
	public static void merge(int[] halfOne, int[] halfTwo, int[] temp) {
		int index1 = 0, index2 = 0, index3 = 0; // Current index in halfone,halftwo, and temp
	
		while (index1 < halfOne.length && index2 < halfTwo.length) {
			if (halfOne[index1] < halfTwo[index2])
				temp[index3++] = halfOne[index1++];
			else
				temp[index3++] = halfTwo[index2++];
		}
		while (index1 < halfOne.length)
			temp[index3++] = halfOne[index1++];

		while (index2 < halfTwo.length)
			temp[index3++] = halfTwo[index2++];
	}

	
	public static void main(String[] args) {
		int[] list = {1,5,6,8,9,10};
		mergeSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}
}