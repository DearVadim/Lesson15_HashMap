import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String , String> StringMap = new HashMap<>();
        String NewValue, OutputString = "";
        int i =0, FoundCounter=0;
        final int MAXCount = 10000;

        while (i<MAXCount){
            NewValue = StringGenerator();

            if (StringMap.containsKey(NewValue)){
                FoundCounter++;
                //если более 10 раз подряд новое значение уже есть, выход из цикла
                if(FoundCounter==100){
                    System.out.printf("Найдено 100 совпадений для значения %s, выходим из цикла\n", NewValue);
                    break;
                }
            }else{
                StringMap.put(NewValue, NewValue);
                i++;
                FoundCounter=0;
            }

        }

        System.out.printf("Создана коллекция из %d строковых значений:%n", StringMap.size());

       //System.out.println(StringMap);

        for(HashMap.Entry<String, String> item:StringMap.entrySet()){
            OutputString = OutputString + item.getValue() + " ";
            if(OutputString.length() > 100){
                System.out.println(OutputString);
                OutputString = "";
            }
        }
        System.out.println(OutputString);
    }

    // генератор случайного слова из символов шаблона SYMBOLS (каждый символ из шаблона - уникальный в слове)
    public static String StringGenerator(){
        int Size, i = 0, SYMBOLSCount, SYMBOLNumber;
        String Result = "", RemainingSYMBOLS;
        final String SYMBOLS = "бульдозер";//строка шаблона с допустимыми символами
        final int MINSize = 1;

        RemainingSYMBOLS = SYMBOLS;
        SYMBOLSCount = RemainingSYMBOLS.length();

        // длина строки - случайное число длиной не более шаблона
        Size = (int) (Math.random() * (SYMBOLSCount-MINSize) + MINSize);

        while (i<=Size){
            //позиция буквы в строке шаблона - случайное число, не использованное ранее
            SYMBOLSCount = RemainingSYMBOLS.length();
            SYMBOLNumber = (int) (Math.random() * SYMBOLSCount);
            Result = Result + RemainingSYMBOLS.charAt(SYMBOLNumber);

            RemainingSYMBOLS = RemainingSYMBOLS.substring(0,SYMBOLNumber) + RemainingSYMBOLS.substring(SYMBOLNumber+1,SYMBOLSCount);
            //System.out.println(Result + " " + RemainingSYMBOLS);

            i++;
            }

        return Result;
    }
}