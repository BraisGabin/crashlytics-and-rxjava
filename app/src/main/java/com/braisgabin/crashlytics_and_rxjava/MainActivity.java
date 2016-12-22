package com.braisgabin.crashlytics_and_rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import rx.Observable;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Observable.just("hello")
            .map(new Func1<String, String>() {
              @Override
              public String call(String s) {
                throw new RuntimeException("Report this to Crashlytics, please!");
              }
            })
            .subscribe();
      }
    });
  }
}
