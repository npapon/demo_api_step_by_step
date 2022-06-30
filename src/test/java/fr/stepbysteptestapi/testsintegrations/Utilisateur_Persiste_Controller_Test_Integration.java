package fr.stepbysteptestapi.testsintegrations;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class Utilisateur_Persiste_Controller_Test_Integration {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void givenApiUtilisateurWhenGetUtilisateur0PrenomThenReturn() {

		try {
			mockMvc.perform(get("/utilisateur")).andExpect(status().isOk())
					.andExpect(jsonPath("$[0].login", is("jchieze")));
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
