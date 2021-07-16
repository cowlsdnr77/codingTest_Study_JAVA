package Java_Grammar.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Sale {
    String fruitName;
    int price;
    float discount;

    public Sale(String fruitName, int price, float discount) {
        this.fruitName = fruitName;
        this.price = price;
        this.discount = discount;
    }
}

public class Sparta_Main03 {
    public static void main(String[] args) {
        List<Sale> saleList = Arrays.asList(
                new Sale("Apple", 5000, 0.05f),
                new Sale("Grape", 3000, 0.1f),
                new Sale("Orange", 4000, 0.2f),
                new Sale("Tangerine", 2000, 0)
        );

        Stream<Sale> saleStream = saleList.stream();
        // 원래 build.gradle에 추가하면되는데 난 안함
        // implementation 'org.apache.commons:commons-lang3:3.0'
        // Pair라는 map과 비슷한 형태가 있음
//        saleStream.map(sale -> Pair.of(sale.fruitName, sale.price * (1 - sale.discount)))
//                .forEach(pair -> System.out.println(pair.getLeft() + " 실 구매가:  " + pair.getRight() + "원 "));

    }
}
