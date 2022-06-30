package fr.stepbysteptestapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.stepbysteptestapi.model.Connexion_Utilisateur_Persiste;
import fr.stepbysteptestapi.repository.Connexion_Utilisateur_Persiste_Repository;
import lombok.Data;

@Data
@Service
public class Connexion_Utilisateur_Persiste_Service {

	@Autowired
	private Connexion_Utilisateur_Persiste_Repository connexion_Utilisateur_Repository;

	public Optional<Connexion_Utilisateur_Persiste> getConnexionUtilisateur(final Long id) {
		return connexion_Utilisateur_Repository.findById(id);
	}

	public Iterable<Connexion_Utilisateur_Persiste> getAllConnexionUtilisateur() {
		return connexion_Utilisateur_Repository.findAll();
	}

	public void deleteConnexionUtilisateur(final Long id) {
		connexion_Utilisateur_Repository.deleteById(id);
	}

	public Connexion_Utilisateur_Persiste saveConnexionUtilisateur(
			Connexion_Utilisateur_Persiste connexionUtilisateur) {
		Connexion_Utilisateur_Persiste savedConnexionUtilisateur = connexion_Utilisateur_Repository
				.save(connexionUtilisateur);
		return connexionUtilisateur;

	}

}
