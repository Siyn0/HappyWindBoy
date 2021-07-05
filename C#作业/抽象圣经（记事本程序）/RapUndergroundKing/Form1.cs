using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Collections.Specialized;
using System.IO;

namespace RapUndergroundKing
{
    public partial class MainForm : Form
    {
        private string filename = "Untitled";
        public MainForm(string filename)
        {
            InitializeComponent();
            if(filename != null)
            {
                this.filename = filename;
                OpenFile();
            }
        }


        private void 新建ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            TBox.Text = "";
        }

        private void 打开ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(dialogOpenFile.ShowDialog() == DialogResult.OK)
            {
                filename = dialogOpenFile.FileName;
                OpenFile();
            }
            
        }

        private void 保存ToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            SaveFileDialog SaveData = new SaveFileDialog();
            SaveData.InitialDirectory = @"C:\";
            SaveData.Filter = "txt文件(*.txt)|*.txt";
            string TextName = "";

            SaveData.FileName = "New";
            if (SaveData.ShowDialog() == DialogResult.OK)
            {
                TextName = SaveData.FileName;
            }
            StreamWriter sw = new StreamWriter(SaveData.FileName);
            sw.WriteLine(TBox.Text);
            sw.Close();
        }

        private void 退出ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        protected void OpenFile()
        {
            try
            {
                TBox.Clear();
                TBox.Text = File.ReadAllText(filename);
            }
            catch(IOException ex)
            {
                MessageBox.Show(ex.Message, "Simple Editor", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        private void 帮助ToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("没错，就这么点功能了。如想体验全部记事本功能请充值会员，仅需5毛/秒！","开发者：z"); 
        }


        private void 字体ToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            if (fontDialog1.ShowDialog() == DialogResult.OK)
            {
                TBox.SelectionFont = fontDialog1.Font;
                TBox.SelectionColor = fontDialog1.Color;
            }
        }

    }
}
