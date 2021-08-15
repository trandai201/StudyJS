using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.SqlClient;
using System.Data;

namespace VDVeXML
{
    class Program
    {
        static void Main(string[] args)
        {
            // Đây là String để kết nối vô DataBase ă, thôi cứ hiểu như 1 cái chìa khóa vô cổng đi không có nó không kết nối đc đâu
            String stringConn= "Data Source=DESKTOP-KQDGKVB\\SQLEXPRESS;Initial Catalog=STUDENTS;Integrated Security=True";
            // này là câu lệnh select dử liệu ă
            String query = "select * from student_table";
            // tạo đối tượng để kết nối
            SqlConnection conn = new SqlConnection(stringConn);

            try{
            SqlDataAdapter da = new SqlDataAdapter();
            da.SelectCommand = new SqlCommand(query,conn);
            SqlCommandBuilder cb = new SqlCommandBuilder(da);
            DataSet ds = new DataSet();
            da.Fill(ds,"student");
            ds.DataSetName = "students";
            ds.WriteXml("temp.xml");
            }catch(Exception e){
                Console.Write("Loi Roi "+e.Message);
            }


        }
    }
}
