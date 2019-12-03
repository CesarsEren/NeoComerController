package com.millenniumprogrammers.neocomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.millenniumprogrammers.neocomer.model.Atributos;
import com.millenniumprogrammers.neocomer.repository.AtributosDAO;

@SpringBootApplication
public class NeocomerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(NeocomerApplication.class, args);
	}

	@Autowired
	AtributosDAO atrdao;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Atributos x = new Atributos();
		x.setDetalle("Tercer Atributo");
		//x.setId_atributo(1);
		
		atrdao.Register(x);
		
	}
}
