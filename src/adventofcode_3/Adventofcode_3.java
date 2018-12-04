/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode_3;

import Matrix.Matrix;
import Matrix.Pixel;
import Matrix.Row;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Stream;
import java.lang.*;
import java.lang.reflect.Array;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 *
 * @author stampel
 */
public class Adventofcode_3 {

    public static long getId(char[] chars) {

        int i = 1;
        long ret = 0;

        while (' ' != chars[i] && i < chars.length) {
            long diff;
            diff = Long.parseLong(Character.toString(chars[i]));
            ret = ret * 10 + diff;

            i++;
        }
        return ret;
    }

    public static long[] getStartPoint(char[] chars) {

        int i = 1;
        long[] ret = {0, 0};

        while ('@' != chars[i] && i < chars.length) {
            i++;
        }

        i += 2;

        while (',' != chars[i] && i < chars.length) {
            long diff;
            diff = Long.parseLong(Character.toString(chars[i]));
            ret[0] = ret[0] * 10 + diff;

            i++;
        }
        i++;
        while (':' != chars[i] && i < chars.length) {
            long diff;
            diff = Long.parseLong(Character.toString(chars[i]));
            ret[1] = ret[1] * 10 + diff;

            i++;
        }
        return ret;
    }

    public static long[] getEndPoint(char[] chars, long[] startPoint) {

        int i = 1;
        long[] ret = {0, 0};

        while (':' != chars[i] && i < chars.length) {
            i++;
        }

        i += 2;

        while ('x' != chars[i] && i < chars.length) {

            ret[0] = ret[0] * 10 + Long.parseLong(Character.toString(chars[i]));
            i++;

        }
        i++;
        while (i < chars.length) {

            ret[1] = ret[1] * 10 + Long.parseLong(Character.toString(chars[i]));
            i++;

        }

        ret[0] += startPoint[0];
        ret[1] += startPoint[1];
        return ret;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String fileName = "/home/stampel/adventofcode_3/src/advent.txt";

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            List<String> y = new ArrayList();
            stream.forEach(s -> {
                y.add(s);
                //System.out.println(s);
            });
            Matrix matrix = new Matrix();

            for (String string : y) {
                char[] chars;
                chars = string.toCharArray();
                long id = Adventofcode_3.getId(chars);
                long[] startPoint = Adventofcode_3.getStartPoint(chars);
                long[] endPoint = Adventofcode_3.getEndPoint(chars, startPoint);
                //System.out.println(endPoint[0]+";"+endPoint[1]);

                for (long pY = startPoint[1]; pY < endPoint[1]; pY++) {

                    List<Row> rows = matrix.getRows();
                    Row row = new Row(pY);

                    for (long pX = startPoint[0]; pX < endPoint[0]; pX++) {

                        Pixel pixel = new Pixel(id, pX);
                        row.addPixelToRow(pixel);
                    }

                    if (!matrix.addRow(row)) {
                        matrix.updateRow(row);

                    }

                }

            }
           
            

            System.out.println(matrix.getMoreClaimsCount());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
