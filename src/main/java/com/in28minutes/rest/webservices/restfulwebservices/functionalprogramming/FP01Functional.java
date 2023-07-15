package com.in28minutes.rest.webservices.restfulwebservices.functionalprogramming;

import java.util.List;

public class FP01Functional {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

    //    printAllNumbersInListFunctional(numbers);
//    printEvenNumbersInListFunctional(numbers);
    printSquaresOfEvenNumbersInListFunctional(numbers);
  }

  private static void printAllNumbersInListFunctional(List<Integer> numbers) {
    numbers.forEach(System.out::println);
  }

  private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
    numbers.stream().filter(p -> p % 2 == 0).forEach(System.out::println);
  }

  private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
    numbers.stream().filter(p -> p % 2 == 0).map(n -> n * n).forEach(System.out::println);
  }
}
