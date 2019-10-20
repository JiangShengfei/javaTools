import java.sql.*;

public class Database {
    String JDBC_DRIVER;
    String DB_URL;
    String USER;
    String PWD;
    String TEST_SQL;

    public Database(String jdbc_dir, String db_url, String user, String pwd, String test_sql){
	this.JDBC_DRIVER = jdbc_dir;
	this.DB_URL = db_url;
	this.USER = user;
	this.PWD = pwd;
	this.TEST_SQL = test_sql;
    }

    public void Glzz(String sql){
	Connection conn = null;
	Statement stmt = null;

	try{
	    Class.forName(JDBC_DRIVER).newInstance();
	    System.out.println("Connecting to database...");
	    conn = DriverManager.getConnection(DB_URL, USER, PWD);
	    System.out.println("Creating statement...");
	    stmt = conn.createStatement();

	    ResultSet rs = stmt.executeQuery(TEST_SQL);
        
        int count = 1;
	    while(rs.next()){
		System.out.print("记录:" + Integer.toString(count) + " => ");
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		for (int i=1; i<=columnCount; i++){
		    String msg = rs.getString(i);
		    System.out.print(msg + "\t");
		    count++;
		}
		System.out.print("\n");
	    }

	    rs.close();
	    stmt.close();
	    conn.close();

	    System.out.println("database test success!");
        
	}catch(SQLException se){
	    //Handle error for jdbc
	    se.printStackTrace();
	}catch(Exception e){
	    //Handle error for class.forName
	    e.printStackTrace();
	}finally{
	    //finally block used to close resources
	    try{
		if(stmt!=null)
		    stmt.close();
	    }catch(SQLException se2){
	    }
	    try{
		if(conn!=null)
		    conn.close();
	    }catch(SQLException se){
		se.printStackTrace();
	    }
	}
    }
    
    public void printInfo(){
	System.out.println("驱动名称:" + JDBC_DRIVER);
	System.out.println("数据库URL:" + DB_URL);
	System.out.println("用户名:" + USER);
	System.out.println("密码:" + PWD);
	System.out.println("数据测试SQL语句:" + TEST_SQL);
    }
}
