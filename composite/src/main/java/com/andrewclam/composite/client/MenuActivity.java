package com.andrewclam.composite.client;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.andrewclam.composite.Menu;
import com.andrewclam.composite.MenuComponent;
import com.andrewclam.composite.MenuItem;
import com.andrewclam.composite.R;

/**
 * Example client of that demonstrates the use of
 * {@link MenuComponent} Composite Pattern
 */
public class MenuActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.composite_activity_menu);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });

    Toast.makeText(this,test(),Toast.LENGTH_LONG).show();
  }

  private String test(){
    // Individual Composite Menu
    MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
    MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
    MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
    MenuComponent yogurtLandMenu = new Menu("YOGURTLAND MENU", "Dessert");

    // Composite Menu (root)
    MenuComponent allMenus = new Menu("MEGA COMPOSITE MENU", "All menus combined");
    allMenus.add(pancakeHouseMenu);
    allMenus.add(dinerMenu);
    allMenus.add(cafeMenu);
    allMenus.add(yogurtLandMenu);

    // Add Menu items
    pancakeHouseMenu.add(new MenuItem(
        "Unforgettable ultra stacks",
        "Nice and rich full of chocolate and stuff",
        false,
        12.5));

    // Create client waitress and have her print out the menus
    Waitress waitress = new Waitress(allMenus);
    return waitress.printMenu();
  }

}
