package model.employees;

import model.company.Department;
import model.company.JobFunctions;
import model.company.Teams;

import java.util.Vector;

public class Participation {
    private Vector<JobFunctions> functions;
    private Vector<Teams> teams;
    private Department department;

    public Participation(Vector<JobFunctions> f, Vector<Teams> t, Department d){
        this.department = d;
        this.functions = f;
        this.teams = t;
    }
    public void addFunction(JobFunctions jobFunctions){
        functions.add(jobFunctions);
    }

    public String getFunctionName(int index){
        return functions.get(index).getName();
    }

    public void removeFunction(int index){
        functions.remove(index);
    }
    public int getNumberOfFunctions(){
        return functions.size();
    }

    public void addTeams (Teams teams){
        this.teams.add(teams);
    }

    public String getTeamName(int index){
       return teams.get(index).getName();
    }

    public void removeTeam(int index){
        teams.remove(index);
    }

    public Vector<Teams> getTeam(){
        return teams;
    }

    public int getNumberOfTeams(){
        return functions.size();
    }

    public String getDepartementName(){
        return department.getName();
    }

}
