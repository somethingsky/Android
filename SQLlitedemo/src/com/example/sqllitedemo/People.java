package com.example.sqllitedemo;

public class People {
	public int ID=-1;
	public String Name;
	public String Sex;
	public String Place;
	public int Pay;
	@Override
	public String toString(){
		String result="";
		result+="ID �� "+this.ID+" �� ";
		result+=" ������ "+this.Name+" �� ";
		result+=" �Ա� "+this.Sex+" �� ";
		result+=" ���ţ� "+this.Place+" �� ";
		result+=" ���ʣ� "+this.Pay+" �� ";
		return result;
	}
}