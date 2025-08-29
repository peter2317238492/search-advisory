package com.example.searchadvisory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class SearchController {
    @GetMapping("/api/search")
    public List<String> search(@RequestParam String query) {
        // 静态推荐结果
        return Arrays.asList(
            query + " 推荐1",
            query + " 推荐2",
            query + " 推荐3"
        );
    }
}
