/**
 * Test de integracion
 * 
 * @author GR
 */


package com.personajes.app;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.personajes.app.entity.Personajes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = PersonajesApplication.class, 
        webEnvironment = WebEnvironment.RANDOM_PORT)
        
public class PersonajesControllerTest {

    @LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testCreatePersonaje() 
	{
        Personajes oPersonajes = new Personajes(1L, "SUPERMAN");
       
        ResponseEntity<String> responseEntity = this.restTemplate
		.withBasicAuth("admin", "admin")
        .postForEntity("http://localhost:" + port + "/api/personajes", oPersonajes, String.class);
        assertEquals(201, responseEntity.getStatusCodeValue());

	}
    
}
