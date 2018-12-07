//package com.luchongbin.mycashbook.http;
//
//import java.util.concurrent.TimeUnit;
//
//
//import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class RestApi {
//
//    private static RestApi mInstance;
//    public static boolean isDebug = false;
//    private final static int CONNECT_TIMEOUT =60;
//    public static synchronized RestApi getInstance() {
//        if (mInstance == null)
//            mInstance = new RestApi();
//        return mInstance;
//    }
//
//    public void bug(boolean isDebug) {
//        this.isDebug = isDebug;
//    }
//
//    // create retrofit singleton
//    private Retrofit createApiClient(String baseUrl) {
//        return new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
////                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .client(createOkHttpClient(isDebug))
//                .build();
//    }
//
//    // create api service singleton
//    public <T> T create(String baseUrl, Class<T> clz) {
//        return createApiClient(baseUrl).create(clz);
//    }
//
//    // create okHttpClient singleton
//    OkHttpClient createOkHttpClient(boolean debug) {
//        return new OkHttpClient.Builder()
//                .addNetworkInterceptor(new HttpCacheInterceptor())
//                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
//                .addInterceptor(
//                        new HttpLoggingInterceptor().setLevel(
//                                debug ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
//                .build();
//    }
//}
