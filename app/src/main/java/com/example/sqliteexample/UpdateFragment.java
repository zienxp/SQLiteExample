package com.example.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {

    private EditText update_id, update_name, update_email;
    private Button update_button;


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        update_id = view.findViewById(R.id.text_update_id);
        update_name = view.findViewById(R.id.text_update_name);
        update_email = view.findViewById(R.id.text_update_email);
        update_button = view.findViewById(R.id.button_update_save);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();

            }
        });

        return view;
    }

    private void updateContact() {


        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = contactDbHelper.getWritableDatabase();
        int id = Integer.parseInt(update_id.getText().toString());
        String name = update_name.getText().toString();
        String email = update_email.getText().toString();

        contactDbHelper.updateContact(id, name, email, database);
        contactDbHelper.close();

        Toast.makeText(getActivity(), "Contact Updated", Toast.LENGTH_SHORT).show();
        update_id.setText("");
        update_name.setText("");
        update_email.setText("");
    }

}
