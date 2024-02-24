package com.github.luisfeliperochamartins.aluraDesafio;

import com.github.luisfeliperochamartins.aluraDesafio.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraDesafioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AluraDesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.showMenu();
	}
}
