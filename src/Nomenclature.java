import java.util.Scanner;
public class Nomenclature {

    // заводим справочники исходных данных метизов
    static String[] nomRef =  {"гвозди","шурупы","болты","гайки","гвозди","шурупы","болты","гайки"}; // массивы наименований, коэффициентов и ед. измерения
    static float[] koefRef = {100, 150, 120, 400, 0.01f, 0.015f, 0.012f, 0.04f}; // как сделать одним массивов данные разных типов пока не проходили, поэтому пока сделал тремя массивами. связь через индексы

    static String[] measureRef = {"шт","шт","шт","шт","кг","кг","кг","кг"}; //    массив единиц измерения

    public static void main(String[] args){
       Scanner inputData = new Scanner(System.in);
       System.out.println(" Введите номенклатуру для конвертации в формате:");
       System.out.println("Номенклатура колическто ед.измерения");
       String nomenclature=inputData.nextLine();  // получаем строку из консоли от юзера
        nomenclature=nomenclature.trim(); // отрежем пробелы на концах, страховка
        String[] nomArray=nomenclature.split(" "); // разобьем название колич и ед. изм. на массив из 3х элементов
        String Measure=getMeasure(nomArray);
        System.out.println(Measure);


    }
    // ищем по данным разложенной строки в справочнике
    private static String getMeasure(String[] ReceivedData){
        String currentNom=ReceivedData[0];
        float currentQuantity=Float.parseFloat(ReceivedData[1]);
        String currentMeasure=ReceivedData[2];
        int myIndex=-1;
        boolean nomFounded=false;
        for (int i=0;i< nomRef.length; i++)
        {
            if (nomRef[i].equalsIgnoreCase(currentNom))
            {
                nomFounded=true;
                if (measureRef[i].equalsIgnoreCase(currentMeasure))
                {
                    myIndex = i;
                    break;
                }

            }
        }
        if (myIndex==-1 && nomFounded)
            {
                return "нет такого конвертора, допускаются кг и шт";
            }
        else if(myIndex==-1 && !nomFounded)
            {
                return "не найдена номенклатура";
            }
        //float foundKoef=Float.parseFloat(koefRef[myIndex]);
        float foundKoef=koefRef[myIndex];
        String newNom=nomRef[myIndex];
        float newQuantity=currentQuantity/foundKoef;
        String newMeasure="";
        System.out.println("тек. единица "+currentMeasure+" длина "+currentMeasure.length());
        if (currentMeasure.equalsIgnoreCase("шт"))
            {
            newMeasure= "кг";
            }
        else
            {
            newMeasure= "шт";
            }

        return "Конвертировано: "+newNom+" "+currentQuantity+" "+currentMeasure+" = "+newQuantity+" "+newMeasure;
    }
}
