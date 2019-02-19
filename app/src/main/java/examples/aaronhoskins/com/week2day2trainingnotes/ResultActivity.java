package examples.aaronhoskins.com.week2day2trainingnotes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    public static final int RESPONSE_CODE = 422;
    Intent passedIntent;
    EditText etUserName;
    EditText etUserEmail;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        etUserEmail = findViewById(R.id.etUserEmail);
        etUserName = findViewById(R.id.etUserName);
        sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE);
        //get values from shared preferences
        etUserName.setText(sharedPreferences.getString("name", ""));
        etUserEmail.setText(sharedPreferences.getString("email",""));


        passedIntent = getIntent();
    }

    public void onClick(View view) {
        String email = etUserEmail.getText().toString();
        String name = etUserName.getText().toString();

        if(!email.isEmpty() && !name.isEmpty()) {
            passedIntent.putExtra("name", name);
            passedIntent.putExtra("email", email);

            setResult(RESPONSE_CODE, passedIntent);
            finish();
        }
    }
}
