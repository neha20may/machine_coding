package com.example.uber.solution.cabbooking.strategies;

import com.example.uber.solution.cabbooking.model.Location;

public interface PricingStrategy {
  Double findPrice(Location fromPoint, Location toPoint);
}
