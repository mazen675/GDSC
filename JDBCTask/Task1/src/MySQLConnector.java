import java.sql.*;

public class MySQLConnector {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "0000";
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT COUNT(name) from Students");
            rs.next();
            int size= rs.getInt(1);
            rs=st.executeQuery("SELECT * FROM Students");
            for(int i=0;i<size;i++)
            {
                rs.next();
                String name=rs.getString("name");
                int id=rs.getInt("id");
                String grade=rs.getString("grade");
                System.out.println("Name: "+name +" ,ID: "+id +" ,Grade: "+grade);
            }
            con.close();
        }
        catch (SQLException ex){
            System.out.println(ex);
        }
        
    }
}
