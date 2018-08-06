package com.mokhlisse.hibernatenamedquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class })
@EntityScan("com.mokhlisse.hibernatenamedquery")
public class HibernateNamedQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateNamedQueryApplication.class, args);
	}
}
