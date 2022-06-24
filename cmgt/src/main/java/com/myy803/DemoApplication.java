
package com.myy803;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Configuration;

@EnableJpaRepositories("com.Data*")
@ComponentScan(basePackages = { "com.myy803", "com.Web" })
@EntityScan("com.Data")
@Configuration
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		// CreateDefaultPasses();
		SpringApplication.run(DemoApplication.class, args);
	}

	public static void CreateDefaultPasses() {
		// Create and encode default user passwords
		UserDetails admin = User.withDefaultPasswordEncoder()
				  .username("admin")
				  .password("admin")
				  .roles("instructor")
				  .build();
		UserDetails john = User.withDefaultPasswordEncoder()
				  .username("john")
				  .password("password")
				  .roles("instructor")
				  .build();
		UserDetails max = User.withDefaultPasswordEncoder()
				  .username("max")
				  .password("max")
				  .roles("instructor")
				  .build();
		System.out.println("Admin: " + admin.getPassword());
		System.out.println("John: " + john.getPassword());
		System.out.println("Max: " + max.getPassword());
	}
}
