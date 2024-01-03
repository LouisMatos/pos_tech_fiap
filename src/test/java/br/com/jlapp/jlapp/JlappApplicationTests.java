package br.com.jlapp.jlapp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.postechfiap.jlapp.JlappApplication;
import lombok.RequiredArgsConstructor;

@ActiveProfiles("test")
@RequiredArgsConstructor
@SpringBootTest(classes = { JlappApplication.class })
class JlappApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}

}