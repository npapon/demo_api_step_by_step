package fr.stepbysteptestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "utilisateur_persiste")
public class Utilisateur_Persiste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id_utilisateur;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "MOT_DE_PASSE")
	private String motDePasse;

	@Column(name = "EMAIL")
	private String email;

}
