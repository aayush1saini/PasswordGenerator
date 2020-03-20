package hobey;
import java.util.Random;
public class PasswordGenerator {
	final String alpha="bycxdwevjqirhsgtfukplomnaz";
	final String caps="ZANMOLPKUFTGSHRIQJVEWDXCYB";
	final String nums="9257314068";
	final String spc="&@%#(}[{]*}/!?^";
	
	public  String generate()
	{
		String temp="";
		
		Random rand=new Random();
		int i=0;
		while(i<3)
		{
			int alphaL=rand.nextInt(alpha.length());
		    int capsL=rand.nextInt(caps.length());
		    
		    temp+=alpha.charAt(alphaL);
		    temp+=caps.charAt(capsL);
		    i++;
		}
		i=0;
		while(i<2) 
		{
			int numsL=rand.nextInt(nums.length());
			int spcL =rand.nextInt(spc.length());
			
			temp+=spc.charAt(spcL);
			temp+=nums.charAt(numsL);
			i++;
		}
		
		
		return temp;
	}
	public void shuffle(String temp)
	{
		
		char temppswd[]=temp.toCharArray();
		int x=1;
		String password="";
		Random rand=new Random();
		while(x<=10) 
		{
			int i=rand.nextInt(temp.length());
			int j=rand.nextInt(temp.length());
		
			if(i!=j)
			{
			   char t=temppswd[i];
			   temppswd[i]=temppswd[j];
			   temppswd[j]=t;
			}
			x++;
			
		}
		
		for(int i=0;i<10;i++)
		{
			password+=temppswd[i];
		}
		System.out.println(password);
		
	}

	public static void main(String args[]) {
		PasswordGenerator a=new PasswordGenerator();
		String temp=a.generate();
		a.shuffle(temp);
	}
}
