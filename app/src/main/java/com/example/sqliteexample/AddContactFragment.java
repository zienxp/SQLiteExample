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
public class AddContactFragment extends Fragment {
    private Button button_save;
    private EditText editText_id, editText_name, editText_email;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);
        button_save = view.findViewById(R.id.button_save);
        editText_id = view.findViewById(R.id.editText_contact_id);
        editText_name = view.findViewById(R.id.editText_name);
        editText_email = view.findViewById(R.id.editText_email);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editText_id.getText().toString();
                String name = editText_name.getText().toString();
                String email = editText_email.getText().toString();
                ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
                SQLiteDatabase database = contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(id), name, email, database);
                contactDbHelper.close();
                editText_id.setText("");
                editText_name.setText("");
                editText_email.setText("");
                Toast.makeText(getActivity(), "Contact Saved Successfully ...", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
