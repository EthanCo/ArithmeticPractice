package com.ethanco.myarithmetictest;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by EthanCo on 2016/7/23.
 */
public class ActivityTest extends ActivityUnitTestCase<MainActivity> {

    private MainActivity mMainActivity;
    private TextView tvInfo;

    public ActivityTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    public ActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(intent, null, null);

        mMainActivity = getActivity();
        checkWidgets();
    }

    public void checkWidgets() {
        tvInfo = (TextView) mMainActivity.findViewById(R.id.tvInfo);
        assertEquals(false, TextUtils.isEmpty(tvInfo.getText().toString()));
    }

    public void test1() {
        tvInfo.setText("test");
        assertEquals("test", tvInfo.getText().toString());
    }
}
