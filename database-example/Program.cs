using MySql.Data.MySqlClient;

static MySqlConnection GetConnection(string db, string username, string password)
{
    var myConnectionString = $"server=127.0.0.1;uid={username};pwd={password};database={db}";

    var myConnection = new MySqlConnection(myConnectionString);
    return myConnection;
}

static MySqlCommand BuildDatabaseCommand(MySqlConnection myConnection, String Qry)
{
    MySqlCommand myCommand = new MySqlCommand();
    myCommand.Connection = myConnection;
    myCommand.CommandText = Qry;
    return myCommand;
}

static MySqlDataReader DoSometing(MySqlCommand myCommand)
{
    var myReader = myCommand.ExecuteReader();
    {
        while (myReader.Read())
        {
            var fullname = myReader.GetString("FULL_NAME");
            var mobile = myReader.GetString("mobile");
            Console.WriteLine($"My fullname is {fullname} , mobile number {mobile}");
        }
    }

    return myReader;
}

MySqlConnection? myConnection = null;
try
{
    myConnection = GetConnection("sweprofile", "sweelam", "sweelam_224466");
    myConnection.Open();

    string Qry = @"SELECT * FROM my_info WHERE id = @clientId;";
    var myCommand = BuildDatabaseCommand(myConnection, Qry);
    myCommand.Parameters.AddWithValue("@clientId", 1);

    MySqlDataReader myReader = DoSometing(myCommand);
}
catch (MySqlException ex)
{
    Console.WriteLine(ex);
} finally 
{
    myConnection?.Close();
}

