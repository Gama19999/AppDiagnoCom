package com.gamars.diagnocom;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import static java.util.Map.entry;

public class SE1FActivity extends AppCompatActivity {
    private final ArrayList<Integer> options = new ArrayList<>(Arrays.asList(
        R.id.se1f_d_cabeza, R.id.se1f_d_respiratorio, R.id.se1f_d_digestivo,
        R.id.se1f_d_interno, R.id.se1f_d_urinario, R.id.se1f_d_cutaneo
    ));

    private final Map<Integer, Integer> se1fOptionsResult = Map.ofEntries(
            entry(R.id.se1f_d_cabeza, R.string.se1f_dx_cabeza),
            entry(R.id.se1f_d_respiratorio, R.string.se1f_dx_respiratorio),
            entry(R.id.se1f_d_digestivo, R.string.se1f_dx_digestivo),
            entry(R.id.se1f_d_interno, R.string.se1f_dx_interno),
            entry(R.id.se1f_d_urinario, R.string.se1f_dx_urinario),
            entry(R.id.se1f_d_cutaneo, R.string.se1f_dx_cutaneo)
    );

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // No NightMode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR); // No screen rotation

        setContentView(R.layout.activity_se1f);
    }

    /**
     * Called when the user accepts the notice pressing a button
     * @param v View from where the event is fired
     */
    public void noticeAccepted(View v) {
        findViewById(R.id.se1f_notice).setVisibility(View.GONE);
        findViewById(R.id.se1f_accept_notice).setVisibility(View.GONE);
        findViewById(R.id.se1f_decline_notice).setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "¡Previo aviso aceptado!", Toast.LENGTH_SHORT).show();
        toggleViewOptionsItems(View.VISIBLE);
    }

    /**
     * Sets the visibility for the radio options elements in the SE1F view
     * @param visibility View.CONSTANT (VISIBLE, INVISIBLE, GONE)
     */
    private void toggleViewOptionsItems(int visibility) {
        new ArrayList<View>(Arrays.asList(
                findViewById(R.id.se1f_frame_title),
                findViewById(R.id.se1f_frame_directions),
                findViewById(R.id.se1f_options),
                findViewById(R.id.se1f_next_directions),
                findViewById(R.id.se1f_continue_btn)
        )).forEach(i -> i.setVisibility(visibility));
    }

    /**
     * When called it makes the 1st forward chain into the Knowledge Base
     * to retrieve the fact from the Inference Engine accordingly to whatever
     * rule was fired as consequence of the user inputs
     * @param v View from where the event was fired
     */
    public void get1stDiagnose(View v) {
        RadioGroup options = findViewById(R.id.se1f_options);

        if (options.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Seleccione opción", Toast.LENGTH_SHORT).show();
        } else {
            toggleViewOptionsItems(View.INVISIBLE);
            doForwardChaining();
            toggleViewDxItems(View.VISIBLE);
        }
    }

    private void doForwardChaining() {
        var choices = new ArrayList<String>();
        for (int opt : options) choices.add(((RadioButton) findViewById(opt)).isChecked() ? "si" : "no");
        handleResult(MainActivity.ruleBase.getAfeccion(choices));
    }

    private void handleResult(Object result) {
        if (Objects.isNull(result)) {
            Toast.makeText(getApplicationContext(), "Resultado desconocido!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Hecho: ( " + result + " )", Toast.LENGTH_SHORT).show();
            ((TextView) findViewById(R.id.se1f_dx_result)).setText(result.toString());
            MainActivity.chainings.push(result.toString());
        }
    }

    /**
     * When called it organizes the app view to be back to the 'Lugar del malestar'
     * view aka the view with the radio buttons
     * @param v View from where the event was fired
     */
    public void se1fBackBtn(View v) {
        toggleViewDxItems(View.INVISIBLE);


        // TODO checar si en la base de reglas se tiene que modif el encadenamiento


        toggleViewOptionsItems(View.VISIBLE);
    }

    /**
     * Sets the visibility for the Dx options elements in the SE1F
     * view and resets the partial Dx string
     * @param visibility View.CONSTANT (VISIBLE, INVISIBLE, GONE)
     */
    private void toggleViewDxItems(int visibility) {
        new ArrayList<View>(Arrays.asList(
                findViewById(R.id.se1f_dx_introduction),
                findViewById(R.id.se1f_dx_result),
                findViewById(R.id.se1f_back_btn)
        )).forEach(i -> i.setVisibility(visibility));
    }

    /**
     * Terminates the application execution
     */
    public void closeApp(View v) {
        finish();
        System.exit(0);
    }
}
