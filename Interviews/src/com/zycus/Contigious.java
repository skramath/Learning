package com.zycus;

public class Contigious {
	
	public static void main(String[] args) {
		
		int arr[]={1,4,6,7,-1,3,4,-3,-5,3};
		checkContigency(arr);
	}
	
	public static void checkContigency(int[] arr){
		long maxConSum = Integer.MIN_VALUE;long maxNonConSum = Integer.MIN_VALUE;int previousSum=0;
		for(int x: arr){
			System.out.println(x);
			int currentSum = x;
			if(previousSum > 0){
				currentSum += previousSum;
			}
			previousSum = currentSum;
			
			if(currentSum > maxConSum){
				maxConSum = currentSum;
			}
			
			
			if(maxNonConSum < 0 && x > maxNonConSum){
				maxNonConSum = x;
			}else if(maxNonConSum > 0 && x > 0){
				maxConSum += x;
			}
			
		}
		System.out.println("MaxConSum -"+maxConSum);
		System.out.println("MaxNonConSum -"+maxNonConSum);
		
	}

}
