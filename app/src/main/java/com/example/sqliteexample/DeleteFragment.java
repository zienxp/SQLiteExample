package com.example.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {
    private EditText editText;
    private Button button;


    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        editText = view.findViewById(R.id.text_delete_id);
        button = view.findViewById(R.id.delete_Contact);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });
        return view;
    }

    void deleteContact() {

        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        SQLiteDatabase database = contactDbHelper.getWritableDatabase();
        int id = Integer.parseInt(editText.getText().toString());
        contactDbHelper.deleteContact(id, database);
        contactDbHelper.close();
        editText.setText("");

        Toast.makeText(getActivity(), "Contact Deleted Successfully", Toast.LENGTH_SHORT).show();

    }


}
