package model.log;

import model.employees.HRPerson;
import model.employees.Person;

public class UserAction {

    public int createPerson = 0;
    public int changeValue = 1;
    public int setAssignement = 2;
    public int deletePerson = 4;
    private String actionDescription[];
    private String entry;

    public UserAction(HRPerson hrPerson, Person person, int action){

    }

    public String getEntry() {
        return entry;
    }
}

