package com.app.wecare.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserIdGenerator implements IdentifierGenerator {

    private static int counter = 100;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "user";
        int id = counter++;
        LocalDateTime localDate = LocalDateTime.now();
        return (prefix + localDate.getDayOfMonth() + localDate.getMonthValue() + localDate.getYear()
                + localDate.getHour() + localDate.getMinute() + id);
    }
}
