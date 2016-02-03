package sidespell.tech.midtermexam.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sidespell.tech.midtermexam.MainActivity;
import sidespell.tech.midtermexam.R;

public class Music_detail extends AppCompatActivity {
    private static final String FRAGMENT_TAG = "fragmentContained";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);

        Intent intent = getIntent();
        if (intent == null) {
            throw new RuntimeException("DetailActivity must accept intent extras.");
        }

        Fragment fragment = null;



        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment, FRAGMENT_TAG)
                    .commit();
        }
    }
}
