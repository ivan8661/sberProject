package sber.dict;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<City> cities = parseFile();
        System.out.println("source: ");
        formattingOutput(cities);
        //the default comparer by Name with compareTo
        System.out.println("sort by name:");
        cities.sort(City::compareTo);
        formattingOutput(cities);
        //sorting with lambda by federation district and name with upper case
        System.out.println("sort by district and name:");
        cities.sort((o1, o2) -> {
            if(o1.getDistrict().equals(o2.getDistrict())){
                return o1.getName().compareTo(o2.getName());
            } else {
                return o1.getDistrict().compareTo(o2.getDistrict());
            }
        });
        formattingOutput(cities);
        //sorting by name again using Comparator
        System.out.println("sort by name:");
        cities.sort(City.NameComparator);
        formattingOutput(cities);
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

    public static void formattingOutput(ArrayList<City> cities) {
        for(City city : cities){
            System.out.println(city+"\n");
        }
    }
}