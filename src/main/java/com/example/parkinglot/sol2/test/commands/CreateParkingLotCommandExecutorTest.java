package com.example.parkinglot.sol2.test.commands;

import com.example.parkinglot.sol2.src.OutputPrinter;
import com.example.parkinglot.sol2.src.commands.CreateParkingLotCommandExecutor;
import com.example.parkinglot.sol2.src.model.Command;
import com.example.parkinglot.sol2.src.model.ParkingLot;
import com.example.parkinglot.sol2.src.model.parking.strategy.NaturalOrderingParkingStrategy;
import com.example.parkinglot.sol2.src.service.ParkingLotService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateParkingLotCommandExecutorTest {
  private ParkingLotService parkingLotService;
  private OutputPrinter outputPrinter;
  private CreateParkingLotCommandExecutor createParkingLotCommandExecutor;

  @Before
  public void setUp() throws Exception {
    parkingLotService = mock(ParkingLotService.class);
    outputPrinter = mock(OutputPrinter.class);
    createParkingLotCommandExecutor =
        new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter);
  }

  @Test
  public void testValidCommand() {
    assertTrue(createParkingLotCommandExecutor.validate(new Command("create_parking_lot 6")));
  }

  @Test
  public void testInvalidCommand() {
    assertFalse(createParkingLotCommandExecutor.validate(new Command("create_parking_lot")));
    assertFalse(createParkingLotCommandExecutor.validate(new Command("create_parking_lot abcd")));
  }

  @Test
  public void testCommandExecution() {
    createParkingLotCommandExecutor.execute(new Command("create_parking_lot 6"));

    final ArgumentCaptor<ParkingLot> argument = ArgumentCaptor.forClass(ParkingLot.class);
    verify(parkingLotService)
        .createParkingLot(argument.capture(), any(NaturalOrderingParkingStrategy.class));
    assertEquals(6, argument.getValue().getCapacity());
    verify(outputPrinter).printWithNewLine("Created a parking lot with 6 slots");
  }
}
