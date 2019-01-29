package com.bank.springjunit.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bank.springjunit.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {
	@LocalServerPort
	int randomServerPort;
	String url="http://localhost:";
	RestTemplate restTemplate = new RestTemplate();
	@Test
	public void retrieveAllStudentsSuccess() throws URISyntaxException {
		

		final String baseUrl = url + randomServerPort + "/students";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals(true, result.getBody().contains("id"));
		Assert.assertEquals(true, result.getBody().contains("name"));
		Assert.assertEquals(true, result.getBody().contains("passportNumber"));
		
	}
	@Test
	public void createStudentSuccess() throws URISyntaxException {
	
		final String baseUrl = url + randomServerPort + "/students";
		URI uri = new URI(baseUrl);	
		Long id=1005L;
		Student student =new Student(id,"Suchat","passwod");

		ResponseEntity<String> result=restTemplate.postForEntity(uri, student,String.class);
		// Verify request succeed
		Assert.assertEquals(201, result.getStatusCodeValue());
	

	}
}
