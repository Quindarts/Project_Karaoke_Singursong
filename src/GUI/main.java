package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import ConnectDB.ConnectDB;
import Entity.Phong;
import Entity.TrangThaiPhong;
import OtherFunction.HelpXLSX;

public class main extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private JFrame_DangNhap app;

			public void run() {
				try {
					
					//Connect Database
					try {
						ConnectDB.getInstance().connect();
						System.out.println("Connected!!!!");
					}catch (SQLException e) {
						e.printStackTrace();
					}
					
					// Setup my app
					FlatLightLaf.setup();
					app = new JFrame_DangNhap();
					app.setVisible(true);

					// DEMO component
					Components component_app = new Components();
					component_app.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
