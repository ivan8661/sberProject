package sber.dict;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<City> cities = parseFile();
        HashMap<String, Integer> map = new HashMap<>();
        for(City city : cities) {
            map.merge(city.getRegion(), 1, Integer::sum);
        }
        System.out.println(map);
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