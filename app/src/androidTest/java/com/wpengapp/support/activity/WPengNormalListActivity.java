package com.wpengapp.support.activity;

import android.os.Bundle;
import android.widget.ListView;
import com.wpengapp.support.R$id;
import com.wpengapp.support.R$layout;

public class WPengNormalListActivity extends WPengBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.pw_activity_normal_list);
        ListView listView = (ListView) findViewById(R$id.list);
    }
}
