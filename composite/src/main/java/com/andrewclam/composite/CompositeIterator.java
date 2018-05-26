package com.andrewclam.composite;

import android.support.annotation.NonNull;

import java.util.Iterator;
import java.util.Stack;

/**
 * Responsible for iterating (transversing) the whole list of {@link MenuComponent}s,
 * including {@link MenuComponent}s within the sub-trees
 */
public class CompositeIterator implements Iterator<MenuComponent> {
  Stack<Iterator<MenuComponent>> stack = new Stack<>(); // Stores a stack of component iterators

  public CompositeIterator(@NonNull Iterator<MenuComponent> iterator){ stack.push(iterator); }

  @Override
  public MenuComponent next() {
    if(hasNext()) {
      Iterator<MenuComponent> iterator = stack.peek();
      MenuComponent component = iterator.next();
      stack.push(component.createIterator());
      return component;
    }
    else{ return null; }
  }

  @Override
  public boolean hasNext() {
    if (stack.isEmpty())               { return false; }
    else{
      Iterator<MenuComponent> iterator = stack.peek();
      if (!iterator.hasNext())         { stack.pop(); return hasNext(); }
      else                             { return true; /* top iterator have the next item */ }
    }
  }
}
