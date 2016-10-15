package id.sch.smktelkom_mlg.tugas01.xiirpl2007.rentalmobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText etNama, etNomor;
    Button bOk;
    RadioGroup rgStatus;
    CheckBox cbS, cbB, cbA;
    Spinner spMM;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etNomor = (EditText) findViewById(R.id.editTextNomor);
        bOk = (Button) findViewById(R.id.buttonOk);

        cbS = (CheckBox) findViewById(R.id.cbSupir);
        cbB = (CheckBox) findViewById(R.id.cbBBM);
        cbA = (CheckBox) findViewById(R.id.cbAir);

        spMM = (Spinner) findViewById(R.id.spinnerMerk);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doProses();
                doClick();
            }
        });
    }

    private void doClick()
    {
        String hasil = null;
        String nama = etNama.getText().toString();
        String nomor = etNomor.getText().toString();
        String fas = "\n";

        int startlen = fas.length();
        if (cbS.isChecked()) fas+=cbS.getText()+"\n";
        if (cbB.isChecked()) fas+=cbB.getText()+"\n";
        if (cbA.isChecked()) fas+=cbA.getText()+"\n";

        if (fas.length()==startlen) fas+="Kosong";

        if (rgStatus.getCheckedRadioButtonId() != -1)
        {
            RadioButton rb = (RadioButton)
                    findViewById(rgStatus.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (hasil == null)
        {
            tvHasil.setText("Anda belum mengisi");
        }
        else
        {
            tvHasil.setText("Nama Anda : " + nama + "\nNomor Anda : " + nomor + "\nStatus Anda : " + hasil + "\nFasilitas Anda :" + fas + " Merek Mobil : " + spMM.getSelectedItem().toString());
        }


    }

    private void doProses()
    {
        String nama = etNama.getText().toString();
        String nomor= etNomor.getText().toString();

        rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);

        tvHasil.setText(nama);
    }
}

