package com.mjc.stage2;

import com.mjc.stage2.impl.ManufactureFilteringStrategy;
import com.mjc.stage2.impl.MaxPriceFilteringStrategy;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class ShopStock {
    private final List<Product> productList;

    public ShopStock(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> executeFilteringStrategy(FilteringStrategy filteringStrategy){
        return productList.stream()
                .filter(p -> filteringStrategy.filter(p))
                .collect(Collectors.toList());
    }

//    public static void main(String[] args) {
//        Product p1 = new Product("A", 2.2, "M1");
//        Product p2 = new Product("B", 3.3, "M1");
//        Product p3 = new Product("C", 5.5, "c1");
//
//        ShopStock s = new ShopStock(List.of(p1,p2,p3));
//
//        System.out.println(s.executeFilteringStrategy(new MaxPriceFilteringStrategy(5.4d)));
//
//    }

}
