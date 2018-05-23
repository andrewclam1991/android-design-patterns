package com.andrewclam.composite;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Composite menu class, designed to be a Composite Node to hold a
 * collection of {@link MenuItem}s (Leaves) or other {@link Menu}s (Nodes)
 */
public class Menu extends MenuComponent {
  @NonNull
  private final List<MenuComponent> menuComponents;

  @NonNull
  private final String name;

  @NonNull
  private final String description;

  public Menu(@NonNull String name,
              @NonNull String description){
    this.name = name;
    this.description = description;
    this.menuComponents = new ArrayList<>();
  }

  @Override
  public void add(MenuComponent component) {
    menuComponents.add(component);
  }

  @Override
  public void remove(MenuComponent component) {
    menuComponents.remove(component);
  }

  @Override
  public MenuComponent getChild(int index) {
    return menuComponents.get(index);
  }

  @NonNull
  @Override
  String getName() {
    return name;
  }

  @NonNull
  @Override
  String getDescription() {
    return description;
  }

  @Override
  public String print() {
    return toString();
  }

  /**
   * Recursively get all children nodes and leaves' descriptions starting
   * from a particular root.
   *
   * TODO Note: Potentially single huge string, consider o emit each description in meaningful chunks
   * @return full print-out of this {@link Menu} each {@link MenuComponent}'s
   * descriptions.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("\n %s",getName()));
    sb.append(String.format(", %s",getDescription()));
    sb.append("------------------------------------\n");

    /*
    * NOTE: If during this iteration we encounter another Menu object,
    * its print() method will start another iteration, and so on.
    */
    for (MenuComponent menuComponent : menuComponents) {
      sb.append(menuComponent.print());
    }
    return sb.toString();
  }
}
