package com.example.myapplication.ui.home;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private MainActivity MainActivity;
    final Context context = MainActivity;
    String amount_of_dialog;
    private TextView final_text;
    View root;
    Button[] b;
    TextView[] t;
    Button[] b_p;
    Button[] p;
    TextView[] t_p;
    Double sum = 0.0;
    String[] tags = {"t1","t2","t3","t4","t5","t6","t7","t8","t9","t10","t11","t12","t13","t14","t15","t16",};
    String[] tags_p = {"t_p1","t_p2","t_p3","t_p4","t_p5","t_p6","t_p7","t_p8","t_p9","t_p10","t_p11","t_p12","t_p13","t_p14","t_p15","t_p16",};
    SharedPreferences sPref;
    Integer num_of_bat ;
    Integer num_of_bat_p ;
    LinearLayout ll;
    ImageButton button;
    ImageButton button_p;
    Boolean trigger = true;


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_balans);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });

        final TextView balans = (TextView) root.findViewById(R.id.text_balans);
        balans.setText(loadData("sum"));
        sum = Double.parseDouble(String.valueOf(balans.getText()));
        Button b_profit = (Button) root.findViewById(R.id.profit);
        Button b_consum = (Button) root.findViewById(R.id.consum);
        b_p = new Button[]{(Button)root.findViewById(R.id.b_1),(Button)root.findViewById(R.id.b_2),(Button)root.findViewById(R.id.b_3),
                (Button)root.findViewById(R.id.b_4),(Button)root.findViewById(R.id.b_5),(Button)root.findViewById(R.id.b_6),
                (Button)root.findViewById(R.id.b_7),(Button)root.findViewById(R.id.b_8),(Button)root.findViewById(R.id.b_9),
                (Button)root.findViewById(R.id.b_10),(Button)root.findViewById(R.id.b_11),(Button)root.findViewById(R.id.b_12),
                (Button)root.findViewById(R.id.b_13),(Button)root.findViewById(R.id.b_14),(Button)root.findViewById(R.id.b_15),
                (Button)root.findViewById(R.id.b_16)};
        t_p = new TextView[]{(TextView) root.findViewById(R.id.t_1),(TextView) root.findViewById(R.id.t_2),(TextView) root.findViewById(R.id.t_3),
                (TextView)root.findViewById(R.id.t_4),(TextView)root.findViewById(R.id.t_5),(TextView)root.findViewById(R.id.t_6),
                (TextView)root.findViewById(R.id.t_7),(TextView)root.findViewById(R.id.t_8),(TextView)root.findViewById(R.id.t_9),
                (TextView)root.findViewById(R.id.t_10),(TextView)root.findViewById(R.id.t_11),(TextView)root.findViewById(R.id.t_12),
                (TextView)root.findViewById(R.id.t_13),(TextView)root.findViewById(R.id.t_14),(TextView)root.findViewById(R.id.t_15),
                (TextView)root.findViewById(R.id.t_16)};
        b = new Button[]{(Button)root.findViewById(R.id.b2_1),(Button)root.findViewById(R.id.b2_2),(Button)root.findViewById(R.id.b2_3),
                (Button)root.findViewById(R.id.b2_4),(Button)root.findViewById(R.id.b2_5),(Button)root.findViewById(R.id.b2_6),
                (Button)root.findViewById(R.id.b2_7),(Button)root.findViewById(R.id.b2_8),(Button)root.findViewById(R.id.b2_9),
                (Button)root.findViewById(R.id.b2_10),(Button)root.findViewById(R.id.b2_11),(Button)root.findViewById(R.id.b2_12),
                (Button)root.findViewById(R.id.b2_13),(Button)root.findViewById(R.id.b2_14),(Button)root.findViewById(R.id.b2_15),
                (Button)root.findViewById(R.id.b2_16)};
        t = new TextView[]{(TextView) root.findViewById(R.id.t2_1),(TextView) root.findViewById(R.id.t2_2),(TextView) root.findViewById(R.id.t2_3),
                (TextView)root.findViewById(R.id.t2_4),(TextView)root.findViewById(R.id.t2_5),(TextView)root.findViewById(R.id.t2_6),
                (TextView)root.findViewById(R.id.t2_7),(TextView)root.findViewById(R.id.t2_8),(TextView)root.findViewById(R.id.t2_9),
                (TextView)root.findViewById(R.id.t2_10),(TextView)root.findViewById(R.id.t2_11),(TextView)root.findViewById(R.id.t2_12),
                (TextView)root.findViewById(R.id.t2_13),(TextView)root.findViewById(R.id.t2_14),(TextView)root.findViewById(R.id.t2_15),
                (TextView)root.findViewById(R.id.t2_16)};
        p = new Button[]{(Button)root.findViewById(R.id.p_1),(Button)root.findViewById(R.id.p_2),(Button)root.findViewById(R.id.p_3),
                (Button)root.findViewById(R.id.p_4),(Button)root.findViewById(R.id.p_5),(Button)root.findViewById(R.id.p_6),
                (Button)root.findViewById(R.id.p_7),(Button)root.findViewById(R.id.p_8),(Button)root.findViewById(R.id.p_9),
                (Button)root.findViewById(R.id.p_10),(Button)root.findViewById(R.id.p_11),(Button)root.findViewById(R.id.p_12),
                (Button)root.findViewById(R.id.p_13),(Button)root.findViewById(R.id.p_14),(Button)root.findViewById(R.id.p_15),
                (Button)root.findViewById(R.id.p_16)};
        num_of_bat = Integer.parseInt(loadData("num_of_but"));
        num_of_bat_p = Integer.parseInt(loadData("num_of_but_p"));
        consum(b,b_p,t,t_p);


        b_profit.setOnClickListener(new OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View v) {
                profit(b,b_p,t,t_p);
                root.setBackgroundColor(R.color.profit_color);
            }
        });
        b_consum.setOnClickListener(new OnClickListener() {
            @SuppressLint("ResourceAsColor")
            public void onClick(View v) {
                consum(b,b_p,t,t_p);
                root.setBackgroundColor(R.color.consum_color);
            }
        });


