package model.employees;

public class Person {

    private String firstName;
    private String lastName;
    private Participation participation;

    public Person(String fName, String lName, Participation p ){
        this.firstName= fName;
        this.lastName = lName;
        this.participation = p;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Participation getParticipation(){
        return participation;
    }


}
