package com.wpengapp.support.multiprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.wpengapp.support.Command;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Deprecated
public class BaseService extends Service {

    /* renamed from: ֏ */
    public C0456 f703 = new BaseService(this);

    /* renamed from: com.wpengapp.support.multiprocess.BaseService$֏ */
    public interface C0456 {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        List<Command> list;
        C0456 r0 = this.f703;
        if (intent != null) {
            try {
                if (!(intent.getExtras() == null || (list = (List) intent.getSerializableExtra("key_cmd")) == null)) {
                    for (Command r2 : list) {
                        "onStartCommand, CMD: " + r2;
                        if (r0 != null) {
                            ((BaseService) r0).f2157.mo7876(r2.f2520, r2.f2521);
                        }
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    /* renamed from: ֏ */
    public void mo7876(String str, Map<String, Serializable> map) {
    }
}
