package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLConnector {

    private class Connect {

        private Connection connection;
        private final String url =
                "jdbc:sqlite:/app/src/main/database/database";

        public Connection connect() {
            try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println("Connect.connect(): error");
                e.printStackTrace();
            }
            return connection;
        }

        public void disconnect() {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Connect.disconnect(): error");
                e.printStackTrace();
            }
        }
    }
    private Object dbPen = new Object();

    public ArrayList getAllNotes() throws SQLException {
        Connect connect = new Connect();

        ArrayList<Note> notes = new ArrayList<>();

        String url = "SELECT * FROM notes";
        Statement s = connect.connect().createStatement();
        ResultSet rs = s.executeQuery(url);

        while (rs.next()) {
            notes.add(new Note(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }

        connect.disconnect();

        return notes;
    }

    public ArrayList addNote(String title, String content, String tag, String image) throws SQLException {

        synchronized (dbPen) {
            Connect connect = new Connect();
            String url = "INSERT INTO notes(title, content, tag, image) VALUES(?,?,?,?)";
            PreparedStatement ps = connect.connect().prepareStatement(url);

            ps.setString(1, title);
            ps.setString(2, content);
            ps.setString(3, tag);
            ps.setString(4, image);

            ps.executeUpdate();
            connect.disconnect();
        }
        return getAllNotes();
    }
}
