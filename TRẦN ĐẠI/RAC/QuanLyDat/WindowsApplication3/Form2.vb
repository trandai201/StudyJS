Imports System.Data.OleDb

Public Class Form2
    Public con_tro As BindingManagerBase


    Function createTable(ByVal str As String) As Boolean
        Form1.con.Open()

        Dim cmd As New OleDbCommand(str, Form1.con)

        Dim bang_doc As OleDbDataReader = cmd.ExecuteReader

        Dim dttable As New DataTable("table_user")

        dttable.Load(bang_doc, LoadOption.OverwriteChanges)
        Form1.con.Close()

        DataGrid1.DataSource = dttable
        con_tro = BindingContext(dttable)

        Return True
    End Function


    Private Sub Form2_FormClosing(ByVal sender As System.Object, ByVal e As System.Windows.Forms.FormClosingEventArgs) Handles MyBase.FormClosing
        Hide()
        Form1.Show()
    End Sub

    Private Sub Form2_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        createTable("select * from table_thuadat")
    End Sub

    
 

  

    Private Sub DataGrid1_MouseCaptureChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles DataGrid1.MouseCaptureChanged
        Try
            TextBoxThuaDatSo.Text = con_tro.Current(0)
            TextBoxSoCCCD.Text = con_tro.Current(1)
            TextBoxDienTich.Text = con_tro.Current(2)
            RichTextBoxDiaChi.Text = con_tro.Current(3)
            TextBoxDai.Text = con_tro.Current(4)
            TextBoxRong.Text = con_tro.Current(5)



            If con_tro.Current(6).ToString.Equals("Nông Nghiệp") Then
                ComboBoxLoai.SelectedIndex = 1
            End If
            If con_tro.Current(6).ToString.Equals("Thổ Cư") Then
                ComboBoxLoai.SelectedIndex = 0
            End If
        Catch ex As Exception

        End Try
     







    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        createTable("select * from table_ThuaDat where diachi like N'%" + TextBoxDiaChi.Text + "%' and " +
                     TextBoxTu.Text + " <= dientich and dientich <= " + TextBoxDen.Text + " and loai = N'" + ComboBoxLoaiTK.SelectedItem.ToString + "'")
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Try
            Form1.con.Open()
            Dim qurey As String = "update table_ThuaDat set soCCCD = '" + TextBoxSoCCCD.Text + "' , dientich = " + TextBoxDienTich.Text + " ,dai = " + TextBoxDai.Text + ", rong = " + TextBoxRong.Text + ", loai = N'" + ComboBoxLoai.SelectedItem.ToString + "', diachi = '" + RichTextBoxDiaChi.Text + "' where maThuaDat = '" + con_tro.Current(0) + "'"
            Dim cmd As New OleDbCommand(qurey, Form1.con)
            cmd.ExecuteNonQuery()
            Form1.con.Close()
            createTable("select * from table_thuadat")
            MsgBox("Sửa Thành Công", vbOKOnly, "Thông Báo")
        Catch ex As Exception
            Form1.con.Close()
            MsgBox("Lỗi Rồi", vbOKOnly, "Thông Báo")
        End Try
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Try
            Form1.con.Open()
            Dim qurey As String = "delete from table_ThuaDat where maThuaDat = '" + con_tro.Current(0) + "'"
            Dim cmd As New OleDbCommand(qurey, Form1.con)
            cmd.ExecuteNonQuery()
            Form1.con.Close()
            createTable("select * from table_thuadat")
            MsgBox("Xóa Thành Công", vbOKOnly, "Thông Báo")
        Catch ex As Exception
            Form1.con.Close()
            MsgBox("Lỗi Rồi", vbOKOnly, "Thông Báo")
        End Try
    End Sub


    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click

        Form1.con.Open()
        Dim qurey As String = "insert into table_ThuaDat" +
       " values " +
"('" + TextBoxThuaDatSo.Text + "','" + TextBoxSoCCCD.Text + "'," + TextBoxDienTich.Text + ",N'" + RichTextBoxDiaChi.Text + "'," + TextBoxDai.Text + "," + TextBoxRong.Text + ", N'" + ComboBoxLoai.SelectedItem.ToString + "')"
        Dim cmd As New OleDbCommand(qurey, Form1.con)
        cmd.ExecuteNonQuery()
        Form1.con.Close()
        createTable("select * from table_thuadat")
        MsgBox("Thêm Thành Công", vbOKOnly, "Thông Báo")
   
    End Sub

    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click
        Form4.Show()
    End Sub

    Private Sub Button6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button6.Click
        Form3.Show()
    End Sub
End Class