package fr.stepbysteptestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.stepbysteptestapi.model.Utilisateur_Persiste;

@Repository
public interface Utilisateur_Persiste_Repository extends CrudRepository<Utilisateur_Persiste, Long> {

}
