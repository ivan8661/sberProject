package sber.dict;

import java.util.Comparator;

public class City implements Comparable<City>{

    private String name;

    private String region;

    private String district;

    private int population;

    private String foundation;

    public City() {
    }

    public City(String name, String region, String district, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }

    @Override
    public int compareTo(City o) {
        return this.name.compareTo(o.name);
    }

    public static Comparator<City> NameComparator = new Comparator<City>() {
        @Override
        public int compare(City o1, City o2) {
            if(o1.equals(o2))
                return 0;
            return o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
        }
    };

}
