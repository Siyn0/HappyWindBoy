using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;
using Newtonsoft.Json;
using System.IO;
using System.Net;

namespace Mewwwww
{
    public partial class Home : Form
    {

        [STAThread]
        public static void Main()
        {
            Application.Run(new Home());
        }

        public Home()
        {
            InitializeComponent();
            ChatUpdateCat("你好呀。我叫Mew，我是一只小傻猫~\n你叫什么名字呢？");
        }

        //载入图像（猫头像）
        //Bitmap Head = new Bitmap("Images/Cat/ChatHead.bmp");
        const String KEY = "98373f587e7b4ae4be9d34d1d580dcc3";
        Encoding encoding = Encoding.GetEncoding("utf-8");


        public static string HttpGet(string url, Encoding encoding)
        {
            string data = "";
            try
            {
                WebRequest request; //使用url发出请求的类
                request = WebRequest.Create(url);
                request.Credentials = CredentialCache.DefaultCredentials;   //使用默认的身份验证
                request.Timeout = 10000;    //设定超时
                WebResponse response;   //提供响应的类
                response = request.GetResponse();
                data = new StreamReader(response.GetResponseStream(), encoding).ReadToEnd();    //获取数据
            }
            catch (System.Exception e)
            {
                Console.WriteLine(e.Message);
            }

            return data;
        }

        class Player
        {
            public string Name = "铲屎官";
            public bool isName = false;
            public bool isStart = false;
        }

        Player Player0 = new Player();

        //点击发送
        private void Send_Click(object sender, EventArgs e)
        {
            ChatList.Text += "\n\n" + Player0.Name + ": " + Say.Text;
            if (!Player0.isName)
            {
                Player0.isStart = true;
                Player0.isName = true;
                Player0.Name = Say.Text;
                ChatUpdateCat("好的~以后可以叫你" + Player0.Name + "了喵~");
            }
            else if (Say.Text == "空明杖是小弱受！")
                ChatUpdateCat("赞同+1哟！喵喵喵w");
            //else
            //ChatUpdateCat("目前只能识别两句话呀，体谅一下萌新开发者喵www");
            else
            {
                string url = "http://www.tuling123.com/openapi/api?key=" + KEY + "&info=" + Say.Text;
                String data = HttpGet(url, encoding);
                JsonReader reader = new JsonTextReader(new StringReader(data));
                while (reader.Read())
                {
                    //ChatList.AppendText(reader.TokenType + "\t\t" + reader.ValueType + "\t\t" + reader.Value + "\n");
                    if (reader.TokenType == JsonToken.PropertyName
                    && reader.ValueType == Type.GetType("System.String")
                    && Convert.ToString(reader.Value) == "code")
                    {
                        /* 如果当前Value是code，读取下一条，查看code的值 */
                        reader.Read();
                        switch (Convert.ToInt32(reader.Value))
                        {
                            case 100000:
                                /* 返回码为文本类数据 */
                                reader.Read();
                                reader.Read();
                                ChatUpdateCat((string)reader.Value);
                                break;
                            default:
                                ChatUpdateCat("暂时无法读取的消息类型，试试聊点别的喵w");
                                break;
                        }
                    }
                }
            }
            ToDown();
            Say.Text = "";
        }

        //显示猫猫的话
        private void ChatUpdateCat(string Said)
        {
            //CatName.Text = "< 对方正在输入...";
            //Thread.Sleep(1500);    //TO DO: 这样写会导致整个程序休眠
            //CatName.Text = "< Mewwwww";
            ChatList.Text += "\n\n";
            //Clipboard.SetDataObject(Head, false);
            // ChatList.Paste();    //TO DO：没有做出来QAQ，头像在剪贴板里，但是没有显示
            ChatList.Text += "Mew: ";
            //ChatList.Select(ChatList.TextLength-5, 5);
            //ChatList.SelectionColor = Color.Blue;    //TO DO: 为什么改不了颜色呢？？？
            //ChatList.Select(ChatList.TextLength, 0);
            ChatList.Text += Said;
        }

        //自动到底部
        private void ToDown()
        {
            ChatList.Focus();    //获取焦点
            ChatList.Select(ChatList.TextLength, 0);    //光标定位到文本最后
            ChatList.ScrollToCaret();    //滚动到光标处
            Say.Focus();
        }

        //TO DO:气泡聊天。可能用到：右对齐：ChatList.SelectionAlignment = HorizontalAlignment.Center;
    }
}
