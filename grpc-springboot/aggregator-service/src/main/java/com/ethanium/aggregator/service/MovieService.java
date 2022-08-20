package com.ethanium.aggregator.service;

import com.ethanium.aggregator.dto.Movie;
import com.ethanium.model.MovieSearchRequest;
import com.ethanium.model.MovieSearchResponse;
import com.ethanium.model.MovieServiceGrpc;
import com.ethanium.model.common.Genre;
import com.google.common.util.concurrent.ListenableFuture;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @GrpcClient("movie-service")
    private MovieServiceGrpc.MovieServiceFutureStub asyncStub;

    public List<Movie> getMovies(String genre) {

        MovieSearchRequest request = MovieSearchRequest.newBuilder()
                .setGenre(Genre.valueOf(genre))
                .build();

        MovieSearchResponse response = null;
        try {
            response = asyncStub.getMovies(request).get();
            return response.getMovieList().stream()
                    .map(movieDto -> new Movie(movieDto.getTitle(), movieDto.getYear(), movieDto.getRating()))
                    .collect(Collectors.toList());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
