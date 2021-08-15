<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form3
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Dim ReportDataSource1 As Microsoft.Reporting.WinForms.ReportDataSource = New Microsoft.Reporting.WinForms.ReportDataSource()
        Me.table_ThuaDat1BindingSource = New System.Windows.Forms.BindingSource(Me.components)
        Me.QuanLiDatDataSet = New WindowsApplication3.QuanLiDatDataSet()
        Me.table_ThuaDatBindingSource = New System.Windows.Forms.BindingSource(Me.components)
        Me.DataSet1 = New WindowsApplication3.DataSet1()
        Me.ReportViewer1 = New Microsoft.Reporting.WinForms.ReportViewer()
        Me.table_ThuaDat1TableAdapter = New WindowsApplication3.QuanLiDatDataSetTableAdapters.table_ThuaDat1TableAdapter()
        Me.Label1 = New System.Windows.Forms.Label()
        CType(Me.table_ThuaDat1BindingSource, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.QuanLiDatDataSet, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.table_ThuaDatBindingSource, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataSet1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'table_ThuaDat1BindingSource
        '
        Me.table_ThuaDat1BindingSource.DataMember = "table_ThuaDat1"
        Me.table_ThuaDat1BindingSource.DataSource = Me.QuanLiDatDataSet
        '
        'QuanLiDatDataSet
        '
        Me.QuanLiDatDataSet.DataSetName = "QuanLiDatDataSet"
        Me.QuanLiDatDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema
        '
        'table_ThuaDatBindingSource
        '
        Me.table_ThuaDatBindingSource.DataMember = "table_ThuaDat"
        Me.table_ThuaDatBindingSource.DataSource = Me.DataSet1
        '
        'DataSet1
        '
        Me.DataSet1.DataSetName = "DataSet1"
        Me.DataSet1.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema
        '
        'ReportViewer1
        '
        ReportDataSource1.Name = "DataSet1"
        ReportDataSource1.Value = Me.table_ThuaDat1BindingSource
        Me.ReportViewer1.LocalReport.DataSources.Add(ReportDataSource1)
        Me.ReportViewer1.LocalReport.ReportEmbeddedResource = "WindowsApplication3.Report1.rdlc"
        Me.ReportViewer1.Location = New System.Drawing.Point(12, 93)
        Me.ReportViewer1.Name = "ReportViewer1"
        Me.ReportViewer1.Size = New System.Drawing.Size(898, 497)
        Me.ReportViewer1.TabIndex = 0
        '
        'table_ThuaDat1TableAdapter
        '
        Me.table_ThuaDat1TableAdapter.ClearBeforeFill = True
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Font = New System.Drawing.Font("Microsoft Sans Serif", 20.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.ForeColor = System.Drawing.Color.FromArgb(CType(CType(192, Byte), Integer), CType(CType(0, Byte), Integer), CType(CType(0, Byte), Integer))
        Me.Label1.Location = New System.Drawing.Point(270, 9)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(329, 31)
        Me.Label1.TabIndex = 1
        Me.Label1.Text = "Báo Cáo Theo Tìm Kiếm"
        '
        'Form3
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(922, 602)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.ReportViewer1)
        Me.Name = "Form3"
        Me.Text = "Đại_34_Nhóm 8"
        CType(Me.table_ThuaDat1BindingSource, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.QuanLiDatDataSet, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.table_ThuaDatBindingSource, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataSet1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents ReportViewer1 As Microsoft.Reporting.WinForms.ReportViewer
    Friend WithEvents table_ThuaDatBindingSource As System.Windows.Forms.BindingSource
    Friend WithEvents DataSet1 As WindowsApplication3.DataSet1
    Friend WithEvents table_ThuaDat1BindingSource As System.Windows.Forms.BindingSource
    Friend WithEvents QuanLiDatDataSet As WindowsApplication3.QuanLiDatDataSet
    Friend WithEvents table_ThuaDat1TableAdapter As WindowsApplication3.QuanLiDatDataSetTableAdapters.table_ThuaDat1TableAdapter
    Friend WithEvents Label1 As System.Windows.Forms.Label
End Class
