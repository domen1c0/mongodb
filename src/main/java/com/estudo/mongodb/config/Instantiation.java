package com.estudo.mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.estudo.mongodb.domain.User;
import com.estudo.mongodb.repositories.UserRepository;

@Configuration //Para o Spring entender que isso é uma configuração
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll(); //Limpa a coleção no MongoDB
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob)); // Salva os usuários na coleção no MongoDB
		
	}
	

}
