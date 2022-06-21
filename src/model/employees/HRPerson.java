package model.employees;

public class HRPerson extends Person{

    private int modus;
    private String pwd;

    public HRPerson(String fName, String lName){
        super(fName, lName);
        this.modus =
    }
    public void change(String person, int modus) {

    }

    public void setModus(int modus) {
        this.modus = modus;
    }

    public int getModus() {
        return modus;
    }

    public void setPassword(String pwd) {
        this.pwd = pwd;
    }

    public String getPassword() {
        return pwd;
    }

    public void writeLogEntry(int action, String person){

    }
}
