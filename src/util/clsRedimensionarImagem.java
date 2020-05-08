/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Raoni
 */
public class clsRedimensionarImagem {
    public ImageIcon redimensionar(JLabel jLabel, int xLargura, int yAltura){
       
        ImageIcon img = new ImageIcon (jLabel.getIcon().toString());  
        img.setImage(img.getImage().getScaledInstance(xLargura, yAltura, 100));
       
        return img;
    }
}
