package <%= appPackage %>.data.net

import com.kristal.mymovie.network.model.Movie
import com.kristal.mymovie.network.model.Movies
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Dwi_Ari on 10/24/17.
 */

internal interface MovieApi {
    @get:GET("movie/upcoming")
    val upcoming: Observable<Movies>

    @get:GET("movie/now_playing")
    val nowPlaying: Observable<Movies>

    @GET("search/movie")
    fun getSearch(@Query("query") search: String): Observable<Movies>

    @GET("movie/{id}")
    fun getDetailMovie(@Path("id") id: Int): Observable<Movie>
}
