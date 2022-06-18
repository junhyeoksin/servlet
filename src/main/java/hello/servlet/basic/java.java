package hello.servlet.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class java {
    public static void main(String[] args) {
            String [] numbers = new String[]{"1","2","3"};

            for(String num : numbers){
                System.out.println("num =" +  num);
            }

            Stream<String> stream = Arrays.stream(numbers);
            stream.forEach(System.out::println);




    }
}
