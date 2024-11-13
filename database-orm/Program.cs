using System;
using System.Linq;
using Microsoft.EntityFrameworkCore;
using Repo;

try
{
    using (var context = new MyInfoContext())
    {
        int clientId = 1;
        var myInfo = context.MyInfo
            .FirstOrDefault(info => info.Id == clientId);

        if (myInfo != null)
        {
            Console.WriteLine($"My fullname is {myInfo.FullName}, mobile number {myInfo.Mobile}");
        }
        else
        {
            Console.WriteLine("No record found.");
        }
    }
}
catch (Exception ex)
{
    Console.WriteLine(ex.Message);
}