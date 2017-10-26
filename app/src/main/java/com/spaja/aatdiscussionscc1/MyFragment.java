package com.spaja.aatdiscussionscc1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import io.realm.Realm;

/**
 * Created by Spaja on 26-Oct-17.
 */

public class MyFragment extends android.app.Fragment {

    View view;
    private Realm realm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout, container, false);

        Button button = (Button) view.findViewById(R.id.frag_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.putExtra("data", true);
//                getActivity().setResult(2, intent);
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Data data = new Data();
                        data.setId(1);
                        data.setName("fragment");
                        realm.copyToRealmOrUpdate(data);
                    }
                });
                getActivity().finish();

            }
        });

        return view;
    }
}
