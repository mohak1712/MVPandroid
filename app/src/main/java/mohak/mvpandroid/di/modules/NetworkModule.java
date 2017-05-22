package mohak.mvpandroid.di.modules;

import dagger.Module;
import dagger.Provides;
import mohak.mvpandroid.di.scopes.ApplicationScope;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohak on 19/5/17.
 */

@Module
public class NetworkModule {

    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }




}
