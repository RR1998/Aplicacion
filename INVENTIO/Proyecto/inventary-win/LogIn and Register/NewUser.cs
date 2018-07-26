using inventio_win;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto.Proyecto.inventary_win.LogIn_and_Register
{
    public partial class Registro : Form
    {
        public Registro()
        {
            InitializeComponent();
        }

        private void NewUser_Load(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void Nombre_TextChanged(object sender, EventArgs e)
        {
        }

        private void Apellido_TextChanged(object sender, EventArgs e)
        {
        }

        private void Email_TextChanged(object sender, EventArgs e)
        {
        }

        private void DUI_TextChanged(object sender, EventArgs e)
        {
        }

        private void NIT_TextChanged(object sender, EventArgs e)
        {
        }

        private void Telefono_TextChanged(object sender, EventArgs e)
        {
        }

        private void User_TextChanged(object sender, EventArgs e)
        {
        }

        private void Password_TextChanged(object sender, EventArgs e)
        {
        }

        private void Aceptar_Click(object sender, EventArgs e)
        {
            String Nombretxt, Apellidotxt, Emailtxt, DUItxt, NITtxt, Telefonotxt, Usertxt, Passwordtxt;
            Nombretxt = Nombre.Text;
            Apellidotxt = Apellido.Text;
            Emailtxt = Email.Text;
            DUItxt = DUI.Text;
            NITtxt = NIT.Text;
            Telefonotxt = Telefono.Text;
            Usertxt = User.Text;
            Passwordtxt = Password.Text;
            Registrar(Nombretxt, Apellidotxt, Emailtxt, DUItxt, NITtxt, Telefonotxt, Usertxt, Passwordtxt);
        }

        private void Cancelar_Click(object sender, EventArgs e)
        {
            
        }

        private void Ayuda_Click(object sender, EventArgs e)
        {
            
        }
        public void Registrar(String Nombre, String Apellido, String Email, String DUI, String NIT, String Telefono, String User, String Password)
        {
            int IDP;
            Connection C = new Connection("Register", "");
            C.execute("INSERT INTO PERSONA (Nombres, Apellidos, Email, DUI, NIT, Telefono) value (\"" + Nombre + "\",\"" + Apellido + "\", \"" + Email + "\", \"" + DUI + "\", \"" + NIT + "\", \"" + Telefono + ",NOW())");
            IDP = C.GetIDs("SELECT IDPersona FROM PERSONA WHERE Telefono = \"" + Telefono + ",NOW()");
            C.execute("INSERT INTO USUARIOS(IDPersona, Usuario, Password) value(\"" + IDP + "\",\"" + User + "\", \"" + Password + ",NOW())");
        }
    }
}
