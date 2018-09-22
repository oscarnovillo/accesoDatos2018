/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.filesnio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author oscar
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        
        List<String> lineas = new LinkedList<>();
        
        lineas.add("linea uno");
        lineas.add("linea dos");
        lineas = Files.readAllLines(Paths.get("test"));
      
        lineas.forEach(System.out::println);
        lineas.stream().filter(s -> s.length() > 4).collect(Collectors.toList()).forEach(System.out::println);
        Files.write(Paths.get("test1"),lineas.stream().filter(s -> s.length() > 4).map(String::toUpperCase).collect(Collectors.toList()));
        
    }
}
