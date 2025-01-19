package com.example.DnD_Character_Server;

import com.example.DnD_Character_Server.services.CharacterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DnDCharacterServerApplication {


	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DnDCharacterServerApplication.class, args);
		CharacterService characterService = ctx.getBean(CharacterService.class);
		System.out.println(characterService.getAnyCharacterDetails(1));
		System.out.println("Server is running");
	}

}
