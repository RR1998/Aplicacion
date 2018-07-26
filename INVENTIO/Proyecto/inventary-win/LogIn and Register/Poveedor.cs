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
    public partial class Proveedor : Form
    {
        public Proveedor()
        {
            InitializeComponent();
        }

        private void Nombre_TextChanged(object sender, EventArgs e)
        {

        }
        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void Proveedor_Load(object sender, EventArgs e)
        {

        }

        private void Aceptar_Click(object sender, EventArgs e)
        {
            string Nombretxt, Apellidotxt, Emailtxt, DUItxt, NITtxt, Telefonotxt, NumeroEmpresa, NumeroProducto;//Numero empresa = contribuyente
            Nombretxt = Nombre.Text;
            Apellidotxt = Apellido.Text;
            Emailtxt = Email.Text;
            DUItxt = DUI.Text;
            NITtxt = NIT.Text;
            Telefonotxt = Telefono.Text;
            NumeroEmpresa = Empresa.Text;
            NumeroProducto = NProducto.Text;
            Registrar(Nombretxt, Apellidotxt, Emailtxt, DUItxt, NITtxt, Telefonotxt, NumeroEmpresa, NumeroProducto);
        }

        private void Cancelar_Click(object sender, EventArgs e)
        {

        }

        private void Ayuda_Click(object sender, EventArgs e)
        {
            MessageBox.Show("1.Ingrese su nombre sin apellidos \n" +
                "2. Ingrese sus apellidos \n" +
                "3. Ingrese su correo electronico \n" +
                "4. Ingrese su DUI, con el guion \n" +
                "5. Ingrese su NIT, con los guiones \n" +
                "6. Ingrese su numero de telefono \n" +
                "7. Ingrese el numero de contribuyente de la empresa a la que perteneze, si no esta registrada puede hacerlo por medio del boton registrar empresa \n" +
                "8. Ingrese el numer de producto, si no esta registrad puede hacerlo por medio del boton registrar producto \n" +
                "si usted desea ingresar todos los datos presione el boton de aceptar, si quiere regresar al menu inicial precione cancelar", "Ayuda", MessageBoxButtons.OK, MessageBoxIcon.Question);
        }
        
        private void Registrar(string Nombre, string Apellido, string Email, string DUI, string NIT, string Telefono, string NumeroContribuyente, string NumeroProducto)
        {
            int IDPersona, IDProducto;
            var regexItem = new Regex("!@#$%^&*()_-+={}[]|\'';:?/>.<,");//regex se usa para validar caracteres especiales ams facil, ver newuser cs para detalles
            Connection C = new Connection("Register", "");
            C.execute("INSERT INTO PERSONA (Nombres, Apellidos, Email, DUI, NIT, Telefono) value (\"" + Nombre + "\",\"" + Apellido + "\", \"" + Email + "\", \"" + DUI + "\", \"" + NIT + "\", \"" + Telefono + ",NOW())");
            IDPersona = C.GetIDs("SELECT IDPersona FROM PERSONA WHERE DUI = \"" + DUI + ",NOW()");
            IDProducto = C.GetIDs("SELECT IDProducto FROM PRODUCTO WHERE IDProductoU = \"" + NumeroProducto + ",NOW()");
            C.execute("INSERT INTO PROVEEDOR(IDPersona, Usuario, Password) value(\"" + NumeroContribuyente + "\",\"" + IDPersona + "\", \"" + IDProducto + ",NOW())");
        }
    }
}
