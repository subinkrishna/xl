package com.subinkrishna.xl;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.civ) ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            MainActivity.this,
                            v,
                            getString(R.string.transition_shared_profile));
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
                } else {
                    startActivity(new Intent(MainActivity.this, DetailsActivity.class));
                }
            }
        });
    }
}
