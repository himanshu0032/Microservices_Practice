package com.example.userService.external;

import com.example.userService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
    @GetMapping("ratings/users/{userId}")
    public ResponseEntity<List<Rating>> getRating(@PathVariable  String userId);
    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating);
    @PutMapping("/ratings/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable  String ratingId, Rating rating);
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId);

}
