package rxjava.lambda;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaPractice {

    public static enum EnumTest {
        F1,  F2;
    }

    public static void main(String[] args) {
        String[][] strs = {{"A", "1"}, {"B", "2"}};
        Map<String, String> stringMap = Stream.of(strs)
                .collect(Collectors.toMap((str -> str[0]), (str -> str[1]), (a, b) -> a+b));

        stringMap.forEach((key, value) -> System.out.println(key + " " + value));


        System.out.println(EnumTest.valueOf("F1"));


        String[] str = {"1", "2"};

    }
}
