package sg.edu.ep.c346.id20029318.oursingapre;

import java.io.Serializable;

public class Island implements Serializable {

    private int id;
    private String name;
    private String description;
    private int areaKM2;
    private int stars;

    public Island(String name, String description, int areaKM2, int stars) {
        this.name = name;
        this.description = description;
        this.areaKM2 = areaKM2;
        this.stars = stars;
    }

    public Island(int id, String name, String description, int areaKM2, int stars) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.areaKM2 = areaKM2;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public Island setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAreaKM2() {
        return areaKM2;
    }

    public void setAreaKM2(int areaKM2) {
        this.areaKM2 = areaKM2;
    }

    public int getStars() {
        return stars;
    }

    public Island setStars(int stars) {
        this.stars = stars;
        return this;
    }

    @Override
    public String toString() {
        String starsString = "";
        if (stars == 5){
            starsString = "*****";
        } else if (stars == 4){
            starsString = "****";
        }

        //or
        for(int i = 0; i < stars; i++){
            starsString += "*";
        }
        return name + "\n" + description + " - " + areaKM2 + "\n" + starsString;

    }
}

