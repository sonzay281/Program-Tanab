
import java.util.Scanner;

public class Tanab {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 3;
        String[] name = new String[choice];
        String[] subjects = {"Computer", "Ennglish"/*, "Nepali", "Science", "Math"*/};
        String header = String.format("%10s%10s%8s%n", "Name", "Score", "Grade");
        double[] percentages = new double[name.length + 1];
        double[] totals = new double[name.length];
        double min = percentages[0];
        double max = percentages[0];
        double[] marks = new double[subjects.length];
        char grade[] = new char[name.length];
        int maximum = name.length;
        int minimum = 1;
        System.out.println("Please enter the data");
        System.out.println("***********************************");
        for (int i = 0; i < name.length; i++) {
            System.out.print("Student's name:");
            name[i] = input.next();
            System.out.println("Marks secured in:");
            for (int j = 0; j < subjects.length; j++) {
                System.out.print("\t\t" + subjects[j] + ":");
                marks[j] = input.nextDouble();
                totals[i] += marks[j];
            }
            percentages[i] = totals[i] / subjects.length;
            if (percentages[i] > 80) {
                grade[i] = 'A';
            } else if (percentages[i] > 65) {
                grade[i] = 'B';
            } else if (percentages[i] > 40) {
                grade[i] = 'C';
            } else if (percentages[i] > 20) {
                grade[i] = 'D';
            } else {
                grade[i] = 'E';
            }

            if (percentages[i] > max) {
                max = percentages[i];
                maximum = i;
            } else if (percentages[i] < max) {
                min = percentages[i];
                minimum = i;

            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.print(header);
        for (int i = 0; i < name.length; i++) {
            if (percentages[i] < percentages[i + 1]) {
                String temp = name[i];
                name[i] = name[i + 1];
                name[i + 1] = temp;
                char temp1=grade[i];
                grade[i]=grade[i+1];
                grade[i+1]=temp1;
            }
            System.out.println("\t" + i + "\t" + name[i] + "\t" + grade[i]);
        }
        System.out.println(name[minimum] + "  obtains lowest percentages of " + min);
        System.out.println(name[maximum] + "  obtains higest percentages of " + max);

    }
}
