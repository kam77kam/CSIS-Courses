package demo;

import java.util.ArrayList;
import java.util.Arrays;

public class DemoArrayList{
   public static void main(String[] args){
      ArrayList<String> colors = new ArrayList<String>();
      colors.add("red");
      colors.add("blue");
      colors.add("yellow");
      colors.add("green");
      
      System.out.println(colors);
      
      colors.remove("blue");
      
      System.out.println(colors);
      
      System.out.println("index of green: "+colors.indexOf("green"));
      
      System.out.println("contains red: "+colors.contains("red"));
      
      System.out.println("Index '0': "+colors.get(0));
      
      System.out.println("Number of elements: "+colors.size());
      
      for(String el:colors)
         System.out.print(el + " ");
         
         
      //:PART 2
      String[] colors2 = {"red","yellow","blue"};
      
      System.out.println("\n"+Arrays.toString(colors2));
      
      colors.set(0,"pink");
      
      System.out.println(colors);
      
      
      System.out.println("Last color of colors: "+colors.get(colors.size() -1));
      
      System.out.println("Last color of colors2: "+colors2[colors2.length-1]);
      
      System.out.println("Colors: "+colors);
      
      System.out.println("Colors2: "+Arrays.toString(colors2));
      
      colors2[0]=colors.get(colors.size() -1);
      System.out.println("Colors2: "+Arrays.toString(colors2));
      
      colors.set(0, colors2[colors2.length-1]);
      
      System.out.println("Colors: "+colors);
      
      for(String el:colors)
         System.out.print(el+", ");
   }
}