package com.example.rocky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private TextView angleTextView;
    private TextView powerTextView;
    private TextView directionTextView;
    private  joystick joysticks;
    private WebView webView;
    public String sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished (WebView view, String url) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                      view.evaluateJavascript("loadMsg(\"" + sex + "\")", null);
                } else {
                    view.loadUrl("javascript:loadMsg('How are you today!')");
                }
            }
        });
        webView.loadUrl("http://192.168.43.197/");

        angleTextView = (TextView) findViewById(R.id.angleTextView);
        powerTextView = (TextView) findViewById(R.id.powerTextView);
        directionTextView = (TextView) findViewById(R.id.directionTextView);
        joysticks = (joystick) findViewById(R.id.joysteek);
        joysticks.setOnJoystickMoveListener(new joystick.OnJoystickMoveListener() {
            public void onValueChanged(int angle, int power, int direction) {
                angleTextView.setText(" " + String.valueOf(angle) + "°");
                powerTextView.setText(" " + String.valueOf(power) + "%");
                switch (direction) {
                    case joystick.FRONT:
                        directionTextView.setText(R.string.front_lab);
                        sex = "front";
                        webView.loadUrl("http://192.168.43.197/");
                        break;
                    case joystick.FRONT_RIGHT:
                        directionTextView.setText(R.string.front_right_lab);
                        sex = "front-right";
                        webView.loadUrl("http://192.168.43.197/");
                        break;
                    case joystick.RIGHT:
                        directionTextView.setText(R.string.right_lab);
                        sex = "right";
                        webView.loadUrl("http://192.168.43.197/");
                        break;
                    case joystick.RIGHT_BOTTOM:
                        directionTextView.setText(R.string.right_bottom_lab);
                        sex = "right-bottom";
                        webView.loadUrl("http://192.168.43.197/");
                        break;
                    case joystick.BOTTOM:
                        directionTextView.setText(R.string.bottom_lab);
                        sex = "bottom";
                        webView.loadUrl("http://192.168.43.197/");
                        break;
                    case joystick.BOTTOM_LEFT:
                        directionTextView.setText(R.string.bottom_left_lab);
                        sex = "bottom-left";
                        webView.loadUrl("http://192.168.43.197/");
                        break;
                    case joystick.LEFT:
                        directionTextView.setText(R.string.left_lab);
                        sex = "left";
                        webView.loadUrl("http://192.168.43.197/");
                        break;
                    case joystick.LEFT_FRONT:
                        directionTextView.setText(R.string.left_front_lab);
                        sex = "left-front";
                        webView.loadUrl("http://192.168.43.197/");
                        break;
                    default:
                        directionTextView.setText(R.string.center_lab);
                        webView.loadUrl("http://192.168.43.197/");
                }

            }

        }, joystick.DEFAULT_LOOP_INTERVAL);
    }

}

