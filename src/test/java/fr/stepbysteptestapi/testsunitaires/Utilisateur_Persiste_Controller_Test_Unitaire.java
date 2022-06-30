package fr.stepbysteptestapi.testsunitaires;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import fr.stepbysteptestapi.controller.Utilisateur_Persiste_Controller;
import fr.stepbysteptestapi.service.Utilisateur_Persiste_Service;

@WebMvcTest(controllers = Utilisateur_Persiste_Controller.class)
public class Utilisateur_Persiste_Controller_Test_Unitaire {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private Utilisateur_Persiste_Service utilisateur_Persiste_Service;

	@Test
	public void testGetTousLesUtilisateurs() throws Exception {

		mockMvc.perform(get("/utilisateur")).andExpect(status().isOk());
	}

}
