package oaosugar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static boolean yearCheck(String year){
        String pattern = "[^0-9]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(year);
        if (m.find()){
            return false;
        }
        else {
            int intYear = Integer.parseInt(year);
            if ((intYear>=1940)&&(intYear<=2024)) {
                return true;
            }
            else{return false;}
        }
    }

    public static boolean countOfIncidentsCheck(String countOfIncidents) {
        String pattern = "[^0-9]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(countOfIncidents);
        if (m.find()) {
            return false;
        } else {
            int intCountOfIncidents = Integer.parseInt(countOfIncidents);
            if (intCountOfIncidents>=0) {
                return true;
            }
            else{return false;}
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadanie 1.12 Milovantseva Irina RIBO-01-22 Variant 16(1)");
        System.out.println("Введите марку автомобиля: ");
        String mark = scanner.nextLine();
        boolean entryOfYear = true;
        int intYear=0;
        do {
            System.out.println("Введите год выпуска автомобиля: ");
            String year = scanner.nextLine();
            if (yearCheck(year) == true) {
                intYear = Integer.parseInt(year);
                entryOfYear = false;
            } else {
                System.out.println("Ошибка введенных данных, попробуйте снова.");
            }
        } while (entryOfYear);
        String registrNumber;
        boolean enterOfRegistr = false;
        do {
            System.out.println("Введите регистрационный номер автомобиля: ");
            registrNumber = scanner.nextLine();
            String pattern = "[A-Za-z]\\d{3}[A-Za-z]{2}";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(registrNumber);
                if (m.matches()) {
                    enterOfRegistr = true;
                } else {
                    System.out.println("Ошибка введенных данных, попробуйте снова.");
                }
            } while (enterOfRegistr == false);
        System.out.println("Введите цвет машины: ");
        String colour = scanner.nextLine();
        boolean entryOfIncidents=true;
        int intCountOfIncidents=0;
        do{
            System.out.println("Введите количество ДТП, в которых учатствовал автомобиль: ");
            String countOfIncidents = scanner.nextLine();
            if (countOfIncidentsCheck(countOfIncidents)) {
                intCountOfIncidents = Integer.parseInt(countOfIncidents);
            } else {
                System.out.println("Ошибка введенных данных, попробуйте снова.");
            }
        } while (entryOfIncidents);
        System.out.println(mark+" "+intYear+" "+registrNumber+" "+colour+" "+intCountOfIncidents);

        Car car = new Car(mark,intYear,registrNumber,colour,intCountOfIncidents);
        //File file = new File("C:\\Users\\User\\Desktop\\tet\\car.txt");
        SaverRunnable sr = new SaverRunnable(car,"C:\\car.txt");
        Thread th = new Thread(sr);
        th.start();
    }
}
