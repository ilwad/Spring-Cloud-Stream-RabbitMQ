package io.spring.dataflow.sample.usagedetailhttpsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.app.http.source.HttpSourceConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(HttpSourceConfiguration.class)
public class UsageDetailHttpSourceRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsageDetailHttpSourceRabbitApplication.class, args);
	}

}
