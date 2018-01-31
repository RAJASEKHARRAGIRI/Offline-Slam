/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
/**
 *
 * @author rgukt
 */
public class FIO {
    public String encrypt(String str,int key)
    {
		int ch;
		key=key%26;
		String text="";
		for(int i=0;i<str.length();i++)
		{
			ch=str.charAt(i);
			if(str.charAt(i)>='a'&&str.charAt(i)<='z')
			{
				ch=ch+key;
				if(ch>'z')
					ch='a'+(ch-'z')-1;	
			}
			else if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
			{
				ch=ch+key;
				if(ch>'Z')
					ch='A'+(ch-'Z')-1;	
			}
			text=text+(char)ch;
		}
		return text;
    }
    public String decrypt(String str,int key)
    {
		int ch;
		key=key%26;
		String text="";
		for(int i=0;i<str.length();i++)
		{
			ch=str.charAt(i);
			if(str.charAt(i)>='a'&&str.charAt(i)<='z')
			{
				ch=ch-key;
				if(ch<'a')
					ch='z'-('a'-ch)+1;	
			}
			else if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
			{
				ch=ch-key;
				if(ch<'A')
					ch='Z'-('A'-ch)+1;	
			}
                       
			text=text+(char)ch;
		}
		return text;
    }
    public void intoFile(String str,String data) throws IOException
    {
          FileWriter fw=new FileWriter(str+"",true);
          BufferedWriter bw=new BufferedWriter(fw);
          bw.write(data+"\n");
          bw.close();
          fw.close();
        
    }
    public String FromFile(String str) throws IOException
    {
        String data;
        FileReader fr=new FileReader(str+"");
        BufferedReader br=new BufferedReader(fr);
        br.close();
        fr.close();
        data=br.readLine();
        return  data;
    }
}
