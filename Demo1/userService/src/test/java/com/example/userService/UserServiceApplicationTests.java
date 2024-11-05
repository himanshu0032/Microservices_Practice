package com.example.userService;

import com.example.userService.entities.Rating;
import com.example.userService.external.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {
    @Autowired
	private RatingService ratingService;

//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(10).userId("").hotelId(" ").feedback("Not good").build();
////		ratingService.createRating(rating);
//		ResponseEntity<Rating> savedRating = ratingService.createRating(rating);
//        System.out.println("Rating created "+ savedRating);
//	}
//	@Test
//	void deleteRating(){
//		ratingService.deleteRating("993618f2-2a61-4375-8440-68551714ab28");
//        System.out.println("Rating deleted");
//	}

	@Test
	void contextLoads() {
	}


}
