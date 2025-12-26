package com.organization.rates;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing rates logic.
 */
@Service
public class RateService {
    private final List<Rate> rates = new ArrayList<>();

    public Rate createRate(Rate rate) {
        rate.setId((long) (rates.size() + 1)); // Simple ID generation
        rates.add(rate);
        return rate;
    }

    public List<Rate> getAllRates() {
        return rates;
    }

    public Rate updateRate(Long id, Rate rate) {
        Rate existingRate = rates.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
        if (existingRate != null) {
            existingRate.setName(rate.getName());
            existingRate.setValue(rate.getValue());
            existingRate.setType(rate.getType());
            existingRate.setUpdatedAt(rate.getUpdatedAt());
        }
        return existingRate;
    }

    public void deleteRate(Long id) {
        rates.removeIf(rate -> rate.getId().equals(id));
    }
}