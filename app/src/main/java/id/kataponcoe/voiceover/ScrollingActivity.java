package id.kataponcoe.voiceover;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class ScrollingActivity extends AppCompatActivity {
    MediaPlayer audioMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Memberi definisi di onCreate untuk toggle
        //myToggle = (ToggleButton) findViewById(R.id.toggleSound);
        //Memanggil file startup_apppro pada folder raw
        audioMainMenu = MediaPlayer.create(this, R.raw.jurusan_rpl);
        //Set looping ke false untuk memainkan audio jika telah selesai
        audioMainMenu.setLooping(false);
        //Set volume audio agar berbunyi
        audioMainMenu.setVolume(1,1);
        //Memulai audio

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audioMainMenu.start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        audioMainMenu.stop();
        this.finish(); // mengakhiri jika kita balik ke menu kembali
    }
}
