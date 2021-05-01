package asmt1_13;
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

//import asmt1_11.ImpInterFace;
//import asmt1_11.Server2;
//import asmt1_11.Server3;
import asmt1_11.*;



   class sendMessage implements Runnable {
	
	    Thread t1;
	    public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    int serverPort;
	    String ss1,ss2;
	    String msg;
	    String sid,sem,method,courseid;
	    File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_13/Server1.txt");
	    BufferedWriter output0;
	   
	    sendMessage(int p,String st1,String st2)
	    {
	    	serverPort=p;
	    	ss1=st1;
	    	ss2=st2;
	    	
	    	msg=null;
	    	 msg=ss2+":"+ss1;
	    	 t1=new Thread(this);
	    }
	   
	    public sendMessage(int p, String studentID,String courseID, String sem, String methd) {
	    	
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
	    
public sendMessage(int p, String studentID,String courseID, String methd) {
	    	
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
				
				  System.out.println(msg);
				  
				  byte[] message = msg.getBytes();
				  InetAddress aHost = InetAddress.getByName("localhost");
				  DatagramPacket request = new DatagramPacket(message, msg.length(), aHost, serverPort);
				  aSocket.send(request);
				  
				 
					
					try {
						output0 = new BufferedWriter(new FileWriter(f0,true));
						Date date1 = new Date();
						output0.write(", Request message sent from the client to server with port number " + serverPort+" , ");
						output0.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				  System.out.println("Request message sent from the client to server with port number " + serverPort + " is: "
					+ new String(request.getData()));
				  
				  
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
				  System.out.println((reply.getData()).length);
				  System.out.println("cheking : "+t1.isAlive()+ImpInterFace.compfallstudent.get(sid+"2"));
				  System.out.println(ImpInterFace.compfallstudent);
				 // System.out.println(new String(reply.getData())); 
				  String tmp = new String(reply.getData());
			
			   	String kept = tmp.substring(tmp.indexOf(":")+1,tmp.length());
			  
					 if(kept.trim().equals("methodlist"))
					 {
		
						 	
						 Server1.output += tmp.substring(0,tmp.indexOf(":"));
			
						 
					 }else if(kept.trim().equals("methodenroll"))
					 {
						 Server1.enrol = tmp.substring(0,tmp.indexOf(":"));
					
						 
					 }else if(kept.trim().equals("methoddrop"))
					 {
						 Server1.drop = tmp.substring(0,tmp.indexOf(":"));
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

 class receive implements Runnable {
	 
	 public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_13/Server1.txt");
	    BufferedWriter output0;
	 Thread t2;
	    int serverPort;
	    receive()
	    {
	    	//serverPort=p;
	    	t2=new Thread(this);
	    	
	    }
	    public synchronized void run() 
	    {
	    	DatagramSocket aSocket = null;
			 try {
				 aSocket = new DatagramSocket(8000);
				 
				 String kept2 = null; 
				 System.out.println("Server 8000 Started............");
				 while (true) {
					 byte[] buffer = new byte[1000];
					 byte[] message = new byte[1000];
				
					 message=null;
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
					 System.out.println(msg1.length()+"**");
					 System.out.println(msg1);
					msg1.trim();
				
					 System.out.println(msg1.length()+"77");
					 String kept = msg1.substring( 0, msg1.indexOf(":"));
					 if(kept.equals("methodlist"))
					 {
						 String kept1 = msg1.substring(msg1.indexOf(":")+1,msg1.length());
						
						 ImpInterFace imobj = new ImpInterFace(1);
						  kept2=imobj.listCourseAvailabilityserver(kept1,"server1");
					
						  kept2=kept2+":methodlist";
						  message  = kept2.getBytes();
					 } 
					 else if(kept.equals("methodenroll"))
					 {
						 
						 String stuid = msg1.substring(msg1.indexOf(":")+1,msg1.indexOf("*"));
						 String corid = msg1.substring(msg1.indexOf("*")+1,msg1.indexOf("#"));
						 String seme =   msg1.substring(msg1.indexOf("#")+1,msg1.length());
						// System.out.println("###"+stuid+corid+seme+"###");
						 ImpInterFace imobj = new ImpInterFace(2);
						 kept2=imobj.enrolCourse1(stuid,corid,seme);
						  System.out.println(kept2.length()+"00");
						 kept2=kept2+":methodenroll";
						  System.out.println(kept2.length()+"11");
						 kept2.trim();
						 message  = kept2.getBytes(); 
						 System.out.println(message.length);
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






public class Server1 {

	 public static String output,enrol,drop;
	 public static final DateFormat sdfs1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
	 public Server1()
	 {
		 output=" ";
		 enrol=" ";
		 drop=" ";
		 System.out.println(ImpInterFace.compfallsub);
	
	 }
	
	
	// public synchronized void listCourseAvailabilitys1get1(String output1)
	// {
//		 output=output1;
		 
//	 } 
	public synchronized String  listCourseAvailabilitys1send(String semester)
	{
		File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_13/Server1.txt");
		BufferedWriter output0;
		try {
			output0 = new BufferedWriter(new FileWriter(f0,true));
			Date date1 = new Date();
			output0.write("\n"+sdfs1.format(date1)+" ,enrolcourse request to server2 (SOEN) & server 3(INSE), ");
			output0.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  sendMessage R2 = new sendMessage(8001,semester,"methodlist"); // methodenroll , methoddrop , methodschedule
	      R2.start();
	      sendMessage R3 = new sendMessage(8002,semester,"methodlist");
	      R3.start();	
	     try {
			R2.t1.join();
			R3.t1.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
	      return output;
	} 
	
	
	
	public String enrolCourseserver(String studentID, String courseID, String semester) {
		// TODO Auto-generated method stub
		System.out.println(courseID);
		if((courseID.substring(0, 4)).equals("soen"))
		{
		sendMessage R2 = new sendMessage(8001,studentID,courseID,semester,"methodenroll"); // methodenroll , methoddrop , methodschedule
		
		File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_13/Server1.txt");
		BufferedWriter output0;
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
			      return enrol;
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}

		}else if((courseID.substring(0, 4)).equals("inse"))
		{
	      sendMessage R2 = new sendMessage(8002,studentID,courseID,semester,"methodenroll");
	      
	      
	      File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_13/Server1.txt");
			BufferedWriter output0;
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
				R2.t1.join();
			
			} catch (Exception e) {
				// TODO: handle exception
			}
	      return enrol;
	      
		}
		return enrol;
	     
		
	}

	
	
	public String dropCourseserver(String studentID, String courseID) {
		// TODO Auto-generated method stub
		System.out.println(courseID);
		if((courseID.substring(0, 4)).equals("soen"))
		{
		sendMessage R2 = new sendMessage(8001,studentID,courseID,"methoddrop"); // methodenroll , methoddrop , methodschedule
	      
		
		File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_13/Server1.txt");
		BufferedWriter output0;
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
			
			      return drop;
			} catch (Exception e) {
				// TODO: handle exception
				
				
			}

		}else if((courseID.substring(0, 4)).equals("inse"))
		{
	      sendMessage R2 = new sendMessage(8002,studentID,courseID,"methoddrop");
	      
	      File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_13/Server1.txt");
			BufferedWriter output0;
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
				R2.t1.join();
			
			} catch (Exception e) {
				// TODO: handle exception
			}
	      return drop;
	      
		}
		return drop;
	     
		
	}


//	public synchronized String  listCourseAvailabilitys1get()
//	{
//		System.out.println(output+"uuuuuuu");
//		return output;		
//	}
	
	public static void main(String args[]) throws Exception{
	
		
		//ImpInterFace obj1 = new ImpInterFace(ID,temp1,temp2);
		
		ImpInterFace stub = new ImpInterFace();
		Registry registry = LocateRegistry.createRegistry(3900);
		registry.bind("COMPserver", stub);
		System.out.println("COMP Server is running now...");
		File f0 = new File("/Users/apple/Documents/projects/asmt1_1/src/asmt1_13/Server1.txt");
		BufferedWriter output0 =new BufferedWriter(new FileWriter(f0,true));
		Date date1 = new Date();
		output0.write(sdfs1.format(date1)+"  ,"+"COMP Server is running now...");
		Scanner scanner = new Scanner(System.in);
		 receive R1 = new receive();
	      R1.start();
	      
		
			  
		     
		
	}


	
} 



