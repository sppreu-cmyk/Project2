package edu.javagroup.jcalc.line;

import edu.javagroup.jcalc.digit.Addition;
import edu.javagroup.jcalc.digit.Division;
import edu.javagroup.jcalc.digit.Multiplication;
import edu.javagroup.jcalc.digit.Subtraction;

/**
 * Класс LineOperation
 * Содержит методы, для проверки корректности математического выражения в виде строки
 *
 * @author Ubozhanka
 */
public class LineOperation {

    /**
     * Удаляет последний символ строки.
     * Если входная строка равна null или пустая то возвращает пустую строку
     *
     * @param line входная строка
     * @return line без последнего символа или пустая строка
     */
    public static String removeLastSymbol(String line) {
        if (line == null || line.isEmpty()) {
            return "";
        } else {
            return line = line.substring(0, line.length() - 1);
        }
    }

    /**
     * Добавляет символ '-' в начало строки.
     *
     * @param line входная строка
     * @return line с добавленным символом '-' в начале
     */
    public static String addMinusPrefix(String line) {
        StringBuilder str = new StringBuilder(line);
        str.insert(0, "-");
        return line = str.toString();
    }

    /**
     * Выполняет конкатенацию двух строк.
     *
     * @param line  первая строка
     * @param line2 вторая строка
     * @return результат конкатенации строк
     */
    public static String concatLines(String line, String line2) {
        return line + line2;
    }

    /**
     * Обрабатывает входную строку и вычисляет итоговый результат выражения.
     * Посредством методов:
     * Обрабатывает выражение с круглыми скобками или без них
     *
     * @param line математическое выражение
     * @return возвращает результа вычисления, в виде строки, при необходимости округляя этот результат.
     */
    public static String getResult(String line) {
        if (line == null || line.isEmpty()) {
            return "";
        } else {
            line = LinePreparing.linePreparing(line);
        }

        if (!LineCheck.isLineCorrect(line)) {
            return line;
        }

        if (LineParsing.isFinalDigit(line)) {
            return line;
        }

        if (line.contains("(") || line.contains(")")) {
            line = getResultWithRoundBrackets(line);
        } else {
            line = getResultWithoutRoundBrackets(line);
        }

        line = LineParsing.clearResult(line);

        if (line.contains(".")) {
            return line;
        }

        return LineParsing.clearResult(line);
    }

    /**
     * Обрабатывает математическое выражение, содержащее круглые скобки.
     * Процесс повторяется, пока в строке остаются круглые скобки.
     *
     * @param line выражение, содержащее круглые скобки
     * @return результат вычисления выражения без скобок
     */
    public static String getResultWithRoundBrackets(String line) {
        while (line.contains("(") || line.contains(")")) {

            if (LineParsing.isFinalDigit(line)) {
                return line;
            }

            int index1 = line.lastIndexOf("(");
            int index2 = line.indexOf(')', index1);

            String result = line.substring(index1 + 1, index2);
            result = LinePreparing.linePreparing(result);

            String lineNew = getResultWithoutRoundBrackets(result);
            line = collectLines(line, lineNew, index1, index2);
        }

        return getResultWithoutRoundBrackets(line);
    }

    /**
     * Выполняет вычисление математического выражения без скобок.
     * получаем первый математический оператор (+, -, *, /), с учетом унарного минуса
     * затем извлекаются числа слева и справа от него,
     * выполняется математическое вычисление
     * после чего результат подставляется обратно в строку.
     * Эти шаги повторяются до тех пор, пока не останется одно число.
     * обработать этот результат
     *
     * @param line входное выражение без скобок
     * @return результат вычислений или пустая строка при ошибке
     */

    public static String getResultWithoutRoundBrackets(String line) {
        while (line.contains("+") || line.contains("-") || line.contains("*") || line.contains("/")) {
            String symbol = LineParsing.findFirstMathSymbol(line);

            if (symbol == null || symbol.isEmpty()) {
                System.out.println("Пустая строка");
                return "";
            }

            int index = line.indexOf(symbol);

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == symbol.charAt(0)) {
                    if (c == '-' && (i == 0 || "+-*/".indexOf(line.charAt(i - 1)) >= 0))
                        continue;
                    index = i;
                    break;
                }
            }
            if (index < 0) return "";

            String right = LineParsing.getNumberFromRightPart(line, index);
            String left = LineParsing.getNumberFromLeftPart(line, index);
            String result;

