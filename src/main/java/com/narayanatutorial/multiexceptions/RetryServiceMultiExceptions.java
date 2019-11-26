package com.narayanatutorial.multiexceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;


@Service
public class RetryServiceMultiExceptions {
	private static final Logger LOGGER = LoggerFactory.getLogger(RetryServiceMultiExceptions.class);

	private static int COUNTER = 0;

	@Retryable(value = { TypeOneException.class, TypeTwoException.class },maxAttempts = 4, backoff = @Backoff(delay = 2000))
	public String retryWhenSpecificExceptionOccured() throws TypeOneException, TypeTwoException {

		COUNTER++;

		LOGGER.info("COUNTER = " + COUNTER);

		if (COUNTER == 1)
			throw new TypeOneException();
		else if (COUNTER == 2)
			throw new TypeTwoException();
		else
			throw new RuntimeException();

	}

	@Recover
	public String recover(Throwable t) {

		LOGGER.info("RetryServiceMultiExceptions.recover");

		return "Error Class :: " + t.getClass().getName();

	}
}
