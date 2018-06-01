package com.andrewclam.state;

class NoQuarterState implements State {
  private GumballMachine mGumballMachine;

  NoQuarterState(GumballMachine gumballMachine){ mGumballMachine = gumballMachine; }

  @Override
  public void insertQuarter() {

  }

  @Override
  public void ejectQuarter() {

  }

  @Override
  public void turnCrank() {

  }

  @Override
  public void dispense() {

  }
}
