package com.example.parkinglot.sol2.src.commands;

import com.example.parkinglot.sol2.src.OutputPrinter;
import com.example.parkinglot.sol2.src.model.Command;
import com.example.parkinglot.sol2.src.service.ParkingLotService;
import com.example.parkinglot.sol2.src.validator.IntegerValidator;

import java.util.List;

/**
 * Executor to handle command of freeing of slot from a car.
 */
public class LeaveCommandExecutor extends CommandExecutor {
  public static String COMMAND_NAME = "leave";

  public LeaveCommandExecutor(final ParkingLotService parkingLotService,
      final OutputPrinter outputPrinter) {
    super(parkingLotService, outputPrinter);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean validate(final Command command) {
    final List<String> params = command.getParams();
    if (params.size() != 1) {
      return false;
    }
    return IntegerValidator.isInteger(params.get(0));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void execute(final Command command) {
    final int slotNum = Integer.parseInt(command.getParams().get(0));
    parkingLotService.makeSlotFree(slotNum);
    outputPrinter.printWithNewLine("Slot number " + slotNum + " is free");
  }
}
