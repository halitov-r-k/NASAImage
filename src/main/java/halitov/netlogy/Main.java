package halitov.netlogy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main {
    public static final String url = "https://api.nasa.gov/planetary/apod?api_key=Ad5FiPZWPYc2xB330H839WyrrNP3f349TJbsBBq4&date=2023-03-19";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        System.out.println("Program NASA Image");

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        CloseableHttpResponse response = httpClient.execute(new HttpGet(url));

        //Scanner scanner = new Scanner(response.getEntity().getContent());

        //System.out.println(scanner.nextLine());
        ResponseNASA responseNASA = mapper.readValue(response.getEntity().getContent(), ResponseNASA.class );
        //System.out.println(responseNASA);
        String[] imageUrl = responseNASA.getUrl().split("/");
        String fileName = imageUrl[imageUrl.length-1];


        CloseableHttpResponse image = httpClient.execute(new HttpGet(responseNASA.getUrl()));
        HttpEntity entity = image.getEntity();
        if (entity != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            entity.writeTo(fileOutputStream);
            fileOutputStream.close();
        }
    }


}