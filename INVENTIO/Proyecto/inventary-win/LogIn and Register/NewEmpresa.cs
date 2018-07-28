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
    public partial class NewEmpresa : Form
    {
        public NewEmpresa()
        {
            InitializeComponent();
        }

        private void NewEmpresa_Load(object sender, EventArgs e)
        {
            ToolTip Ayudatp = new ToolTip();
            Ayudatp.AutoPopDelay = 2000;
            Ayudatp.InitialDelay = 1000;
            Ayudatp.ReshowDelay = 500;
            Ayudatp.SetToolTip(NombreEmpresa, "Ingrese el nombre de la empresa");
            Ayudatp.SetToolTip(NIT, "Ingrese el NIT de la empresa con los guiones ingluidos");
            Ayudatp.SetToolTip(Direccion, "Ingrese la direccion completa de la empresa");
            Ayudatp.SetToolTip(Telefono, "Ingrese el telefono de la empresa");
            Ayudatp.SetToolTip(NContribuyente, "Ingrese el numero de contribuyente de la empresa");
        }

        private void Aceptar_Click(object sender, EventArgs e)
        {
            string Nombretxt, NITtxt, Direcciontxt, Telefonotxt, NContribuyentetxt;
            Nombretxt = NombreEmpresa.Text;
            NITtxt = NIT.Text;
            Direcciontxt = Direccion.Text;
            Telefonotxt = Telefono.Text;
            NContribuyentetxt = NContribuyente.Text;
            Registrar(Nombretxt, NITtxt, Direcciontxt, Telefonotxt, NContribuyentetxt);
        }

        private void Ayuda_Click(object sender, EventArgs e)
        {
            MessageBox.Show("1. Ingrese el nombre de la empresa \n" +
                "2. Ingrese el NIT de la empresa con los respectivos guiones \n" +
                "3. Igrese el numero de telefono de la empresa \n" +
                "4. Ingrese el numero de contribuyente de la empresa con los respectivos guiones");
        }

        private void Cancelar_Click(object sender, EventArgs e)
        {
            this.Close();
            //Funcion para abrir el menu inicial de nuevo
        }

        private void Registrar(string Nombre, string NIT, string Direccion, string Telefono, string NContribuyente)
        {
            var regexItem = new Regex("!@#$%^&*()_-+={}[]|\'';:?/>.<,");
            if (!regexItem.IsMatch(Nombre)) { 
                Connection C = new Connection("Register", "");
                C.execute("INSERT INTO EMPRESA (Nombre, NIT, Direccion, Telefono, NumeroContribuyente) VALUE(\"" + Nombre + "\",\"" + NIT + "\", \"" + Direccion + "\", \"" + Telefono + "\",\"" + NContribuyente + "\", NOW())");
                new MainMenu();
                this.Close();
            }
            else
            {
                MessageBox.Show("El nombre de la empresa no debe contener caracteres especiales como: !@#$%^&*()_-+={}[]|\'';:?/>.<,", "Error", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }
    }
}
