package com.example.sqliteexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button buttonAddContact, buttonViewContact, buttonUpdateContact, buttonDeleteContact;
    OnDbOpListener dbOpListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        buttonAddContact = view.findViewById(R.id.button_add_contact);
        buttonAddContact.setOnClickListener(this);
        buttonViewContact = view.findViewById(R.id.button_view_contact);
        buttonViewContact.setOnClickListener(this);
        buttonUpdateContact = view.findViewById(R.id.button_update_contact);
        buttonUpdateContact.setOnClickListener(this);
        buttonDeleteContact = view.findViewById(R.id.button_delete_contact);
        buttonDeleteContact.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add_contact:
                dbOpListener.dbOpPerformed(0);
                break;

            case R.id.button_view_contact:
                dbOpListener.dbOpPerformed(1);
                break;

            case R.id.button_update_contact:
                dbOpListener.dbOpPerformed(2);
                break;
            case R.id.button_delete_contact:
                dbOpListener.dbOpPerformed(3);
                break;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            dbOpListener = (OnDbOpListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement the interface method ..");
        }

    }

    public interface OnDbOpListener {
        void dbOpPerformed(int method);
    }
}
