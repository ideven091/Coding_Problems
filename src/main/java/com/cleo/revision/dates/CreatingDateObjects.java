package com.cleo.revision.dates;

import java.time.Clock;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class CreatingDateObjects {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(22,Calendar.MARCH,4);
        Date today = calendar.getTime();
        System.out.println(today);
        System.out.println(calendar.getTime());
        Instant instant = Instant.now();
        Instant instant1 = Instant.now(Clock.systemUTC());
        System.out.println(instant+ " "+ instant1);

    }
}
