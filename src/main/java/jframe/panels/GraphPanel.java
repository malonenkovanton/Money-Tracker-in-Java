package jframe.panels;

import controller.RegisterController;
import jframe.ChartPanel;
import person.Person;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class GraphPanel extends JPanel {
    private JButton graph;
    private RegisterController controller;
    private JFrame f;
    private DecimalFormat df = new DecimalFormat("0.00");

    public GraphPanel(RegisterController controller, JFrame frame)
    {
        this.graph = new JButton("Create Graph");
        f = new JFrame();
        f.setSize(800,300);
        graph.setBackground(Color.RED);
        graph.setFont(new Font("Dialog", Font.PLAIN, 32));
        graph.revalidate();
        this.controller = controller;

        graph.addActionListener(evt->
            init()
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(graph);
    }
    public void changeColor()
    {
        graph.setBackground(Color.GREEN);
    }
    public void init()
    {

        double[] values = new double[(controller.getPeopleDB().getList().size())+(controller.getPeopleDB().getDeletedPeople().size())];
        String[] names = new String[values.length];
        int i=0;
        for(Person person: controller.getPeopleDB().getList())
        {
            values[i] = person.getTotalDebt();
            names[i] = person.getName()+": "+df.format(person.getTotalDebt())+"eur";
            i++;
        }
        for(Person person: controller.getPeopleDB().getDeletedPeople())
        {
            values[i] = person.getTotalDebt();
            names[i] = person.getName()+": "+df.format(person.getTotalDebt())+"eur";
            i++;
        }
        f.getContentPane().add(new ChartPanel(values,names,"Total Debt Graph"));
        f.setVisible(true);
    }
}
