/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rgukt
 */
public class Person {
        String name,phone,mail,address,gender;
	Person next;
	public Person(String name,String c,String d,String e,String f,Person ref)
	{
		this.name=name;
                this.gender=c;
                this.phone=d;
                this.mail=e;
                this.address=f;
		this.next=ref;
	}
	public String toString()
	{
		return name+"::"+gender+"::"+phone+"::"+mail+"::"+address;
	}
}
