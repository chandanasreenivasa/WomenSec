package com.example.chandanasrinivas.womensec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button nName;

    EditText name,emailId,phone;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("Users");
    user uc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nName = (Button) findViewById(R.id.submit);
        name = (EditText)findViewById(R.id.name);
        emailId = (EditText)findViewById(R.id.emailid);
        phone = (EditText)findViewById(R.id.phone);

        uc = new user();
    }

    public void click(View view) {

        String username = name.getText().toString();
        String useremail = emailId.getText().toString();
        String userphone = phone.getText().toString();

        uc.setName(username);
        uc.setEmail(useremail);
        uc.setPhone(userphone);

        reference.push().setValue(uc);
        Toast.makeText(this, "Uploaded", Toast.LENGTH_SHORT).show();

    }

}