            if (symbol.equals("+")) {
                result = Addition.addition(left, right);
            } else if (symbol.equals("-")) {
                result = Subtraction.subtraction(left, right);
            } else if (symbol.equals("*")) {
                result = Multiplication.multiplication(left, right);
            } else if (symbol.equals("/")) {
                result = Division.division(left, right);
            } else {
                return "";
            }

            line = collectLines(line, result, index);
            line = LinePreparing.linePreparing(line);

            if (line.contains(".") && LineParsing.isFinalDigit(line)) {
                line = LineParsing.clearResult(line);
            }

            if (LineParsing.isFinalDigit(line)) {
                break;
            }
        }

        return line;
    }

    /**
     * Выполняет операцию умножения.
     * Из строки извлекаются числа слева и справа от символа a
     * после чего возвращается результат их умножения.
     *
     * @param line строка с математическим выражением
     * @param a    координата символа
     * @return результат умножения
     */
    public static String multiplication(String line, int a) {
        String diget1 = (LineParsing.getNumberFromLeftPart(line, a));
        String diget2 = (LineParsing.getNumberFromRightPart(line, a));

        Integer a1 = Integer.parseInt(diget1);
        Integer a2 = Integer.parseInt(diget2);

        Integer result = a1 * a2;

        return result.toString();
    }

    /**
     * Выполняет операцию деления.
     * Из строки извлекаются числа слева и справа от символа a
     * после чего возвращается результат их деления.
     *
     * @param line строка с математическим выражением
     * @param a    координата символа
     * @return результат деления
     */
    public static String division(String line, int a) {
        String diget1 = LineParsing.getNumberFromLeftPart(line, a);
        String diget2 = LineParsing.getNumberFromRightPart(line, a);

        return Division.division(diget1, diget2);
    }

    /**
     * Выполняет операцию сложения.
     * Из строки извлекаются числа слева и справа от символа a
     * после чего возвращается результат их сложения.
     *
     * @param line строка с математическим выражением
     * @param a    координата символа
     * @return результат сложения
     */
    public static String addition(String line, int a) {
        String diget1 = (LineParsing.getNumberFromLeftPart(line, a));
        String diget2 = (LineParsing.getNumberFromRightPart(line, a));

        Integer a1 = Integer.parseInt(diget1);
        Integer a2 = Integer.parseInt(diget2);

        Integer result = a1 + a2;

        return result.toString();
    }

    /**
     * Выполняет операцию вычитания.
     * Из строки извлекаются числа слева и справа от симвла a
     * после чего возвращается результат их вычитания.
     *
     * @param line строка с математическим выражением
     * @param a    координата символа
     * @return результат вычитания
     */
    public static String subtraction(String line, int a) {
        String diget1 = (LineParsing.getNumberFromLeftPart(line, a));
        String diget2 = (LineParsing.getNumberFromRightPart(line, a));

        Integer a1 = Integer.parseInt(diget1);
        Integer a2 = Integer.parseInt(diget2);

        Integer result = a1 - a2;

        return result.toString();
    }

    /**
     * Возвращает новую строку с математическим выражением
     * находим числа слева и справа от координаты символа a,
     * затем формирует новую строку: часть до левого числа + результат + часть после правого числа.
     *
     * @param line  исходная строка с математическим выражением
     * @param line2 результат операции
     * @param a     координата символа в строке
     * @return строка с заменённым выражением
     */
    public static String collectLines(String line, String line2, int a) {
        String diget1 = (LineParsing.getNumberFromLeftPart(line, a));
        String diget2 = (LineParsing.getNumberFromRightPart(line, a));

        String part1 = line.substring(0, a - diget1.length());
        String part2 = line.substring(a + diget2.length() + 1);

        return part1 + line2 + part2;
    }

    /**
     * Возвращает новую строку с математическим выражением
     * часть до '(' + результат + часть после ')
     *
     * @param line  исходная строка
     * @param line2 результат операции
     * @param a     координата символа '('
     * @param b     координата символа ')'
     * @return новая строка
     */
    public static String collectLines(String line, String line2, int a, int b) {
        String part1 = line.substring(0, a);
        String part2 = line.substring(b + 1);

        StringBuilder result = new StringBuilder();
        result.append(part1).append(line2).append(part2);
        return result.toString();

    }
}

