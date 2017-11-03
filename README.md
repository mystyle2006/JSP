# JSP
This contains JSP codes from a lecture.

# 02_servlethelloworld
this contains an example of URL mapping by using ***web.xml or annotation.***

* By using annotation
<pre>
<code>
@WebServlet("/HWorld") //Annotation starts with '@'
public class HelloWorld extends HttpServlet {
</code>
</pre>

* By using web.xml
~~~
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>servlethelloworld</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  <servlet>
  	<servlet-name>Test</servlet-name> // this can be set randomly. this should be same as servlet-name in servlet-mapping.
  	<servlet-class>com.javalec.ex.HelloWorld</servlet-class> //the path of .java(servlet) file included with the package
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>Test</servlet-name>
  	<url-pattern>/HW</url-pattern> //mapping url
  </servlet-mapping>
</web-app>
~~~
