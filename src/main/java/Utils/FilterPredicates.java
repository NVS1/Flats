package Utils;

import model.Flat;

import java.util.function.Predicate;

public class FilterPredicates {
    public static Predicate<Flat> hasDistrict (String district){
        return flat -> flat.getDistrict().startsWith(district);
    }
    public static Predicate<Flat> hasAddress (String adress){
        return flat -> flat.getAddress().startsWith(adress);
    }
    public static Predicate<Flat> hasArea (int areaFrom, int areaTo){
        return flat -> flat.getArea()>=areaFrom && flat.getArea()<=areaTo;
    }
    public static Predicate<Flat> hasNumOfRoom (int num){
        return flat -> flat.getNumOfRoom()==num;
    }
    public static Predicate<Flat> hasPrice (long priceFrom, long priceTo){
        return flat -> flat.getPrice()>=priceFrom && flat.getPrice()<=priceTo;
    }
}