for (int i=0; i<16;i++) {
    t[i].setText( loadData(tags[i]));
    t_p[i].setText( loadData(tags_p[i]));
    final int finalI = i;
    b[i].setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            View inquiryView = inflater.inflate(R.layout.inquiry, null);

            AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(getActivity());

            mDialogBuilder.setView(inquiryView);

            final EditText userInput = (EditText) inquiryView.findViewById(R.id.amount);

            final String str = String.valueOf(t[finalI].getText());
            mDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    t[finalI].setText(userInput.getText());
                                    Float a = Float.valueOf(String.valueOf(t[finalI].getText())) + Float.valueOf(str);
                                    t[finalI].setText(String.valueOf(a));
                                    sum = sum - a;
                                    balans.setText(String.valueOf(sum));
                                    saveData(sum.toString(),"sum");
                                    saveData(a.toString(), tags[finalI]);
                                }

                            })
                    .setNegativeButton("Отмена",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });


            AlertDialog alertDialog = mDialogBuilder.create();

            alertDialog.show();


        }
    });

    b_p[i].setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            View inquiryView = inflater.inflate(R.layout.inquiry, null);

            AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(getActivity());

            mDialogBuilder.setView(inquiryView);

            final EditText userInput = (EditText) inquiryView.findViewById(R.id.amount);

            final String str = String.valueOf(t[finalI].getText());
            mDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    t_p[finalI].setText(userInput.getText());
                                    Float a = Float.valueOf(String.valueOf(t_p[finalI].getText())) + Float.valueOf(str);
                                    t_p[finalI].setText(String.valueOf(a));
                                    sum = sum + a;
                                    balans.setText(String.valueOf(sum));
                                    saveData(sum.toString(),"sum");
                                    saveData(a.toString(), tags_p[finalI]);

                                }

                            })
                    .setNegativeButton("Отмена",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });


            AlertDialog alertDialog = mDialogBuilder.create();

            alertDialog.show();


        }
    });
    p[i].setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {

                    View inquiryView = inflater.inflate(R.layout.add_categorie, null);

                    AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(getActivity());

                    mDialogBuilder.setView(inquiryView);

                    final EditText userInput = (EditText) inquiryView.findViewById(R.id.amount);

                    final String str = String.valueOf(t[finalI].getText());
                    mDialogBuilder
                            .setCancelable(false)
                            .setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            t[finalI].setText(userInput.getText());
                                            Float a = Float.valueOf(String.valueOf(t[finalI].getText())) + Float.valueOf(str);
                                            t[finalI].setText(String.valueOf(a));
                                            sum = sum - a;
                                            balans.setText(String.valueOf(sum));
                                            saveData(sum.toString(),"sum");
                                            saveData(a.toString(), tags[finalI]);
                                        }

                                    })
                            .setNegativeButton("Отмена",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });


                    AlertDialog alertDialog = mDialogBuilder.create();

                    alertDialog.show();



            if (trigger) {
                b[num_of_bat].setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_foreground));
                b[num_of_bat].setVisibility(View.VISIBLE);
                t[num_of_bat].setVisibility(View.VISIBLE);
                b[num_of_bat].setClickable(true);
                p[num_of_bat].setClickable(false);
                p[num_of_bat].setVisibility(View.INVISIBLE);
                if (num_of_bat <= 15) {
                    num_of_bat++;
                    saveData(String.valueOf(num_of_bat), "num_of_but");
                    p[num_of_bat].setVisibility(View.VISIBLE);
                    p[num_of_bat].setClickable(true);

                }
            } else {
                    b_p[num_of_bat_p].setVisibility(View.VISIBLE);
                    t_p[num_of_bat_p].setVisibility(View.VISIBLE);
                    b_p[num_of_bat_p].setClickable(true);
                    p[num_of_bat_p].setClickable(false);
                    p[num_of_bat_p].setVisibility(View.INVISIBLE);
                    Log.d("","расходы +");
                    if (num_of_bat_p <= 15) {
                            num_of_bat_p++;
                            saveData(String.valueOf(num_of_bat), "num_of_but_p");
                            p[num_of_bat_p].setVisibility(View.VISIBLE);
                            p[num_of_bat_p].setClickable(true);
                    }
                }
            }

        }
    );

}


        return root;
    }
    private void saveData(String transaction, String value) {
        sPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(value, transaction);
        ed.commit();

    }

    private String loadData(String value){
        sPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        String result = sPref.getString(value, "0");
        return result;
    }

    void consum(final Button[] b, Button[] b_p, final TextView[]t, TextView[] t_p){
        trigger = true;
        for (int l = 0; l <16; l++){
            b_p[l].setVisibility(View.INVISIBLE);
            b_p[l].setClickable(false);
            p[l].setClickable(false);
            t_p[l].setVisibility(View.INVISIBLE);
            p[l].setVisibility(View.INVISIBLE);
            b[l].setVisibility(View.INVISIBLE);
            t[l].setVisibility(View.INVISIBLE);
            b[l].setClickable(false);

        }
        p[num_of_bat].setVisibility(View.VISIBLE);
        p[num_of_bat].setClickable(true);
        for (int j =0; j < num_of_bat; j++)
        {
            b[j].setVisibility(View.VISIBLE);
            t[j].setVisibility(View.VISIBLE);
            b[j].setClickable(true);
        }

    }

    void profit(final Button[] b, final Button[] b_p, final TextView[]t, final TextView[] t_p){
        trigger = false;
        for (int l = 0; l <16; l++){
            b_p[l].setVisibility(View.INVISIBLE);
            b_p[l].setClickable(false);
            t_p[l].setVisibility(View.INVISIBLE);
            b[l].setVisibility(View.INVISIBLE);
            t[l].setVisibility(View.INVISIBLE);
            b[l].setClickable(false);
            p[l].setClickable(false);
            p[l].setVisibility(View.INVISIBLE);
        }
        p[num_of_bat_p].setVisibility(View.VISIBLE);
        p[num_of_bat_p].setClickable(true);

        for (int j =0; j < num_of_bat_p; j++)
        {
            b_p[j].setVisibility(View.VISIBLE);
            t_p[j].setVisibility(View.VISIBLE);
            b_p[j].setClickable(true);
        }
    }


    /*void Creat_Button(int x, int y, final Button[] b, final TextView[] t, final int n, int tr)
    {
        final ImageButton button = new ImageButton(getActivity());
        ll.addView(button);
        button.setLeft(x);
        button.setTop(y);
        button.setImageResource(R.drawable.ic_app_button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                b[n].setVisibility(View.VISIBLE);
                t[n].setVisibility(View.VISIBLE);
                b[n].setClickable(true);

                button.setLeft(50);
                button.setTop(50);

            }
        }
        );
    }*/

}