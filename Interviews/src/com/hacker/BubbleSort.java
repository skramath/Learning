package com.hacker;

public class BubbleSort {
	
	/**
	 * https://www.youtube.com/watch?v=6Gv8vg0kcHc
	 */
	static int[] arr = {3,12,6,2,5,1};
	
	public static void main(String[] args) {
		boolean isSorted = false;
		int lastSorted = arr.length - 1;
		while(!isSorted){
			isSorted = true;
			for(int i=0;i < lastSorted;i++){
				if(arr[i] > arr[i+1]){
					swap(i,i+1);
					isSorted = false;
				}
			}
			print();
			System.out.println();
		}
		lastSorted --;
	}
	
	static void swap(int i, int j){
		int temp = arr[i];
		arr[i]   = arr[j];
		arr[j]   = temp;
		
	}
	
	static void print(){
		for(int k=0;k<arr.length;k++){
			System.out.print(arr[k]+",");
		}
	}

}
