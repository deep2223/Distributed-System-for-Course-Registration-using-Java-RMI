package asmt1_14;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;
import java.util.Scanner;

import asmt1_11.*;
import asmt1_13.Server1;


   class sendMessage1 implements Runnable {
	
	   Thread t2;
	    int serverPort;
	    String ss1,ss2;
	    String msg;
	    String sid,sem,method,courseid;
	    public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_14/Server2.txt");
		    BufferedWriter output0;
	   
	   
	    sendMessage1(int p,String st1,String st2)
	    {
	    	serverPort=p;
	    	ss1=st1;
	    	ss2=st2;
	    	msg=null;
	    	 msg=ss2+":"+ss1;
	    	t2=new Thread(this);
	    	
	    }
	   
	    public sendMessage1(int p, String studentID,String courseID, String sem, String methd) {
	    	
	    	serverPort=p;
	    	sid=studentID;
	    	this.sem=sem;
	    	method=methd;
	    	courseid=courseID;
	    	
	    	msg=null;
	    	msg=method+":"+sid+"*"+courseid+"#"+sem;
	    	t2=new Thread(this);
			// TODO Auto-generated constructor stub
		}
	    
	    	public sendMessage1(int p, String studentID,String courseID, String methd) {
	    	
	    	serverPort=p;
	    	sid=studentID;
	 
	    	method=methd;
	    	courseid=courseID;
	    	
	    	msg=null;
	    	msg=method+":"+sid+"*"+courseid;
	    	t2=new Thread(this);
			// TODO Auto-generated constructor stub
		}
	    
	    
	    public synchronized void run()  
	    {
	    	 DatagramSocket aSocket = null;
			  try {
				  aSocket = new DatagramSocket();
				  byte[] message = new byte[1000];
				
				  message=msg.getBytes();
				  
				  InetAddress aHost = InetAddress.getByName("localhost");
				  DatagramPacket request = new DatagramPacket(message, msg.length(), aHost, serverPort);
				  aSocket.send(request);
				  System.out.println("Request message sent from the client to server with port number " + serverPort + " is: "
					+ new String(request.getData()));
				  
				  

					try {
						output0 = new BufferedWriter(new FileWriter(f0,true));
						Date date1 = new Date();
						output0.write(", Request message sent from the client to server with port number " + serverPort+" , ");
						output0.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
				  
				  
				  byte[] buffer = new byte[1000];
				 
				  DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
				  aSocket.receive(reply);
				  String tmp = new String(reply.getData());
				  
				  
				  try {
						output0 = new BufferedWriter(new FileWriter(f0,true));
						Date date1 = new Date();
						output0.write(" , Reply received from the server with port number " + serverPort+" , \n\n");
						output0.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				  
				  
				  System.out.println("Reply received from the server with port number " + serverPort + " is: "
					+ tmp);
				  tmp.trim();
			   	String kept = tmp.substring(tmp.indexOf(":")+1,tmp.length());
			 
			 // System.out.println(tmp+"---"+kept);
			   	
					 if(kept.trim().equals("methodlist"))
					 {
					//	String output4=null;
						 
						 Server2.output1 =Server2.output1+ tmp.substring(0,tmp.indexOf(":"));
						 //System.out.println( Server2.output1);
					//	 Server1 s1=new Server1();
					//	 s1.listCourseAvailabilitys1get1(output4);
						 
					 }else if(kept.trim().equals("methodenroll"))
					 {
						 Server2.enrol1=null;
						 Server2.enrol1 = tmp.substring(0,tmp.indexOf(":"));
						 
						 
						// String h=tmp.substring(0,tmp.indexOf(":"));
						 //Server2 d=new Server2();
						 //d.ff(h);
						 System.out.println(Server2.enrol1);
						 
					 }else if(kept.trim().equals("methoddrop"))
					 {
						 Server2.drop1 = tmp.substring(0,tmp.indexOf(":"));
					 }
					 
				  
				  
			  } catch (SocketException e) {
				  System.out.println("Socket: " + e.getMessage());
			  } catch (IOException e) {
				  e.printStackTrace();
				  System.out.println("IO: " + e.getMessage());
			  } finally {
				  if (aSocket != null)
					  aSocket.close();
			  }
	     }

		public void start() {
			// TODO Auto-generated method stub
			t2.start ();
			
		}
	     
	     

	    
	 

	
}

 class receive1 implements Runnable {
	 
	 public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_14/Server2.txt");
	    BufferedWriter output0;
	 Thread t1;
	    int serverPort;
	    receive1()
	    {
	    	//serverPort=p;
	    	t1=new Thread(this);
	    		
	    	
	    }
	    public synchronized void run() 
	    {
	    	DatagramSocket aSocket = null;
	   	
			 try {
				 aSocket = new DatagramSocket(8001);
			
				 String kept2 = null;
				 System.out.println("Server 8001 Started............");
				 ImpInterFace imobj2 = new ImpInterFace();
				 while (true) {
					
					 byte[] buffer = new byte[1000];
					 byte[] message = new byte[1000];
					 DatagramPacket request = new DatagramPacket(buffer, buffer.length);
					 aSocket.receive(request);
					 
					 
					 try {
							output0 = new BufferedWriter(new FileWriter(f0,true));
							Date date1 = new Date();
							output0.write("\n"+sdfs1.format(date1)+" ,request comming from "+request.getAddress()+" port : "+request.getPort());
							output0.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 
					 
					 
					 String msg1= new String(request.getData());
					 String kept = msg1.substring( 0, msg1.indexOf(":"));
					 if(kept.equals("methodlist"))
					 {
						 
						 String kept1 = msg1.substring(msg1.indexOf(":")+1,msg1.length());
						
					
						  kept2=imobj2.listCourseAvailabilityserver(kept1,"server2");
						  kept2=kept2+":methodlist";
						  message  = kept2.getBytes();
					 } 
					 else if(kept.equals("methodenroll"))
					 {
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("#"));
						 String seme =   msg1.substring(msg1.indexOf("#")+1,msg1.length());
						// ImpInterFace imobj = new ImpInterFace(2);
						 kept2=imobj2.enrolCourse1(stuid,corid,seme);
						 System.out.println("cheking : "+ImpInterFace.compfallstudent.get(stuid+"2"));
						  
						 kept2=kept2+":methodenroll";
						 System.out.println("output----"+kept2);
						 message  = kept2.getBytes();
						 
					 }else if(kept.equals("methoddrop"))
					 {
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.length());
						// System.out.println("###"+stuid+corid+seme+"###");
						 ImpInterFace imobj = new ImpInterFace(2);
						 kept2=imobj.dropCourse1(stuid,corid);
						 
						 kept2=kept2+":methoddrop";
						  
						 kept2.trim();
						 message  = kept2.getBytes(); 
					 }
					  
					 
					 DatagramPacket reply = new DatagramPacket(message, kept2.length(), request.getAddress(),
						request.getPort());
					
					 
					 
					 try {
							output0 = new BufferedWriter(new FileWriter(f0,true));
							Date date1 = new Date();
							output0.write(" ,reply sent to "+request.getAddress()+" port : "+request.getPort()+"\n\n");
							output0.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 
					 
					 aSocket.send(reply);
				 }
			 } catch (SocketException e) {
				 System.out.println("Socket: " + e.getMessage());
			 } catch (IOException e) {
				 System.out.println("IO: " + e.getMessage());
			 } finally {
				 if (aSocket != null)
					 aSocket.close();
			 }
		 
	    }
		public void start() {
			// TODO Auto-generated method stub
			t1.start ();
		}
	
}






public class Server2 {

	 public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_14/Server2.txt");
	    BufferedWriter output0;
	
	 public static String output1;
	 public static String enrol1,drop1;  
	 public static String val; 
	 public Server2()
	 {
		 output1=" ";
		 enrol1=" ";
		 val=" ";
		 drop1=" ";
	 }
	
	
	// public synchronized void listCourseAvailabilitys1get1(String output1)
	// {
//		 output=output1;
		 
//	 } 
	public synchronized String  listCourseAvailabilitys2send(String semester)
	{
		
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server1 (COMP) & server 3(INSE), ");
			output0.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		  sendMessage1 R2 = new sendMessage1(8000,semester,"methodlist"); // methodenroll , methoddrop , methodschedule
	      R2.start();
	      sendMessage1 R3 = new sendMessage1(8002,semester,"methodlist");
	      R3.start();	
	     try {
			R2.t2.join();
			R3.t2.join(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
	  
	      
	      return output1;
	} 
	
	public void ff(String a)
	{
	 val=a;	
	 System.out.println("val:"+val);
	}
	
	public String enrolCourseserver1(String studentID, String courseID, String semester) {
		// TODO Auto-generated method stub
	
		if((courseID.substring(0, 4)).equals("comp"))
		{
		sendMessage1 R8 = new sendMessage1(8000,studentID,courseID,semester,"methodenroll"); // methodenroll , methoddrop , methodschedule
		
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server1 (COMP) , ");
			output0.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	      R8.start();
	      
	      try {
	    	  System.out.println("j"+  R8.t2.isAlive() );
	    	  System.out.println("val2:"+enrol1);
				R8.t2.join(); 
				  System.out.println("vb"+  R8.t2.isAlive() );
			
			      return enrol1;
			} catch (Exception e) {
				// TODO: handle exception
			}
	      
	      //System.out.println(Server2.enrol1); 
	    
	      
	     // return enrol1;
		}else if((courseID.substring(0, 4)).equals("inse"))
		{
	      sendMessage1 R2 = new sendMessage1(8002,studentID,courseID,semester,"methodenroll");
	      
	      try {
				output0 = new BufferedWriter(new FileWriter(f0,true));
				Date date1 = new Date();
				output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server3 (INSE) , ");
				output0.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      
	      R2.start();
	      try {
				R2.t2.join(); 
				  
			      return enrol1;
			} catch (Exception e) {
				// TODO: handle exception
			}
	  
	   
	     // return enrol1;
	      
		}
		
	     return "ggg";
		
	}
	
	
	
	public String dropCourseserver1(String studentID, String courseID) {
		// TODO Auto-generated method stub
		System.out.println(courseID);
		if((courseID.substring(0, 4)).equals("comp"))
		{
		sendMessage1 R2 = new sendMessage1(8000,studentID,courseID,"methoddrop"); // methodenroll , methoddrop , methodschedule
	    
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" , dropcourse request to server1 (COMP) , ");
			output0.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		R2.start();
	      
	      try {
	    	
	    	 
				R2.t2.join(); 
			
			      return drop1;
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}

		}else if((courseID.substring(0, 4)).equals("inse"))
		{
	      sendMessage1 R2 = new sendMessage1(8002,studentID,courseID,"methoddrop");
	      try {
				output0 = new BufferedWriter(new FileWriter(f0,true));
				Date date1 = new Date();
				output0.write("\n"+sdfs1.format(date1)+" , dropcourse request to server3 (INSE) , ");
				output0.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      
	      R2.start();
	      
	      try {
				R2.t2.join();
			
			} catch (Exception e) {
				// TODO: handle exception
			}
	      return drop1;
	      
		}
		return drop1;
	     
		
	}
	
	
//	public synchronized String  listCourseAvailabilitys1get()
//	{
//		System.out.println(output+"uuuuuuu");
//		return output;		
//	}
	
	public static void main(String args[]) throws Exception{
	
		
		//ImpInterFace obj1 = new ImpInterFace(ID,temp1,temp2);
		
		ImpInterFace stub = new ImpInterFace();
		Registry registry = LocateRegistry.createRegistry(3901);
		registry.bind("SOENserver", stub);
		System.out.println("SOEN Server is running now...");
		
		
		File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_14/Server2.txt");
		BufferedWriter output0 =new BufferedWriter(new FileWriter(f0,true));
		Date date1 = new Date();
		output0.write(sdfs1.format(date1)+"  ,"+"SOEN Server is running now...");
		
		
		Scanner scanner = new Scanner(System.in);
		 receive1 R1 = new receive1();
	      R1.start();
	      
		
			  
		     
		
	}

} 



