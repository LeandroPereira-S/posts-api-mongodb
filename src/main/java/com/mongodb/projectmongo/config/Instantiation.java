package com.mongodb.projectmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongodb.projectmongo.domain.Post;
import com.mongodb.projectmongo.domain.User;
import com.mongodb.projectmongo.dto.AuthorDTO;
import com.mongodb.projectmongo.dto.CommentsDTO;
import com.mongodb.projectmongo.repository.PostRepository;
import com.mongodb.projectmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null,  sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, abraços", new AuthorDTO(maria));
		Post post2 = new Post(null,  sdf.parse("23/03/2018"),"Bom dia", "Acordei feliz hoje", new AuthorDTO (alex));
		
		CommentsDTO c1 = new CommentsDTO("Boa viagem!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentsDTO c2 = new CommentsDTO("Fico feliz por você", sdf.parse("14/01/2019"), new AuthorDTO(maria));
		CommentsDTO c3 = new CommentsDTO("Boa!", sdf.parse("15/03/2018"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPost().addAll(Arrays.asList(post1, post2));

		userRepository.save(maria);
	}

}
