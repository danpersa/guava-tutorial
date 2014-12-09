package com.guava.tutorial.collection;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import com.guava.tutorial.NullSafePoint;
import com.guava.tutorial.Point;

/**
 * @author  dpersa
 */
public class TableTest {

    @Test
    public void tableTest() {
        final Point p1 = NullSafePoint.from(0, 1);
        final Point p2 = NullSafePoint.from(3, 4);
        final Point p3 = NullSafePoint.from(2, 3);

        final Table<Point, Point, Double> weightedGraph = HashBasedTable.create();
        weightedGraph.put(p1, p2, 4.0);
        weightedGraph.put(p1, p3, 20.0);
        weightedGraph.put(p2, p3, 5.0);

        weightedGraph.row(p1);    // returns a Map mapping p2 to 4, p3 to 20
        weightedGraph.column(p3); // returns a Map mapping p1 to 20, p2 to 5
    }
}
