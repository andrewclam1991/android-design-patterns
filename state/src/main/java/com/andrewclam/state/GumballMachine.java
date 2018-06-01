package com.andrewclam.state;

import com.sun.istack.internal.NotNull;

/**
 * Example implementation of an object that is allowed to alter its behavior
 * when its internal state changes such that the object will appear to
 * have changed its class.
 */
public class GumballMachine implements State{
  // Possible states that this gumball machine can be in
  private State soldOutState;
  private State noQuarterState;
  private State hasQuarterState;
  private State soldState;

  // Instance to track the last known state
  private State currentState;

  // Tracks number of gumball that the machine currently holds
  // starts with 0
  private int count = 0;

  // Response msg
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
  public void setResponse(@NotNull String response){ this.response = response; }

  /**
   * @return the current response of the most recent state-change action.
   */
  public String getResponse(){ return response; }
}
