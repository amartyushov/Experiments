package mart.io.timetracker;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class TimeTrackerAdapter extends BaseAdapter {
    private List<TimeRecord> list = new ArrayList<>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.time_record_view, parent, false);
        }

        TimeRecord time = list.get(position);
        TextView timeTextView = (TextView) convertView.findViewById(R.id.time_view);
        timeTextView.setText(time.getTime());

        TextView noteTextView = (TextView) convertView.findViewById(R.id.note_view);
        noteTextView.setText(time.getNote());

        return convertView;
    }
}
