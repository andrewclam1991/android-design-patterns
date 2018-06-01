package com.andrewclam.state;

/**
 * API of a state machine, contains all possible actions that could affect
 * the state of the machine.
 */
public interface State {
  void insertQuarter();
  void ejectQuarter();
  void turnCrank();
  void dispense();
}
