package com.aaa.fire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aaa.fire.R;
import com.aaa.fire.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference database;
    EditText et_user_name, et_user_email, et_user_id;
    Button btn_save, btn_read;
    TextView read_data;
    int i = 1; //userId값 count하기 위한 변수
    ListView listView;
    TextView text1, text2;

    ArrayList<User> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_user_name = findViewById(R.id.et_user_name);
        et_user_email = findViewById(R.id.et_user_email);
        et_user_id = findViewById(R.id.et_user_id);
        btn_save = findViewById(R.id.btn_save);
        btn_read = findViewById(R.id.btn_read);
        read_data = findViewById(R.id.read_data);
        read_data = findViewById(R.id.read_data);
        listView = findViewById(R.id.listView);

        database = FirebaseDatabase.getInstance().getReference("users");
        Log.d("파이어베이스>> ", database + " ");

        //db에서 가지고 오는 유저들의 목록을 넣을 공간
        arrayList = new ArrayList<>();

        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //유저들의 목록을 가지고 오는 메서드
                arrayList.clear();

                Log.d("파이어베이스>> ", "users아래의 자식들의 개수: " + snapshot.getChildrenCount());
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    //snapshot.getChildren() => users아래에 있는 user목록을 다 가지고 온다.
                    //DataSnapshot => for문으로 목록에 들어있는 user를 한명씩 꺼내줌.
                    //user의 값들을 가지고와서, User vo에 넣는다.
                    //getValue(User.class) => 해당하는 멤버변수과 동일한 set메서드를 자동을 부른다.
                    User user = snapshot1.getValue(User.class);
                    arrayList.add(user);
                    Log.d("파이어베이스>> ", "user 1명: " + user);
                }
                i = arrayList.size();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = et_user_name.getText().toString();
                String email = et_user_email.getText().toString();
                i++;

                User user = new User(userName, email);

                database.child(String.valueOf(i)).setValue(user)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "저장을 완료했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "저장을 실패했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });


        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userId = et_user_id.getText().toString();

                database.child(userId).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User user = snapshot.getValue(User.class);
                        Log.d("파이어베이스>> ", userId + ": userId 상세정보: " + user);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.d("파이어베이스>> ", userId + ": userId 없음");
                    }
                });
            }
        });
    } //onCreate
}//class
