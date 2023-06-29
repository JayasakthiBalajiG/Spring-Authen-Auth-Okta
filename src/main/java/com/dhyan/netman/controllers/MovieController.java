package com.dhyan.netman.controllers;

import com.dhyan.netman.model.Movie;
import com.dhyan.netman.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    public static final String AUTHENTICATED_PATH = "/authenticated";
    @RequestMapping(AUTHENTICATED_PATH)
    public String authenticated(){
        return "autheticated";
    }


    @RequestMapping("/allmovies")
    @PreAuthorize("hasAuthority('ADMINS')")
    public ResponseEntity<List<Movie>> getAllMovies() {
        System.out.println("worked");
        List<Movie> movies = new ArrayList<>();
        Movie nextGen = new Movie();
        nextGen.setMovieId(1);
        nextGen.setMovieName("hello");
        nextGen.setGenre("fantasy");
        nextGen.setDirector("Balaji");
        nextGen.setComments("good");
        movies.add(nextGen);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @RequestMapping("/users")
    @PreAuthorize("hasAuthority('USERS')")
    public String UsersFunc(Principal principal){
        return "Hi" + principal.getName()+ " user function";
    }

    @PostMapping("/movie")
    @PreAuthorize("hasAuthority('ADMINS')")
    public ResponseEntity<Movie> saveMovies(@RequestBody Movie newMovie, Authentication auth) {
        return ResponseEntity.status(HttpStatus.CREATED).body((movieService.saveMovie(newMovie)));
    }


    @PostMapping("/comments")
    @PreAuthorize("hasAuthority('USERS')")
    public ResponseEntity<Movie>giveComments(@RequestBody Movie newComment, Authentication auth){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.findByComments(String.valueOf(newComment)));
    }


    @GetMapping("/{name}")
    @PreAuthorize("hasAuthority('USERS')")
    public ResponseEntity <List<Movie>> getMoviesByName(@PathVariable("name")String movieName){
        return ResponseEntity.ok().body(Collections.singletonList(movieService.findByMovieName(movieName)));
    }

    @GetMapping("/")
    public String Test(Principal principal){
        return "Hi"+principal.getName() + " hi";
    }


}
