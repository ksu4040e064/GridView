package tw.com.ksu4040e064.gridview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        GridView gvMember = (GridView) findViewById(R.id.gvMember);
        gvMember.setAdapter(new MemberAdapter(this));
        gvMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Member member = (Member) parent.getItemAtPosition(position);
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(member.getImage());
                Toast toast = new Toast(MainActivity.this);
                toast.setView(imageView);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private class MemberAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<Member> memberList;

        public MemberAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);

            memberList = new ArrayList<>();
            memberList.add(new Member(23, R.drawable.b01, "皮卡丘"));
            memberList.add(new Member(75, R.drawable.b02, "米老鼠"));
            memberList.add(new Member(65, R.drawable.b03, "黑熊"));
            memberList.add(new Member(12, R.drawable.b04, "大力水手"));
            memberList.add(new Member(92, R.drawable.b05, "派大星"));
            memberList.add(new Member(103, R.drawable.b06, "Hello Kitty"));
            memberList.add(new Member(45, R.drawable.b07, "孫悟空"));
            memberList.add(new Member(78, R.drawable.b08, "多拉a夢"));
            memberList.add(new Member(234, R.drawable.b09, "黑崎一護"));
            memberList.add(new Member(35, R.drawable.b10, "喜洋洋"));
            memberList.add(new Member(57, R.drawable.b11, "喬巴"));
            memberList.add(new Member(61, R.drawable.b12, "老鼠"));
        }

        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Object getItem(int position) {
            return memberList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return memberList.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.gridview_item, parent, false);
            }

            Member member = memberList.get(position);
            ImageView ivImage = (ImageView) convertView
                    .findViewById(R.id.ivImage);
            ivImage.setImageResource(member.getImage());

            TextView tvId = (TextView) convertView
                    .findViewById(R.id.tvId);
            tvId.setText(Integer.toString(member.getId()));

            TextView tvName = (TextView) convertView
                    .findViewById(R.id.tvName);
            tvName.setText(member.getName());
            return convertView;
        }
    }
}
