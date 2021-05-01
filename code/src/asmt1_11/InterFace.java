package asmt1_11;
import java.rmi.*;

public interface InterFace extends Remote  {
	
	

	public String addCourse(String courseID, String semester) throws RemoteException;
	public String removeCourse(String courseID, String semester) throws RemoteException;
	public String listCourseAvailability (String semester) throws RemoteException;
	public String enrolCourse (String studentID, String courseID,String semester) throws RemoteException;
	public String getClassSchedule (String studentID) throws RemoteException;
	public String dropCourse (String studentID, String courseID) throws RemoteException;
	public void courseCapacity (int Capacity) throws RemoteException;
	public void UserId (String id) throws RemoteException;
	
}
