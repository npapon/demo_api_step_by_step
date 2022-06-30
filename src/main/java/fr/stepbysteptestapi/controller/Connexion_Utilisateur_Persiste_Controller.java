package fr.stepbysteptestapi.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.stepbysteptestapi.model.Connexion_Utilisateur_Persiste;
import fr.stepbysteptestapi.service.Connexion_Utilisateur_Persiste_Service;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Connexion_Utilisateur_Persiste_Controller {

	@Autowired
	private Connexion_Utilisateur_Persiste_Service connexion_utilisateur_persiste_service;

	@GetMapping("/connexionutilisateur")
	public Iterable<Connexion_Utilisateur_Persiste> getAllConnexionsUtilisateur() {
		return connexion_utilisateur_persiste_service.getAllConnexionUtilisateur();
	}

	@GetMapping("/connexionutilisateur/{id_connexion_utilisateur}")
	public Connexion_Utilisateur_Persiste getUtilisateur(
			@PathVariable("id_connexion_utilisateur") final Long id_connexion_utilisateur) {
		Optional<Connexion_Utilisateur_Persiste> optionalConnexionUtilisateur = connexion_utilisateur_persiste_service
				.getConnexionUtilisateur(id_connexion_utilisateur);
		if (optionalConnexionUtilisateur.isPresent()) {
			return optionalConnexionUtilisateur.get();
		} else {
			return null;
		}
	}

	@PostMapping("/connexionutilisateur")
	public Connexion_Utilisateur_Persiste createConnexionUtilisateur(
			@RequestBody Connexion_Utilisateur_Persiste connexion_utilisateur_persiste) {
		return connexion_utilisateur_persiste_service.saveConnexionUtilisateur(connexion_utilisateur_persiste);
	}

	@PutMapping("/connexionutilisateur/{id_connexion_utilisateur_a_updater}")
	public Connexion_Utilisateur_Persiste updateConnexionUtilisateur(
			@PathVariable("id_connexion_utilisateur_a_updater") final Long id_connexion_utilisateur_a_updater,
			@RequestBody Connexion_Utilisateur_Persiste connexionUtilisateurAvecLesMisesAJour) {
		Optional<Connexion_Utilisateur_Persiste> optionalConnexionUtilisateurDuEndPoint = connexion_utilisateur_persiste_service
				.getConnexionUtilisateur(id_connexion_utilisateur_a_updater);

		if (optionalConnexionUtilisateurDuEndPoint.isPresent()) {
			Connexion_Utilisateur_Persiste connexionUtilisateurEndPoint = optionalConnexionUtilisateurDuEndPoint.get();

			Date dateAMettreAJour = connexionUtilisateurAvecLesMisesAJour.getDate_connexion();
			if (dateAMettreAJour != null) {
				connexionUtilisateurEndPoint.setDate_connexion(dateAMettreAJour);
			}

			connexion_utilisateur_persiste_service.saveConnexionUtilisateur(connexionUtilisateurEndPoint);

			return connexionUtilisateurEndPoint;

		} else {

			return null;
		}
	}

	@DeleteMapping("/connexionutilisateur/{id_connexion_utilisateur_a_supprimer}")
	public void deleteConnexionUtilsateur(
			@PathVariable("id_connexion_utilisateur_a_supprimer") final Long id_connexion_utilisateur_a_supprimer) {
		connexion_utilisateur_persiste_service.deleteConnexionUtilisateur(id_connexion_utilisateur_a_supprimer);
	}

}