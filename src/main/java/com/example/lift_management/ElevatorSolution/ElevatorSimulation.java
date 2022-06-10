package com.example.lift_management.ElevatorSolution;

import com.example.lift_management.ElevatorSolution.model.Elevator;
import com.example.lift_management.ElevatorSolution.model.ElevatorControlSystem;

//import elevator.impl.Elevator;
//import elevator.impl.ElevatorControlSystem;

/**
 * Created by Arun Singh on 4/3/16.
 */
public class ElevatorSimulation {

    public static void main(String[] args) {

        ElevatorControlSystem elevatorControlSystem = new ElevatorControlSystem(2);
        for(int i = 1; i <= 5; i++){
            elevatorControlSystem.pickUpRequest(i);
        }

        System.out.println("*** Request Distribution ***");
        for(Elevator elevator : elevatorControlSystem.getElevators()){
            System.out.println("Elevator[" + elevator.getId() + "] - " + elevator.getTotalRequests());
        }

        System.out.println("------------------------");

        System.out.println("*** Stepping simulation ***");
        while(elevatorControlSystem.getActiveRequests() > 0){
            elevatorControlSystem.step();
            for(Elevator elevator : elevatorControlSystem.getElevators()){
                System.out.println("Elevator[" + elevator.getId() + "] - Current Floor " + elevator.getCurrentFloor());
            }
        }
    }
}
