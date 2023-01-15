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

class Result4 {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {    	
    	int[] frequency = new int[201]; 
        IntStream.range(0, d).forEach(i->frequency[expenditure.get(i)]++ );
    
        int[] medianArray = new int[d];
        int size = medianArray.length;
        
      return (int)IntStream.range(d,expenditure.size()).filter(start->{
            int pointer=0;
            for(int i=0;i<201;i++) {
                int j = frequency[i];
                while(j>0) {
                    medianArray[pointer++] = i;
                    j--;
                }
            }
            
            int currentDayExpenditure = expenditure.get(start);
            double medianExpenditure = size%2==0?((medianArray[size/2]) + (medianArray[size/2 -1])) / 2.0:medianArray[size/2];;
            
            frequency[expenditure.get(start-d)]--;
            frequency[expenditure.get(start)]++;
            
            return (currentDayExpenditure >= 2*medianExpenditure);
        }).count();    
      }
}

public class FraudlentActivityNotification {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result4 = Result4.activityNotifications(expenditure, d);
        System.out.println("result  :"+result4);
  //      bufferedWriter.write(String.valueOf(result));
  //      bufferedWriter.newLine();

        bufferedReader.close();
   //     bufferedWriter.close();
    }
}
