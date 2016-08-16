package warrenhong.datepicker;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    int year;
    int month;
    int day;
    static final int DIALOG_ID = 0;

    public void showDialogOnClick() {
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == DIALOG_ID) {
            return new DatePickerDialog(this, dpickerlistener, year, month, day);
        } else {
            return null;
        }
    }

    private DatePickerDialog.OnDateSetListener dpickerlistener
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int yearX, int monthOfYear, int dayOfYear) {
            year = yearX;
            month = monthOfYear + 1;
            day = dayOfYear;
            Toast.makeText(MainActivity.this, yearX + "/" + monthOfYear + "/" + dayOfYear, Toast.LENGTH_SHORT).show();
        }
    };

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);


        showDialogOnClick();
    }
}
