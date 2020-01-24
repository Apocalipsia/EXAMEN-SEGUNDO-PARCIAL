package facci.juliointriago.mongobd.rest.adapter;

import com.squareup.picasso.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseAdapter {
    private static Retrofit retrofit;
    private static HttpLoggingInterceptor.Level LEVEL_LOG = HttpLoggingInterceptor.Level.BODY;

    BaseAdapter(String baseUrl){init(baseUrl);
    }

    private void init(String baseUrl){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(getClient()).addConverterFactory(GsonConverterFactory.create()).build();
        }
    }

    private OkHttpClient getClient() {
        OkHttpClient.Builder builderClientHttp = new OkHttpClient().newBuilder();
        // Show HTTPS logs in dev mode
        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(LEVEL_LOG);
            builderClientHttp.addInterceptor(interceptor);
        }
        return builderClientHttp.build();
    }
    <T> T creativeService(Class<T>_class) {return retrofit.create(_class);}
}

