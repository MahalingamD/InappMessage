package com.maha.inappmessage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appindexing.Action;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.FirebaseUserActions;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.appindexing.builders.Actions;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
   public static final String TAG = MainActivity.class.getSimpleName();

   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_main );
      Log.e( TAG, "onCreate: " );
      FirebaseApp.initializeApp( MainActivity.this );


      String refreshedToken = FirebaseInstanceId.getInstance().getToken();

      if( refreshedToken != null )
         Log.e( "TOKEN", refreshedToken );

      // ATTENTION: This was auto-generated to handle app links.
      Intent appLinkIntent = getIntent();
      String appLinkAction = appLinkIntent.getAction();
      Uri appLinkData = appLinkIntent.getData();
   }

   /**
    * ATTENTION: This was auto-generated to implement the App Indexing API.
    * See https://g.co/AppIndexing/AndroidStudio for more information.
    */
   public Action getIndexApiAction() {
      return Actions.newView( "Main", "https://www.angleritech.com" );
   }

   @Override
   public void onStart() {
      super.onStart();

      Log.e( TAG, "onStart: " );

      // ATTENTION: This was auto-generated to implement the App Indexing API.
      // See https://g.co/AppIndexing/AndroidStudio for more information.
      FirebaseAppIndex.getInstance().update( new Indexable.Builder().setName( "Main" ).setUrl( "https://www.angleritech.com" ).build() );
      FirebaseUserActions.getInstance().start( getIndexApiAction() );
   }

   @Override
   public void onStop() {

      // ATTENTION: This was auto-generated to implement the App Indexing API.
      // See https://g.co/AppIndexing/AndroidStudio for more information.
      FirebaseUserActions.getInstance().end( getIndexApiAction() );
      super.onStop();
   }
}
