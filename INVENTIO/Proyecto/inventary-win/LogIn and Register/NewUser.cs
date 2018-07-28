using inventio_win;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
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
            ToolTip Ayudatp = new ToolTip();
            Ayudatp.AutoPopDelay = 2000;
            Ayudatp.InitialDelay = 1000;
            Ayudatp.ReshowDelay = 500;
            Ayudatp.SetToolTip(Nombre, "Ingrese unicamente los nombres del usuario");
            Ayudatp.SetToolTip(Apellido, "Ingrese los apellidos del usuario");
            Ayudatp.SetToolTip(Email, "Ingrese el correo electronico del usuario");
            Ayudatp.SetToolTip(DUI, "Ingrese el DUI del usuario con el guion incluido");
            Ayudatp.SetToolTip(NIT, "Ingrese el NIT del usuario con el guion incluido");
            Ayudatp.SetToolTip(Telefono, "Ingrese el numero de telefono del usuario sin el codigo de país");
            Ayudatp.SetToolTip(User, "Ingrese el usuario que desea ocupar recuerde que este no debe poseer caraceres especiales como: \n" +
                "!@#$%^&*()_-+={}[]|\'';:?/>.<,");
            Ayudatp.SetToolTip(Password, "Ingrese la contraseña que desea utilizar en su usuario recuerde que no debe sobrepasar los 15 caracteres");
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
            string Nombretxt, Apellidotxt, Emailtxt, DUItxt, NITtxt, Telefonotxt, Usertxt, Passwordtxt;
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
            new MainMenu();
            this.Close();
        }

        private void Ayuda_Click(object sender, EventArgs e)
        {
            MessageBox.Show("1.Ingrese su nombre sin apellidos \n" +
                "2. Ingrese sus apellidos \n"+
                "3. Ingrese su correo electronico \n"+
                "4. Ingrese su DUI, con el guion \n" +
                "5. Ingrese su NIT, con los guiones \n"+
                "6. Ingrese su numero de telefono \n" +
                "7. Ingrese el Usuario que utilizara, no debe contener caracteres especiales como '!, @, #, $, %, ^, &, *, (, ), [, ], {, }, /, |, comillas dobles o simples \n'"+
                ":, ;, <, >, ., ? "+
                "8. Ingrese su contrasena, no debe tener mas de 15 caracteres, Ejemplo de contrasena: Contrasena1@#$| \n" +
                "si usted desea ingresar todos los datos presione el boton de aceptar, si quiere regresar al menu inicial precione cancelar", "Ayuda", MessageBoxButtons.OK, MessageBoxIcon.Question);
        }
        public void Registrar(string Nombre, string Apellido, string Email, string DUI, string NIT, string Telefono, string User, string Password)
        {
            int IDP;
            char Estrato = '0';
            var regexItem = new Regex("!@#$%^&*()_-+={}[]|\'';:?/>.<,");
            if (!regexItem.IsMatch(User))
            {
                Connection C = new Connection("Register", "");
                C.execute("INSERT INTO PERSONA (Nombres, Apellidos, Email, DUI, NIT, Telefono) value (\"" + Nombre + "\",\"" + Apellido + "\", \"" + Email + "\", \"" + DUI + "\", \"" + NIT + "\", \"" + Telefono + ",NOW())");
                IDP = C.GetInt("SELECT IDPersona FROM PERSONA WHERE DUI = \"" + DUI + ",NOW()");
                C.execute("INSERT INTO USUARIOS(IDPersona, Usuario, Password, Estrato) value(\"" + IDP + "\",\"" + User + "\", \"" + Password + "\", \"" + Estrato + ",NOW())");
                new MainMenu();
                this.Close();
            }
            else
            {
                MessageBox.Show("Su nombre de usuario no debe poseer ninguno de los siguientes caracteres: !@#$%^&*()_-+={}[]|\'';:?/>.<,", "Error", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }
    }
}
