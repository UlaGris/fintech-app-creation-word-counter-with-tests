package com.example.fintechappcreation_wordcounterwithtests;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final TextCounter counter = new TextCounter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText etInput = findViewById(R.id.etInput);
        Spinner spCountType = findViewById(R.id.spCountType);
        Button btnCount = findViewById(R.id.btnCount);
        TextView tvResult = findViewById(R.id.tvResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountType.setAdapter(adapter);

        btnCount.setOnClickListener(v -> {
            String input = etInput.getText().toString();

            if (input.trim().isEmpty()) {
                Toast.makeText(this, getString(R.string.toast_empty_input), Toast.LENGTH_SHORT).show();
                return;
            }

            int selectedCountIndex = spCountType.getSelectedItemPosition();
            int countResult;

            if (selectedCountIndex == 0) {
                countResult = counter.countWords(input);
            } else if (selectedCountIndex == 1) {
                countResult = counter.countPunctuation(input);
            } else {
                countResult = 0;
            }

            tvResult.setText(getString(R.string.result_prefix, countResult));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}