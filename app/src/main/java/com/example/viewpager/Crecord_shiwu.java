package com.example.viewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;


import java.util.ArrayList;
import java.util.List;

public class Crecord_shiwu extends AppCompatActivity {

    ViewPager viewPager;
    List<Fragment> fragmentList;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cshiwu_record);
        initView();
    }
    private void initView(){
        viewPager=(ViewPager) findViewById(R.id.view_pager);
        radioGroup=(RadioGroup) findViewById(R.id.radiogr);
        fragmentList=new ArrayList<>();
        fragmentList.add(new CshiwuFragment());
        fragmentList.add(new CshiwuFragment2());
        MyFragAdapter myAdapter=new MyFragAdapter(getSupportFragmentManager(),this,fragmentList);
        viewPager.setAdapter(myAdapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.already_gui:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.not_gui:
                        viewPager.setCurrentItem(1);
                        break;
                    default:

                        break;
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position){
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}