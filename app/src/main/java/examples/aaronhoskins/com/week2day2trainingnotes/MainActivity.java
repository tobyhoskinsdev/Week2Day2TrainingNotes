package examples.aaronhoskins.com.week2day2trainingnotes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 421;
    TextView tvUserName;
    TextView tvUserEmail;
    Button btnStartAct;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("shared_pref", MODE_PRIVATE);
        tvUserEmail = findViewById(R.id.tvUserEmail);
        tvUserName = findViewById(R.id.tvUserName);
        btnStartAct = findViewById(R.id.btnStartActiviyResult);

    }

    public void onStartForResult(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            //btnStartAct.setVisibility(View.INVISIBLE);
            String name = data.getStringExtra("name");
            String email = data.getStringExtra("email");
            //Put value of string in shared preferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", name);
            editor.putString("email", email);
            editor.commit();

            tvUserEmail.setText(email);
            tvUserName.setText(name);
        }
    }
}
