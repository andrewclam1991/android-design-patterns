package com.andrewclam.state;

class SoldOutState implements State {
  private GumballMachine mGumballMachine;

  SoldOutState(GumballMachine gumballMachine){ mGumballMachine = gumballMachine; }

  @Override
  public void insertQuarter() {
    mGumballMachine.setResponse("No more inventory");
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
