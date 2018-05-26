package com.andrewclam.designpatterns;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andrewclam.composite.client.CompositeActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.composite_activity_menu);
    launchCompositeExample();
  }

  private void launchCompositeExample(){
    Intent intent = new Intent(this, CompositeActivity.class);
    startActivity(intent);
  }
}
