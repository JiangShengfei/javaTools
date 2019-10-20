
public class DatabaseCheck {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";
    static final String USER = "rs";
    static final String PWD = "1682";
    //static final String TEST_SQL = "select * from test";
    static final String TEST_SQL = "select version(),user()";

    public static void main(String[] args){
	Database mydb = new Database(JDBC_DRIVER, DB_URL, USER, PWD, TEST_SQL);
	mydb.printInfo();
	mydb.Glzz(TEST_SQL);
    }
}
