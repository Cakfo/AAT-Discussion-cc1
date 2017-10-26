package com.spaja.aatdiscussionscc1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @BindView (R.id.first_button) Button startAct;
    @BindView (R.id.second_button) Button showDialog;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        realm = Realm.getDefaultInstance();

        startAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(i, 1);
            }
        });

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogMssg("first");
            }
        });

    }

    private void showDialogMssg(String name) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (name.equals("activity")) {
            builder.setTitle("Cool Title");
            builder.setMessage("Second Act");
            builder.show();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Data id = realm.where(Data.class).equalTo("id", 1).findFirst();
                    id.deleteFromRealm();

                }
            });
        } else if (name.equals("fragment")) {
            builder.setTitle("Cool Title");
            builder.setMessage("Frag Act");
            builder.show();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Data id = realm.where(Data.class).equalTo("id", 1).findFirst();
                    id.deleteFromRealm();

                }
            });
        } else if (name.equals("first")) {
            builder.setTitle("Cool Title");
            builder.setMessage("First Act");
            builder.show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
            }
        }
    }

    @Override
    protected void onResume() {
        Data id = realm.where(Data.class).equalTo("id", 1).findFirst();
        if (id != null) {
            String name = id.getName();
            showDialogMssg(name);
        }
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
