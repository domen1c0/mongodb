package com.estudo.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.estudo.mongodb.domain.Post;
import com.estudo.mongodb.domain.User;
import com.estudo.mongodb.dto.AuthorDTO;
import com.estudo.mongodb.repositories.PostRepository;
import com.estudo.mongodb.repositories.UserRepository;

@Configuration //Para o Spring entender que isso é uma configuração
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll(); //Limpa a coleção no MongoDB
		postRepository.deleteAll(); //Limpa a coleção no MongoDB
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob)); // Salva os usuários na coleção no MongoDB
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
	}
	

}
