package com.zoom.notifications.collection;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RomanConvertor
{
  private static HashMap<Integer, String> baseValue2RomanNumeral = new HashMap<Integer, String>();
  private final int[] baseValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

  private static void createBaseValueToRomanNumeralMap()
  {
    baseValue2RomanNumeral.put(1, "I");
    baseValue2RomanNumeral.put(4, "IV");
    baseValue2RomanNumeral.put(5, "V");
    baseValue2RomanNumeral.put(9, "IX");
    baseValue2RomanNumeral.put(10, "X");
    baseValue2RomanNumeral.put(40, "XL");
    baseValue2RomanNumeral.put(50, "L");
    baseValue2RomanNumeral.put(90, "XC");
    baseValue2RomanNumeral.put(100, "C");
    baseValue2RomanNumeral.put(400, "CD");
    baseValue2RomanNumeral.put(500, "D");
    baseValue2RomanNumeral.put(900, "CM");
    baseValue2RomanNumeral.put(1000, "M");
  }

  private String convertor(int number)
  {
    createBaseValueToRomanNumeralMap();
    String romanValue = "";
    for (int i : baseValues) {
      while (number >= i) {
        romanValue += baseValue2RomanNumeral.get(i);
        number = number - i;
      }
    }
    return romanValue;
  }

  public static void main(String arg[]) {
    RomanConvertor romanConvertor = new RomanConvertor();
    romanConvertor.getRomanNumeral();
  }

  private void getRomanNumeral(){
    for (int i = 0; ; i++) {
      int no = getNumber();
      if(no > 0){
        System.out.println(convertor(no));
      }
      String approvalForNext = getApprovalForNext();
      if(!approvalForNext.equalsIgnoreCase("Y")){ //ASSUMPTION - everything except Y is N
        break;
      }
    }
  }

  private int getNumber(){
    System.out.println("Enter number to convert : ");
    Scanner sc = new Scanner(System.in);
    try {
      return sc.nextInt();
    }
    catch (InputMismatchException inputMismatchException){
      System.out.println("Input mismatched.");
    }
    return -1;
  }

  private String getApprovalForNext(){
    System.out.println("Want to do it again ? Y/N");
    Scanner sc = new Scanner(System.in);
    return sc.nextLine();
  }

}