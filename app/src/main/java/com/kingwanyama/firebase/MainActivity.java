package com.kingwanyama.firebase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText input_name, input_email, input_age;
    ProgressDialog progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_name = findViewById(R.id.inputName);
        input_email = findViewById(R.id.inputEmail);
        input_age = findViewById(R.id.inputAge);
    }

    public void save(View view) {
        String names = input_name.getText().toString();
        String email = input_email.getText().toString();
        String age = input_age.getText().toString();
        progress = new ProgressDialog(this);
        progress.setMessage("Saving...");

        if (names.isEmpty()||email.isEmpty()||age.isEmpty())
        {
            Toast.makeText(this, "Fill in all the Inputs", Toast.LENGTH_SHORT).show();
            return;
        }
        long time = System.currentTimeMillis();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Names/"+time);
        User x = new User(names,email,age);
        progress.show();
        ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progress.dismiss();
                if (task.isSuccessful())
                {
                    input_name.setText("");
                    input_email.setText("");
                    input_age.setText("");
                }else
                    {
                        Toast.makeText(MainActivity.this, "Failed. Try Again", Toast.LENGTH_SHORT).show();
                    }
            }
        });



    }

    public void fetch(View view) {
        Intent intent = new Intent(getApplicationContext(),UsersActivity.class);
        startActivity(intent);
    }
}
