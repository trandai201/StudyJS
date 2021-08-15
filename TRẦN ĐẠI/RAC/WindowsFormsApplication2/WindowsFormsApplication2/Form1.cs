using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Xml;

namespace WindowsFormsApplication2
{

    public partial class Form1 : Form
    {
        System.Xml.XmlDocument doc = new System.Xml.XmlDocument();

        XmlNodeList bientoancuc;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            doc.Load("employees.xml");





        }

        private void buttonSearch_Click(object sender, EventArgs e)
        {
            try {

                if (radioButtonFisrtName.Checked == true)
                {
                    //chọn phần tử employee nào mà có firstname nào = <textbox1.Text>
                    //trả về các nút employee hợp lệ vào biến nodelist
                    bientoancuc = doc.SelectNodes("/employees/employee[./firstname/text() = '" + textBoxKeyWord.Text + "']");
                    richTextBoxNote.Text = bientoancuc.Count.ToString() + " " + textBoxKeyWord.Text;

                }
                // 
                //nếu chọn radio button "Họ"
                if (radioButtonLastName.Checked)
                {
                    //chọn phần tử employee nào có lastname nào = <textbox1.Text>
                    //trả về các nút employee hợp lệ vào biến nodelist

                    bientoancuc = doc.SelectNodes("/employees/employee[./lastname/text() = '" + textBoxKeyWord.Text + "']");
                    richTextBoxNote.Text = bientoancuc.Count.ToString() + " " + textBoxKeyWord.Text;

                }

                foreach (XmlNode node in bientoancuc)
                {

                    comboBoxID.Items.Add(node.Attributes["employeeid"].Value);
                }
            }
            catch { }
            
         
        }

        private void buttonGetInfo_Click(object sender, EventArgs e)
        {

            //label FirstName = giá trị nằm giữa cặp tag <firstname>...</firstname>
            labelFirstName.Text =
           bientoancuc[comboBoxID.SelectedIndex].ChildNodes[0].InnerText;
            //label LastName = giá trị nằm giữa cặp tag <lastname>...</lastname>
            labelLastName.Text =
           bientoancuc[comboBoxID.SelectedIndex].ChildNodes[1].InnerText;
            //label HomePhone = giá trị nằm giữa cặp tag <homephone>...</homephone>
            labelPhone.Text =
         bientoancuc[comboBoxID.SelectedIndex].ChildNodes[2].InnerText;
            //label notes = giá trị nằm giữa cặp tag <notes>...</notes>
            richTextBoxNote.Text =
     bientoancuc[comboBoxID.SelectedIndex].ChildNodes[3].Value;



        }




    }
}
