import utulities.ReusableMethods;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Odev {

    /*
         ---------------------------------------------------------------------
    								Ödev
         1- Roles tablosundan name bilgisi 'Receptionist' olan rolün is_active, is_system, is_superadmin ve created_at bilgilerini alt alta yazdiriniz.
         2- Patients tablosundaki ismi 'a' ile baslayan hastalarin patient_name, age, mobileno, email bilgilerini listeleyiniz.
         3- visitors_book tablosundan purpose bilgisi 'Inguiry' olan ziyaretcilerin isimlerini ters sirali listeleyiniz.
         ---------------------------------------------------------------------
     */

    /*
       1- Roles tablosundan name bilgisi 'Receptionist' olan rolün is_active, is_system, is_superadmin
       ve created_at bilgilerini alt alta yazdiriniz.
        */
    public static void main(String[] args) throws SQLException {


        Statement st = ReusableMethods.createStatement(ReusableMethods.getConnection());

        String query = "select is_active,is_system,is_superadmin,created_at from heallife_hospitaltraining.roles where `name`='Receptionist';";

        ResultSet rs = st.executeQuery(query);

        rs.next();
        System.out.println(rs.getInt("is_active") + " \n " + rs.getInt("is_system") + " \n " + rs.getInt("is_superadmin") + " \n " + rs.getString("created_at"));

        System.out.println("------------------------------------------------------------------");

        /*
         2- Patients tablosundaki ismi 'a' ile baslayan hastalarin patient_name, age, mobileno, email bilgilerini listeleyiniz.
         */

        query = "select patient_name,mobileno,email from heallife_hospitaltraining.patients where patient_name LIKE 'a%'";

        rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString("patient_name") + " \n " + rs.getString("mobileno") + " \n " + rs.getString("email"));
        }

        System.out.println("------------------------------------------------------------------");

        /*
           3- visitors_book tablosundan purpose bilgisi 'Inquiry' olan ziyaretcilerin isimlerini ters sirali listeleyiniz.
         */

        query = "select name from heallife_hospitaltraining.visitors_book where purpose='Inquiry' order by name DESC";

        rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }
}
