package com.andrewclam.composite;

/**
 * Abstract API for composite member Node and Leaf, in this case the Leaf will be
 * the each menu item, and the Node will be the menu.
 * For reference see Pg 368
 *
 * Note: seems hackish to have an abstract class that just returns exceptions,
 * isn't there a better way to do this for this to be considered a pattern?
 */
public abstract class MenuComponent {

  /**
   * Composite method
   * Adds a component Leaf to a composite Node
   * @param component Leaf to be added
   */
  public void add (MenuComponent component){
    throw new UnsupportedOperationException();
  }

  /**
   * Composite method
   * Remove an existing component Leaf from a composite Node
   * @param component Leaf to be plucked
   */
  public void remove (MenuComponent component){
    throw new UnsupportedOperationException();
  }

  /**
   * Composite method
   * Find an existing component Leaf within a composite Node by index
   * @param index the index of the Leaf within a Node collection
   * @return the particular Leaf client is looking for by index
   */
  public MenuComponent getChild (int index) {
    throw new UnsupportedOperationException();
  }

  /**
   * @return the name of the leaf/node
   */
  String getName(){
    throw new UnsupportedOperationException();
  }

  /**
   * @return the description of the leaf/node
   */
  String getDescription(){
    throw new UnsupportedOperationException();
  }

  /**
   * @return the price of the leaf/node
   */
  double getPrice(){
    throw new UnsupportedOperationException();
  }

  /**
   * @return whether the leaf/node is vegetarian
   */
  boolean isVegetarian(){
    throw new UnsupportedOperationException();
  }

  /**
   * @return prints leaf/node's description
   */
  public String print(){
    throw new UnsupportedOperationException();
  }
}
