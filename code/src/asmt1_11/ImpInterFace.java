package asmt1_11;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Iterable;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import asmt1_11.InterFace;
import asmt1_11.*;
import asmt1_13.*;
import asmt1_14.*;
import asmt1_15.*;

 
public class ImpInterFace extends UnicastRemoteObject implements InterFace {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id2;
	public static String courseID1;
	public static String semester1;
	public static String studentID1;
	public static String userid;
	public char id3;
	public int capacity;
	static boolean flag= false;
	static int capa;
	public static final DateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static int logg;
	public static int logg1=2;
	Scanner scanner = new Scanner(System.in);
	

	
    // List<Integer> compsubjectsdetails = new ArrayList<Integer>();
	public static final HashMap<String, Integer> compfallsubject1 = new HashMap<String, Integer>();   // comp1111 5
	public static final HashMap<String,Integer> soenfallsubject1 = new HashMap<String, Integer>();
	public static final HashMap<String, Integer> insefallsubject1 = new HashMap<String, Integer>();
	
	public static final HashMap<String, Integer> compwintersubject1 = new HashMap<String, Integer>();  //  
	public static final HashMap<String,Integer> soenwintersubject1 = new HashMap<String, Integer>();
	public static final HashMap<String, Integer> insewintersubject1 = new HashMap<String, Integer>();
	
	public static final HashMap<String, Integer> compsummersubject1 = new HashMap<String, Integer>();
	public static final HashMap<String,Integer> soensummersubject1= new HashMap<String, Integer>();
	public static  final HashMap<String, Integer> insesummersubject1 = new HashMap<String, Integer>();
	
	public static final HashMap<String, Integer> compfallsubject = new HashMap<String, Integer>();   // comp1111 5
	public  static final HashMap<String,Integer> soenfallsubject = new HashMap<String, Integer>();
	public  static final HashMap<String, Integer> insefallsubject = new HashMap<String, Integer>();
	
	public  static final HashMap<String, Integer> compwintersubject = new HashMap<String, Integer>();  //  
	public static  final HashMap<String,Integer> soenwintersubject = new HashMap<String, Integer>();
	public  static final HashMap<String, Integer> insewintersubject = new HashMap<String, Integer>();
	
	public  static final HashMap<String, Integer> compsummersubject = new HashMap<String, Integer>();
	public  static final HashMap<String,Integer> soensummersubject = new HashMap<String, Integer>();
	public  static final HashMap<String, Integer> insesummersubject = new HashMap<String, Integer>();

	
	public  static final HashMap<String, String> compfallstudent = new HashMap<String, String>();   //  comps1111  comp1111
	public  static final HashMap<String,String> soenfallstudent = new HashMap<String, String>();
	public  static final HashMap<String, String> insefallstudent = new HashMap<String, String>();
	
	public  static final HashMap<String, String> compwinterstudent = new HashMap<String, String>();
	public static final  HashMap<String,String> soenwinterstudent = new HashMap<String, String>();
	public static final  HashMap<String, String> insewinterstudent = new HashMap<String, String>();
	
	public  static final HashMap<String, String> compsummerstudent = new HashMap<String, String>();
	public  static final HashMap<String,String> soensummerstudent = new HashMap<String, String>();
	public  static final HashMap<String, String> insesummerstudent = new HashMap<String, String>();
	
	
	
	public static final HashMap<String, ArrayList<String>> compadvisor = new HashMap<String, ArrayList<String>>();
	public static final ArrayList<String> compfallsub = new ArrayList<String>();
	public  static final ArrayList<String> compwintersub = new ArrayList<String>();
	public  static final ArrayList<String> compsummersub = new ArrayList<String>();
	
	public  static final HashMap<String, ArrayList<String>> soenadvisor = new HashMap<String, ArrayList<String>>();
	public  static final ArrayList<String> soenfallsub = new ArrayList<String>();
	public static  final ArrayList<String> soenwintersub = new ArrayList<String>();
	public  static final ArrayList<String> soensummersub = new ArrayList<String>();
	
	public  static final HashMap<String, ArrayList<String>> inseadvisor = new HashMap<String, ArrayList<String>>();
	public static final ArrayList<String> insefallsub = new ArrayList<String>();
	public static final ArrayList<String> insewintersub = new ArrayList<String>();
	public  static final ArrayList<String> insesummersub = new ArrayList<String>();

	public  void default_values()
	{
		capa=0;
		logg=2;
		compadvisor.put("fall",compfallsub);
		compadvisor.put("winter",compwintersub);
		compadvisor.put("summer",compsummersub);
		compfallsub.add("comp1111");
		compfallsub.add("comp2222");
		compfallsub.add("comp3333");
		compsummersub.add("comp1111");
		
		soenadvisor.put("fall",soenfallsub);
		soenadvisor.put("winter",soenwintersub);
		soenadvisor.put("summer",soensummersub);
		soenfallsub.add("soen1111");
		soenfallsub.add("soen2222");
		soenfallsub.add("soen3333");
		soenwintersub.add("soen1111");
		soensummersub.add("soen2222");
		
		inseadvisor.put("fall",insefallsub);
		inseadvisor.put("winter",insewintersub);
		inseadvisor.put("summer",insesummersub);
		insefallsub.add("inse2222");
		insesummersub.add("inse3333");


		compfallsubject1.put("comp1111", 5);
		compfallsubject1.put("comp2222", 6);
		compfallsubject1.put("comp3333", 6);
		compsummersubject1.put("comp1111", 7);
		soenfallsubject1.put("soen1111", 4);
		soenfallsubject1.put("soen2222", 5);
		soenfallsubject1.put("soen3333", 9);
		soenwintersubject1.put("soen1111", 6);
		soensummersubject1.put("soen2222", 9);
		insefallsubject1.put("inse2222", 4);
		insesummersubject1.put("inse3333",8);
		
		compfallsubject.put("comp1111", 3);
		compfallsubject.put("comp2222", 6);
		compfallsubject.put("comp3333", 6);
		compsummersubject.put("comp1111", 7);
		soenfallsubject.put("soen1111", 4);
		soenfallsubject.put("soen2222", 4);
		soenfallsubject.put("soen3333", 9);
		soenwintersubject.put("soen1111", 5);
		soensummersubject.put("soen2222", 9); 
		insefallsubject.put("inse2222", 4);
		insesummersubject.put("inse3333",8);
		
		
		compfallstudent.put("comps11111", "comp1111");
	//	compfallstudent.put("comps11112", "soen2222");
		compfallstudent.put("soens11111", "comp1111");
		compfallstudent.put("soens11112", "soen2222");
		
		compwinterstudent.put("comps11111", "soen1111");
		
			
	}
	
