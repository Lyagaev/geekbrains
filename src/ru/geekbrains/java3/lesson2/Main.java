package ru.geekbrains.java3.lesson2;


import java.sql.*;

public class Main {

    private static Connection conn;
    private static Statement stmt;

    public static void main(String[] args)  {

        //Создать CRUD операции, 1 метод создани таблицы 2 метод для добавления записи 3 метод для получения записи 4 метод для удаления записи 5 удаление таблицы
        try {
//            CreateTable("CREATE TABLE Students\n" +
//                    "(\n" +
//                    "  StudID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
//                    "  Name TEXT,\n" +
//                    "  GroupName TEXT,\n" +
//                    "  Score INTEGER\n" +
//                    "); " +
//                    "CREATE TABLE StudentsDel " +
//                    "(id INTEGER" +
//                    ")");

//            InsertRowTable("INSERT INTO Students (Name, GroupName, score) VALUES ('andrei', '10', 100); "+
//                    "INSERT INTO Students (Name, GroupName, score) VALUES ('andrei2', '10', 100); "+
//                    "INSERT INTO Students (Name, GroupName, score) VALUES ('andrei', '20', 100)"
//            );

            //SelectDataTable("SELECT * FROM Students");

            //DeleteRowTable("DELETE FROM Students WHERE GroupName='10';");

            DeleteTable("DROP TABLE StudentsDel;");

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    private static void CreateTable(String q) throws Exception {
        connect();
        int i=stmt.executeUpdate(q);
        System.out.println("Добавленно "+ i +" таблица");
        disconnect();
    }

    private static void InsertRowTable(String q) throws Exception {
        connect();
        int i=stmt.executeUpdate(q);
        System.out.println("Добавленно "+ i +" записей");
        disconnect();
    }

    private static void SelectDataTable(String q) throws Exception {
        connect();
        ResultSet rs = stmt.executeQuery(q);

        while (rs.next()) {
                System.out.println(rs.getString("StudId") + " " + rs.getString("Name") + " " + rs.getString("GroupName")
                        + " " + rs.getString("score"));
            }
        disconnect();
    }

    private static void DeleteRowTable(String q) throws Exception {
        connect();
        int i=stmt.executeUpdate(q);
        System.out.println("Удалена "+ i +" запись");
        disconnect();
    }

    private static void DeleteTable(String q) throws Exception {
        connect();
        int i=stmt.executeUpdate(q);
        System.out.println("Удалена "+ i +" таблица");
        disconnect();
    }

    private static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = conn.createStatement();
    }

    private static void disconnect() throws SQLException {
        conn.close();
    }
}
