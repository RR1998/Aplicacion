using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using inventio_win;
using System.Windows.Forms;

namespace Proyecto.Proyecto.inventary_win
{
    public partial class MainMenu : Form
    {
        private class Item
        {
            public string Name;
            public int Value;
            public Item(string name, int value)
            {
                Name = name; Value = value;
            }
            public override string ToString()
            {
                // Generates the text shown in the combo box
                return Name;
            }
        }
        public MainMenu()
        {
            InitializeComponent();
        }

        private void MainMenu_Load(object sender, EventArgs e, string Usuario)
        {
            int Grade, ID;
            NombreUsuario.Text = Usuario;//puede cambiar para ser el nombre real del usuario o sol oel username
            Connection C = new Connection("","");//Cambiar usuario y pass solo de consulta en el switch de conexion
            ID = (C.GetInt("SELECT IDPusuario FROM USUARIO WHERE Usuario = \"" + Usuario + ",NOW()"));
            NUsuario.Text = ID.ToString();
            Grade = C.GetInt("SELECT Estrato FROM USUARIO WHERE IDUsuario = \"" + ID + ",NOW()");
            switch (Grade)
            {
                case (0):
                    Opciones.Items.Add(new Item (" Ver Productos", 1));
                    break;
                case (1):
                    Opciones.Items.Add(new Item ("Vender", 1));
                    Opciones.Items.Add(new Item ("Inventario", 2));
                    Opciones.Items.Add(new Item ("Ver Productos", 3));
                    break;
                case (2):
                    Opciones.Items.Add(new Item("Administrar",1));
                    Opciones.Items.Add(new Item("Vender", 2));
                    Opciones.Items.Add(new Item("Comprar", 3));
                    Opciones.Items.Add(new Item("Ver registro de ventas", 4));
                    Opciones.Items.Add(new Item("Ver registro de compras", 5));
                    Opciones.Items.Add(new Item("Inventario", 6));
                    Opciones.Items.Add(new Item("Ver productos", 7));
                    break;
                case (4):
                    Opciones.Items.Add(new Item("Administrar Usuarios", 1));
                    Opciones.Items.Add(new Item("Administrar", 2));
                    Opciones.Items.Add(new Item("Vender", 3));
                    Opciones.Items.Add(new Item("Comprar", 4));
                    Opciones.Items.Add(new Item("Ver registro de ventas", 5));
                    Opciones.Items.Add(new Item("Ver registro de compras", 6));
                    Opciones.Items.Add(new Item("Inventario", 7));
                    Opciones.Items.Add(new Item("Ver productos", 8));
                    break;
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void NombreUsuario_Click(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void NUsuario_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void Opciones_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void Aceptar_Click(object sender, EventArgs e)
        {
            Item Opcion = (Item)Opciones.SelectedItem;
            string Opc = Opcion.Name.ToString();
            switch (Opc)
            {
                case "Ver Productos":
                    //funcion para ver productos
                    break;
                case "Vender":
                    //funcion para vender
                    break;
                case "Comprar":
                    //funcion para comprar
                    break;
                case "Administrar Usuarios":
                    //Funcion para administrar usuarios
                    break;
                case "Administrar":
                    //Funcion para administrar
                    break;
                case "Ver registro de ventas":
                    //funcion para ver el registro de ventas
                    break;
                case "Ver registro de compras":
                    //funcion para ver el registro de ventas
                    break;
                case "Inventario":
                    break;
            }
        }

        private void Cancelar_Click(object sender, EventArgs e)
        {

        }

        private void Ayuda_Click(object sender, EventArgs e)
        {

        }
    }
}
