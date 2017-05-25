package com.example.han.smartlocktowifi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.han.smartlocktowifi.interfaces.ConnectionResultListener;
import com.example.han.smartlocktowifi.interfaces.WifiStateListener;

public class MainActivity extends Activity {

    private PopupWindow mPopupWindow;
    private View popupView;
    private ImageView place_home;
    private ImageView place_office;
    private ImageView place_school;
    private int tmp_image;
    private EditText ed;
    private TextView tv_tmp;
    private ImageButton ib_tmp;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        place_home = (ImageView) findViewById(R.id.place_setting1);
        place_office = (ImageView) findViewById(R.id.place_setting2);
        place_school = (ImageView) findViewById(R.id.place_setting3);

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

//    public void wifi_setting_onclick(View v) {
//        popupView = getLayoutInflater().inflate(R.layout.place_popup_window, null);
//        mPopupWindow = new PopupWindow(popupView,
//                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        mPopupWindow.setAnimationStyle(1);
//        mPopupWindow.setFocusable(true);
//        mPopupWindow.setTouchable(true);
//        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
//
//        switch (v.getId()) {
//            case R.id.place_setting1:
//                tmp_image = 1;
//                break;
//            case R.id.place_setting2:
//                tmp_image = 2;
//                break;
//            case R.id.place_setting3:
//                tmp_image = 3;
//                break;
//            case R.id.txtv1:
//                tmp_image = 1;
//                break;
//            case R.id.txtv2:
//                tmp_image = 2;
//                break;
//            case R.id.txtv3:
//                tmp_image = 3;
//                break;
//            default:
//                break;
//        }
//    }
//
//    public void wifi_setting_image(View v) {
//
//        switch (v.getId()) {
//            case R.id.home:
//                if (tmp_image == 1) {
//                    tv_tmp = (TextView) findViewById(R.id.txtv1);
//                    tv_tmp.setVisibility(View.GONE);
//                    place_home.setImageResource(R.drawable.home);
//                    place_home.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else if (tmp_image == 2) {
//                    tv_tmp = (TextView) findViewById(R.id.txtv2);
//                    tv_tmp.setVisibility(View.GONE);
//                    place_office.setImageResource(R.drawable.home);
//                    place_office.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else if (tmp_image == 3) {
//                    tv_tmp = (TextView) findViewById(R.id.txtv3);
//                    tv_tmp.setVisibility(View.GONE);
//                    place_school.setImageResource(R.drawable.home);
//                    place_school.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else
//                    break;
//
//            case R.id.office:
//
//                if (tmp_image == 1) {
//                    tv_tmp = (TextView) findViewById(R.id.txtv1);
//                    tv_tmp.setVisibility(View.GONE);
//                    place_home.setImageResource(R.drawable.office);
//                    place_home.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else if (tmp_image == 2) {
//                    tv_tmp = (TextView) findViewById(R.id.txtv2);
//                    tv_tmp.setVisibility(View.GONE);
//                    place_office.setImageResource(R.drawable.office);
//                    place_office.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else if (tmp_image == 3) {
//                    tv_tmp = (TextView) findViewById(R.id.txtv3);
//                    tv_tmp.setVisibility(View.GONE);
//                    place_school.setImageResource(R.drawable.office);
//                    place_school.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else
//                    break;
//            case R.id.school:
//
//                if (tmp_image == 1) {
//                    tv_tmp = (TextView) findViewById(R.id.txtv1);
//                    tv_tmp.setVisibility(View.GONE);
//                    place_home.setImageResource(R.drawable.school);
//                    place_home.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else if (tmp_image == 2) {
//                    tv_tmp = (TextView) findViewById(R.id.txtv2);
//                    tv_tmp.setVisibility(View.GONE);
//                    place_office.setImageResource(R.drawable.school);
//                    place_office.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else if (tmp_image == 3) {
//                    tv_tmp = (TextView) findViewById(R.id.txtv3);
//                    tv_tmp.setVisibility(View.GONE);
//                    place_school.setImageResource(R.drawable.school);
//                    place_school.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else
//                    break;
//
//            case R.id.image_to_text:
//
//                if (tmp_image == 1) {
//                    ib_tmp = (ImageButton) findViewById(R.id.place_setting1);
//                    ib_tmp.setVisibility(View.GONE);
//                    TextView tv1 = (TextView) findViewById(R.id.txtv1);
//                    ed = (EditText) popupView.findViewById(R.id.image_to_textedit);
//                    String str = ed.getText().toString();
//                    tv1.setText(str);
//                    tv1.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else if (tmp_image == 2) {
//                    ib_tmp = (ImageButton) findViewById(R.id.place_setting2);
//                    ib_tmp.setVisibility(View.GONE);
//                    TextView tv2 = (TextView) findViewById(R.id.txtv2);
//                    ed = (EditText) popupView.findViewById(R.id.image_to_textedit);
//                    String str = ed.getText().toString();
//                    tv2.setText(str);
//                    tv2.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else if (tmp_image == 3) {
//                    ib_tmp = (ImageButton) findViewById(R.id.place_setting3);
//                    ib_tmp.setVisibility(View.GONE);
//                    TextView tv3 = (TextView) findViewById(R.id.txtv3);
//                    ed = (EditText) popupView.findViewById(R.id.image_to_textedit);
//                    String str = ed.getText().toString();
//                    tv3.setText(str);
//                    tv3.setVisibility(View.VISIBLE);
//                    mPopupWindow.dismiss();
//                    break;
//                } else
//                    mPopupWindow.dismiss();
//                break;
//
//            default:
//                break;
//        }
//    }


    public void wifi_setting(View v){

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifiConn = networkInfo.isConnected();
        Toast.makeText(getApplicationContext(), "클릭된 팝업 메뉴" + networkInfo, Toast.LENGTH_SHORT).show();

        if(!isWifiConn){
            // First initializate a WifiConnector object
            WifiConnector connector = new WifiConnector(this, "NEW_SSID", "NEW_BSSID", "WEP", "wifiPassword");
            connector.setWifiStateListener(new WifiStateListener() {
                @Override
                public void onStateChange(int wifiState) {

                }

                @Override
                public void onWifiEnabled() {
                    // here you should be start your network operations
                }

                @Override
                public void onWifiEnabling() {

                }

                @Override
                public void onWifiDisabling() {

                }

                @Override
                public void onWifiDisabled() {

                }
            });

            // For connecting to specific wifi network, third parameter (new_bssid) could be null
            connector.connectToWifi(new ConnectionResultListener() {
                @Override
                public void successfulConnect(String SSID) {
                    // toast!
                }

                @Override
                public void errorConnect(int codeReason) {
                    // toast!
                }

                @Override
                public void onStateChange(SupplicantState supplicantState) {
                    // update UI!
                }
            });

            // And do not forget to unregister your wifi state listener on the onStop() or onDestroy() method
            connector.unregisterWifiStateListener();
        }
        else{

        }

    }


}
