
package spring1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This example is the same as previous version except that it uses the
 * open source Spring Framework for Dependency Injection. See the Spring
 * configuration file ("applicationContext.xml") under the default package.
 * 
 * @author  Jim Lombardo, WCTC Lead Java Instructor
 * @version 1.00
 * @see     applicationContext.xml for Spring configuration format
 * @see     Project properties - Libraries for reference to 3rd party
 * libraries used in the project.
 * @see     http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/
 */
public class Driver {

    public static void main(String[] args) {

        /* 
         * Retrieve a Spring application context from the classpath. You could
         * use a different Spring class for an external file path. 
         * This causes Spring to instantiate all beans. You only need to do 
         * this once, but if you do it again, it returns a copy.
         */
        final AbstractApplicationContext ctx = 
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // To store your config file external to the app use something like 
        // this, where /conf/applicationContext.xml is relative to the root
        // of the startup drive.
//        ApplicationContext ctx =
//          new FileSystemXmlApplicationContext("file:/conf/applicationContext.xml");

        
        // Now ask Spring to give you a fully configured Copier object. Note
        // that the reader and writer have already been injected by Spring.
        Copier copier = (Copier)ctx.getBean("copier");
        copier.copy();

        // Send end of program message
        System.out.println("Program ended.  "
                + "Line of reader input copied successfully to writer output.");
    }
}
