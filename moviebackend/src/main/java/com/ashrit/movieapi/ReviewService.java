package com.ashrit.movieapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String body, String imdbId){
        Review review = reviewRepo.insert(new Review(body,imdbId));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review)).first();

        return review;
    }
    public Optional<Review> singleReview(String id){
        return reviewRepo.findByimdbId(id);
    }
    public Optional<Review> deleteReview(String id){
        return reviewRepo.deleteByimdbId(id);
    }
//    public Review updateReview(ObjectId id, String body){
//        Optional<Review> data=reviewRepo.findByObjectId(id);
//        if (data.isPresent()){
//            Review datas= data.get();
//            datas.setBody(body);
//            return datas;
//        }
//        else{
//            return null;
//        }
//    }
}
