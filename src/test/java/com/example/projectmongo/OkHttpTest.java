package com.example.projectmongo;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class OkHttpTest {

    @Test
    public void whenGetRequest_thenCorrect() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://fakestoreapi.com/products")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        var body = response.body().string();

//        Gson gson = new Gson();
//        Product[] mcArray = gson.fromJson(body, Product[].class);

        Assertions.assertNotNull(response.code());
    }

}
