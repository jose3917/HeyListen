package com.example.josedeita.heylisten;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private TextView mTextMessage;
    public static final String HOME_TAG = "home";
    public static final String DASHBOARD_TAG = "dashboard";
    public static final String NOTIFICATIONS_TAG = "notifications";
  
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    if(fragment!=null && fragment.getTag()!= HOME_TAG){
                      removeFragment(fragment);
                      addHomeFragment();
                    }
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    if(fragment!=null && fragment.getTag()!=DASHBOARD_TAG){
                      removeFragment(fragment);
                      addDashboardFragment();
                    }
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    if(fragment!=null && fragment.getTag()!=NOTIFICATIONS_TAG){
                      removeFragment(fragment);
                      addNotificationsFragment();
                    }
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        
        addHomeFragment();
            
    }
    
    public void addHomeFragment(){
      HomeFragment fragment = new HomeFragment();
      getSupportFragmentManager()
          .beginTransaction()
          .add(R.id.fragment_container, fragment, HOME_TAG)
          .commit();
    }
  
    public void addDashboardFragment(){
      DashboardFragment fragment = new DashboardFragment();
      getSupportFragmentManager()
          .beginTransaction()
          .add(R.id.fragment_container, fragment, DASHBOARD_TAG)
          .commit();
    }
    
    public void addNotificationsFragment(){
      NotificationsFragment fragment = new NotificationsFragment();
      getSupportFragmentManager()
          .beginTransaction()
          .add(R.id.fragment_container, fragment, NOTIFICATIONS_TAG)
          .commit();
    }
    
    public void removeFragment(Fragment fragment){
      if(fragment!=null){
        getSupportFragmentManager()
            .beginTransaction()
            .remove(fragment)
            .commit();
      }
    }

}
