package edu.javagroup.jcalc.line;

/**
 * Класс LineCheck
 * Выполняет проверку корректности математического вырожения в виде строки
 *
 * @author Ubozhanka
 */
public class LineCheck {

    /**
     * @param line входная строка
     * @return результат проверки методов isRoundBracketsCorrect и isMathSymbolsCorrect
     */
    public static boolean isLineCorrect(String line) {

        return isRoundBracketsCorrect(line) && isMathSymbolsCorrect(line);
    }

    /**
     * Проверяет корректность круглых скобок в строке.
     *
     * @param line входная строка
     * @return результат метода isRoundBracketsCountCorrect, если строка содержит скобки, иначе true
     */
    public static boolean isRoundBracketsCorrect(String line) {
        if (line.contains("(") || line.contains(")")) {
            return isRoundBracketsCountCorrect(line);
        } else
            return true;
    }

    /**
     * Проверяет равенство количества открывающих и закрывающих скобок.
     *
     * @param line входная строка
     * @return результат метода isRoundBracketsPositionCorrect, если количество скобок равно, иначе false
     */
    public static boolean isRoundBracketsCountCorrect(String line) {
        char[] array = line.toCharArray();
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                count++;
            } else if (array[i] == ')') {
                count--;
            }
        }

        return count == 0 ? isRoundBracketsPositionCorrect(line) : false;
    }

    /**
     * Проверяет корректность расположения скобок.
     *
     * @param line входная строка
     * @return false, если закрывающая скобка встречается раньше открывающей
     * или если нарушен порядок скобок, иначе true
     */
    public static boolean isRoundBracketsPositionCorrect(String line) {
        char[] array = line.toCharArray();
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                count++;
            } else if (array[i] == ')') {
                count--;
            }
            if (count < 0) return false;
        }

        return count == 0;
    }

    /**
     * Проверяет корректность расположения математических символов.
     *
     * @param line входная строка
     * @return true, если строка не начинается с *, /, + и не заканчивается на *, /, +, -
     */
    public static boolean isMathSymbolsCorrect(String line) {

        return !line.startsWith("*") && !line.startsWith("/") && !line.startsWith("+") && !line.endsWith("*") && !line.endsWith("/") && !line.endsWith("+") && !line.endsWith("-");
    }

    /**
     * Проверяет, начинается ли строка с указанного символа.
     * Возвращает инвертированный результат проверки.
     *
     * @param line1
     * @param line2
     * @return true, если строка НЕ начинается с символа
     */
    public static boolean isFirstMathSymbol(String line1, String line2) {

        return !line1.startsWith(line2);
    }

    /**
     * Проверяет, заканчивается ли строка указанным символом.
     * Возвращает инвертированный результат проверки.
     *
     * @param line1
     * @param line2
     * @return true, если строка НЕ заканчивается символом
     */
    public static boolean isLastMathSymbol(String line1, String line2) {

        return !line1.endsWith(line2);
    }
}



