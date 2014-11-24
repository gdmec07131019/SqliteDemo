package cn.edu.gdmec.s07131019.sqlitedemo;

public class People {
	public int ID =-1;
	public String Name;
	public  int Age;
	public float Height;
	
	People(int id,String name,int age,float height){
		super();
		ID = id;
		Name = name;
		Age = age;
		Height  = height;
	}
	People(){
		
	}

	@Override
	public String toString() {
		String result="";
		result += "ID:"+ID+",";
		result += "Name:"+Name+",";
		result += "Age:"+Age+",";
		result += "Height:"+Height;
		return result;
	}
	
	
}
