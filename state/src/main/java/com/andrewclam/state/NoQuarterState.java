package com.andrewclam.state;

class NoQuarterState implements State {
  private GumballMachine mGumballMachine;

  NoQuarterState(GumballMachine gumballMachine){ mGumballMachine = gumballMachine; }

  @Override
  public void insertQuarter() {
    mGumballMachine.setResponse("Quarter inserted");
    mGumballMachine.setState(mGumballMachine.getHasQuarterState());
  }

  @Override
  public void ejectQuarter() {
    mGumballMachine.setResponse("No quarter to return!");
  }

  @Override
  public void turnCrank() {
    mGumballMachine.setResponse("No quarter, no gumball");
  }

  @Override
  public void dispense() {
    mGumballMachine.setResponse("No quarter, no gumball");
  }
}
