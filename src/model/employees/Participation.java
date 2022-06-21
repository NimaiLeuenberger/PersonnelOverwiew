package model.employees;

import model.company.Department;
import model.company.JobFunctions;
import model.company.Teams;

import java.util.Vector;

public class Participation {
    private Vector<JobFunctions> function;
    private Vector<Teams> teams;
    private Department department;

    public Participation(JobFunctions f, Teams t, Department d){
        this.department = d;
        this.function = new Vector<>();
        this.teams = new Vector<>();
    }
    public void addFunction(JobFunctions jobFunctions){

    }

    public String getFunctionName(int index){
        return getFunctionName(index);
    }

    public void removeFunction(int index){

    }
    public int getNumberOfFunctions(){
        return getNumberOfFunctions();
    }

    public void addTeams (Teams teams){

    }

    public String getTeamName(int index){
       return getTeamName(index);
    }

    public void removeTeam(int index){
        teams.remove(index);
    }

    public int getNumberOfTeams(){
        return teams.size();
    }

}
