package com.example.searchadvisory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(ItemRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                String placeholder = "https://via.placeholder.com/60x60?text=物品";
                repo.save(new Item("苹果", "新鲜的红苹果", placeholder));
                repo.save(new Item("香蕉", "香甜的香蕉", placeholder));
                repo.save(new Item("橙子", "多汁的橙子", placeholder));
                repo.save(new Item("西瓜", "清爽的西瓜", placeholder));
                repo.save(new Item("葡萄", "紫色葡萄", placeholder));
            }
        };
    }
}
