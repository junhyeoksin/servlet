package hello.servlet.basic;

import java.util.Arrays;
import java.util.stream.Stream;

public class java {
    public static void main(String[] args) {
            String [] numbers = new String[]{"1","2","3"};
            System.out.println("numbers = " + numbers[0]);
            System.out.println("numbers = " + numbers[1]);
            System.out.println("numbers = " + numbers[2]);

            for(String num : numbers){
                System.out.println("num =" +  num);
            }
        Stream<String> num = Arrays.stream(numbers);
        System.out.println("stream num  = " + num);
        num.forEach(System.out::println);
    }
}
