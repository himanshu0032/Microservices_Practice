package com.example.ratingService.controller;

import java.util.List;

import com.example.ratingService.entities.Rating;
import com.example.ratingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
   private RatingService ratingService;
	

	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.ok(ratingService.getRatings());
	}
	

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		List<Rating> ratings = ratingService.getRatingByUserId(userId);
		System.out.println("userId: " + userId + " given ratings :"+ ratings);
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
	}

//	@DeleteMapping("/{ratingId}")
//	public ResponseEntity<String> deleteRatingByRatingId(@PathVariable("ratingId") String ratingId){
//		ratingService.deleteRatingById(ratingId);
//		return ResponseEntity.ok().body("Rating Deleted " + ratingId);
//
//	}

	@DeleteMapping("/{ratingId}")
	public ResponseEntity<String> deleteRatingByRatingId(@PathVariable("ratingId") String ratingId) {
		try {
			ratingService.deleteRatingById(ratingId);
			return ResponseEntity.ok().body("Rating Deleted " + ratingId);
		} catch (Exception e) {
			// Log the specific error for debugging
			System.err.println("Error deleting rating: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete rating: " + e.getMessage());
		}
	}


}
