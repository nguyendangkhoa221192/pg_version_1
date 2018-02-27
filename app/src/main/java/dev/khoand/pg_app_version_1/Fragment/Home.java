package dev.khoand.pg_app_version_1.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.khoand.pg_app_version_1.Adapter.AdapterMenuGridView;
import dev.khoand.pg_app_version_1.R;


public class Home extends Fragment {

    public Home() {
        // Required empty public constructor
    }

    @BindView(R.id.home_menu_major) GridView gr_menu_major;
    @BindView(R.id.home_menu_report) GridView gr_menu_report;

    private int[] icon_menu_major = {
            R.mipmap.mic_checkin,
            R.mipmap.mic_sell,
            R.mipmap.mic_checkout,
            R.mipmap.mic_location
    };
    private int[] icon_menu_report = {
            R.mipmap.mic_productivity,
            R.mipmap.mic_order_detail,
            R.mipmap.mic_report
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);

        String[] text_menu_major = getActivity().getResources().getStringArray(R.array.major_buttons_text);
        String[] text_menu_report = getActivity().getResources().getStringArray(R.array.report_buttons_text);

        AdapterMenuGridView adapterMenuGridView = new AdapterMenuGridView(getActivity(), text_menu_major, icon_menu_major);
        gr_menu_major.setAdapter(adapterMenuGridView);

        adapterMenuGridView = new AdapterMenuGridView(getActivity(), text_menu_report, icon_menu_report);
        gr_menu_report.setAdapter(adapterMenuGridView);

        gr_menu_major.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                handleEventClickMajor(i);
            }
        });

        gr_menu_report.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                handleEventClickReport(i);
            }
        });

        return root;
    }

    private void handleEventClickMajor(int i) {
        if (i < icon_menu_major.length) {
            switch (i) {
                case 0:
                    Toast.makeText(getActivity(), "aaa", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(getActivity(), "bbb", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getActivity(), "ccc", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(getActivity(), "ddd", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private void handleEventClickReport(int i) {
        if (i < icon_menu_major.length) {
            switch (i) {
                case 0:
                    Toast.makeText(getActivity(), "aaa", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(getActivity(), "bbb", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getActivity(), "ccc", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}
