package com.in28minutes.rest.webservices.restfulwebservices.functionalprogramming;

import java.util.List;

public class FP01Exercises {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

    System.out.println("Exercise 1");
    printOddNumbersInListFunctional(numbers);

    List<String> courses =
        List.of(
            "Spring",
            "Spring Boot",
            "API",
            "Microservices",
            "AWS",
            "PCF",
            "Azure",
            "Docker",
            "Kubernetes");
    System.out.println("\nExercise 2");
    courses.forEach(System.out::println);

    System.out.println("\nExercise 3");
    courses.stream().filter(p -> p.contains("Spring")).forEach(System.out::println);

    System.out.println("\nExercise 4");
    courses.stream().filter(p -> p.length() >= 4).forEach(System.out::println);

    System.out.println("\nExercise 5");
    printCubesOfOddNumbersInListFunctional(numbers);

    System.out.println("\nExercise 6");
    courses.stream().map(course -> course + " " + course.length()).forEach(System.out::println);
  }

  private static void printOddNumbersInListFunctional(List<Integer> numbers) {
    numbers.stream().filter(p -> p % 2 != 0).forEach(System.out::println);
  }

  private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
    numbers.stream().filter(p -> p % 2 != 0).map(n -> n * n * n).forEach(System.out::println);
  }
}
