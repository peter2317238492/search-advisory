package com.example.searchadvisory;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "*")
public class SearchController {
    @Autowired
    private ItemRepository itemRepository;
    @GetMapping("/api/search")
    public List<String> search(@RequestParam String query) {
        // 静态推荐结果
        return Arrays.asList(
            query + " 推荐1",
            query + " 推荐2",
            query + " 推荐3"
        );
    }

    @GetMapping("/api/items")
    public List<Item> getItems() {
        return itemRepository.findAll();
    }
}
