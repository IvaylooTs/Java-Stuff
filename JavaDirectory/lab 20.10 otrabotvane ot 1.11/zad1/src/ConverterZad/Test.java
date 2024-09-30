package ConverterZad;

public class Test {
    public static void main(String[] args){
        DecimalToBinConverter BinTest = new DecimalToBinConverter();
        DecimalToHexConverter HexTest = new DecimalToHexConverter();

        Converter[] AllConverters = {BinTest, HexTest};

        for(int i=0;i< AllConverters.length; i++){
            System.out.println(AllConverters[i].convert(171));
        }

    }
}
