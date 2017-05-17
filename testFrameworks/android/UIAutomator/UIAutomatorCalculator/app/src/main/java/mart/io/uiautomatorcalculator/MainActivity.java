package mart.io.uiautomatorcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) this.findViewById(R.id.button_1);

        final EditText firstOperand = (EditText) this.findViewById(R.id.input_field_1);
        final EditText secondOperand = (EditText) this.findViewById(R.id.input_field_2);

        final TextView resultView = (TextView) this.findViewById(R.id.result_field_2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final float num1 = Float.parseFloat(firstOperand.getText().toString());
                final float num2 = Float.parseFloat(secondOperand.getText().toString());

                resultView.setText(String.valueOf(num1 * num2));
            }
        });
    }
}
