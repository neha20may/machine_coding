package com.example.uber.solution.cabbooking.strategies;

import com.example.uber.solution.cabbooking.model.Cab;
import com.example.uber.solution.cabbooking.model.Location;
import com.example.uber.solution.cabbooking.model.Rider;
import java.util.List;

public interface CabMatchingStrategy {

  Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);
}
