# JSP
This contains JSP codes from a lecture.

# 02_servlethelloworld
this contains an example of URL mapping by using ***web.xml or annotation.***

# 05_servlethelloworld
this contains the following contents.
* Sending data by using Form tag with POST method.
* How to use Parameter function.
* Encoding Korean.

# 06_JSP
* Scriptlet, Expression, Directive

# 07_Session
this contains the session example of creating login page.

* How to create a session.
* How to get a session.
* How to delete a session.

# 08_Exception
this contains the exception example of redirecting to self-created error page.

* How to redirect the page to error page by using web.xml and a page directive.

# 09_userManagement
This coutains the app of creating, delting, modifying a user

* the concept of ***Connection Full*** is applied to this app. Please find the code below.

  **server -> context.xml through tomcat server**
~~~
  <Resource 
    auth = "Container" 
    drvierClassName = "oracle.jdbc.driver.OracleDriver" 
    url = "jdbc:oracle:thin:@localhost:1521:xe" 
    username = "scott"
    password = "tiger" 
    name = "jdbc/Oracle11g" 
    type = "javax.sql.DataSource" maxActive = "50"
    maxWait = "1000"
  />
~~~
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**userDAO.java**
~~~
  private Connection getConnection() {
    Context context = null;
    DataSource dataSource = null;
    Connection con = null;
    
    try {
      context = new InitialContext();
      dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
      con = dataSource.getConnection();
    } catch (Exception e) {
      System.out.println("Error at getConnection()");
    }
    return con;
  }
~~~
