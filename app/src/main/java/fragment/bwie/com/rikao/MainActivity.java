package fragment.bwie.com.rikao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginView{


    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.pwd)
    EditText pwd;
    @Bind(R.id.denglu)
    Button denglu;
    private LoginPresenter process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        process = new LoginPresenter(this);
    }

    @OnClick(R.id.denglu)
    public void onClick() {
        process.login(name.getText().toString(),pwd.getText().toString());
    }

    @Override
    public void nameEmpty() {
        Toast.makeText(MainActivity.this,"name is empty" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pwdExpty() {
        Toast.makeText(MainActivity.this,"pwd is empty" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSurress(Object object) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,"loginSurress" , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void loginFailed(int code) {
        Toast.makeText(MainActivity.this,"loginFailed" , Toast.LENGTH_SHORT).show();
    }
}
