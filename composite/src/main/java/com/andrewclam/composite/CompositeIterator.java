package com.andrewclam.composite;

import android.support.annotation.NonNull;

import java.util.Iterator;
import java.util.Stack;

/**
 * Responsible for iterating (transversing) the whole list of {@link MenuComponent}s,
 * including {@link MenuComponent}s within the sub-trees
 */
public class CompositeIterator implements Iterator<MenuComponent> {
  // Stack data structure to store a list of iterator in memory,
  // this is a CompositeIterator after all.
  Stack<Iterator<MenuComponent>> stack = new Stack<>();

  public CompositeIterator(@NonNull Iterator<MenuComponent> iterator){ stack.push(iterator); }

  @Override
  public MenuComponent next() {
    /*
     * If this CompositeIterator has another iterator in the stack
     *  - peek() at the iterator stack without popping it off.
     *  - get the next component from the top iterator stack.
     *  - get the component's iterator and push it down the stack.
     *  - then return this component.
     * else
     *  - CompositeIterator has nothing in stack, return null.
     */

    if(hasNext()) {
      Iterator<MenuComponent> iterator = stack.peek();
      MenuComponent component = iterator.next();
      stack.push(component.createIterator());
      return component;
    }
    else{ return null; }
  }

  /**
   * Determines if this iterator has another element next
   * @return whether iteration can continue traversing through the tree.
   */
  @Override
  public boolean hasNext() {
    // Check if the CompositeIterator has iterators in stack
    if (stack.isEmpty())               { return false; }
    else{
      // peek() at the iterator stack without popping it off.
      Iterator<MenuComponent> iterator = stack.peek();
      // if such iterator is empty, pop it off and calls self *recursively*
      // until either stack is empty
      // or iterator is not empty
      if (!iterator.hasNext())         { stack.pop(); return hasNext(); }
      // else, iterator has something, signal true
      else                             { return true; /* top iterator have the next item */ }
    }
  }
}
