package com.example.along.ui1project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by Long on 2016/10/20.
 */
public class PersonalInfo extends Activity {
    TextView info_back_arrow,//个人信息返回箭头
            user_nick_name,//用户昵称
            head_portrait_next_arrow,//头像箭头
            nick_name_next_arrow,//昵称后的箭头
            user_sex,//用户性别
            user_sex_next_arrow,//性别后的箭头
            personalized_edit_signature,//个人签名
            personalized_edit_signature_next_arrow;//个人签名后的箭头
    ImageView info_head_portrait;//用户头像
    LayoutInflater layoutInflater;//转换器
    AlertDialog cameraDialog;//更换头像弹
    //更换用户头像
    LinearLayout info_head_change,
            sexual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_personal);
        layoutInflater = LayoutInflater.from(this);//视图转换器
        info_back_arrow = (TextView) findViewById(R.id.info_back_arrow);//个人信息返回箭头
        user_nick_name = (TextView) findViewById(R.id.user_nick_name);//用户昵称
        head_portrait_next_arrow = (TextView) findViewById(R.id.head_portrait_next_arrow);//头像箭头
        nick_name_next_arrow = (TextView) findViewById(R.id.nick_name_next_arrow);//昵称后的箭头
        user_sex = (TextView) findViewById(R.id.user_sex);//用户性别
        sexual= (LinearLayout) findViewById(R.id.sexual);
        user_sex_next_arrow = (TextView) findViewById(R.id.user_sex_next_arrow);//性别后的箭头
        personalized_edit_signature = (TextView) findViewById(R.id.personalized_edit_signature);//个人签名
        personalized_edit_signature_next_arrow = (TextView) findViewById(R.id.personalized_edit_signature_next_arrow);//个人签名后的箭头
        info_head_portrait = (ImageView) findViewById(R.id.info_head_portrait);//用户头像
        info_head_change = (LinearLayout) findViewById(R.id.info_head_change);//更换用户头像

        info_head_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHeadPortraitWindow();
            }
        });
        sexual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChangeSexualWindow();
            }
        });
    }

    //设置屏幕背景透明度
    public void backGroundAlpha(float alpha) {
        WindowManager.LayoutParams l = this.getWindow().getAttributes();
        l.alpha = alpha;
        getWindow().setAttributes(l);
    }

    //创建选择头像弹出框
    public void setHeadPortraitWindow() {
        View view = layoutInflater.inflate(R.layout.chang_head_protrait, null);
        cameraDialog = new AlertDialog.Builder(PersonalInfo.this).create();
        TextView camera = (TextView) view.findViewById(R.id.head_camera);//拍照获取头像
        TextView headChangeCancel = (TextView) view.findViewById(R.id.head_cancel);//取消更换头像
        TextView fromPhotoAlbum = (TextView) view.findViewById(R.id.from_photo_album);//从手机相册里选择头像图片

        //设置拍照 启用摄像头/待编辑
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //设置取消更换头像
        headChangeCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraDialog.dismiss();
            }
        });
        //从相册里选择头像图片/待编辑
        fromPhotoAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cameraDialog.setContentView(view);
        cameraDialog.setCanceledOnTouchOutside(true);
        cameraDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                backGroundAlpha((float) 1);
            }
        });
    }

    //更换性别
    public void setChangeSexualWindow() {
        View view = layoutInflater.inflate(R.layout.change_sexual_window, null);
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(personalized_edit_signature);
    }
}
