import java.util.*;
import java.lang.*;
import java.io.*;

public class test{

public static void main(String args[])throws Exception
{
	MongoClient mongoClient = new MongoClient();
	System.out.println("Login or Signup?");
	InputStreamReader read_initial = new InputStreamReader(System.in);
	BufferedReader inp = new BufferedReader(read_initial);
	String input = inp.readLine();
	System.out.println(input);
	
	if(input.toLowerCase().equals("login")) login();
	else if(input.toLowerCase().equals("signup")) signup();
}
	public static void login()throws Exception
	{
		System.out.println("Enter your email id ");
		InputStreamReader read_email = new InputStreamReader(System.in);
		BufferedReader in_email = new BufferedReader(read_email);
		String email = in_email.readLine();
		if(email.indexOf("@") == -1) System.out.println("not valid email ID"); //see how to put checks in place
		
		System.out.println("Enter your password:");
		InputStreamReader read_pw = new InputStreamReader(System.in);
		BufferedReader in_pw = new BufferedReader(read_pw);
		String pw = in_pw.readLine();
		
		System.out.println(email);
		System.out.println(pw);
	}
	
	public static void signup()throws Exception
	{	
		//first name
		System.out.println("Enter your first name:");
		InputStreamReader read_fname = new InputStreamReader(System.in);
		BufferedReader in_fname = new BufferedReader(read_fname);
		String fname = in_fname.readLine();
		
		//last name
		System.out.println("Enter your last name:");
		InputStreamReader read_lname = new InputStreamReader(System.in);
		BufferedReader in_lname = new BufferedReader(read_lname);
		String lname = in_lname.readLine();
		
		//email id
		System.out.println("Enter your email id");
		InputStreamReader read_email = new InputStreamReader(System.in);
		BufferedReader in_email = new BufferedReader(read_email);
		String email = in_email.readLine();
		//System.out.println(email);
		
		//password
		System.out.println("Enter your password:");
		InputStreamReader read_pw = new InputStreamReader(System.in);
		BufferedReader in_pw = new BufferedReader(read_pw);
		String pw = in_pw.readLine();
		
		//confirm password
		System.out.println("Re-enter your password:");
		InputStreamReader read_pwc = new InputStreamReader(System.in);
		BufferedReader in_pwc = new BufferedReader(read_pwc);
		String pwc = in_pwc.readLine();
		
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(email);
		System.out.println(pw);
		System.out.println(pwc);
	}
}
