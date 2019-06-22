package com.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FragmentNote extends Fragment {

    private SQLConnector sqlConnector;
    private View context;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        this.context = view;

        sqlConnector = new SQLConnector();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        this.recyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public void addNote(String title, String description, String tag) {
        RecyclerViewAdapter adapter = null;
        try {
            adapter = new RecyclerViewAdapter(sqlConnector.addNote(title, description, tag), getContext());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(adapter);
    }

    public List<Note> fill_with_data() {

        ArrayList data = new ArrayList();

        data.add(new Note("Batman vs Superman", "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", "film"));
        data.add(new Note("X-Men: Apocalypse", "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", "film"));
        data.add(new Note("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", "film"));
        data.add(new Note("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", "film"));
        data.add(new Note("Warcraft", "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. ", "film"));
        data.add(new Note("Alice in Wonderland", "Alice in Wonderland: Through the Looking Glass ", "film"));
        return data;
    }
}

