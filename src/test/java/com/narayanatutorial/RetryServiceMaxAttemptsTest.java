package com.narayanatutorial;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.narayanatutorial.maxattempts.RetryServiceMaxAttempts;

@SpringBootTest
public class RetryServiceMaxAttemptsTest {

	@Autowired
	RetryServiceMaxAttempts retryServiceMaxAttempts;
	
	@Test
	public void sampleRetry() throws SQLException {
		retryServiceMaxAttempts.sampleRetry();
	}
}
