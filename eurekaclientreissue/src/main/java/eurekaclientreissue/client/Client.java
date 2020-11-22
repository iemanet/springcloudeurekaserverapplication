package eurekaclientreissue.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Client {

	@Autowired
	private LoadBalancerClient loadBalancer;

	public String displayReservation() {

		// come from spring.application.name in app.properties
		ServiceInstance serviceInstance = loadBalancer.choose("eureka-client-app-displayreservation");

		// rest method
		String baseUrl = serviceInstance.getUri().toString();

		System.out.println(baseUrl);

		baseUrl = baseUrl + "/displayReservation";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;

		response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);

		return response.getBody();
	}

	private static HttpEntity<?> getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
		return new HttpEntity<>(headers);
	}
}
