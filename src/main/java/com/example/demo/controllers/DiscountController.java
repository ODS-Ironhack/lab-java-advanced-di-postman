package com.example.demo.controllers;

import com.example.demo.services.EarlyBirdDiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DiscountController {
    @Nullable
    private final EarlyBirdDiscountService earlyBirdDiscountService;

    @GetMapping("/discount")
    public ResponseEntity<?> calculateDiscountedPrice(
            @RequestParam("eventDate") String eventDate,
            @RequestParam("bookingDate") String bookingDate) throws ParseException {

        if (earlyBirdDiscountService == null) {
            return ResponseEntity.status(503).body("El servicio de descuento no está habilitado.");
        }


        double discount = earlyBirdDiscountService.calculateDiscount(bookingDate, eventDate);

        return ResponseEntity.ok(discount);
    }
}
