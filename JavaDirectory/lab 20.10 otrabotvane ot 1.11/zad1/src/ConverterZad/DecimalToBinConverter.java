package ConverterZad;

public class DecimalToBinConverter implements Converter {
    @Override
    public String convert(int number){
        int either = 0;
        String result = "";

        while(number>0){
            either = number%2;
            result = either + result;
            number /=2;
        }


        return (result);
    }

}
