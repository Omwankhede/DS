import org.springframework.web.client.RestTemplate;

public class WebServiceClient {

    public static void main(String[] args) {
        // URL of the web service
        String webServiceUrl = "http://localhost:8080/api/hello";

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Make a GET request to the web service
        String response = restTemplate.getForObject(webServiceUrl, String.class);

        // Print the response
        System.out.println("Response from the web service: " + response);
    }
}
