package org.example;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Dollar treefiddy = new Dollar(3, 50);
        String flDesc = "A description of the record";
        GregorianCalendar flReleaseDate = new GregorianCalendar(2023, Calendar.NOVEMBER, 2);
        Vinyl gv = new Vinyl("Fruit LoOops", "You're Somebody's World", "TL072", treefiddy, flDesc,
                30, flReleaseDate, Vinyl.RotationSpeed.RPM33, Vinyl.DiscSize.TWELVE);

        System.out.println(gv.toString());

    }
}