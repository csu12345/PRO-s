/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.StringWriter;
import java.io.IOException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
/**
 *
 * @author Owner
 */
public class StudentAdd extends JFrame implements ActionListener
{
     JLabel l1, l2, l3, l4;
     JTextField tf1, tf2, tf3;
     JButton btn1;
     
     StudentAdd()
     {
        setVisible(true);
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Registration");
 
        l1 = new JLabel("Student Registration:");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        
        l2 = new JLabel("Student Id:");
        l3 = new JLabel("First Name:");
        l4 = new JLabel("Last Name:");
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        
         btn1 = new JButton("Submit");
         
         btn1.addActionListener(this);
         
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        tf3.setBounds(300, 150, 200, 30);
        btn1.setBounds(50, 200, 100, 30);
        
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(tf3);
        add(btn1);
     }
     
    @Override
    public void actionPerformed(ActionEvent e)
    {
         if (e.getSource() == btn1)
         {
             String id = tf1.getText();
             String fname = tf2.getText();
             String lname = tf3.getText();
             
             try 
             {
               SAXBuilder builder = new SAXBuilder();
               File xmlFile = new File("C:\\Users\\Owner\\Desktop\\ITC515_assignment2\\DataManagementDemo_DB.xml");
               //String temp = "1234567";
               
               Document doc = (Document) builder.build(xmlFile);
               Element rootNode = doc.getRootElement();
               
               Element studentTable = rootNode.getChild("studentTable");
               Element student = studentTable.getChild("student");
               
               student.getAttribute("sid").setValue(id);
               student.getAttribute("fname").setValue(fname);
               student.getAttribute("lname").setValue(lname);
               
                XMLOutputter xmlOutput = new XMLOutputter();
                xmlOutput.setFormat(Format.getPrettyFormat());
                StringWriter out = new StringWriter();
                xmlOutput.output(doc, out);
                //FileUtils.writeStringToFile(new File("C:\\Users\\Owner\\Desktop\\ITC515_assignment2\\updated.txt"), out.toString(), true);
             }
                catch (IOException io) 
                {
                    io.printStackTrace();
                } 
                catch (JDOMException ex) 
                {
                    ex.printStackTrace();
                }
             
          }
             
             
             
         }
        public static void main(String[] p)
        {
            new StudentAdd();
        }
 }
    
     
     
