/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.CM.cameraMart.component;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Manula
 */
public class RoundedPanel extends JPanel {

    public RoundedPanel() {
        init();
    }

    public void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:30");
    }
}
