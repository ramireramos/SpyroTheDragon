package dam.pmdm.spyrothedragon;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private AnimationDrawable splashAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView splashImageView = findViewById(R.id.splash_image_view);
        splashImageView.setBackgroundResource(R.drawable.splash_animation);
        splashAnimation = (AnimationDrawable) splashImageView.getBackground();

        // Iniciar la animación
        splashAnimation.start();

        // Pasar a la actividad principal después de un tiempo
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000); // 3 segundos
    }
}