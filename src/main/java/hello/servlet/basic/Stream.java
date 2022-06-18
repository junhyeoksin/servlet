package hello.servlet.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Stream {
    
    
    
    public static void main(String[] args) {
        // 중복되는 데이터를 제거
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 1, 5, 5, 5);
        System.out.println("list = " + list);


        list.stream().distinct().forEach(System.out::print);




    }
}
