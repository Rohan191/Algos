import java.util.*;
class Booths1
{
	int m,q,q_1=0,a=0,c,t;

	void table(int x)
	{
		int i=(new Integer(5).toBinaryString(a)).length();
		if(i>t)
			System.out.print((new Integer(5).toBinaryString(a)).substring(i-t)+"\t");
		else	
			display(a);
		
		i=(new Integer(5).toBinaryString(q)).length();
		if(i>t)
			System.out.print((new Integer(5).toBinaryString(q)).substring(i-t)+"\t");
		else	
			display(q);
		
		System.out.print(q_1+"\t");
		display(m);
		if(x==1)
			System.out.println(c+"\tA=A+M");
		if(x==2)
			System.out.println(c+"\tSubtract(A=A-M)");
		if(x==3)
		{
			System.out.println(c+"\tRight Shift");
			System.out.println("____________________________________________________________");
		}
		if(x==4)
			System.out.println(c+"\tIntial Value");
	}

	void display(int n)
	{
		for(int i=0;i<t-(new Integer(4).toBinaryString(n)).length();i++)
			System.out.print("0");
		System.out.print(new Integer(4).toBinaryString(n)+"\t");
	}


	void getdata()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the multiplicand.(0-127) ");
		m=s.nextInt();
		System.out.println("Enter the multiplier.(0-127) ");
		q=s.nextInt();
	}

	void execute()
	{
		int flag=0,temp1, temp2;
		if(((new Integer(5).toBinaryString(q)).length()>4)||((new Integer(5).toBinaryString(m)).length()>4))
			c=8;
		else
			c=4;
		t=c;
		if(t==8)
			System.out.println("A\t\tQ\t\tQ_1\t\tM\tC");
		else
			System.out.println("A\tQ\tQ_1\tM\tC");
		System.out.println("____________________________________________________________");
		table(4);
		System.out.println("____________________________________________________________");
		do
		{
			if((q%2==0)&&(q_1==1))
			{
				a=a+m;
				table(1);
			}
			else if((q%2==1)&&(q_1==0))
			{
				a=a-m;
				table(2);
			}
		
			if(q%2==1)
				q_1=1;
			else
				q_1=0;
			temp1=a;
			temp2=q;
			
			a=a>>1;
			q=q>>1;
			if(temp1>=Math.pow(2,t-1))
				a=a+(int ) Math.pow(2,t-1);	
			if(temp1%2!=0)
				q=q+(int ) Math.pow(2,t-1);
			table(3);
			c--;
		}while(c!=0);
	}
}				



class Booths1Main
{
	public static void main(String args[])
	{
		Booths1 b=new Booths1();
		b.getdata();
		b.execute();
	}
}