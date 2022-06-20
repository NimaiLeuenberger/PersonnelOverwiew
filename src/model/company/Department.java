package model.company;

import model.employees.Person;

import java.util.Vector;

public class Department {

    private String name;
    private Vector<Person> members;


    public Department(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addMember(Person person){
        this.members.add(person);
    }

    public Person getMember(int index){
        return getMember(index);
    }
    public void remoceMember(int index){
        this.members.remove(members);
    }
    public int getNumberOfMembers(){
        return getNumberOfMembers();
    }
}
