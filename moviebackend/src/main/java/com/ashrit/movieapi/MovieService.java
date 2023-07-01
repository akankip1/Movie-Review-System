package com.ashrit.movieapi;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService  {
    @Autowired
    private MovieRepo movierepository;
    @Autowired
    private MongoTemplate mongoTemplate;
public List<Movie>All(){
return movierepository.findAll();
}
public Optional<Movie> singleMovie(String id){
return movierepository.findByimdbId(id);
}
public Movie create(String imdbId, String title){
    Movie movie=movierepository.insert(new Movie(imdbId,title));

    mongoTemplate.save(movie);

    return movie;
}
}
