using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class q019
    {
        static void Main(string[] args)
        {
            string[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
            int startDay = 2; //1901 starts on tuesday
            int sundays = 0;
            for (int yr = 1901; yr < 2001; ++yr)
            {
                Console.Write(yr+": ");
                bool leapYr = ((yr%100==0) ?(yr%400==0):(yr%4==0));    
                for (int i = 0; i < 12; ++i)
                {
                    if (startDay == 0) ++sundays;
                    int daysInMnth = (i==3||i== 5||i==8||i==10)?30:((i==1)?((leapYr)?29:28):31);
                    int k = startDay + (daysInMnth % 7);
                    Console.Write(days[startDay].Substring(0, 2)+" ");
                    startDay = (k>6)?(k)-7:k;
                }
                Console.WriteLine();
            }
            Console.WriteLine("Sundays: " + sundays);
            Console.Read();
        }
    }

}
