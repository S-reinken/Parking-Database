package main;

import java.io.*;
//import java.nio.*;

class DataStreamer
{
    BufferedReader reader;
    //BufferedWriter writer;
    
    public String updateListin()
    throws java.io.IOException
    {
    	String a = "";
        a = reader.readLine();
        //System.out.println(a);
        return (a);
    }
    public void activate()
    throws java.io.FileNotFoundException, java.io.IOException
    {
    	reader = new BufferedReader(new FileReader("/Users/schuylerreinken/Desktop/DataStreamer.txt"));
    	//reader = new BufferedReader(new FileReader("W://Students//Preparatory//Computer Science//dropbox//DataStreamer.txt"));
    }
    
    /*public void updateListout(String a)
    throws java.io.FileNotFoundException, java.io.IOException
    {
        writer = new BufferedWriter(new FileWriter("DataStreamer.txt"));
    }*/
}

