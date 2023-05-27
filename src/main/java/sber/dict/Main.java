package sber.dict;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<City> cities = parseFile();
        Object[] cityArray = cities.toArray();
        int maxPopulation = ((City)cityArray[0]).getPopulation();
        int indexPopulation = 0;
        for(int i = 0; i < cityArray.length; ++i){
            City city = (City) cityArray[i];
            if(city.getPopulation() > maxPopulation){
                indexPopulation = i;
                maxPopulation = city.getPopulation();
            }
        }
        System.out.println("["+indexPopulation+"] = " + maxPopulation);
    }

    public static ArrayList<City> parseFile() throws FileNotFoundException {
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
        return cities;
    }
}