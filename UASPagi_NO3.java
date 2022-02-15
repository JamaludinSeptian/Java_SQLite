import java.sql.*;
import java.util.Scanner;

public class UASPagi_NO3 {
    public static void main(String[] args){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection file=DriverManager.getConnection("jdbc:sqlite:D:/UAS/Jamaludin.db");
            Statement stat=file.createStatement();
            Scanner sc = new Scanner(System.in);
          
            System.out.println("                    DATA NILAI PEMROGRAMAN 3                                                      ");
            System.out.println("==================================================================================================");
            System.out.print("\t Masukkan kata kunci pencarian : "); String kunci=sc.next();
            System.out.println("==================================================================================================");
            System.out.println("Hasil Pencarian : ");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("NPM      \tNama Mahasiswa\t       Kelas  \tRata-rata\tGrade");
            System.out.println("--------------------------------------------------------------------------------------------------");
             
            ResultSet rsl=stat.executeQuery("select * from mahasiswa where NPM='"+kunci+"' OR Nama like '%"+kunci+"%'");
            while(rsl.next()){
                int rt=rsl.getInt("rata_rata");
                String g;
                if(rt >= 85 && rt <= 100){
                    g="A";
                }else if(rt >= 70 && rt <= 84.99){
                    g="B";
                }else if(rt >= 56 && rt <= 69.99){
                    g="C";
                }else if(rt >= 45 && rt <= 55.99){
                    g="D";
                }else if(rt >= 0 && rt <= 44.99){
                    g="E";
                }else{
                    g="Data Tidak Ada";
                }
                System.out.print(rsl.getString ("NPM"));
                System.out.print("\t"+rsl.getString ("Nama"));
                System.out.print("\t\t"+rsl.getString ("Kelas"));
                System.out.print("\t"+rsl.getString ("rata_rata"));
                System.out.print("\t\t"+g);
                System.out.println();
                System.out.println("--------------------------------------------------------------------------------------------------");
            }
        }catch(Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }
}
