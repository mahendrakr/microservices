package com.javathesimpleway.ioc;

public class Hello {
	private A aobj = null;
	private B bobj = null;

	public void show() {
		aobj.m1();
		bobj.m2();

	}

	public A getAobj() {
		return aobj;
	}

	public void setAobj(A aobj) {
		this.aobj = aobj;
	}

	public B getBobj() {
		return bobj;
	}

	public void setBobj(B bobj) {
		this.bobj = bobj;
	}
	
	
}
