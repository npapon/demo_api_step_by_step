package fr.stepbysteptestapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.stepbysteptestapi.model.Utilisateur_Persiste;
import fr.stepbysteptestapi.service.Utilisateur_Persiste_Service;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Utilisateur_Persiste_Controller {

	@Autowired
	private Utilisateur_Persiste_Service utilisateur_Persiste_Service;

	@GetMapping("/utilisateur")
	public Iterable<Utilisateur_Persiste> getAllUtilisateur() {
		return utilisateur_Persiste_Service.getAllUtilisateur();
	}

	@GetMapping("/utilisateur/{id_utilisateur}")
	public Utilisateur_Persiste getUtilisateur(@PathVariable("id_utilisateur") final Long id_utilisateur) {
		Optional<Utilisateur_Persiste> optionalUtilisateur = utilisateur_Persiste_Service
				.getUtilisateur(id_utilisateur);
		if (optionalUtilisateur.isPresent()) {
			return optionalUtilisateur.get();
		} else {
			return null;
		}
	}

	@PostMapping("/utilisateur")
	public Utilisateur_Persiste createUtilisateur(@RequestBody Utilisateur_Persiste utilisateur) {
		return utilisateur_Persiste_Service.saveUtilisateur(utilisateur);
	}

	@PutMapping("/utilisateur/{id_utilisateur_a_updater}")
	public Utilisateur_Persiste updateUtilisateur(
			@PathVariable("id_utilisateur_a_updater") final Long id_utilisateur_a_updater,
			@RequestBody Utilisateur_Persiste utilisateurAvecLesMisesAJour) {
//on récupère l'utilisateur de l'url
		Optional<Utilisateur_Persiste> optionalUtilisateurDuEndPoint = utilisateur_Persiste_Service
				.getUtilisateur(id_utilisateur_a_updater);

		if (optionalUtilisateurDuEndPoint.isPresent()) {
			Utilisateur_Persiste utilisateurEndPoint = optionalUtilisateurDuEndPoint.get();
//et on met à jour ses infos avec l'utilisateur du body
			String loginAMettreAJour = utilisateurAvecLesMisesAJour.getLogin();
			if (loginAMettreAJour != null) {
				utilisateurEndPoint.setLogin(loginAMettreAJour);
			}

			String motDePasseAMettreAJour = utilisateurAvecLesMisesAJour.getMotDePasse();
			if (motDePasseAMettreAJour != null) {
				utilisateurEndPoint.setMotDePasse(motDePasseAMettreAJour);

			}
			String emailAMettreAJour = utilisateurAvecLesMisesAJour.getEmail();
			if (emailAMettreAJour != null) {
				utilisateurEndPoint.setEmail(emailAMettreAJour);
			}

			utilisateur_Persiste_Service.saveUtilisateur(utilisateurEndPoint);

			return utilisateurEndPoint;

		} else {

			return null;
		}
	}

	@DeleteMapping("/utilisateur/{id_utilisateur_a_supprimer}")
	public void deleteUtilsateur(@PathVariable("id_utilisateur_a_supprimer") final Long id_utilisateur_a_supprimer) {
		utilisateur_Persiste_Service.deleteUtilisateur(id_utilisateur_a_supprimer);
	}

	@GetMapping("/login")
	public Utilisateur_Persiste getUtilisateurByLoginEtMotDePasse(@RequestParam(name = "login") String login,
			@RequestParam(name = "motdepasse") String motDePasse) {

		Optional<Utilisateur_Persiste> optionalUtilisateur = utilisateur_Persiste_Service
				.findByLoginAndMotDePasse(login, motDePasse);
		if (optionalUtilisateur.isPresent()) {
			return optionalUtilisateur.get();
		} else {
			return null;
		}

	}

	@GetMapping("/controlelogin")
	public Utilisateur_Persiste getUtilisateurByLogin(@RequestParam(name = "login") String login) {

		Optional<Utilisateur_Persiste> optionalUtilisateur = utilisateur_Persiste_Service.findByLogin(login);
		if (optionalUtilisateur.isPresent()) {
			return optionalUtilisateur.get();
		} else {
			return null;
		}

	}

	@GetMapping("/utilisateuravecreponsepersonnalisee/{id_utilisateur}")
	public ResponseEntity getUtilisateurAvecReponsePersonnalisee(
			@PathVariable("id_utilisateur") final Long id_utilisateur) {

		if (id_utilisateur == 0) {
			return ResponseEntity.badRequest().body("Aucun utilisateur ne peut être trouvé avec un id 0");
		}

		Optional<Utilisateur_Persiste> optionalUtilisateur = utilisateur_Persiste_Service
				.getUtilisateur(id_utilisateur);
		if (optionalUtilisateur.isPresent()) {
			return ResponseEntity.ok().body(optionalUtilisateur.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}