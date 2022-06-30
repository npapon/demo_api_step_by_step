package fr.stepbysteptestapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "connexions_utilisateur_persiste")
public class Connexion_Utilisateur_Persiste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id_connexion_utilisateur;

	@OneToOne
	@JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID")
	private Utilisateur_Persiste utilisateur;

	@Column(name = "DATE_CONNEXION")
	private Date date_connexion;

}
