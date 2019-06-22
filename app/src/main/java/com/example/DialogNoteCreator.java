package com.example;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DialogNoteCreator extends DialogFragment {

    private FragmentNote fragmentNote;

    @SuppressLint("ValidFragment")
    public DialogNoteCreator(FragmentNote fragmentNote) {
        this.fragmentNote = fragmentNote;
    }

    public DialogNoteCreator() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_note_creator, container, false);

        Button button = view.findViewById(R.id.dialog_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText titleET = getView().findViewById(R.id.title_dialog);
                EditText descriptionET = getView().findViewById(R.id.description_dialog);
                String title = titleET.getText().toString();
                String description = descriptionET.getText().toString();

                if (!title.equals("") && !description.equals("")) {
                    fragmentNote.addNote(title, description, "no tag");
                    dismiss();
                }
            }
        });

        return view;
    }
}
