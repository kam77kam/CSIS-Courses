/*
Author: Kamdon Bird
Date: 11/3/2018
Assignment A08 - Pattern
*/
package a08;

//Creating Class of Pattern
public class Pattern{
/****************Creating 4 different pattern methods to later be called*******************/
   //Created nested 'for loops' for pattern1
   public static void pattern1(int size){
      //Created first loop for amount of rows (dependent on user input)
      for(int i = 0; i < size; i++){
         //pattern1 created
         for(int j = 0; j < 1; j++){
            System.out.print("o");
         }
         for(int k = size; k > 1 + i; k--){
            System.out.print(" ");
         }
         for(int l = 2; l > 1; l--){
            System.out.print("//");
         }
         for(int m = 1; m < 1+i; m++){
            System.out.print("  ");  
         }
         for(int n = 2; n > 1; n--){
            System.out.print("\\"+"\\");
         }
         for(int n = 2; n > 1; n--){
            System.out.print(".");
         }
         System.out.println();
      }
   }
   //Created nested 'for loops' for pattern2
   public static void pattern2(int size){
      //Created first loop for amount of rows (dependent on user input)
      for(int i = 0; i < size; i++){
         //pattern2 created
         for(int k = size; k > 1 + i; k--){
            System.out.print(" ");
         }
         for(int n = 2; n > 1; n--){
            System.out.print(".//");
         }
         for(int j = 1; j < 1+i; j++){
            System.out.print("  ");
         }
         for(int l = 2; l > 1; l--){
            System.out.print("\\"+"\\");
         }
         for(int m = size; m > 1+i; m--){
            System.out.print(" ");  
         }
         for(int n = 0; n < 1; n++){
            System.out.print("o");
         }
         System.out.println();
      }
   }
   //Created nested 'for loops' for pattern3
   public static void pattern3(int size){
      //Created first loop for amount of rows (dependent on user input)
      for(int i = 0; i < size; i++){
         //pattern3 created
         for(int j = 0; j < 1; j++){
            System.out.print("o");
         }
         for(int k = 1; k < 1 + i; k++){
            System.out.print(" ");
         }
         for(int l = 2; l > 1; l--){
            System.out.print("\\"+"\\");
         }
         for(int m = 1; m < size - i; m++){
            System.out.print("  ");  
         }
         for(int n = 2; n > 1; n--){
            System.out.print("//");
         }
         for(int n = 2; n > 1; n--){
            System.out.print(".");
         }
         System.out.println();
      }
   }
   //Created nested 'for loops' for pattern4
   public static void pattern4(int size){
      //Created first loop for amount of rows (dependent on user input)
      for(int i = 0; i < size; i++){
         //pattern4 created
         for(int k = 1; k < 1 + i; k++){
            System.out.print(" ");
         }
         for(int l = 2; l > 1; l--){
            System.out.print(".\\"+"\\");
         }
         for(int m = 1; m < size - i; m++){
            System.out.print("  ");  
         }
         for(int n = 2; n > 1; n--){
            System.out.print("//");
         }
         for(int m = size; m > size-i; m--){
            System.out.print(" ");  
         }
         for(int n = 0; n < 1; n++){
            System.out.print("o");
         }
         System.out.println();
      }
   }
}