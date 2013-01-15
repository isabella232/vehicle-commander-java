package com.esri.vehiclecommander;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Displays a list of buttons in a JPanel, based on a list of equipment names.
 */
public class EquipmentListJPanel extends javax.swing.JPanel {

    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 18);

    private final List<ActionListener> listeners = new ArrayList<ActionListener>();
    private final AdvancedSymbolController mil2525CSymbolController;

    /**
     * Creates a new EquipmentListJPanel.
     * @param symbolController the application's AdvancedSymbolController.
     */
    public EquipmentListJPanel(AdvancedSymbolController symbolController) {
        this.mil2525CSymbolController = symbolController;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Adds a listener for an action on any button in this panel. The listener's actionPerformed
     * method will be called with the ActionEvent generated by the button action.
     * @param listener the listener.
     */
    public void addButtonListener(ActionListener listener) {
        listeners.add(listener);
    }

    /**
     * Sets the names of the equipment for which buttons should display.
     * @param equipmentNames the names of the equipment for which buttons should display.
     */
    public void setEquipmentNames(List<String> equipmentNames) {
        removeAll();

        for (final String name : equipmentNames) {
            JButton button = new JButton(name) {
                @Override
                public void paint(Graphics g) {
                    if (null == getIcon()) {
                        //Doing this here because it's expensive, so only
                        //do it when we actually need it.
                        setIcon(new ImageIcon(mil2525CSymbolController.getSymbolImage(name)));
                    }
                    super.paint(g);
                }
            };
            button.setFont(BUTTON_FONT);
            button.setHorizontalAlignment(SwingConstants.LEFT);
            button.setFocusable(false);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
            button.setMinimumSize(new Dimension(0, 60));
            button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    for (ActionListener listener : listeners) {
                        listener.actionPerformed(e);
                    }
                }
            });
            add(button);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
