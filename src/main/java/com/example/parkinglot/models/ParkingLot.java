package com.example.parkinglot.models;

import com.example.parkinglot.constants.ParkingTicketStatus;
import com.example.parkinglot.constants.VehicleType;
import com.example.parkinglot.exceptions.ParkingFullException;
import com.example.parkinglot.models.account.Address;
import com.example.parkinglot.models.panel.EntrancePanel;
import com.example.parkinglot.models.panel.ExitPanel;
import com.example.parkinglot.models.spot.HandicappedSpot;
import com.example.parkinglot.models.spot.ParkingSpot;
import com.example.parkinglot.models.vehicle.Vehicle;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import static com.example.parkinglot.constants.ParkingSpotType.*;

public class ParkingLot {
    String id;
    private final AtomicLong counter = new AtomicLong();
    Address address;
    ParkingRate parkingRate;
    int handicapSpotCount;
    int compactSpotCount;
    int largeSptCount;
    int motorCount;
    int electricSpotCount;

    int maxCompCount;
    int maxMotorCount;
    int maxLargeCount;
    int maxElectricCount;
    int maxHandiCount;

    HashMap<String, EntrancePanel> entrancePanels;
    HashMap<String, ExitPanel> exitPanels;

    public HashMap<String, ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    HashMap<String, ParkingFloor> parkingFloors;

    HashMap<String, ParkingTicket> activeTickets;

    private static ParkingLot parkingLot = null;

    private ParkingLot() {
        // 1. initialize variables: read name, address and parkingRate from database
        // 2. initialize parking floors: read the parking floor map from database,
        //  this map should tell how many parking spots are there on each floor. This
        //  should also initialize max spot counts too.
        // 3. initialize parking spot counts by reading all active tickets from database
        // 4. initialize entrance and exit panels: read from database
        this.id = "Z sqaure parking lot";
        this.address = new Address("Kanpur", "BadaChauhara", "UP", "India");
        this.parkingFloors = getFloors();
        reinitialseSpotCount();


    }

    private void reinitialseSpotCount() {
        //read tickets and vehicle and initialise spots.
        activeTickets= new HashMap<>();
        ParkingTicket t1 = new ParkingTicket("1", new Date(2022, 5, 5),
                null, 100.50, ParkingTicketStatus.Active);
        ParkingTicket t2 = new ParkingTicket("2", new Date(2022, 5, 5),
                null, 100.50, ParkingTicketStatus.Active);
        ParkingTicket t3 = new ParkingTicket("3", new Date(2022, 5, 5),
                null, 100.50, ParkingTicketStatus.Active);
        ParkingTicket t4 = new ParkingTicket("4", new Date(2022, 5, 5),
                null, 100.50, ParkingTicketStatus.Active);
        ParkingTicket t5 = new ParkingTicket("5", new Date(2022, 5, 5),
                null, 100.50, ParkingTicketStatus.Active);
        activeTickets.put("1", t1);
        activeTickets.put("2", t2);
        activeTickets.put("3", t3);
        activeTickets.put("4", t4);
        activeTickets.put("5", t5);
        //TODO: Not sure how active tickets determine the current number of spots.
        //A ticket does not tell about vehicle and vehicle determines the ticket
        //Example of composition, a ticket can not stand without vehicle
        handicapSpotCount = 1;
        compactSpotCount = 1;
        largeSptCount = 1;
        motorCount = 1;
        electricSpotCount = 1;

    }

    private HashMap<String, ParkingFloor> getFloors() {
        String a[] = {"First", "Second", "Third"};
        HashMap<String, ParkingFloor> map = new HashMap<>();
        for (int i=0; i< a.length; i++) {
            String s=a[i];
            ParkingFloor pf = new ParkingFloorBuilder().setName(s).createParkingFloor();
            map.put(s, pf);
            addSpots(pf);
        }
        this.maxCompCount = compactSpotCount;
        this.maxLargeCount = largeSptCount;
        this.maxHandiCount = handicapSpotCount;
        this.maxMotorCount = motorCount;
        this.maxElectricCount = electricSpotCount;
        return map;
    }

