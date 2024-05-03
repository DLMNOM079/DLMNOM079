import java.util.*;
import java.io.*;

public class Median {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the data file:");
        String filename = scanner.next();
        ArrayList<String> myList = new ArrayList<>();


        try {
            Scanner file = new Scanner(new File(filename));

            while (file.hasNext()) {
                String line = file.nextLine();
                myList.add(line);

            }
            double percent;
            ArrayList<Double> percents = new ArrayList<>();
            String damName = null;

            for (String data : myList) {
                String[] lines = data.split(" ");
                double fsc = Double.parseDouble(lines[0]);
                double cl = Double.parseDouble(lines[1]);
                damName = lines[2];
                percent = calculatePercentage(cl, fsc);
                percents.add(percent);

              
            }

            calculateMedian(percents);
            System.out.println("Dam levels:");
            printDams(myList);
            

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static double calculatePercentage(double a, double b) {
        return (a * 100) / b;
    }
    public static void calculateMedian(ArrayList<Double> percents) {
        Collections.sort(percents);
        double median;
        int size = percents.size();
        if (size % 2 == 0) {
            median = (percents.get(size / 2 - 1) + percents.get(size / 2)) / 2.0;
        } else {
            median = percents.get(size / 2);
        }
        System.out.println("The median level is " + String.format("%.1f", median) + " percent.");

    }

    public static void printDams(ArrayList<String> myList){
        double percent;
        ArrayList<Double> percents = new ArrayList<>();
        String damName = null;

        for (String data : myList) {
            String[] lines = data.split(" ");
            double fsc = Double.parseDouble(lines[0]);
            double cl = Double.parseDouble(lines[1]);
             damName = lines[2];
            percent = calculatePercentage(cl, fsc);
            percents.add(percent);

           System.out.println(damName + " : " + String.format("%.1f", percent));
        }

    }

}


