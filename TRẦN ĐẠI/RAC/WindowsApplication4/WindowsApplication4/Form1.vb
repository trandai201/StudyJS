Public Class Form1

    Private Sub DateTimePicker1_ValueChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles DateTimePicker1.ValueChanged
        RichTextBox1.Text = DateTimePicker1.Value.Date.ToString
        PrintLine(
    End Sub
End Class
