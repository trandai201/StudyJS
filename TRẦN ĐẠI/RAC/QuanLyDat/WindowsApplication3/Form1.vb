Imports System.Data.OleDb

Public Class Form1
    Public con As OleDbConnection
    Public con_tro As BindingManagerBase
    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Dim constring As String = "Provider=SQLOLEDB;Data Source=DESKTOP-KQDGKVB\SQLEXPRESS;Integrated Security=SSPI;Initial Catalog=QuanLiDat"
        con = New OleDbConnection(constring)
        DataGrid1.Enabled = False
    End Sub

    Private Sub textFiledSoCCCDA_Leave(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles textBoxSoCCCDA.Leave
        Dim str As String = "select * from table_CongDan,table_HoKhau where soCCCD = '" + textBoxSoCCCDA.Text + "'  and table_CongDan.soHoKhau = table_HoKhau.soHoKhau"
        con.Open()
        Dim cmd As New OleDbCommand(str, con)
        Dim bang_doc As OleDbDataReader = cmd.ExecuteReader
        Try
            bang_doc.Read()
            TextBoxHoTenA.Text = bang_doc("ten").ToString
            DateTimePickerNgaySinhA.Value = DateTime.Parse(bang_doc(2).ToString)
            DateTimePickerNgayCapA.Value = DateTime.Parse(bang_doc(3).ToString)
            RichTextBoxDiaChiA.Text = bang_doc(6).ToString
            TextBoxSoHoKhauA.Text = bang_doc(5).ToString
        Catch ex As Exception
            MsgBox("Bạn Đã Nhập Sai Số CCCD", vbOKOnly, "Thông Báo")
        End Try
        con.Close()
    End Sub

    Private Sub textBoxSoCCCDB_Leave(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles textBoxSoCCCDB.Leave
        Dim str As String = "select * from table_CongDan,table_HoKhau where soCCCD = '" + textBoxSoCCCDB.Text + "'  and table_CongDan.soHoKhau = table_HoKhau.soHoKhau"

        con.Open()
        Dim cmd As New OleDbCommand(str, con)
        Dim bang_doc As OleDbDataReader = cmd.ExecuteReader
        Try
            bang_doc.Read()
            TextBoxHoTenB.Text = bang_doc("ten").ToString

            DateTimePickerNgaySinhB.Value = DateTime.Parse(bang_doc(2).ToString)
            DateTimePickerNgayCapB.Value = DateTime.Parse(bang_doc(3).ToString)
            RichTextBoxDiaChiB.Text = bang_doc(6).ToString
            TextBoxSoHoKhauB.Text = bang_doc(5).ToString
        Catch ex As Exception
            MsgBox("Bạn Đã Nhập Sai Số CCCD", vbOKOnly, "Thông Báo")
        End Try


        con.Close()
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        DataGrid1.Enabled = True
        Module1.resetDataGid()
    End Sub

    Private Sub DataGrid1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles DataGrid1.Click
        thuaDatSo.Text = con_tro.Current(0)
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        If thuaDatSo.Text = "" Or textBoxSoCCCDA.Text = "" Or textBoxSoCCCDB.Text = "" Then
            MsgBox("Nhập Thiếu Đầu Vào, Hãy Kiểm Tra Lại", vbOKOnly, "Thông Báo")
        Else
            con.Open()
            Dim cmd As New OleDbCommand("update table_ThuaDat  set soCCCD = '" + textBoxSoCCCDB.Text + "' where maThuaDat = '" + thuaDatSo.Text + "'", con)
            cmd.ExecuteNonQuery()
            con.Close()
            MsgBox("Đã Chuyển Nhượng Thành Công", vbOKOnly, "Thông Báo")
            DataGrid1.DataSource = Nothing
            DataGrid1.Enabled = False

            textBoxSoCCCDA.Text = ""
            TextBoxHoTenA.Text = ""
            RichTextBoxDiaChiA.Text = ""
            TextBoxSoHoKhauA.Text = ""


            textBoxSoCCCDB.Text = ""
            TextBoxHoTenB.Text = ""
            RichTextBoxDiaChiB.Text = ""
            TextBoxSoHoKhauB.Text = ""
        End If
    End Sub

    Private Sub LicToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles LicToolStripMenuItem.Click
        Form2.Show()
        Hide()
    End Sub

    Private Sub BáoCáoToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles BáoCáoToolStripMenuItem.Click
        Form3.Show()
    End Sub

End Class
