/*
 * Copyright (c) 2018. JeongHa, Cho
 */

package personal.cjh.java.eight.streamapi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by cho_jeong_ha on 2018-03-25 오후 12:02
 * Blog : https://jungha-cho.github.io/
 * Github : https://github.com/JungHa-Cho
 * Email : ppzxc8487@gmail.com
 */
public class StreamApi {

  public void arrayIntOfBuildingStreams() {
    Stream<Integer> number = Stream.of(1, 2, 3, 4);

    int[] numbers = {1, 2, 3, 4};
    IntStream numbersArray = Arrays.stream(numbers);
  }

  public void fileStream() throws IOException {
    // File Stream
    long numberOfLines = Files.lines(Paths.get("MyFile.txt"), Charset.forName("UTF-8")).count();
  }

  public void infiniteStream() {
    // Infinite Streams
    // iterate 반복자, limit generate 생성자
    Stream<Integer> infiniteNumbers = Stream.iterate(0, n -> n + 10);
    infiniteNumbers.limit(5).forEach(System.out::println);
  }

  public void numericStream() {
    List<Integer> transaction = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      transaction.add(i);
    }

    /*transaction.stream()
            .mapToInt(Transaction::getValue)
            .sum();*/

    /*transaction.stream()
            .mapToInt(Transaction::getValue)
            .Int*/
  }

  public void filteringStream() {
    List<String> transactions = Arrays.asList("하나", "둘", "세엣", "네에엣", "다서어어엇", "여섯", "일고오오옵", "여덟입니다", "오호오오옵아홉", "열");

    long count = transactions.stream().filter(w -> w.length() > 2).count();
    long pCount = transactions.parallelStream().filter(w -> w.length() > 3).count();
    long distinctCount = transactions.stream().distinct().count();
    long limitCount = transactions.stream().limit(5).count();
    long skipCount = transactions.stream().skip(3).count();
  }

  public void mappingStream() {
    // Mapping
    List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
    List<Integer> wordLength = words.stream()
            .map(String::length) // map(e -> e * 2), map(s -> s.toUpperCase())
            .collect(Collectors.toList());
  }

  public void findingAndMatching() {
    List<String> transactions = Arrays.asList("하나", "둘", "세엣", "네에엣", "다서어어엇", "여섯", "일고오오옵", "여덟입니다", "오호오오옵아홉", "열");
    List<Integer> transaction = Arrays.asList(1, 2, 34, 56, 7, 123, 41, 6, 12535, 123159);
    int[] numbers = {1, 2, 34, 56, 7, 123, 41, 6, 12535, 123159};

    boolean expensive = transaction.stream()
            //.noneMatch(t -> t > 100)
            //.anyMatch(t -> t > 100)
            .allMatch(t -> t > 100);

    //transaction.stream().filter(t -> t == Transaction.)

    // Finding and Matching
    //boolean expensive = Arrays.stream(transaction).allMatch(t -> t.getValue() > 100);
  }

  public void reducing() {
    int[] numbers = {1, 2, 34, 56, 7, 123, 41, 6, 12535, 123159};

    // ex 1
    int sum = 0;
    for (int x : numbers) {
      sum += x;
    }

    // ex2
    int sum2 = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);

    // ex3
    int product = Arrays.stream(numbers).reduce(1, (a, b) -> a * b);

    // ex4
    int product2 = Arrays.stream(numbers).reduce(1, Integer::max);
  }

  public class Person {
    Person(String name) {
      this.name = name;
    }
    String name;
  }
  public void collect() {
    List<Person> transactions = Arrays
            .asList(new Person("홍길동"), new Person("이하늬"), new Person("이명박"));

    List<Person> filtered = transactions
            .stream()
            .filter(p -> p.name.startsWith("이"))
            .collect(Collectors.toList()); // Collectors.toSet()
    System.out.println(filtered);
  }
}
