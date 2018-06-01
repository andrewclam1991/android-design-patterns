package com.andrewclam.state;

class HasQuarterState implements State {
  private GumballMachine mGumballMachine;

  HasQuarterState(GumballMachine gumballMachine){ this.mGumballMachine = gumballMachine; }

  @Override
  public void insertQuarter() {
    mGumballMachine.setResponse("You can't insert another quarter!");
  }

  @Override
  public void ejectQuarter() {
    mGumballMachine.setResponse("Here is your money back.");
    mGumballMachine.setState(mGumballMachine.getNoQuarterState());
  }

  @Override
  public void turnCrank() {
    mGumballMachine.setResponse("You turned...");
    mGumballMachine.setState(mGumballMachine.getSoldState());
  }

  @Override
  public void dispense() {
    mGumballMachine.setResponse("No gumball dispensed");
  }
}
