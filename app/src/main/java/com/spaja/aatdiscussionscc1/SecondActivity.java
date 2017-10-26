package com.spaja.aatdiscussionscc1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class SecondActivity extends AppCompatActivity {

    @BindView (R.id.back) Button back;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        realm = Realm.getDefaultInstance();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("data", true);
//                setResult(MainActivity.RESULT_OK, returnIntent);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Data data = new Data();
                        data.setId(1);
                        data.setName("activity");
                        realm.copyToRealmOrUpdate(data);
                    }
                });
                finish();

            }
        });

        android.app.Fragment fragment = new MyFragment();
        android.app.FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }
}
