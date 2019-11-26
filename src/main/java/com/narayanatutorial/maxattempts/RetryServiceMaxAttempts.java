package com.narayanatutorial.maxattempts;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryServiceMaxAttempts {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetryServiceMaxAttempts.class);

    int counter =0;

    @Retryable(value = { SQLException.class }, maxAttempts = 3)
    public String sampleRetry() throws SQLException {

        counter++;

        LOGGER.info("RetryServiceMaxAttempts Failed "+ counter);

        throw new SQLException();

    }

    @Recover
    public String sampleRecover(SQLException t){

        LOGGER.info("RetryServiceMaxAttempts recovering");

        return "Service recovered from RetryServiceMaxAttempts service failure.";

    }
}
