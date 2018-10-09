package pathsExample;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class createPath {

    public static void main(String[] args) {
        //Paths.get generates a local path according with the running OS. The origin can be the following:

        //A string
        Path p1 = Paths.get("D:/tmp/foo");
        System.out.println(p1.toString());
     

        //An input argument: A String or an URI
        //Eclipse: Right click --> Run as --> Run Configurations --> Java application --> Program arguments (ex.C:\Documents)
        //Netbeans: RightClick project --> Properties --> RUn --> Select MainClass and arguments --> Run the project (not the file)
        Path p2 = Paths.get(args[0]);
        System.out.println(p2.toString());

        //URI
        Path p3 = Paths.get(URI.create("file:///D:/NetBeansProjects/DWEC_1.0/public_html/actividad2_4.html"));
        System.out.println(p3.toString());

        //Concat strings and/or home variables
        Path p4 = Paths.get(System.getProperty("user.home"), "logs", "foo.log");
        System.out.println(p4.toString());

        //Otra variable de entorno
        Path p5 = Paths.get(System.getProperty("user.dir"), "Programas");
        System.out.println(p5.toString() + "hola");

    }
}
