package lzhou.programmingtest.careercup.test5758678876553216;

import java.time.Duration;
import java.time.LocalTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

/**
 * Unit test for simple App.
 */
public class RestaurantTest {
	Restaurant restaurant;
    //global timeout rule
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);
    
    // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
        //System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        //System.out.println("@AfterClass - runOnceAfterClass");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
    	restaurant = new Restaurant(LocalTime.of(8, 0), LocalTime.of(21, 0));
    	//5 tables, {0, 3},{1, 4},{2, 5},{3, 6},{4, 7}
    	for (int i=0; i<5; ++i) {
    		Table t = new Table();
    		t.tableNumber=i;
    		t.maxPartySize=i+3; 
    		restaurant.tables.add(t);
    	}
    	//20 durations
    	for (int i=0; i<20; ++i) {
    		restaurant.reservationDurationsPerPartySize.put(i, Duration.ofMinutes(i*10));
    	}
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
        //System.out.println("@After - runAfterTestMethod");
    }

    @Test
    public void test_openclosetime() {
        Table table = restaurant.bookReservation(restaurant.buildReservation("1", 3, LocalTime.of(7, 59)));
        assertThat(table, nullValue());
        table = restaurant.bookReservation(restaurant.buildReservation("2", 3, LocalTime.of(21, 1)));
        assertThat(table, nullValue());
        table = restaurant.bookReservation(restaurant.buildReservation("3", 3, LocalTime.of(8, 1)));
        assertThat(table, notNullValue());
        assertThat(table.tableNumber, is(0));
    }
    
    @Test
    public void test_partysize() {
    	Table table = restaurant.bookReservation(restaurant.buildReservation("1", 2, LocalTime.of(8, 59)));
        assertThat(table, notNullValue());
        assertThat(table.tableNumber, is(0));
        table = restaurant.bookReservation(restaurant.buildReservation("2", 5, LocalTime.of(12, 0)));
        assertThat(table, notNullValue());
        assertThat(table.tableNumber, is(2));
        table = restaurant.bookReservation(restaurant.buildReservation("3", 100, LocalTime.of(8, 0)));
        assertThat(table, nullValue());
    }
    
    @Test
    public void test_noconflict() {
    	Table table = restaurant.bookReservation(restaurant.buildReservation("1", 2, LocalTime.of(8, 59)));
        assertThat(table, notNullValue());
        assertThat(table.tableNumber, is(0));
        table = restaurant.bookReservation(restaurant.buildReservation("2", 2, LocalTime.of(8, 3)));
        assertThat(table, notNullValue());
        assertThat(table.tableNumber, is(0));
        table = restaurant.bookReservation(restaurant.buildReservation("3", 2, LocalTime.of(8, 1)));
        assertThat(table, notNullValue());
        assertThat(table.tableNumber, is(1));
        table = restaurant.bookReservation(restaurant.buildReservation("4", 2, LocalTime.of(8, 4)));
        assertThat(table, notNullValue());
        assertThat(table.tableNumber, is(2));
        table = restaurant.bookReservation(restaurant.buildReservation("5", 2, LocalTime.of(8, 20)));
        assertThat(table, notNullValue());
        assertThat(table.tableNumber, is(3));
    }
    
    @Test
    public void test_conflict() {
    	for (int i=0; i<5; ++i) {
	    	Table table = restaurant.bookReservation(restaurant.buildReservation("1", 2, LocalTime.of(8, 59)));
	        assertThat(table, notNullValue());
	        assertThat(table.tableNumber, is(i));
    	}
    	Table table = restaurant.bookReservation(restaurant.buildReservation("1", 4, LocalTime.of(9, 3)));
        assertThat(table, nullValue());
        
        table = restaurant.bookReservation(restaurant.buildReservation("1", 7, LocalTime.of(9, 30)));
        assertThat(table, notNullValue());
        assertThat(table.tableNumber, is(4));
    }
}
