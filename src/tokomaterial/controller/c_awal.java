/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_user;
import view.homeAwal;
import view.login;

/**
 *
 * @author Vin
 */
public class c_awal {

    homeAwal theView;

    public c_awal(homeAwal theView) {
        this.theView = theView;
        theView.setVisible(true);
        this.theView.klikLogin(new v_login());
        this.theView.klikAbout(new v_about());
    }

    private class v_login implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.dispose();
            try {
                c_user con = new c_user(new login(), new m_user());
                theView.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(c_awal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private class hitungLuas implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            //rumus jumlah bibit internasional
            //luas*(10000/2*10000/20)*(100*100)*(jml bibit/lubang)*(berat benih/1000 benih)
//           bibit = ((getluas() * ((10000 / 20) * (10000 / 20))) * (100 / 90) * 3 * (130 / 1000))
//           hit pupuk = luas x (30kg/36)x100
//           pupuk = ((getluas()*(30/36))*100)
            String regex = "[0-9]*\\.?[0-9]*";//untuk menggunakan parameternya
            if (view.getLuas().getText().matches(regex)) {
                bibit = ((Double.valueOf(view.getLuas().getText()) * (Math.pow(500, 2) * 0.9 * 0.39)));
                view.getBibit().setText(Double.toString(bibit / 1000));
                pupuk = ((Double.valueOf(view.getLuas().getText()) * (0.83) * 100));
                view.getPupuk().setText(Double.toString(pupuk));
            } else {
                view.getLuas().setText("");
                JOptionPane.showMessageDialog(view, "Silahkan Masukkan Angka dengan BENAR!1!!1");
            }

        }
    }

    private class v_about implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(theView, "Project dari mata kuliah PPL Agro yang mengharuskan mahasiswa untuk membuat suatu program\n"
                    + "yang di dalamnya mencakup materi agroindustri yang mana sistem ini membantu agroindustri,\nsehingga membantu untuk memperoleh hasil agroindustri yang terbaik.\n"
                    + "Kelompok Kami antara lain : \n" + "1. Ayu Sisca Irianti      152410101053\n" + "2. Siti Vika NF      152410101072\n"
                    + "3. Gavin Liffera Kusuma P      152410101096\n" + "4. Aisyah Nur F      152410101097");
        }

    }

}
