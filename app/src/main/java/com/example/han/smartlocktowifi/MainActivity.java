package com.example.han.smartlocktowifi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private PopupWindow mPopupWindow;
    private View popupView;
    private ImageButton btn_Popup1;
    private ImageButton btn_Popup2;
    private ImageButton btn_Popup3;
    private int tmp_image;
    private EditText ed;
    private TextView tv_tmp;
    private ImageButton ib_tmp;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Popup1 = (ImageButton) findViewById(R.id.place_setting1);
        btn_Popup2 = (ImageButton) findViewById(R.id.place_setting2);
        btn_Popup3 = (ImageButton) findViewById(R.id.place_setting3);

    }


    public void menu_open(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.getMenuInflater().inflate(R.menu.setting_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_setting:
                                intent = new Intent(MainActivity.this, SettingsActivity.class);
                                startActivity(intent);
                                break;
                            case R.id.menu_help:

                                break;
                            case R.id.menu_info:
                                intent = new Intent(MainActivity.this, InfomationActivity.class);
                                startActivity(intent);
                                break;
                        }
                        Toast.makeText(getApplicationContext(), "클릭된 팝업 메뉴" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
        popup.show();
    }

    public void wifi_setting_onclick(View v) {
        popupView = getLayoutInflater().inflate(R.layout.place_popup_window, null);
        mPopupWindow = new PopupWindow(popupView,
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setAnimationStyle(1);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        switch (v.getId()) {
            case R.id.place_setting1:
                tmp_image = 1;
                break;
            case R.id.place_setting2:
                tmp_image = 2;
                break;
            case R.id.place_setting3:
                tmp_image = 3;
                break;
            case R.id.txtv1:
                tmp_image = 1;
                break;
            case R.id.txtv2:
                tmp_image = 2;
                break;
            case R.id.txtv3:
                tmp_image = 3;
                break;
            default:
                break;
        }
    }

    public void wifi_setting_image(View v) {

        switch (v.getId()) {
            case R.id.home:
                if (tmp_image == 1) {
                    tv_tmp = (TextView) findViewById(R.id.txtv1);
                    tv_tmp.setVisibility(View.GONE);
                    btn_Popup1.setImageResource(R.drawable.home);
                    btn_Popup1.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else if (tmp_image == 2) {
                    tv_tmp = (TextView) findViewById(R.id.txtv2);
                    tv_tmp.setVisibility(View.GONE);
                    btn_Popup2.setImageResource(R.drawable.home);
                    btn_Popup2.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else if (tmp_image == 3) {
                    tv_tmp = (TextView) findViewById(R.id.txtv3);
                    tv_tmp.setVisibility(View.GONE);
                    btn_Popup3.setImageResource(R.drawable.home);
                    btn_Popup3.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else
                    break;

            case R.id.office:

                if (tmp_image == 1) {
                    tv_tmp = (TextView) findViewById(R.id.txtv1);
                    tv_tmp.setVisibility(View.GONE);
                    btn_Popup1.setImageResource(R.drawable.office);
                    btn_Popup1.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else if (tmp_image == 2) {
                    tv_tmp = (TextView) findViewById(R.id.txtv2);
                    tv_tmp.setVisibility(View.GONE);
                    btn_Popup2.setImageResource(R.drawable.office);
                    btn_Popup2.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else if (tmp_image == 3) {
                    tv_tmp = (TextView) findViewById(R.id.txtv3);
                    tv_tmp.setVisibility(View.GONE);
                    btn_Popup3.setImageResource(R.drawable.office);
                    btn_Popup3.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else
                    break;
            case R.id.school:

                if (tmp_image == 1) {
                    tv_tmp = (TextView) findViewById(R.id.txtv1);
                    tv_tmp.setVisibility(View.GONE);
                    btn_Popup1.setImageResource(R.drawable.school);
                    btn_Popup1.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else if (tmp_image == 2) {
                    tv_tmp = (TextView) findViewById(R.id.txtv2);
                    tv_tmp.setVisibility(View.GONE);
                    btn_Popup2.setImageResource(R.drawable.school);
                    btn_Popup2.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else if (tmp_image == 3) {
                    tv_tmp = (TextView) findViewById(R.id.txtv3);
                    tv_tmp.setVisibility(View.GONE);
                    btn_Popup3.setImageResource(R.drawable.school);
                    btn_Popup3.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else
                    break;

            case R.id.image_to_text:

                if (tmp_image == 1) {
                    ib_tmp = (ImageButton) findViewById(R.id.place_setting1);
                    ib_tmp.setVisibility(View.GONE);
                    TextView tv1 = (TextView) findViewById(R.id.txtv1);
                    ed = (EditText) popupView.findViewById(R.id.image_to_textedit);
                    String str = ed.getText().toString();
                    tv1.setText(str);
                    btn_Popup1.setVisibility(View.GONE);
                    tv1.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else if (tmp_image == 2) {
                    ib_tmp = (ImageButton) findViewById(R.id.place_setting2);
                    ib_tmp.setVisibility(View.GONE);
                    TextView tv2 = (TextView) findViewById(R.id.txtv2);
                    ed = (EditText) popupView.findViewById(R.id.image_to_textedit);
                    String str = ed.getText().toString();
                    tv2.setText(str);
                    btn_Popup1.setVisibility(View.GONE);
                    tv2.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else if (tmp_image == 3) {
                    ib_tmp = (ImageButton) findViewById(R.id.place_setting3);
                    ib_tmp.setVisibility(View.GONE);
                    TextView tv3 = (TextView) findViewById(R.id.txtv3);
                    ed = (EditText) popupView.findViewById(R.id.image_to_textedit);
                    String str = ed.getText().toString();
                    tv3.setText(str);
                    btn_Popup1.setVisibility(View.GONE);
                    tv3.setVisibility(View.VISIBLE);
                    mPopupWindow.dismiss();
                    break;
                } else
                    mPopupWindow.dismiss();
                break;

            default:
                break;
        }
    }

}
