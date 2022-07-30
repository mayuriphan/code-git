package me.person.hybrid_energy;



        import android.content.Intent;
        import android.os.Bundle;
        import android.provider.ContactsContract;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;


public class Registration extends AppCompatActivity {

    private EditText userName;
    private EditText Passcode;
    private EditText cPasscode;
    private Button Register;
    private EditText userEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userName = (EditText)findViewById(R.id.eT1);
        userEmail= (EditText)findViewById(R.id.eT2);
        Passcode = (EditText)findViewById(R.id.eT4);
        cPasscode = (EditText)findViewById(R.id.eT5);
        Register= (Button)findViewById(R.id.b1);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Passcode==cPasscode)                //issue lag raha hai
                {
                    final String user = userName.getText().toString();
                    final String password = Passcode.getText().toString();
                    Intent loginIntent = new Intent(Registration.this, LogIN.class);
                    Registration.this.startActivity(loginIntent);
                }
                else{
                    System.out.println("Password do not match");    //alert dalna hai
                }






            }
        });

    }

}
