package fr.stepbysteptestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.stepbysteptestapi.model.Connexion_Utilisateur_Persiste;

@Repository
public interface Connexion_Utilisateur_Persiste_Repository
		extends CrudRepository<Connexion_Utilisateur_Persiste, Long> {

}