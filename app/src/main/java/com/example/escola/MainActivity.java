package com.example.escola;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.escola.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void Calcular(View view) {


        boolean ok = true;


        if (binding.edtM1.getText().toString().trim().isEmpty()) {
            ok = false;
            binding.edtM1.setError(getString(R.string.msgError));
        }

        if (binding.edtM2.getText().toString().trim().isEmpty()) {
            ok = false;
            binding.edtM2.setError(getString(R.string.msgError));
        }

        if (ok) {
            float n1 = Float.parseFloat(binding.edtM1.getText().toString());
            float n2 = Float.parseFloat(binding.edtM2.getText().toString());
            float m = (n1 + n2) / 2;

            binding.txtMedia.setText(String.format("%.1f", m));

            if (m < 4) {
                binding.txtSit.setText(getString(R.string.strSitRep));
                binding.txtSit.setTextColor(Color.parseColor("#FF0000"));
                Toast.makeText(getApplicationContext(), getString(R.string.strMsgRep), Toast.LENGTH_SHORT).show();
                binding.imgSit.setImageResource(R.drawable.emojireprovado);
            } else if (m < 6) {
                binding.txtSit.setText(getString(R.string.strSitRec));
                binding.txtSit.setTextColor(Color.GREEN);
                Toast.makeText(getApplicationContext(), getString(R.string.strMsgRec), Toast.LENGTH_SHORT).show();
                binding.imgSit.setImageResource(R.drawable.emojirecuperacao);
            } else {
                binding.txtSit.setText(getString(R.string.strSitAp));
                binding.txtSit.setTextColor(getResources().getColor(R.color.azul));
                Toast.makeText(getApplicationContext(), getString(R.string.strMsgAp), Toast.LENGTH_SHORT).show();
                binding.imgSit.setImageResource(R.drawable.emojiaprovado);
            }
        }


    }
}