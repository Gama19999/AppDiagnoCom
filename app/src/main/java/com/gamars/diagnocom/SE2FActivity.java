package com.gamars.diagnocom;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class SE2FActivity extends AppCompatActivity {
    private final ArrayList<Integer> options = new ArrayList<>(Arrays.asList(
        R.id.se2f_respiratorio_s1, R.id.se2f_respiratorio_s2, R.id.se2f_respiratorio_s3, R.id.se2f_respiratorio_s4,
        R.id.se2f_respiratorio_s5, R.id.se2f_respiratorio_s6, R.id.se2f_respiratorio_s7, R.id.se2f_respiratorio_s8,
        R.id.se2f_respiratorio_s9, R.id.se2f_respiratorio_s10, R.id.se2f_respiratorio_s11, R.id.se2f_respiratorio_s12
    ));

    private boolean viewOptionsItems = false;
    private boolean viewDxItems = false;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // No NightMode
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR); // No screen rotation

        Toast.makeText(getApplicationContext(), MainActivity.chainings.peek(), Toast.LENGTH_SHORT).show();
        switch (MainActivity.chainings.peek()) {
            case "Diagnóstico Encefálico" -> setContentView(R.layout.activity_se2f_cabeza);
            case "Diagnóstico Respiratorio" -> setContentView(R.layout.activity_se2f_respiratorio);
            case "Diagnóstico Digestivo" -> setContentView(R.layout.activity_se2f_digestivo);
            case "Diagnóstico Interno" -> setContentView(R.layout.activity_se2f_interno);
            case "Diagnóstico Urinario" -> setContentView(R.layout.activity_se2f_urinario);
            case "Diagnóstico Cutáneo" -> setContentView(R.layout.activity_se2f_cutaneo);
        }

        //toggleViewOptionsItems();
    }

    /**
     * Sets the visibility for the radio options elements in the SE2F view
     */
    private void toggleViewOptionsItems() {
        new ArrayList<View>(Arrays.asList(
                findViewById(R.id.se2f_frame_title),
                findViewById(R.id.se2f_frame_directions),
                findViewById(R.id.se2f_options),
                findViewById(R.id.se2f_next_directions),
                findViewById(R.id.se2f_chain_btn)
        )).forEach(i -> i.setVisibility(viewOptionsItems ? View.INVISIBLE : View.VISIBLE));
        viewOptionsItems = !viewOptionsItems;
    }

    /**
     * When called it makes the 1st forward chain into the Knowledge Base
     * to retrieve the fact from the Inference Engine accordingly to whatever
     * rule was fired as consequence of the user inputs
     * @param v View from where the event was fired
     */
    public void get2ndDiagnose(View v) {
        if (atLeast1SymptomChecked()) { // Todo must be negated duhhhh
            Toast.makeText(getApplicationContext(), "Seleccione sus síntomas", Toast.LENGTH_SHORT).show();
        } else {
            toggleViewOptionsItems();
            doForwardChaining();
            toggleViewDxItems();
        }
    }

    private boolean atLeast1SymptomChecked() {
        for (int opt : options) if (((CheckBox) findViewById(opt)).isChecked()) return true;
        return false;
    }

    private void doForwardChaining() {
        var choices = new ArrayList<String>();
        choices.add(MainActivity.chainings.peek());
        for (int opt : options) choices.add(((CheckBox) findViewById(opt)).isChecked() ? "si" : "no");
        handleResult(MainActivity.ruleBase.getDx_Cabeza(choices));
    }

    private void handleResult(Object result) {
        if (Objects.isNull(result)) {
            Toast.makeText(getApplicationContext(), "Resultado desconocido!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Hecho: ( " + result + " )", Toast.LENGTH_SHORT).show();
            ((TextView) findViewById(R.id.se2f_dx_result)).setText(result.toString());
            MainActivity.chainings.push(result.toString());
        }
    }

    /**
     * When called it organizes the app view to be back to the 'Lugar del malestar'
     * view aka the view with the radio buttons
     * @param v View from where the event was fired
     */
    public void se2fBackBtn(View v) {
        toggleViewDxItems();


        // TODO checar si en la base de reglas se tiene que modif el encadenamiento


        toggleViewOptionsItems();
    }

    /**
     * Sets the visibility for the Dx options elements in the SE1F
     * view and resets the partial Dx string
     */
    private void toggleViewDxItems() {
        new ArrayList<View>(Arrays.asList(
                findViewById(R.id.se2f_dx_introduction),
                findViewById(R.id.se2f_dx_result),
                findViewById(R.id.se2f_back_btn)
        )).forEach(i -> i.setVisibility(viewDxItems ? View.INVISIBLE : View.VISIBLE));
        viewDxItems = !viewDxItems;
    }

    /**
     * Terminates the application execution
     */
    public void closeApp(View v) {
        finish();
        System.exit(0);
    }
}
