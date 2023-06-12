package com.example.individual1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.individual1.databinding.ActivityMainBinding;
import com.example.individual1.databinding.FragmentBlankBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private WebView web;



    private FragmentBlankBinding binding;
    private MainActivity mainActivity;
    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        WebView webView = binding.webView1; // Obtiene la instancia de WebView usando View Binding
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        // Configura la configuración del WebView
        webView.getSettings().setJavaScriptEnabled(true); // Habilita JavaScript si es necesario
        webView.setWebViewClient(new WebViewClient()); // Configura un WebViewClient para cargar el contenido dentro del WebView



        // Obtiene la URL desde MainActivity
        String url = mParam1.trim();

        // Carga la URL en el WebView
        webView.loadUrl(url);
        return view;
    }
}