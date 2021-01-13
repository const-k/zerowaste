package com.zerowaste;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ZeroWasteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeroWasteApplication.class, args);
	}

}
