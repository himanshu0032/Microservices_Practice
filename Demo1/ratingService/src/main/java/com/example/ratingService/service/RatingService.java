package com.example.ratingService.service;

import java.util.List;

import com.example.ratingService.entities.Rating;

public interface RatingService {
  Rating create(Rating rating);
  List<Rating> getRatings();
  List<Rating> getRatingByUserId(String userId);
  List<Rating> getRatingByHotelId(String hotelId);
  void deleteRatingById(String ratingId);
  Rating getRatingByRatingId(String ratingId);
}
