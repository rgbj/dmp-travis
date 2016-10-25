package me.rgbj;

import java.io.IOException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntegrationTest {

    @Test
    public void http_test() throws IOException {
        HttpGet httpget = new HttpGet("http://localhost:" + System.getProperty("HTTP_PORT"));
        try (CloseableHttpClient hc = HttpClients.createDefault()) {
            hc.execute(httpget, hr -> {
                assertEquals(200, hr.getStatusLine().getStatusCode());
//                try {
//                    System.out.println(EntityUtils.toString(hr.getEntity()));
//                } catch (IOException | ParseException e) {
//                    throw new RuntimeException(e);
//                }
                return null;
            });
        }
    }
}
