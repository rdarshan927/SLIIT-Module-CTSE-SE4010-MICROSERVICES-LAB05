package com.ctse.itemservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    // Simple in-memory list (no database needed)
    private List<Map<String, Object>> items = new ArrayList<>(List.of(
            new HashMap<>(Map.of("id", 1, "name", "Book")),
            new HashMap<>(Map.of("id", 2, "name", "Laptop")),
            new HashMap<>(Map.of("id", 3, "name", "Phone"))));
    private int idCounter = 4;

    @GetMapping
    public List<Map<String, Object>> getItems() {
        return items;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addItem(@RequestBody Map<String, Object> item) {
        item.put("id", idCounter++);
        items.add(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItem(@PathVariable int id) {
        return items.stream()
                .filter(i -> i.get("id").equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
