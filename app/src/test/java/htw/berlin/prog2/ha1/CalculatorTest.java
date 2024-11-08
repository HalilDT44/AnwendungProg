package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen
    @Test
    @DisplayName("checkt, ob bei dem clear button der bildschirm und die operatoren zurückgesetzt wurden")
    public void testPressClearKey() {
        // beispieloperation, damit bildschirm einen wert hat den man zurücksetzen kann
        Calculator calc = new Calculator();
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        // Drückt die Clear-Taste und überprüfe, ob der Bildschirm auf 0 zurückgesetzt wird
        calc.pressClearKey();
        assertEquals("0", calc.readScreen());
    }

    @Test
    @DisplayName("sollte einen Fehler angeben wenn man die funktion 1/x bei 0 benutzt")
    void testDivisionByDotkey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("1/x");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("sollte fehler angeben wenn man den ln von 0 zieht")
    void testlnByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("ln"); // Hab eine ln funktion eingefügt da in der beschreibung stand, dass man den code erweitern kann

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}



