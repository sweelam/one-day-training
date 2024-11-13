using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Logging; 
using System;
using Entity;

namespace Repo
{
    public class MyInfoContext : DbContext
    {
        public DbSet<MyInfoEntity> MyInfo { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            var connectionString = "server=127.0.0.1;uid=sweelam;pwd=sweelam_224466;database=sweprofile";
            optionsBuilder.UseMySql(connectionString, ServerVersion.AutoDetect(connectionString))
            .LogTo(Console.WriteLine, LogLevel.Information)
            .EnableDetailedErrors();
        }
    }
}
