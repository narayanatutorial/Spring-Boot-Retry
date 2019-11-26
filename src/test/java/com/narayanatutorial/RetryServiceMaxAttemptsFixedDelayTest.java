package com.narayanatutorial;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.narayanatutorial.fixeddelay.RetryServiceMaxAttemptsFixedDelay;

@SpringBootTest
public class RetryServiceMaxAttemptsFixedDelayTest {

	@Autowired
	RetryServiceMaxAttemptsFixedDelay  retryServiceMaxAttemptsFixedDelay;
	
	@Test
	public void sampleRetry() throws SQLException {
		retryServiceMaxAttemptsFixedDelay.sampleRetry();
	}
}
