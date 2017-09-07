package al.jamil.suvo.banglacalender;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageView;
import android.widget .TextView;
import android.graphics.drawable.*;
import android.view .View;
import android.widget .Button;
import android.widget .Toast;

import java.util .Date;

public class BanglaCalender extends Activity {
	int byear;
	int eyear;
	int bd,bmi;
	int msd,osm;
 	String[] bn={"০","১","২","৩","৪","৫","৬","৭","৮","৯"};
	String[] bm={"বৈশাখ","জৈষ্ঠ","আষাঢ়","শ্রাবণ","ভাদ্র","আশ্বিন","কার্তিক","অগ্রায়ণ","পৌষ","মাঘ","ফাল্গুন","চৈত্র"};
	final static int[] bmd=new int[12];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bangla_calender);
		Toast.makeText(getBaseContext(), getWidgetInfo(),Toast.LENGTH_LONG).show();
		setbmi();
		getMonth();
		setMonth();
		Date d=new Date();
		int td=d.getDay()+1;
		setCalender(osm);
		clickButton();
		clicknext();
		clickpre();
	}

	private CharSequence getWidgetInfo() {
		CharSequence st="";
		st="বাংলা পঞ্জিকা ব্যবহার আরো সহজ করতে আপনার হোম পেজে 'বাংলাপঞ্জিকা ওইজেট' যুক্ত করে নিন";
		return st;
	}

	private void clickpre() {
		Button bt=(Button)findViewById(R.id.pre);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int b;
				if (osm==0) b=11;
				else b=osm-1;
				int a=bmd[b];
				msd=msd-(a%7);
				if (msd<1) msd+=7;
				if(osm==0) {osm=11;byear--;}
				else osm--;
				if (osm==6) eyear--;
				setCalender(osm);
			}
		});
		
	}

	private void clicknext() {
		Button bt=(Button)findViewById(R.id.next);
		bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int a=bmd[osm];
				msd=(a%7)+msd;
				if (msd>7) msd-=7;
				if(osm==11) {osm=1;byear++;}
				else osm++;
				if (osm==8) eyear++;
				setCalender(osm);
			}
		});
	}

	private void clickButton() {
		Button bt=(Button)findViewById(R.id.me);
		
		bt.setOnClickListener( new View.OnClickListener(){
			
			@Override
			public void onClick(View v) {
				setContentView(R.layout.programmer);
				clickBack();
			}

			private void clickBack() {
				Button bc=(Button)findViewById(R.id.back);
				bc.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						onCreate(null);
						
					}
				});
			}
			
		});
	
		
	}

	private void setbmi() {
		for (int i=0;i<=4;i++)bmd[i]=31;
		for (int i=5;i<=11;i++)bmd[i]=30;
	}

	private void setCalender(int mon) {
		int byear=0;
		int[] ems={14,15,15,16,16,16,16,15,15,14,13,15};
		int[] nems={18,18,17,17,17,16,17,17,18,19,17,18};
		String[] emn={"Apr/May","May/Jun","Jun/July","July/Aug","Aug/Sept","Sept/Oct","Oct/Nov","Nov/Dec","Dec/Jun","Jun/Feb","Feb/Mar","Mar/Apr"};
		setenMon(emn[mon]);
		setMon(mon);
		int i=0;
		int k=0;
		int e=0;
		int ml=bmd[mon];
		if (mon==10){
			if (eyear%4==0){
				ml++;
				nems[10]++;
			}
		}
		k=1;
		i=0;
		if (k>=msd) i++;
		else i=0;
		k++;
		setD1(getBdS(i));
		if (i==1) e=ems[mon];
		else if (i>1) e++;
		setE1(getBdS(e));
		if (k>=msd) i++;
		k++;
		setD2(getBdS(i));
		if (i==1) e=ems[mon];
		else if (i>1) e++;
		setE2(getBdS(e));
		if (k>=msd) i++;
		k++;
		setD3(getBdS(i));
		if (i==1) e=ems[mon];
		else if (i>1) e++;
		setE3(getBdS(e));
		if (k>=msd) i++;
		k++;
		setD4(getBdS(i));
		if (i==1) e=ems[mon];
		else if (i>1) e++;
		setE4(getBdS(e));
		if (k>=msd) i++;
		k++;
		setD5(getBdS(i));
		if (i==1) e=ems[mon];
		else if (i>1) e++;
		setE5(getBdS(e));
		if (k>=msd) i++;
		k++;
		setD6(getBdS(i));
		if (i==1) e=ems[mon];
		else if (i>1) e++;
		setE6(getBdS(e));
		if (k>=msd) i++;
		k++;
		setD7(getBdS(i));
		if (i==1) e=ems[mon];
		else if (i>0) e++;
		setE7(getBdS(e));
		i++;
		setD8(getBdS(i));
		e++;
		setE8(getBdS(e));
		i++;
		setD9(getBdS(i));
		e++;
		setE9(getBdS(e));
		i++;
		setD10(getBdS(i));
		e++;
		setE10(getBdS(e));;
		i++;
		setD11(getBdS(i));
		e++;
		setE11(getBdS(e));
		i++;
		setD12(getBdS(i));
		e++;
		setE12(getBdS(e));
		i++;
		setD13(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE13(getBdS(e));
		i++;
		setD14(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE14(getBdS(e));
		i++;
		setD15(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE15(getBdS(e));
		i++;
		setD16(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE16(getBdS(e));
		i++;
		setD17(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE17(getBdS(e));
		i++;
		setD18(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE18(getBdS(e));
		i++;
		setD19(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE19(getBdS(e));
		i++;
		setD20(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE20(getBdS(e));
		i++;
		setD21(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE21(getBdS(e));
		i++;
		setD22(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE22(getBdS(e));
		i++;
		setD23(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE23(getBdS(e));
		i++;
		setD24(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE24(getBdS(e));
		i++;
		setD25(getBdS(i));
		if (i==nems[mon]) e=1;
		else e++;
		setE25(getBdS(e));
		i++;
		setD26(getBdS(i));
		e++;
		setE26(getBdS(e));
		i++;
		setD27(getBdS(i));
		e++;
		setE27(getBdS(e));
		i++;
		setD28(getBdS(i));
		e++;
		setE28(getBdS(e));
		if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD29(getBdS(i));
		e++;
		setE29(getBdS(e));
		if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD30(getBdS(i));
		e++;
		setE30(getBdS(e));
		if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD31(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE31(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD32(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE32(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD33(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE33(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD34(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE34(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD35(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE35(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD36(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE36(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD37(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE37(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD38(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE38(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD39(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE39(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD40(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE40(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD41(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE41(getBdS(e));
		if (k==0) i=0;
		else if ((ml-i)==1) {k=0;i++;}
		else i++;
		setD42(getBdS(i));
		if (i==0)e=0;
		else e++;
		setE42(getBdS(e));
	}



	private void setE1(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed1);
		t.setText(bdS);
	}

	private void setE42(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed42);
		t.setText(bdS);
	}

	private void setE41(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed41);
		t.setText(bdS);
	}

	private void setE40(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed40);
		t.setText(bdS);
	}

	private void setE39(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed39);
		t.setText(bdS);
	}

	private void setE38(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed38);
		t.setText(bdS);
	}

	private void setE37(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed37);
		t.setText(bdS);
	}

	private void setE36(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed36);
		t.setText(bdS);
	}

	private void setE35(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed35);
		t.setText(bdS);
	}

	private void setE34(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed34);
		t.setText(bdS);
	}

	private void setE33(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed33);
		t.setText(bdS);
	}

	private void setE32(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed32);
		t.setText(bdS);
	}

	private void setE31(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed31);
		t.setText(bdS);
	}

	private void setE30(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed30);
		t.setText(bdS);
	}

	private void setE29(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed29);
		t.setText(bdS);
	}

	private void setE28(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed28);
		t.setText(bdS);
	}

	private void setE27(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed27);
		t.setText(bdS);
	}

	private void setE26(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed26);
		t.setText(bdS);
	}

	private void setE25(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed25);
		t.setText(bdS);
	}

	private void setE24(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed24);
		t.setText(bdS);
	}

	private void setE23(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed23);
		t.setText(bdS);
	}

	private void setE22(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed22);
		t.setText(bdS);
	}

	private void setE21(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed21);
		t.setText(bdS);
	}

	private void setE20(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed20);
		t.setText(bdS);
	}

	private void setE19(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed19);
		t.setText(bdS);
	}

	private void setE18(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed18);
		t.setText(bdS);
	}

	private void setE17(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed17);
		t.setText(bdS);
	}

	private void setE16(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed16);
		t.setText(bdS);
	}

	private void setE15(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed15);
		t.setText(bdS);
	}

	private void setE14(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed14);
		t.setText(bdS);
	}

	private void setE13(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed13);
		t.setText(bdS);
	}

	private void setE12(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed12);
		t.setText(bdS);
	}

	private void setE11(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed11);
		t.setText(bdS);
	}

	private void setE10(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed10);
		t.setText(bdS);
	}

	private void setE9(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed9);
		t.setText(bdS);
	}

	private void setE8(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed8);
		t.setText(bdS);
	}

	private void setE7(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed7);
		t.setText(bdS);
	}

	private void setE6(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed6);
		t.setText(bdS);
	}

	private void setE5(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed5);
		t.setText(bdS);
	}

	private void setE4(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed4);
		t.setText(bdS);	
	}

	private void setE3(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed3);
		t.setText(bdS);
		
	}

	private void setE2(String bdS) {
		TextView t=(TextView)findViewById(R.id.ed2);
		t.setText(bdS);
		
	}

	private void setenMon(String string) {
		TextView t=(TextView)findViewById(R.id.em);
		Date d=new Date();
		t.setText(string+" "+ eyear);
	}

	private void setD36(String bdS) {
		TextView t=(TextView)findViewById(R.id.d36);
		t.setText(bdS);
		
	}

	private void setD37(String bdS) {
		TextView t=(TextView)findViewById(R.id.d37);
		t.setText(bdS);
		
	}

	private void setD38(String bdS) {
		TextView t=(TextView)findViewById(R.id.d38);
		t.setText(bdS);
	}

	private void setD39(String bdS) {
		TextView t=(TextView)findViewById(R.id.d39);
		t.setText(bdS);
		
	}

	private void setD40(String bdS) {
		TextView t=(TextView)findViewById(R.id.d40);
		t.setText(bdS);
		
	}

	private void setD41(String bdS) {
		TextView t=(TextView)findViewById(R.id.d41);
		t.setText(bdS);
		
	}

	private void setD42(String bdS) {
		TextView t=(TextView)findViewById(R.id.d42);
		t.setText(bdS);
		
	}

	private void setMon(int m) {
		TextView t=(TextView)findViewById(R.id.mn);
		String str=bm[m];
		t.setText(str+" "+getBY(byear));
		
	}
	public String getBY(int i){
		String str="";
		str+=bn[(i-(i%1000))/1000];
		i=i%1000;
		str+=bn[(i-(i%100))/100];
		i=i%100;
		str+=bn[(i-(i%10))/10];
		str+=bn[i%10];
		return str;
	}
	
	private void setD35(String bdS) {
		TextView t=(TextView)findViewById(R.id.d35);
		t.setText(bdS);
		
	}

	private void setD34(String bdS) {
		TextView t=(TextView)findViewById(R.id.d34);
		t.setText(bdS);
		
	}

	private void setD33(String bdS) {
		TextView t=(TextView)findViewById(R.id.d33);
		t.setText(bdS);
		
	}

	private void setD32(String bdS) {
		TextView t=(TextView)findViewById(R.id.d32);
		t.setText(bdS);
		
	}

	private void setD31(String bdS) {
		TextView t=(TextView)findViewById(R.id.d31);
		t.setText(bdS);
		
	}

	private void setD30(String bdS) {
		TextView t=(TextView)findViewById(R.id.d30);
		t.setText(bdS);
		
	}

	private void setD29(String bdS) {
		TextView t=(TextView)findViewById(R.id.d29);
		t.setText(bdS);
		
	}

	private void setD28(String bdS) {
		TextView t=(TextView)findViewById(R.id.d28);
		t.setText(bdS);
		
	}

	private void setD27(String bdS) {
		TextView t=(TextView)findViewById(R.id.d27);
		t.setText(bdS);
		
	}

	private void setD26(String bdS) {
		TextView t=(TextView)findViewById(R.id.d26);
		t.setText(bdS);
		
	}

	private void setD25(String bdS) {
		TextView t=(TextView)findViewById(R.id.d25);
		t.setText(bdS);
		
	}

	private void setD24(String bdS) {
		TextView t=(TextView)findViewById(R.id.d24);
		t.setText(bdS);
		
	}

	private void setD23(String bdS) {
		TextView t=(TextView)findViewById(R.id.d23);
		t.setText(bdS);
		
	}

	private void setD22(String bdS) {
		TextView t=(TextView)findViewById(R.id.d22);
		t.setText(bdS);
		
	}

	private void setD21(String bdS) {
		TextView t=(TextView)findViewById(R.id.d21);
		t.setText(bdS);
		
	}

	private void setD20(String bdS) {
		TextView t=(TextView)findViewById(R.id.d20);
		t.setText(bdS);
		
	}

	private void setD19(String bdS) {
		TextView t=(TextView)findViewById(R.id.d19);
		t.setText(bdS);
		
	}

	private void setD18(String bdS) {
		TextView t=(TextView)findViewById(R.id.d18);
		t.setText(bdS);
		
	}

	private void setD17(String bdS) {
		TextView t=(TextView)findViewById(R.id.d17);
		t.setText(bdS);
		
	}

	private void setD16(String bdS) {
		TextView t=(TextView)findViewById(R.id.d16);
		t.setText(bdS);
		
	}

	private void setD15(String bdS) {
		TextView t=(TextView)findViewById(R.id.d15);
		t.setText(bdS);
		
	}

	private void setD14(String bdS) {
		TextView t=(TextView)findViewById(R.id.d14);
		t.setText(bdS);
		
	}

	private void setD13(String bdS) {
		TextView t=(TextView)findViewById(R.id.d13);
		t.setText(bdS);
		
	}

	private void setD12(String bdS) {
		TextView t=(TextView)findViewById(R.id.d12);
		t.setText(bdS);
		
	}

	private void setD11(String bdS) {
		TextView t=(TextView)findViewById(R.id.d11);
		t.setText(bdS);
		
	}

	private void setD10(String bdS) {
		TextView t=(TextView)findViewById(R.id.d10);
		t.setText(bdS);
		
	}

	private void setD9(String bdS) {
		TextView t=(TextView)findViewById(R.id.d9);
		t.setText(bdS);
		
	}

	private void setD8(String bdS) {
		TextView t=(TextView)findViewById(R.id.d8);
		t.setText(bdS);
		
	}

	private void setD7(String bdS) {
		TextView t=(TextView)findViewById(R.id.d7);
		t.setText(bdS);
		
	}

	private void setD6(String bdS) {
		TextView t=(TextView)findViewById(R.id.d6);
		t.setText(bdS);
		
	}

	private void setD5(String bdS) {
		TextView t=(TextView)findViewById(R.id.d5);
		t.setText(bdS);
		
	}

	private void setD4(String bdS) {
		TextView t=(TextView)findViewById(R.id.d4);
		t.setText(bdS);
		
	}

	private void setD3(String bdS) {
		TextView t=(TextView)findViewById(R.id.d3);
		t.setText(bdS);
		
	}

	private void setD2(String bdS) {
		TextView t=(TextView)findViewById(R.id.d2);
		t.setText(bdS);
		
	}

	private void setD1(String bdS) {
		TextView t=(TextView)findViewById(R.id.d1);
		t.setText(bdS);
		
	}

	private void setMonth() {
		String[] bs={"গ্রীষ্ণ","বর্ষা","শরৎ","হেমন্ত","শীত","বসন্ত"};
		String[] bdin={"রবি","সোম","মঙ্গল","","বৃহঃস্পতি","শুক্র","শনি"};
		TextView tx=(TextView)findViewById(R.id.td);
		String bdat=getbdat();
		Date d=new Date();
		String season=getseason();
		tx.setText("আজ-"+bdin[d.getDay()]+"বার "+bdat+" "+bm[bmi]+" "+season+"কাল");
		msd=(d.getDay()+1)-(bd%7)+1;
		if (msd<1) msd+=7;
		osm=bmi;
	}

	private void getMonth() {
		int[] emd={0,31,59,90,120,151,181,212,243,273,304,334};
		Date d=new Date();
		int ed=d.getDate();
		int yd=emd[d.getMonth()]+ed;
		eyear=d.getYear()+1900;
		byear=eyear-593;
		if (yd>103) yd-=103;
		else {yd+=261;byear--;};
		int i=0;
		while (yd>bmd[i]){
			yd-=bmd[i];
			i++;
		}
		bmi=i;
		bd=yd;
	}
private String getbdat(){
	String bdat=" ";
		bdat+=bn[(bd-(bd%10))/10];
		bdat+=bn[bd%10];
		return bdat;
	}
private String getBdS(int i){
	String str="";
	if (i!=0){
	str+=bn[(i-(i%10))/10];
	str+=bn[i%10];
	}
	return str;
}
private String getseason(){
	String str="";
	switch(bmi){
	case 0:
	case 1:
		
		str="গ্রীষ্ণ";
		break;
	case 2:
	case 3:
		str="বর্ষা";
		setBgs2();
		break;
	case 4:
	case 5:
		
		str="শরৎ";
		break;
	case 6:
	case 7:
		str="হেমন্ত";
		break;
	case 8:
	case 9:
		
		str="শীত";
		break;
	case 10:
	case 11:
		str="বসন্ত";
		break;
	}
	return str;
}
	private void setBgs2(){
		ImageView iv=(ImageView)findViewById(R.id.img);
		Drawable im;
		im=getResources().getDrawable(R.drawable.s2);
		iv.setImageDrawable(im);
	}
}
