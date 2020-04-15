package io.raghamapp.fasms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class BrodcastSms extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("ssss",intent.getAction()+"");


        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
        {
            Bundle bundle=intent.getExtras();

            SmsMessage[] smsMessages=null;

            if(bundle!=null)
            {
                Object[] pdus=(Object[]) bundle.get("pdus");
                smsMessages=new SmsMessage[pdus.length];

                for(int i=0;i<smsMessages.length;i++)
                {
                    smsMessages[i]=SmsMessage.createFromPdu((byte[]) pdus[i]);
                    Log.i("ppp",smsMessages[i].getStatus()+"  "+smsMessages[i].getMessageBody()+"   "+smsMessages[i].getPdu()+
                            "  "+smsMessages[i].getEmailFrom()+"  "+smsMessages[i].getTimestampMillis()+"   "+smsMessages[i].getDisplayOriginatingAddress());
                    Toast.makeText(context, smsMessages[i].getMessageBody(), Toast.LENGTH_SHORT).show();
                }
            }

        }


    }
}
