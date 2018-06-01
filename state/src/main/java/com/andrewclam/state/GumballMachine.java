package com.andrewclam.state;

import com.sun.istack.internal.NotNull;

public class GumballMachine implements State{
  private State soldOutState;
  private State noQuarterState;
  private State hasQuarterState;
  private State soldState;

  private State currentState;
  private int count = 0;

  private String response;

  public GumballMachine(int numGumballs){
    soldOutState = new SoldOutState(this);
    noQuarterState = new NoQuarterState(this);
    hasQuarterState = new HasQuarterState(this);
    soldState = new SoldState(this);

    this.count = numGumballs;
    if (numGumballs > 0) { currentState = noQuarterState; }
    else                 { currentState = soldOutState; }
  }

  @Override
  public void insertQuarter() {
    currentState.insertQuarter();
  }

  @Override
  public void ejectQuarter() {
    currentState.ejectQuarter();
  }

  @Override
  public void turnCrank() {
    currentState.turnCrank();
    currentState.dispense();
  }

  @Override
  public void dispense() {
    throw new UnsupportedOperationException("Client can't call dispense directly.");
  }

  public State getSoldOutState() {
    return soldOutState;
  }

  public State getNoQuarterState() {
    return noQuarterState;
  }

  public State getHasQuarterState() {
    return hasQuarterState;
  }

  public State getSoldState() {
    return soldState;
  }

  public State getCurrentState() {
    return currentState;
  }

  public int getCount() {
    return count;
  }

  /**
   * Allows internal {@link State} to be updated with a compatible new state
   * @param newState the {@link State} that is to be set as the new current state
   */
  public void setState (State newState){
    this.currentState = newState;
  }

  /**
   * Sets the most current response of an action.
   * @param response response from the current state after an action is performed
   */
  public void setResponse(@NotNull String response){

  }

  /**
   * @return the current response of the most recent state-change action.
   */
  public String getResponse(){ return response; }
}
