package com.example.mobilebank_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class OfficeActivity extends AppCompatActivity {
    // TODO - добавить карту, адрес, все что угодно, что душа пожелает, просто чтобы смотрелось норм
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office);

        TextView textView =(TextView)findViewById(R.id.maplinkLabel);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='https://yandex.ru/maps/21/vologda/?ll=39.883176%2C59.219143&mode=poi&poi%5Bpoint%5D=39.884561%2C59.219662&poi%5Buri%5D=ymapsbm1%3A%2F%2Forg%3Foid%3D1022616757&z=16'> Открыть карту </a>";
        textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));
        textView.setLinkTextColor(Color.WHITE);
    }

    public void menuClick(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void exitClick(View view){
        this.finishAffinity();
    }

    public void profileClick(View view){
        Intent profile = new Intent(this, ProfileActivity.class);
        startActivity(profile);
    }


}