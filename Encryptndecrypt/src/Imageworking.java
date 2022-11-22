import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLOutput;
import javax.swing.JTextField;

public class Imageworking {

    public static void operate(int key){
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        try{
            FileInputStream fis=new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;

            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;

            }
            FileOutputStream fos =new FileOutputStream(file);
            fos.write(data);
            fos.close();
            JOptionPane.showMessageDialog(null,"done");
            



        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        System.out.println("this is working");

        JFrame f =new JFrame();
        f.setTitle("Image Opertion");
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font=new Font("ROBOTO",Font.BOLD,25);

        JButton button =new JButton();
        button.setText("Open Image");
        button.setFont(font);

        JTextField textField=new JTextField(10);
        textField.setFont(font);

        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
        f.setVisible(true);
        button.addActionListener((e->{
            System.out.println("Pressed");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);

        }));









        f.setVisible( true );

    }

}
