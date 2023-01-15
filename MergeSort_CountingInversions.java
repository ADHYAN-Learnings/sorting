package org.adhyan.hackerrank.sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result5 {

    /*
     * Complete the 'countInversions' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long countInversions(List<Integer> arr) {
        int[] array_list = new int[arr.size()];
        
        for(int i=0;i<arr.size();i++) {
        	array_list[i] = arr.get(i);
        }
    	int length = arr.size();
    	long totalInversions = mergeSort(array_list,0,length-1);
    	
      return totalInversions;
    }

	private static long  mergeSort(int[] array_list, int beginning, int end) {
		long totalInversions = 0l; 
		if(beginning < end) {
			int middle = (beginning + end)/2;
			totalInversions += mergeSort(array_list,beginning,middle);
			totalInversions += mergeSort(array_list,middle+1,end);
			totalInversions += merge(array_list,beginning,middle,end);
		}
		return totalInversions;
	}

	private static long merge(int[] array_list, int beginning, int middle, int end) {
		long totalInversions = 0l;
		
		int n1 = middle - beginning + 1;
		int n2 = end - middle;
		
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];
		
		IntStream.range(0, n1).forEach(i->leftArray[i]=array_list[beginning+i]);
		IntStream.range(0, n2).forEach(j->rightArray[j]=array_list[middle+1+j]);
		
		int i=0;
		int j=0;
		int k=beginning;
		
		for(k=beginning;i<n1 && j<n2;k++) {
			if(leftArray[i]<=rightArray[j]) {
				array_list[k]=leftArray[i++];
			} else {
				array_list[k]=rightArray[j++];
				totalInversions +=n1-i;
			}
		}
	
		for(;i<n1;k++) {
			array_list[k]=leftArray[i++];
		}
		for(;i<n2;k++) {
			array_list[k]=leftArray[j++];
		}
		return totalInversions;
	}
}

public class MergeSort_CountingInversions {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                long result5 = Result5.countInversions(arr);
                System.out.println(result5);

//                bufferedWriter.write(String.valueOf(result));
 //               bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
 //       bufferedWriter.close();
    }
}

