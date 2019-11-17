package xyChart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Axes extends JPanel {
    int a;
    int b;
    LineDraw mainLine;
    LineDraw lineX = new LineDraw(200, 400, 200, 0, Color.BLACK);
    LineDraw lineY = new LineDraw(0, 200, 400, 200, Color.BLACK);
    ArrayList<LineDraw> lines = new ArrayList<>();

    public Axes(int a, int b) {
        this.a = a;
        this.b = b;
        this.mainLine = new LineDraw(0, a, 400, b, Color.GREEN);
        lines.add(mainLine);
        lines.add(lineX);
        lines.add(lineY);
        for (int i = 10; i < 400; i += 10) {
            lines.add(new LineDraw(i, 195, i, 205, Color.BLACK));
        }
        for (int j = 10; j < 400; j += 10) {
            lines.add(new LineDraw(195, j, 205, j, Color.BLACK));
        }
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (LineDraw lineDraw : lines) {
            lineDraw.paintComponent(g);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public void setLayout(LayoutManager mgr) {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj liczbę a");
        int wspa = sc.nextInt();
        System.out.println("Podaj liczbę b");
        int wspb = sc.nextInt();
        int y1 = wspa * (-20) + wspb;
        int y2 = wspa * 20 + wspb;
        int a;
        int b;

        if (y1 < 0) {
            a = 200 + 10 * (-y1);
        } else {
            a = -10 * y1 + 200;
        }
        if (y2 < 0) {
            b = 200 + 10 * (-y2);
        } else {
            b = -10 * y2 + 200;
        }

        JFrame okno = new JFrame();
        JLabel labelX = new JLabel("Oś X");
        JLabel labelY = new JLabel("Oś Y");

        Axes panel = new Axes(a, b);
        panel.setLayout(null);
        panel.add(labelX);
        panel.add(labelY);

        Dimension size = labelX.getPreferredSize();
        labelX.setBounds(360, 210, size.width, size.height);
        labelY.setBounds(210, 0, size.width, size.height);

        okno.setResizable(false);
        okno.add(panel);
        okno.setTitle("Osie");
        okno.pack();
        okno.setLocation(0, 0);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);

    }
}
