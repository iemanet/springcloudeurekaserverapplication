package eurekaclientreissue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

import eurekaclientreissue.client.Client;
import eurekaclientreissue.config.RibbonConfiguration;

@RibbonClient(name = "ping-server", configuration = RibbonConfiguration.class)
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientReissueApplication {

	@Bean
	public Client client() {
		return new Client();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientReissueApplication.class, args);
	}
}
