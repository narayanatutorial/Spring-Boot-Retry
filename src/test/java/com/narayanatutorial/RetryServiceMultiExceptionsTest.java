package com.narayanatutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.narayanatutorial.multiexceptions.RetryServiceMultiExceptions;

@SpringBootTest
public class RetryServiceMultiExceptionsTest {

	@Autowired
	RetryServiceMultiExceptions retryServiceMultiExceptions;
	
	@Test
	public void retryPossibleExceptionOccured() {
		retryServiceMultiExceptions.retryWhenSpecificExceptionOccured();
	}
}
