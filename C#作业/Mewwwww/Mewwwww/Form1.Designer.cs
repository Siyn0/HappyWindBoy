namespace Mewwwww
{
    partial class Home
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Home));
            this.CatName = new System.Windows.Forms.Label();
            this.More = new System.Windows.Forms.Button();
            this.Say = new System.Windows.Forms.TextBox();
            this.Send = new System.Windows.Forms.Button();
            this.ChatList = new System.Windows.Forms.RichTextBox();
            this.SuspendLayout();
            // 
            // CatName
            // 
            this.CatName.AutoSize = true;
            this.CatName.Font = new System.Drawing.Font("黑体", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.CatName.ForeColor = System.Drawing.Color.Black;
            this.CatName.Location = new System.Drawing.Point(3, 9);
            this.CatName.Name = "CatName";
            this.CatName.Size = new System.Drawing.Size(118, 24);
            this.CatName.TabIndex = 0;
            this.CatName.Text = "< Mewwwww";
            // 
            // More
            // 
            this.More.FlatAppearance.BorderSize = 0;
            this.More.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Gray;
            this.More.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Silver;
            this.More.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.More.Font = new System.Drawing.Font("黑体", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.More.ForeColor = System.Drawing.Color.Black;
            this.More.Location = new System.Drawing.Point(306, 3);
            this.More.Name = "More";
            this.More.Size = new System.Drawing.Size(40, 36);
            this.More.TabIndex = 1;
            this.More.Text = "…";
            this.More.UseVisualStyleBackColor = true;
            // 
            // Say
            // 
            this.Say.AcceptsReturn = true;
            this.Say.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(224)))), ((int)(((byte)(224)))), ((int)(((byte)(224)))));
            this.Say.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Say.Location = new System.Drawing.Point(26, 502);
            this.Say.MaxLength = 300;
            this.Say.MinimumSize = new System.Drawing.Size(250, 40);
            this.Say.Multiline = true;
            this.Say.Name = "Say";
            this.Say.Size = new System.Drawing.Size(250, 40);
            this.Say.TabIndex = 0;
            // 
            // Send
            // 
            this.Send.BackColor = System.Drawing.Color.LightGray;
            this.Send.FlatAppearance.BorderSize = 0;
            this.Send.FlatAppearance.MouseDownBackColor = System.Drawing.Color.Gray;
            this.Send.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Silver;
            this.Send.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.Send.Font = new System.Drawing.Font("黑体", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.Send.ForeColor = System.Drawing.Color.Black;
            this.Send.Location = new System.Drawing.Point(284, 502);
            this.Send.Name = "Send";
            this.Send.Size = new System.Drawing.Size(62, 40);
            this.Send.TabIndex = 1;
            this.Send.Text = "发送";
            this.Send.UseVisualStyleBackColor = false;
            this.Send.Click += new System.EventHandler(this.Send_Click);
            // 
            // ChatList
            // 
            this.ChatList.AcceptsTab = true;
            this.ChatList.BackColor = System.Drawing.Color.Silver;
            this.ChatList.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.ChatList.CausesValidation = false;
            this.ChatList.Font = new System.Drawing.Font("微软雅黑", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.ChatList.Location = new System.Drawing.Point(26, 42);
            this.ChatList.MaximumSize = new System.Drawing.Size(320, 436);
            this.ChatList.MinimumSize = new System.Drawing.Size(320, 436);
            this.ChatList.Name = "ChatList";
            this.ChatList.ReadOnly = true;
            this.ChatList.ScrollBars = System.Windows.Forms.RichTextBoxScrollBars.Vertical;
            this.ChatList.Size = new System.Drawing.Size(320, 436);
            this.ChatList.TabIndex = 2;
            this.ChatList.Text = "";
            // 
            // Home
            // 
            this.AcceptButton = this.Send;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.Silver;
            this.ClientSize = new System.Drawing.Size(352, 551);
            this.Controls.Add(this.ChatList);
            this.Controls.Add(this.Send);
            this.Controls.Add(this.Say);
            this.Controls.Add(this.More);
            this.Controls.Add(this.CatName);
            this.ForeColor = System.Drawing.SystemColors.Window;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Home";
            this.RightToLeftLayout = true;
            this.Text = "Mewwwww🐈";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label CatName;
        private System.Windows.Forms.Button More;
        private System.Windows.Forms.TextBox Say;
        private System.Windows.Forms.Button Send;
        private System.Windows.Forms.RichTextBox ChatList;
    }
}