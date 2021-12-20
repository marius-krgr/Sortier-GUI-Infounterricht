package sortier_gui;

import gui_sort.BubbleSort;
import gui_sort.InsertionSort;
import gui_sort.SelectionSort;
import gui_sort.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class sortier_gui extends JFrame {
    private JPanel pMain;
    private JTextArea taSelectionSort;
    private JTextArea taBubbleSort;
    private JTextArea taInsertionSort;
    private JLabel BubbleSort;
    private JLabel SelectionSort;
    private JLabel InsertionSort;
    private JPanel pBubble;
    private JPanel pSelection;
    private JPanel pInsertion;
    private JPanel pHeader;
    private JLabel lWelcome;
    private JLabel lInfo;
    private JPanel pChoose;
    private JLabel lCoose1;
    private JLabel lChoose2;
    private JFormattedTextField taEigeneZahlen;
    private JLabel lChoose3;
    private JSpinner sGroesseArray;
    private JButton bStartNormal;
    private JPanel pNormal;
    private JPanel pAdvanced;
    private JPanel pExtreme;
    private JButton bStartAdvanced;
    private JButton bStartExtreme;
    private JLabel lBubbleInfo;
    private JLabel lSelectionInfo;
    private JLabel lInsertionInfo;

    private int[] array;
    private final int[] durchlaufe = new int[3];

    public sortier_gui() {
        super();
        setTitle("Marius' SSG (Super Sortier GUI)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pMain);
        setSize(1800, 820);
        setVisible(true);

        start();
    }

    private void start() {

        //Normal run
        bStartNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                array = new int[] {34,812,62,3,9,0,163,92,93,40,1};
                reset();
                startSort("BubbleSort");
                startSort("SelectionSort");
                startSort("InsertionSort");
                setColor();
            }
        });
        //Advanced run
        bStartAdvanced.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = taEigeneZahlen.getText();
                array = Utils.makeArray(text);
                reset();
                startSort("BubbleSort");
                startSort("SelectionSort");
                startSort("InsertionSort");
                setColor();
            }
        });
        //Advanced run
        bStartExtreme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lange = (Integer) sGroesseArray.getValue();
                array = Utils.erstelleArraySingular(lange);
                reset();
                startSort("BubbleSort");
                startSort("SelectionSort");
                startSort("InsertionSort");
                setColor();
            }
        });
    }

    private void startSort(String name) {
        if(Objects.equals(name, "BubbleSort")){
            BubbleSort bs = new BubbleSort(array, taBubbleSort, durchlaufe[0]);
            durchlaufe[0] = bs.bubbleSort();
            setDurchlaufe(0);
        } else if(Objects.equals(name, "SelectionSort")){
            SelectionSort ss = new SelectionSort(array, taSelectionSort, durchlaufe[1]);
            durchlaufe[1] = ss.selectionSort();
            setDurchlaufe(1);
        } else if(Objects.equals(name, "InsertionSort")){
            InsertionSort is = new InsertionSort(array, taInsertionSort, durchlaufe[2]);
            durchlaufe[2] = is.insertionSort();
            setDurchlaufe(2);
        }

    }
    private void setDurchlaufe(int i) {
        if (i == 0){
            lBubbleInfo.setText("Durchläufe: " + durchlaufe[0]);
        } else if (i == 1){
            lSelectionInfo.setText("Durchläufe: " + durchlaufe[1]);
        } else {
            lInsertionInfo.setText("Durchläufe: " + durchlaufe[2]);
        }
    }
    private void setColor() {
        if (durchlaufe[0] < durchlaufe[1] && durchlaufe[0] < durchlaufe[2]){
            //BubbleSort hat gewonnen!
            pBubble.setBackground(Color.green);
        } else if (durchlaufe[1] < durchlaufe[2] && durchlaufe[1] < durchlaufe[0]){
            //SelectionSort hat gewonnen!
            pSelection.setBackground(Color.green);
        } else if (durchlaufe[2] < durchlaufe[1] && durchlaufe[2] < durchlaufe[0]){
            //Insertion Sort hat gewonnen!
            pInsertion.setBackground(Color.green);
        } else if (durchlaufe[0] == durchlaufe[1] && durchlaufe[1] < durchlaufe[2]){
            pBubble.setBackground(Color.green);
            pSelection.setBackground(Color.green);
        } else if (durchlaufe[1] == durchlaufe[2] && durchlaufe[1] < durchlaufe[0]){
            pSelection.setBackground(Color.green);
            pInsertion.setBackground(Color.green);
        } else {
            pBubble.setBackground(Color.green);
            pInsertion.setBackground(Color.green);
        }
    }

    public void reset(){
        pBubble.setBackground(Color.getHSBColor(0,0,93));
        pSelection.setBackground(Color.getHSBColor(204,7,25));
        pInsertion.setBackground(Color.getHSBColor(204,7,25));
        taBubbleSort.setText("");
        taInsertionSort.setText("");
        taSelectionSort.setText("");
        durchlaufe[0] = 0;
        durchlaufe[1] = 0;
        durchlaufe[2] = 0;
    }



    public static void main(String[] args) {
        new sortier_gui();
    }
}