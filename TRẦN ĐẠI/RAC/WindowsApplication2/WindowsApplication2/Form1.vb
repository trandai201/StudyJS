Imports System.Data.OleDb
Imports Microsoft.Reporting.WinForms

Public Class Form1
    Private con As OleDbConnection
    Private WithEvents danh_sach As BindingManagerBase
    Public lenh As String


    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Dim constring As String = "Provider=SQLOLEDB;Data Source=DESKTOP-KQDGKVB\SQLEXPRESS;Integrated Security=SSPI;Initial Catalog=DanhBa"

        Label1.Text = Application.StartupPath

        con = New OleDbConnection(constring)
        Dim a As ReportDataSource
        ''     ReportViewer1.LocalReport.DataSources.Add()

        Xuat_sinhvien()



        Me.ReportViewer1.RefreshReport()
    End Sub

    Private Sub Xuat_sinhvien()
        Dim lenh As String
        con.Open()
        lenh = "select * from table_User"
        Dim cmd As New OleDbCommand(lenh, con)

        Dim bang_doc As OleDbDataReader = cmd.ExecuteReader

        'Label1.Text = bang_doc("userName").ToString
        Dim dttable As New DataTable("table_User")
        dttable.Load(bang_doc, LoadOption.OverwriteChanges)
        con.Close()

        DataGrid1.DataSource = dttable

        danh_sach = Me.BindingContext(dttable)

    End Sub


 
End Class
