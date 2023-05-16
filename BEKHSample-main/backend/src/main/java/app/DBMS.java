package app;

import org.springframework.web.bind.annotation.PostMapping;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBMS {
    private Connection c = null;
    private PreparedStatement pstmt = null;

    public DBMS() throws SQLException {
        connectDB();
    }

    public void connectDB() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bekh", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }


    public void registerBus(Map<String,Object> newBus) throws SQLException {
        String sql = "INSERT INTO business (business_name, owner_name, email, phone, address, ownership, website, description)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        pstmt = c.prepareStatement(sql);
        pstmt.setString(1,newBus.get("business_name").toString());
        pstmt.setString(2,newBus.get("owner_name").toString());
        pstmt.setString(3,newBus.get("email").toString());
        pstmt.setString(4,newBus.get("phone").toString());
        pstmt.setString(5,newBus.get("address").toString());
        pstmt.setString(6,newBus.get("ownership").toString());
        pstmt.setString(7,newBus.get("website").toString());
        pstmt.setString(8,newBus.get("description").toString());

        // Execute the insert statement
        int rowsInserted = pstmt.executeUpdate();

    }

    public void signUp(Map<String,Object> newStaff) throws SQLException {
        String sql = "INSERT INTO staff (firstname, lastname, email, phone, password)" +
                " VALUES (?, ?, ?, ?, ?)";
        pstmt = c.prepareStatement(sql);
        pstmt.setString(1,newStaff.get("firstname").toString());
        pstmt.setString(2,newStaff.get("lastname").toString());
        pstmt.setString(3,newStaff.get("email").toString());
        pstmt.setString(4,newStaff.get("phone").toString());
        pstmt.setString(5,newStaff.get("password").toString());

        // Execute the insert statement
        int rowsInserted = pstmt.executeUpdate();

    }

    public void eRegister(Map<String, Object> newEvent) throws SQLException {
        String sql = "INSERT INTO event (title, host, address, event_date, event_time, description)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        pstmt = c.prepareStatement(sql);
        pstmt.setString(1,newEvent.get("title").toString());
        pstmt.setString(2,newEvent.get("host").toString());
        pstmt.setString(3,newEvent.get("address").toString());
        pstmt.setString(4,newEvent.get("event_date").toString());
        pstmt.setString(5,newEvent.get("event_time").toString());
        pstmt.setString(6,newEvent.get("description").toString());
        // Execute the insert statement
        int rowsInserted = pstmt.executeUpdate();
    }

    public Object login(Map<String, String> credentials) throws SQLException {
        // Define the query with a parameter
        String query = "SELECT * FROM staff WHERE email = ? AND password= ?";

        //  Create a prepared statement with the query
        PreparedStatement pstmt = c.prepareStatement(query);

        // Set the parameter value
        pstmt.setString(1, credentials.get("email"));
        pstmt.setString(2, credentials.get("password"));

        // Execute the query and get the result set
        ResultSet rs = pstmt.executeQuery();

        // Loop through the result set and print the values
        Object id=null;
        while (rs.next()) {
            id = rs.getObject("id");
        }

        // Close the result set, prepared statement, and connection
        rs.close();
        return id;
    }

    public Object getBus() throws SQLException {
        // Define the query with a parameter
        String query = "select * from business";

        //  Create a prepared statement with the query
        PreparedStatement pstmt = c.prepareStatement(query);

        // Execute the query and get the result set
        ResultSet rs = pstmt.executeQuery();
        System.out.println(rs);


        ArrayList<Map<String,String>> businesses=new ArrayList<>();

        // Loop through the result set and print the values
        while (rs.next()) {
            //business_name, owner_name, email, phone, address, ownership, website, description

            HashMap<String, String> newBus=new HashMap<>();
            newBus.put("id",rs.getString("id"));
            newBus.put("business_name",rs.getString("business_name"));
            newBus.put("owner_name",rs.getString("owner_name"));
            newBus.put("email",rs.getString("email"));
            newBus.put("address",rs.getString("address"));
            newBus.put("ownership",rs.getString("ownership"));
            newBus.put("website",rs.getString("website"));
            newBus.put("description",rs.getString("description"));

            businesses.add(newBus);
        }

        // Close the result set, prepared statement, and connection
        rs.close();
        return businesses;
    }

    public Object getEvents() throws SQLException {
        // Define the query with a parameter
        String query = "select * from event";

        //  Create a prepared statement with the query
        PreparedStatement pstmt = c.prepareStatement(query);

        // Execute the query and get the result set
        ResultSet rs = pstmt.executeQuery();
        System.out.println(rs);


        ArrayList<Map<String,String>> events=new ArrayList<>();

        // Loop through the result set and print the values
        while (rs.next()) {
            //business_name, owner_name, email, phone, address, ownership, website, description

            HashMap<String, String> newBus=new HashMap<>();
            newBus.put("id",rs.getString("id"));
            newBus.put("title",rs.getString("title"));
            newBus.put("host",rs.getString("host"));
            newBus.put("address",rs.getString("address"));
            newBus.put("event_date",rs.getString("event_date"));
            newBus.put("event_time",rs.getString("event_time"));
            newBus.put("description",rs.getString("description"));

            events.add(newBus);
        }

        // Close the result set, prepared statement, and connection
        rs.close();
        return events;
    }

    public Object getEvent(String id) throws SQLException {

        // Define the query with a parameter
        String query = "select * from event where id = ? ::uuid";

        //  Create a prepared statement with the query
        PreparedStatement pstmt = c.prepareStatement(query);
        pstmt.setString(1,id);

        // Execute the query and get the result set
        ResultSet rs = pstmt.executeQuery();
        Map<String,String> event=new HashMap<>();

        // Loop through the result set and print the values
        while (rs.next()) {
            //business_name, owner_name, email, phone, address, ownership, website, description
            event.put("id", rs.getString("id"));
            event.put("title", rs.getString("title"));
            event.put("host", rs.getString("host"));
            event.put("address", rs.getString("address"));
            event.put("event_date", rs.getString("event_date"));
            event.put("event_time", rs.getString("event_time"));
            event.put("description", rs.getString("description"));

        }

        // Close the result set, prepared statement, and connection
        rs.close();
        return event;
    }
    public void deleteEvent(String id) throws SQLException {

        // Define the query with a parameter
        String query = "delete from event where id = ? ::uuid";

        //  Create a prepared statement with the query
        PreparedStatement pstmt = c.prepareStatement(query);
        pstmt.setString(1,id);

        // Execute the query and get the result set
        int rs = pstmt.executeUpdate();

        // Close the result set, prepared statement, and connection

    }
    public Object getUpEvents() throws SQLException, ParseException {
        // Define the query with a parameter
        String query = "select * from event";

        //  Create a prepared statement with the query
        PreparedStatement pstmt = c.prepareStatement(query);

        // Execute the query and get the result set
        ResultSet rs = pstmt.executeQuery();
        System.out.println(rs);


        ArrayList<Map<String,String>> events=new ArrayList<>();

        // Loop through the result set and print the values
        while (rs.next()) {
            //business_name, owner_name, email, phone, address, ownership, website, description

            HashMap<String, String> newBus=new HashMap<>();
            newBus.put("id",rs.getString("id"));
            newBus.put("title",rs.getString("title"));
            newBus.put("host",rs.getString("host"));
            newBus.put("address",rs.getString("address"));
            newBus.put("event_date",rs.getString("event_date"));
            newBus.put("event_time",rs.getString("event_time"));
            newBus.put("description",rs.getString("description"));

            Date date=new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("event_date"));
            LocalDate localDate=LocalDate.now();
            Date today = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            if(date.after(today)) {
                events.add(newBus);
            }
        }

        // Close the result set, prepared statement, and connection
        rs.close();
        return events;
    }

}
