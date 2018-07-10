package com.example.chayen.pincodesample;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.register_pin);
        if (fragment instanceof ConfirmPINCode == false) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.register_pin, CreatePINCode.newInstance(), "Create PIN code page")
                    .addToBackStack(null)
                    .commit();
        }else Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
    }
}
