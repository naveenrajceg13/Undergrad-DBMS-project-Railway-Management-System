import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
import java.util.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
class project extends Frame implements ActionListener
{
     Frame f,f1,f2,f3,f4,f5,f6,f7,f8,f9;
     TextField username,password;
     TextField name,loginname,pwd,phoneno,frm,to,days,pnrno;
     Button login,register,cancel,submit,exits,gos,exit,check,cance,avail,exi,book,back,goback,canceling,no,finalise,thatsit,itsok;
     Image image;
     CheckboxGroup cg1;
     Connection con;
     Statement st;  
     int ss,tno;
     String log,fr,t,day;
     public static void main(String args[])throws Exception
     {
       project pj=new project();
      }
      public void paint(Graphics g)
      {
               g.drawImage(f.png,100,100,this);
      }
       public project()
        {
           try
           {
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           con=DriverManager.getConnection("jdbc:odbc:student");
           st=con.createStatement();
           }
            catch(Exception e)
            {
            }
        Label lbl = new Label("to railway ticket reservation ",Label.CENTER);
        f=new Frame("login page");
        this.paint(new Graphics());
        Panel wrapper=new Panel();
        wrapper.setBackground(Color.blue);
        f.add(wrapper);
        f.setVisible(true);
        f.add(lbl);
        f.setLayout(new FlowLayout());
        username=new TextField();
        password=new TextField();
        f.add(new Label("username"));
        f.add(username);
        f.add(new Label("password"));
        f.add(password);
        login=new Button("login");
        register=new Button("register");
        cancel=new Button("cancel");
        f.add(login);
        f.add(register);
        f.add(cancel);
        login.addActionListener(this);
        register.addActionListener(this);
        cancel.addActionListener(this);           
}
    public void actionPerformed(ActionEvent ae)
{
          
         String action=ae.getActionCommand();
           System.out.println(action);
         if(action.equals("cancel"))
              f.setVisible(false);
          if(action.equals("cance"))
              f3.setVisible(false);
         if(action.equals("register"))
              {
                     int c=0;
                     f.setVisible(false);
                     f1=new Frame("registeration");
                     f1.setLayout(new FlowLayout());
                     f1.setVisible(true);
                     f1.add(new Label("name"));
                     name=new TextField("");
                       f1.add(name);
                     f1.add(new Label("loginname"));
                      loginname=new TextField("");
                       f1.add(loginname);
                     f1.add(new Label("password"));
                      pwd=new TextField("");
                       f1.add(pwd);
                     f1.add(new Label("phoneno"));
                      phoneno=new TextField("");                   
                       f1.add(phoneno);
                       exit=new Button("exit");
                      submit=new Button("submit");
                       f1.add(exit);
                      f1.add(submit);
                       exit.addActionListener(this);
                      submit.addActionListener(this);                     }
           if(action.equals("submit"))
               {   
                         int c=1;
                         System.out.println("entered submit");
                      String loginnam=loginname.getText();
                      String nam=name.getText();
                      String pw=pwd.getText();
                      String phonen=phoneno.getText();
                         System.out.println("entered after getting text "+loginnam+nam+pw+phonen);
                      try
                         {
                          ResultSet rs=st.executeQuery("Select * from loginpage"); 
                      while(rs.next())
                       {
                                   String cv=rs.getString("loginname");
                                        System.out.println(loginnam);
                                   if(loginnam.equals(cv))
                                     {
                                        System.out.println(cv);
                                        c=0;
                                     }
                       }
                        if(c!=0)
                       {
                                
                                 String dbQuery = "INSERT INTO loginpage(loginname, name, password, phoneno) VALUES (?,?,?,?)";
 
PreparedStatement stat = con.prepareStatement(dbQuery);
stat.setString( 1, loginnam );
stat.setString( 2, nam ); 
stat.setString( 3, pw );
stat.setString( 4, phonen );
stat.executeUpdate();                              
                                 System.out.println("uptated");
                         f1.setVisible(false);
                         f.setVisible(true);
                         f.setLayout(new FlowLayout());
                         f.add(new Label("you registered successfully"));
                       }
                        else
                         {
                                 System.out.println("already");
                                 f1.add(new Label("sorry loginname already exits"));
                         }
                       }
                     catch(Exception e)
                      {
                                  System.out.println(e);
                      }
                         
               }
                        if(action.equals("exit"))
                                f1.setVisible(false);
                        if(action.equals("login"))
                          {
                                  System.out.println("in log in ");
                                  int c=0;
                                  log=username.getText();
                                  String pas=password.getText();   
                                  try
                         {
                          ResultSet rs=st.executeQuery("Select * from loginpage"); 
                              String nam=" ",phonen=" ",pw=" ",loginnam=" ";
                      while(rs.next())
                       {
                                    loginnam=rs.getString("loginname");
                                   if(loginnam.equals(log))
                                     {
                                        pw=rs.getString("password");
                                               if(pw.equals(pas))
                                                {    
                                                c=1;
                                                System.out.println("password match");
                                                nam=rs.getString("name");
                                                phonen=rs.getString("phoneno");
                                                break;
                                                }
                                     }
                       }
                                   if(c==1)
                                      {
                                              f.setVisible(false);                                                                            f2=new Frame("welcome page");
                                              f2.setVisible(true);
                                              f2.setLayout(new FlowLayout());                                                         f2.add(new Label(loginnam));
                                              f2.add(new Label(nam));
                                              f2.add(new Label(pw));
                                              f2.add(new Label(phonen));
                                              gos=new Button("go");
                                              exits=new Button("exits");
                                              f2.add(gos);
                                              f2.add(exits);
                                              exits.addActionListener(this);
                                              gos.addActionListener(this);
                                       }
                             }
                             catch(Exception e)
                              {
                                      System.out.println(e);
                              }
                          }
                          if(action.equals("exits"))
                                f2.setVisible(false);
                          if(action.equals("go"))
                           {
                                      f2.setVisible(false);
                                      f3=new Frame("train details page");
                                      f3.setVisible(true);
                                      f3.setLayout(new FlowLayout());
                                      frm=new TextField();
                                      to=new TextField();
                                      days=new TextField();
                                      check=new Button("check");
                                      cance=new Button("cance");
                                      canceling=new Button("canceling");
                                       f3.add(new Label("from"));
                                       f3.add(frm);
                                       f3.add(new Label("to"));
                                       f3.add(to);
                                       f3.add(new Label("days"));
                                       f3.add(days);
                                       f3.add(check);
                                       f3.add(cance);
                                       f3.add(canceling);
                                      canceling.addActionListener(this);
                                      check.addActionListener(this);
                                      cance.addActionListener(this);                                     
                          }
                         if(action.equals("check"))
                         {
                             try
                             {
                             f3.setVisible(false);
                             f4=new Frame("available trains");
                             f4.setLayout(new FlowLayout());
                             f4.setVisible(true);
                             fr=frm.getText();
                             t=to.getText();
                             day=days.getText();
                             System.out.println("before DB sta");
                             ResultSet rs=st.executeQuery("Select * from checkpage");
                              System.out.println("after DB sta");
                             avail=new Button("avail");
                             exi=new Button("exi");
                             cg1=new CheckboxGroup();
                             while(rs.next())
                             {
                                     String f=rs.getString("from");
                                     String tt=rs.getString("to");
                                     String d=rs.getString("day");
                                     System.out.println(f+tt+d);
                                     System.out.println(fr+t+day);
                                    if((f.equals(fr))&&(tt.equals(t))&&(d.equals(day)))
                                     {
                                     int trai=rs.getInt("trainno");
                                     Integer i=new Integer(trai);
                                     String trains=i.toString();      
                                     f4.add(new Checkbox(trains, cg1, false));
                                     }
                             } 
                               f4.add(avail);
                               f4.add(exi);
                               avail.addActionListener(this);
                               exi.addActionListener(this);
                         }
                          catch(Exception e)
                                   {
                                           System.out.println(e);
                                   }
}
                         if(action.equals("exi"))
                                f4.setVisible(false); 
                         if(action.equals("avail"))
                          {
                                try
                                {
                                f4.setVisible(false);
                                f5=new Frame("availabity");
                                f5.setVisible(true);
                                f5.setLayout(new FlowLayout());
                                book=new Button("book");
                                back=new Button("back");
                                String train=cg1.getSelectedCheckbox().getLabel();
                                tno=Integer.parseInt(train);
                                ResultSet rs=st.executeQuery("Select * from avail where traino="+tno);
                                while(rs.next())
                                  {
                                         ss=rs.getInt("availabity");
                                         Integer s=new Integer(ss);
                                         String av=s.toString();
                                         f5.add(new Label("avalibity in "+tno+"is "));
                                         f5.add(new Label(av));
                                  }
                                  f5.add(book);
                                  f5.add(back);                                                                                   book.addActionListener(this);
                                  back.addActionListener(this);
                           }
                            catch(Exception e)
                             {
                               System.out.println(e);              
                              }
}
                           if(action.equals("back"))
                              {
                                 f5.setVisible(false);
                                 f3.setVisible(true);
                              }
                           if(action.equals("book"))
                             {
                                    try
                                    {
                                     f6=new Frame("booking state");
                                     f6.setVisible(true);
                                     f5.setVisible(false);
                                     f6.setLayout(new FlowLayout());
                                     goback=new Button("goback");                                                                    if(ss==0)
                                     f6.add(new Label("seats not available sorry"));
                                     else
                                      {
                                          int rows = st.executeUpdate("UPDATE avail SET availabity = availabity -1 WHERE traino ="+tno ) ;                                                                String db = "INSERT INTO booked( pnr, trainno, loginname) VALUES (?,?,?)";
                                Random randomGenerator = new Random();
                                int ran = tno;
                                PreparedStatement stat = con.prepareStatement(db);
                                stat.setInt( 1, ran );
                                stat.setInt( 2, tno );
                                stat.setString( 3, log );
                                stat.executeUpdate(); 
                                f6.add(new Label("booked"));
                                Integer g=new Integer(ran);
                                String pn=g.toString();
                                f6.add(new Label("room no is "+pn));
                                f6.add(new Label("from "+fr));
                                f6.add(new Label("to "+t));
                                f6.add(new Label("day "+day));
                                f6.add(goback);
                                goback.addActionListener(this); 
                              }
                           }
                                 catch(Exception e)
                                  {
                                          System.out.println(e);
                                   }
                                      
                                }    
                                   if(action.equals("goback"))
                                      {
                                             f6.setVisible(false);                                                                           f3.setVisible(true);
                                       } 
                                   if(action.equals("canceling"))
                                      {
                                              System.out.println("inside canceling");
                                              
                                              f7=new Frame("canceling");
                                              f7.setLayout(new FlowLayout());
                                              f7.setVisible(true);
                                              f3.setVisible(false);
                                              System.out.println("step 1");
                                              pnrno=new TextField();
                                              f7.add(new Label("enter the pnr no to cancel"));
                                              f7.add(pnrno);
                                              finalise=new Button("finalise");
                                              no=new Button("no");
                                              f7.add(finalise);
                                              f7.add(no);
                                              finalise.addActionListener(this);
                                              no.addActionListener(this);
                                       }
                                   if(action.equals("no"))
                                      {
                                                 f7.setVisible(false);
                                                 f3.setVisible(true);
                                       }
                                   if(action.equals("itsok"))
                                      {
                                                 f9.setVisible(false);
                                                 f3.setVisible(true);
                                       }
                                   if(action.equals("thatsit"))
                                        {
                                               f8.setVisible(false);
                                               f3.setVisible(true);
                                        }
                                   if(action.equals("finalise"))
                                    {
                                             try
                                            {
                                             int z=0;
                                             String p=pnrno.getText();
                                             int ps=Integer.parseInt(p);
                                     ResultSet rs=st.executeQuery("Select * from booked"); 
                      while(rs.next())
                       {
                                     int a=rs.getInt("pnr");
                                     if(a==ps)
                                       {
                                           String str=rs.getString("loginname");
                                             if(str.equals(log))
                                                 z++;
                                        }
                       }
                                        System.out.println("after checking avalibility ");
                                           if(z>0)
                                           {
 int rows = st.executeUpdate("UPDATE avail SET availabity = availabity +1 where traino=(select trainno from booked WHERE pnr="+ps+")");
                                       System.out.println("after 1st query ");
                                             int row = st.executeUpdate("DELETE from booked where pnr="+ps);
                                          f7.setVisible(false);
                                          f8=new Frame("wow u canceled");
                                          f8.setLayout(new FlowLayout());
                                          f8.setVisible(true);
                                          thatsit=new Button("thatsit");
                                          f8.add(thatsit);
                                          thatsit.addActionListener(this);
                                           }
                                           else
                                           {
                                                f9=new Frame("sorry");
                                                f9.setVisible(true);
                                                f7.setVisible(false);
                                                f9.add(new Label("pnr is invalid or already canceled one "));
                                                itsok=new Button("itsok");
                                                f9.add(itsok);
                                                itsok.addActionListener(this);
                                            } 
                             }
                             catch(Exception e)
                               {
                                         System.out.println(e);
                               }
}                          
}  
} 