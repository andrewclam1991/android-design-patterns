package com.andrewclam.composite;

/**
 * Implementation of a {@link MenuComponent} that
 * represents each item within a menu (composite)
 */
public class MenuItem extends MenuComponent {
  private String name;
  private String description;
  private boolean vegetarian;
  private double price;

  public MenuItem(String name,
                  String description,
                  boolean vegetarian,
                  double price)
  {
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public void setVegetarian(boolean vegetarian) {
    this.vegetarian = vegetarian;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * @return calls toString()
   */
  @Override
  public String print(){
    return toString();
  }

  /**
   * @return readable description and price of this particular
   * menu item
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getName());
    if (isVegetarian()){ sb.append("(veg)"); }
    sb.append(String.format(",%s", getPrice()));
    sb.append(String.format("  -- %s", getDescription()));
    return sb.toString();
  }
}
