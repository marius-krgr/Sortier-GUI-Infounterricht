package gui_sort;

import javax.swing.*;
import java.util.Arrays;

public class InsertionSort {
    private final int[] a;
    private final JTextArea ausgabe;
    private int durchlaufe;

    public InsertionSort(int[] a, JTextArea ausgabe, int durchlaufe) {
        this.a = Arrays.copyOf(a, a.length);
        this.ausgabe = ausgabe;
        this.durchlaufe = durchlaufe;
    }
    public int insertionSort() {
        ausgabe.append("InsertionSort gestartet\n\n");
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while ((j > -1) && (a[j] > key)) {
                a[j + 1] = a[j];
                j--;
                Utils.ausgabeGUI(a, ausgabe);
                this.durchlaufe ++;
            }
            a[j + 1] = key;
        }
        ausgabe.append("\nInsertionSort beendet");
        return this.durchlaufe;
    }

}
