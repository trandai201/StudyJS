using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using System.Xml;
using System.IO;
namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {
            //XDocument xDoc = new XDocument(new XDeclaration("1.0","UTF-8","yes"),new XComment("Thoong tin Level"),
            //    new XElement("Levels",
            //        new XElement("level",
            //            new XAttribute("levelIndex",1),
            //            new XElement("Imagepath","Gril.jpg"),
            //            new XElement("Rows",3),
            //            new XElement("Clos",3)
         
            //    )));
            //xDoc.Save("new.xml");

            XDocument XDoc = XDocument.Load("new.xml");


            foreach (XElement e in XDoc.Descendants("level"))
            {
             //   if (e.Attribute("levelIndex").Value.ToString().Equals("1"))
                {
                    e.Element("Imagepath").Value = "dai.jpg";

                }
            }
            Console.Read();
            XDoc.Save("new1.xml");
         
        }
    }
}
