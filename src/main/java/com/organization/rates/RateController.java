package com.organization.rates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller to manage rates.
 */
@RestController
@RequestMapping("/api/rates")
public class RateController {

    @Autowired
    private RateService rateService;

    @PostMapping
    public ResponseEntity<Rate> createRate(@RequestBody Rate rate) {
        Rate createdRate = rateService.createRate(rate);
        return ResponseEntity.ok(createdRate);
    }

    @GetMapping
    public ResponseEntity<List<Rate>> getAllRates() {
        List<Rate> rates = rateService.getAllRates();
        return ResponseEntity.ok(rates);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rate> updateRate(@PathVariable Long id, @RequestBody Rate rate) {
        Rate updatedRate = rateService.updateRate(id, rate);
        return ResponseEntity.ok(updatedRate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRate(@PathVariable Long id) {
        rateService.deleteRate(id);
        return ResponseEntity.noContent().build();
    }
}