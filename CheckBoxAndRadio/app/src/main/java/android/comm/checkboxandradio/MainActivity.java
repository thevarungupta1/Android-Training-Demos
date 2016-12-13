package android.comm.checkboxandradio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    RadioGroup radioGroup;
    CheckBox cricket, football, hockey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cricket = (CheckBox) findViewById(R.id.cricket);
        football = (CheckBox) findViewById(R.id.football);
        hockey = (CheckBox) findViewById(R.id.hockey);

        cricket.setOnCheckedChangeListener(this);
        football.setOnCheckedChangeListener(this);
        hockey.setOnCheckedChangeListener(this);

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String message = null;
        switch (buttonView.getId()) {
            case R.id.cricket:
                message = "Cricket is";
                break;
            case R.id.football:
                message = "Football is";
                break;
            case R.id.hockey:
                message = "Hockey is";
                break;
        }
        message += isChecked ? "Checked" : "Unchecked";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.mumbai:
                Toast.makeText(this, "Mumbai", Toast.LENGTH_SHORT).show();
                break;
            case R.id.london:
                Toast.makeText(this, "London", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delhi:
                Toast.makeText(this, "Delhi", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
