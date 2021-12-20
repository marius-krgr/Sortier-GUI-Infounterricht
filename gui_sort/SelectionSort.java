package gui_sort;

import javax.swing.*;
import java.util.Arrays;

public class SelectionSort {
    private final int[] a;
    private final JTextArea ausgabe;
    private int durchlaufe;

    public SelectionSort(int[] a, JTextArea ausgabe, int durchlaufe) {
        this.a = Arrays.copyOf(a, a.length);
        this.ausgabe = ausgabe;
        this.durchlaufe = durchlaufe;
    }
    public int selectionSort() {
        ausgabe.append("SelectionSort gestartet\n\n");
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
                Utils.ausgabeGUI(this.a, this.ausgabe);
                this.durchlaufe ++;
            }
            Utils.swap(a, i, min);
        }
        ausgabe.append("\nSelectionSort beendet");
        return this.durchlaufe;
    }
}
