package model.company;

import java.util.Vector;

public class JobFunctions {

    private String jobFunction;

    public JobFunctions(String jobFunction){
        this.jobFunction = jobFunction;
    }

    public String getName(){
        return jobFunction;
    }
}
