package lab;

import java.util.ArrayList;
import java.util.List;

public class Generics {
   static List<Integer> list1 = new ArrayList<>();
   static List list2 = new ArrayList();
   public static void main(String[] args) {
      list2.add("string");
      list2.add(123);
      list2.add(12.3);
      
      String s = (String) list2.get(0);
      int i = (int) list2.get(1);
      double d = (double) list2.get(2);
      System.out.println(list2);
      System.out.println(s + i + d);
   }
}