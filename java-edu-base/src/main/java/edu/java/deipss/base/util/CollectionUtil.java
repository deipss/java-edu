package edu.java.deipss.base.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtil {

    public  static <T>  List<T> diffKeepRight(Collection<T> a,Collection<T> b){
        return a.stream().filter(i->!b.contains(a)).collect(Collectors.toList());
    }


    public  static <T>  List<T> diffKeepLeft(Collection<T> a,Collection<T> b){
        return diffKeepRight(b,a);
    }


    public  static <T>  List<T> intersection(Collection<T> a,Collection<T> b){
        return a.stream().filter(i->b.contains(a)).collect(Collectors.toList());
    }



}
