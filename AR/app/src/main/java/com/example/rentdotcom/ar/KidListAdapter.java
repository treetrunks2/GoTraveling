package com.example.rentdotcom.ar;
/**
 * Created by sookmyung on 2017-10-10.
 */
import java.text.DateFormat;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public final class KidListAdapter extends ArrayAdapter<KidEntry> {
    private final int kidItemLayoutResource;

    private static class ViewHolder {
        public TextView textview_name;
        public TextView subTitleView;
        public ImageView imageView;
    }

    public KidListAdapter(final Context context, final int kidItemLayoutResource) {
        super(context, 0);
        this.kidItemLayoutResource = kidItemLayoutResource;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final View view = getWorkingView(convertView);
        final ViewHolder viewHolder = getViewHolder(view);
        final KidEntry entry = getItem(position);

        // Setting the title view is straightforward
        viewHolder.textview_name.setText(entry.getName());

        // Setting the subTitle view requires a tiny bit of formatting
        final String formattedSubTitle = String.format("By %s on %s",
                entry.getParents(),
                DateFormat.getDateInstance(DateFormat.SHORT).format(entry.getBirthDate())
        );

        viewHolder.subTitleView.setText(formattedSubTitle);

        // Setting image view is also simple
        viewHolder.imageView.setImageResource(entry.getIcon());

        return view;
    }

    private View getWorkingView(final View convertView) {
        // The workingView is basically just the convertView re-used if possible
        // or inflated new if not possible
        View workingView = null;

        if(null == convertView) {
            final Context context = getContext();
            final LayoutInflater inflater = (LayoutInflater)context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);

            workingView = inflater.inflate(kidItemLayoutResource, null);
        } else {
            workingView = convertView;
        }

        return workingView;
    }

    private ViewHolder getViewHolder(final View workingView) {
        // The viewHolder allows us to avoid re-looking up view references
        // Since views are recycled, these references will never change
        final Object tag = workingView.getTag();
        ViewHolder viewHolder = null;


        if(null == tag || !(tag instanceof ViewHolder)) {
            viewHolder = new ViewHolder();

            viewHolder.textview_name = (TextView) workingView.findViewById(R.id.news_entry_title);
            viewHolder.subTitleView = (TextView) workingView.findViewById(R.id.news_entry_subtitle);
            viewHolder.imageView = (ImageView) workingView.findViewById(R.id.news_entry_icon);

            workingView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) tag;
        }

        return viewHolder;
    }

    /**
     * ViewHolder allows us to avoid re-looking up view references
     * Since views are recycled, these references will never change
     */
}
