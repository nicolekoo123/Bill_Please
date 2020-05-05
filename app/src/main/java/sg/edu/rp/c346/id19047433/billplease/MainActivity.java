package sg.edu.rp.c346.id19047433.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText etAmount;
    EditText etPax;
    ToggleButton tbSVS;
    ToggleButton tbGST;
    EditText etDiscont;
    TextView tvBILL;
    TextView tvPAY;
    Button btnSPLIT;
    Button btnRESET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAmount = findViewById(R.id.etAmount);
        etPax = findViewById(R.id.etPax);
        tbSVS = findViewById(R.id.tbSVS);
        tbGST = findViewById(R.id.tbGST);
        etDiscont = findViewById(R.id.etdiscount);
        tvBILL = findViewById(R.id.tvBill);
        tvPAY = findViewById(R.id.tvPAY);
        btnSPLIT = findViewById(R.id.btnSPILT);
        btnRESET = findViewById(R.id.btnRESET);

        btnSPLIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etAmount.getText().toString().trim().length() != 0 && etPax.getText().toString().trim().length() != 0) {
                    double newAmt = 0.0;
                    if (!tbSVS.isChecked() && !tbGST.isChecked()) {
                    } else if (tbSVS.isChecked() && !tbGST.isChecked()) {
                        newAmt = Double.parseDouble(etAmount.getText().toString()) * 1.1;
                    } else if (!tbSVS.isChecked() && tbGST.isChecked()) {
                        newAmt = Double.parseDouble(etAmount.getText().toString()) * 1.07;
                    } else {
                        newAmt = Double.parseDouble(etAmount.getText().toString()) * 1.17;
                    }
                    if (etDiscont.getText().toString().trim().length() != 0) {
                        newAmt *= 1 - Double.parseDouble(etDiscont.getText().toString()) / 100;
                    }
                    tvBILL.setText("Total Bill $" + String.format("%.2f", newAmt));
                    int numPax = Integer.parseInt(etPax.getText().toString());
                    if (numPax != 1) {
                        tvPAY.setText("Each Pay: $" + String.format("%.2f", newAmt / numPax));
                    } else {
                        tvPAY.setText("Each pays: $" + newAmt);
                    }
                }
            }
        });
    }
}


