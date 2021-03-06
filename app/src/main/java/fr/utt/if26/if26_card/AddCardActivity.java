package fr.utt.if26.if26_card;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.zxing.integration.android.IntentIntegrator;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        Button scan = findViewById(R.id.add_card);
        scan.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(AddCardActivity.this);
                integrator.setCaptureActivity(CustomCaptureActivity.class);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setOrientationLocked(false);
                integrator.setPrompt("Scan");
                integrator.initiateScan();
            }
        });
    }
}
