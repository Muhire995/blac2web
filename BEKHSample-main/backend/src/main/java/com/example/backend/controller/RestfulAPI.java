package com.example.backend.controller;

import app.DBMS;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Queue;
import java.sql.DriverManager;
import java.sql.Connection;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class RestfulAPI {
    DBMS db=new DBMS();

    public RestfulAPI() throws SQLException {
    }

    @GetMapping("/")
    public ResponseEntity<Object> getData(){
        return new ResponseEntity<>(new String[]{"successfully"},HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerBus(@RequestBody Map<String,Object> bus) throws SQLException {
        db.registerBus(bus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody Map<String, Object> newStaff) throws SQLException {

        db.signUp(newStaff);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("eRegister")
    public ResponseEntity<Void> eRegister(@RequestBody Map<String, Object> newEvent) throws SQLException, ParseException {
        db.eRegister(newEvent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody Map<String,String> credentials) throws SQLException {

        return new ResponseEntity<>(db.login(credentials),HttpStatus.OK);
    }

    @GetMapping("businesses")
    public ResponseEntity<Object> getBus() throws SQLException {
        return new ResponseEntity<>(db.getBus(),HttpStatus.OK);
    }

    @GetMapping("events")
    public ResponseEntity<Object> getEvents() throws SQLException {
        return new ResponseEntity<>(db.getEvents(),HttpStatus.OK);
    }


    @GetMapping("event/{id}")
    public ResponseEntity<Object> getEvent(@PathVariable String id) throws SQLException {

        return new ResponseEntity<>(db.getEvent(id),HttpStatus.OK);
    }
    @GetMapping("event/del/{id}")
    public String delete(@PathVariable String id) throws SQLException {

        db.deleteEvent(id);
        return "deleted";
    }

    @GetMapping("upEvents")
    public ResponseEntity<Object> getUpEvents() throws SQLException, ParseException {
        return new ResponseEntity<>(db.getUpEvents(),HttpStatus.OK);
    }
}
