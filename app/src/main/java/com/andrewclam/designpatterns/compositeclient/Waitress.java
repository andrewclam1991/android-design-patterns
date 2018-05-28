package com.andrewclam.designpatterns.compositeclient;

import com.andrewclam.composite.MenuComponent;

/**
 * Client class that uses the Composite {@link MenuComponent}
 */
public class Waitress {
  MenuComponent allMenus;

  public Waitress(MenuComponent allMenus){
    this.allMenus = allMenus;
  }

  public String printMenu(){
    return allMenus.print();
  }
}
