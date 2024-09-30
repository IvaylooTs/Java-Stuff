package ConverterZad;

public class DecimalToHexConverter implements Converter{
        @Override
        public String convert(int number){
            int either;
            String result = "";

            while(number>0){
                either = number%16;
                if(either <=9){
                    result = either + result;
                }
                else {
                    switch (either){
                        case 10:
                            result = "A" + result;
                            break;
                        case 11:
                            result = "B" + result;
                            break;
                        case 12:
                            result = "C" + result;
                            break;
                        case 13:
                            result = "D" + result;
                            break;
                        case 14:
                            result = "E" + result;
                            break;
                        case 15:
                            result = "F" + result;
                            break;
                    }
                }
                number /=16;
            }


            return (result);
        }

    }