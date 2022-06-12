package com.example.parkinglot.sol2.test.model.parking.strategy;

import com.example.parkinglot.sol2.src.exception.NoFreeSlotAvailableException;
import com.example.parkinglot.sol2.src.model.parking.strategy.NaturalOrderingParkingStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NaturalOrderingParkingStrategyTest {
  private NaturalOrderingParkingStrategy naturalOrderingParkingStrategy =
      new NaturalOrderingParkingStrategy();

  @Test
  public void testValidStrategyExecution() {
    naturalOrderingParkingStrategy.addSlot(1);
    naturalOrderingParkingStrategy.addSlot(2);
    naturalOrderingParkingStrategy.addSlot(3);
    assertEquals((Integer)1, naturalOrderingParkingStrategy.getNextSlot());
    naturalOrderingParkingStrategy.removeSlot(2);
    assertEquals((Integer)1, naturalOrderingParkingStrategy.getNextSlot());
    naturalOrderingParkingStrategy.removeSlot(1);
    assertEquals((Integer)3, naturalOrderingParkingStrategy.getNextSlot());
    naturalOrderingParkingStrategy.addSlot(2);
    assertEquals((Integer)2, naturalOrderingParkingStrategy.getNextSlot());
  }

  @Test(expected = NoFreeSlotAvailableException.class)
  public void testFullParkingStrategy() {
    Integer nextSlot = naturalOrderingParkingStrategy.getNextSlot();
  }
}
