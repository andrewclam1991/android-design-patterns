package com.andrewclam.state;

class SoldState implements State {
  private GumballMachine mGumballMachine;

  SoldState(GumballMachine gumballMachine){ this.mGumballMachine = gumballMachine; }

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
