package mohak.mvpandroid.di.modules;

import dagger.Module;
import dagger.Provides;
import mohak.mvpandroid.Utils.Constants;
import mohak.mvpandroid.data.DataManager.network.TvDbService;
import mohak.mvpandroid.di.qualifiers.Url;
import mohak.mvpandroid.di.scopes.ApplicationScope;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohak on 19/5/17.
 */

@Module
public class NetworkModule {

    @ApplicationScope
    @Provides
    Retrofit provideRetrofit(@Url String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    @Url
    @Provides
    String retrofitUrl() {
        return Constants.BASE_URL;
    }

    @ApplicationScope
    @Provides
    TvDbService getMovieDbService(Retrofit retrofit) {
        return  retrofit.create(TvDbService.class);
    }



}
