package mart.io.rssreader;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    Bitmap image;

    @Override // executes on UI thread
    protected void onCreate(Bundle savedInstanceState) {

        // below two strings are dirty hack
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // as far as handler is created here, in method which is executed in UI thread
        // this handler may execute code in UI thread
        // handler keeps a reference to the thread it was created by
        handler = new Handler();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        refreshOnFeed();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    private void resetDisplay(String title, String description) {
        TextView titleView = (TextView) findViewById(R.id.myViewTitle);
        TextView descriptionView = (TextView) findViewById(R.id.myViewDescription);
        titleView.setText(title);
        descriptionView.setText(description);
    }

    private void refreshOnFeed() {
        final IotdHandler iotdHandler = new IotdHandler();

        // This is blocking notification
        final ProgressDialog dialog = ProgressDialog.show(this, "Loading", "Loading RSS feed");


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // this is another thread, and here we do expensive work
                iotdHandler.processFeed();

                // post method executes Runnable in thread, where Handler was initiated -> UI thread
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        resetDisplay(iotdHandler.getTitle(), iotdHandler.getDescription());
                        ImageView descriptionView = (ImageView) findViewById(R.id.test_image);

                        image = ((BitmapDrawable) descriptionView.getDrawable()).getBitmap();

                        dialog.dismiss();
                    }
                });
            }
        });

        t.start();

    }

    public void onRefresh(View view) {
        refreshOnFeed();
    }

    public void onSetWallPaper(View view) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(MainActivity.this);
                try {
                    wallpaperManager.setBitmap(image);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Wallpaper was set", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (IOException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Wallpaper was not set", Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }
}
