package com.example.slidingdrawer;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
  
/** 
 * @author yangyu 
 *  功能描述：列表Fragment，用来显示列表视图 
 */  
public class SampleListFragment extends ListFragment {  
	
	SlidingMenu menu;
	public SampleListFragment(SlidingMenu menu) {
		// TODO Auto-generated constructor stub
		super();
		this.menu = menu;
	}
  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
        return inflater.inflate(R.layout.list, null);  
    }  
  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        SampleAdapter adapter = new SampleAdapter(getActivity());  
        for (int i = 0; i < 20; i++) {  
            adapter.add(new SampleItem("Sample List", android.R.drawable.ic_menu_search));  
        }  
        this.getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				closeWindow();
				System.out.println("hehehhehehehehehh");
			}
		});
        setListAdapter(adapter);  
    }  
    
    public void closeWindow()
    {
    	this.menu.showContent();
    }
  
    private class SampleItem {  
        public String tag;  
        public int iconRes;  
        public SampleItem(String tag, int iconRes) {  
            this.tag = tag;   
            this.iconRes = iconRes;  
        }  
    }
    
  
    public class SampleAdapter extends ArrayAdapter<SampleItem> {  
  
        public SampleAdapter(Context context) {  
            super(context, 0);  
        }  
  
        public View getView(int position, View convertView, ViewGroup parent) {  
            if (convertView == null) {  
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);  
            }  
            ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);  
            icon.setImageResource(getItem(position).iconRes);  
            TextView title = (TextView) convertView.findViewById(R.id.row_title);  
            title.setText(getItem(position).tag);  
  
            return convertView;  
        }  
  
    }  
}  