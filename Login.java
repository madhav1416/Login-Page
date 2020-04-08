import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    String id,password;
    JFrame f;
    JTextField t1;
    JPasswordField t2;
    Connection con=null;
    Statement stm=null;
Login(){
JFrame f =new JFrame("Login Page");
JLabel l1=new JLabel("Login:");
l1.setBounds(100,50,100,100); 
JLabel l2=new JLabel("Password:");
l2.setBounds(100,100,100,100); 
 t1=new JTextField();
t1.setBounds(200,90,200,20);
t2=new JPasswordField();
t2.setBounds(200,140,200,20);
JButton b=new JButton("Click");
b.setBounds(200,190,100,30);
b.addActionListener(this);
f.add(l1);f.add(l2);f.add(t1);f.add(t2);f.add(b);
f.setSize(500,500);
f.setLayout(null);
f.setVisible(true);
}
public void actionPerformed(ActionEvent e) {
id = t1.getText();
password =t2.getPassword().toString();
try { 
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
    stm=con.createStatement();
    String sql;
    sql ="INSERT INTO login(id,password) VALUES('"+id+"','"+password+"')";
    stm.executeUpdate(sql);
    con.close();
    stm.close();
    JOptionPane.showMessageDialog(null,"Inserted Successfully!");
}
catch(Exception ex){
    ex.printStackTrace();
    //System.out.println("sorry");
}
}
// public String getid(){
//     return id;
// }
// public String getpassword() {
//     return password;
// }
}
class main {

    public static void main(String args[]){

        new Login();
        // String id=t.getid();
        // String password=t.getpassword();
        // System.out.println(id+" "+password);
    }
}