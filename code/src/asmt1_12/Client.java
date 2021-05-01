package asmt1_12;
import java.io.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//simport asmt1_11.InterFace;
import asmt1_11.ImpInterFace;
import asmt1_11.*;

public class Client {
	 public static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public static void log(int n,File f,char i) throws IOException
	{
		
		
		BufferedWriter output =new BufferedWriter(new FileWriter(f,true));
		Date date = new Date();
		output.write("\n"+sdf.format(date)+"  ,");
		if(n==1)
		{
			output.write(" enrol course ,  [studentID, courseID, semester] ,");
			
		}else if(n==2)
		{
			output.write(" drop course , [studentID, courseID] ,");
		}else if(n==3)
		{
			output.write(" get class schedule , [studentID] ,");
		}else if(n==4)
		{
			output.write(" add course , [courseID, semester] ,");
		}else if(n==5)
		{
			output.write(" remove course , [courseID, semester] ,");
		}else if(n==6)
		{
			output.write(" list course availability , [semester] ,");
		}
		output.close();

	}
	static void opt(int a)
	{
		if(a==1)
		{
			System.out.println();
			System.out.println("1-> enrol course");
			System.out.println("2-> drop course");
			System.out.println("3-> get class schedule");
			System.out.println();
		}
		else
		{
			System.out.println();
			System.out.println("1-> enrol course");
			System.out.println("2-> drop course");
			System.out.println("3-> get class schedule");
			System.out.println("4-> add course");
			System.out.println("5-> remove course");
			System.out.println("6-> list course availability");
			System.out.println();
		
		}
	}
	

