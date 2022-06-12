package fr.stepbysteptestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.stepbysteptestapi.model.Utilisateur_Persiste;
import fr.stepbysteptestapi.service.Utilisateur_Persiste_Service;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private Utilisateur_Persiste_Service utilisateur_persiste_service;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello world");
		Utilisateur_Persiste utilisateur_test = new Utilisateur_Persiste();
		utilisateur_test.setLogin("test_login");
		utilisateur_test.setMot_de_passe("test_mdp");
		utilisateur_test.setEmail("test email");
		utilisateur_persiste_service.saveUtilisateur(utilisateur_test);

	}

}
