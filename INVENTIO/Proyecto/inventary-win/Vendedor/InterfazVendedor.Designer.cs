namespace Proyecto.Proyecto.inventary_win
{
    partial class InterfazVendedor
    {
        /// <summary> 
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.Nombres = new System.Windows.Forms.MaskedTextBox();
            this.NombreL = new System.Windows.Forms.Label();
            this.ApellidosL = new System.Windows.Forms.Label();
            this.Apellidos = new System.Windows.Forms.TextBox();
            this.Telefono = new System.Windows.Forms.TextBox();
            this.TelefonoL = new System.Windows.Forms.Label();
            this.DUIL = new System.Windows.Forms.Label();
            this.NITL = new System.Windows.Forms.Label();
            this.EmpresaL = new System.Windows.Forms.Label();
            this.DUI = new System.Windows.Forms.TextBox();
            this.NIT = new System.Windows.Forms.TextBox();
            this.Empresa = new System.Windows.Forms.TextBox();
            this.AgregarEmpresa = new System.Windows.Forms.Button();
            this.AgregarVenta = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Nombres
            // 
            this.Nombres.Location = new System.Drawing.Point(51, 38);
            this.Nombres.Name = "Nombres";
            this.Nombres.Size = new System.Drawing.Size(153, 20);
            this.Nombres.TabIndex = 0;
            // 
            // NombreL
            // 
            this.NombreL.AutoSize = true;
            this.NombreL.Location = new System.Drawing.Point(51, 19);
            this.NombreL.Name = "NombreL";
            this.NombreL.Size = new System.Drawing.Size(49, 13);
            this.NombreL.TabIndex = 1;
            this.NombreL.Text = "Nombres";
            this.NombreL.Click += new System.EventHandler(this.label1_Click);
            // 
            // ApellidosL
            // 
            this.ApellidosL.AutoSize = true;
            this.ApellidosL.Location = new System.Drawing.Point(227, 19);
            this.ApellidosL.Name = "ApellidosL";
            this.ApellidosL.Size = new System.Drawing.Size(49, 13);
            this.ApellidosL.TabIndex = 2;
            this.ApellidosL.Text = "Apellidos";
            // 
            // Apellidos
            // 
            this.Apellidos.Location = new System.Drawing.Point(221, 38);
            this.Apellidos.Name = "Apellidos";
            this.Apellidos.Size = new System.Drawing.Size(150, 20);
            this.Apellidos.TabIndex = 3;
            // 
            // Telefono
            // 
            this.Telefono.Location = new System.Drawing.Point(51, 137);
            this.Telefono.Name = "Telefono";
            this.Telefono.Size = new System.Drawing.Size(100, 20);
            this.Telefono.TabIndex = 4;
            // 
            // TelefonoL
            // 
            this.TelefonoL.AutoSize = true;
            this.TelefonoL.Location = new System.Drawing.Point(51, 121);
            this.TelefonoL.Name = "TelefonoL";
            this.TelefonoL.Size = new System.Drawing.Size(49, 13);
            this.TelefonoL.TabIndex = 5;
            this.TelefonoL.Text = "Telefono";
            // 
            // DUIL
            // 
            this.DUIL.AutoSize = true;
            this.DUIL.Location = new System.Drawing.Point(51, 72);
            this.DUIL.Name = "DUIL";
            this.DUIL.Size = new System.Drawing.Size(26, 13);
            this.DUIL.TabIndex = 6;
            this.DUIL.Text = "DUI";
            // 
            // NITL
            // 
            this.NITL.AutoSize = true;
            this.NITL.Location = new System.Drawing.Point(169, 72);
            this.NITL.Name = "NITL";
            this.NITL.Size = new System.Drawing.Size(25, 13);
            this.NITL.TabIndex = 7;
            this.NITL.Text = "NIT";
            this.NITL.Click += new System.EventHandler(this.label5_Click);
            // 
            // EmpresaL
            // 
            this.EmpresaL.AutoSize = true;
            this.EmpresaL.Location = new System.Drawing.Point(169, 121);
            this.EmpresaL.Name = "EmpresaL";
            this.EmpresaL.Size = new System.Drawing.Size(114, 13);
            this.EmpresaL.TabIndex = 8;
            this.EmpresaL.Text = "Numero de la Empresa";
            this.EmpresaL.Click += new System.EventHandler(this.label6_Click);
            // 
            // DUI
            // 
            this.DUI.Location = new System.Drawing.Point(51, 88);
            this.DUI.Name = "DUI";
            this.DUI.Size = new System.Drawing.Size(100, 20);
            this.DUI.TabIndex = 9;
            // 
            // NIT
            // 
            this.NIT.Location = new System.Drawing.Point(172, 88);
            this.NIT.Name = "NIT";
            this.NIT.Size = new System.Drawing.Size(100, 20);
            this.NIT.TabIndex = 10;
            // 
            // Empresa
            // 
            this.Empresa.Location = new System.Drawing.Point(172, 137);
            this.Empresa.Name = "Empresa";
            this.Empresa.Size = new System.Drawing.Size(100, 20);
            this.Empresa.TabIndex = 11;
            // 
            // AgregarEmpresa
            // 
            this.AgregarEmpresa.Location = new System.Drawing.Point(292, 137);
            this.AgregarEmpresa.Name = "AgregarEmpresa";
            this.AgregarEmpresa.Size = new System.Drawing.Size(97, 23);
            this.AgregarEmpresa.TabIndex = 12;
            this.AgregarEmpresa.Text = "Agregar Empresa";
            this.AgregarEmpresa.UseVisualStyleBackColor = true;
            this.AgregarEmpresa.Click += new System.EventHandler(this.AgregarEmpresa_Click);
            // 
            // AgregarVenta
            // 
            this.AgregarVenta.Location = new System.Drawing.Point(292, 85);
            this.AgregarVenta.Name = "AgregarVenta";
            this.AgregarVenta.Size = new System.Drawing.Size(97, 23);
            this.AgregarVenta.TabIndex = 13;
            this.AgregarVenta.Text = "Agregar cliente";
            this.AgregarVenta.UseVisualStyleBackColor = true;
            this.AgregarVenta.Click += new System.EventHandler(this.button1_Click);
            // 
            // InterfazVendedor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.AgregarVenta);
            this.Controls.Add(this.AgregarEmpresa);
            this.Controls.Add(this.Empresa);
            this.Controls.Add(this.NIT);
            this.Controls.Add(this.DUI);
            this.Controls.Add(this.EmpresaL);
            this.Controls.Add(this.NITL);
            this.Controls.Add(this.DUIL);
            this.Controls.Add(this.TelefonoL);
            this.Controls.Add(this.Telefono);
            this.Controls.Add(this.Apellidos);
            this.Controls.Add(this.ApellidosL);
            this.Controls.Add(this.NombreL);
            this.Controls.Add(this.Nombres);
            this.Name = "InterfazVendedor";
            this.Size = new System.Drawing.Size(424, 207);
            this.Load += new System.EventHandler(this.InterfazVendedor_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MaskedTextBox Nombres;
        private System.Windows.Forms.Label NombreL;
        private System.Windows.Forms.Label ApellidosL;
        private System.Windows.Forms.TextBox Apellidos;
        private System.Windows.Forms.TextBox Telefono;
        private System.Windows.Forms.Label TelefonoL;
        private System.Windows.Forms.Label DUIL;
        private System.Windows.Forms.Label NITL;
        private System.Windows.Forms.Label EmpresaL;
        private System.Windows.Forms.TextBox DUI;
        private System.Windows.Forms.TextBox NIT;
        private System.Windows.Forms.TextBox Empresa;
        private System.Windows.Forms.Button AgregarEmpresa;
        private System.Windows.Forms.Button AgregarVenta;
    }
}
