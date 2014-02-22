package edu.ucsb.cs56.projects.utilities.GEAR_scraper;

/**
 * CoEGECourse Interface
 * @version CS56, Winter 2014
 * 
 */

public class GECourse implements CoEgeCourse{
    private String deptInGear;
    private String deptCode;
    private String courseNum;
    private boolean isD;
    private boolean isE;
    private boolean isF;
    private boolean isG;
    private boolean isWriting;
    private boolean isAmHistInst;
    private boolean isEuroTrad;
    private boolean isEthnicity;

    public GECourse(String line,String area){
	if (area.equals("D"))
	    isD = true;
	if (area.equals("E"))
	    isE = true;
	if (area.equals("F"))
	    isF = true;
	if (area.equals("G"))
	    isG = true;
	if (line.contains("*"))
	    isWriting = true;
	if (line.contains("@"))
	    isAmHistInst = true;
	if (line.contains("&"))
	    isEthnicity = true;
	if (line.contains("^"))
	    isEuroTrad = true;
	int p = 0;
	deptInGear = "";
	for(String s: line.split("\\s+")){
		if(( s.contains("0") || s.contains("1") || s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("7") || s.contains("8") || s.contains("9"))&& (p==0)){
		    courseNum = s;
		    p = 1;
		}
		else if(p==0 & !(s.contains("*")) & !(s.contains("&")) & !(s.contains("@")) & !(s.contains("^")) )
		    deptInGear+=(" "+s);		    

	    }


    }

    public String getDeptInGear(){return deptInGear;} // department offering the course, exactly as formatted in GEAR
                            // e.g. Anthropology
	public String getDeptCode(){return deptCode;}  // department code (){e.g. ANTH} as in GOLD (){you'll have to translate to get that}
    public String getCourseNum(){return courseNum;} // e.g. 118B 
    public boolean isD(){return isD;} // its on the area D list
    public boolean isE(){return isE;} // its on the area E list
    public boolean isF(){return isF;} // its on the area F list
    public boolean isG(){return isG;} // its on the area G list
    public boolean isWriting(){return isWriting;} // This course applies toward the writing requirement. 
    public boolean isAmHistInst(){return isAmHistInst;} // This course applies toward the American History & Institutions requirement.
    public boolean isEthnicity(){return isEthnicity;} //  This course applies toward the ethnicity requirement.
    public boolean isEuroTrad(){return isEuroTrad;} // This course applies toward the European Traditions requirement.
}