	public static void main(String args[]) throws Exception{
		
		 InputStreamReader is = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(is);
         Scanner scanner = new Scanner(System.in);
         String ID,studentID = null,adviserID,studentID1,courseID,semester;
         int n,capa;
         int cho=1;
         String ou;
        Registry registry = LocateRegistry.getRegistry(3900);
		InterFace obj = (InterFace) registry.lookup("COMPserver");
		Registry registry1 = LocateRegistry.getRegistry(3901);
		InterFace obj1 = (InterFace) registry1.lookup("SOENserver");
		Registry registry2 = LocateRegistry.getRegistry(3902);
		InterFace obj2 = (InterFace) registry2.lookup("INSEserver");
		
		System.out.print("Enter Your ID : ");
		ID = br.readLine();
		File f = null;
	
		String path = null;
		
			try {
		         // create new files
				
				if(ID.substring(0, 4).equals("comp"))
				{
					path="asmt1_13";
				}
				else if(ID.substring(0, 4).equals("soen"))
				{
					path="asmt1_14";
				}else if(ID.substring(0, 4).equals("inse"))
				{
					path="asmt1_15";
				}
				else
				{
					path="asmt1_16";
					File f2 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_12/errorclient.txt");
					BufferedWriter output1 =new BufferedWriter(new FileWriter(f2,true));
					Date date1 = new Date();
					output1.write(sdf.format(date1)+"  ,");
					output1.write(" user "+ID+" is unauthorized\n");
					output1.close();
				}
		         f = new File("/Users/apple/Documents/projects/asmt1_1/src/"+path+"/"+ID+".txt");
		        boolean bool = f.exists();
		         if(bool == false) {
		        	 f.createNewFile();
		         } 
		      } catch(Exception e) {
		         e.printStackTrace();
		      }
		
		
		
		//ID="soena1111";
		String temp1= ID.substring(0, 4);
		char temp2= ID.charAt(4);
		String temp3= ID.substring(5, 9);
		if(temp2=='a'||temp2=='A')
		{
			adviserID=ID;
			ImpInterFace.logg1=1;
		}
		else
		{
			studentID=ID;
			ImpInterFace.logg1=0;
		}
	//	System.out.print(temp1+" "+temp2+" "+temp3);
		
		while(cho==1)
		{
		if(temp1.equals("COMP") || temp1.equals("comp"))
		{
			obj.UserId(ID);
			
			//ImpInterFace obj1 = new ImpInterFace(ID,temp1,temp2);
			switch( temp2 )   
            {  
                case 'A':
                case 'a':  
                		opt(2);
                		n = scanner.nextInt();
                		log(n,f,temp2);
                		
                		
                		
                		switch( n )
                		{
                			case 4:
                				System.out.print("Enter semester : ");
                				semester = scanner.next();
                				System.out.print("\nEnter course id : ");
                				courseID = scanner.next();
                				System.out.print("\nEnter course capacity : ");
                				capa = scanner.nextInt();
                				if((courseID.substring(0, 4)).equals("soen") || (courseID.substring(0, 4)).equals("inse"))
                				{
                					System.out.print("\nYou can not add another department's course");
                					try {
                						BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
                						output2.write(" Request failed ,");
                						output2.write(" You can not add another department's course. \n");
                						output2.close();
                					} catch (IOException e) {
                						// TODO Auto-generated catch block
                						e.printStackTrace();
                					}
                				}
                				else if ((courseID.substring(0, 4)).equals("comp"))
                				{
                				obj.courseCapacity(capa);
                				String g = obj.addCourse(courseID, semester);
                				System.out.print(g);
                				}
                				break;
                				
                			case 5:
                				System.out.print("\nEnter course id : ");
                				courseID = scanner.next();
                				System.out.print("Enter semester : ");
                				semester = scanner.next();
                				
                				if((courseID.substring(0, 4)).equals("soen") || (courseID.substring(0, 4)).equals("inse"))
                				{
                					System.out.print("\nYou can not remove another department's course");
                					try {
                						BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
                						output2.write(" Request failed ,");
                						output2.write(" You can not remove another department's course. \n");
                						output2.close();
                					} catch (IOException e) {
                						// TODO Auto-generated catch block
                						e.printStackTrace();
                					}
                				}
                				else if ((courseID.substring(0, 4)).equals("comp"))
                				{
                					System.out.print(obj.removeCourse(courseID, semester));
                				}
                				break;
                			case 6: 
                				
                				System.out.print("\nEnter semester : ");
                				semester = scanner.next();
                				ou=obj.listCourseAvailability(semester);
                				System.out.println(ou);
                				BufferedWriter output2 = new BufferedWriter(new FileWriter(f,true));
                				output2.write(" Request successfully completed , ");
                				output2.write(ou+"\n\n");
                				break;
                			case 1:
                				System.out.print("\nEnter course id : ");
                				courseID = scanner.next();
                				System.out.print("Enter semester : ");
                				semester = scanner.next();
                				System.out.print("Enter Student id : ");
                				studentID1 = scanner.next();
                				
                				if((studentID1.substring(0, 4)).equals("soen") || (studentID1.substring(0, 4)).equals("inse"))
                				{
                					System.out.print("\nYou can not enrol another department's student");
                					try {
                						BufferedWriter output3 =new BufferedWriter(new FileWriter(f,true));
                						output3.write(" Request failed ,");
                						output3.write(" You can not enrol another department's student. \n");
                						output3.close();
                					} catch (IOException e) {
                						// TODO Auto-generated catch block
                						e.printStackTrace();
                					}
                				}
                				else if ((studentID1.substring(0, 4)).equals("comp"))
                				{
                					ou=obj.enrolCourse( studentID1, courseID,  semester);
                				System.out.println(ou);
                				
                				try {
            						BufferedWriter output5 =new BufferedWriter(new FileWriter(f,true));
            						if(ou.equals(studentID1+"is successfully enrolled in "+ courseID))
            						{
            						output5.write(" Request successfully completed ,");	
            						}
            						else 
            						{
            							output5.write(" Request failed ,");
            						}
            						output5.write(ou+"\n");
            						output5.close();
            					} catch (IOException e) {
            						// TODO Auto-generated catch block
            						e.printStackTrace();
            					}
                				}
                				break;
                			case 3:
                				System.out.print("Enter Student id : ");
                				studentID1 = scanner.next();
                				ou=obj.getClassSchedule(studentID1);
                				
                				  System.out.print(ou);
                				    BufferedWriter output21 =new BufferedWriter(new FileWriter(f,true));
                				 	output21.write(" Request successfully completed ,");
                					output21.write(ou);
                					output21.close();
                				
                				break;
                			case 2:
                				System.out.print("\nEnter course id : ");
                				courseID = scanner.next();
                				System.out.print("Enter Student id : ");
                				studentID1 = scanner.next();
                				
                				if((studentID1.substring(0, 4)).equals("soen") || (studentID1.substring(0, 4)).equals("inse"))
                				{
                					System.out.print("\nYou can not drop course of another department's student");
                					try {
                						BufferedWriter output3 =new BufferedWriter(new FileWriter(f,true));
                						output3.write(" Request failed ,");
                						output3.write(" You can not drop course of another department's student \n\n");
                						output3.close();
                					} catch (IOException e) {
                						// TODO Auto-generated catch block
                						e.printStackTrace();
                					}
                				}
                				else if ((studentID1.substring(0, 4)).equals("comp"))
                				{
                					ou=obj.dropCourse( studentID1, courseID);
                				System.out.println(ou);
                				
                				try {
            						BufferedWriter output5 =new BufferedWriter(new FileWriter(f,true));
            						if(ou.equals(studentID1+" is successfully drop in "+courseID))
            						{
            						output5.write(" Request successfully completed ,");	
            						}
            						else 
            						{
            							output5.write(" Request failed ,");
            						}
            						output5.write(ou+"\n");
            						output5.close();
            					} catch (IOException e) {
            						// TODO Auto-generated catch block
            						e.printStackTrace();
            					}
                				}
                				
                				
                				break;
                		}
                    break;  
                case 'S':
                case 's':
                		opt(1);
                		n = scanner.nextInt();
                		log(n,f,temp2);
                		switch( n )
                		{  
                			case 1:
                				System.out.print("\nEnter course id : ");
                				courseID = scanner.next();
                				System.out.print("Enter semester : ");
                				semester = scanner.next();
                				ou=obj.enrolCourse( studentID, courseID, semester);
                				
                				System.out.print(ou);
                			
                				 BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
                					output2.write(ou);
                					output2.close();
                				break;
                			case 3:
                				ou=obj.getClassSchedule(studentID);
                				  System.out.print(ou);
                				    BufferedWriter output21 =new BufferedWriter(new FileWriter(f,true));
                				 	output21.write(" Request successfully completed ,");
                					output21.write(ou);
                					output21.close();
                				break;
                			case 2:
                				System.out.print("\nEnter course id : ");
                				courseID = scanner.next();
                				ou=obj.dropCourse( studentID, courseID);
                				System.out.print(ou);
                				BufferedWriter output8 =new BufferedWriter(new FileWriter(f,true));
                				if(ou.equals(studentID+" is successfully drop in "+courseID))
                				{
                					
        							output8.write(" Request successfully completed , ");
        							
                				}
                				else
                				{
                					output8.write(" Request failed , ");
                				}
               				
               					output8.write(ou);
               					output8.close();
                				
                				break;	
                		}
                	break;                
            }  
		}
		else if(temp1.equals("SOEN") || temp1.equals("soen"))
		{
			obj1.UserId(ID);
			//ImpInterFace obj1 = new ImpInterFace(ID,temp1,temp2);
		
			switch( temp2 )   
            {  
                case 'A':
                case 'a':  
                	opt(2);
                	n = scanner.nextInt();
                	log(n,f,temp2);
                	switch( n )
            		{
            		case 4:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				System.out.print("Enter semester : ");
        				semester = scanner.next();
        				System.out.print("\nEnter course capacity : ");
        				capa = scanner.nextInt();
        				if((courseID.substring(0, 4)).equals("comp") || (courseID.substring(0, 4)).equals("inse"))
        				{
        					System.out.print("\nYou can not add another department's course");
        					try {
        						BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
        						output2.write(" Request failed ,");
        						output2.write(" You can not add another department's course. \n");
        						output2.close();
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				else if ((courseID.substring(0, 4)).equals("soen"))
        				{
        				obj1.courseCapacity(capa);
        				String g = obj1.addCourse(courseID, semester);
        				System.out.print(g);
        				}
        			
        				break;
        			case 5:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				System.out.print("Enter semester : ");
        				semester = scanner.next();
        				
        				if((courseID.substring(0, 4)).equals("comp") || (courseID.substring(0, 4)).equals("inse"))
        				{
        					System.out.print("\nYou can not remove another department's course");
        					try {
        						BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
        						output2.write(" Request failed ,");
        						output2.write(" You can not remove another department's course. \n");
        						output2.close();
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				else if ((courseID.substring(0, 4)).equals("soen"))
        				{
        					System.out.print(obj1.removeCourse(courseID, semester));
        				}
        				
        				break;
        			case 6:
        				System.out.print("\nEnter semester : ");
        				semester = scanner.next();
        				ou=obj1.listCourseAvailability(semester);
        				System.out.println(ou);
        				BufferedWriter output2 = new BufferedWriter(new FileWriter(f,true));
        				output2.write(" Request successfully completed , ");
        				output2.write(ou+"\n\n");
        				break;
        			case 1:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				System.out.print("Enter semester : ");
        				semester = scanner.next();
        				System.out.print("Enter Student id : ");
        				studentID1 = scanner.next();
        				if((studentID1.substring(0, 4)).equals("comp") || (studentID1.substring(0, 4)).equals("inse"))
        				{
        					System.out.print("\nYou can not enrol another department's student");
        					try {
        						BufferedWriter output3 =new BufferedWriter(new FileWriter(f,true));
        						output3.write(" Request failed ,");
        						output3.write(" You can not enrol another department's student. \n");
        						output3.close();
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				else if ((studentID1.substring(0, 4)).equals("soen"))
        				{
        				ou=obj1.enrolCourse( studentID1, courseID,  semester);
        				System.out.print(ou+"\n");
        				try {
    						BufferedWriter output4 =new BufferedWriter(new FileWriter(f,true));
    						if(ou.equals(studentID1+"is successfully enrolled in "+ courseID))
    						{
    						
    						output4.write(" Request successfully completed ,");	
    						}
    						else 
    						{
    							
    							output4.write(" Request failed ,");
    						}
    						output4.write(ou+"\n");
    						output4.close();
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        				}
        				break;
        			case 3: 
        				System.out.print("Enter Student id : ");
        				studentID1 = scanner.next();
        				ou=obj1.getClassSchedule(studentID1);
        				
        				System.out.print(ou);
       				    BufferedWriter output6 =new BufferedWriter(new FileWriter(f,true));
       				 	output6.write(" Request successfully completed ,");
       					output6.write(ou);
       					output6.close();
        				break;
        			case 2:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				System.out.print("Enter Student id : ");
        				studentID1 = scanner.next();
        				
        				if((studentID1.substring(0, 4)).equals("comp") || (studentID1.substring(0, 4)).equals("inse"))
        				{
        					System.out.print("\nYou can not drop course of another department's student");
        					try {
        						BufferedWriter output3 =new BufferedWriter(new FileWriter(f,true));
        						output3.write(" Request failed ,");
        						output3.write(" You can not drop course of another department's student \n\n");
        						output3.close();
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				else if ((studentID1.substring(0, 4)).equals("soen"))
        				{
        					ou=obj1.dropCourse( studentID1, courseID);
        				System.out.println(ou);
        				
        				try {
    						BufferedWriter output5 =new BufferedWriter(new FileWriter(f,true));
    						if(ou.equals(studentID1+" is successfully drop in "+courseID))
    						{
    						output5.write(" Request successfully completed ,");	
    						}
    						else 
    						{
    							output5.write(" Request failed ,");
    						}
    						output5.write(ou+"\n");
    						output5.close();
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        				}
        				
        				
        				break;
            		}
                	
                    break;  
                case 'S':
                case 's':
                	opt(1);
                	n = scanner.nextInt();
                	log(n,f,temp2);
                	switch( n )
            		{
            		case 1:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				System.out.print("Enter semester : ");
        				semester = scanner.next();
        				ou=obj1.enrolCourse( studentID, courseID,  semester);
        				
        				System.out.print(ou);
       				    BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
       					output2.write(ou);
       					output2.close();
        				break;
        			case 3:
        				  ou=obj1.getClassSchedule(studentID);
        				    System.out.print(ou);
          				    BufferedWriter output21 =new BufferedWriter(new FileWriter(f,true));
          				 	output21.write(" Request successfully completed ,");
          					output21.write(ou);
          					output21.close();
        				break;
        			case 2:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				ou=obj1.dropCourse( studentID, courseID);
        				System.out.print(ou);
          				 BufferedWriter output8 =new BufferedWriter(new FileWriter(f,true));
          					

          					if(ou.equals(studentID+" is successfully drop in "+courseID))
            				{
            					
    							output8.write(" Request successfully completed , ");
    							
            				}
            				else
            				{
            					output8.write(" Request failed , ");
            				}
          					
          					output8.write(ou);
          					output8.close();
          					
          					
        				break;
            		}
                    break;  
            }
		}
		else if(temp1.equals("INSE") || temp1.equals("inse"))
		{
			obj2.UserId(ID);
			//ImpInterFace obj1 = new ImpInterFace(ID,temp1,temp2);
			
			switch( temp2 )   
            {  
                case 'A':
                case 'a':  
                	opt(2);
                	n = scanner.nextInt();
                	log(n,f,temp2);
                	switch( n )
            		{
            		case 4:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				System.out.print("Enter semester : ");
        				semester = scanner.next();
        				System.out.print("\nEnter course capacity : ");
        				capa = scanner.nextInt();
        				if((courseID.substring(0, 4)).equals("soen") || (courseID.substring(0, 4)).equals("comp"))
        				{
        					System.out.print("\nYou can not add another department's course");
        					try {
        						BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
        						output2.write(" Request failed ,");
        						output2.write(" You can not add another department's course. \n");
        						output2.close();
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				else if ((courseID.substring(0, 4)).equals("inse"))
        				{
        				obj2.courseCapacity(capa);
        				String g = obj2.addCourse(courseID, semester);
        				System.out.print(g);
        				}
        				break;
        			case 5:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				System.out.print("Enter semester : ");
        				semester = scanner.next();
        				
        				if((courseID.substring(0, 4)).equals("comp") || (courseID.substring(0, 4)).equals("soen"))
        				{
        					System.out.print("\nYou can not remove another department's course");
        					try {
        						BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
        						output2.write(" Request failed ,");
        						output2.write(" You can not remove another department's course. \n");
        						output2.close();
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				else if ((courseID.substring(0, 4)).equals("inse"))
        				{
        					System.out.print(obj2.removeCourse(courseID, semester));
        				}
        				
        				break;
        			case 6:
        				System.out.print("\nEnter semester : ");
        				semester = scanner.next();
        				ou=obj2.listCourseAvailability(semester);
        				System.out.print(ou);
       				    BufferedWriter output6 =new BufferedWriter(new FileWriter(f,true));
       				 	output6.write(" Request successfully completed ,");
       					output6.write(ou);
       					output6.close();
        				break;
        			case 1:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				System.out.print("Enter semester : ");
        				semester = scanner.next();
        				System.out.print("Enter Student id : ");
        				studentID1 = scanner.next();
        				if((studentID1.substring(0, 4)).equals("comp") || (studentID1.substring(0, 4)).equals("soen"))
        				{
        					System.out.print("\nYou can not enrol another department's student");
        					try {
        						BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
        						output2.write(" Request failed ,");
        						output2.write(" You can not enrol another department's student. \n");
        						output2.close();
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				else if ((studentID1.substring(0, 4)).equals("inse"))
        				{
        				ou=obj2.enrolCourse( studentID1, courseID,  semester);
        				System.out.print(ou+"\n");
        				
        				try {
    						BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
    						if(ou.equals(studentID1+"is successfully enrolled in "+ courseID))
    						{
    						
    						output2.write(" Request successfully completed ,");	
    						}
    						else 
    						{
    							
    							output2.write(" Request failed ,");
    						}
    						output2.write(ou+"\n");
    						output2.close();
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        				
        				}
        				break;
        			case 3:System.out.print("Enter Student id : ");
        					studentID1 = scanner.next();
        					ou=obj2.getClassSchedule(studentID1);
        					
        					  System.out.print(ou);
            				    BufferedWriter output21 =new BufferedWriter(new FileWriter(f,true));
            				 	output21.write(" Request successfully completed ,");
            					output21.write(ou);
            					output21.close();
        					
        					break;
        			case 2:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				System.out.print("Enter Student id : ");
        				studentID1 = scanner.next();
        				
        				if((studentID1.substring(0, 4)).equals("soen") || (studentID1.substring(0, 4)).equals("comp"))
        				{
        					System.out.print("\nYou can not drop course of another department's student");
        					try {
        						BufferedWriter output3 =new BufferedWriter(new FileWriter(f,true));
        						output3.write(" Request failed ,");
        						output3.write(" You can not drop course of another department's student \n\n");
        						output3.close();
        					} catch (IOException e) {
        						// TODO Auto-generated catch block
        						e.printStackTrace();
        					}
        				}
        				else if ((studentID1.substring(0, 4)).equals("inse"))
        				{
        					ou=obj2.dropCourse( studentID1, courseID);
        				System.out.println(ou);
        				
        				try {
    						BufferedWriter output5 =new BufferedWriter(new FileWriter(f,true));
    						if(ou.equals(studentID1+" is successfully drop in "+courseID))
    						{
    						output5.write(" Request successfully completed ,");	
    						}
    						else 
    						{
    							output5.write(" Request failed ,");
    						}
    						output5.write(ou+"\n");
    						output5.close();
    					} catch (IOException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
        				}
        				
        				
        				
        				
        				break;
            		}
                	
                    break;  
                case 'S':
                case 's':
                	opt(1);
                	n = scanner.nextInt();
                	log(n,f,temp2);
                	switch( n )
            		{
            		case 1:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				System.out.print("Enter semester : ");
        				semester = scanner.next();
        				ou=obj2.enrolCourse( studentID, courseID,  semester);
        				
        				System.out.print(ou);
       				 BufferedWriter output2 =new BufferedWriter(new FileWriter(f,true));
       					output2.write(ou);
       					output2.close();
        				
        				break;
        			case 3:
        				ou=obj2.getClassSchedule(studentID);
        				
        				  System.out.print(ou);
        				    BufferedWriter output21 =new BufferedWriter(new FileWriter(f,true));
        				 	output21.write(" Request successfully completed ,");
        					output21.write(ou);
        					output21.close();
        				break;
        			case 2:
        				System.out.print("\nEnter course id : ");
        				courseID = scanner.next();
        				ou=obj2.dropCourse( studentID, courseID);
        				System.out.print(ou);
          				 BufferedWriter output8 =new BufferedWriter(new FileWriter(f,true));
          				if(ou.equals(studentID+" is successfully drop in "+courseID))
        				{
        					
							output8.write(" Request successfully completed , ");
							
        				}
        				else
        				{
        					output8.write(" Request failed , ");
        				}
          					output8.write(ou);
          					output8.close();
        				break;	
            		}
                	
                    break;  
        
            }
		}
		else
		{
			System.out.print("Invalid id");

		}
		
		System.out.print("\nwanna continue? 1/0");
		cho=scanner.nextInt();
	}
	}
	
}
