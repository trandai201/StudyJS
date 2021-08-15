Imports System.Data.OleDb

Public Class Group_8_Đại_34

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim constring As String = "Provider=SQLOLEDB;Data Source=DESKTOP-KQDGKVB\SQLEXPRESS;Integrated Security=SSPI;Initial Catalog=QuanLiDat"
        Dim con As OleDbConnection = New OleDbConnection(constring)
        Dim str As String = "select * from table_login where userName  =  '" + userName.Text + "' and password = '" + password.Text + "'"
        con.Open()
        Dim cmd As New OleDbCommand(str, con)
        Dim bang_doc As OleDbDataReader = cmd.ExecuteReader
        Try
            bang_doc.Read()
            str = bang_doc(0).ToString
            Form1.Show()
        Catch ex As Exception
            MsgBox("Sai Tên Đăng Nhập Hoặc Mật Khẩu", vbOKOnly, "Thông Báo")
        End Try
        con.Close()
    End Sub
    Private Sub Group_8_Đại_34_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
    End Sub
End Class