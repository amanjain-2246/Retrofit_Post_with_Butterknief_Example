package com.example.ashish.retrofitpost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ashish on 22/08/2017.
 */

public interface ReqResInterface {

@POST("/api/users")
    Call<UserResponse> userreq(@Body UserRequest userRequest);

}
