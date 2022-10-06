package com.example.parkinglot.parkinglot.parkingStrategy;

import com.example.parkinglot.parkinglot.*;
import com.example.parkinglot.parkinglot.enums.VehicleType;
import com.example.parkinglot.parkinglot.exceptions.ParkingSpaceFullException;
import com.example.parkinglot.parkinglot.gates.Coordinate;
import com.example.parkinglot.parkinglot.gates.Gate;
import lombok.var;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NearestParkingStrategy extends ParkingStrategy {
    Gate entranceGate;

    @Override
    public void removeSpot(Spot spot) {
        pq.remove(spot);
    }

    public NearestParkingStrategy(ParkingSpotManager pm, Gate entranceGate) {
        super(pm);
        this.entranceGate= entranceGate;
        this.pq = new PriorityQueue<Spot>(new Comparator<Spot>() {
            @Override
            public int compare(Spot o1, Spot o2) {
                Coordinate gateCoord = entranceGate.getCd();
                var o1Dist= diff(o1.getCod(), gateCoord);
                var o2dist= diff(o2.getCod(), gateCoord);
                if(o1Dist <= o2dist)
                    return 1;
                else return 0;

            }
        });
        //filter and add
        for(var spt: pm.getSpots()){
            if(spt.isFree())
                pq.add(spt);
        }

    }

    @Override
    public void addSpot(Spot spot) {
        pq.add(spot);
    }

    private double diff(Coordinate cod, Coordinate gateCoord) {
        //L2
        int xd= cod.getX() - gateCoord.getX();
        int yd= cod.y- gateCoord.y;
        double r = Math.sqrt(xd*xd + yd*yd);
        return r;

    }


    PriorityQueue<Spot> pq;
    @Override
    public Spot getSpot(VehicleType vt) throws ParkingSpaceFullException {
        List<Spot> spots= pm.getSpots();

        return pq.peek();

    }
}
