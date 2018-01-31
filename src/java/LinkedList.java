/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;
/**
 *
 * @author rgukt
 */
public class LinkedList {
    Person first,last,next=null;
    public void insert(String name,String gender,String phone,String mail,String address)
    {
	Person temp=new Person(name,gender,phone,mail,address,next);
		if(first==null)
		{
			first=temp;
			last=first;
		}
		else
		{
			last.next=temp;
			last=last.next;
		}
	}
    public void sort()
    {
		int len=0;
		Person forlenght=first;
		while((forlenght)!=null)
		{	
			forlenght=forlenght.next;
			len++;		
		}
		
		int n=len-1;
		Person current,post,pre;
		while(n>0)
		{
			current=first;
			post=current.next;
			pre=null;
			int in=n,i=0;
			while(i<in)
			{
				if(current.name.compareTo(post.name)>0)
				{
					current.next=post.next;
					post.next=current;
					if(pre==null)
					{
						pre=post;
						first=post;		
					}
					else
					{
						pre.next=post;			
					}
				}
				// thesre are for next comparison
				if(post.next==current)
				{
					pre=post;
					post=current.next;		
				}
				else
				{
					pre=current;
					current=current.next;
					post=post.next;			
				}
				i++;
			}
			n--;
		}
    } 
    public void delete(String key)
    {
		Person current=first;
		if(first.phone.equals(key))
		{	
                        
			first=first.next;
                         this.intoFile();
			return;
		}
		else
		{
			while(current.next.next!=null)
			{
				if(current.next.phone.equals(key))
				{
					current.next=current.next.next;
                                        this.intoFile();
					return;		
				}
				else
				current=current.next;
			}
		}
		if(current.next.phone.equals(key))
		{
			last=current;
			last.next=null;
                        this.intoFile();
			return;	
		}
                
	}
       public void display()
	{
                FIO fobj=new FIO();
		Person current=first;
		while(current!=null)
		{
			System.out.println(current);
			current=current.next;
		}
	}
        public boolean find(String key)
	{
                FIO fobj=new FIO();
		Person current=first;
		while(current!=null)
		{
                        if(current.phone.equals(key))
                               break;
			current=current.next;
		}
                if(current==null)
                    return false;
                else
                    return true;
	}
       public String getData(String value)
       {
           Person temp=first;
           String mod[];
           String ret="";
           while(true)
           {
              
               if(temp.name.equals(value))
               {
                   mod=(temp+"").split("::");
                   for(int j=0;j<mod.length;j++)
                   {
                       if(j==0)
                           ret=ret+" Name\t: ";
                       else if(j==1)
                           ret=ret+" Gender\t: ";
                       else if(j==2)
                            ret=ret+" Phone\t: ";
                       else if(j==3)
                            ret=ret+" Mail\t: ";
                       else if(j==4)
                            ret=ret+" Address\t: ";
                       if(j==4)
                       {
                           String tempadr="";
                           String add[]=mod[j].split(";;;");
                           for(String adr:add)
                           {
                               tempadr=tempadr+adr+"\n\t  ";
                           }
                           ret=ret+tempadr;
                       }
                       else
                           ret=ret+mod[j]+"\n";
                   }
                   return ret;
               }
               
               else
               {
                   temp=temp.next;
                  
               }
           }
              
       }
       public String[] getnames()
       {
                String store="";
                Person current=first;
		while(current!=null)
		{
			store=store+current.name+":";
			current=current.next;
		}
                return store.split(":");
       }
       public String[] getnames(String key)
       {
                String store="";
                Person current=first;
		while(current!=null)
		{
                        if(current.name.contains(key))  
                            store=store+current.name+":";
                        current=current.next;
		}
                return store.split(":");
       }
       public void Testing()
       {
           String str[]=this.getnames();
           for(int i=0;i<str.length;i++)
               System.out.println(str[i]);
       }
       public void readFile() throws IOException
       {   
        FIO fobj=new FIO();
        FileReader fr=new FileReader("userdata/data");
        BufferedReader br=new BufferedReader(fr);
     	String name,gender,phone,mail,address,s;
	while((s=br.readLine())!=null)
	{
		StringTokenizer st=new StringTokenizer(s,"::");
                name=fobj.decrypt(st.nextToken(),10);
                gender=fobj.decrypt(st.nextToken(),10);
                phone=fobj.decrypt(st.nextToken(),10);
                mail=fobj.decrypt(st.nextToken(),10);
                address=fobj.decrypt(st.nextToken(),10);
		this.insert(name,gender,phone,mail,address);
        }
        this.sort();
        this.intoFile();
    }
       
       public void intoFile()
        {
            try {
                
            FIO obj=new FIO();
            FileWriter fw=new FileWriter("userdata/data");
            BufferedWriter bw=new BufferedWriter(fw);
            Person current=first;
            while(current!=null)
            {
			bw.write(obj.encrypt(current+"\n", 10));
			current=current.next;
            }
            bw.close();
            fw.close();
            }
            catch(Exception ex)
            {
                javax.swing.JOptionPane.showMessageDialog(null,"Rewrite Failed");
            }
            
        }
       public void intoFileDump()
        {
            try {
            FileReader fr=new FileReader("stack");
            BufferedReader br=new BufferedReader(fr);
            String strr=br.readLine();
            FIO obj=new FIO();
            FileWriter fw=new FileWriter("userdata/"+strr);
            BufferedWriter bw=new BufferedWriter(fw);
            Person current=first;
            while(current!=null)
            {
			bw.write(obj.encrypt(current+"\n", 10));
			current=current.next;
            }
            bw.close();
            fw.close();
            }
            catch(Exception ex)
            {
                javax.swing.JOptionPane.showMessageDialog(null,"Rewrite Failed");
            }
            
        }
       
       
       int count=0;
       int getCount()
       {
           FIO fobj=new FIO();
		Person current=first;
		while(current!=null)
		{
			System.out.println(current);
			current=current.next;
                        count++;
		}
            return count;    
       }
}