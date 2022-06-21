package model.company;

import model.employees.Person;

import java.util.Vector;

public class Department {

    private String name;


    public Department(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
