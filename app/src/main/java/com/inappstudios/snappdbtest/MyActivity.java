package com.inappstudios.snappdbtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.snappydb.DB;
import com.snappydb.DBFactory;

import java.util.Date;


public class MyActivity extends Activity {

    private static final String TAG = "SnappyDBTest";
    Button saveToDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        saveToDb = (Button) findViewById(R.id.btnSave);
        saveToDb.setOnClickListener(clickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btnSave) {

                Log.d(TAG, "creating dummy users");

                User user1 = new User();
                user1.setUserFBId("dummyID 1");
                user1.setRegistrationStatus("PROCESSING");
                user1.setRegisteredOnDate(new Date());

                UserBasicInfo user2 = new UserBasicInfo();
                user2.setUserFBId("dummyID 2");
                user2.setRegistrationStatus("PROCESSING");
                user2.setRegisteredOnDate(new Date());

                user2.setEmailId("dummy@test.com");
                user2.setUserName("Cool Name");

                try {
                    DB db = DBFactory.open(getApplication()); //create or open an existing databse using the default name

                    Log.d(TAG, "Trying to save user to DB");

                    db.put("USER_OBJ", user1);
                    db.put("USER_OBJ", user2);

                    db.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
