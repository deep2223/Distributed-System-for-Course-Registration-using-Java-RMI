package asmt1_15;
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




   class sendMessage2 implements Runnable {
	
	   
	   public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_15/Server3.txt");
		    BufferedWriter output0;
	   
	   Thread t1;
	    int serverPort;
	    String ss1,ss2;
	    String msg;
	    String sid,sem,method,courseid;
	    
	   
	   
	    sendMessage2(int p,String st1,String st2)
	    {
	    	serverPort=p;
	    	ss1=st1;
	    	ss2=st2;
	    	msg=null;
	    	 msg=ss2+":"+ss1;
	    	t1=new Thread(this);
	    	
	    }
	    
 public sendMessage2(int p, String studentID,String courseID, String sem, String methd) {
	    	
	    	serverPort=p;
	    	sid=studentID;
	    	this.sem=sem;
	    	method=methd;
	    	courseid=courseID;
	    	
	    	msg=null;
	    	msg=method+":"+sid+"*"+courseid+"#"+sem;
	    	t1=new Thread(this);
			// TODO Auto-generated constructor stub 
		}
 
 public sendMessage2(int p, String studentID,String courseID, String methd) {
 	
 	serverPort=p;
 	sid=studentID;
 
 	method=methd;
 	courseid=courseID;
 	
 	msg=null;
 	msg=method+":"+sid+"*"+courseid;
 	t1=new Thread(this);
		// TODO Auto-generated constructor stub 
	}
	   
	    public synchronized void run() 
	    {
	    	 DatagramSocket aSocket = null;
			  try {
				  aSocket = new DatagramSocket();
			
				  byte[] message = msg.getBytes();
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
					+ new String(reply.getData()));
				  
				  String tmp = new String(reply.getData());
			   	String kept = tmp.substring(tmp.indexOf(":")+1,tmp.length());
			   //	System.out.println(kept);
					 if(kept.equals("methodlist"))
					 {
					//	String output4=null;
						 
						 Server3.output2 += tmp.substring(0,tmp.indexOf(":"));
						 System.out.println( Server3.output2);
					//	 Server1 s1=new Server1();
					//	 s1.listCourseAvailabilitys1get1(output4);
						 
					 }else if(kept.equals("methodenroll"))
					 {
						 Server3.enrol2 = tmp.substring(0,tmp.indexOf(":"));
						 //System.out.println("fff"+Server3.enrol2);
						 
					 }else if(kept.equals("methoddrop"))
					 {
						 Server3.drop2 = tmp.substring(0,tmp.indexOf(":"));
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
			t1.start ();
			
		}
	     
	     

	    
	 

	
}

 class receive2 implements Runnable {
	 
	 
	 public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_15/Server3.txt");
	    BufferedWriter output0;
	 
	 
	 Thread t2;
	    int serverPort;
	    receive2()
	    {
	    	//serverPort=p;
	    	t2=new Thread(this);
	    	
	    }
	    public synchronized void run() 
	    {
	    	DatagramSocket aSocket = null;
			 try {
				 aSocket = new DatagramSocket(8002);
			
				 String kept2 = null;
				 System.out.println("Server 8002 Started............");
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
						
						 ImpInterFace imobj = new ImpInterFace(1);
						  kept2=imobj.listCourseAvailabilityserver(kept1,"server3");
						  kept2=kept2+":methodlist";
						  message  = kept2.getBytes();
					 } 
					 else if(kept.equals("methodenroll"))
					 {
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("#"));
						 String seme =   msg1.substring(msg1.indexOf("#")+1,msg1.length());
						 System.out.println("###"+stuid+corid+seme+"###");
						 ImpInterFace imobj2 = new ImpInterFace(2);
						 kept2=imobj2.enrolCourse1(stuid,corid,seme);
						// System.out.println("output2----"+kept2);
						 kept2=kept2+":methodenroll";
						 System.out.println("output2----"+kept2);
						 message  = kept2.getBytes();
						 System.out.println(new String(message));
						 System.out.println(message.length + "=="+kept2.length());
						 
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
			t2.start ();
		}
	
}






public class Server3 {

	 public static String output2,enrol2,drop2;
	 
	 public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_15/Server3.txt");
	    BufferedWriter output0;
	 
	 
	 public Server3()
	 {
		 output2=" ";
		 enrol2=" ";
		 drop2=" ";
	 }
	
	
	// public synchronized void listCourseAvailabilitys1get1(String output1)
	// {
//		 output=output1;
		 
//	 } 
	public synchronized String  listCourseAvailabilitys3send(String semester)
	{
		
		
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server2 (SOEN) & server 1(COMP), ");
			output0.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		  sendMessage2 R2 = new sendMessage2(8001,semester,"methodlist"); // methodenroll , methoddrop , methodschedule
	      R2.start();
	      sendMessage2 R3 = new sendMessage2(8000,semester,"methodlist");
	      R3.start();	
	     try {
			R2.t1.join();
			R3.t1.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
	  
	      
	      return output2;
	} 
	
	
	
	public String enrolCourseserver2(String studentID, String courseID, String semester) {
		// TODO Auto-generated method stub
		System.out.println(courseID);
		if((courseID.substring(0, 4)).equals("soen"))
		{
		sendMessage2 R2 = new sendMessage2(8001,studentID,courseID,semester,"methodenroll"); // methodenroll , methoddrop , methodschedule
	   
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server2 (SOEN) , ");
			output0.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		R2.start();
	      
	      try {
				R2.t1.join(); 
			
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}
	      
	      return enrol2;
		}else if((courseID.substring(0, 4)).equals("comp"))
		{
	      sendMessage2 R2 = new sendMessage2(8000,studentID,courseID,semester,"methodenroll");
	    
	      try {
				output0 = new BufferedWriter(new FileWriter(f0,true));
				Date date1 = new Date();
				output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server1 (COMP) , ");
				output0.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      
	      R2.start();
	      
	      try {
				R2.t1.join();
			
			} catch (Exception e) {
				// TODO: handle exception
			}
	      return enrol2;
	      
		}
		return enrol2;
	     
		
	}
	
	
	
	public String dropCourseserver2(String studentID, String courseID) {
		// TODO Auto-generated method stub
		System.out.println(courseID);
		if((courseID.substring(0, 4)).equals("soen"))
		{
		sendMessage2 R2 = new sendMessage2(8001,studentID,courseID,"methoddrop"); // methodenroll , methoddrop , methodschedule
	    
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" , dropcourse request to server2 (SOEN) , ");
			output0.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		R2.start();
	      
	      try {
	    	
	    	 
				R2.t1.join(); 
			
			      return drop2;
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}

		}else if((courseID.substring(0, 4)).equals("comp"))
		{
	      sendMessage2 R2 = new sendMessage2(8000,studentID,courseID,"methoddrop");
	      
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
				R2.t1.join();
			
			} catch (Exception e) {
				// TODO: handle exception
			}
	      return drop2;
	      
		}
		return drop2;
	     
		
	}
	
//	public synchronized String  listCourseAvailabilitys1get()
//	{
//		System.out.println(output+"uuuuuuu");
//		return output;		
//	}
	
	public static void main(String args[]) throws Exception{
	
		
		//ImpInterFace obj1 = new ImpInterFace(ID,temp1,temp2);
		
		ImpInterFace stub = new ImpInterFace();
		Registry registry = LocateRegistry.createRegistry(3902);
		registry.bind("INSEserver", stub);
		System.out.println("INSE Server is running now...");
		
		File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_15/Server3.txt");
		BufferedWriter output0 =new BufferedWriter(new FileWriter(f0,true));
		Date date1 = new Date();
		output0.write(sdfs1.format(date1)+"  ,"+"INSE Server is running now...");
		
		
		Scanner scanner = new Scanner(System.in);
		 receive2 R1 = new receive2();
	      R1.start();
	      
		
			  
		     
		
	}

} 



