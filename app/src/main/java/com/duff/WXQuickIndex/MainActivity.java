package com.duff.WXQuickIndex;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.OvershootInterpolator;
import android.widget.ListView;
import android.widget.TextView;

import com.duff.WXQuickIndex.QuickIndexBar.OnTouchLetterListener;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends Activity {
	private QuickIndexBar quickIndexBar;
	private ListView listview;
	private TextView currentWord;
	
	private ArrayList<Friend> friends = new ArrayList<Friend>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		quickIndexBar = (QuickIndexBar) findViewById(R.id.quickIndexBar);
		listview = (ListView) findViewById(R.id.listview);
		currentWord = (TextView) findViewById(R.id.currentWord);
		
		//1.准备数据
		fillList();
		//2.对数据进行排序
		Collections.sort(friends);
		//3.设置Adapter
		listview.setAdapter(new MyAdapter(this,friends));
		
		quickIndexBar.setOnTouchLetterListener(new OnTouchLetterListener() {
			@Override
			public void onTouchLetter(String letter) {
				//根据当前触摸的字母，去集合中找那个item的首字母和letter一样，然后将对应的item放到屏幕顶端
				for (int i = 0; i < friends.size(); i++) {
					String firstWord = friends.get(i).getPinyin().charAt(0)+"";
					if(letter.equals(firstWord)){
						//说明找到了，那么应该讲当前的item放到屏幕顶端
						listview.setSelection(i);
						break;//只需要找到第一个就行
					}
				}
				
				//显示当前触摸的字母
				showCurrentWord(letter);
			}
		});
		
		
		//通过缩小currentWord来隐藏
		ViewHelper.setScaleX(currentWord, 0);
		ViewHelper.setScaleY(currentWord, 0);
	}
	private boolean isScale = false;
	private Handler handler = new Handler();
	protected void showCurrentWord(String letter) {
		currentWord.setText(letter);
		if(!isScale){
			isScale = true;
			ViewPropertyAnimator.animate(currentWord).scaleX(1f)
			.setInterpolator(new OvershootInterpolator())
			.setDuration(450).start();
			ViewPropertyAnimator.animate(currentWord).scaleY(1f)
			.setInterpolator(new OvershootInterpolator())
			.setDuration(450).start();
		}
		
		//先移除之前的任务
		handler.removeCallbacksAndMessages(null);
		
		//延时隐藏currentWord
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
//				currentWord.setVisibility(View.INVISIBLE);
				ViewPropertyAnimator.animate(currentWord).scaleX(0f).setDuration(450).start();
				ViewPropertyAnimator.animate(currentWord).scaleY(0f).setDuration(450).start();
				isScale = false;
			}
		}, 1500);
	}

	private void fillList() {
		// 虚拟数据
		friends.add(new Friend("努努"));
		friends.add(new Friend("莫德凯撒"));
		friends.add(new Friend("嘉文四世"));
		friends.add(new Friend("奥莉安娜"));
		friends.add(new Friend("提莫"));
		friends.add(new Friend("迦娜"));
		friends.add(new Friend("卡萨丁"));
		friends.add(new Friend("古拉加斯"));
		friends.add(new Friend("雷克顿"));
		friends.add(new Friend("费德提克"));
		friends.add(new Friend("伊泽瑞尔"));
		friends.add(new Friend("娑娜"));
		friends.add(new Friend("索拉卡"));
		friends.add(new Friend("拉克丝"));
		friends.add(new Friend("波比"));
		friends.add(new Friend("潘森"));
		friends.add(new Friend("茂凯"));
		friends.add(new Friend("蒙多医生"));
		friends.add(new Friend("希维尔"));
		friends.add(new Friend("弗拉基米尔"));
		friends.add(new Friend("普朗克"));
		friends.add(new Friend("崔丝塔娜"));
		friends.add(new Friend("艾瑞莉娅"));
		friends.add(new Friend("沃里克"));
		friends.add(new Friend("厄运晓姐"));
		friends.add(new Friend("库奇"));
		friends.add(new Friend("布兰德"));
		friends.add(new Friend("阿卡丽"));
		friends.add(new Friend("卡尔玛"));
		friends.add(new Friend("李青"));
		friends.add(new Friend("凯南"));
		friends.add(new Friend("盖伦"));
		friends.add(new Friend("艾希"));
		friends.add(new Friend("泰达米尔"));
		friends.add(new Friend("塔里克"));
		friends.add(new Friend("贾克斯"));
		friends.add(new Friend("薇恩"));
		friends.add(new Friend("莫甘娜"));
		friends.add(new Friend("玛尔扎哈"));
		friends.add(new Friend("特朗德尔"));
		friends.add(new Friend("辛吉德"));
		friends.add(new Friend("斯维因"));
		friends.add(new Friend("卡西奥佩娅"));
		friends.add(new Friend("卡尔萨斯"));
		friends.add(new Friend("安妮"));
		friends.add(new Friend("凯特琳"));
		friends.add(new Friend("伊芙琳"));
		friends.add(new Friend("图奇"));
		friends.add(new Friend("凯尔"));
		friends.add(new Friend("科'加斯"));
		friends.add(new Friend("奥拉夫"));
		friends.add(new Friend("阿木木"));
		friends.add(new Friend("加里奥"));
		friends.add(new Friend("布里茨"));
		friends.add(new Friend("黑默丁格"));
		friends.add(new Friend("崔斯特"));
		friends.add(new Friend("墨菲特"));
		friends.add(new Friend("内瑟斯"));
		friends.add(new Friend("克格'莫"));
		friends.add(new Friend("易"));
		friends.add(new Friend("赵信"));
		friends.add(new Friend("奈德丽"));
		friends.add(new Friend("阿利斯塔"));
		friends.add(new Friend("拉莫斯"));
		friends.add(new Friend("厄加特"));
		friends.add(new Friend("慎"));
		friends.add(new Friend("瑞兹"));
		friends.add(new Friend("艾尼维亚"));
		friends.add(new Friend("卡特琳娜"));
		friends.add(new Friend("乌迪尔"));
		friends.add(new Friend("赛恩"));
		friends.add(new Friend("萨科"));
		friends.add(new Friend("乐芙兰"));
		friends.add(new Friend("魔腾"));
	}

}
