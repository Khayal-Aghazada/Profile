package com.example.profile;

import static android.view.WindowManager.LayoutParams.FLAG_SECURE;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvMail, tvCall, tvMessage, tvGithub, tvLinkedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(FLAG_SECURE, FLAG_SECURE);// no screenshot

        tvMail = findViewById(R.id.tvMail);
        tvCall = findViewById(R.id.tvCall);
        tvMessage = findViewById(R.id.tvMessage);
        tvGithub = findViewById(R.id.tvGithub);
        tvLinkedin = findViewById(R.id.tvLinkedin);

        tvMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvMail.setText(Html.fromHtml("<a href=\"mailto:examplemail@gmail.com\">examplemail@gmail.com</a>"));
                tvMail.setMovementMethod(LinkMovementMethod.getInstance());

            }
        });


        tvCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tvCall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: your number"));
                        startActivity(intent);
                    }
                });
            }
        });

        tvMessage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tvMessage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + "your number &text" + tvMessage));
                        startActivity(intent);
                    }
                });
            }
        });


        tvLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("url to ur linkedin acc"));
                startActivity(intent);
            }
        });

        tvGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("url to ur github acc"));
                startActivity(intent);
            }
        });
    }
}