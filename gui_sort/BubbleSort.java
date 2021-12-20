package gui_sort;

import javax.swing.*;
import java.util.Arrays;

public class BubbleSort {
    private final int[] b;
    private final JTextArea ausgabe;
    private int durchlaufe;

    public BubbleSort(int[] a, JTextArea ausgabe, int durchlaufe) {
        b = Arrays.copyOf(a, a.length);
        this.ausgabe = ausgabe;
        this.durchlaufe = durchlaufe;
    }
    public int bubbleSort() {
        ausgabe.append("BubbleSort gestartet\n\n");
        for (int i = this.b.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (this.b[j] > this.b[j + 1]) {
                    gui_sort.Utils.swap(this.b, j, (j + 1));
                }
                Utils.ausgabeGUI(this.b, this.ausgabe);
                this.durchlaufe ++;
            }
        }
        ausgabe.append("\nBubbleSort beendet");
        return this.durchlaufe;
    }
}