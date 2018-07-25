using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data.MySqlClient;
using System.Windows.Forms;

namespace inventio_win{
    class Connection{
        public MySqlConnection con;
        public long insert_id;
        public Connection(String User, String Password) {
            switch (User) {
                //Cambiar para que el case lo haga por el usuario buscando en la base no por el dato quemado
                case ("Admin"):
                    Coneccion(User, Password);
                    break;
                case ("Usuario"):
                    Coneccion(User, Password);
                    break;
                default:
                    MessageBox.Show("El usuario" + User + "No esta registrado");
                    break;
            } 
        }

        public void execute(String sql){
            MySqlCommand cmd = this.con.CreateCommand();
            cmd.CommandText = sql;
            this.con.Open();
            cmd.ExecuteNonQuery();
            this.con.Close();
            this.insert_id = cmd.LastInsertedId;
        }
        public void Coneccion(String User, String Password){
            try
            {
                MySqlConnectionStringBuilder b = new MySqlConnectionStringBuilder();
                b.Server = "localhost";
                b.UserID = User;//usuario que tenes registrado en tu base de datos mysql, no vayas a ocupar xampp que no sirve
                b.Password = Password;//contrasenia que le pusiste a la base de datos de mysql
                b.Database = "Proyecto";
                con = new MySqlConnection(b.ToString());
            }
            catch (MySqlException me)
            {
                MessageBox.Show(me.Message);
            }
        }
    }
}
