package com.ashrit.movieapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> getReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("body"),payload.get("imdbId")), HttpStatus.CREATED);

    }
//    @PutMapping
//    public ResponseEntity<Review> updateReview(@RequestBody Map<String,String> payload,Map<ObjectId,String> objid){
//        return new ResponseEntity<Review>(reviewService.updateReview(objid.get(),payload.get("body")), HttpStatus.OK);
//
//    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<Review>> getsingleReview(@PathVariable String id){
        return new ResponseEntity<Optional<Review>>(reviewService.singleReview(id), HttpStatus.OK);
    }
//    @DeleteMapping("{id}")
//    public ResponseEntity<Optional<Review>> delete(@PathVariable String id){
//        return new ResponseEntity<Optional<Review>>(reviewService.deleteReview(id), HttpStatus.ACCEPTED);
//
//    }

}
