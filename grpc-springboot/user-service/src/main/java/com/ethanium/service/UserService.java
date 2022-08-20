package com.ethanium.service;

import com.ethanium.model.UserResponse;
import com.ethanium.model.UserSearchRequest;
import com.ethanium.model.UserServiceGrpc;
import com.ethanium.model.UserUpdateGenreRequest;
import com.ethanium.model.common.Genre;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {


    @Override
    public void getUserGenre(UserSearchRequest request, StreamObserver<UserResponse> responseObserver) {

        UserResponse response = UserResponse.newBuilder()
                .setLoginId(request.getLoginId())
                .setName("ROLLYN")
                .setGenre(Genre.ACTION)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

        //        super.getUserGenre(request, responseObserver);
    }

    @Override
    public void updateUserGenre(UserUpdateGenreRequest request, StreamObserver<UserResponse> responseObserver) {
        super.updateUserGenre(request, responseObserver);
    }
}
