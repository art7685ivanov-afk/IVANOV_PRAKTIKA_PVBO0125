public class Wrapper_Double {
    public static void main(String[] args) {
        // 1. Создание объектов Double через valueOf()
        Double d1 = Double.valueOf(3.14);
        Double d2 = Double.valueOf("2.718");
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);

        // 2. String → double
        String s = "123.456";
        double parsed = Double.parseDouble(s);
        System.out.println("parseDouble(\"" + s + "\") = " + parsed);

        // 3. Преобразование Double ко всем примитивным типам
        Double obj = 65.9; // автоупаковка
        byte b   = obj.byteValue();     // 65
        short sh = obj.shortValue();    // 65
        int i    = obj.intValue();      // 65
        long l   = obj.longValue();     // 65
        float f  = obj.floatValue();    // 65.9f
        double d = obj.doubleValue();   // 65.9

        System.out.println("byteValue   = " + b);
        System.out.println("shortValue  = " + sh);
        System.out.println("intValue    = " + i);
        System.out.println("longValue   = " + l);
        System.out.println("floatValue  = " + f);
        System.out.println("doubleValue = " + d);

        // 4. Вывод значения объекта Double
        System.out.println("Значение объекта Double: " + obj);

        // 5. double → String
        String dStr = Double.toString(3.14);
        System.out.println("Double.toString(3.14) = " + dStr);
    }
}