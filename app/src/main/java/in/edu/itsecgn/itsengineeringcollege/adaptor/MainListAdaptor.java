package in.edu.itsecgn.itsengineeringcollege.adaptor;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import in.edu.itsecgn.itsengineeringcollege.R;
import in.edu.itsecgn.itsengineeringcollege.activities.AnnualCalenderActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.BusRouteActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.EDActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.ExtraCurricularActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.HODActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.HostelRulesActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.MentorActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.NewsAndEventsActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.NoticeAndAnnouncementsActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.OrientationScheduleActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.SportsActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.StudentHandbook;
import in.edu.itsecgn.itsengineeringcollege.activities.SyllabusActivity;
import in.edu.itsecgn.itsengineeringcollege.activities.TimeTableActivity;
import in.edu.itsecgn.itsengineeringcollege.constants.MyConstants;
import in.edu.itsecgn.itsengineeringcollege.model.MainList;

public class MainListAdaptor extends RecyclerView.Adapter<MainListAdaptor.MyViewHolder> {

    private Context ctx;
    private List<MainList> mainLists;

    public MainListAdaptor(Context ctx, List<MainList> mainLists) {
        this.ctx = ctx;
        this.mainLists = mainLists;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(ctx).inflate(R.layout.item_main_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.titleTextView.setText(mainLists.get(position).getName());
        Glide.with(ctx)
                .load(setImageIcon(position))
                .thumbnail(0.5f)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                        return false;
                    }
                })
                .into(holder.itemImageView);
    }

    @Override
    public int getItemCount() {
        return mainLists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImageView;
        TextView titleTextView;
        CardView cardView;

        MyViewHolder(View itemView) {
            super(itemView);
            itemImageView = (ImageView) itemView.findViewById(R.id.image_view_main_item);
            titleTextView = (TextView) itemView.findViewById(R.id.text_view_title);
            cardView = itemView.findViewById(R.id.card_view_show_card);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int mPosition = getLayoutPosition();
                    checkPosition(mPosition);
                }
            });
        }



    }

    private void checkPosition(int mPosition) {
        switch (mainLists.get(mPosition).getId()) {
            case 2:
                switch (mPosition) {
                    case 0:
                        setIntent(EDActivity.class);
                        break;
                    case 1:
                        setIntent(HODActivity.class);
                        break;
                    case 2:
                        setIntent(MentorActivity.class);
                        break;
                }
                break;
            case 3:
                switch (mPosition) {
                    case 0:
                        setIntent(OrientationScheduleActivity.class);
                        break;
                    case 1:
                        setIntent(StudentHandbook.class);
                        break;
                    case 2:
                        setIntent(TimeTableActivity.class);
                        break;
                    case 3:
                        setIntent(SyllabusActivity.class);
                        break;
                    case 4:
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(MyConstants.ACADEMIC_CALENDER));
                        ctx.startActivity(i);
                        break;
                }
                break;
            case 4:
                switch (mPosition) {
                    case 0:
                        setIntent(AnnualCalenderActivity.class);
                        break;
                    case 1:
                        setIntent(BusRouteActivity.class);
                        break;
                    case 2:
                        setIntent(SportsActivity.class);
                        break;
                    case 3:
                        setIntent(HostelRulesActivity.class);
                        break;

                }
                break;
            case 5:
                switch (mPosition) {
                    case 0:
                        setIntent(ExtraCurricularActivity.class);
                        break;
                    case 1:
                        setIntent(NewsAndEventsActivity.class);
                        break;
                    case 2:
                        setIntent(NoticeAndAnnouncementsActivity.class);
                        break;

                }
                break;
        }
    }

    private String setImageIcon(int mPosition) {
        String s = mainLists.get(mPosition).getName();
        if (s.equals("ED")) {
            return MyConstants.ED_ADAPTOR_IMAGE;
        } else if (s.equals("HOD")) {
            return MyConstants.HOD_ADAPTOR_IMAGE;
        } else if (s.equals("Mentor")) {
            return MyConstants.MENTOR_ADAPTOR_IMAGE;
        } else if (s.equals("Orientation Schedule")) {
            return MyConstants.ORIENTATION_ADAPTOR_IMAGE;
        } else if (s.equals("Student Handbook")) {
            return MyConstants.HANDBOOK_ADAPTOR_IMAGE;
        } else if (s.equals("Time Table")) {
            return MyConstants.TIME_TABLE_ADAPTOR_IMAGE;
        } else if (s.equals("BTech/MBA Syllabus")) {
            return MyConstants.SYLLABUS_ADAPTOR_IMAGE;
        } else if (s.equals("Academic Calender")) {
            return MyConstants.ACADEMIC_CALENDER_ADAPTOR_IMAGE;
        } else if (s.equals("Annual Calender")) {
            return MyConstants.ANNUAL_CALENDER_ADAPTOR_IMAGE;
        } else if (s.equals("Bus Route")) {
            return MyConstants.BUS_ROUTE_ADAPTOR_IMAGE;
        } else if (s.equals("Sports")) {
            return MyConstants.SPORTS_ADAPTOR_IMAGE;
        } else if (s.equals("Hostel Rules")) {
            return MyConstants.HOSTEL_RULES_ADAPTOR_IMAGE;
        } else if (s.equals("Social Media")) {
            return MyConstants.SOCIAL_ADAPTOR_IMAGE;
        } else if (s.equals("Extra Curricular Activities")) {
            return MyConstants.EXTRA_CURRICULAR_ADAPTOR_IMAGE;
        } else if (s.equals("News Events")) {
            return MyConstants.NEWS_EVENTS_ADAPTOR_IMAGE;
        } else if (s.equals("Notice and announcements")) {
            return MyConstants.NOTICE_ADAPTOR_IMAGE;
        }
        return MyConstants.LOGIN_IN_REQUIRED_LINK;
    }

    private void setIntent(Class<?> cls) {
        ctx.startActivity(new Intent(ctx, cls));
    }
}
