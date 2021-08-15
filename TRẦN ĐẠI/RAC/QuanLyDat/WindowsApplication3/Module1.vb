Imports System.Data.OleDb

Module Module1
    Function resetDataGid() As Boolean
        Form1.con.Open()
        Dim cmd As New OleDbCommand("select a.maThuaDat,a.soCCCD,a.dientich,a.dai,a.rong,a.diachi,a.loai  from table_ThuaDat a,table_CongDan b where b.soCCCD = '" + Form1.textBoxSoCCCDA.Text + "' and a.soCCCD = b.soCCCD", Form1.con)
        Dim bang_doc As OleDbDataReader = cmd.ExecuteReader


        Dim dttable As New DataTable("table_user")
        dttable.Load(bang_doc, LoadOption.OverwriteChanges)
        Form1.con.Close()

        Form1.DataGrid1.DataSource = dttable
        Form1.con_tro = Form1.BindingContext(dttable)

        Return True
    End Function
End Module
