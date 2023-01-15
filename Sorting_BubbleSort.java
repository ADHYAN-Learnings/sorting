package org.adhyan.hackerrank.sorting;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
    	    	
    int count =	IntStream.range(0, a.size()).map(i->{
    	return	(int) IntStream.range(0, a.size()-1).filter(j->a.get(j)>a.get(j+1)).peek(j->{
    			int temp = a.get(j+1);
    			a.set(j+1, a.get(j));
				a.set(j, temp);
    		}).count(); 
    	}).sum();
    System.out.println("Array is sorted in "+count+" swaps.");
	System.out.println("First Element: "+a.get(0));
	System.out.println("Last Element: "+a.get(a.size()-1)); 
    }

}

public class Sorting_BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.countSwaps(a);

        bufferedReader.close();
    }
}

