package dam.pmdm.spyrothedragon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class GuideActivity extends AppCompatActivity {

    private int currentFragmentIndex = 0;
    private Fragment[] guideFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        // Crear los fragments de la guía
        guideFragments = new Fragment[]{
                new GuideFragmentIntro(),
                new GuideFragmentPersonajes(),
                new GuideFragmentWorld(),
                new GuideFragmentColeccionables(),
                new GuideFragmentInformacion(),
                new GuideFragmentResumen(),
        };

        // Mostrar el primer fragment
        showFragment(currentFragmentIndex);

        // Configurar los botones
        Button previousButton = findViewById(R.id.previous_button);
        Button nextButton = findViewById(R.id.next_button);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousFragment();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextFragment();
            }
        });
    }

    private void showFragment(int index) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.guide_container, guideFragments[index]);
        transaction.commit();
    }

    private void showPreviousFragment() {
        if (currentFragmentIndex > 0) {
            currentFragmentIndex--;
            showFragment(currentFragmentIndex);
        }
    }

    private void showNextFragment() {
        if (currentFragmentIndex < guideFragments.length - 1) {
            currentFragmentIndex++;
            showFragment(currentFragmentIndex);
        } else {
            // Si es el último fragment, ir a la MainActivity
            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}