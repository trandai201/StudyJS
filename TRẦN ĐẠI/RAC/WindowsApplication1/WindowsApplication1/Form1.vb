Public Class Form1

    Private Sub OleDbDataAdapter1_RowUpdated(ByVal sender As System.Object, ByVal e As System.Data.OleDb.OleDbRowUpdatedEventArgs)

    End Sub

    Private Sub OleDbConnection1_InfoMessage(ByVal sender As System.Object, ByVal e As System.Data.OleDb.OleDbInfoMessageEventArgs)

    End Sub

    Private Sub DataGrid1_Navigate(ByVal sender As System.Object, ByVal ne As System.Windows.Forms.NavigateEventArgs)

    End Sub




    Private Sub BindingSource1_CurrentChanged(ByVal sender As System.Object, ByVal e As System.EventArgs)

    End Sub

    Private Sub FirstTableBindingSource_CurrentChanged(ByVal sender As System.Object, ByVal e As System.EventArgs)

    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        BindingContext(TableAdapterManager).Position = 2
        Button1.Text = BindingContext(TableAdapterManager).Count

    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        'TODO: This line of code loads data into the 'HelloSQLDataSet.firstTable' table. You can move, or remove it, as needed.
        Me.FirstTableTableAdapter.Fill(Me.HelloSQLDataSet.firstTable)
        'TODO: This line of code loads data into the 'HelloSQLDataSet.firstTable' table. You can move, or remove it, as needed.
        Me.FirstTableTableAdapter.Fill(Me.HelloSQLDataSet.firstTable)

    End Sub

    Private Sub FirstTableBindingSource_CurrentChanged_1(ByVal sender As System.Object, ByVal e As System.EventArgs)

    End Sub
End Class
