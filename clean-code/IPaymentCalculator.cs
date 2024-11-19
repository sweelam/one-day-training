namespace clean_code
{
    public interface IPaymentCalculator
    {
        public decimal CalculateDiscount( decimal amount);
    }

    public class RegularPaymentCalculator : IPaymentCalculator
    {
        public decimal CalculateDiscount(decimal amount)
        {
            return amount * 0.1m;
        }
    }

    public class VipPaymentCalculator : IPaymentCalculator
    {
        public decimal CalculateDiscount(decimal amount)
        {
            return amount * 0.2m;
        }
    }
}

