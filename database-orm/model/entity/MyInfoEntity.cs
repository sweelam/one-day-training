using System.ComponentModel.DataAnnotations.Schema;

namespace Entity
{
    [Table("my_info")]
    public class MyInfoEntity
    {
        [Column("id")]
        public int Id { set; get; }
        [Column("full_name")]
        public string FullName { set; get; }
        [Column("mobile")]
        public string Mobile { set; get; }
        [Column("job_title")]
        public string JobTitle { set; get; }
        [Column("address")]
        public string Address { set; get; }
    }
}