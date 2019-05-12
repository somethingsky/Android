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
		result+="ID ： "+this.ID+" ， ";
		result+=" 姓名： "+this.Name+" ， ";
		result+=" 性别： "+this.Sex+" ， ";
		result+=" 部门： "+this.Place+" ， ";
		result+=" 工资： "+this.Pay+" ； ";
		return result;
	}
}