package <%= appPackage %>.data.example.retrofit.net.tools

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import <%= appPackage %>.data.BuildConfig
import <%= appPackage %>.data.example.retrofit.net.MovieApi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Dwi_Ari on 10/24/17.
 */

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor =
                Interceptor {
                    val url = it.request()
                            .url()
                            .newBuilder()
                            .addQueryParameter("api_key", BuildConfig.KEY)
                            .addQueryParameter("language", "en-US")
                            .build()

                    val request = it.request()
                            .newBuilder()
                            .url(url)
                            .build()

                    it.proceed(request)
                }

        val logger = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BASIC)

        val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .addInterceptor(interceptor)
                .build()

        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
    }

    @Singleton
    @Provides
    internal fun provideMovies(retrofit: Retrofit): MovieApi =
            retrofit.create(MovieApi::class.java)
}
