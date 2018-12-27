package com.shilko.ru.labmilndifferentiation;

import com.shilko.ru.labrungedifferentiation.RungeDifferentiation;

import java.util.List;
import java.util.function.BiFunction;

public class MilnDifferentiation {

    public static List<Point> calculate(BiFunction func, double x0, double y0, double lastX, double precision) {
        double dx = precision;
        List<Point> points = RungeDifferentiation.calculate(func, x0, y0, dx, 4);
        double x = x0 + dx * 3;
        int i = 3;
        while (x < lastX) {
            ++i;
            x += dx;
            double prevY = points.get(i - 4).getY()
                    + 4 * dx / 3 * (2 * (double) func.apply(points.get(i - 3).getX(), points.get(i - 3).getY())
                    - (double) func.apply(points.get(i - 2).getX(), points.get(i - 2).getY())
                    + 2 * (double) func.apply(points.get(i - 1).getX(), points.get(i - 1).getY()));
            double y = prevY;
            do {
                prevY = y;
                y = points.get(i - 2).getY()
                        + dx / 3 * ((double) func.apply(points.get(i - 2).getX(), points.get(i - 2).getY())
                        + 4 * (double) func.apply(points.get(i - 1).getX(), points.get(i - 1).getY())
                        + (double) func.apply(x, prevY));
            } while (Math.abs(prevY - y)/29 > precision);
            points.add(new Point(x,y));
        }
        return points;
    }

}
