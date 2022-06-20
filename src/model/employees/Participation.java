package model.employees;

import model.company.JobFunctions;
import model.company.Teams;

import java.util.Vector;

public class Participation {
    private JobFunctions[] function;
    private Vector<Teams> teams;
    private Person owner;

    public Participation(String person){

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
