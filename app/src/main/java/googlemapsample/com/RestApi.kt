package googlemapsample.com

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RestApi {

    @GET("directions/json")
    fun getRouteDirectionData(@Query("origin") origin: String,
                              @Query("destination") destination: String,
                              @Query("key") key: String): Call<RouteDirectionDataResp>
}

