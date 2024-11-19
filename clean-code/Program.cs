
using clean_code;

var cal = new Calculator();

decimal discount = cal.CalculateDiscount("Regular", 1020);
Console.WriteLine($"You pay $1020 , you get ${discount} dsicount");

    IPaymentCalculator regularCalc = new RegularPaymentCalculator();
    Console.WriteLine($"You pay $20018, you get discount ${regularCalc.CalculateDiscount(20018)}");

    IPaymentCalculator vipCalc = new VipPaymentCalculator();
    Console.WriteLine($"You pay $20018, you get discount ${regularCalc.CalculateDiscount(20018)}");

class Calculator
{
    public decimal CalculateDiscount(string customerType, decimal amount)
    {
        if (customerType == "Regular")
        {
            return amount * 0.1m;
        }
        else if (customerType == "VIP")
        {
            return amount * 0.2m;
        }
        else 
        {
            return 0;
        }
    }
}


//  After
