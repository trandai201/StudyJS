Partial Class HelloSQLDataSet
    Partial Class firstTableDataTable

        Private Sub firstTableDataTable_ColumnChanging(ByVal sender As System.Object, ByVal e As System.Data.DataColumnChangeEventArgs) Handles Me.ColumnChanging
            If (e.Column.ColumnName = Me.idColumn.ColumnName) Then
                'Add user code here
            End If

        End Sub

        Private Sub firstTableDataTable_firstTableRowChanging(ByVal sender As System.Object, ByVal e As firstTableRowChangeEvent) Handles Me.firstTableRowChanging

        End Sub

    End Class

End Class

Namespace HelloSQLDataSetTableAdapters

    Partial Public Class firstTableTableAdapter
    End Class
End Namespace
