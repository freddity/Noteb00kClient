package com.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.sql.SQLException;
import java.util.List;

public class FragmentNote extends Fragment {

    private SQLConnector sqlConnector;

    public FragmentNote() {
        sqlConnector = new SQLConnector();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        try {
            sqlConnector.addNote(
                    "Batman vs Superman",
                    "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ",
                    "films"
            );
        } catch (SQLException e) {
            System.out.println("(1) FragmentNote.onCreateView(): SQLException");
            e.printStackTrace();
        }

        try {
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(sqlConnector.getAllNotes(), getContext());
            recyclerView.setAdapter(adapter);
        } catch (SQLException e) {
            System.out.println("(2) FragmentNote.onCreateView(): SQLException");
            e.printStackTrace();
        }

        try {
            Note x = (Note) sqlConnector.getAllNotes().get(0);
            System.out.println("ELOOO" + x.title);
        } catch (SQLException e) {
            System.out.println("(2) FragmentNote.onCreateView(): SQLException");
            e.printStackTrace();
        }

        return view;


        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        List<Data> data = fill_with_data();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data, getContext());
        recyclerView.setAdapter(adapter);

        data.add(new Data("TO JAAA", "SIEMA KURKA", R.drawable.ic_launcher));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RecyclerViewAdapter adapter2 = new RecyclerViewAdapter(data,getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    /*public List<> fill_with_data() {


        data.add(new Data("Batman vs Superman", "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", R.drawable.ic_launcher));
        data.add(new Data("X-Men: Apocalypse", "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", R.drawable.ic_launcher));
        data.add(new Data("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", R.drawable.ic_launcher));
        data.add(new Data("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", R.drawable.ic_launcher));
        data.add(new Data("Warcraft", "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. ", R.drawable.ic_launcher));
        data.add(new Data("Alice in Wonderland", "Alice in Wonderland: Through the Looking Glass ", R.drawable.ic_launcher));
    }*/
}

