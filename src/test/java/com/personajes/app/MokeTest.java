/**
 * Test de Unitario
 * 
 * @author GR
 */

package com.personajes.app;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

import com.google.common.net.HttpHeaders;
import com.personajes.app.controller.PersonajesController;
import com.personajes.app.entity.Personajes;
import com.personajes.app.service.PersonajeServices;


@WebMvcTest(PersonajesController.class)
public class MokeTest { 

	@Autowired
	private MockMvc MockMvc;
	
	@MockBean
	private PersonajeServices service;
	

	@Test
	public void FindAllTest() throws Exception {

		List<Personajes> listPersonajes = new ArrayList<>();
		listPersonajes.add(new Personajes(1L, "SUPERMAN"));
		listPersonajes.add(new Personajes(2L, "SPIDERMAN"));
		
		Mockito.when(service.finAll()).thenReturn(listPersonajes);

		
		MockMvc.perform(get("/api/personajes")
		.header(HttpHeaders.AUTHORIZATION,
                    "Basic " + Base64Utils.encodeToString("admin:admin".getBytes())))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("SPIDERMAN")))
		.andDo(print());
		
	}
}
