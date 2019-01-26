/**************************************************************************
 *                                                                         *
 *     Program Filename:  Khan18B.java                                     *
 *     Author          :  Sarim Khan                                       *
 *     Date Written    :  November 19th, 2017                              *
 *     Purpose         :  To solve the egg drop problem                    *
 *     Input from      :  Keyboard                                         *
 *     Output to       :  Screen                                           *
 *                                                                         *
 **************************************************************************/
import java.util.Scanner;

public class Khan18B
{
   public static void main(String[] args) 
   {
      int eggs; 
      int floors; 
      int i, j, k, store;   
      
      Scanner scan = new Scanner(System.in); 
      
      System.out.println("Please enter the number of eggs"); 
      eggs = scan.nextInt(); 
      System.out.println("Please enter the number of floors"); 
      floors = scan.nextInt(); 
      
      int A[][] = new int[eggs+1][floors+1];
      
      for(i = 1; i<=eggs; i++)
      {
         A[i][1] = 1;
         A[i][0] = 0;  
      }   
      
      for(i = 1; i<=floors; i++)
      {
         A[1][i] = i;
      }  
      
      for (i=2; i<=eggs; i++)
      {
         for (j=2; j<=floors; j++)
         {
            A[i][j] = 200000000;  
            for (k=1; k<=j; k++)
            {
             store = 1+Max(A[i-1][k-1], A[i][j-k]); 
             if (store < A[i][j])
               A[i][j] = store; 
            }
         }
      }
      
      System.out.println(A[eggs][floors]); 
   }
   
   static int Max(int a, int b)
   {
      int x; 
      
      if (a > b)
      x = a; 
      else 
      x = b; 
      
      return x; 
   }
}
