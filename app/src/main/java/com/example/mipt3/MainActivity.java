package com.example.mipt3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.editText = findViewById(R.id.editInput);

    }

    public void onMathExpressionButtonClick(View view){
        Button currentButton = (Button)view;
        String currentString = this.editText.getText().toString();
        String newString = currentString + currentButton.getText();
        this.editText.setText(newString);
    }
    public void onEqualsButtonCLick(View view) {
        String currentString = this.editText.getText().toString();
        Expression e = new Expression(currentString);
        String result = e.getExpressionString() + " = " + e.calculate();
        this.editText.setText(result);

    }


}

