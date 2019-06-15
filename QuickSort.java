package luke;

public class QuickSort {
	private static void quickSort(int[] S,int L, int G) {
		if (L < G) {
			//create partitions
			int index= partition(S,L,G);
			//sort the left partition min values
			quickSort(S,L,index -1);
			//sort the right max values
			quickSort(S,index +1,G);
		}
	}
	private static int partition(int[] S, int min, int max) {
		int pivot,L,G;
		int mid =(min+max)/2;
		//use the mid as the position 
		pivot = S[mid];
		swap(S,mid,min);
		L= min;
		G= max;
		while(L < G) {
			while (S[L] < pivot) 
				L++;
			while(S[G]>pivot)
				G--;
			if(L < G)
				swap(S,L,G);
		}
		swap(S,L,G);
		return G;
	}
	private static void swap(int[] S, int L, int G) {
		int temp = S[L];
		S[L] = S[G];
		S[G] = temp;
		
	}
	
	//main test method
	public static void main(String[] args ) {
		int[] list = {1,5,6,8,9,10};
		quickSort(list,0,list.length-1);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}
}
