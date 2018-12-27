package com.shilko.ru.labrungedifferentiation;

import com.shilko.ru.labmilndifferentiation.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class RungeDifferentiation {

    public static List<Point> calculate(BiFunction func, double x0, double y0, double dx, int count) {
        List<Point> points = new ArrayList<>();
        if (count <= 0)
            return points;
        points.add(new Point(x0, y0));
        if (count == 1)
            return points;
        double x = x0;
        for (int i = 0; i < count - 1; ++i) {
            x += dx;
            double k0 = (double) func.apply(points.get(i).getX(), points.get(i).getY());
            double k1 = (double) func.apply(points.get(i).getX() + dx / 2, points.get(i).getY() + dx * k0 / 2);
            double k2 = (double) func.apply(points.get(i).getX() + dx / 2, points.get(i).getY() + dx * k1 / 2);
            double k3 = (double) func.apply(points.get(i).getX() + dx, points.get(i).getY() + dx * k2);
            double y = points.get(i).getY() + dx / 6 * (k0 + 2 * k1 + 2 * k2 + k3);
            points.add(new Point(x, y));
        }
        return points;
    }

}
