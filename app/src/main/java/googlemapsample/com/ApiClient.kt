package googlemapsample.com

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ApiClient {

    private val TAG = "ServiceGenerator"
    private const val API_BASE_URL = "https://maps.googleapis.com/maps/api/"

    private// add your other interceptors …
    // set your desired log level
    // add logging as last interceptor
    // <-- this is the important line!
    val client: Retrofit
        get() {

            val httpClient = OkHttpClient.Builder()
            httpClient.connectTimeout(60, TimeUnit.SECONDS)
            httpClient.readTimeout(60, TimeUnit.SECONDS)

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(logging)
            val gson = GsonBuilder()
                    .setLenient()
                    .create()

            return Retrofit.Builder()
                    .baseUrl(API_BASE_URL).client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create(gson)).build()
        }
    //    private static final String API_BASE_URL = "http://beta.sweetnsweets.com/iphone/webservices/";

    fun createService(): RestApi {
        return client
                .create<RestApi>(RestApi::class.java!!)
    }

}
