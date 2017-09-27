package com.example.josedeita.heylisten;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    //private TextView mTextMessage;
    public static final String HOME_TAG = "home";
    public static final String FRIENDS_LIST_TAG = "friends";
    public static final String SETTINGS_TAG = "settings";
  
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);
            switch (item.getItemId()) {
                case R.id.navigation_settings:
                    //mTextMessage.setText(R.string.title_home);
                    if(fragment!=null && fragment.getTag()!= SETTINGS_TAG){
                      removeFragment(fragment);
                      addSettingsFragment();
                    }
                    return true;
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_dashboard);
                    if(fragment!=null && fragment.getTag()!= HOME_TAG){
                      removeFragment(fragment);
                      addHomeFragment();
                    }
                    return true;
                case R.id.navigation_friends_list:
                    //mTextMessage.setText(R.string.title_notifications);
                    if(fragment!=null && fragment.getTag()!=FRIENDS_LIST_TAG){
                      removeFragment(fragment);
                      addFriendsListFragment();
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
        navigation.setSelectedItemId(R.id.navigation_home);
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
  
    public void addSettingsFragment(){
      SettingsFragment fragment = new SettingsFragment();
      getSupportFragmentManager()
          .beginTransaction()
          .add(R.id.fragment_container, fragment, SETTINGS_TAG)
          .commit();
    }
    
    public void addFriendsListFragment(){
      FriendsFragment fragment = new FriendsFragment();
      getSupportFragmentManager()
          .beginTransaction()
          .add(R.id.fragment_container, fragment, FRIENDS_LIST_TAG)
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
