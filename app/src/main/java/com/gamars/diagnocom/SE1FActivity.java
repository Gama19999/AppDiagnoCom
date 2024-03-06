package com.gamars.diagnocom;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;
import java.util.Arrays;

public class SE1FActivity extends AppCompatActivity {
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
        findViewById(R.id.se1f_right).setVisibility(View.GONE);
        findViewById(R.id.se1f_decline).setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(), "¡Previo aviso aceptado!", Toast.LENGTH_SHORT).show();
        showHideROptions(View.VISIBLE);
    }

    /**
     * When called it makes the 1st forward chain into the Knowledge Base
     * to retrieve the fact from the Inference Engine accordingly to whatever
     * rule was fired as consequence of the user inputs
     * @param v View from where the event was fired
     */
    public void get1stDiagnose(View v) {
        showHideROptions(View.INVISIBLE);

        // TODO llamar al metodo de forward chain the la base de reglas

        // TODO establecer la string adecuada al textview 'se1f_res_dx'
        showHideDxOptions(View.VISIBLE);
    }

    /**
     * When called it organizes the app view to be back to the 'Lugar del malestar'
     * view aka the view with the radio buttons
     * @param v View from where the event was fired
     */
    public void se1fDxBack(View v) {
        showHideDxOptions(View.INVISIBLE);

        // TODO checar si en la base de reglas se tiene que modif el encadenamiento

        showHideROptions(View.VISIBLE);
    }

    /**
     * Sets the visibility for the radio options elements in the SE1F
     * view
     * @param visibility View.CONSTANT (VISIBLE, INVISIBLE, GONE)
     */
    private void showHideROptions(int visibility) {
        new ArrayList<View>(Arrays.asList(
                findViewById(R.id.se1f_title),
                findViewById(R.id.se1f_directions),
                findViewById(R.id.se1f_rg1),
                findViewById(R.id.se1f_next_dir1),
                findViewById(R.id.se1f_cont)
        )).forEach(i -> i.setVisibility(visibility));
    }

    /**
     * Sets the visibility for the Dx options elements in the SE1F
     * view and resets the partial Dx string
     * @param visibility View.CONSTANT (VISIBLE, INVISIBLE, GONE)
     */
    private void showHideDxOptions(int visibility) {
        new ArrayList<View>(Arrays.asList(
                findViewById(R.id.se1f_dx_prev),
                findViewById(R.id.se1f_res_dx),
                findViewById(R.id.se1f_dx_back)
        )).forEach(i -> i.setVisibility(visibility));
        if (visibility == View.INVISIBLE) {
            ((TextView) findViewById(R.id.se1f_res_dx)).setText(R.string.se1f_dx_empty);
        }
    }

    /**
     * Terminates the application execution
     */
    public void closeApp(View v) {
        finish();
        System.exit(0);
    }
}
