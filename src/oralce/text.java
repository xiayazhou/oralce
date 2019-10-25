package oralce;

import java.sql.*;

public class text {
    public static void main(String[] args) {
        Connection conn=null;
        Statement statement=null;
        ResultSet qes=null;
        try{
            //第一种方式连接Oracle
            // 第一步加载驱动
            Class.forName("oracle.jdbc.OracleDriver");
            //第二步获取连接
            conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","123456");
            //第三步获取执行sql的语句对象
            statement=conn.createStatement();
            //第四步执行sql语句
            qes=statement.executeQuery("select t.*, t.rowid from STUDENT t");
            //第五步处理结果集
            while (qes.next()){
//                System.out.println("id="+qes.getInt("id"));
                System.out.print("stuid="+qes.getInt("stuid")+"  ");
                System.out.print("stuname="+qes.getString("stuname")+"  ");
                System.out.println("stuage="+qes.getString("stuage")+"  ");
            }
            //第二种方式
            //第一步使用Driver对象加载驱动


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //第六步：关闭资源
            try {
                if (qes!=null) qes.close();
                if (statement!=null) statement.close();
                if (conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
