package com.andrewclam.composite;

import java.util.Iterator;

/**
 * Null iterator where it doesn't contain any elements
 * and signals as such with hasNext() returns a constant "false"
 */
public class NullIterator implements Iterator<MenuComponent>{
  NullIterator(){ }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public MenuComponent next() {
    return null;
  }
}
