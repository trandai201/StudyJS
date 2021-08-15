Public Class Form3

    Private Sub Form3_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'TODO: This line of code loads data into the 'QuanLiDatDataSet.table_ThuaDat1' table. You can move, or remove it, as needed.
        Me.table_ThuaDat1TableAdapter.Fill(Me.QuanLiDatDataSet.table_ThuaDat1)
        Me.ReportViewer1.RefreshReport()
        Dim dt As New DataTable
        Using con As New SqlClient.SqlConnection("Data Source=DESKTOP-KQDGKVB\SQLEXPRESS;Initial Catalog=QuanLiDat;Integrated Security=True")
            con.Open()
            Using cmd As New SqlClient.SqlCommand("select * from table_ThuaDat t ,table_CongDan c where diachi like N'%" + Form2.TextBoxDiaChi.Text + "%' and " +
                     Form2.TextBoxTu.Text + " <= dientich and dientich <= " + Form2.TextBoxDen.Text + " and loai = N'" + Form2.ComboBoxLoaiTK.SelectedItem.ToString + "' and c.soCCCD = t.soCCCD", con)
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