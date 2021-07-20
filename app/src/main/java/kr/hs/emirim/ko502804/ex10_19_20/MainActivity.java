package kr.hs.emirim.ko502804.ex10_19_20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCall = findViewById(R.id.btn_call);
        Button btnHome = findViewById(R.id.btn_homepage);
        Button btnMap = findViewById(R.id.btn_map);
        Button btnSearch = findViewById(R.id.btn_search);
        Button btnSms = findViewById(R.id.btn_sms);
        Button btnPhoto = findViewById(R.id.btn_photo);

        btnCall.setOnClickListener(btnListener);
        btnHome.setOnClickListener(btnListener);
        btnMap.setOnClickListener(btnListener);
        btnSearch.setOnClickListener(btnListener);
        btnSms.setOnClickListener(btnListener);
        btnPhoto.setOnClickListener(btnListener);

    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            Uri uri = null;
            switch (view.getId()){
                case R.id.btn_call:
                    uri = Uri.parse("tel:01033337777");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    break;
                case R.id.btn_homepage:
                    uri = Uri.parse("https://www.e-mirim.hs.kr");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_map:
                    uri = Uri.parse("https://www.google.co.kr/maps?q="+37.46694156119198 + "," + 126.9329306626001);
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_search:
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "코로나 현황");
                    break;
                case R.id.btn_sms:
                    uri = Uri.parse("smsto:" + Uri.encode("010-5555-1111"));
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body", "우리 팀 어떻게 하면 좋을까?");
                    intent.setData(uri);
                    break;
                case R.id.btn_photo:
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    break;
            }
            startActivity(intent);
        }
    };
}