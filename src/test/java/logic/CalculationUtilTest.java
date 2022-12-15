package logic;

import javafx.scene.shape.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationUtilTest {

    @Test
    void calcAng_90_1() {

        Line line1 = new Line(100, 0, 0, 0);    // horizontal right to left
        Line line2 = new Line(0, 0, 0, 100);    // vertical top to bottom

        assertEquals(90, CalculationUtil.calculateAngel(line1, line2));
    }

    @Test
    void calcAng_90_2() {
        // same test but Lin1
        Line line1 = new Line(0, 0, 100, 0);    // horizontal left to right
        Line line2 = new Line(0, 0, 0, 100);    // vertical top to bottom

        assertEquals(90, CalculationUtil.calculateAngel(line1, line2));
    }

    @Test
    void calcAng_45_1() {
        Line line1 = new Line(0, 0, 100, 0);
        Line line2 = new Line(0, 0, 100, 100);

        assertEquals(45, CalculationUtil.calculateAngel(line1, line2));
    }

    @Test
    void calcAng_45_2() {
        // similar test, it WILL fail if you comment out the long if, if, if, if block in calculateAngle Class (search for KAPUTT)
        Line line1 = new Line(0, 0, 100, 0);
        Line line2 = new Line(100, 100, 0, 0);

        assertEquals(45, CalculationUtil.calculateAngel(line1, line2));
    }

    @Test
    void calculateLineLength_1() {
        Line line1 = new Line(0, 0, 100, 0);
        assertEquals(100, CalculationUtil.calculateLineLength(line1));
    }
    @Test
    void calculateLineLength_2() {
        Line line2 = new Line(100, 100, 0, 0);
        assertEquals(141.4213562373095, CalculationUtil.calculateLineLength(line2));
    }
}