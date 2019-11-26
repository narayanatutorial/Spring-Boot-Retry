package com.narayanatutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

import com.narayanatutorial.fixeddelay.RetryServiceMaxAttemptsFixedDelay;
import com.narayanatutorial.maxattempts.RetryServiceMaxAttempts;
import com.narayanatutorial.multiexceptions.RetryServiceMultiExceptions;

@SpringBootApplication
@EnableRetry
public class SpringBootRetryApplication implements CommandLineRunner {

	@Autowired
	RetryServiceMaxAttempts retryServiceMaxAttempts;
	
	@Autowired
	RetryServiceMaxAttemptsFixedDelay  retryServiceMaxAttemptsFixedDelay;
	
	@Autowired
	RetryServiceMultiExceptions retryServiceMultiExceptions;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRetryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//calling  retryServiceMaxAttempts
		//retryServiceMaxAttempts.sampleRetry();
		
		//calling  retryServiceMaxAttemptsFixedDelay
		//retryServiceMaxAttemptsFixedDelay.sampleRetry();
		
		//multi exceptions retry
		//retryServiceMultiExceptions.retryWhenSpecificExceptionOccured();

	}

}
