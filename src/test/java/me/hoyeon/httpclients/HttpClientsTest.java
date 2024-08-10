package me.hoyeon.httpclients;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.RequestBuilder;

import java.io.IOException;

import static okhttp3.Request.*;

public class HttpClientsTest {

    @Test
    void apacheHttpClientTest() throws IOException {

        try (var httpClient = HttpClients.createDefault()){
            var httpGet = new HttpGet("https://emart.ssg.com/");
            System.out.println(httpGet.getRequestLine());

            System.out.println("---------");

            var responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                    var statusCode = response.getStatusLine()
                                             .getStatusCode();
                    if (statusCode >= 200 && statusCode < 300) {
                        var entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("unexpected code : " + statusCode);
                    }
                }
            };
            var responseBody = httpClient.execute(httpGet, responseHandler);

            System.out.println(responseBody);
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void OkHttpClientTest() {
        var client = new OkHttpClient();
        var request = new Builder().url("https://emart.ssg.com/")
                                   .build();
        try (var response = client.newCall(request).execute()) {
            var body = response.body();
            System.out.println(body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
