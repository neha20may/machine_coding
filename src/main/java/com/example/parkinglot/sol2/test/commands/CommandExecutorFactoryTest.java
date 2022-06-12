package com.example.parkinglot.sol2.test.commands;

import com.example.parkinglot.sol2.src.commands.CommandExecutor;
import com.example.parkinglot.sol2.src.commands.CommandExecutorFactory;
import com.example.parkinglot.sol2.src.commands.LeaveCommandExecutor;
import com.example.parkinglot.sol2.src.exception.InvalidCommandException;
import com.example.parkinglot.sol2.src.model.Command;
import com.example.parkinglot.sol2.src.service.ParkingLotService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class CommandExecutorFactoryTest {

  private CommandExecutorFactory factory;

  @Before
  public void setUp() throws Exception {
    final ParkingLotService parkingLotService = mock(ParkingLotService.class);
    factory = new CommandExecutorFactory(parkingLotService);
  }

  @Test
  public void testFetchingExecutorForValidCommand() {
    final CommandExecutor commandExecutor = factory.getCommandExecutor(new Command("leave 1"));
    assertNotNull(commandExecutor);
    assertTrue(commandExecutor instanceof LeaveCommandExecutor);
  }

  @Test(expected = InvalidCommandException.class)
  public void testFetchingExecutorForInvalidCommand() {
    factory.getCommandExecutor(new Command("some-random-command random-param1 random-param2"));
  }
}
