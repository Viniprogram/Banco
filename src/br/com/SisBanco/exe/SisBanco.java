/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.exe;

import br.com.SisBanco.view.JFPrincipal;
import javax.swing.UIManager;

/**
 *
 * @author Vinicius
 */
public class SisBanco {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }    
        new JFPrincipal().setVisible(true);
    }
    
}
