/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SisBanco.accessories;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author vinic
 */
public class DesktopImagem extends JDesktopPane{
    private ImageIcon iiImagem;
    
    public DesktopImagem (String imagem){
        iiImagem = new ImageIcon(getClass().getResource(imagem));        
    }
    
    public void paintComponente(Graphics g){
        super.paintComponent(g);
        iiImagem.paintIcon(this, g, 0, 0);
    }
    
    public Dimension getPreferredSize(){
        return new Dimension(iiImagem.getIconWidth(), iiImagem.getIconHeight());
    }
}
