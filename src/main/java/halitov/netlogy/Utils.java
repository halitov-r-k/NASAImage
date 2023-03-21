package halitov.netlogy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class Utils {
    public static ObjectMapper mapper = new ObjectMapper();
    static CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(5000)
                    .setSocketTimeout(30000)
                    .setRedirectsEnabled(false)
                    .build())
            .build();

    public static String getUrl(String url) throws IOException {
        CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
        ResponseNASA responseNASA = mapper.readValue(response.getEntity().getContent(), ResponseNASA.class );
        return responseNASA.getUrl();
    }

}
