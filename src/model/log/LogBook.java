package model.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Vector;

public class LogBook {

    private Vector<String> entries;
    LogBook logBook= new LogBook();
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean fileWritingEnabled = false;

    private LogBook(){}

    public LogBook getLogBook() {
        return logBook;
    }

    public void addEntry(UserAction entry){

    }

    public UserAction getEntry(int index){
        return
    }

    public int getSize(){
        return
    }

    public void logBookClosed(){

    }

    public void printLog(){

    }

    public void writeFile(){

    }

    public void readFile(){

    }
}
