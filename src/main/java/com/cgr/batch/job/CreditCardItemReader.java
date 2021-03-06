package com.cgr.batch.job;

import com.cgr.batch.domain.CreditCard;
import com.cgr.batch.repository.CreditCardRepository;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

public class CreditCardItemReader implements ItemReader<CreditCard> {

    @Autowired
    private CreditCardRepository respository;

    private Iterator<CreditCard> usersIterator;

    @BeforeStep
    public void before(StepExecution stepExecution) {
        usersIterator = respository.findAll().iterator();
    }

    @Override
    public CreditCard read() {
        if (usersIterator != null && usersIterator.hasNext()) {
            return usersIterator.next();
        } else {
            return null;
        }
    }
}
