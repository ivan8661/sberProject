package sber.dict;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File fileWithCities = new File("src/main/resources/data.csv");
        ArrayList<City> cities = new ArrayList<>();
        try {
            Scanner sc = new Scanner(fileWithCities);
            while(sc.hasNextLine()){
                Scanner columns = new Scanner(sc.nextLine());
                columns.useDelimiter(";");
                String[] fields = new String[6];
                for(int i = 0; i < 6 && columns.hasNext(); ++i){
                    fields[i] = columns.next();
                }
                City city = new City(fields[1], fields[2], fields[3], Integer.parseInt(fields[4]), fields[5]);
                cities.add(city);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("file " + fileWithCities.getName() + " doesn't found or exist!!!");
        }
        for (City city: cities) {
            System.out.println(city+"\n");
        }
    }
}