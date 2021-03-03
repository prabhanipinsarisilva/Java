/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscr;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class quick_purchase extends javax.swing.JFrame {
Connection con=null;
  PreparedStatement pst=null;
 ResultSet rs=null;
    /**
     * Creates new form NewJFrame
     */
    public quick_purchase() {
        initComponents();
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    
   /* 
    
      public void makeConnection() 
 {
     
    try{ 
     
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
     LocalDateTime now = LocalDateTime.now();  
     String date = dtf.format(now);
     
     String subtot =  jTextField6.getText();
     String name =  jTextField2.getText();
     String pay = jTextField7.getText();
     String bal =  jTextField9.getText();
    
    
     String item_code  = "";
     String price = "";
     String qty1;
        qty1 = "";
     int total = 0;
     int lastinsertid=0;
        
     Class.forName("com.mysql.jdbc.Driver");   
     //con1=DriverManager.getConnection("jdbc:mysql://localhost/javapos","root",""); 
  //  con=(java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/javapos","root","");
   con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/practise","root","");
    String query1 = "insert into sales (date,subtotal,cashier,pay,balance)values(?,?,?,?,?)";
    pst = (PreparedStatement) con.prepareStatement(query1,Statement.RETURN_GENERATED_KEYS);
  
   pst.setString(1, date);    
   pst.setString (2, subtot);
    pst.setString (3, name);
   pst.setString(4, pay);   
   pst.setString (5, bal); 
   pst.executeUpdate(); 
   ResultSet generatedKeyResult = pst.getGeneratedKeys();

       if (generatedKeyResult.next()) 
       {
          lastinsertid = generatedKeyResult.getInt(1);
      }    
    System.out.println("Inserted record's ID: " + lastinsertid);   
  
  
  int rows;
        rows = jTable1.getRowCount();
  String queryco1 = "Insert into sales_product(sales_id,product_id,sell_price,qty,total)values(?,?,?,?,?)";    
  java.sql.PreparedStatement preparedStmt1 = con.prepareStatement(queryco1);

  for (int i = 0; i < jTable1.getRowCount(); i++)      
  {        
    item_code = (String)jTable1.getValueAt(i, 0);
    price = (String)jTable1.getValueAt(i, 2);  
    String quantity; 
         quantity = (String)jTable1.getValueAt(i, 3);
    total = (Integer)jTable1.getValueAt(i, 4); 

    preparedStmt1.setInt(1, lastinsertid);
    preparedStmt1.setString(2, item_code );
    preparedStmt1.setString(3, price);
    preparedStmt1.setString(4,  quantity);
    preparedStmt1.setInt(5, total);
    preparedStmt1.executeUpdate();      
      
  }
  
     String sqlupdate= "update item1 set stock_in_hand= stock_in_hand-? where item_code=? ";
     preparedStmt1=con.prepareStatement(sqlupdate);
      
   for (int i = 0; i < jTable1.getRowCount(); i++)      
  {        
    item_code  = (String)jTable1.getValueAt(i, 0);
         String quantity = (String)jTable1.getValueAt(i, 2); 
     
    preparedStmt1.setString(3,quantity);
    preparedStmt1.setString(0, item_code );    
    preparedStmt1.execute();
  
  }
   
  preparedStmt1.addBatch();
  JOptionPane.showMessageDialog(null, "Successfully Save");    
      
}
catch(ClassNotFoundException | SQLException | HeadlessException e){
  JOptionPane.showMessageDialog(this,e.getMessage());

}
     
 }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    */
    
    private void Updatestock()
    {
         
        int qty = Integer.parseInt(jSpinner1.getValue().toString());
        int stock = Integer.parseInt(jTextField8.getText());
        int remain =stock-qty;
        jTextField10.setText(String.valueOf(remain)); 
        int a;
    a = Integer.parseInt(jTextField10.getText());        
   try{ String mk = jTextField1.getText();
  String ml = jTextField10.getText();
  try{
     Class.forName("com.mysql.jdbc.Driver").newInstance();
    // Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?zeroDateTimeBehavior=convertToNull","root","netbean");
    con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?zeroDateTimeBehavior=convertToNull","root","");
       try (Statement stmt = con.createStatement()) {
           int bp = JOptionPane.showConfirmDialog(this,"Do you want to update the current stock?");
           if(bp == JOptionPane.YES_OPTION)
           {
               if(a>0)
               {
                    String query = "update item1 set stock_in_hand = '"+ ml +"'where item_code = '"+ mk +"';";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(this,"stock has been updated");
               }
               else
               {
                    JOptionPane.showMessageDialog(this,"stock cannot be updated");
               }
           }
           if(bp == JOptionPane.CANCEL_OPTION){
               // jFrame2.dispose();
//jFrame2.setVisible(true);
           }
           if(bp == JOptionPane.NO_OPTION){
               //jFrame2.dispose();
//jFrame2.setVisible(true);
           } }
     con.close();
  }
  catch(HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e)
  {
      JOptionPane.showMessageDialog(this,"Error in connectivity" );
  } 
}
catch(HeadlessException e)
{
    JOptionPane.showMessageDialog(null,"Invalid Entry or field must be completely filled","message",2); 
}// TODO add your handling code here:

        
        
   
    }
    
    
    
    
    
    
    
    
    
    
    public void calculation()
    {
        
        int f_total = Integer.parseInt(jTextField11.getText());
        int pay = Integer.parseInt(jTextField7.getText());
        int bal = f_total - pay;
        
        jTextField9.setText(String.valueOf(bal));
        
    }

    public void calculation(int x)
    {
        int total1 = Integer.parseInt(jTextField6.getText());
        int final_price=total1-(total1*x/100);
        jTextField11.setText(String.valueOf(final_price));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     public void bill()
    {
         String total = jTextField6.getText();
         String pay = jTextField7.getText();
         String bal = jTextField9.getText();
          String discount = jTextField12.getText();
         
         // DefaultTableModel model = new DefaultTableModel();
        
      //  model = (DefaultTableModel)jTable1.getModel();
         
      
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
         jTextArea1.setText(jTextArea1.getText() + "******************************************************\n");
         jTextArea1.setText(jTextArea1.getText() + "           POSBILL                                     \n");
         jTextArea1.setText(jTextArea1.getText() + "*******************************************************\n");
         
         //Heading
          jTextArea1.setText(jTextArea1.getText() + "Product" + "\t" + "Price" + "\t" + "Amount" + "\n"  );
          
          
          for(int i = 0; i < model.getRowCount(); i++)
          {
              
              String pname = (String)model.getValueAt(i, 1);
              String price = (String)model.getValueAt(i, 3);
              String amount = (String)model.getValueAt(i, 4); 
              
           jTextArea1.setText(jTextArea1.getText() + pname  + "\t" + price + "\t" + amount  + "\n"  );
    
          }
          
          jTextArea1.setText(jTextArea1.getText() + "\n");     
          
         jTextArea1.setText(jTextArea1.getText() + "\t" + "\t" + "Subtotal :" + total + "\n");
         jTextArea1.setText(jTextArea1.getText() + "\t" + "\t" + "discount :" + discount + "\n");
          jTextArea1.setText(jTextArea1.getText() + "\t" + "\t" + "Pay :" + pay + "\n");
         jTextArea1.setText(jTextArea1.getText() + "\t" + "\t" + "Balance :" + bal + "\n");
          jTextArea1.setText(jTextArea1.getText() + "\n");
          jTextArea1.setText(jTextArea1.getText() + "*******************************************************\n");
          jTextArea1.setText(jTextArea1.getText() + "           THANK YOU COME AGIN             \n");

        
    }
    
    
    
    
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("BACK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(70, 900, 160, 60);

        jPanel6.setBackground(new java.awt.Color(0, 153, 51));

        jLabel7.setText("Total");

        jTextField6.setBackground(new java.awt.Color(204, 255, 0));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel8.setText("Pay");

        jTextField7.setBackground(new java.awt.Color(204, 255, 0));

        jLabel9.setText("Balance");

        jButton1.setText(" Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel12.setText("final amount");

        jTextField12.setBackground(new java.awt.Color(204, 255, 0));

        jLabel13.setText("discount");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(84, 84, 84)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(25, 25, 25))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(17, 17, 17)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(1390, 40, 440, 800);

        jPanel4.setBackground(new java.awt.Color(255, 204, 0));

        jLabel2.setText("Item_code");

        jLabel3.setText("item_name");

        jLabel4.setText("Qty");

        jLabel5.setText("price");

        jLabel6.setText("amount");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("stock_in_hand");

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jLabel11.setText("stock remain");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(19, 19, 19)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel6)
                        .addGap(152, 152, 152))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jSpinner1)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField10)
                    .addComponent(jTextField8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(100, 40, 1263, 228);

        jTable1.setBackground(new java.awt.Color(255, 102, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "item_code", "item_name", "quantity", "price", "total"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(100, 300, 1250, 500);

        jButton3.setText("print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(624, 846, 329, 82);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/splashscr/images/thumb-1920-883558.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(-70, -270, 2310, 1330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
        //DefaultTableModel model = new DefaultTableModel();
      //  model = (DefaultTableModel)jTable1.getModel();
        
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]
                
        {
            jTextField1.getText(),
            jTextField2.getText(),
           jSpinner1.getValue().toString(),
         //   jTextField5.getText(),
            jTextField3.getText(),
            jTextField4.getText(),           
        });   
                
            int sum = 0;
                    
        for(int i = 0; i<jTable1.getRowCount(); i++)
        {
            sum = sum + Integer.parseInt(jTable1.getValueAt(i, 4).toString());
            
           //  String sqlupdate= "update item1 set stock_in_hand= stock_in_hand-parseInt(jTable1.getValueAt(i, 3).toString()) where item_code=? ";
        }
        
    
     
     
     
     
     
      jTextField6.setText(Integer.toString(sum));
           
           jTextField1.setText("");
           jTextField2.setText("");
           //jTextField5.setText("");
            jTextField3.setText("");
           jTextField4.setText("");
           jTextField8.setText("");
             jTextField10.setText("");
         jTextField1.requestFocus();
    
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
                             
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String pcode = jTextField1.getText();   
            try {
                Class.forName("com.mysql.jdbc.Driver");
              //  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?zeroDateTimeBehavior=convertToNull","root","");
                con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant?zeroDateTimeBehavior=convertToNull","root","");
                pst = (PreparedStatement) con.prepareStatement("select * from item1 where item_code = ?");
                pst.setString(1, pcode);
                rs = pst.executeQuery();
                
                if(rs.next() == false)
                {     
                    JOptionPane.showMessageDialog(this, "Product Code Not Found");  
                }
                else
                {
                    String pname = rs.getString("item_name");
                     String price = rs.getString("rate");
                     String st_hand=rs.getString("stock_in_hand");
                    jTextField2.setText(pname.trim());
                     jTextField3.setText(price.trim());
                     jTextField8.setText(st_hand.trim());
                     
                     
                }
            } catch (ClassNotFoundException | SQLException ex) {
                
            }
        }
    
        
        
        
        
        
        
    }//GEN-LAST:event_jTextField1KeyPressed

    
    
    
    
    
    
    
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int discount = Integer.parseInt(jTextField12.getText());
        calculation(discount);
        calculation();
        
        bill();
     //  makeConnection() ;
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        try 
        {
            jTextArea1.print();
        } 
        catch (PrinterException ex) {
            
        }  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
         int qty = Integer.parseInt(jSpinner1.getValue().toString());
        int price = Integer.parseInt(jTextField3.getText());
        int tot = qty * price;
        
        jTextField4.setText(String.valueOf(tot));
        
        Updatestock();
        
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         purchase_pannel A=new  purchase_pannel();
         this.setVisible(false);
         A.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quick_purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new quick_purchase().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