	public void UserId (String id) throws RemoteException
	{
		userid=id;
	}
	
	
	public synchronized String  listCourseAvailabilityserver(String semester1,String id1){
		
		
		
		if(id1.equals("server1"))
		{
			if(semester1.trim().equals("fall"))
			{
				String aaa=" "; 
				for(Map.Entry entry:compfallsubject.entrySet()){
				    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
				}
				//System.out.println(aaa);
				return aaa;
			}
			else if(semester1.trim().equals("winter"))
			{
				String aaa=" "; 

				for(Map.Entry entry:compwintersubject.entrySet()){
				    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
				}

				return aaa;
			}
			else if(semester1.trim().equals("summer"))
			{
				String aaa=" "; 

				for(Map.Entry entry:compsummersubject.entrySet()){
				    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
				}
	
				return aaa;
			}
			
			
		}
		else if(id1.equals("server2"))
		{
		if(semester1.trim().trim().equals("fall"))
		{
			String aaa=null;
			aaa=" "; 
			for(Map.Entry entry2:soenfallsubject.entrySet()){
			    aaa=aaa+entry2.getKey() + "  " + entry2.getValue()+", ";
			}
			System.out.println(aaa);
			return aaa;
		}
		else if(semester1.trim().equals("winter"))
		{
			String aaa=" ";

			for(Map.Entry entry:soenwintersubject.entrySet()){
			    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
			}

			return aaa;
		}
		else if(semester1.trim().equals("summer"))
		{
			String aaa=" ";


			for(Map.Entry entry:soensummersubject.entrySet()){
			    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
			}

			return aaa;
		}
		}
		else if(id1.equals("server3"))
		{
		if(semester1.trim().equals("fall"))
		{
			String aaa=" ";

			for(Map.Entry entry:insefallsubject.entrySet()){
			    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
			}


			return aaa;
		}
		else if(semester1.trim().equals("winter"))
		{
			String aaa=" ";

			for(Map.Entry entry:insewintersubject.entrySet()){
			    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
			}


			return aaa;
		}
		else if(semester1.trim().equals("summer"))
		{
			String aaa=" ";

			for(Map.Entry entry:insesummersubject.entrySet()){
			    aaa=aaa+entry.getKey() + "  " + entry.getValue()+", ";
			}

			return aaa;
		}
		}
		return "gg";
		// TODO Auto-generated method stub	
	}
	
	
	
	
	public static Object getKeyFromValue(Map hm, Object value) {
	    for (Object o : hm.keySet()) {
	      if (hm.get(o).equals(value)) {
	        return o;
	      }
	    }
	    return null;
	  }
	 
