import java.sql.*;

public class Employee {
    static String url = "jdbc:mysql://localhost:3306/mydatabase";
    static String user = "root";
    static String password = "0000";
    static Connection con;
        public static void main(String[] args) {

            try {
                 con = DriverManager.getConnection(url, user, password);
                    createTable();
                    fillData();
                    updateUsingBatching();
                    con.close();
            }
            catch(SQLException ex)
            {
                System.out.println(ex);
            }

        }
        static void createTable() throws SQLException{

                String query = "CREATE TABLE employee(" +
                        "F_name varchar(50)," +
                        "L_name varchar(50)," +
                        "Sex varchar(50)," +
                        "Age int," +
                        "Address varchar(50)," +
                        "Phone_Number varchar(50)," +
                        "Vacation_Balance int DEFAULT 30);";
                PreparedStatement ps = con.prepareStatement(query);
                ps.execute();

        }
        static void fillData() throws SQLException
        {
            String query="INSERT INTO employee(F_name,L_name,Sex,Age,Address,Phone_Number) VALUES(?,?,?,?,?,?);";
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,"Ahmed");
            ps.setString(2,"Mohamed");
            ps.setString(3,"Male");
            ps.setInt(4,28);
            ps.setString(5,"Cairo");
            ps.setString(6,"1111");
            ps.addBatch();
            ps.setString(1,"Alaa");
            ps.setString(2,"Elsayed");
            ps.setString(3,"Male");
            ps.setInt(4,25);
            ps.setString(5,"Alexandria");
            ps.setString(6,"2222");
            ps.addBatch();
            ps.setString(1,"Ali");
            ps.setString(2,"Wael");
            ps.setString(3,"Male");
            ps.setInt(4,24);
            ps.setString(5,"NewYork");
            ps.setString(6,"3333");
            ps.addBatch();
            ps.setString(1,"Mariam");
            ps.setString(2,"Abdullah");
            ps.setString(3,"Female");
            ps.setInt(4,55);
            ps.setString(5,"Atlanta");
            ps.setString(6,"4444");
            ps.addBatch();
            ps.setString(1,"Maged");
            ps.setString(2,"Mohamed");
            ps.setString(3,"Male");
            ps.setInt(4,57);
            ps.setString(5,"London");
            ps.setString(6,"5555");
            ps.addBatch();
            ps.executeBatch();
            con.commit();
        }
        static void updateUsingBatching()throws SQLException{
            String vacationUpdate="UPDATE employee set Vacation_Balance=45 WHERE Age>45 ;";
            String nameUpdate="UPDATE Employee SET F_Name = CONCAT(CASE WHEN Sex = 'Male' THEN 'Mr. ' WHEN Sex = 'Female' THEN 'Mrs. ' ELSE '' END, F_Name) WHERE Age > 45";
            con.setAutoCommit(false);
            Statement st= con.createStatement();
            st.addBatch(vacationUpdate);
            st.addBatch(nameUpdate);
            st.executeBatch();
            con.commit();
        }
    }

