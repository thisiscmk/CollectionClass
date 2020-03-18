package org.example;

import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;

/*  CollectionClass.java
    This class include the basic use of java collection interfaces with junit as a testing framework
    Author: CMK
    Date: 15 March 2020
 */

import java.util.*;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class CollectionClass {

    //initialize Collection classes
    static final List<String> city = Arrays.asList("Johannesburg", "Cape Town", "Pretoria");
    static final Set<String> color= Set.of("Red", "Blue", "Yellow");
    static final Map<Integer,String> map = Map.of(100, "John", 101, "Deborah", 102, "Sansa");

    public static void main(String [] args){


        //traversing the list
        System.out.println("List:");
        for(String c : city){
            System.out.println(c);
        }
        //traversing the set
        System.out.println();
        System.out.println("Set:");
        for(String c : color){
            System.out.println(c);
        }

        //traversing the map
        System.out.println();
        System.out.println("Map");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }


    //Tests
    @Test
    public void testList(){
        List<String> expected = Arrays.asList("Johannesburg", "Cape Town", "Pretoria");
        assertThat(city, is(expected));
    }

    @Test
    public void testListItem(){
        assertThat(city, hasItems("Pretoria"));
    }

    @Test
    public void testListEmpty(){
        assertThat(city, not(IsEmptyCollection.empty()));
    }

    @Test
    public void testEqualSets() {
        Set<String> expectedColor= Set.of("Red", "Blue", "Yellow");
        assertThat(color, is(expectedColor));
    }

    @Test
    public void testSetEmpty(){
        assertThat(color, is(IsEmptyCollection.empty()));
    }

    @Test
    public void testMapEquals(){
        Map<Integer,String> otherMap = Map.of(100, "John", 101, "Deborah", 102, "Sansa");
        assertThat(map, is(otherMap));

    }

    @Test
    public void testMapKey(){
        assertThat(map, IsMapContaining.hasKey(100));
    }

    @Test
    public void testMapSize(){
        assertThat(map.size(), is(3));
    }

}