	public static synchronized int checkmaxterm(String studentID, String  semester)
	{
		ArrayList<String> arrli = new ArrayList<String>();
	
		int count1[]=new int[] {0,0,0};
		String h = studentID;
		for(int i=1;i<=3;i++)
		{
			 //Integer intInstance = new Integer(i);      
			
			if(semester.trim().equals("fall"))
			{
			arrli.add(compfallstudent.get(h+ Integer.toString(i)));
			arrli.add(soenfallstudent.get(h+Integer.toString(i)));
			arrli.add(insefallstudent.get(h+Integer.toString(i)));
			//System.out.println(str);
			for (String str : arrli) 
			{
				
				if(str!=null)
				{
					++count1[0];
				}
			}
			 arrli.clear();
			}
			if(semester.trim().equals("winter"))
			{ 
			arrli.add(compwinterstudent.get(h+Integer.toString(i)));
			arrli.add(soenwinterstudent.get(h+Integer.toString(i)));
			arrli.add(insewinterstudent.get(h+Integer.toString(i)));
			for (String str : arrli) 
			{
				if(str!=null)
				{
					++count1[1];
				}
			}
			 arrli.clear();
			}if(semester.trim().equals("summer"))
			{
			arrli.add(compsummerstudent.get(h+Integer.toString(i)));
			arrli.add(soensummerstudent.get(h+Integer.toString(i)));
		    arrli.add(insesummerstudent.get(h+Integer.toString(i)));
		    for (String str : arrli) 
			{
				if(str!=null)
				{
					++count1[2];
				}
			}
			 arrli.clear();
			}
		}
		arrli.clear();
		System.out.println(count1[0]+" "+count1[1]+" "+count1[2]+"term");
	/*	if(semester.equals("fall"))
		{
			return count1[0];
		}
		else if(semester.equals("winter"))
		{
			return count1[1];
		}
		else if(semester.equals("summer"))
		{
			return count1[2];
		}*/
		
		
		if(semester.trim().equals("fall"))
		{
			if(count1[0]==3)
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		else if(semester.trim().equals("winter"))
		{
			if(count1[1]==3)
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}else if(semester.trim().equals("summer"))
		{
			if(count1[2]==3)
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		return 999;
	}
	
	
	
	public static synchronized int checkmaxdep(String studentID, String  semester,String courseID)
	{
		ArrayList<String> arrli = new ArrayList<String>();
		
		int count[]=new int[] {0,0,0};
		
		String h = studentID;

		for(int i=1;i<=3;i++)
		{
			Integer intInstance = new Integer(i);      
			
			arrli.add(compfallstudent.get(h+intInstance.toString()));
			arrli.add(compwinterstudent.get(h+intInstance.toString()));
			arrli.add(compsummerstudent.get(h+intInstance.toString()));
			 
			arrli.add(soenfallstudent.get(h+intInstance.toString()));
			arrli.add(soenwinterstudent.get(h+intInstance.toString()));
			arrli.add(soensummerstudent.get(h+intInstance.toString()));
			 
			arrli.add(insefallstudent.get(h+intInstance.toString()));
			arrli.add(insewinterstudent.get(h+intInstance.toString()));
			 arrli.add(insesummerstudent.get(h+intInstance.toString()));
		}

		for (String str : arrli) {
			//System.out.println(str);
			if(str!=null)
			{
				if(str.substring(0,4).equals("comp"))
				{
					count[0]++;
				}
				else if(str.substring(0,4).equals("soen"))
				{
					count[1]++;
				}
				else if(str.substring(0,4).equals("inse"))
				{
					count[2]++;
				}
			}
		}

		System.out.println(count[0]+" "+count[1]+" "+count[2]+"dep");
		arrli.clear();
		String tmp = studentID.substring(0, 4);
		String tmp1 = courseID.substring(0, 4);
		System.out.println(tmp1);
		if(tmp1.equals("comp"))
		{
			++count[0];
		}else if(tmp1.equals("soen"))
		{
			count[1]=count[1]+1;
		}else if(tmp1.equals("inse"))
		{
			++count[2];
		}
		System.out.println(count[0]+" "+count[1]+" "+count[2]+"dep");
		if(tmp.equals("comp"))
		{
			if( count[1]>2  || count[2]>2 || (count[1]+count[2])>2)
			{
					return 0;
			}
			else
			{
				return 1;
			}
		}	
		else if(tmp.equals("soen"))
		{
			if(count[0]>2 || count[2]>2 || (count[0]+count[2])>2)
			{
					return 0;
			}
			else
				{
					return 1;
				}
		}else if(tmp.equals("inse"))
		{
			if(count[1]>2 || count[0]>2 || (count[1]+count[0])>2)
			{
				return 0;
			}
			else
			{
				return 1;
			}
		}
		
		//System.out.println(count1[0]+" "+count1[1]+" "+count1[2]);
		return 2;
	}
	
	
	public static synchronized int checkavailibility(String courseID, String semester)
	{
		String tmp = courseID.substring(0, 4);	
		
		if(tmp.trim().equals("comp"))
		{
			 if(semester.trim().equals("fall"))
			 {
				 int tmp1 = compfallsubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
			 else if(semester.trim().equals("winter"))
			 {
				 int tmp1 = compwintersubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
			 else if(semester.trim().equals("summer"))
			 {
				 int tmp1 = compsummersubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
		}
		else if(tmp.trim().equals("soen"))
		{
			 if(semester.trim().equals("fall"))
			 {
				 int tmp1 = soenfallsubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
			 else if(semester.trim().equals("winter"))
			 {
				 int tmp1 = soenwintersubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
			 else if(semester.trim().equals("summer"))
			 {
				 int tmp1 = soensummersubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
		}
		else if(tmp.trim().equals("inse"))
		{
			 if(semester.trim().equals("fall"))
			 {
				 int tmp1 = insefallsubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
			 else if(semester.trim().equals("winter"))
			 {
				 int tmp1 = insewintersubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
			 else if(semester.trim().equals("summer"))
			 {
				 int tmp1 = insesummersubject.get(courseID);
				 if(tmp1>0)
				 {
					 return 1;
				 }
				 else
				 {
					 return 0;
				 }	 
			 }
		}
		
		return 0;
		
	}
	
	
	public static synchronized int  checkenroll(String studentID, String courseID /*, String semester*/)
	{
		int f = 0;
	
			if(compfallsubject.containsKey(courseID) || soenfallsubject.containsKey(courseID) || insefallsubject.containsKey(courseID) || compwintersubject.containsKey(courseID) || soenwintersubject.containsKey(courseID) || insewintersubject.containsKey(courseID) || compsummersubject.containsKey(courseID) || soensummersubject.containsKey(courseID) || insesummersubject.containsKey(courseID) )
			{
				
				
				
				ArrayList<String> arrli = new ArrayList<String>();
								
				String h = studentID;

				for(int i=1;i<=3;i++)
				{
					Integer intInstance = new Integer(i);      
					
					arrli.add( (compfallstudent.get(h+intInstance.toString())));
					arrli.add(compwinterstudent.get(h+intInstance.toString()));
					arrli.add(compsummerstudent.get(h+intInstance.toString()));
					 
					arrli.add(soenfallstudent.get(h+intInstance.toString()));
					arrli.add(soenwinterstudent.get(h+intInstance.toString()));
					arrli.add(soensummerstudent.get(h+intInstance.toString()));
					 
					arrli.add(insefallstudent.get(h+intInstance.toString()));
					arrli.add(insewinterstudent.get(h+intInstance.toString()));
					 arrli.add(insesummerstudent.get(h+intInstance.toString()));
				}
				
				for (String str : arrli) {
					
					//System.out.println(str);
					if(courseID.equals(str))
					{
						f=1;
					}	
				}
				arrli.clear();
				/*
				if( (compfallstudent.get(studentID+"1").equals(courseID)) || compfallstudent.get(studentID+"2").equals(courseID) || compfallstudent.get(studentID+"3").equals(courseID) || soenfallstudent.get(studentID+"1").equals(courseID) || soenfallstudent.get(studentID+"2").equals(courseID) || soenfallstudent.get(studentID+"3").equals(courseID) || insefallstudent.get(studentID+"1").equals(courseID) || insefallstudent.get(studentID+"2").equals(courseID) || insefallstudent.get(studentID+"3").equals(courseID)
						|| compwinterstudent.get(studentID+"1").equals(courseID) || compwinterstudent.get(studentID+"2").equals(courseID) || compwinterstudent.get(studentID+"3").equals(courseID) || soenwinterstudent.get(studentID+"1").equals(courseID) || soenwinterstudent.get(studentID+"2").equals(courseID) || soenwinterstudent.get(studentID+"3").equals(courseID) || insewinterstudent.get(studentID+"1").equals(courseID) || insewinterstudent.get(studentID+"2").equals(courseID) || insewinterstudent.get(studentID+"3").equals(courseID)	
						|| compsummerstudent.get(studentID+"1").equals(courseID) || compsummerstudent.get(studentID+"2").equals(courseID) || compsummerstudent.get(studentID+"3").equals(courseID) || soensummerstudent.get(studentID+"1").equals(courseID) || soensummerstudent.get(studentID+"2").equals(courseID) || soensummerstudent.get(studentID+"3").equals(courseID) || insesummerstudent.get(studentID+"1").equals(courseID) || insesummerstudent.get(studentID+"2").equals(courseID) || insesummerstudent.get(studentID+"3").equals(courseID))
				{
					System.out.println("AA");
					return true;
				}
				else
				{
					System.out.println("BB");
					return false;
					
				}
				*/
			//	System.out.println("dd");
				//return f;
				
			}
			else
			{
				System.out.println("Course is not available in this term");
				//return 1;
				f=1;
				
			}
			return f;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// -----------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	public ImpInterFace() throws RemoteException {
		
		// TODO Auto-generated constructor stub
			if(flag==false)
			{
				default_values();
				flag=true;
			}
		
	}
public ImpInterFace(int a) throws RemoteException {
		
		// TODO Auto-generated constructor stub
			super();
		
	}
	public ImpInterFace(String studentID,String id2,char id3) throws RemoteException {
		
		// TODO Auto-generated constructor stub
		this.studentID1=studentID;
		this.id2=id2;
		this.id3=id3;
		System.out.print(studentID+id2+"6666"+id3);
		
	}
	


	@Override
	public synchronized void courseCapacity(int Capacity) throws RemoteException {
		// TODO Auto-generated method stub
		capa=Capacity;
	}
	
	@Override
	public synchronized String addCourse(String courseID, String semester) throws RemoteException
	{
		// comp1111 fall
		// only his dept course can be add
		// if it already add in that sem
		// put course in compfalladvisor
		// add capacity to compfallsubject1
		
		int o=2;
		
		if((courseID.substring(0, 4)).equals("comp"))
		{
			 if(semester.equals("fall"))
			 {
				 if(compfallsub.contains(courseID))
				 {
					 //return "course "+courseID+" is already added in fall term";
					 o=0;
				 }
				 else
				 {
					 compfallsub.add(courseID);
					 compfallsubject1.put(courseID, capa);
					 compfallsubject.put(courseID, capa);
					 //return "course "+courseID+" added in fall term";
					 o=1;
				 }
			 }else  if(semester.equals("winter"))
			 {
				 if(compwintersub.contains(courseID))
				 {
					 o=0;
					// return "course "+courseID+" is already added in winter term";
				 }
				 else
				 {
					 compwintersub.add(courseID);
					 compwintersubject1.put(courseID, capa);
					 compwintersubject.put(courseID, capa);
					 o=1;
					 //return "course "+courseID+" added in winter term";
				 }
			 }else  if(semester.equals("summer"))
			 {
				 if(compsummersub.contains(courseID))
				 {
					 o=0;
					// return "course "+courseID+" is already added in summer term";
				 }
				 else
				 {
					 compsummersub.add(courseID);
					 compsummersubject1.put(courseID, capa);
					 compsummersubject.put(courseID, capa);
					 o=1;
					 return "course "+courseID+" added in summer term";
				 }
			 }
		}
		else if((courseID.substring(0, 4)).equals("soen"))
		{
			
			if(semester.equals("fall"))
			 {
				 if(soenfallsub.contains(courseID))
				 {
					 o=0;
					 // return "course "+courseID+" is already added in fall term";
				 }
				 else
				 {
					 soenfallsub.add(courseID);
					 soenfallsubject1.put(courseID, capa);
					 soenfallsubject.put(courseID, capa);
					 o=1;
					 // return "course "+courseID+" added in fall term";
				 }
			 }else  if(semester.equals("winter"))
			 {
				 if(soenwintersub.contains(courseID))
				 {
					 o=0;
				   //	 return "course "+courseID+" is already added in winter term";
				 }
				 else
				 {
					 soenwintersub.add(courseID);
					 soenwintersubject1.put(courseID, capa);
					 soenwintersubject.put(courseID, capa);
					
					 o=1;
					 //  return "course "+courseID+" added in winter term";
				 }
			 }else  if(semester.equals("summer"))
			 {
				 if(soensummersub.contains(courseID))
				 {
					 o=0;
					 // return "course "+courseID+" is already added in summer term";
				 }
				 else
				 {
					 soensummersub.add(courseID);
					 soensummersubject1.put(courseID, capa);
					 soensummersubject.put(courseID, capa);
					 o=1;
					 // return "course "+courseID+" added in summer term";
				 }
			 }
			
			
		}
		else if((courseID.substring(0, 4)).equals("inse"))
		{
			 if(semester.equals("fall"))
			 {
				 if(insefallsub.contains(courseID))
				 {
					 o=0;
					 // return "course "+courseID+" is already added in fall term";
				 }
				 else
				 {
					 insefallsub.add(courseID);
					 insefallsubject1.put(courseID, capa);
					 insefallsubject.put(courseID, capa);
					 o=1;
					 // return "course "+courseID+" added in fall term";
				 }
			 }else  if(semester.equals("winter"))
			 {
				 if(insewintersub.contains(courseID))
				 {
					 o=0;
					 // return "course "+courseID+" is already added in summer term";
				 }
				 else
				 {
					 insewintersub.add(courseID);
					 insewintersubject1.put(courseID, capa);
					 insewintersubject.put(courseID, capa);
					 o=1;
					 // return "course "+courseID+" added in winter term";
				 }
			 }else  if(semester.equals("summer"))
			 {
				 if(insesummersub.contains(courseID))
				 {
					 o=0;
					 //	 return "course "+courseID+" is already added in summer term";
				 }
				 else
				 {
					 insesummersub.add(courseID);
					 insesummersubject1.put(courseID, capa);
					 insesummersubject.put(courseID, capa);
					 o=1;
					 // return "course "+courseID+" added in summer term";
				 }
			 }
		}
		
		
		
		
		
		String path = null;	
		if(userid.substring(0, 4).equals("comp"))
		{
			path="asmt1_13";
		}
		else if(userid.substring(0, 4).equals("soen"))
		{
			path="asmt1_14";
		}else if(userid.substring(0, 4).equals("inse"))
		{
			path="asmt1_15";
		}	
	
		
	
	
		     File f3 = new File("/Users/apple/Documents/projects/asmt1_1/src/"+path+"/"+userid+".txt");
		    
		
		
		
		
		if( o==0)
		{
 
			BufferedWriter output2;
			try {
				output2 = new BufferedWriter(new FileWriter(f3,true));
				output2.write(" Request failed , ");
				output2.write("course "+courseID+" is already added in "+semester+" term \n\n");
				output2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "course "+courseID+" is already added in "+semester+" term";
			
		}
		else if(o==1)
		{
			
			BufferedWriter output2;
			try {
				output2 = new BufferedWriter(new FileWriter(f3,true));
				output2.write(" Request successfully completed , ");
				output2.write("course "+courseID+" added in "+semester+" term\n\n");
				output2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "course "+courseID+" added in "+semester+" term";
		}
		
		
		return null;
	}

	
	@Override
	public synchronized String removeCourse(String courseID, String semester) throws RemoteException {
		
		// TODO Auto-generated method stub
		int o = 2;
		// only his dept course can be add
		// if it already add in that sem
		// put course in compfalladvisor
		// add capacity to compfallsubject1
		if((courseID.substring(0, 4)).equals("comp"))
		{
			 if(semester.equals("fall"))
			 {
				 if(!compfallsub.contains(courseID))
				 {
					 o=0;
					 //return "no such course like "+courseID+" is available in fall term";
				 }
				 else
				 {
					 compfallsub.remove(courseID);
					 compfallsubject1.remove(courseID);
					 compfallsubject.remove(courseID);
					 if(compfallstudent.containsValue(courseID))
					 {
						 String ii = (String) getKeyFromValue(compfallstudent,courseID);
						 compfallstudent.remove(ii);
					 }
					 o=1;
					 //return "course "+courseID+" is removed in fall term";
				 }
			 }else  if(semester.equals("winter"))
			 {
				 if(compwintersub.contains(courseID))
				 {
					 o=0;
					 // return "no such course like "+courseID+" is available in winter term";
				 }
				 else
				 {
					 compwintersub.remove(courseID);
					 compwintersubject1.remove(courseID);
					 compwintersubject.remove(courseID);
					 if(compwinterstudent.containsValue(courseID))
					 {
						 String ii = (String) getKeyFromValue(compwinterstudent,courseID);
						 compwinterstudent.remove(ii);
					 }
					o=1;
					 //return "course "+courseID+" is removed in winter term";
				 }
			 }else  if(semester.equals("summer"))
			 {
				 if(compsummersub.contains(courseID))
				 {
					o=0;
					 // return "no such course like "+courseID+" is available in summer term";
				 }
				 else
				 {
					 compsummersub.remove(courseID);
					 compsummersubject1.remove(courseID);
					 compsummersubject.remove(courseID);
					 if(compsummerstudent.containsValue(courseID))
					 {
						 String ii = (String) getKeyFromValue(compsummerstudent,courseID);
						 compsummerstudent.remove(ii);
					 }
					o=1;
					 // return "course "+courseID+" is removed in summer term";
				 }
			 }
		}
		else if((courseID.substring(0, 4)).equals("soen"))
		{
			
			if(semester.equals("fall"))
			 {
				 if(soenfallsub.contains(courseID))
				 {
					 o=0;
					// return "no such course like "+courseID+" is available in fall term";
				 }
				 else
				 {
					 soenfallsub.remove(courseID);
					 soenfallsubject1.remove(courseID, capa);
					 soenfallsubject.remove(courseID, capa);
					 if(soenfallstudent.containsValue(courseID))
					 {
						 String ii = (String) getKeyFromValue(soenfallstudent,courseID);
						 soenfallstudent.remove(ii);
					 }
					o=1;
					 // return "course "+courseID+" is removed in fall term";
				 }
			 }else  if(semester.equals("winter"))
			 {
				 if(soenwintersub.contains(courseID))
				 {
					o=0;
					 // return "no such course like "+courseID+" is available in winter term";
				 }
				 else
				 {
					 soenwintersub.remove(courseID);
					 soenwintersubject1.remove(courseID, capa);
					 soenwintersubject.remove(courseID, capa);
					 if(soenwinterstudent.containsValue(courseID))
					 {
						 String ii = (String) getKeyFromValue(soenwinterstudent,courseID);
						 soenwinterstudent.remove(ii);
					 }
					o=1;
					 // return "course "+courseID+" is removed in winter term";
				 }
			 }else  if(semester.equals("summer"))
			 {
				 if(soensummersub.contains(courseID))
				 {
					o=0;
					 // return "no such course like "+courseID+" is available in summer term";
				 }
				 else
				 {
					 soensummersub.remove(courseID);
					 soensummersubject1.remove(courseID, capa);
					 soensummersubject.remove(courseID, capa);
					 if(soensummerstudent.containsValue(courseID))
					 {
						 String ii = (String) getKeyFromValue(soensummerstudent,courseID);
						 soensummerstudent.remove(ii);
					 }
				o=1;
					 //	 return "course "+courseID+" is removed in summer term";
				 }
			 }
			
			
		}
		else if((courseID.substring(0, 4)).equals("inse"))
		{
			 if(semester.equals("fall"))
			 {
				 if(insefallsub.contains(courseID))
				 {
					
					 o=0;
					 // return "no such course like "+courseID+" is available in fall term";
				 }
				 else
				 {
					 insefallsub.remove(courseID);
					 insefallsubject1.remove(courseID, capa);
					 insefallsubject.remove(courseID, capa);
					 if(insefallstudent.containsValue(courseID))
					 {
						 String ii = (String) getKeyFromValue(insefallstudent,courseID);
						 insefallstudent.remove(ii);
					 }
					
					 o=1;
					// return "course "+courseID+" is removed in fall term";
				 }
			 }else  if(semester.equals("winter"))
			 {
				 if(insewintersub.contains(courseID))
				 {
					o=0;
					 // return "no such course like "+courseID+" is available in summer term";
				 }
				 else
				 {
					 insewintersub.remove(courseID);
					 insewintersubject1.remove(courseID, capa);
					 insewintersubject.remove(courseID, capa);
					 if(insewinterstudent.containsValue(courseID))
					 {
						 String ii = (String) getKeyFromValue(insewinterstudent,courseID);
						 insewinterstudent.remove(ii);
					 }
					o=1;
					 // return "course "+courseID+" is removed in winter term";
				 }
			 }else  if(semester.equals("summer"))
			 {
				 if(insesummersub.contains(courseID))
				 {
					 o=0;
					 // return "no such course like "+courseID+" is available in summer term";
				 }
				 else
				 {
					 insesummersub.remove(courseID);
					 insesummersubject1.remove(courseID, capa);
					 insesummersubject.remove(courseID, capa);
					 if(insesummerstudent.containsValue(courseID))
					 {
						 String ii = (String) getKeyFromValue(insesummerstudent,courseID);
						 insesummerstudent.remove(ii);
					 }
					 o=1;
					 // return "course "+courseID+" is removed in summer term";
				 }
			 }
		}
		

		String path = null;	
		if(userid.substring(0, 4).equals("comp"))
		{
			path="asmt1_13";
		}
		else if(userid.substring(0, 4).equals("soen"))
		{
			path="asmt1_14";
		}else if(userid.substring(0, 4).equals("inse"))
		{
			path="asmt1_15";
		}	
	
		
	
	
		     File f3 = new File("/Users/apple/Documents/projects/asmt1_1/src/"+path+"/"+userid+".txt");
		    
		
		
		
		
		if( o==0)
		{
               
			BufferedWriter output2;
			try {
				output2 = new BufferedWriter(new FileWriter(f3,true));
				output2.write(" Request failed , ");
				output2.write("no such course like "+courseID+" is available in "+semester+" term \n\n");
				output2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "no such course like "+courseID+" is available in "+semester+" term";
			
		}
		else if(o==1)
		{
			
			BufferedWriter output2;
			try {
				output2 = new BufferedWriter(new FileWriter(f3,true));
				output2.write(" Request successfully completed , ");
				output2.write("course "+courseID+" added in "+semester+" term\n\n");
				output2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "course "+courseID+" remove in "+semester+" term";
		}
		
		return null;
	}

	@Override
	public  synchronized String  listCourseAvailability(String semester) throws RemoteException {
		
		String list="";
		if((userid.substring(0, 4)).equals("comp"))
		{
			Server1 SerVer1= new Server1();
			 list=semester+" - ";
			String s1= listCourseAvailabilityserver(semester,"server1");
			String s2=SerVer1.listCourseAvailabilitys1send(semester);
			//String s2= SerVer1.listCourseAvailabilitys1get();
			list=list+s1+s2;
			return list;
		}else if((userid.substring(0, 4)).equals("soen"))
		{
			Server2 SerVer2= new Server2();
			 list=semester+" - ";
			String s1= listCourseAvailabilityserver(semester,"server2");
			String s2=SerVer2.listCourseAvailabilitys2send(semester);
			list=list+s1+s2;
			return list;
		}else if((userid.substring(0, 4)).equals("inse"))
		{
			Server3 SerVer3= new Server3();
			 list=semester+" - ";
			String s1= listCourseAvailabilityserver(semester,"server3");
			String s2=SerVer3.listCourseAvailabilitys3send(semester);
			list=list+s1+s2;
			return list;
		}
		
		
		return list;
		// TODO Auto-generated method stub
		
		
	}
	
	
	
	
	public static synchronized int minuscap(String courseID,String sem)
	{
		int hh;
		if(sem.equals("fall"))
		{
			if(courseID.equals("comp"))
			{
					hh=compfallsubject.get(courseID);
					hh=hh-1;
					compfallsubject.put(courseID, hh);
			}else if(courseID.equals("soen"))
			{
				hh=soenfallsubject.get(courseID);
				hh=hh-1;
				soenfallsubject.put(courseID, hh);
			}else if(courseID.equals("inse"))
			{
				hh=insefallsubject.get(courseID);
				hh=hh-1;
				insefallsubject.put(courseID, hh);
			}
			return 1;
		}else if(sem.equals("winter"))
		{
			if(courseID.equals("comp"))
			{
					hh=compwintersubject.get(courseID);
					hh=hh-1;
					compwintersubject.put(courseID, hh);
			}else if(courseID.equals("soen"))
			{
				hh=soenwintersubject.get(courseID);
				hh=hh-1;
				soenwintersubject.put(courseID, hh);
			}else if(courseID.equals("inse"))
			{
				hh=insewintersubject.get(courseID);
				hh=hh-1;
				insewintersubject.put(courseID, hh);
			}
			return 1;
		}else if(sem.equals("summer"))
		{
			if(courseID.equals("comp"))
			{
					hh=compsummersubject.get(courseID);
					hh=hh-1;
					compsummersubject.put(courseID, hh);
			}else if(courseID.equals("soen"))
			{
				hh=soensummersubject.get(courseID);
				hh=hh-1;
				soensummersubject.put(courseID, hh);
			}else if(courseID.equals("inse"))
			{
				hh=insesummersubject.get(courseID);
				hh=hh-1;
				insesummersubject.put(courseID, hh);
			}
			return 1;
		}
		else
		{
			return 0;
		}
							
							
	}
	public static synchronized String enrolCourse1(String studentID, String courseID, String semester) {
		// TODO Auto-generated method stub
		
		int chk=9;
		int z,vv;
		studentID1=studentID;
		courseID1=courseID;
		semester1=semester;
		studentID.trim();
		courseID.trim();
		semester.trim();
	//	System.out.println(studentID+courseID+courseID);
		
			int flag1 = checkenroll(studentID, courseID/*,  semester*/);
			if(flag1==1)
			{
				chk=1;
			}
			else if(flag1==0)
			{
				
				int flag3 = checkmaxdep(studentID,semester,courseID);
				int flag4 = checkmaxterm(studentID,semester);
				System.out.print(flag3);
				System.out.print(flag4);
				if(flag3==1 && flag4==1)
				{
					int flag2 = checkavailibility(courseID,  semester);
					System.out.print(flag2);
					if(flag2==1)
					{
						//if(courseID.substring(0, 4).equals("comp"))
						//{ 
						//System.out.println("space available in this subject in fall term\n");
				
						if(semester1.trim().equals("fall"))
						{
							String v;
							
							boolean v1;
							
							for(int i=1;i<=3;i++)
							{
						
								
								
								if(studentID.substring(0, 4).equals("comp"))
								{
									
									v=compfallstudent.get(studentID+i);
									v1=compfallstudent.containsValue(studentID+i);
									if((v == null) && v1==false )
									{
										 
										compfallstudent.put(studentID+i,courseID);
										vv=minuscap(courseID,"fall");
										System.out.println(compfallstudent.get(studentID+i));
										System.out.println((studentID+i)+"keyyyy "+getKeyFromValue(compfallstudent,courseID));
										System.out.println(compfallstudent);
										break ;
									}
								}
								else if(studentID.substring(0, 4).equals("soen"))
								{
									
									v=soenfallstudent.get(studentID+i);
									v1=soenfallstudent.containsValue(studentID+i);
									if((v == null) && (v1==false))
									{
										soenfallstudent.put(studentID+i,courseID);
										
										vv=minuscap(courseID,"fall");
										
										break ;
									}
								}else if(studentID.substring(0, 4).equals("inse"))
								{
										v=insefallstudent.get(studentID+i);
										v1=insefallstudent.containsValue(studentID+i);
										if((v == null) && v1==false )
										{
											vv=minuscap(courseID,"fall");
											insefallsubject.put(courseID, vv);
										 	break ;
										}
								}
			
							}

							
						
					}else if(semester1.trim().equals("winter"))
					{
						String v ;
						boolean v1;
						
						for(int i=1;i<=3;i++)
						{
						//System.out.println("sbb");
							
							
							if(studentID.substring(0, 4).equals("comp"))
							{
								v=compwinterstudent.get(studentID+i);
								v1=compwinterstudent.containsValue(studentID+i);
								if((v == null) && v1==false )
								{
									vv=minuscap(courseID,"winter");
									compwintersubject.put(courseID, vv);
									break ;
								}
							}
							else if(studentID.substring(0, 4).equals("soen"))
							{
								v=soenwinterstudent.get(studentID+i);
								v1=soenwinterstudent.containsValue(studentID+i);
								if((v == null) && v1==false )
								{
									soenwinterstudent.put(studentID+i,courseID);
									vv=minuscap(courseID,"winter");
									break ;
								}
							}else if(studentID.substring(0, 4).equals("inse"))
							{
									v=insewinterstudent.get(studentID+i);
									v1=insewinterstudent.containsValue(studentID+i);
									if((v == null) && v1==false )
									{
									 	insewinterstudent.put(studentID+i,courseID);
									 	vv=minuscap(courseID,"winter");
									 	break ;
									}
							}
		
						}
					
					}else if(semester1.trim().equals("summer"))
					{
						String v ;
						boolean v1;
						
						for(int i=1;i<=3;i++)
						{
						//System.out.println("sbb");
							
							
							if(studentID.substring(0, 4).equals("comp"))
							{
								v=compsummerstudent.get(studentID+i);
								v1=compsummerstudent.containsValue(studentID+i);
								if((v == null) && v1==false )
								{
									compsummerstudent.put(studentID+i,courseID);
									vv=minuscap(courseID,"winter");
									break ;
								}
							}
							else if(studentID.substring(0, 4).equals("soen"))
							{
								v=soensummerstudent.get(studentID+i);
								v1=soensummerstudent.containsValue(studentID+i);
								if((v == null) && v1==false )
								{
									soensummerstudent.put(studentID+i,courseID);
									vv=minuscap(courseID,"winter");
									break ;
								}
							}else if(studentID.substring(0, 4).equals("inse"))
							{
									v=insesummerstudent.get(studentID+i);
									v1=insesummerstudent.containsValue(studentID+i);
									if((v == null) && v1==false )
									{
									 	insesummerstudent.put(studentID+i,courseID);
									 	vv=minuscap(courseID,"winter");
									 	break ;
									}
							}
		
						}
					}
						chk=2;
					}
					else
					{
					//	System.out.print("no space available in this subject in fall term");
						chk=3;
					}	
				}
				else
				{
					//System.out.print("you cant enroll in this subject in fall term");
					chk=4;
				}
			}
		
		
			 
			String path = null;	
			if(studentID.substring(0, 4).equals("comp"))
			{
				path="asmt1_13";
			}
			else if(studentID.substring(0, 4).equals("soen"))
			{
				path="asmt1_14";
			}else if(studentID.substring(0, 4).equals("inse"))
			{
				path="asmt1_15";
			}	
		
			
			if(userid.charAt(4)=='s')
			{
				if(chk==1 || chk==3 || chk==4 || chk==6)
				{
		
			     File f3 = new File("/Users/apple/Documents/projects/asmt1_1/src/"+path+"/"+studentID+".txt");
			     try {
				BufferedWriter output2 =new BufferedWriter(new FileWriter(f3,true));
				output2.write(" Request failed , ");
				output2.close();
			     } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			     }
			
		        }
			}
		
			
		if(chk==1)
		{
			logg=0;
			return "You already enroll this subject in fall term";
			
		}
		else if(chk==2)
		{
			
			if(userid.charAt(4)=='s')
			{
			    File f3 = new File("/Users/apple/Documents/projects/asmt1_1/src/"+path+"/"+studentID+".txt");
			    try {
			    BufferedWriter output2 =new BufferedWriter(new FileWriter(f3,true));
				output2.write(" Request successfully completed , ");
				output2.close();
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				return studentID+"is successfully enrolled in "+ courseID;
		}
		else if(chk==3)
		{
			logg=0;
		return "no space available in this subject in this term";
				}
		else if(chk==4)
		{
		//return studentID+" cant enroll "+courseID+" in" + semester+" term";
			logg=0;
		return "Max course capacity exceed for "+studentID;
		
		}
		else if(chk==6)
		{
			logg=0;
			return "error ";
		}
		
		return "sorry ";
	}

	
	
  public synchronized String enrolCourse(String studentID, String courseID, String semester) throws RemoteException {
		
	String stat,stat1;
	Server1 ser1=new Server1(); 
	Server2 ser2=new Server2();
	Server3 ser3=new Server3(); 
	
	  if(userid.substring(0, 4).equals("comp"))
		{
			if(studentID.substring(0, 4).equals("comp"))
			{
				
				if(courseID.substring(0, 4).equals("comp"))
				{
					stat=enrolCourse1(studentID,courseID,semester);
					return stat;
				}
				else if(courseID.substring(0, 4).equals("soen") || courseID.substring(0, 4).equals("inse"))
				{
				     	
				    
					stat=ser1.enrolCourseserver(studentID,courseID,semester);  																																			 stat=enrolCourse1(studentID,courseID,semester); 
				     return stat;
				}
			}
			else
			{
				return "you can not enroll another department's student";
			}
			
		}
	  else if(userid.substring(0, 4).equals("soen"))
		{
			if(studentID.substring(0, 4).equals("soen"))
			{
				
				if(courseID.substring(0, 4).equals("soen"))
				{
					stat=enrolCourse1(studentID,courseID,semester);
					return stat;
				}
				else if(courseID.substring(0, 4).equals("comp") || courseID.substring(0, 4).equals("inse"))
				{
				     
				     //System.out.println(studentID+courseID+semester); 
				  
				     stat=ser2.enrolCourseserver1(studentID,courseID,semester);  																																	  stat=enrolCourse1(studentID,courseID,semester);
				  
				     return stat;
				}
			} 
			else
			{
				return "you can not enroll another department's student";
			}
			
		}
	  else if(userid.substring(0, 4).equals("inse"))
		{
			if(studentID.substring(0, 4).equals("inse"))
			{
				
				if(courseID.substring(0, 4).equals("inse"))
				{
					stat=enrolCourse1(studentID,courseID,semester);
					return stat;
				}
				else if(courseID.substring(0, 4).equals("soen") || courseID.substring(0, 4).equals("comp"))
				{
				     	
				     stat=ser3.enrolCourseserver2(studentID,courseID,semester);   																																	 stat=enrolCourse1(studentID,courseID,semester);
				     return stat; 
				}
			}
			else
			{
				return "you can not enroll another department's student";
			}
			
		}
		
		
		return semester;
		
	}
	

	
	
	
	
	
	
	
	public synchronized String getClassSchedule(String studentID) throws RemoteException {
		// TODO Auto-generated method stub
		String tmp,tmpp,tmppp;
		String tmp1=null;

		
			tmp1 = "\nFall : ";
			
			for(int i=1;i<=3;i++)
			{
					tmp=compfallstudent.get(studentID+i);
					tmpp=soenfallstudent.get(studentID+i);
					tmppp=insefallstudent.get(studentID+i);
					System.out.print(" "+tmp+" ");
					if(tmp!=null )
					{
						tmp1=tmp1+tmp+" ";
					}
					if(tmpp!=null )
					{
						tmp1=tmp1+tmpp+" ";
					}
					if(tmppp!=null )
					{
						tmp1=tmp1+tmppp+" ";
					}
			}
			tmp1=tmp1+"\nwinter : ";
			for(int i=1;i<=3;i++)
			{
				tmp=compwinterstudent.get(studentID+i);
				tmpp=soenwinterstudent.get(studentID+i);
				tmppp=insewinterstudent.get(studentID+i);
				System.out.print(" "+tmp+" ");
				if(tmp!=null )
				{
					tmp1=tmp1+tmp+" ";
				}
				if(tmpp!=null )
				{
					tmp1=tmp1+tmpp+" ";
				}
				if(tmppp!=null )
				{
					tmp1=tmp1+tmppp+" ";
				}	
			}
			tmp1=tmp1+"\nsummer : ";
			for(int i=1;i<=3;i++)
			{
				tmp=compsummerstudent.get(studentID+i);
				tmpp=soensummerstudent.get(studentID+i);
				tmppp=insesummerstudent.get(studentID+i);
				System.out.print(" "+tmp+" ");
				if(tmp!=null )
				{
					tmp1=tmp1+tmp+" ";
				}
				if(tmpp!=null )
				{
					tmp1=tmp1+tmpp+" ";
				}
				if(tmppp!=null )
				{
					tmp1=tmp1+tmppp+" ";
				}	
			}
		return tmp1;	
			
	}

	
	
	
 

	public synchronized String dropCourse1(String studentID, String courseID) {
	
		int flag2 = checkenroll(studentID, courseID);
		int ck=0;
		
		
		String path = null;	
		if(studentID.substring(0, 4).equals("comp"))
		{
			path="asmt1_13";
		}
		else if(studentID.substring(0, 4).equals("soen"))
		{
			path="asmt1_14";
		}else if(studentID.substring(0, 4).equals("inse"))
		{
			path="asmt1_15";
		}	
		
		if(flag2==1)
		{
				for(int i=1;i<=3;i++)
				{
					if(compfallstudent.get(studentID+i)!=null && (compfallstudent.get(studentID+i)).equals(courseID) )
					{
						compfallstudent.remove(studentID+i);
						if(courseID.substring(0, 4).equals("comp"))
						{
						int tt=compfallsubject.get(courseID)+1;
						compfallsubject.replace(courseID, tt);
						ck=1;
						}
						else if(courseID.substring(0, 4).equals("soen"))
						{
						int tt=soenfallsubject.get(courseID)+1;
						soenfallsubject.replace(courseID, tt);
						ck=1;
						}
						else if(courseID.substring(0, 4).equals("inse"))
						{
						int tt=insefallsubject.get(courseID)+1;
						insefallsubject.replace(courseID, tt);
						ck=1;
						}
						
						
					}else if(compwinterstudent.get(studentID+i)!=null && (compwinterstudent.get(studentID+i)).equals(courseID))
					{
						compwinterstudent.remove(studentID+i);
						if(courseID.substring(0, 4).equals("comp"))
						{
						int tt=compwintersubject.get(courseID)+1;
						compwintersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("soen"))
						{
						int tt=soenwintersubject.get(courseID)+1;
						soenwintersubject.replace(courseID, tt);
						ck=1;
						}
						else if(courseID.substring(0, 4).equals("inse"))
						{
						int tt=insewintersubject.get(courseID)+1;
						insewintersubject.replace(courseID, tt);
						ck=1;
						}
						
					}else if(compsummerstudent.get(studentID+i)!=null && (compsummerstudent.get(studentID+i)).equals(courseID))
					{
						compsummerstudent.remove(studentID+i);
						if(courseID.substring(0, 4).equals("comp"))
						{
						int tt=compsummersubject.get(courseID)+1;
						compsummersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("soen"))
						{
						int tt=soensummersubject.get(courseID)+1;
						soensummersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("inse"))
						{
						int tt=insesummersubject.get(courseID)+1;
						insesummersubject.replace(courseID, tt);
						ck=1;
						}
						
					}else if(soenfallstudent.get(studentID+i)!=null && (soenfallstudent.get(studentID+i)).equals(courseID))
					{
						soenfallstudent.remove(studentID+i);
						if(courseID.substring(0, 4).equals("comp"))
						{
						int tt=compfallsubject.get(courseID)+1;
						compfallsubject.replace(courseID, tt);
						ck=1;
						}
						else if(courseID.substring(0, 4).equals("soen"))
						{
						int tt=soenfallsubject.get(courseID)+1;
						soenfallsubject.replace(courseID, tt);
						ck=1;
						}
						else if(courseID.substring(0, 4).equals("inse"))
						{
						int tt=insefallsubject.get(courseID)+1;
						insefallsubject.replace(courseID, tt);
						ck=1;
						}
						
					}else if(soenwinterstudent.get(studentID+i)!=null && (soenwinterstudent.get(studentID+i)).equals(courseID))
					{
						soenwinterstudent.remove(studentID+i);
						if(courseID.substring(0, 4).equals("comp"))
						{
						int tt=compwintersubject.get(courseID)+1;
						compwintersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("soen"))
						{
						int tt=soenwintersubject.get(courseID)+1;
						soenwintersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("inse"))
						{
						int tt=insewintersubject.get(courseID)+1;
						insewintersubject.replace(courseID, tt);
						ck=1;
						}
						
					}else if(soensummerstudent.get(studentID+i)!=null && (soensummerstudent.get(studentID+i)).equals(courseID))
					{
						soensummerstudent.remove(studentID+i);
						if(courseID.substring(0, 4).equals("comp"))
						{
						int tt=compsummersubject.get(courseID)+1;
						compsummersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("soen"))
						{
						int tt=soensummersubject.get(courseID)+1;
						soensummersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("inse"))
						{
						int tt=insesummersubject.get(courseID)+1;
						insesummersubject.replace(courseID, tt);
						ck=1;
						}
					}
					else if(insefallstudent.get(studentID+i)!=null && (insefallstudent.get(studentID+i)).equals(courseID))
					{
						insefallstudent.remove(studentID+i);
						if(courseID.substring(0, 4).equals("comp"))
						{
						int tt=compfallsubject.get(courseID)+1;
						compfallsubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("soen"))
						{
						int tt=soenfallsubject.get(courseID)+1;
						soenfallsubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("inse"))
						{
						int tt=insefallsubject.get(courseID)+1;
						insefallsubject.replace(courseID, tt);
						ck=1;
						}
					}
					else if(insewinterstudent.get(studentID+i)!=null && (insewinterstudent.get(studentID+i)).equals(courseID))
					{
						insewinterstudent.remove(studentID+i);
						if(courseID.substring(0, 4).equals("comp"))
						{
						int tt=compwintersubject.get(courseID)+1;
						compwintersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("soen"))
						{
						int tt=soenwintersubject.get(courseID)+1;
						soenwintersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("inse"))
						{
						int tt=insewintersubject.get(courseID)+1;
						insewintersubject.replace(courseID, tt);
						ck=1;
						}
					}
					else if(insesummerstudent.get(studentID+i)!=null && (insesummerstudent.get(studentID+i)).equals(courseID))
					{
						insesummerstudent.remove(studentID+i);
						if(courseID.substring(0, 4).equals("inse"))
						{
						int tt=insesummersubject.get(courseID)+1;
						insesummersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("comp"))
						{
						int tt=compsummersubject.get(courseID)+1;
						compsummersubject.replace(courseID, tt);
						ck=1;
						}else if(courseID.substring(0, 4).equals("soen"))
						{
						int tt=soensummersubject.get(courseID)+1;
						soensummersubject.replace(courseID, tt);
						ck=1;
						}
					}
				}
				
				
				
				 
				if(ck==1)
				{
					return studentID+" is successfully drop in "+courseID;
				}else {
					return studentID+" is not successfully drop in "+courseID;
				}
		}
		else
		{
			return "you are cant not drop  "+courseID;
		}
	}

	public synchronized String dropCourse(String studentID, String courseID) throws RemoteException {
		String stat,stat1;
		Server1 ser1=new Server1(); 
		Server2 ser2=new Server2();
		Server3 ser3=new Server3(); 
		
		  if(userid.substring(0, 4).equals("comp"))
			{
				if(studentID.substring(0, 4).equals("comp"))
				{
					
					if(courseID.substring(0, 4).equals("comp"))
					{
						stat=dropCourse1(studentID,courseID);
						return stat;
					}
					else if(courseID.substring(0, 4).equals("soen") || courseID.substring(0, 4).equals("inse"))
					{
					     	
					    
						stat=ser1.dropCourseserver(studentID,courseID);  																																															stat=dropCourse1(studentID,courseID);		
					     return stat;
					}
				}
				else
				{
					return "you can not drop course of another department's student";
				}
				
			}
		  else if(userid.substring(0, 4).equals("soen"))
			{
				if(studentID.substring(0, 4).equals("soen"))
				{
					
					if(courseID.substring(0, 4).equals("soen"))
					{
						stat=dropCourse1(studentID,courseID);
						return stat;
					}
					else if(courseID.substring(0, 4).equals("comp") || courseID.substring(0, 4).equals("inse"))
					{
					     
					     //System.out.println(studentID+courseID+semester); 
					  
					     stat=ser2.dropCourseserver1(studentID,courseID);  																																			 stat=dropCourse1(studentID,courseID);
					  
					     return stat;
					}
				} 
				else
				{
					return "you can not drop course of another department's student";
				}
				
			}
		  else if(userid.substring(0, 4).equals("inse"))
			{
				if(studentID.substring(0, 4).equals("inse"))
				{
					
					if(courseID.substring(0, 4).equals("inse"))
					{
						stat=dropCourse1(studentID,courseID);
						return stat;
					}
					else if(courseID.substring(0, 4).equals("soen") || courseID.substring(0, 4).equals("comp"))
					{
					     	
					     stat=ser3.dropCourseserver2(studentID,courseID); 																																																	stat=dropCourse1(studentID,courseID);			
					  
					     
					     return stat; 
					}
				}
				else
				{
					return "you can not drop course of another department's student";
				}
				
			}
			
			
			return null;
	}


}
