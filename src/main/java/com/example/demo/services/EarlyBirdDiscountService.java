package com.example.demo.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EarlyBirdDiscountService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public double calculateDiscount(String bookingDateStr, String eventDateStr) throws ParseException {

        try {
            Date bookingDate = dateFormat.parse(bookingDateStr);
            Date eventDate = dateFormat.parse(eventDateStr);

            long differenceInMillis = eventDate.getTime() - bookingDate.getTime();
            long differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24);

            if(differenceInDays>30 ){
                return 0.15;
            }else {
                return 0.0;
            }
        }
        catch  (ParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Use 'yyyy-MM-dd'.");
        }
    }
}
