package al.jamil.suvo.banglacalender;
import java.util.Date;

import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.content .Intent;
import android.app .PendingIntent;


public class MyWidgetProvider extends AppWidgetProvider{
	public static final String ACTION_CLICK="ACTION_CLICK";
	public void onUpdate(Context context,AppWidgetManager appWidgetManager,int[] appWidgetIds){
		ComponentName thisWidget=new ComponentName(context,MyWidgetProvider.class);
		int[] allWidgetIds=appWidgetManager.getAppWidgetIds(thisWidget);
		for (int widgetId:allWidgetIds){
			RemoteViews remoteViews=new RemoteViews(context.getPackageName(),R.layout.widget);
			Log.w("BanglaCalander",getToday());
			remoteViews.setTextViewText(R.id.widgetText, getToday());
			Intent intent=new Intent(context,MyWidgetProvider.class);
			intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
			intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
			PendingIntent pendingIntent=PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
			remoteViews.setOnClickPendingIntent(R.id.widgetText, pendingIntent);
			appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
			}
		
	}


	private String getToday() {
		String tday="";
		int bd,bmi;
		int[] bmd=new int[12];
		for (int i=0;i<=4;i++)bmd[i]=31;
		for (int i=5;i<=11;i++)bmd[i]=30;
		String[] bs={"গ্রীষ্ণ","বর্ষা","শরৎ","হেমন্ত","শীত","বসন্ত"};
		String[] bdin={"রবি","সোম","মঙ্গল","","বৃহঃস্পতি","শুক্র","শনি"};
		String[] bn={"০","১","২","৩","৪","৫","৬","৭","৮","৯"};
		String[] bm={"বৈশাখ","জৈষ্ঠ","আষাঢ়","শ্রাবণ","ভাদ্র","আশ্বিন","কার্তিক","অগ্রায়ণ","পৌষ","মাঘ","ফাল্গুন","চৈত্র"};
		int[] emd={0,31,59,90,120,151,181,212,243,273,304,334};
		Date d=new Date();
		int ed=d.getDate();
		int yd=emd[d.getMonth()]+ed;
		int eyear=d.getYear()+1900;
		int byear=eyear-593;
		if (yd>102) yd-=103;
		else {yd+=261;byear--;}
		int i=0;
		while (yd>bmd[i]){
			yd-=bmd[i];
			i++;
		}
		bmi=i;
		bd=yd;
		tday+=bdin[d.getDay()]+"বার ";
		tday+=bn[(bd-(bd%10))/10];
		tday+=bn[bd%10];
		tday+=" ";
		tday+=bm[bmi];
		tday+=" ";
		tday+=bn[(byear-(byear%1000))/1000];
		byear=byear%1000;
		tday+=bn[(byear-(byear%100))/100];
		byear=byear%100;
		tday+=bn[(byear-(byear%10))/10];
		tday+=bn[byear%10];
		tday+=" ";
		switch(bmi){
		case 0:
		case 1:
			
			tday+="গ্রীষ্ণ";
			break;
		case 2:
		case 3:
			tday+="বর্ষা";
			break;
		case 4:
		case 5:
			
			tday+="শরৎ";
			break;
		case 6:
		case 7:
			tday+="হেমন্ত";
			break;
		case 8:
		case 9:
			
			tday+="শীত";
			break;
		case 10:
		case 11:
			tday+="বসন্ত";
			break;
		}
		tday+="কাল ";
		return tday;
	}

}
