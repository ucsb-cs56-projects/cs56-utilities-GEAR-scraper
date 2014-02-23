package edu.ucsb.cs56.projects.utilities.GEAR_scraper;

import java.net.URL;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** Command Line Interface class
 * modeled on Phill Conrad lecture notes at http://www.cs.ucsb.edu/~pconrad/cs56/14W/lect/02.06/CLIExample.java
 * @author Alan Buzdar
 */

public class GEAR_scraper_Interface{

    private String prompt = "> ";
    private GEAR_scraper x;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<GECourse> p;


    public void go(String... args) {
	if(args.length==0)
	    x = new GEAR_scraper();
	else
	    x = new GEAR_scraper(args[0],Integer.parseInt(args[1]),Integer.parseInt(args[2]));
	p = x.createArrayList();

	boolean done = false;
	
	while (!done) {
	    // Prompt for input
	    System.out.print(prompt);

	    // Get next line input, minus leading and trailing whitespace
	    String line  = sc.nextLine().trim();
	 
	    if (line.contains("quit") ) {
		done = true;
	    } else if (line.contains("show") ) {
		this.show(line);
	    } else if (line.contains("help")) {
		this.help(line);
	    } else if (line.equals("")) {
		System.out.println("Type \"quit\" to quit");
	    } else {
		System.out.println("Unknown command: " + line);
		System.out.println("Try \"help\" or type \"quit\" to quit");
	    }
	} // end while

    } // end go

    public void show(String line){
	if(line.contains("all")){
		for(GECourse a: p)
		    System.out.println(a);
	    }
	else if(line.contains("areaD")){
	    for(GECourse a: p){
		if(a.isD())
		    System.out.println(a);}}
	else if(line.contains("areaE")){
	    for(GECourse a: p){
		if(a.isE())
		    System.out.println(a);}}	
	else if(line.contains("areaF")){
	    for(GECourse a: p){
		if(a.isF())
		    System.out.println(a);}}
	else if(line.contains("areaG")){
	    for(GECourse a: p){
		if(a.isG())
		    System.out.println(a);}}
	else if(line.contains("writing")){
	    for(GECourse a: p){
		if(a.isWriting())
		    System.out.println(a);}}
	else if(line.contains("american")){
	    for(GECourse a: p){
		if(a.isAmHistInst())
		    System.out.println(a);}}
	else if(line.contains("ethnicity")){
	    for(GECourse a: p){
		if(a.isEthnicity())
		    System.out.println(a);}}
	else if(line.contains("euro")){
	    for(GECourse a: p){
		if(a.isEuroTrad())
		    System.out.println(a);}}
	else{
	    System.out.println(line+" not recognized. possible show commands include: \"show all\"  \"show areaD\"  \"show areaE\"  \"show areaF\"  \"show areaG\"  \"show writing\"  \"show american\"  \"show ethnicity\"  \"show euro\" ");

	}
    }

    public void help(String line){
	//stub

    }

    public static void main(String... args){

	if(args.length==0 || args.length==3){
	GEAR_scraper_Interface n = new GEAR_scraper_Interface();
	n.go(args);    
	}
	else
	    System.out.println("Improperly formatted arguments. \n This program takes either no arguments, or all three of the following: URLofGEAR StartPage EndPage");
	
	
    }




}