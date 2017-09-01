    package com.victoralejandro.pizzago;

    import android.content.Intent;
    import android.net.Uri;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.MediaController;
    import android.widget.VideoView;

    public class PrincipalActivity extends AppCompatActivity {
        private VideoView videoView;
        private Button btnpedido;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_principal);
            btnpedido = (Button) findViewById(R.id.btnpedir);
            videoView = (VideoView) findViewById(R.id.videoView);
            videoView.setMediaController(new MediaController(this));
    //        videoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
            videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videopizza));
            videoView.start();

            btnpedido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(PrincipalActivity.this, SolicitudActivity.class);
                    startActivity(intent1);
                }
            });
        }
    }
