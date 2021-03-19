package stringcalculator;

public class StringCalculator {


    public int add(String input) {
        String[] array = input.split(",|:|-|;|\n");
        int sum = 0;

        for(String s : array) {
            if(s.isEmpty())
                return 0;
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
        return sum;
    }
}
