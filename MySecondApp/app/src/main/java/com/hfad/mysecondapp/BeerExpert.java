package com.hfad.mysecondapp;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    List<String> getBeers(String beer_type) {
        List<String> brands = new ArrayList<>();
        switch (beer_type) {
            case "german beer":
                brands.add("Heineken");
                brands.add("Budweiser");
                break;
            case "belgian ale":
                brands.add("Duvel");
                brands.add("Chimay");
                break;
            case "irish beer":
                brands.add("Guinness");
                brands.add("Murphy's");
                break;
            case "dark beer":
                brands.add("Porter");
                brands.add("Stout");
                break;
            case "light beer":
                brands.add("Miller Lite");
                brands.add("Coors Light");
                break;
            default:
                brands.add("No Brand Selected!");
                break;
        }
        return brands;
    }
}
