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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Result {
    final static int limit = 256;
    static int error=0;
    public static int max_char(String str, int n) { 
        int count[] = new int[limit]; 
        for (int i = 0; i < n; i++) { 
            count[str.charAt(i)]++; 
        } 
        int max_distinct = 0; 
        for (int i = 0; i < limit; i++) { 
            if (count[i] != 0) { 
                max_distinct++; 
            } 
        } 
        return max_distinct; 
    } 
    public static int shortestSubstring(String s) {
    int n=s.length();
    int max = max_char(s, n);
    int minl=n;
    for (int i = 0; i <=  n; i++) { 
            for (int j = 0; j <= n; j++) { 
                String substr = null; 
                if(i<j) 
                    substr = s.substring(i, j); 
                else
                    substr = s.substring(j, i); 
                int subs_lenght = substr.length(); 
                int sub_distinct_char = max_char(substr, subs_lenght); 
                if (subs_lenght < minl && max == sub_distinct_char) { 
                    minl = subs_lenght;
                } 
            } 
        } 
        return minl; 
    } 

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String");
        String s = in.next();
        int len_str = s.length();
        for(int i = 0;i<len_str;i++)
        {
            char res = s.charAt(i);
            if(Character.isDigit(res))
            {
                error =1;
            }
               
        }
         if(error == 0)
         {
             int len_substr = shortestSubstring(s);
             System.out.println("The shortest substring length is: "+len_substr);
         }
        else
         {
             System.out.println("String Contains number");
         }
         in.close();
    }
}
