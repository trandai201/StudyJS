Public Class Form4

    Private Sub Form4_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'TODO: This line of code loads data into the 'QuanLiDatDataSet.table_ThuaDat1' table. You can move, or remove it, as needed.
        Me.table_ThuaDat1TableAdapter.Fill(Me.QuanLiDatDataSet.table_ThuaDat1)
        Me.ReportViewer1.RefreshReport()
        Dim dt As New DataTable
        Using con As New SqlClient.SqlConnection("Data Source=DESKTOP-KQDGKVB\SQLEXPRESS;Initial Catalog=QuanLiDat;Integrated Security=True")
            con.Open()
            Using cmd As New SqlClient.SqlCommand("SELECT maThuaDat, t.soCCCD,c.ten, dientich, diachi, dai, rong, loai FROM dbo.table_ThuaDat t, dbo.table_CongDan c " +
"where t.soCCCD = c.soCCCD and t.soCCCD = '" + Form2.con_tro.Current(1) + "'", con)
                Dim da As New SqlClient.SqlDataAdapter
                da.SelectCommand = cmd
                da.Fill(dt)
            End Using
            With Me.ReportViewer1.LocalReport
                .DataSources.Clear()
                .DataSources.Add(New Microsoft.Reporting.WinForms.ReportDataSource("DataSet1", dt))
            End With
            Me.ReportViewer1.RefreshReport()
        End Using
    End Sub
End Class