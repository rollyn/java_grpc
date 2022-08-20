package com.ethanium.service;

import com.ethanium.model.MovieDto;
import com.ethanium.model.MovieSearchRequest;
import com.ethanium.model.MovieSearchResponse;
import com.ethanium.model.MovieServiceGrpc;
import com.ethanium.model.common.Genre;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class MovieService extends MovieServiceGrpc.MovieServiceImplBase {


    @Override
    public void getMovies(MovieSearchRequest request, StreamObserver<MovieSearchResponse> responseObserver) {
        Genre genre = request.getGenre();
        System.out.println("Genre: "+genre.name());

        MovieDto movie = MovieDto.newBuilder()
                .setTitle("Mission Impossible")
                .setYear(2022)
                .setRating(10)
                .build();

        MovieSearchResponse response = MovieSearchResponse.newBuilder()
                .addMovie(movie)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        //super.getMovies(request, responseObserver);
    }
}
