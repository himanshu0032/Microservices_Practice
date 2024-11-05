package com.example.ratingService.serviceImpl;

import java.util.List;
import java.util.UUID;

import com.example.ratingService.entities.Rating;
import com.example.ratingService.repository.RatingRepo;
import com.example.ratingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RatingServiceImpl implements RatingService
{
	@Autowired
  private RatingRepo ratingRepo;

	@Override
	public Rating create(Rating rating) {
		String randomUserIdString = UUID.randomUUID().toString();
		rating.setRatingId(randomUserIdString);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}
	@Override
	public Rating getRatingByRatingId(String ratingId){
      Rating rating = ratingRepo.findByRatingId(ratingId);
	  return rating;
	}

	@Override
	public void deleteRatingById(String ratingId) {
		Rating rating = getRatingByRatingId(ratingId);
		ratingRepo.delete(rating);
	}

}
