package mart.io.robotiumcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner operationSpinner;
    TextView result;
    Button getResult;

    private enum OperationType {
        Addition, Subtraction
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtfirstNumber = (EditText)
                this.findViewById(R.id.txtFirstNumber);
        final EditText txtsecondNumber = (EditText)
                this.findViewById(R.id.txtSecondNumber);

        this.result = (TextView) this.findViewById(
                R.id.resultText);
        this.result.setText("0.00");

        this.getResult = (Button) this.findViewById(
                R.id.btnGetResult);
        this.operationSpinner = (Spinner) this.findViewById(
                R.id.operationSpinner);

        // Adding listener to get result button
        this.getResult.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                OperationType operationType = OperationType.
                        valueOf(MainActivity.this.operationSpinner.
                                getSelectedItem().toString());
                final float num1 = Float.parseFloat(
                        txtfirstNumber.getText().toString());
                final float num2 = Float.parseFloat(
                        txtsecondNumber.getText().toString());
                // Getting first & second values and passing to show result
                MainActivity.this.showResult(num1, num2, operationType);
            }
        });

        Button button = (Button) findViewById(R.id.button_simple);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });
    }

    // Showing operation results
    protected void showResult(final float firstNumber,
                              final float secondNumber, final OperationType type) {
        float resultVal = 0;
        if (type.equals(OperationType.Addition)) {
            resultVal = firstNumber + secondNumber;
        } else if (type.equals(OperationType.Subtraction)) {
            resultVal = firstNumber - secondNumber;
        }
        String operationResult = String.valueOf(resultVal);
        this.result.setText(operationResult);
    }

}
