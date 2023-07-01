package com.ashrit.movieapi;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieservice;

    @GetMapping
    public ResponseEntity<List<Movie>> getAll(){
        return new ResponseEntity<List<Movie>>(movieservice.All(),HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<Movie>> getsingleMovie(@PathVariable String id){
        return new ResponseEntity<Optional<Movie>>(movieservice.singleMovie(id),HttpStatus.OK);
    }
//    @PostMapping
//    public ResponseEntity<Movie> createMovie(@RequestBody Map<String,String> payload){
//        return new ResponseEntity<Movie>(movieservice.create(payload.get("imdbId"),payload.get("title")), HttpStatus.CREATED);
//
//    }
}
