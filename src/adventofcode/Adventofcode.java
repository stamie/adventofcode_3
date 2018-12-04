/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Stream;
import java.lang.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 *
 * @author stampel
 */
public class Adventofcode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String fileName = "/home/stampel/adventofcode_3/src/advent_proba.txt";
       
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
                    List<String> y =  new ArrayList();
                    stream.forEach(s-> {
                    y.add(s);
                    
                    });
                    
                    
                    
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
