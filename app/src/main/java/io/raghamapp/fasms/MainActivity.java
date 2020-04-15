package io.raghamapp.fasms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.raghamapp.fasms.R;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.RECEIVE_SMS)!=getPackageManager().PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS},1000);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();

    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==1000)
        {
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "success permition ", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "dont success ", Toast.LENGTH_SHORT).show();
                finish();
            }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
