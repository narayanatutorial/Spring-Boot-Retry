package com.narayanatutorial.fixeddelay;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryServiceMaxAttemptsFixedDelay {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetryServiceMaxAttemptsFixedDelay.class);

    int counter =0;

    @Retryable(value = { SQLException.class }, maxAttempts = 3,backoff = @Backoff(delay = 5000))
    public String sampleRetry() throws SQLException {

        counter++;

        LOGGER.info("RetryServiceMaxAttemptsFixedDelay Failed "+ counter);

        throw new SQLException();

    }

    @Recover
    public String sampleRecover(SQLException t){

        LOGGER.info("RetryServiceMaxAttemptsFixedDelay Service recovering");

        return "Service recovered from RetryServiceMaxAttemptsFixedDelay service failure.";

    }
}