    private void addSpots(ParkingFloor pf) {
        ParkingSpot spot;
        Random r = new Random();
        int max = 10, min = 1;
        int randomNo = r.nextInt(max - min) + min;
        this.handicapSpotCount += randomNo;
        for (int i = 1; i < randomNo; i++) {
            spot = new HandicappedSpot(Handicapped);
            pf.addParkingSpot(spot);
        }
        randomNo = r.nextInt(max - min) + min;
        this.compactSpotCount += randomNo;
        for (int i = 1; i < randomNo; i++) {
            spot = new HandicappedSpot(Large);
            pf.addParkingSpot(spot);
        }
        randomNo = r.nextInt(max - min) + min;
        this.compactSpotCount += randomNo;
        for (int i = 1; i < randomNo; i++) {
            spot = new HandicappedSpot(Compact);
            pf.addParkingSpot(spot);
        }
        this.motorCount += randomNo;
        randomNo = r.nextInt(max - min) + min;
        for (int i = 1; i < randomNo; i++) {
            spot = new HandicappedSpot(MotorBike);
            pf.addParkingSpot(spot);
        }
        randomNo = r.nextInt(max - min) + min;
        this.electricSpotCount += randomNo;
        for (int i = 1; i < randomNo; i++) {
            spot = new HandicappedSpot(Electric);
            pf.addParkingSpot(spot);
        }

    }

    public static ParkingLot getInstance() {
        if (parkingLot == null)
            parkingLot = new ParkingLot();
        return parkingLot;
    }

    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
        if (this.isFull(vehicle.getType())) {
            throw new ParkingFullException("Sorry, Parking is full.");
        }
        ParkingTicket ticket = new ParkingTicket(String.valueOf(counter.incrementAndGet()),
                new Date(), null, 0.0, ParkingTicketStatus.Active);
        vehicle.assignTicket(ticket);
        //floor to assign vehicle and ticket?
        saveInDb(ticket, vehicle);
        this.incrementSpotCount(vehicle.getType());
        ParkingFloor pf=chooseFloor();
        ParkingSpot spot=getSpot(pf, vehicle.getType());
        pf.assignVehicleToSpot(vehicle, spot);
        this.activeTickets.put(ticket.getTicketNumer(), ticket);
        return ticket;
    }

    private ParkingSpot getSpot(ParkingFloor pf, VehicleType type) {
        if (type == VehicleType.Truck || type == VehicleType.Van) {
            {
                if(pf.freeParkingSpots.get(Large)>0 || pf.freeParkingSpots.get(Compact)>0){

                }
            }
        }
        if (type == VehicleType.Motorbike) {
//            return motorCount >= maxMotorCount;
        }
        if (type == VehicleType.Car) {
//            return (compactSpotCount + largeSptCount > maxLargeCount + maxCompCount);
        }
        return null;
    }

    private void saveInDb(ParkingTicket ticket, Vehicle vehicle) {

    }

    public boolean isFull(VehicleType type) {
        if (type == VehicleType.Truck || type == VehicleType.Van) {
            return largeSptCount > maxLargeCount;
        }
        if (type == VehicleType.Motorbike) {
            return motorCount >= maxMotorCount;
        }
        if (type == VehicleType.Car) {
            return (compactSpotCount + largeSptCount > maxLargeCount + maxCompCount);
        }
        return false;
    }

    private boolean incrementSpotCount(VehicleType type) {
        //TODO: pattern for if-else if?
        if(type==VehicleType.Truck || type==VehicleType.Van)
        {
            largeSptCount++;
        }
        else if(type==VehicleType.Motorbike)
        {
            motorCount++;
        }
        else if(type==VehicleType.Car)
        {
            if(compactSpotCount< maxCompCount){
                {
                    compactSpotCount++;
                }
            }else{
                {
                    largeSptCount++;
                }
            }
        }
        else if(type== VehicleType.Electric){
            if(electricSpotCount< maxElectricCount)
            {
                electricSpotCount++;
            }
            else if(compactSpotCount<maxCompCount)
            {
                compactSpotCount++;
            }
            else
            {
                largeSptCount++;
            }
        }
        return true;
    }

    public boolean isFull() {
        for (String key : parkingFloors.keySet()) {
            if (!(parkingFloors.get(key)).isFull()) {
                return false;
            }
        }
        return true;
    }

    public ParkingFloor chooseFloor() {
        //TODO: stargtegy to choose floor
        for (String key : parkingFloors.keySet()) {
            if (!(parkingFloors.get(key)).isFull()) {
                return parkingFloors.get(key);
            }
        }
        return null;
    }

    public void addFloor(ParkingFloor pf) {

    }

    public void addEntrancePanel(EntrancePanel ep) {

    }

    public void addExitPanel(ExitPanel ep) {

    }


}
