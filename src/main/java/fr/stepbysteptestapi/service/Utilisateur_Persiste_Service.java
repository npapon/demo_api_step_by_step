package fr.stepbysteptestapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.stepbysteptestapi.model.Utilisateur_Persiste;
import fr.stepbysteptestapi.repository.Utilisateur_Persiste_Repository;
import lombok.Data;

@Data
@Service
public class Utilisateur_Persiste_Service {

	@Autowired
	private Utilisateur_Persiste_Repository utilisateur_Persiste_Repository;

	public Optional<Utilisateur_Persiste> getUtilisateur(final Long id) {
		return utilisateur_Persiste_Repository.findById(id);
	}

	public Iterable<Utilisateur_Persiste> getAllUtilisateur() {
		return utilisateur_Persiste_Repository.findAll();
	}

	public void deleteUtilisateur(final Long id) {
		utilisateur_Persiste_Repository.deleteById(id);
	}

	public Utilisateur_Persiste saveUtilisateur(Utilisateur_Persiste utilisateur_persiste) {

		Optional<Utilisateur_Persiste> optionalUtilisateur = this.findByLogin(utilisateur_persiste.getLogin());

		if (!optionalUtilisateur.isPresent()) {
			utilisateur_Persiste_Repository.save(utilisateur_persiste);
			return utilisateur_persiste;
		} else {
			return null;
		}

	}

	public Optional<Utilisateur_Persiste> findByLoginAndMotDePasse(String login, String motDePasse) {

		return utilisateur_Persiste_Repository.findByLoginAndMotDePasse(login, motDePasse);

	}

	public Optional<Utilisateur_Persiste> findByLogin(String login) {

		return utilisateur_Persiste_Repository.findByLogin(login);

	}

}
