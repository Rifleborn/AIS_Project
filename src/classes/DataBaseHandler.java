package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 * Клас який відповідає за взаємодію з базою даних
 * @author Butcher
 */

public class DataBaseHandler {
        public class a{
            
        }
        private static Connection connection;
	private static Statement statmt;
	private static ResultSet resSet;
        private static PreparedStatement prepst;

	//-------- connection to database --------
	public static void Connection() throws ClassNotFoundException, SQLException {       

                try {
		   connection = null;
		   Class.forName("org.sqlite.JDBC");
		   connection = DriverManager.getConnection("jdbc:sqlite:database.s3db");
                }
                catch (Exception e){
                    System.out.println("!DATABASE NOT FOUND!");
                }
		   System.out.println("===== База під'єднана =====");
	   }
	
	//-------- create/open table --------
	public static void CreateDB() throws ClassNotFoundException, SQLException {
		statmt = connection.createStatement();
		System.out.println("===== Таблиця існує =====");
	}
        
        //-------- removing object from table --------
	public static void RemoveObjectDB() throws ClassNotFoundException, SQLException {
		//
          
	}
	
	//-------- writing data to DB --------
	public static void WriteDB(String address, String passport, String SNP, String birthYear, String gender, int privelegeCode, String studentGroup, int room, String colonizeDate) throws SQLException, ClassNotFoundException {           
              String query = "insert into Students(Address, Passport, SNP, BirthYear, Gender, PrivelegeCode, StudentGroup, Room, ColonizeDate) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
              
              prepst = connection.prepareStatement(query);
              prepst.setString(1, address);
              prepst.setString(2, passport);
              prepst.setString(3, SNP);
              prepst.setString(4, birthYear);
              prepst.setString(5, gender);
              prepst.setInt(6, privelegeCode);
              prepst.setString(7, studentGroup);
              prepst.setInt(8, room);
              prepst.setString(9, colonizeDate);
              prepst.execute();
              prepst.close();
              System.out.println("===== Дані успішно записано =====");

	}
	
	//-------- getting data from DB --------
	public static String ReadDB() throws SQLException, ClassNotFoundException {
              
                resSet = statmt.executeQuery("SELECT StudentsCode, Address, Passport, SNP, BirthYear, Gender, PrivelegeCode, StudentGroup, Room, ColonizeDate FROM Students");
		int countStudents = 0;
                StringBuilder data = new StringBuilder();
                
                // to console
		while(resSet.next()){
		int id = resSet.getInt("StudentsCode");
		String address = resSet.getString("Address");
		String passport = resSet.getString("Passport");
                String SNP = resSet.getString("SNP");
		String birthYear = resSet.getString("BirthYear");
                String gender = resSet.getString("Gender");
		int privelegeCode = resSet.getInt("PrivelegeCode");
                int room = resSet.getInt("Room");
                String studentGroup = resSet.getString("StudentGroup");
		String colonizeDate = resSet.getString("ColonizeDate");
                
                // output to console
                System.out.println( "StudentCode = " + id);
	        System.out.println( "Address = " + address);
	        System.out.println( "Passport = " + passport);
                System.out.println( "SNP = " + SNP);
	        System.out.println( "Birth year = " + birthYear);
	        System.out.println( "Gender = " + gender);
                System.out.println( "Privelege code = " + privelegeCode);
	        System.out.println( "Room = " + room);
                System.out.println( "Group = " + studentGroup);
	        System.out.println( "Colonize date = " + colonizeDate + "\n");
                
                String idString = String.valueOf(id);
                data.append("StudentCode: " +  idString + "\n");
                data.append("Address: " + address + "\n");
                data.append("Passport: " + passport + "\n");
                data.append("SNP = " + SNP + "\n");
                data.append("Birth year " + birthYear + "\n");
                data.append("Gender = " + gender + "\n");
                data.append("Privelege code = " + privelegeCode + "\n");
                data.append("Room = " + room + "\n");
                data.append("Student group = " + studentGroup + "\n");
                data.append("Colonize date = " + colonizeDate + "\n");
                data.append("\n");
                
                countStudents++;
		}	
		
		System.out.println("===== Таблиця  виведена =====");
                System.out.println("Кількість студентів в базі даних:" + countStudents);

                return data.toString();   
                
    }
	
	//-------- closing connection -----------
	public static void CloseDB() throws ClassNotFoundException, SQLException {
		// closing connection
                connection.close();
		statmt.close();
		resSet.close();
              
		System.out.println("!Connection closed!");
	   }
            
    }
