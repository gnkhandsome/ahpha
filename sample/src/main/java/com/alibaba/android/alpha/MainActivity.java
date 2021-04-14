/*
 * Copyright 2018 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.android.alpha;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.TextView;
import com.alibaba.android.alphasample.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = (TextView) findViewById(R.id.task_log);
        text.setMovementMethod(new ScrollingMovementMethod());
        ConfigTest test = new ConfigTest(getApplicationContext());
        test.setOnProjectExecuteListener(new OnProjectExecuteListener() {
            @Override
            public void onProjectStart() {

            }

            @Override
            public void onTaskFinish(String taskName) {

            }

            @Override
            public void onProjectFinish() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(MyLog.getLogString());
                    }
                });
            }
        });
        test.start();
    }
}
