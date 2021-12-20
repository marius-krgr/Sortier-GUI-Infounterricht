package gui_sort;

import javax.swing.*;
import java.util.Arrays;

public class Utils {

    public static int[] erstelleArray(int length) {
        int[] x = new int[length];
        int max = Integer.MAX_VALUE;
        //int min = Integer.MIN_VALUE;
        
        if (length < max / 10) {
                max = length * 10;
        }
        
        for (int i = 0; i < length; i++) {
            
            x[i] = (int) (Math.random() * max);
        }

        return x;
    }

    public static int[] erstelleArraySingular(int length) {
        // tertiären operator
        // <ausdruck> ? <true-wert> : <false-wert>
        int maxValue = (length < Integer.MAX_VALUE / 10) ? length * 10 : Integer.MAX_VALUE;

        return erstelleArraySingular2(length, maxValue);
    }

    public static int[] erstelleArraySingular2(int length, int maxValue) {
        int[] a = new int[length];

        if (maxValue < length) {
            // System.err.println("Nö, die maximale Länge ist zu klein für das Array.");
            // System.exit(1);
            throw new IllegalArgumentException("Invalid Parameter: maxValue must be greater than or equal to " +
            "length");
        }

        var verwendet = new boolean[maxValue];
        Arrays.fill(verwendet, false);

        for (int i = 0; i < a.length; i++) {
            int x;
            do {
                x = (int) (Math.random() * maxValue);
            } while (verwendet[x]);

            a[i] = x;
            verwendet[x] = true;
        }
        
        return a;
    }

    public static int[] mischen(int a[]) {
        //HA: Mischen!: x und y als random Zahl im Array, dann die beiden vertauschen... Das so lange wie array.lenght / 2!
        for (int i = 0; i < a.length; i++) {
            int x = (int) (Math.random() * a.length);
            int y = (int) (Math.random() * a.length);
            if (x == y) {
                i--;
            } else {
                int temp = a[x];
                a[x] = a[y];
                a[y] = temp;
            }
        }
        return a;
    }

    public static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void ausgabeArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println("");
    }
    public static void ausgabeGUI(int[] a, JTextArea ausgabe) {
        if (ausgabe != null) {
            ausgabe.append(Arrays.toString(a) + "\n");
        } else {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void checkSort(int[] a, int[] correct) {

        if (Arrays.equals(a, correct)) {
            System.out.println("Test erfolgreich.");
        } else {
            System.err.println("Sort fehlgeschlagen:");
            System.err.println("expected:  " + Arrays.toString(correct));
            System.err.println("result:    " + Arrays.toString(a));
        }
    }

    public static int[] makeArray(String text) {
        String[] temp;
        try {
            temp = text.split(",");
            int[] out = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                out[i] = Integer.parseInt(temp[i]);
            }
            return out;
        } catch (Exception e){
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,"Das war keine gültige Eingabe! Die Eingabe darf nur Zahlen enthalten, die mit einem Komma getrennt werden!");
        }
        return null;
    }
}