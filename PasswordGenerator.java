package hobey;
import java.util.Random;
import java.io.FileWriter;
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
	public String shuffle(String temp)
	{
		
		char temppswd[]=temp.toCharArray();
		int x=1;
		String password="";
		Random rand=new Random();
		while(x<=100) 
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
		return password;
		
	}
	
	public void writetofile(String password)
	{
		try {
			FileWriter fw=new FileWriter("C:\\Users\\AAYUSH\\Documents\\java_projects\\PasswordGenerator\\PasswordGenerator_out.txt");
			fw.write(password);
			fw.flush();
			fw.close();
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong.....");
			System.out.println(e);
		}
		finally 
		{
			System.out.println("Password successfully Generated.....");
		}
	}

	public static void main(String args[]) {
		PasswordGenerator a=new PasswordGenerator();
		String temp=a.generate();
		String password=a.shuffle(temp);
		a.writetofile(password);
	}
}
