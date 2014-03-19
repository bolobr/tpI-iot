import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class TPGui  {
	public static AlienModule aModule;
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
    	//
    	aModule = new AlienModule();
        //Create and set up the window.
        JFrame frame = new JFrame("TP-IOT");
        JPanel controlPanel = new JPanel();
        JButton syncButton = new JButton("Sincrono");
        JButton successRateTest = new JButton("Teste Taxa de Sucesso");
        JButton readRateTest = new JButton("Teste Leituras por Segundo");
        JButton generateSummary = new JButton("Gerar Relatorio");
        
        syncButton.setMnemonic(KeyEvent.KEY_PRESSED);
        syncButton.setActionCommand("pulse");
        syncButton.addActionListener(new buttonAction(aModule));
        JTextField distance = new JTextField("Distancia");
        JTextField degree = new JTextField("Graus");
        
        controlPanel.add(distance);
        controlPanel.add(degree);
        
        successRateTest.setMnemonic(KeyEvent.KEY_PRESSED);
        successRateTest.setActionCommand("SRtest");
        
        readRateTest.setMnemonic(KeyEvent.KEY_PRESSED);
        readRateTest.setActionCommand("RRtest");
        
        generateSummary.setMnemonic(KeyEvent.KEY_PRESSED);
        generateSummary.setActionCommand("summary");
        
        syncButton.addActionListener(new buttonAction(aModule));
        successRateTest.addActionListener(new buttonAction(aModule, degree, distance));
        readRateTest.addActionListener(new buttonAction(aModule, degree, distance));
        generateSummary.addActionListener(new buttonAction(aModule));
        
        JToggleButton asyncButton = new JToggleButton("Asincrono");
        asyncButton.addItemListener(new ItemListener() {
        	   public void itemStateChanged(ItemEvent ev) {
        	      if(ev.getStateChange()==ItemEvent.SELECTED){
        	    	aModule.AlienAutonomous();
        	      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
        	    	aModule.AlienOff();
        	      }
        	   }
        	});
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanel.setLayout(new FlowLayout());

        //Add the ubiquitous "Hello World" label.

        controlPanel.add(syncButton);
        controlPanel.add(asyncButton);
        controlPanel.add(successRateTest);
        controlPanel.add(readRateTest);
        controlPanel.add(generateSummary);
        frame.getContentPane().add(controlPanel);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
    
    public void actionPerformed(ActionEvent e){
        if ("pulse".equals(e.getActionCommand())) {
        	new AlienModule();
        } else {
        	System.out.println("Problem, press again");
        }
    }
}

