package com.example.userService.serviceImpl;

import com.example.userService.entities.Hotel;
import com.example.userService.entities.Rating;
import com.example.userService.external.HotelService;
import com.example.userService.external.RatingService;
import com.example.userService.service.UserService;
import com.example.userService.exception.ResourceNotFoundException;
import com.example.userService.repository.UserRepo;
import com.example.userService.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RatingService ratingService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserIdString = UUID.randomUUID().toString();
        user.setUserId(randomUserIdString);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given Id os not found on server!! :"+userId));
        //fetch rating of above user from RATING SERVICE
        //http://localhost:8085/ratings/users/4fd7f4a5-31cf-4ef2-aa3b-4ed64cd0b564

//        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
//        logger.info("{}", ratingsOfUser);
//        List<Rating> ratings= Arrays.stream(ratingsOfUser).toList();

        ResponseEntity<List<Rating>> ratingsEntity = ratingService.getRating(user.getUserId());
        List<Rating> ratings = ratingsEntity.getBody();
        List<Rating> ratingList = ratings.stream().map((Rating e) -> {
          // ResponseEntity<Hotel> hotelsEntity=  restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+e.getHotelId(), Hotel.class);
//           Hotel hotel = hotelsEntity.getBody();
//            logger.info("response status code:{}",hotelsEntity.getStatusCode());
            Hotel hotel = hotelService.getHotel(e.getHotelId());

            e.setHotel(hotel);
            return e;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
